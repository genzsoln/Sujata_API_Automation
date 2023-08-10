package headerDemo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;


public class BasicHeaderValidation 
{
	// some info of header keep changing not every field
	// server info , content encoding, content type, cache control, (info most of the time constant) will not change
	// date ehen it will expire, P#P info will be change
	// whatever details are constant we have to validate that "content type & content encoding most of the time we have to validate
	//& some time server name
		
	@Test
		void testHeader()
		{
			given()
			
			.when()
				.get("https://www.google.com/")
			
			.then()
				.header("Content-Type", "text/html; charset=ISO-8859-1")
				.and() //if you have multiple validation u can seperate them using and
				.header("Content-Encoding","gzip")
				.and()
				.header("Server", "gws")
				.log().headers(); // printed all the response
		}
}
