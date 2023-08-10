package XMLResponse;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import java.util.List;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import static io.restassured.RestAssured.*;

public class AdditionalValidationForXMLResponse 
{
	@Test
	void testXMLResponseBody()
    {
        //approach_2
		//XML path class is used for additional validation
		
        Response res = given()
        
        .when()
            .get("http://restapi.adequateshop.com/api/Traveler?page=1");
        
        	//create object of xmlpath class
        	// if u want to convert data in string format use toString method
        	// if u want to convert entire response as string the use asString method
        
        	XmlPath xmlobj=new XmlPath(res.asString());//have to convert res in string format
        	
        	//find total no. of travellers info 
        	List<String> travellers=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation"); //we need all the node/traveller so am not passing index here
        	//in traveller variable we verify total no of travellers
        	
        	Assert.assertEquals(travellers.size(),10);   //here we found all the travellers
        	
        	//verify traveller name is present in xml response or not
        	//1st from xml response we have to capture all the name
        	List<String> traveller_names=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name"); //xpath for name

        	//searching texhnique
//        	for(String travellername:traveller_names)
//        	{
//        		System.out.println(travellername); //it will print all the traveller names
//        		//if(travellername);
//        	}     	
        	
        	boolean status=false;
        	for(String travellername:traveller_names)
        	{
        		if(travellername.equals("Developer123"))
        		{
        			status=true;
        			break;
        		}
        	} 
        	Assert.assertEquals(status, true);
    }
}