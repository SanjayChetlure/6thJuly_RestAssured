package P10_TypesOfAuthorizations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Ex3_Preemptive_Auththentication
{
	
	
	//@Test(priority = 3)
	public void AuthEx3_preemptive() 
	{
		given()
			.auth().preemptive().basic("postman", "password")
		.when()
			.get("https://www.postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	
	
	
	@Test(priority = 6)
	public void AuthEx7_ApiKey2() 
	{
		given()
			.queryParam("appid", "5120d656c622c588181f50a225d65448")
			.queryParam("q", "pune")
			.queryParam("limit", "5")
		.when()
			.get("http://api.openweathermap.org/geo/1.0/direct")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	//@Test(priority = 6)
	public void AuthEx7_ApiKey1() 
	{
		given()
			.pathParam("myPath", "geo/1.0/direct")
			.queryParam("appid", "5120d656c622c588181f50a225d65448")
			.queryParam("q", "pune")
			.queryParam("limit", "5")
		.when()
			.get("http://api.openweathermap.org/{myPath}")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	
	
}
