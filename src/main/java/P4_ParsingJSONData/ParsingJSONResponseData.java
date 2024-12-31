package P4_ParsingJSONData;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONResponseData 
{
	@Test(priority = 1)
	public void testJSONResponse1() 
	{
		//approach1: Normal way (without capturing response)
		
		given()    
			.contentType(ContentType.JSON)		
		.when()
			.get("http://localhost:3000/store")		
		.then()
			.statusCode(200)
			.body("book[2].price", equalTo("150.50"))
			.body("book[3].title", equalTo("The Lord of Rings"))
			.body("book[0].auther", equalTo("Amol"));
	}
	
	

	
}
