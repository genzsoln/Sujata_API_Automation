package FileUploadDownload;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.File;

public class FileUpload 
{
	//@Test
	void singleFileUpload()
	{
		// Create a File object with the path to the file
       File myfile = new File("C:\\Users\\Admin\\Desktop\\Workspace\\API\\File.txt");

        // Use the File object in the request
        given()
            .multiPart("file", myfile) // Upload the file using the "multiPart" method
            .contentType("multipart/form-data") //to specify form-data we have 1 method multipart pass key and value
            
       .when()
            .post("http://localhost:8080/uploadFile")
        
        .then()
            .statusCode(200)
            .body("fileName", equalTo("File.txt"))
            .log().all();
	}
	
	@Test
	void multipleFileUpload()
	{
		// Create a File object with the path to the file
       File myfile1 = new File("C:\\Users\\Admin\\Desktop\\Workspace\\API\\File1.txt");
       File myfile2 = new File("C:\\Users\\Admin\\Desktop\\Workspace\\API\\File2.txt");

       File filearr[]= {myfile1,myfile2}; //another way to write the file
       
        // Use the File object in the request
        given()
            .multiPart("files", myfile1) // Upload the file using the "multiPart" method
            .multiPart("files", myfile2) // Upload the file using the "multiPart" method
            //.multiPart("files", filearr)
            .contentType("multipart/form-data")
            
       .when()
            .post("http://localhost:8080/uploadMultipleFiles")
        
        .then()
            .statusCode(200)
            .body("[0].fileName", equalTo("File1.txt")) //response get in array format so need to add the array
            .body("[1].fileName", equalTo("File2.txt"))
            .log().all();
	}
}

// two things are imp when you upload the file
// multipart & form data
// we haveto use multipart & content Type to upload the file
