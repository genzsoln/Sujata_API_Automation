package ValidateSchemaResponseForJsonAndXml;

import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.given;

public class JSONSchemaValidation {
    @Test
    void jsonSchemaValidation() {
        given()
            .when()
                .get("http://localhost:3000/book")
            .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("bookjsonSchema.json"));
    }
}


//response validation - we validate data in response 
//schema validataion - we will focuse on the type of data
//once we get the response from that response  we have to create
// a schema then we have to compare the response is according to schema or not
// what ever response we capture from the request that response is data is schema type
// 1st we have to convert json to jsonschema "https://transform.tools/json-to-json-schema"
// we have to create 1 file for json schema and store it inside src/main/resource
//have to store response in variable , then capture it & have to compre it