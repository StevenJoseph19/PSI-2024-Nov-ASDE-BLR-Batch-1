package org.acme.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;
import org.bson.Document;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    public static void main(String[] args) {
        // Disable MongoDB log output
        Logger mongoDriverLogger = Logger.getLogger("org.mongodb.driver");
        mongoDriverLogger.setLevel(Level.OFF); // Disable logs for MongoDB driver

        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
            MongoDatabase database = mongoClient.getDatabase("mongojava");
            MongoCollection<Document> collection = database.getCollection("users");

            // Drop the collection if it exists
            collection.drop();
            System.out.println("Dropped 'users' collection if it existed.");

            // Perform CRUD operations
            performInsert(collection);
            performFind(collection);
            // Find users with the department "IT" and sort them by name in ascending order
            findAndSortByInfoField(collection, "department", "IT", "name", true);
            performUpdate(collection);
            // Delete the user with ID 3
            int userIdToDelete = 3;
            performDelete(collection, userIdToDelete);

            System.out.println("MongoDB is running. Press Ctrl+C to stop...");
            Thread.sleep(Long.MAX_VALUE); // Keep the application running indefinitely
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Application terminated.");
        }
    }

    static void performInsert(MongoCollection<Document> collection) {
        List<User> users = ExampleData.getUsers(); // Get the list of users from ExampleData

        for (User user : users) {
            Document doc = new Document("_id", user.getId())
                    .append("name", user.getName())
                    .append("role", user.getRole())
                    .append("isEmployee", user.isEmployee())
                    .append("tags", user.getTags()) // Add the tags list (if not null)
                    .append("info", user.getInfo()); // Add the info map (if not null);

            collection.insertOne(doc);
            System.out.println("Inserted User: " + doc.toJson());
        }
    }

    static Document performFind(MongoCollection<Document> collection) {
        Document query = new Document("_id", 1);
        return collection.find(query).first(); // Return the found user or null
    }

    static Document findAndSortByInfoField(MongoCollection<Document> collection, String infoKey, Object infoValue, String sortField, boolean ascending) {
        Document query = new Document("info." + infoKey, infoValue);
        Document sortCriteria = new Document(sortField, ascending ? 1 : -1);

        Document foundDocument = collection.find(query).sort(sortCriteria).first();

        if (foundDocument != null) {
            System.out.println("Found and Sorted Document: " + foundDocument.toJson());
        } else {
            System.out.println("No matching document found.");
        }

        return foundDocument;
    }

    static Document performUpdate(MongoCollection<Document> collection) {
        Document query = new Document("_id", 1);
        Document updatedUser = new Document("$set", new Document("name", "Updated User"));

        collection.updateOne(query, updatedUser);

        // Log the update operation
        System.out.println("Updated user with ID 1 to name: Updated User");

        // Return the updated user to allow verification
        return collection.find(query).first();
    }

    static String createNameIndex(MongoCollection<Document> collection) {
        try {
            // Create an index on the "info.name" field, assuming "name" is a key within the "info" map
            collection.createIndex(Indexes.ascending("name"));
            return "Index created on 'info.name' field.";
        } catch (Exception e) {
            // In case of failure, return error message
            return "Failed to create index: " + e.getMessage();
        }
    }

    static Document performDelete(MongoCollection<Document> collection, int userId) {
        Document query = new Document("_id", userId);
        Document deletedUser = collection.findOneAndDelete(query);

        if (deletedUser != null) {
            System.out.println("Deleted User: " + deletedUser.toJson());
        } else {
            System.out.println("User with ID " + userId + " not found.");
        }

        return deletedUser;
    }

}