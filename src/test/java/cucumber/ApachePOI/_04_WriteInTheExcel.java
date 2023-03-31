package cucumber.ApachePOI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class _04_WriteInTheExcel {

  public static void main(String[] args) throws IOException {

    String path="src/test/java/ApachePOI/Resources/WriteInTheExcelFile.xlsx";
    FileInputStream inputStream=new FileInputStream(path);
    Workbook workbook= WorkbookFactory.create(inputStream);
    Sheet sheet=workbook.getSheet("Sheet1");


    Row row= sheet.createRow(0);
    Cell cell= row.createCell(0);
    cell.setCellValue("Hello World");
    for (int i = 1; i < 10 ; i++) {
      row.createCell(i).setCellValue(i);
    }

    inputStream.close();


    FileOutputStream outputStream=new FileOutputStream(path);

    workbook.write(outputStream);
    workbook.close();
    outputStream.close();
    System.out.println("Process completed");
  }
}

