package cookiesDemo;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;
import org.json.JSONObject;

public class GetSingleCoockieInfoFromVariable 
{
	@Test
	void getCookiesInfo()
	{
		// if u want response in one var then no need to add then method
		
		Response res=given() // import pckg for this & once we get response it will stored in res variable ,
				//is having res body, header, cookies 
		
		.when()
			.get("https://www.google.com/");   //after this if u wat to do validation then dont put ; semicoln 
			//after this stmt there is no other method used so we have to close this by ; 
		//then only ore valur will be store inside the variable
		
			//get single cookies infor from res var
		
			String cookie_value=res.getCookie("AEC");  //we extract/capture only cookies here
			//it will return string type of data
			
			System.out.println("The value of coockie is ---"+cookie_value); //getting cookie info
	}
}
