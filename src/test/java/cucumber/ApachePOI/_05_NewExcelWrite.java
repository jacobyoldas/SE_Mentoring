package cucumber.ApachePOI;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class _05_NewExcelWrite {

  public static void main(String[] args) throws IOException {

    XSSFWorkbook workbook=new XSSFWorkbook();
    XSSFSheet sheet=workbook.createSheet("Sheet1");

    Row row= sheet.createRow(0);
    Cell cell= row.createCell(0);
    cell.setCellValue("Hi World");

    for (int i = 1; i < 10 ; i++) {
      row.createCell(i).setCellValue(i);
    }

    String newExcelPath="src/test/java/ApachePOI/Resources/NewExcel.xlsx";
    FileOutputStream outputStream=new FileOutputStream(newExcelPath);
    workbook.write(outputStream);
    workbook.close();
    outputStream.close();
    System.out.println("Process completed");
  }
 }

