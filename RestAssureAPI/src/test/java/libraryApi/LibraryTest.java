package libraryApi;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;


import automation.RestAssureAPI.DataProviderClass;
import org.testng.annotations.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class LibraryTest {

	
	@Test(dataProvider="BookData")
	public void postAddbook(String name,String author) {
		RestAssured.baseURI = "http://216.10.245.166";
		String respose = given().body(DataProviderClass.addBook(name, RandomStringUtils.randomAlphabetic(3), RandomStringUtils.randomAlphanumeric(6), author)).log().all().when().get("Library/Addbook.php").then().extract().response().asString();
		System.out.println(respose);
	}
	
	@DataProvider(name="BookData")
	public Object[][] getBookData(){
		return new Object[][] {
			{
				"Learn Appium Automation with Java","John foe"
			},{
				"Learn API Automation with Java","John mate"
			}
		};
	}
}
