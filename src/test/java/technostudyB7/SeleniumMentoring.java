package technostudyB7;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumMentoring {


  /**
   * Q/A: Who/Whom responsible to create test cases/scenario/plan? Test Case "COVERAGES" and captain of the ship(ownerShip)

   * Test Case Preparation
   * 1- Open the website
   * 2- Test Header links(Category) is working
   * 3- Test Sub category links are working
   *New Test Case
   *  * MAGIC TIME (Shift+Alt)
   *      *handle Thread sleep with method (try-catch)
   *      * add web-driver wait
   *      * add waitUntilVisibleAndClickable method
   *      * add quit driver
   *      * handle sub category (work for single and double click)
   *      * HOW TO BECOME better QA 3+ or 5+ exp handling the code look (My interview EXP)
   *     Test Case: Dropdown list
   *      * * 1- Set expected result/requirements
   *      * * 2- Get actual result/requirements
   *      * * 3- Validate/Verify  expected vs. actual result/requirements
   *      * * 3- Set actual result/requirements
   *      * * 2- Validate/Verify  expected vs. actual result/requirements
   */

    static WebDriver driver;
    static WebDriverWait wait;


    public static void main(String[] args) {

      WebDriverManager.chromedriver().setup();

      driver = new ChromeDriver();

      driver.manage().window().maximize();

      wait= new WebDriverWait(driver,3);

      driver.get("https://demo.seleniumeasy.com/");

      setWait(3);

      clickLinksSubCategory("Input Forms","Checkbox Demo");

      clickLinksSubCategory("Input Forms","Select Dropdown List");

      List<String> expectedList= Arrays.asList("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday");





      quitDriver();




    }



    private static void quitDriver() {

      if (driver!= null) // That means  if there is still driver then quit
        driver.quit();
      System.out.println("Test is Done");
    }

    private static void setWait(int second) {
      try {
        Thread.sleep(second* 1000L);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    private static void clickLinksSubCategory(String category, String subCategory)
    {
      WebElement element = driver.findElement(
          By.xpath("//div[@id='navbar-brand-centered']//a[contains(text(),'" + category + "')]"));

      wait.until(ExpectedConditions.visibilityOf(element));
      element.click();

      setWait(3);

      WebElement element2 = driver.findElement(
          By.xpath("//div[@id='navbar-brand-centered']//a[contains(text(),'" + subCategory + "')]"));

      element2.click();

    }

    public static void clickLinks(String category) {

      WebElement element = driver.findElement(
          By.xpath("//div[@id='navbar-brand-centered']//a[contains(text(),'" + category + "')]"));

      element.click();

    }



}
