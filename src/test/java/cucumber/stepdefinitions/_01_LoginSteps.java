package cucumber.stepdefinitions;

import cucumber.pages._01_LoginPageElements;
import cucumber.pages._02_HomePageElements;
import cucumber.utilities.Driver_Base;
import cucumber.utilities.ParentMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _01_LoginSteps {

  _01_LoginPageElements lp = new _01_LoginPageElements();
  ParentMethods pm = new ParentMethods();

  _02_HomePageElements hp = new _02_HomePageElements();


  @When("User enter valid {string} and {string}")
  public void userEnterValidAnd(String username, String password) {

    pm.login(username,password);
    Driver_Base.getDriver().navigate().back();

  }

  @Then("User should login successfully")
  public void userShouldLoginSuccessfully() {

    hp.successMessageDisplayed();


  }

}
