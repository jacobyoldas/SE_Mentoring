package cucumber.pages;

import cucumber.utilities.BaseMethods;
import cucumber.utilities.Driver_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class _02_HomePageElements extends BaseMethods {
  public _02_HomePageElements() {
    PageFactory.initElements(Driver_Base.getDriver(), this);
  }


  public static By successMessage = By.cssSelector ("div.custom.carousel-caption p");


  public void successMessageDisplayed() {
    String expectedResult="Welcome to Zero Online Banking";
    assertTrueValidationText(successMessage,expectedResult);
  }
}
