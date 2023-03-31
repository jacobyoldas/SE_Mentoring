package cucumber.pages;

import cucumber.utilities.BaseMethods;
import cucumber.utilities.Driver_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class _02_HomePageElements extends BaseMethods {
  public _02_HomePageElements() {
    PageFactory.initElements(Driver_Base.getDriver(), this);
  }


  public static By loginSuccessMessage = By.cssSelector ("div.custom.carousel-caption p");



  public void successMessageDisplayed() {
    String expectedResult="Welcome";

    assertTrueValidationText(loginSuccessMessage,expectedResult);
  }
}
