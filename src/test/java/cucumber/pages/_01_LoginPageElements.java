package cucumber.pages;

import cucumber.utilities.BaseMethods;
import cucumber.utilities.Driver_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _01_LoginPageElements extends BaseMethods {


  public _01_LoginPageElements() {
    PageFactory.initElements(Driver_Base.getDriver(), this);
  }

//  @FindBy(id = "input#user_login")
//  private WebElement usernameInput;
//
//  @FindBy(id = "input#user_password")
//  private WebElement passwordInput;
//
//  @FindBy(id = "//input[@value='Sign in']")
//  private WebElement signInButton;
//

  private static final By usernameInput = By.cssSelector ("input[name='user_login']");
  private static final By passwordInput = By.cssSelector ("input[name='user_password']");
  public static final By signInButton = By.xpath ("//input[@value='Sign in']");


  public By getUsernameInput(){
    return usernameInput;
  }
  public By getPasswordInput(){
    return passwordInput;
  }


  public void loginNoParam() {
    sendKeys(usernameInput,"username");
    sendKeys(passwordInput,"password");
    click(signInButton);
  }
}
