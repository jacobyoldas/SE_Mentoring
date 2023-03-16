package technostudyB7;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterLinks extends BasePOM{


  @Test(description = "Validation of Footer Links")
  public void TC3_FooterLinks() {

    // verify there are links  part

    List<String> expectedList = Arrays.asList("Selenium Tutorials", "TestNG Tutorial",
        "JUnit Tutorial", "JXL Tutorial",
        "Apache POI", "ANT Tutorial", "Maven Tutorial");

    List<String> actualFooterLinks = BasePOM.getActualFooterLinkLists();

    Assert.assertEquals(expectedList, actualFooterLinks, "Failed to get footer links");

    // verify the link functionality works
    // key-> value
    //HasMap : Using unorder
    //TreeMap : Using key's natural order
    //LinkedHashMap : Using insertion order

    LinkedHashMap<String, String> links = new LinkedHashMap<>();

    Collection<String> keyLinks = links.keySet(); // get the links
    Collection<String> valueLinks = links.values(); // get the value

    links.put("Selenium Tutorials", "selenium Tutorials");
    links.put("TestNG Tutorial", "testng-tutorials");
    links.put("JUnit Tutorial", "jUnit Tutorial");
    links.put("JXL Tutorial", "jXL Tutorial");
    links.put("Apache POI", "apache POI");
    links.put("ANT Tutorial", "ant Tutorial");
    links.put("Maven Tutorial", "maven Tutorial");

    for (String link : keyLinks) {

      clickLinks(link);

      String expectedPageHeader = links.getOrDefault(link, String.valueOf(valueLinks));

      String actualPageHeader = BasePOM.getPageHeader();

      Assert.assertEquals(actualPageHeader, expectedPageHeader);

      driver.navigate().back();

    }

  }

}



