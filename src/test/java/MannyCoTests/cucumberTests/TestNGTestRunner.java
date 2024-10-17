package MannyCoTests.cucumberTests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/MannyCoTests/cucumberTests",glue="MannyCoTest.StepDefs", monochrome=true, tags="@ErrorTest", plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	
	
}
