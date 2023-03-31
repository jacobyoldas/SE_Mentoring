package cucumber.Runners;

import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;


@CucumberOptions(
    tags = "@LoginSuccess",
    features = {"src/test/java/FeatureFiles/"},
    glue = {"StepsDefinitions"}
)
@Listeners({ExtentITestListenerClassAdapter.class})

public class _04_TestRunnerExtentReport extends AbstractTestNGCucumberTests {

  @AfterClass
  public static void writeExtentReport() {
    ExtentService.getInstance().setSystemInfo("User Name", "Yoldas");
    ExtentService.getInstance().setSystemInfo("Application Name", "Luma");
    ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name"));
    ExtentService.getInstance().setSystemInfo("Department", "QA");
  }
}
