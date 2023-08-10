package XMLResponse;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;

//import io.restassured.response.Response;
//import io.restassured.http.ContentType;
//import org.json.JSONObject;
//import static io.restassured.RestAssured.*;

//parsing means : what ever data we want we can extract it & compare it with our expected values

public class ParsingXMLResponse 
{
    @Test
    void testXMLResponse()
    {
    	given()
    	
        .when()
            .get("http://restapi.adequateshop.com/api/Traveler?page=1")
            
        .then()
            .statusCode(200)
            .header("Content-Type", "application/xml; charset=utf-8")
            .body("TravelerinformationResponse.page", equalTo("1"))
            .body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));
    }
}