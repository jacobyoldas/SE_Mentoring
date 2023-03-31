package cucumber.ApachePOI;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class _01_ApachePOIGetAllData {
  // Todo: These classes are integration testing for DDT
  //  Check out these codes and do code review with peers
  public static void main(String[] args) throws IOException {

    String path="src/test/java/cucumber/ApachePOI/Resources/ApacheExcel22.xlsx";
    FileInputStream inputStream=new FileInputStream(path);
    Workbook workbook= WorkbookFactory.create(inputStream);
    Sheet sheet = workbook.getSheet("Sheet1");

    // gives total row count
    int rowCount=sheet.getPhysicalNumberOfRows();

    for (int i = 0; i < rowCount; i++) {
      Row row= sheet.getRow(i);
      int cellCount = row.getPhysicalNumberOfCells();
      for (int j = 0; j < cellCount; j++) {
        Cell hucre = row.getCell(j);
        System.out.print(hucre+" ");
      }
      System.out.println();
    }
  }
}
