package jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class JiraOperation {

	@Test(enabled=false)
	public void createAnIssue() {
		RestAssured.baseURI = "http://localhost:8080";
		//create cookie
		String reponse = given().log().all().header("Content-Type","application/Json").body("{\r\n" + 
				"    \"username\": \"varunkumar.dx\",\r\n" + 
				"    \"password\": \"Anu12jv@run92\"\r\n" + 
				"}").
				when().post("/rest/auth/1/session").
				then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath path = new JsonPath(reponse);
		String cookie = path.get("session.value");
		
		//create Issue
		reponse = given().header("Content-Type","application/Json").header("cookie",String.format("JSESSIONID=%s",cookie)).body("{\"fields\": \r\n" + 
				"	{\"project\":{\"key\": \"RP\"},\r\n" + 
				"       \"summary\": \"Issue adding comment\",\r\n" + 
				"       \"description\": \"Creating my First bug\",\r\n" + 
				"       \"issuetype\": {\"name\": \"Bug\"}\r\n" + 
				"       }\r\n" + 
				"    }").
					when().post("rest/api/2/issue").
					then().extract().asString();
		System.out.println("-----------------Completed");
	}
	@Test
	public void createAnIssueUsingSession() {
		RestAssured.baseURI = "http://localhost:8080";
		//Create a seesion filter
		SessionFilter session = new SessionFilter();
		
		//create cookie
		String reponse = given().log().all().header("Content-Type","application/Json").body("{\r\n" + 
				"    \"username\": \"varunkumar.dx\",\r\n" + 
				"    \"password\": \"Anu12jv@run92\"\r\n" + 
				"}").filter(session).
				when().post("/rest/auth/1/session").
				then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		//create Issue
		reponse = given().header("Content-Type","application/Json").body("{\"fields\": \r\n" + 
				"	{\"project\":{\"key\": \"RP\"},\r\n" + 
				"       \"summary\": \"Issue adding comment\",\r\n" + 
				"       \"description\": \"Creating my First bug\",\r\n" + 
				"       \"issuetype\": {\"name\": \"Bug\"}\r\n" + 
				"       }\r\n" + 
				"    }").filter(session).
					when().post("rest/api/2/issue").
					then().log().all().extract().asString();
		System.out.println("-----------------Completed");
	}
	
}
