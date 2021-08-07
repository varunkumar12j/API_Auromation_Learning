package serialize;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class TestClass {

	
	@Test
	public void serializationTestMethod() {
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
		
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response response = given().queryParam("key", "qaclick123").body(addPlace).
		when().post("/maps/api/place/add/json").
		then().extract().as(Response.class);
		
		System.out.println("-------------------Extracted values--------------------");
		System.out.println("Status "+response.getStatus());
		System.out.println("ID "+response.getId());
		System.out.println("Place ID "+response.getPlace_id());
		System.out.println("Reference "+response.getReference());
		System.out.println("Scope "+response.getScope());
	}
}
