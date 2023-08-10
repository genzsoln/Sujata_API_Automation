package differentWayTCreatePostMethod;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONTokener;

public class PostUsingExternalJsonFile 
{
	// what ever data you want to send along with post request just past it inside Body.json file
	//suppose i have data in my external file so i can use that data for post request
	//
	
	@Test(priority=1)
	void PostUsingExternalJson() throws FileNotFoundException
    {
    	//to get the data from external file first we have to open the file
		
		File f=new File(".\\body.json"); //also we have to specify location of the file
								// here dot is representing current location of file
		
		//ways to set location of your file
//		File f1=new File(System.getProperty("user.dir"));
//		File f2=new File("C:\\Users\\Admin\\Desktop\\Workspace\\Java Program\\RestAssuredMethods\\Body.json"); //right click on your file select properties & select location
		
		//to read the data we have 2 classes filereader &json tokener 
		
		//read data from file
		FileReader fr=new FileReader(f); //f is passing here to open the file
		
		//we have to split that file into different token
		JSONTokener jt=new JSONTokener(fr); 
		
		//we have to extract data in json object format
		JSONObject data=new JSONObject(jt); //this will throw exception we have to add it
		
        given()
            .contentType("application/json")
            .body(data.toString()) //we are taking data from external json file
            
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
    		.delete("http://localhost:3000/Student/14")
    	
    	.then()
    		.statusCode(200)
    		.log().all();
    }
}
