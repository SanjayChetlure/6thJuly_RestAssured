package P4_ParsingJSONData;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ParsingJSONResponseData 
{
	//@Test(priority = 1)
	public void testJSONResponse1() 
	{
		//approach1: Normal way (without capturing response)
		
		given()    
			.contentType(ContentType.JSON)		
		.when()
			.get("http://localhost:3000/store")		
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json")
			.body("book[2].price", equalTo("150.50"))
			.body("book[3].title", equalTo("The Lord of Rings"))
			.body("book[0].auther", equalTo("Amol"));
	}
	
	
	
	//@Test(priority = 2)
	public void testJSONResponse2() 
	{
		//approach2: store response in a variable (with capturing response)
		
		Response resp = 
				given()    
					.contentType(ContentType.JSON)
				.when()
					.get("http://localhost:3000/store");
		
		
		
				Assert.assertEquals(resp.getStatusCode(), 200);
				Assert.assertEquals(resp.getHeader("Content-Type"), "application/json");
				
			
				
				Assert.assertEquals(resp.jsonPath().get("book[2].price").toString()	, "150.50");
				Assert.assertEquals(resp.jsonPath().get("book[3].title").toString(), "The Lord of Rings");
				
				JsonPath jp = resp.jsonPath();
				Assert.assertEquals(jp.get("book[0].auther").toString(), "Amol");
				
				//Assert.assertEquals(resp.jsonPath().get("book[0].price").toString()	, "savings of the country");
			
				//Note: if title is not stored in same order then this approach will not work
				//    we can't write conditional/looping statement
	}
	
	
	
	
	//@Test(priority = 3)
	public void getAllTitlesFromResponse() 
	{
		//approach3: Converting Response into JSON Object
		
		Response resp = given()    
							.contentType(ContentType.JSON)
						.when()
							.get("http://localhost:3000/store");
		
		//to convert JSON resp into String format need to pass resp into JSONObject constructor
		//converting response into JSON Object type
		JSONObject jo=new JSONObject(resp.asString());     
		//JSONArray ja=new JSONArray();
		
		int length = jo.getJSONArray("book").length();    //4
		
		for(int i=0; i<=length-1; i++)      // 0 to 3
		{  //                                                    0
			//String title = jo.getJSONArray("book").getJSONObject(i).get("auther").toString();
			String title = jo.getJSONArray("book").getJSONObject(i).getString("auther");
			System.out.println(title);
		}
	}

	
	
	   // @Test(priority = 4)
		public void verifySpecificAuthorFromResponse() 
		{
			Response resp = given()    
								.contentType(ContentType.JSON)
							.when()
								.get("http://localhost:3000/store");
			
			JSONObject jo=new JSONObject(resp.asString());      
			
			boolean AuthorFound=false;
			String expAuthor="Ajay";
			
			int lastIndex = jo.getJSONArray("book").length()-1;
			for(int i=0; i<=lastIndex; i++)
			{
				String actTitle = jo.getJSONArray("book").getJSONObject(i).getString("auther");
				if(actTitle.equals(expAuthor)) 
				{
					AuthorFound=true;
					break;
				}
			}
			Assert.assertTrue(AuthorFound,"Failed : Author not found  -   ");
		}

	
	
		@Test(priority = 5)
		public void verifyTotalPriceFromResponse() 
		{
			Response resp = given()    
								.contentType(ContentType.JSON)
							.when()
								.get("http://localhost:3000/store");
			
			JSONObject jo=new JSONObject(resp.asString());      
			
			double totalPrice=0;
			
			int lastIndex = jo.getJSONArray("book").length()-1;
			for(int i=0; i<=lastIndex; i++)
			{
				String price = jo.getJSONArray("book").getJSONObject(i).getString("price");
				totalPrice=totalPrice+ Double.parseDouble(price);
			}
			
			System.out.println(totalPrice);
			Assert.assertEquals(totalPrice, 601,"Failed : price mismatch  -   ");
		}	
	
	
	
	
	
}
