package com.acme.ajax;
//The URL represents the API endpoint (https://jsonplaceholder.typicode.com/posts in this case).
//        The HttpURLConnection object xhr is used to make the HTTP request.
//        The request method is set to POST, and the request body is the JSON string
//        {"title": "foo", "body": "bar", "userId": 1}.
//        setDoOutput(true) is called to allow writing to the connection output stream.
//        The response is read using InputStreamReader and printed to the console.
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HandlingAjaxRequests {

    public static void main(String[] args) {
        try {
            // URL for the API endpoint
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");

            // Open connection
            HttpURLConnection xhr = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            xhr.setRequestMethod("POST");

            // Set the request headers
            xhr.setRequestProperty("Content-Type", "application/json");

            // Enable input/output streams
            xhr.setDoOutput(true);
            xhr.setDoInput(true);

            // JSON payload to send in the POST request
            String jsonInputString = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";

            // Send the request
            try (OutputStream os = xhr.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length); // Write the data
            }

            // Get the response code
            int status = xhr.getResponseCode();
            System.out.println("HTTP Response Code: " + status);

            // Handle the response
            try (BufferedReader br = new BufferedReader(new InputStreamReader(xhr.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response: " + response.toString()); // Log response
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle any I/O exceptions
        }
    }
}

