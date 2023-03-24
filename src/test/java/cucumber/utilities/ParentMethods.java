package cucumber.utilities;

import static cucumber.pages._01_LoginPageElements.signInButton;
import cucumber.pages._01_LoginPageElements;

public class ParentMethods extends BaseMethods{

  _01_LoginPageElements lp =new _01_LoginPageElements();

  public void login(String username, String password) {

    sendKeys(lp.getUsernameInput(),username);
    sendKeys(lp.getPasswordInput(),password);
    click(signInButton);
  }

}
