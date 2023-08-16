package SerializationAndDeserialization;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//import differentWayTCreatePostMethod.PostUsingPOJOClass;
import differentWayTCreatePostMethod.Pojo_PostRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
;public class Serialization 
{
//	when we send request it will go along with body in json format, response also e get in json format
//	serialization means POJO to JSON
//	 pojo is converting into json and json gothrought our request along with the 

	@Test
	void convertPojo2Json() throws JsonProcessingException
	{
		Student studepojo=new Student();
		
		studepojo.setName("Scott");
		studepojo.setLocation("France");
		studepojo.setPhone("123456");
    	
        String coursesArr[] = {"C", "C++"};
        studepojo.setCources(coursesArr);
        
        //convert java obj to json obj
        
        ObjectMapper objMapper=new ObjectMapper();
        
        //String jsondata=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studepojo);
        
       // String jsondata=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studepojo);
        String jsondata = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studepojo); // also it will through an exception //convert java/pojo obj to json obj

        System.out.println(jsondata);
        
//		given()
//		.when()
//		.then()
	}
}
