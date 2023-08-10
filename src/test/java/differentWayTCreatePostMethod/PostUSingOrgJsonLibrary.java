package differentWayTCreatePostMethod;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;

public class PostUSingOrgJsonLibrary 
{
	// post request body creation using Org.Json library
	// for this e have to add one dependencies i.e json library
    // some time key having multiple value(one array contains single value)

    @Test(priority=1)
    void PostUsingOrgJsonLib() 
    {
    	JSONObject data=new JSONObject();
    	
        data.put("name", "Scott");
        data.put("location", "France");
        data.put("phone", "123456");

        String courseArr[] = {"C", "C++"};
        data.put("courses", courseArr); // Corrected key name from "cources" to "courses"

        given()
            .contentType("application/json")
            
            .body(data.toString()) // we can not pass data directly inside the body we have to convert that dat into string format
            // above entire data convert into string format
            // then after converting it will be send data in json format
            
        .when()
            .post("http://localhost:3000/Student")
        
        .then()
            .statusCode(201)
            .body("name", equalTo("Scott"))
            .body("location", equalTo("France"))
            .body("phone", equalTo("123456"))
            .body("courses[0]", equalTo("C")) // Corrected the JSON path to "courses"
            .body("courses[1]", equalTo("C++")) // Corrected the JSON path to "courses"
            .header("Content-Type", "application/json; charset=utf-8")
            .log().all();
    }
    
    //DELETE METHOD
    
    @Test(priority=2)
    void testDelete()
    {
    	given()
    	
    	.when()
    		.delete("http://localhost:3000/Student/12")
    	
    	.then()
    		.statusCode(200)
    		.log().all();
    }
}
