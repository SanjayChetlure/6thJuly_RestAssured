package P2_DiffrentWaysOfCreatingPostRequestBody;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class Ex4_Using_POJOClass
{
	
	@Test(priority = 1)
	public void TC1_CreateNewStudentDetails() 
	{
		StudentPojo sp=new StudentPojo();
		sp.setId("7");
		sp.setName("Ramesh");
		sp.setLocation("Delhi");
		sp.setPhone("7777");
		
//		String [] ar= {"Manual", "Automation"};
//		sp.setCourses(ar);
		
		
		given()
			.contentType("application/json")
			.body(sp)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.log().all();
			
	}
	
	

}
