package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestHooks {

	@Before("@addPlace")
	public void beforeTest() {
		System.out.println("Test running");
	}
	
	@After("@addPlace")
	public void afterTest() {
		System.out.println("Completed running");
	}
}
