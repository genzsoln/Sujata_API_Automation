package differentWayTCreatePostMethod;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostUsingPOJOClass 
{
	// post request body creation using POJO class (plain old java object)
	// some time key having multiple value(one array contains single value)
	//here we use encapsulation concept
	//wrapping of variables and methods into one single class
	//here we use getter & setter methods (to generate/create data)

	    @Test(priority=1)
	    void PostUsingPOJOClass() 
	    {
	    	Pojo_PostRequest data=new Pojo_PostRequest();
	    	
	    	data.setName("Scott");
	    	data.setLocation("France");
	    	data.setPhone("123456");
	    	
	        String coursesArr[] = {"C", "C++"};
	        data.setCources(coursesArr);  //set data into the variables
	        
	        //data.put("courses",coursesArr);  

	        given()
	            .contentType("application/json")
	            .body(data) //pass the data
	            
	        .when()
	            .post("http://localhost:3000/Student")
	        
	        .then()
	            .statusCode(201)
	            .body("name", equalTo("Scott"))
	            .body("location", equalTo("France"))
	            .body("phone", equalTo("123456"))
	            .body("cources[0]", equalTo("C")) // Corrected the JSON path to "courses"
	            .body("cources[1]", equalTo("C++")) // Corrected the JSON path to "courses"
	            .header("Content-Type", "application/json; charset=utf-8")
	            .log().all();
	    }
	    
	    //DELETE METHOD
	    
	    @Test(priority=2)
	    void testDelete()
	    {
	    	given()
	    	
	    	.when()
	    		.delete("http://localhost:3000/Student/11")
	    	
	    	.then()
	    		.statusCode(200)
	    		.log().all();
	    }
}
