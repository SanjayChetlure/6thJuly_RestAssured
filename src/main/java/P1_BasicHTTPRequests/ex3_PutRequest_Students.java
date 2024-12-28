package P1_BasicHTTPRequests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.LinkedHashMap;


public class ex3_PutRequest_Students
{
	
	@Test(priority = 1)
	public void TC1_CreateNewStudentDetails() 
	{
		LinkedHashMap data=new LinkedHashMap();
		data.put("id", "3");
		data.put("name", "AMOL");
		data.put("location", "PUNE");
		data.put("phone", "3333");
		
		String [] ar = {"SQL", "JAVA"};
		data.put("courses", ar);
		
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("http://localhost:3000/students/3")
		.then()
			.statusCode(200)
			.log().all();
			
	}
	
	

}
