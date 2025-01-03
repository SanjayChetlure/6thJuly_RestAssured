package P6_Request_Response_Specification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.LinkedHashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
public class Ex1_WithoutRequestResponseSpecBuilder
{
	String ID;
	
	@Test(priority = 1)
	public void TC1_postStudentDatails() 
	{
		LinkedHashMap map=new LinkedHashMap();
		map.put("id", "3");
		map.put("name", "aditya");
		map.put("location", "Pune");
		map.put("phone", 3333);
		
		String [] courcseNames= {"RPA","Power BI"};
		map.put("courses", courcseNames);
		
		ID=given()               
				.contentType(ContentType.JSON)	
				.body(map)
		.when()                              
			.post("http://localhost:3000/students")
		.then()	
			.statusCode(201)
			.log().all()
			.extract().jsonPath().getString("id");
	}
	
	@Test(priority = 2)
	public void TC2_getSpecificStudentDatails() 
	{
		given()
			.contentType(ContentType.JSON)	
		.when()                              
		.get("http://localhost:3000/students"+"/"+ID)
	.then()	
		.statusCode(200)
		.body("id", equalTo("3"))
		.body("name", equalTo("aditya"))
		.body("courses[0]", equalTo("RPA"))
		.log().all();
	}
	
	
	@Test(priority = 3)
	public void TC3_UpdateSpecificStudentDatails() 
	{
		LinkedHashMap map=new LinkedHashMap();
		map.put("id", ID);
		map.put("name", "ADITYA");
		map.put("location", "PUNE");
		map.put("phone", 3333);
		
		String [] courcseNames= {"RPA","Power BI"};
		map.put("courses", courcseNames);
		
		given()
			.contentType(ContentType.JSON)	
			.body(map)
		.when()                              
			.put("http://localhost:3000/students"+"/"+ID)
		.then()	
			.statusCode(200)
			.body("name", equalTo("ADITYA"))
			.log().all();
	}
	
	
	@Test(priority = 4)
	public void TC3_DeeleteSpecificStudentDatails() 
	{
		given()
			.contentType(ContentType.JSON)	
		.when()
			.delete("http://localhost:3000/students"+"/"+ID)
		.then()
			.statusCode(200);
	}
	
	

}
