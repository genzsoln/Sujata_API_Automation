package cookiesDemo;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;
import org.json.JSONObject;

public class GetCookiesKeyValue
{
	//print only cookies value
	
	@Test
	void getCookiesInfo()
	{
		// if u want response in one var then no need to add then method
		
		Response res=given() // import pckg for this & once we get response it will stored in res variable , is having res body, header, cookies 
		
		.when()
			.get("https://www.google.com/");   //after this if u wat to do validation then dont put ; semicoln after this stmt there is no other method used so we have to close this by ; then only ore valur will be store inside the variable
											   //get all cookies infor/value from res var
		
			Map<String,String> cookies_values=res.getCookies();  //hashmap we store data in key & value pair 
			
			System.out.println(cookies_values.keySet());// it will give only key values
	}
}
