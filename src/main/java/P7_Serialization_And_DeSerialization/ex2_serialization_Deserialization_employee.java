package P7_Serialization_And_DeSerialization;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
public class ex2_serialization_Deserialization_employee
{	
	ObjectMapper mapper=new ObjectMapper();
	
	//@Test(priority = 1)
	public void TC1_serialization_deserialization() throws StreamWriteException, DatabindException, IOException 
	{
		EmployeePojo ep=new EmployeePojo();                 //create pojo class with constructor parameter
		ep.setId("3");
		ep.setName("abc3");
		ep.setCompany("Vodafone");
		ep.setPhone("3333");
							
		 Response resp = given()                              
				 			.contentType("application/json") 	
				 			.body(ep)                      //serialization (java to JSON)
				 		.when()                              
				 			.post("http://localhost:3000/employee");   
		
//		 Assert.assertEquals(resp.jsonPath().getString("id"), "3");
//		 Assert.assertEquals(resp.jsonPath().getString("name"), "abc3");
		 
		 EmployeePojo ep2 = mapper.readValue(resp.body().asString(), EmployeePojo.class);  //de serialize
		
		 Assert.assertEquals(ep2.getId(), "3");
		 Assert.assertEquals(ep2.getName(), "abc3");
	}
	
	
	//@Test
	public void TC2_deserialize() throws JsonMappingException, JsonProcessingException 
	{
		
	 Response resp = given()                              
						.contentType("application/json") 	
					 .when()                              
					 	.get("http://localhost:3000/employee/1");   
		
//			 Assert.assertEquals(resp.jsonPath().getString("id"), "1");
//			 Assert.assertEquals(resp.jsonPath().getString("name"), "abc1");
		 
		 EmployeePojo ep = mapper.readValue(resp.body().asString(), EmployeePojo.class);  //de serialize
		
		 Assert.assertEquals(ep.getId(), "1");
		 Assert.assertEquals(ep.getName(), "abc1");	
	}
	
	
	@Test(priority = 3)
	public void TC3_deserialize_WIth_MultipleData() throws JsonMappingException, JsonProcessingException 
	{
	 Response resp = given()                              
				.contentType("application/json") 	
			.when()                              
				.get("http://localhost:3000/employee");   
		
//			 Assert.assertEquals(resp.jsonPath().getString("[0].id"), "1");
//			 Assert.assertEquals(resp.jsonPath().getString("[0].name"), "abc1");
		 
	 List<EmployeePojo> ep = mapper.readValue(resp.body().asString(), new TypeReference<List<EmployeePojo>>() {});
	 // EmployeePojo fp = mapper.readValue(resp.body().asString(), EmployeePojo.class);  //de serialize
		
		 Assert.assertEquals(ep.get(0).getId(), "1");
		 Assert.assertEquals(ep.get(2).getCompany(), "Vodafone");
	
	}
	
}
