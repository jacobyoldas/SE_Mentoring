package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePOM {

  static WebDriver driver;
  static WebDriverWait wait;
  static WebElement element;

  @BeforeMethod
  public static void setDriver(){

    WebDriverManager.chromedriver().setup();

    driver = new ChromeDriver();

    driver.manage().window().maximize();

    wait= new WebDriverWait(driver,Duration.ofSeconds(15));

    driver.get("http://demo.seleniumeasy.com/");
  }

  @AfterMethod
  public static void quitDriver() {

    if (driver!= null) // That means  if there is still driver then quit
      driver.quit();
    System.out.println("Test is Done");
  }

  public static void setWait(int second) {
    try {
      Thread.sleep(second* 1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public static void clickLinksSubCategory(String category, String subCategory)
  {
    element = driver.findElement(
        By.xpath("//div[@id='navbar-brand-centered']//a[contains(text(),'" + category + "')]"));

    element.click();


    element = driver.findElement(
        By.xpath("//div[@id='navbar-brand-centered']//a[contains(text(),'" + subCategory + "')]"));

    element.click();

  }

  public static void clickLinks(String category) {

    element = driver.findElement(
        By.xpath("//a[contains(text(),'" + category + "')]"));

    element.click();

  }

  public static List<String> getActualDropDownLists() {

    element = driver.findElement(By.id("select-demo"));

    Select select= new Select(element);

    List<String> textOptions = new ArrayList<>();

    for ( WebElement option: select.getOptions()) {
      textOptions.add(option.getText());
    }
    return textOptions;

  }

  public static void waitUntilElementVisibleAndClickable(){
    wait.until(ExpectedConditions.visibilityOf(element));
    wait.until(ExpectedConditions.visibilityOfAllElements(element));
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  public static void scrollToElement(){
    JavascriptExecutor js= (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", element);
    setWait(3);
    //js.executeScript("window.scrollBy(0,1000)");
//    js.executeScript("arguments[0].scroll(0,3000);", element);
//    js.executeScript("arguments[0].click();", element);

  }

  public static List<String> getActualFooterLinkLists() {

    List<String> returList=new ArrayList<>();

    List<WebElement> elements =driver.findElements(By.cssSelector("body  footer  div  div:nth-child(1)  ul  li a"));
    for ( WebElement links : elements ) {
      returList.add(links.getText());
    }
    return returList;
  }

  public static String getPageHeader() {

    element = driver.findElement(By.cssSelector("h1,h2,h3,p"));

    return element.getText().trim();

  }
}
