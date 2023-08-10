package Authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import static io.restassured.matcher.RestAssuredMatchers.*;

// Bearer tokens in APIs are like special keys that allow you to securely access and do specific things
//with online services without revealing your full credentials.

public class BearedTokenAuthentication 
{
	//we need to create our own authenticaion / toke
	@Test
	void testBearedTokenAuthentication()
	{
		String bearerToken="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"; //to save the token
		
		given()
			//.headers("Authorization","Bearer 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")
			//OR
			.headers("Authorization","Bearer "+bearerToken)
			
		.when()
			.get("https://api.github.com/user/repos") //it will shows all repo which is present inside your account
			
		.then()
			.statusCode(200)
			.log().all();
	}
}
