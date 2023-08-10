package Authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class APIKeyAuthentication 
{
	//https://openweathermap.org/api
	//click on Call 16 day / daily forecast data
	//we need to sign in
	
	@Test
	void testBearedTokenAuthentication()
	{
		//Method - 1
//		given()
//			.queryParam("appid", "")//appid is api key
//			//api key is pass as part of query parameter
//			
//		.when()
//			.get("URL") 
//			
//		.then()
//			.statusCode(200)
//			.log().all();
		
		//Method - 2
		given()
			.queryParam("appid", "") //we have to pass qpi key as paramenter
			.pathParam("mypath", "")
			.pathParam("q", "Delhi")
			.pathParam("units", "metric")
			.pathParam("cnt", "7")	
			
		.when()
			.get("https://api.openweathermap.org/(mypath)") //specify only domain here
		
		.then()
			.statusCode(200)
			.log().all();
	}
}

//dev know about how to generate qpi key and authentication
//dev will guid us accordingly