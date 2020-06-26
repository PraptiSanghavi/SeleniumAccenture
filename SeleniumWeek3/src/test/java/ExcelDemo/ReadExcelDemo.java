package ExcelDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelDemo 
{
  @Test
  public void f() throws IOException 
  {
	  File src = new File("src/test/java/myFiles/Login.xlsx");
	  
	  //To read the file
	  FileInputStream fisObj = new FileInputStream(src);
	  
	  //To work on Workbook
	  XSSFWorkbook wb = new XSSFWorkbook(fisObj);
	  
	  //To work on Sheet which is available in workbook
	  XSSFSheet sheet = wb.getSheetAt(0);
	  
	  //Find number of rows in the sheet
	  int rowCount = sheet.getLastRowNum();
	  System.out.println("Total Number of Rows: "+rowCount);
	  
	  //execute for loop till rowCount
	  for(int i=0;i<=rowCount;i++)
	  {
		  //we want to print values
		  //in this particular sheet
		  //for first column..CAPTURE FIRST ROW, then cell and get value of that cell
		  String dataCol1 = sheet.getRow(i).getCell(0).getStringCellValue();
		  System.out.println("Data from First Column is: "+dataCol1);
		  
		  //for second column...
		  String dataCol2 = sheet.getRow(i).getCell(1).getStringCellValue();
		  System.out.println("Data from Second Column is: "+dataCol2);
	  }
	  wb.close();
  }
}
