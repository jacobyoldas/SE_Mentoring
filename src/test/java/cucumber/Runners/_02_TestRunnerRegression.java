package cucumber.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
    tags = "@Regressions",
    features = {"src/test/java/FeatureFiles/"},
    glue = {"StepsDefinitions"},
    plugin= {"html:target/site/cucumber-regression-reports.html"}
)
public class _02_TestRunnerRegression extends AbstractTestNGCucumberTests {

}
