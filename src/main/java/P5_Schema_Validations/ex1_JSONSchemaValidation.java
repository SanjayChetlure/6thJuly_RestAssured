package P5_Schema_Validations;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class ex1_JSONSchemaValidation
{
	
	@Test
	public void jsonSchemaValidation()
	{
			given()		
			.when()
				.get("http://localhost:3000/store")			
			.then()
				.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JSONSchemaStore.json"));
	}

	

}
