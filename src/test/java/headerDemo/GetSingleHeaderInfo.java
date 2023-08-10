package headerDemo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import io.restassured.response.Response;

public class GetSingleHeaderInfo
{
	@Test
	void getHeaders()
	{
		//capture response in variable no need to write then
		
		Response res= given()
		
		.when()
			.get("https://www.google.com/");
			 
			// get/capture single info from headers
			String header_value=res.getHeader("Content-Type");
			System.out.println("The value of Content-Type"+header_value);
	}
}
