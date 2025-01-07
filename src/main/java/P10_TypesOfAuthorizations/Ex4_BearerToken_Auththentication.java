package P10_TypesOfAuthorizations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Ex4_BearerToken_Auththentication
{
	@Test(priority = 4)
	public void AuthEx4_BearerToken() 
	{
		String bearerToken="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";
		
		//bearerToken="Bearer "+bearerToken;
		

		given()
			.headers("Authorization", "Bearer "+bearerToken)
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
	}		
}
