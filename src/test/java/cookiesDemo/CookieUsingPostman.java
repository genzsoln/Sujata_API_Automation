package cookiesDemo;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;
import org.json.JSONObject;

public class CookieUsingPostman 
{
	// suppose you want to capture data from header and cookies
		// cookies are dynamically changes, we can't expect exact value of the cookies everytime it's keep changing
		// whenever value keep changing means our functionality working fine
		// whenever u get data from server then new cookies will be generated
		
		@Test
		void testCookies()
		{
			given()
			
			.when()
				.get("https://www.google.com/")
			
			.then()
				.cookie("AEC","Ad49MVHS-e-V0uMoG3PBPg34OeeqhuMl9UFWodctNiEA12wkxaAJY0gmnQ0")
				.log().all(); // printed all the response
		}
}
