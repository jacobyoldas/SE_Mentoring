package cucumber.utilities;

import static cucumber.utilities.BaseMethods.setWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver_Base {
  private static WebDriver driver;

  public static WebDriver getDriver() {
    //This concept called "Singleton Driver" (we need  one driver for every class thats why its called it)

    if (driver == null) {
      // always open clean browser we dont wanna open new driver again again
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--remote-allow-origins=*"); // To solve the error with Chrome v111
      Locale.setDefault(new Locale("EN"));
      System.setProperty("user.language", "EN");
      Logger.getLogger("").setLevel(Level.SEVERE);
      System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
      System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver(options);
    }

    return driver;
  }

  public static void quitDriver(){

    if (driver != null) { // if there is driver the quit
//      setWait(5);
      driver.quit();
      driver=null; // if there is not this line then failed coz after quit driver must be null again to open
    }
  }
}
