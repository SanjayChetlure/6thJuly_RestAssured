package P3_Logging_Path_And_QueryParameters_Cookies_Headers;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Ex2_PathParameter_QueryParameter
{
	
	//@Test
	public void PathQueryParameter1() 
	{
		given()        
			.contentType("application/json")
			.pathParam("p1", "api")
			.pathParam("p2", "user")
			.queryParam("page", "2")
			.queryParam("id", "5")
			
		.when()
			.get("https://reqres.in/{p1}/{p2}")
		
		.then()
			.statusCode(200)
			.log().all();     
	}
	
	
	@Test
	public void PathQueryParameter2() 
	{
		given()        
			.contentType("application/json")
			.pathParams("p1","api","p2","user")
			.queryParams("page", "2","id","5")
			
		.when()
			.get("https://reqres.in/{p1}/{p2}")
		
		.then()
			.statusCode(200)
			.log().all();     
	}

	

}
