package P10_TypesOfAuthorizations;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Ex5_Auth1_Auth2_Auththentication 
{
	
		@Test(priority = 1)
		public void AuthEx5_Auth1() 
		{
			given()
				.auth().oauth("ConsumerKey", "ConsumerSecret", "AccessToken", "TokenSecret")
			.when()
				.get("request URL")
			.then()
				.statusCode(200)
				.log().all();
		}
		
		
		@Test(priority = 2)
		public void AuthEx6_Auth2() 
		{
			given()
				.auth().oauth2("Auth2 Token")
			.when()
				.get("request URL")
			.then()
				.statusCode(200)
				.log().all();
		}
}
