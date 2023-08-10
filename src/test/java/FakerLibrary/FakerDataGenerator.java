package FakerLibrary;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import static io.restassured.matcher.RestAssuredMatchers.*;
import com.github.javafaker.Faker;
public class FakerDataGenerator 
{
	@Test
	void testGenerateDummyData()
	{
		Faker faker=new Faker();
		
		String fullname=faker.name().fullName();
		String firstname=faker.name().firstName();
		String lastname=faker.name().lastName();
		
		String username=faker.name().username();
		String password=faker.internet().password();
		
		String phoneno=faker.phoneNumber().cellPhone();
		String email=faker.internet().safeEmailAddress();
		
		System.out.println("Full Name : "+fullname);
		System.out.println("First Name : "+firstname);
		System.out.println("Last Name : "+lastname);
		System.out.println("User Name : "+username);
		System.out.println("Passeord : "+password);
		System.out.println("Phone No : "+phoneno);
		System.out.println("Email : "+email);
	}
}

//we can generate randam /dummy data
//need to add dependancy search java faker and click on 1st link copy dependancy from there
//when we run pgm again and again it will generate diff data