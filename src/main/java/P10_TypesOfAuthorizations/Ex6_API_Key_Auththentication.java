package P10_TypesOfAuthorizations;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class Ex6_API_Key_Auththentication
{
	
	@Test(priority = 1)
	public void AuthEx7_ApiKey1() 
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
	
	
//	@Test(priority = 2)
//	public void AuthEx7_ApiKey2() 
//	{
//		given()
//			.pathParam("myPath", "geo/1.0/direct")
//			.queryParam("appid", "5120d656c622c588181f50a225d65448")
//			.queryParam("q", "pune")
//			.queryParam("limit", "5")
//		.when()
//			.get("http://api.openweathermap.org/{myPath}")
//		.then()
//			.statusCode(200)
//			.log().all();
//	}
	
}
