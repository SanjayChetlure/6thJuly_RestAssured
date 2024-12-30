package P3_Logging_Path_And_QueryParameters_Cookies_Headers;

import static io.restassured.RestAssured.given;

import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class Ex3_Cookies 
{
	//@Test
	public void TC1_testCookies()
	{
		given()
		
		.when()
			.get("https://google.com/")
		
		.then()
			.statusCode(200)
			.cookie("AEC","AZ6Zc-V0XCfVHQ0nOj8o7Ehgk2L_nGiSFsl6SuQGG7zWOkf87_eqHu4EGXM")
			.log().cookies();
	}
	
	
	
	//@Test
	public void TC2_getSingleCookieInfo()
	{
		 Response resp = given()	
				 		.when()
				 			.get("https://google.com/");
		
		String cookieValue = resp.getCookie("AEC");
		 System.out.println("----Cookie Info----"+cookieValue);
	}

	
	@Test
	public void TC3_getAllCookiesInfo()
	{
		 Response resp = given()	
				 		.when()
				 			.get("https://google.com/");	
		 
		Map<String, String> hm = resp.cookies();
		
		Set<String> allKeys = hm.keySet();
		
		for(String key:allKeys)
		{
			System.out.println(key+" : "+hm.get(key));
		}
	}

	
	

	

}
