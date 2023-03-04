package technostudyB7;

import static technostudyB7.BasePOM.clickLinksSubCategory;
import static technostudyB7.BasePOM.getActualDropDownLists;

import java.util.Arrays;
import java.util.List;

public class SeleniumMentoring {

  /**
   * Q/A: Who/Whom responsible to create test cases/scenario/plan? Test Case "COVERAGES" and captain
   * of the ship(ownerShip)
   * <p>
   * Test Case 1 Preparation 1- Open the website 2- Test Header links(Category) is working 3- Test
   * Sub category links are working New Test Case * MAGIC TIME (Shift+Alt) *handle Thread sleep with
   * method (try-catch) * add web-driver wait * add waitUntilVisibleAndClickable method * add quit
   * driver * handle sub category (work for single and double click) * HOW TO BECOME better QA 3+ or
   * 5+ exp handling the code look (My interview EXP) Test Case 2: Dropdown list 1- Set expected
   * result/requirements 2- Get actual result/requirements 3- Validate/Verify Dropdown list is there
   * 4- Set actual result/requirements( as end user perspective) 5- Validate/Verify  expected vs.
   * actual result/requirements Test Case 3: Header And Footer 1- Set expected results 2- Get actual
   * results 3- Validate links are there 4- Validate clink functions are working
   */


  public static void main(String[] args) {

    clickLinksSubCategory("Input Forms", "Select Dropdown List");

    List<String> expectedList = Arrays.asList("Please select", "Sunday", "Monday", "Tuesday",
        "Wednesday", "Thursday", "Friday", "Saturday");

    List<String> actualList = getActualDropDownLists();

    if (expectedList.equals(actualList)) {
      System.out.println("Passed");
    } else {
      System.out.println("Fail");
    }

    //@AfterMethod and @BeforeMethod why did not work?
    // 1- I am missing a keyword
    // 2- Where/What method should I run my test?
    // 3- TestNG What's for?

  }


}
