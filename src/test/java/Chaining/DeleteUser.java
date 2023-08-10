package Chaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class DeleteUser 
{
	@Test
	void get_DeleteUser(ITestContext context)
	{
		String barerToken = "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";
        
        //int id=(Integer) context.getAttribute("user_id");
		int id=(Integer) context.getSuite().getAttribute("user_id"); // test level var //this should come from create user class

		given()
        	.headers("Authorization", "Bearer " + barerToken)
        	.pathParam("id", id)

		.when()
        	.delete("https://gorest.co.in/public/v2/users/{id}")

		.then()
			.statusCode(204)
			.log().all();
		
	}
}
