package P1_BasicHTTPRequests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class ex4_deleteRequest_Students
{
	
	@Test(priority = 1)
	public void TC1_deleteStudnestData() 
	{
		given()
			.contentType("application/json")
		.when()
			.delete("http://localhost:3000/students/3")
		.then()
			.statusCode(200)
			.log().all();
	}
	


}
