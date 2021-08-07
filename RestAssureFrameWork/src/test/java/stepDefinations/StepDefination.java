package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
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
import resources.TestDataBuildFile;
import resources.Utils;

@RunWith(Cucumber.class)
public class StepDefination extends Utils{

    private RequestSpecification req;
	TestDataBuildFile tdb = new TestDataBuildFile();
	private Response response;

	@Given("^Add Place Payload$")
    public void add_place_payload() throws Throwable {
		req = given().spec(getRequestSpecBuilder()).body(tdb.addPlacePayload());
    }

    @When("^User Calls \"([^\"]*)\" with Post http reuest$")
    public void user_calls_something_with_post_http_reuest(String strArg1) throws Throwable {
		response = req.when().post("/maps/api/place/add/json").then().spec(getResponseSpecBuilder()).extract().response();
    }

    @Then("^The API call is success with status code 200$")
    public void the_api_call_is_success_with_status_code_200() throws Throwable {
    	assertEquals(response.getStatusCode(), 200);
        
    }

    @And("^\"([^\"]*)\" in reponse body is \"([^\"]*)\"$")
    public void something_in_reponse_body_is_something(String key, String value) throws Throwable {
        JsonPath path = new JsonPath(response.asString());
        assertTrue(path.get(key).toString().equals(value));
    }

}