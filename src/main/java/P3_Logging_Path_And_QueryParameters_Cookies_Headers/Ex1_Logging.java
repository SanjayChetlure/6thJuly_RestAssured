package P3_Logging_Path_And_QueryParameters_Cookies_Headers;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Ex1_Logging 
{
	
	@Test
	public void getLogs() 
	{
		given()        
		
		.when()
			.get("https://reqres.in/api/users?page=2&id=5")
		
		.then()
			//.log().body()       //get only body
			//.log().cookies()    //get only cookies
			//.log().headers();   //get only headers
			.log().all();      //get all details -> body, cookie, header, status code
	}

	

}
