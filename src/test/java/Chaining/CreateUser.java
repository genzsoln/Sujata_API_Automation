package Chaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;
import io.restassured.response.Response;

public class CreateUser 
{
    @Test
    void test_CreateUser(ITestContext context) 
    {
        Faker faker = new Faker();

        // Create JSON data using RestAssured's built-in JSON capabilities
        String requestBody = "{"
            + "\"name\": \"" + faker.name().fullName() + "\","
            + "\"gender\": \"Male\","
            + "\"email\": \"" + faker.internet().emailAddress() + "\","
            + "\"status\": \"inactive\""
            + "}";

        String bearerToken = "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";

        Response response = given()
            .headers("Authorization", "Bearer " + bearerToken)
            .contentType("application/json")
            .body(requestBody)
            
        .when()
            .post("https://gorest.co.in/public/v2/users");

        // Check response status code and handle errors
        int statusCode = response.getStatusCode();
        if (statusCode == 201) 
        {
            int id = response.jsonPath().getInt("data.id");
            System.out.println("Generated id is: " + id);

            context.getSuite().setAttribute("user_id", id);
        }
        
        else 
        {
            System.err.println("Error creating user. Status code: " + statusCode);
            System.err.println("Response body: " + response.getBody().asString());
        }
    }
}