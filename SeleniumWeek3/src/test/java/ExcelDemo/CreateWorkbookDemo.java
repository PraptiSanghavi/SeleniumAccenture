package ExcelDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class CreateWorkbookDemo 
{
  @Test
  public void f() throws IOException 
  {
	  //create blank Workbook
	  XSSFWorkbook wbObj = new XSSFWorkbook();
	  
	  //Create file DemoDDT
	  FileOutputStream outObj = new FileOutputStream(new File("Demo.xlsx"));
	  
	  //to perform Write operation on Workbook
	  wbObj.write(outObj);
	  outObj.close();
	  System.out.println("DemoDDT create successfully!");
  }
}
