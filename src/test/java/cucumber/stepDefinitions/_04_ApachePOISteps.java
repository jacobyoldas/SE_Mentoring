package cucumber.stepDefinitions;

import cucumber.pages._02_HomePageElements;
import cucumber.utilities.ExcelUtility;
import io.cucumber.java.en.Given;
import java.util.ArrayList;

public class _04_ApachePOISteps {

  _02_HomePageElements hp = new _02_HomePageElements();
  @Given("User create add New Payee as positive test")
  public void userCreateNewPayeeWithApachePOI() {

    // excelden oku ve citizenship i create et
    ArrayList< ArrayList< String > > data =
     ExcelUtility.getListData("src/test/java/cucumber/ApachePOI/Resources/ApacheExcel22.xlsx","AddNewPayee", 4);

    for (ArrayList< String > row:data ){
      hp.addNewPayee(row.get(0),row.get(1),row.get(2),row.get(3));
      hp.validateSuccessfully();
    }
  }

}
