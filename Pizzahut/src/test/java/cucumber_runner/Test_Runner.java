package cucumber_runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/home/ganeshravi2013g/eclipse-workspace/Pizzahut/src/test/java/feature/pizzahut.feature",
		glue = "stepdefinition",
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	    monochrome = true,
		publish = true
)

public class Test_Runner {
	

}
