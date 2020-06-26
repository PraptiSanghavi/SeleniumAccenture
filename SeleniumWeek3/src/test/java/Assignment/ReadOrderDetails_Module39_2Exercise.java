package Assignment;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebElement;

public class ReadOrderDetails_Module39_2Exercise 
{  
	WebDriver driver;
	
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }
  
  @Test
  public void f() 
  {
	  driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	  driver.findElement(By.xpath("//a[@href='login.htm']")).click();
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Lalitha");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password123");
	  driver.findElement(By.xpath("//input[@name='Login']")).click();
	  
	  driver.findElement(By.xpath("//span[contains(.,'OrderDetails')]")).click();
	  
	  WebElement table = driver.findElement(By.xpath("//table[@class='table']"));
	  List<WebElement> rows = table.findElements(By.tagName("tr"));
	  System.out.println("Number of rows: "+ rows.size());
	  
	  for(int i=0;i<=rows.size()-1;i++)
	  {
		  System.out.println("Row: "+ i + "\n" + rows.get(i).getText());
		  List<WebElement> columns = table.findElements(By.tagName("th"));
		  for(int j=0;j<=columns.size()-1;j++)
		  {
			  System.out.println("Column: "+ j+"\n");
			  System.out.println(columns.get(j).getText());
		  }
	  }
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
