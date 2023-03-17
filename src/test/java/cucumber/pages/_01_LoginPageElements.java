package cucumber.pages;

import cucumber.utilities.BaseMethods;
import cucumber.utilities.Driver_Base;
import org.openqa.selenium.support.PageFactory;

public class _01_LoginPageElements extends BaseMethods {


  public _01_LoginPageElements() {
    PageFactory.initElements(Driver_Base.getDriver(), this);
  }



}
