package XMLResponse;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class ParsingXMLResponseInVariable 
{
    @Test
    void testXMLResponse()
    {
        //approach_2
    	//validating json response by using xmlpath method
        
        Response res = given()
        
        .when()
            .get("http://restapi.adequateshop.com/api/Traveler?page=1");
        
        	Assert.assertEquals(res.getStatusCode(), 200); // Status code validation
        	Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
        	
        	String pageNo=res.xmlPath().get("TravelerinformationResponse.page").toString();
            Assert.assertEquals(pageNo,"1");
            
            String travelName=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
            Assert.assertEquals(travelName,"Developer");
    }
}