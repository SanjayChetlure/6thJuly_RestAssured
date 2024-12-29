package P2_DiffrentWaysOfCreatingPostRequestBody;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class Ex3_Using_ExternalJSONFile
{
	
	@Test(priority = 1)
	public void TC1_CreateNewStudentDetails() 
	{
		File data=new File("D:\\6th July 2024\\Workspace\\6thJuly_RestAssured\\JsonFiles\\StudentsData.json");
		
		
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
