package Assignment;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Module41_Exercise 
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
	  
	  WebElement about = driver.findElement(By.xpath("//span[contains(.,'AboutUs')]"));
	 
	  Actions a1 = new Actions(driver);
	  a1.moveToElement(about).click().build().perform();
	  a1.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Our')]"))).click().build().perform();
	  a1.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Chennai')]"))).click().build().perform();
	  
	  Set<String> set = driver.getWindowHandles();
	  for(String string:set)
	  {
		  driver.switchTo().window(string);
	  }
			  
	  driver.switchTo().frame(driver.findElement(By.name("main_page")));
	  
	  String address = driver.findElement(By.tagName("address")).getText();
	  System.out.println(address);
	  Assert.assertTrue(address.contains("Chennai"));
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
