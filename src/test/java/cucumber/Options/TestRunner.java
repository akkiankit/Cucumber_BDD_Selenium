package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
		features="src/test/java/features",
		plugin="json:target/jsonReports/cucumber-report.json",
		glue ="stepDefinations"
		,tags ="@tc4"
		
		)

public class TestRunner {
	
	
	

}
