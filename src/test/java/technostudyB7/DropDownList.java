package technostudyB7;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;

public class DropDownList extends BasePOM{

  @Test(description = "Validation of Dropdown List")
  public void dropDownTest(){

    clickLinksSubCategory("Input Forms", "Select Dropdown List");

    List<String> expectedList = Arrays.asList("Please select", "Sunday", "Monday", "Tuesday",
        "Wednesday", "Thursday", "Friday", "Saturday");

    List<String> actualList = getActualDropDownLists();

    if (expectedList.equals(actualList)) {
      System.out.println("Passed");
    } else {
      System.out.println("Fail");
    }

  }

}
