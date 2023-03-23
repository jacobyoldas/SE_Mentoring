package cucumber.utilities;

import static cucumber.pages._01_LoginPageElements.signInButton;

import cucumber.pages._01_LoginPageElements;

public class ParentMethods extends BaseMethods{


  public void login(String username, String password) {

    sendKeys(usernameInput,username);
    sendKeys(passwordInput,password);
    click(signInButton);
  }

}
