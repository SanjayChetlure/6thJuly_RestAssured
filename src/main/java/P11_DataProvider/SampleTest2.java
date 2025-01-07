package P11_DataProvider;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SampleTest2
{
	@Test(dataProvider = "m1", dataProviderClass = SampleData2.class)	
	public void TC2(String serviceEndpoint, int statusCode)
	{		
			given()                              
				.contentType(ContentType.JSON) 
			.when()                              
					.get(serviceEndpoint)
			.then()		
				.statusCode(statusCode)
				.log().all();				
	}
}
