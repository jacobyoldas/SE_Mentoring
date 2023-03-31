package cucumber.utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BaseMethods {

  WebDriverWait wait = new WebDriverWait(Driver_Base.getDriver(), Duration.ofSeconds(15));
  WebDriver driver = Driver_Base.getDriver();

  public void sendKeys(By locator, String value) {

    driver.findElement(locator).sendKeys(value);
  }

  public void click(By locator) {
    waitUntilElementVisibleAndClickable(locator);
    driver.findElement(locator).click();
  }

  public void selectFunctionByValue(By locator, String text) {
    waitUntilElementVisibleAndClickable(locator);
    waitUntilElementVisibleAndClickable(locator);
    Select select = new Select(driver.findElement(locator));
    select.selectByValue(text);
  }

  public void hoverOver(By locator) {
    WebElement element = driver.findElement(locator);
    Actions action = new Actions(driver);
    action.moveToElement(element).perform();
  }

  public String getTextByText(By locator) {
    waitUntilElementVisibleAndClickable(locator);
    return driver.findElement(locator).getText().trim();
  }

  public String getAttributeText(By locator, String attribute) {
    waitUntilElementVisibleAndClickable(locator);
    String text = driver.findElement(locator).getAttribute(attribute).trim();
    return text;
  }

  public List<String> getList(By locator) {
    List<String> returnList = new ArrayList<>();
    List<WebElement> list = driver.findElements(locator); // s
    for (WebElement element : list) {
      returnList.add(element.getText());
    }
    return returnList;
  }

  public List<String> getListByAttribute(By locator, String attribute) {
    waitUntilElementVisibleAndClickable(locator);
    List<String> returnList = new ArrayList<>();
    List<WebElement> list = driver.findElements(locator);
    for (WebElement element : list) {
      returnList.add(element.getAttribute(attribute).trim());
    }
    return returnList;
  }

  public boolean isPresent(By locator) {
    waitUntilElementVisibleAndClickable(locator);
    return driver.findElement(locator).isDisplayed();
  }

  public boolean isSelected(By locator) {
    waitUntilElementVisibleAndClickable(locator);
    return driver.findElement(locator).isSelected();
  }

  public boolean isNotSelected(By locator) {
    boolean found = false;
    waitUntilElementVisibleAndClickable(locator);
    found = driver.findElement(locator).isSelected();
    return !found;
  }

  public void assertTrueValidationText(By locator, String text) {
    waitUntilElementVisibleAndClickable(locator);
    Assert.assertTrue(driver.findElement(locator).getText().toLowerCase().contains(text.toLowerCase()));
  }

  public void scrollIntoView(By locator) {
    waitUntilElementVisibleAndClickable(locator);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", locator);
  }

  public void waitUntilElementVisibleAndClickable(By locator) {
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(locator)));
    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
  }

  public static void setWait(int second) {
    try {
      Thread.sleep(second * 1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
