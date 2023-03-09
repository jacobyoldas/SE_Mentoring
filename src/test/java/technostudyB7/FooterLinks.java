package technostudyB7;

import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;

public class FooterLinks extends BasePOM{


  @Test(description = "Validation of Footer Links")
  public void TC3_FooterLinks(){

    List<String> expectedList = Arrays.asList("Selenium Tutorials", "TestNG Tutorial","JUnit Tutorial","JXL Tutorial",
        "Apache POI","ANT Tutorial","Maven Tutorial");

    List<String>  actualFooterLinks= BasePOM.getActualFooterLinkLists();

  }


}
