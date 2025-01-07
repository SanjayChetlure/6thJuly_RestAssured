package P10_TypesOfAuthorizations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Ex1_Basic_Auththentication
{
	@Test
	public void basicAuth() 
	{
		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://www.postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	
	
		
}
