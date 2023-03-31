package cucumber.stepDefinitions;

import cucumber.pages._01_LoginPageElements;
import cucumber.pages._02_HomePageElements;
import cucumber.utilities.Driver_Base;
import cucumber.utilities.ParentMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import java.util.List;

public class _01_LoginSteps {

  _01_LoginPageElements lp = new _01_LoginPageElements();
  ParentMethods pm = new ParentMethods();

  _02_HomePageElements hp = new _02_HomePageElements();


  @When("User enter valid {string} and {string}")
  public void userEnterValidAnd(String username, String password) {

    pm.login(username, password);
    Driver_Base.getDriver().navigate().back();

  }

  @When("User enter invalid username or invalid password")
  public void userEnterInvalidUsernameOrInvalidPassword(DataTable table) {

    List<List<String>> lists = table.asLists(String.class);

//    lp.userEnterInvalidData(lists.get(0).get(0), lists.get(0).get(1));
//    lp.unSuccessMessageDisplayed();

//    lp.userEnterInvalidData(lists.get(1).get(0), lists.get(1).get(1));
//    lp.unSuccessMessageDisplayed();

//    lp.userEnterInvalidData(lists.get(2).get(0), lists.get(2).get(1));
//    lp.unSuccessMessageDisplayed();

    for (List<String> data : lists) {

      lp.userEnterInvalidData(data.get(0), data.get(1));

      lp.unSuccessMessageDisplayed();
    }

  }

  @Then("User should NOT login and receive error message")
  public void userShouldNOTLoginAndReceiveErrorMessage() {
    lp.unSuccessMessageDisplayed();
  }

  @Then("User should login successfully")
  public void userShouldLoginSuccessfully() {

    hp.successMessageDisplayed();

  }

}
