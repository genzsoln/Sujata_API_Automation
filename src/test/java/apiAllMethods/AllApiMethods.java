package apiAllMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class AllApiMethods 
{
	int id;
	
	@Test(priority=1)
	void getUser()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")  //dont put semocolon bcz all methods are inter-related
			
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
	}
	
	@Test(priority=2)
	void createUser()
	{
		HashMap data=new HashMap(); //obj
		data.put("name","Sujata");
		data.put("job","Engineer");
		
		id=given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("https://reqres.in/api/users")  //dont put semocolon bcz all methods are inter-related
			.jsonPath().getInt("id");
			
//		.then()
//			.statusCode(201)
//			.log().all();
	}		
	
	@Test(priority=3, dependsOnMethods={"createUser"})
	void updateUser()
	{
		HashMap data=new HashMap();
		data.put("name","Sujata");
		data.put("job","trainer");
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.put("https://reqres.in/api/users/"+id)  //dont put semocolon bcz all methods are inter-related
			
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority=4)
	void deleteUser()
	{
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)   //dont put semocolon bcz all methods are inter-related
			
		.then()
			.statusCode(204)
			.log().all();
	}
}