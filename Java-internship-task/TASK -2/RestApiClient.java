/*
---------------------------------------------------------
CODTECH INTERNSHIP - TASK 2
REST API CLIENT USING JAVA

TASK:
Create a Java application that:
1. Connects to a public REST API
2. Sends HTTP requests
3. Receives JSON response
4. Parses and displays structured data

API USED:
https://api.agify.io

This API predicts age based on a person's name.

Example:
Input  : Rahul
Output : Predicted Age = 25

---------------------------------------------------------
AUTHOR : SHAIK BABA SHAREEF
LANGUAGE : JAVA
---------------------------------------------------------
*/

// Import required libraries
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RestApiClient {

    public static void main(String[] args) {

        // Scanner object for user input
        Scanner sc = new Scanner(System.in);

        try {

            // Ask user to enter a name
            System.out.print("Enter a name: ");
            String name = sc.nextLine();

            // REST API URL
            String apiUrl = "https://api.agify.io/?name=" + name;

            // Create URL object
            URL url = new URL(apiUrl);

            // Open connection
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Get response code
            int responseCode = connection.getResponseCode();

            // Check whether request is successful
            if (responseCode == 200) {

                // Read API response
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream())
                );

                String inputLine;
                StringBuilder response = new StringBuilder();

                // Read response line by line
                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }

                // Close reader
                reader.close();

                // Convert response into String
                String jsonResponse = response.toString();

                // Display raw JSON response
                System.out.println("\nRAW JSON RESPONSE:");
                System.out.println(jsonResponse);

                // -------------------------------------------------
                // SIMPLE JSON PARSING
                // -------------------------------------------------

                // Extract "name" value
                String extractedName =
                        jsonResponse.split("\"name\":\"")[1]
                                .split("\"")[0];

                // Extract "age" value
                String extractedAge =
                        jsonResponse.split("\"age\":")[1]
                                .split(",")[0];

                // Extract "count" value
                String extractedCount =
                        jsonResponse.split("\"count\":")[1]
                                .replace("}", "");

                // -------------------------------------------------
                // DISPLAY STRUCTURED DATA
                // -------------------------------------------------

                System.out.println("\n===== STRUCTURED DATA =====");
                System.out.println("Name            : " + extractedName);
                System.out.println("Predicted Age   : " + extractedAge);
                System.out.println("Prediction Count: " + extractedCount);
                System.out.println("============================");

            } else {

                // If API request fails
                System.out.println("HTTP Request Failed");
                System.out.println("Response Code: " + responseCode);
            }

            // Disconnect connection
            connection.disconnect();

        } catch (Exception e) {

            // Handle exceptions
            System.out.println("Error occurred while accessing API.");
            e.printStackTrace();
        }

        // Close scanner
        sc.close();
    }
}