package ValidateSchemaResponseForJsonAndXml;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.given;

public class XMLSchemaValidation 
{
//	https://easycodeforall.com/XMLTOXSDSUBMIT
//     https://www.convertsimple.com/convert-xml-to-xsd-xml-schema/
    
    @Test
    void xmlschemaValidation()
    {
        given()
        
        .when()
            .get("http://restapi.adequateshop.com/api/Traveler")
            
        .then()
            .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("traveller.xsd"));
    }
}