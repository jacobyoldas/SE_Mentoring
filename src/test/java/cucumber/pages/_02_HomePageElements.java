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
  public static final By payeeName = By.xpath( "//input[@id='np_new_payee_name']");
  public static final By payeeAddress = By.xpath("//textarea[@id='np_new_payee_address']");
  public static final By account = By.xpath("//input[@id='np_new_payee_account']");
  public static final By payeeDetails = By.xpath("//input[@id='np_new_payee_details']");
  public static final By addButton = By.id("add_new_payee");
  public static final By successMessage = By.cssSelector("div[id='alert_content']");
  public static final By onlineBankingMenu = By.id("onlineBankingMenu");
  public static final By payBills = By.id("pay_bills_link");
  public static final By addNewPayee = By.xpath("//a[text()='Add New Payee']");


  public void addNewPayee(String s, String s1, String s2, String s3) {
    sendKeys(payeeName,s);
    sendKeys(payeeAddress,s1);
    sendKeys(account,s2);
    sendKeys(payeeDetails,s3);
    click(addButton);
  }

  public void validateSuccessfully() {

    assertTrueValidationText(successMessage,"successfully");
  }

  public void successMessageDisplayed() {
    String expectedResult="Welcome";

    assertTrueValidationText(loginSuccessMessage,expectedResult);
  }
}
