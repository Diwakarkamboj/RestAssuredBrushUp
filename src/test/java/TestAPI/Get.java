package TestAPI;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Get {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://reqres.in";
		
		given()
			//.queryParam("page", "2")
		.when()
			.get("/api/users/2")
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.body("data.id", equalTo(2))
			.body("data.email", equalTo("janet.weaver@reqres.in"));
		
	}

}
