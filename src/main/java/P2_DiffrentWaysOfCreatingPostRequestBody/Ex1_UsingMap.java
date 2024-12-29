package P2_DiffrentWaysOfCreatingPostRequestBody;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.LinkedHashMap;

public class Ex1_UsingMap
{
	
	@Test(priority = 1)
	public void TC1_CreateNewStudentDetails() 
	{
		LinkedHashMap data=new LinkedHashMap();
		data.put("id", "3");
		data.put("name", "Nayana");
		data.put("location", "Mumbai");
		data.put("phone", "3333");
		
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
