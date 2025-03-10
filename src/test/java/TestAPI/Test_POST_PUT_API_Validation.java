package TestAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

import Files.Payload;


public class Test_POST_PUT_API_Validation {

	public static void main(String[] args) {
		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
//		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
//		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
//		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
//		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
//		
//		System.out.println(response);
//		JsonPath js=new JsonPath(response); //for parsing Json
//		String placeId=js.getString("place_id");
//		
//		System.out.println(placeId);
//		
//		//Update Place
//		String newAddress = "Summer Walk, Africa";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.addPlace()).
		when().post("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200);
		
		//Get Place
		
//	String getPlaceResponse=	given().log().all().queryParam("key", "qaclick123")
//		.queryParam("place_id",placeId)
//		.when().get("maps/api/place/get/json")
//		.then().assertThat().log().all().statusCode(200).extract().response().asString();
//	JsonPath js1=ReUsableMethods.rawToJson(getPlaceResponse);
//	String actualAddress =js1.getString("address");
//	System.out.println(actualAddress);
//	Assert.assertEquals(actualAddress, "Pacific ocean");
	//Cucumber Junit, Testng
	
	
	
	
	
	
	
	
	

		
		
		
		
		
	}

}
