package differentWayTCreatePostMethod;

public class Pojo_PostRequest 
{
	//this class contains variable getter and setter methods
	// here we require 4 variable name, location, phone ( this 3 are primitive variable ) & cources (array variable)
	//click on all variables & then click on Generate
	
	String name;
	String location;
	String phone;
	String cources[];
	
	// to assign and retrive the data we have to write getter & setter
	//select above variables go to source click on "generate getter & setter"

	//setter methos will take one parameter & assign the value to the class variable
	// it will take phone value and assign to phone class variable
	
	//setter assign values to the variable
	//getter methos will get value from the variable
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getLocation() 
	{
		return location;
	}
	
	public void setLocation(String location) 
	{
		this.location = location;
	}
	
	public String getPhone() 
	{
		return phone;
	}
	
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}
	
	public String[] getCources()
	{
		return cources;
	}
	
	public void setCources(String[] cources) 
	{
		this.cources = cources;
	}
}
