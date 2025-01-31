package TestAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.*;


public class Post {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		Response response =
		
		given()
			.header("Content-type","application/json")
			.body("{ \"name\": \"morpheus\", \"job\": \"leader\" }")
		.when()
			.post("/api/users");
		
        System.out.println("Response Body:");
		response.prettyPrint();
		
		response.then()
			
			.assertThat()
			.statusCode(201)
			.body("name", equalTo("morpheus"));
		
		//JsonPath js = new JsonPath(response);
			
		
	}

}
