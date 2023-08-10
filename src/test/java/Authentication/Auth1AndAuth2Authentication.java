package Authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class Auth1AndAuth2Authentication 
{
	//for auth1 authentication we have to pass multiple parameter
	//for auth2 neeed to pass access token
	
	//@Test(priority=1)
	void testAuth0Auth1Authentication()
	{		
		//dev will give u info how to generate Auth1 authentication
		given()
			.auth().oauth("consumerKey", "consumerSecrat", "accestoken", "tokenSecrate") // for auth1.0 //these details required to generate auth1 authentication
			
		.when()
			.get("")
			
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	@Test(priority=2)
	void testAuth2Authentication()
	{		
		//auth authentication we have only one paramenter i.e token
		//it will reduce no of para
		
		given()
			.auth().oauth2("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") //these details required to generate auth1 authentication
			
		.when()
			.get("https://api.github.com/user/repos")
			
		.then()
			.statusCode(200)
			.log().all();
	}
}

