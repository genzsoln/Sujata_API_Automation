package SerializationAndDeserialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.given;
import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.given;

public class Deserialization 
{
	// Deserialization means json to POJO
	// json data should be in string format
	//here we used jackson package along with obj mapper class
	// why this process implementes json is light weight format And that more secure
	//we cant send diff java obj through n/w thats not safe
	// so we always transfer the data in json format
	// in restassured by default serialization and deserialization process is there
	
	@Test
	void convertJson2Pojon() throws JsonProcessingException
	{
		String jsondata= 
				"{\r\n"
				+ "	\"name\" : \"Scott\",\r\n"
				+ "	\"location\" : \"France\",\r\n"
				+ "	\"phone\" : \"123456\",\r\n"
				+ "	\"cources\" : [ \"C\", \"C++\" ]\r\n"
				+ "	}";

		//convert json data to pojo obj
        
        ObjectMapper objMapper=new ObjectMapper();
        
        Student studpojo=objMapper.readValue(jsondata, Student.class);

        //extract data
        System.out.println("Name:"+studpojo.getName());
        System.out.println("Location:"+studpojo.getLocation());
        System.out.println("Phone Number:"+studpojo.getPhone());
        System.out.println("Cources:"+studpojo.getCources()[0]); //we have two cources 
        System.out.println("Cources:"+studpojo.getCources()[1]);
	}
}
