package org.acme.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MongoServiceTest {

    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    @BeforeAll
    public static void setup() {
        // Connect to MongoDB and initialize the database/collection
        mongoClient = MongoClients.create("mongodb://localhost:27017"); // Adjust the port if necessary
        database = mongoClient.getDatabase("mongojava");
        collection = database.getCollection("users");

        // Drop the collection before each test
        collection.drop();
        System.out.println("Dropped 'users' collection if it existed.");

        // Insert the necessary products for testing
        // Insert initial data if the collection is empty
        if (collection.countDocuments() == 0) {
            Application.performInsert(collection); // Insert data for testing
        }
    }

    @AfterAll
    public static void tearDown() {

        // Drop the collection again in case it's not cleaned up
        if (collection != null) {
            collection.drop();
        }

        // Close the MongoClient and stop the embedded MongoDB process
        if (mongoClient != null) {
            mongoClient.close();
        }


    }

    @Test
    public void testPerformFind() {
        Document foundUser = Application.performFind(collection);
        assertNotNull(foundUser);
        assertEquals("John Doe", foundUser.getString("name"));
        assertEquals("Customer", foundUser.getString("role"));
    }

    @Test
    public void testFindAndSortByInfoField() {
        Document sortedUser = Application.findAndSortByInfoField(collection, "department", "IT", "name", true);
        assertNotNull(sortedUser);
        assertEquals("Jane Smith", sortedUser.getString("name"));
    }

    @Test
    public void testPerformUpdate() {
        // Check if the document with _id = 1 exists
        Document existingDocument = collection.find(new Document("_id", 1)).first();
        if (existingDocument == null) {
            // Insert a new document if it doesn't exist
            Document newDocument = new Document("_id", 1)
                    .append("name", "Original Name")
                    .append("role", "Original Role");
            collection.insertOne(newDocument);
        }

        // Perform the update
        Document updatedUser = Application.performUpdate(collection);

        // Verify the updated document
        assertNotNull(updatedUser);
        assertEquals("Updated User", updatedUser.getString("name"));
    }

    @Test
    public void testPerformDelete() {
        Application.performDelete(collection, 1);
        Document deletedUser = collection.find(new Document("_id", 1)).first();
        assertNull(deletedUser);
    }

    // Add more tests as needed to cover different scenarios and edge cases
}