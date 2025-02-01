package TestAPI;

import org.testng.Assert;

import Files.Payload;
import io.restassured.path.json.JsonPath;

//Print No of courses returned by API
//
//2.Print Purchase Amount
//
//3. Print Title of the first course
//
//4. Print All course titles and their respective Prices
//
//5. Print no of copies sold by RPA Course
//
//6. Verify if Sum of all Course prices matches with Purchase Amount

public class ComplexJSONParse {
	
	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(Payload.coursePrice());
		
	int count =	js.getInt("courses.size()");
	System.out.println(count);
	
	int purchaseAmt = js.getInt("dashboard.purchaseAmount");
	System.out.println(purchaseAmt);
	
	String firstCourse = js.getString("courses.title");
	System.out.println(firstCourse);
	String allCourse = " ";
	int price = 0;
	for(int i=0;i<count;i++) {
		 allCourse += js.getString("courses.title["+i+"]")+ " ";
		 price += (js.getInt("courses.price["+i+"]"))*(js.getInt("courses.copies["+i+"]"));
		 
	}
	System.out.println(allCourse);
	System.out.println(price);
	Assert.assertEquals(purchaseAmt, price);
	}

}
