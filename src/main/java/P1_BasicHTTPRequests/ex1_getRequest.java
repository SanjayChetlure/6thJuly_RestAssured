package P1_BasicHTTPRequests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class ex1_getRequest
{
	
	@Test
	public void TC() 
	{
		given()                                				 //Pre-req-
			.contentType("application/json")
		.when()												//request type
			.get("https://reqres.in/api/users/2")    
		.then()                                             //validation
			.statusCode(201)
			.log().all();
		
		
		
		//given().contentType("application/json").when().get("url").then().statusCode(200).log().all();
			
	}

}
