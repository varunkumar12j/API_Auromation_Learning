package Cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue= {"stepDefinations"},stepNotifications=true,monochrome=true,plugin= {"json:target/jsonReports/cucumberReport.json"})
public class TestRunner {

}
