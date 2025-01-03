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
public class Ex_RequestResponseSpecBuilder
{
	String ID;
	RequestSpecification requestSpecBuider;
	ResponseSpecification responseSpecBuilder;
	ResponseSpecification responseSpecBuilderPost;
	
	
	@BeforeClass
	public void preRequest() 
	{
		 requestSpecBuider = new RequestSpecBuilder()
				 .setContentType(ContentType.JSON).setBaseUri("http://localhost:3000/students").build();
		 
		 responseSpecBuilder = new ResponseSpecBuilder()
				 .expectContentType(ContentType.JSON).expectStatusCode(200).build();
		 
		 responseSpecBuilderPost = new ResponseSpecBuilder()
				 .expectContentType(ContentType.JSON).expectStatusCode(201).build();
	}
	
	
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
			.spec(requestSpecBuider)
			.body(map)
		.when()                              
			.post()
		.then()	
			.spec(responseSpecBuilderPost)
			.log().all()
			.extract().jsonPath().getString("id");
	}
	
	@Test(priority = 2)
	public void TC2_getSpecificStudentDatails() 
	{
		given()                              
		.spec(requestSpecBuider)
	.when()                              
		.get(ID)
	.then()	
		.spec(responseSpecBuilder)
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
			.spec(requestSpecBuider)
			.body(map)
		.when()                              
			.put(ID)
		.then()	
			.spec(responseSpecBuilder)
			.body("name", equalTo("ADITYA"))
			.log().all();
	}
	
	
	@Test(priority = 4)
	public void TC3_DeeleteSpecificStudentDatails() 
	{
		given()
			.spec(requestSpecBuider)
		.when()
			.delete(ID)
		.then()
			.spec(responseSpecBuilder);
	}
	
	

}
