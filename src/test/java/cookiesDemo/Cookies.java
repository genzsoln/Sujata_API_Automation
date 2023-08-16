package cookiesDemo;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;
import org.json.JSONObject;

public class Cookies 
{
//	 suppose you want to capture data from header and cookies
//	 cookies are dynamically changes, we can't expect exact value of the cookies everytime it's keep changing
//	 whenever value keep changing means our functionality working fine
//	 whenever u get data from server then new cookies will be generated
	
	//@Test(priority=1)
	void testCookies()
	{
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			.cookie("AEC","Ad49MVHS-e-V0uMoG3PBPg34OeeqhuMl9UFWodctNiEA12wkxaAJY0gmnQ0")
			.log().all(); // printed all the response
	}
	
	@Test(priority=2)
	void getCookiesInfo()
	{
		// if u want response in one var then no need to add then method
		
		Response res=given() // import pckg for this & once we get response it will stored in res variable , is having res body, header, cookies 
		
		.when()
			.get("https://www.google.com/");   //after this if u wat to do validation then dont put ; semicoln after this stmt there is no other method used so we have to close this by ; then only ore valur will be store inside the variable
		
			//get single cookies infor from res var
		
			//String cookie_value=res.getCookie("AEC");  //we extract/capture only cookies here
			//it will return string type of data
			
			//System.out.println("The value of coockie is ---"+cookie_value); //getting cookie info
			
			//get all cookies infor/value from res var
		
			Map<String,String> cookies_values=res.getCookies();
			//hashmap we store data in key & value pair 
			
			//System.out.println(cookies_values.keySet());// it will give only key values
			
			// if you want to read all the value from hashmap using loop stmt
			for(String k:cookies_values.keySet())
			{
				String cookies_value=res.getCookie(k);
				System.out.println(k+"        "+cookies_value); // cookie name along with value
			}
	}
}