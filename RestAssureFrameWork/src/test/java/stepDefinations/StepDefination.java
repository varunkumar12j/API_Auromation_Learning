package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Add;
import pojo.Location;
import resources.APIResource;
import resources.TestDataBuildFile;
import resources.Utils;

@RunWith(Cucumber.class)
public class StepDefination extends Utils{

    private RequestSpecification req;
	TestDataBuildFile tdb = new TestDataBuildFile();
	private Response response;
	private APIResource resourceCall;
	private String placeID;

	@Given("^Add Place Payload with \\\"([^\\\"]*)\\\" \\\"([^\\\"]*)\\\" \\\"([^\\\"]*)\\\"$")
    public void add_place_payload(String name,String language, String address) throws Throwable {
		req = given().spec(getRequestSpecBuilder()).body(tdb.addPlacePayload(name, language, address));
    }

    @When("^User Calls \"([^\"]*)\" with \"([^\"]*)\" http reuest$")
    public void user_calls_something_with_post_http_reuest(String resource, String method) throws Throwable {
    	resourceCall = APIResource.valueOf(resource);
		
		if (method.equalsIgnoreCase("POST")) 
			response = req.when().post(resourceCall.getApi());
		else if (method.equalsIgnoreCase("DELETE")) 
			response = req.when().delete(resourceCall.getApi());
		else if (method.equalsIgnoreCase("GET")) 
			response = req.when().post(resourceCall.getApi());
    }

    @Then("^The API call is success with status code 200$")
    public void the_api_call_is_success_with_status_code_200() throws Throwable {
    	assertEquals(response.getStatusCode(), 200);
        
    }

    @And("^\"([^\"]*)\" in reponse body is \"([^\"]*)\"$")
    public void something_in_reponse_body_is_something(String keyPath, String value) throws Throwable {
    	response = response.then().extract().response();
        assertTrue(getJsonPathValue(response, keyPath).toString().equals(value));
    }
    
    
    @But("^verify place_Id created maps to \"([^\"]*)\" using \"([^\"]*)\"$")
    public void verify_placeid_created_maps_to_something_using_something(String name, String api) throws Throwable {
     placeID = getJsonPathValue(response, "place_id");
     resourceCall = APIResource.valueOf(api);
     req = given().spec(getRequestSpecBuilder()).queryParam("place_id", placeID);
     user_calls_something_with_post_http_reuest("getPlaceApi", "Get");
     assertEquals(name, getJsonPathValue(response, "name"));
    }
    
    @Then("^\"([^\"]*)\" added address$")
    public void something_added_address(String api) throws Throwable {
    	System.out.println(placeID);
        req = given().spec(getRequestSpecBuilder()).body(tdb.addToDeletePlaceBody(placeID));
        user_calls_something_with_post_http_reuest(api, "Delete");
        assertEquals("OK", getJsonPathValue(response, "status"));
    }
    
}