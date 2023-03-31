package cucumber.stepDefinitions;

import cucumber.pages._01_LoginPageElements;
import cucumber.utilities.Driver_Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Driver_Hooks {

  WebDriver driver = Driver_Base.getDriver();

  _01_LoginPageElements lp = new _01_LoginPageElements();



  @Before
  public void setup() {
    driver.get("http://zero.webappsecurity.com/login.html");
    driver.manage().window().maximize();
//    lp.loginNoParam();
  }

  @After
  public void tearDown(Scenario scenario) {

    System.out.println("Scenario Result = " + scenario.getStatus());

    if (scenario.isFailed()) {
      TakesScreenshot screenshot = ((TakesScreenshot) driver); // which driver to get a screenshot
      File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
      String scenarioName = scenario.getName();
      File destinationFile = new File("target/FailedScreenshots/" + scenarioName + ".png");
      try {
        FileUtils.copyFile(srcFile, destinationFile);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    Driver_Base.quitDriver();
  }
}
