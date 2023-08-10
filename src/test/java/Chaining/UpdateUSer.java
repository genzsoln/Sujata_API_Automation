package Chaining;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class UpdateUSer 
{
	@Test
	void test_UpdateUser(ITestContext context)
	{
		Faker faker = new Faker();
        
        JSONObject data = new JSONObject(); // for creating data
        
        // create json data
        data.put("name", faker.name().fullName());
        data.put("gender", "Male");
        data.put("email", faker.internet().emailAddress());
        data.put("status", "active");
        
        String barerToken = "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";
        // we pass bearer token along with header
        
        //int id=(Integer) context.getAttribute("user_id");
		int id=(Integer) context.getSuite().getAttribute("user_id"); // test level var //this should come from create user class

        given()
            .headers("Authorization", "Bearer " + barerToken)
            .contentType("application/json")
            .body(data.toString())
            .pathParam("id", id)
            
        .when()
            .put("https://gorest.co.in/public/v2/users/{id}")

        .then()
        	.statusCode(200)
        	.log().all();
	}
}
