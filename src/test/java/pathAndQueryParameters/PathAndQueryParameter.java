package pathAndQueryParameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameter 
{
//	 https://reqres.in/api/users?page=2&id=5
//	 https://reqres.in called domain it will 1st reach to the server
//	 wherever there is / or .in/.com/.org this is called domain
//	 api is a path 
//	 users is also path
//	 page=2  after ? what ever is there called query parameter
	
	@Test
	void testQueryAndPathParameters()
	{
		given()
			.pathParam("maypath", "users") // Correct path parameter name and value
			.queryParam("page", 2)
			.queryParam("id", 5)  //what ever info we pass here that will get it from server
			
		.when()
			.get("https://reqres.in/api/{maypath}") // Correct the URL and use the path parameter 
			//only query para we have to write inside the { } , query para goes along with path oara
			//along with request we have to pass parameter , no need to add further url the query para goes along with request    
			
		.then()
			.statusCode(200)
			.log().all();
	}
}

//path para we have define our variable
//page id exactly shown present on page
