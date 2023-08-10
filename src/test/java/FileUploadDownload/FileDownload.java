package FileUploadDownload;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.File;

public class FileDownload 
{
	@Test
	void fileDownload()
	{
        given()
            
       .when()
            .post("http://localhost:8080/downloadFile/File2.txt")
        
        .then()
            .statusCode(200)
            .log().all();
	}
}
