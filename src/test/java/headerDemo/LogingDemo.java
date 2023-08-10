package headerDemo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;

public class LogingDemo 
{
	// we can use this log method along with then methos there are many sub methods inside the log
	
	@Test
	void testLogs()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/userd?page=2")
			
		.then()
			//.log().all(); //if you want all response /info	
			//.log().body(); //if you want specific body info
			//.log().cookies(); //if you want to print only cookies
			.log().headers(); //print only headers
	}
}
