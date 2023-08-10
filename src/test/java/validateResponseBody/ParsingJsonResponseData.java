package validateResponseBody;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
//import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.checkerframework.checker.units.qual.Length;
import org.json.JSONObject;

public class ParsingJsonResponseData 
{	
	//Approach 1
	//@Test
    void testJsonResponse() 
    {
    	//approach--1
        given()
            .contentType("ContentType.JSON")
        	
        .when()
            .get("http://localhost:3000/book")
        	
        .then()
            .statusCode(200)
            .header("Content-Type", "application/json; charset=utf-8")
            .body("[2].title", equalTo("Moby Dick"));
    }
    
    //approach 2
   // @Test
    void testJsonResponse1() 
    {
        Response res = given()
            .contentType("application/json")
        .when()
            .get("http://localhost:3000/book");
        
        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
        
        System.out.println("Response Body:");
        System.out.println(res.getBody().asString()); // Print the response body
        
        String bookname = res.jsonPath().get("book[2].title").toString(); // Corrected index
        
        Assert.assertEquals(bookname, "Moby Dick");
    }
    
	//////////////////////////////////JSONObject class/////////////////////////////////////
	 // to fetch only title from json response
	
//	
	@Test(priority = 1)
	void testJsonResponseBodyData()
	{
	
	Response res = given()
			.contentType(ContentType.JSON)
			
			.when()
				.get("http://localhost:3000/book");
	
	//using json object class
	JSONObject jo =new JSONObject(res.asString());                 // converting response to json object type
	
	
	//print all title of books
	for(int i=0; i<jo.getJSONArray("book").length(); i++)        // find all json length()
	{
		
		//capture title from every object by using index
		
		String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString(); 
		System.out.println(bookTitle);
	}
//	
//	
//	
//	//search for title of the boo in json - validation 1
//	
//	boolean status=false;
//	
//	for(int i=0; i<jo.getJSONArray("book").length(); i++)        // find all json length()
//	{
//		
//		//capture title from every object by using index
//		
//		String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString(); 
//		
//		if(bookTitle.equals("Moby Dick"))
//		{
//			status=true;
//			break;
//		}
//		
//}
//	Assert.assertEquals(status, true);
//	
//	
//	
//	//validate total price of book - validation 2
//	
//	double totalprice=0;
//	
//	for(int i=0; i<jo.getJSONArray("book").length(); i++)        // find all json length()
//	{
//		
//		//capture title from every object by using index
//		
//		String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString(); 
//		
//		totalprice=totalprice+Double.parseDouble(price);
//	}
//	System.out.println("total price of books is:"+ totalprice);
//		Assert.assertEquals(totalprice, 526.0);
	}
}
		
		
			
