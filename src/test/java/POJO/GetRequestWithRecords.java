package POJO;

import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetRequestWithRecords {
	
	@Test
	public void getResponse() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		
		
		Response response = 
				RestAssured
				.given()
				.when()
					.get("/api/users?page=2")
				.then()
					.extract()
					.response();
		
		//Gson gson = new Gson();
		APIResponse apiResponse = response.as(APIResponse.class);
		System.out.println(apiResponse.total_pages());
		System.out.println(apiResponse.data().get(0).email());
		String lastName = apiResponse.data().get(1).last_name();
		System.out.println(lastName);
				
		
	}

}
