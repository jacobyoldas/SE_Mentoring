package cucumber.utilities;

import io.cucumber.java.Scenario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

// todo: Check out these codes and do code review with peers

  public static ArrayList< ArrayList< String > > getListData(String path, String sheetName, int columnCount){
    ArrayList<ArrayList< String >> data=new ArrayList<>();

    Workbook workbook=null;
    try {
      FileInputStream inputStream = new FileInputStream(path);
      workbook= WorkbookFactory.create(inputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    Sheet sheet=workbook.getSheet(sheetName);

    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
      ArrayList<String> rowData=new ArrayList<>();
      for (int j = 0; j < columnCount; j++) {
      //  if (sheet.getRow(i).getPhysicalNumberOfCells()!=0) //to not get null
        rowData.add(sheet.getRow(i).getCell(j).toString());
      }
      data.add(rowData);
    }
    return data;
  }

  public static void writeExcel(String path, Scenario scenario, String browserName, String date) {

    File file=new File(path);

    if (!file.exists()){  // file is not exist
      XSSFWorkbook workbook = new XSSFWorkbook();
      XSSFSheet sheet = workbook.createSheet("Sheet1");
      Row newRow = sheet.createRow(0);

      Cell newCell = newRow.createCell(0);
      newCell.setCellValue(scenario.getName());

      newCell = newRow.createCell(1);
      newCell.setCellValue(scenario.getStatus().toString());

      newCell = newRow.createCell(2);
      newCell.setCellValue(browserName);

      newCell = newRow.createCell(3);
      newCell.setCellValue(date);
      try {
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    else // if there is file then do these
    {
      FileInputStream inputStream= null;
      Workbook workbook=null;
      try {
        inputStream = new FileInputStream(path);
        workbook= WorkbookFactory.create(inputStream);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      Sheet sheet=workbook.getSheetAt(0);

      int rowCount = sheet.getPhysicalNumberOfRows();
      Row newRow = sheet.createRow(rowCount);

      Cell newCell = newRow.createCell(0);
      newCell.setCellValue(scenario.getName());

      newCell = newRow.createCell(1);
      newCell.setCellValue(scenario.getStatus().toString());

      newCell = newRow.createCell(2);
      newCell.setCellValue(browserName);

      newCell = newRow.createCell(3);
      newCell.setCellValue(date);
      try {
        inputStream.close();
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }
  public static void main(String[] args) {
    ArrayList< ArrayList< String > > data =
        getListData("src/test/java/ApachePOI/Resources/ApacheExcel22.xlsx","testCitizen", 6);
    System.out.println("Data = " + data);
  }
}
