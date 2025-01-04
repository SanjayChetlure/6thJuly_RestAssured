package P7_Serialization_And_DeSerialization;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
public class ex1_serialization_Deserialization_Students
{	
	ObjectMapper mapper=new ObjectMapper();
	
	//@Test(priority = 1)
	public void TC1_serialization() throws StreamWriteException, DatabindException, IOException 
	{
		StudentsPojo sp=new StudentsPojo();                 //create Pojo class with constructor parameter
		sp.setId("3");
		sp.setName("abc3");
		sp.setLocation("Pune");
		sp.setPhone("3333");
		String [] courses={"sub1","sub2"};
		sp.setCourses(courses);
		
		 		given()                              
					.contentType("application/json") 
					.body(sp)                      //serialization (java to JSON)     
				.when()                         
					.post("http://localhost:3000/students")
				.then()
					.log().all();
	}
	
	
	@Test(priority = 2)
	public void TC2_DeSerialization() throws StreamWriteException, DatabindException, IOException 
	{
		Response resp = given()                              
							.contentType("application/json") 	
						.when()                              
							.get("http://localhost:3000/students/1");
		
		StudentsPojo sp = mapper.readValue(resp.body().asString(), StudentsPojo.class);   //de-serialization  convert json -> java object
	
		System.out.println(sp.getId());
		System.out.println(sp.getName());
		System.out.println(sp.getLocation());
		System.out.println(sp.getPhone());
		System.out.println(sp.getCourses()[0]);
		System.out.println(sp.getCourses()[1]);
		
		
		Assert.assertEquals(sp.getId(), "1");
		Assert.assertEquals(sp.getCourses()[1], "Selenium");
	}
	
}
