package Chaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetUser 
{
    @Test
    void test_getUser(ITestContext context)
    {
        int id = (Integer) context.getSuite().getAttribute("user_id");
        String barerToken = "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";

        given()
            .headers("Authorization", "Bearer " + barerToken)
            .pathParam("id", id)
        .when()
            .get("https://gorest.co.in/public/v2/users/{id}")
        .then()
            .statusCode(200)
            .log().all();
    }
}