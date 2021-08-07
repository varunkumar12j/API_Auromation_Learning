package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

	public RequestSpecification getRequestSpecBuilder() {
		PrintStream stream=null;
		try {
			stream = new PrintStream(new FileOutputStream("log.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new RequestSpecBuilder().setBaseUri(loadProperties("baseUrl")).addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(stream))
				.addFilter(ResponseLoggingFilter.logResponseTo(stream)).setContentType(ContentType.JSON).build();
	}
	
	public ResponseSpecification getResponseSpecBuilder() {
		return new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}
	
	public String loadProperties(String key) {
		Properties pro = new Properties();
		FileInputStream stream = null;
		try {
			stream = new FileInputStream("E:\\Project_Code\\RestApi\\RestAssureFrameWork\\src\\test\\java\\resources\\globalValue.properties");
			pro.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro.getProperty(key);
	}
}
