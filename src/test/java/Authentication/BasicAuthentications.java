package Authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class BasicAuthentications 
{
	//	Authentication  - we need to check user is valid or not
	// Authorization - user is valid but we need to check permission/access for that user  
	//restassured diff authentication supported
	//basic
	//digest
	//preempive
	//bearer token
	//auth 1.0, 2.0
	//API KEy
	
	@Test(priority=1)
	void testBasicAuthentication()
	{
		given()
			.auth().basic("postman", "password")
			
		.when()
			.get("https://postman-echo.com/basic-auth") //postman gove this url to support basic ,digest & preemptive auth
			//depends of which auth we choosen according to that alorithm for that auth willl be triggered
		
			.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	@Test(priority=2)
	void testDigestAuthentication()
	{
		given()
			.auth().digest("postman", "password")
			
		.when()
			.get("https://postman-echo.com/basic-auth")
			
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	@Test(priority=3)
	void testPreemptiveAuthentication()
	{
		given()
			.auth().preemptive().basic("postman", "password") //combination of 2 type of authentication
			
		.when()
			.get("https://postman-echo.com/basic-auth")
			
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
}
//above all 3 requires username & password but algoriths are different

//depends on customer reqirement developer have do some kind of api they will implement what kind of authentication is required for that api
//its depends on complexity of app
//suppose u r app is more sensitive and lots of security is required that time devloper go with auth 2 authentication
// auth 2 authentication is very very typical and no body can break that authentication
//bcz 1st we haveto creake a key based on that we create the token multiple things are there 
//some appilcation prefers basic digest authentication
// gmail yahoo we need to provide our gmail password 
// occording to customer requirement developer build authentication same kind of authentication we have to simulate to test the api







