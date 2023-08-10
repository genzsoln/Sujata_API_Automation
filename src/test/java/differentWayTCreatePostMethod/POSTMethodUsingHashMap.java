package differentWayTCreatePostMethod;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class POSTMethodUsingHashMap
{
    // post request body creation using hashmap
    // hash map is java collection we can store the data in the form of key & value
    // some time key having multiple value(one array contains single value)

    @Test(priority=1)
    void testPostUsingHashMap() 
    {
        HashMap data = new HashMap();
        data.put("name", "Scott");
        data.put("location", "France");
        data.put("phone", "123456");

        String courseArr[] = {"C", "C++"};

        data.put("courses", courseArr); // Corrected key name from "cources" to "courses"

        given()
            .contentType("application/json")
            .body(data)    // using hash map we directly pass data inside the body
            
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
    		.delete("http://localhost:3000/Student/10")
    	
    	.then()
    		.statusCode(200)
    		.log().all();
    }
}