package P3_Logging_Path_And_QueryParameters_Cookies_Headers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Ex4_Headers
{	
		//@Test(priority = 1)
		public void testHeades()	
		{
			given()			
			.when()
				.get("https://google.com/")			
			.then()
				.header("Content-Type", "text/html; charset=ISO-8859-1")
				.header("Content-Encoding", "gzip")
				.header("Server", "gws")
				.log().headers();
		}
	
		//@Test(priority = 2)
		public void getHeadersInfo()
		{
			 Response resp = given()			
					 		.when()
					 			.get("https://google.com/");
			
			String headerValue = resp.getHeader("Content-Type");
			 System.out.println("----Content type----"+headerValue);
		}
		
		
		@Test(priority = 3)   //not that must useful / as log.all() /log.headers()
		public void getAllHeadersInfo()
		{
			 Response resp = given()			
			.when()
				.get("https://google.com/");
			
			Headers allHeader = resp.headers();
			for(Header s1:allHeader)
			{
				System.out.println(s1.getName()+" : "+s1.getValue());
			}
		}
		

}
