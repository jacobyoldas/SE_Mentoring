package cucumber.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    tags = "@SmokeTest",
    features = {"src/test/java/cucumber/featueFiles/"},
    glue = {"stepDefinitions"}

)
public class _01_TestRunner extends AbstractTestNGCucumberTests {
}
