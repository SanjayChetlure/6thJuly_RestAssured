package P2_DiffrentWaysOfCreatingPostRequestBody;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Ex2_Using_OrgJSONLibrary
{
	
	@Test(priority = 1)
	public void TC1_CreateNewStudentDetails() 
	{
		JSONObject data=new JSONObject();
		data.put("id", "4");
		data.put("name", "Devika");
		data.put("location", "pune");
		data.put("phone", "4444");
		
		String [] ar = {"selenium", "Python"};
		data.put("courses", ar);
		
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.log().all();
			
	}
	
	

}
