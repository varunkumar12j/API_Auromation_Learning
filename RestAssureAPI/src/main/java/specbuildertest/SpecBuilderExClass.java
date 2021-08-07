package specbuildertest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import serialize.Add;
import serialize.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class SpecBuilderExClass {

	
	public static void main(String[] args) {
		
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		
		Add addPlace = new Add();
		addPlace.setAccuracy(50);
		addPlace.setLanguage("French-IN");
		addPlace.setLocation(location);
		addPlace.setName("Frontline house");
		addPlace.setPhone_number("(+91) 983 893 3937");
		addPlace.setType(new ArrayList<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 5407144226487773360L;

			{
				add("shoe park");
				add("shop");
			}
		});
		addPlace.setAddress("29, side layout, cohen 09");
		addPlace.setWebsite("http://google.com");
	
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").build();
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).build();
		req = given().spec(req).body(addPlace);
		
		
		Response response = req.when().post("/maps/api/place/add/json").then().spec(res).extract().response();
		System.out.println(response.asString());
	}
}
