package headerDemo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class GetAllHeadersInfo 
{
	@Test
	void getHeaders()
	{
		//capture response in variable no need to write then
		
		Response res= given()   //capture response in the variable
		
		.when()
			.get("https://www.google.com/");
			 
			// get/capture all info from headers
		
			Headers myheaders=res.getHeaders(); //using res capture we capture all info into myheaders variable
			for(Header hd:myheaders) // we can read each and every variable using hd
			{
				System.out.println(hd.getName()+"   "+hd.getValue());  //extract name & value of the header 
			}
	}
}


//when we simple write log().all all header info will be displayed no need to write big code
// most of the time this is not used
//also we can write log().headers() it will return only headers

