package cucumber.stepDefinitions;

import static cucumber.pages._02_HomePageElements.*;

import cucumber.pages._02_HomePageElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _03_AddNewPayee {

  _02_HomePageElements hp =new _02_HomePageElements();

  @And("User navigate to online banking page")
  public void userNavigateToOnlineBankingPage() {
    hp.click(onlineBankingMenu);
  }

  @When("Click pay bills module")
  public void clickPayBillsModule() {
    hp.click(payBills);
  }

  @Then("Click add new payee module")
  public void clickAddNewPayeeModule() {
    hp.click(addNewPayee);
  }

  @When("User enter {string} and {string}and {string} and {string}")
  public void userEnterAndAndAnd(String arg0, String arg1, String arg2, String arg3) {
    hp.sendKeys(payeeName,arg0);
    hp.sendKeys(payeeAddress,arg1);
    hp.sendKeys(account,arg2);
    hp.sendKeys(payeeDetails,arg3);
    hp.click(addButton);
  }

  @Then("Success message should be displayed")
  public void successMessageShouldBeDisplayed() {
    hp.validateSuccessfully();
  }
}
