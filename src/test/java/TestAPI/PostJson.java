package TestAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostJson {
	
	public static void main(String[] args) {
		
RestAssured.baseURI = "https://reqres.in/";

		
	String response =	given()
			.header("Content-type","application/json")
			.body("{ \"name\": \"morpheus\", \"job\": \"leader\" }")
		.when()
			.post("/api/users")
		
		.then()
			.assertThat()
			.statusCode(201).extract().response().asString();
			
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String job = js.getString("job");
		System.out.println(job);
		
		//update
		
		given()
			.log().all()
			.header("content-type","application/json")
			.body("{ \"name\": \"morpheus\", \"job\": \"" + job + "\" }")
		.when()
			.put("/api/users/2")
		.then()
			.assertThat()
			.log().all()
			.statusCode(200).body("job", equalTo("leader"));
		
		
		//Given
		
		given()
		.when()
			.get("/api/users/2")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.body("data.id", equalTo(2));
	}

}
