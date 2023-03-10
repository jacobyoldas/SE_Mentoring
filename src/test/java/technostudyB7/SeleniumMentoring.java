package technostudyB7;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumMentoring extends BasePOM{


  public static void main(String[] args) {

    setDriver();

    clickLinksSubCategory("Input Forms", "Select Dropdown List");

    List<String> expectedList = Arrays.asList("Please select", "Sunday", "Monday", "Tuesday",
        "Wednesday", "Thursday", "Friday", "Saturday");

    List<String> actualList = getActualDropDownLists();

    if (expectedList.equals(actualList)) {
      System.out.println("Passed");
    } else {
      System.out.println("Fail");
    }

    quitDriver();

  }

  @Test(description = "Validation of Dropdown List")
  public void dropDownTest(){

    clickLinksSubCategory("Input Forms", "Select Dropdown List");

    List<String> expectedList = Arrays.asList( "Sunday", "Monday", "Tuesday",
        "Wednesday", "Thursday", "Friday", "Saturday");

    List<String> actualList = getActualDropDownLists();
    Assert.fail("Logged Defect : SGP-13 ");
    Assert.assertEquals(expectedList,actualList,"Failed to get drop down list");

    }

}
