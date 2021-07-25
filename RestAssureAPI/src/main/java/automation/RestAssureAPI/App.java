package automation.RestAssureAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    private static String placeId;

	public static void main( String[] args )
    {
        System.out.println( "------------------------Stated------------------------" );
        RestAssured.baseURI = "https://rahulshettyacademy.com";
//        given
//        When
//        Then
        String response = given().log().all().queryParam("key", "qaclick123").header("Content-type","application/json").body(DataProviderClass.getPayload())
        .when().post("maps/api/place/add/json")
        .then().log().all().assertThat().statusCode(200).extract().response().asString();
        
        JsonPath jp = new JsonPath(response);
        placeId=jp.get("place_id");
        System.out.println("place_id :"+response);
        
        jp = new JsonPath(DataProviderClass.getPayload());
        System.out.println("Address :"+jp.get("address"));
        
        response = given().queryParam("key", "qaclick123").body(String.format(DataProviderClass.getPutPayload(), placeId))
        .when().put("maps/api/place/update/json")
        .then().extract().response().asString();
        
        jp = new JsonPath(response);
        System.out.println("Put Message :"+jp.get("msg"));
        
        HashMap<String, String> parameters = new HashMap<String,String>() {
        	/**
			 * Put data members
			 */
			private static final long serialVersionUID = 1L;

			{
        		put("place_id", placeId);
        		put("key","qaclick123");
        	}
        };
        response = given().queryParams(parameters)
        .when().get("maps/api/place/get/json")
        .then().extract().response().asString();
        
        jp = new JsonPath(response);
        System.out.println("Get address :"+jp.get("address"));
        
        
        
        
        System.out.println( "------------------------Completed------------------------" );
    }
}
