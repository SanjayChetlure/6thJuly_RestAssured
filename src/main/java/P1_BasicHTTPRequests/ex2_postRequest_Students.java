package P1_BasicHTTPRequests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.LinkedHashMap;


public class ex2_postRequest_Students
{
	
	@Test(priority = 1)
	public void TC1_CreateNewStudentDetails() 
	{
		LinkedHashMap data=new LinkedHashMap();
		data.put("id", "4");
		data.put("name", "Nayana");
		data.put("location", "Mumbai");
		data.put("phone", "4444");
		
		String [] ar = {"SQL", "Python"};
		data.put("courses", ar);
		
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.log().all();
			
	}
	
	

}
