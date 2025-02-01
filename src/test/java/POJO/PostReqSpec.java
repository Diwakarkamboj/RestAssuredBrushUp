package POJO;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostReqSpec {
	
	@Test
	public static void reqSpec() {
		
		RequestSpecification reqSpec = new RequestSpecBuilder()
				.setBaseUri("https://reqres.in/")
				.setBasePath("/api/users")
				.addHeader("Content-Type", "application/json")
				.setContentType(ContentType.JSON)
				.build();
		
		ResponseSpecification resSpec = new ResponseSpecBuilder()
				.expectStatusCode(201)
				.expectContentType("application/json")
				.build();
		
		given()
			.spec(reqSpec)
			.body("{ \"name\": \"John\", \"job\": \"leader\" }")
		.when()
			.post()
		.then()
			.spec(resSpec);
			
	}

}
