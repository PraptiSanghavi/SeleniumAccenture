package Assignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class TestProductSearch_Module40_Exercise 
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
  public void f() throws InterruptedException 
  {
	  driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	  
	  WebElement searchBox = driver.findElement(By.xpath("//input[@id='myInput']"));
	  Actions act = new Actions(driver);
	  
	  act.keyDown(searchBox, Keys.SHIFT).perform();
	  act.sendKeys("w").pause(2000).sendKeys("e").pause(2000).sendKeys("a").pause(2000).sendKeys("r").build().perform();
	  Thread.sleep(3000);
	  
	  WebElement summerWear = driver.findElement(By.xpath("(//div[contains(.,'Summer wear')])[4]"));
	  act.moveToElement(summerWear).click().build().perform();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("//input[@type='submit']"));
	  Thread.sleep(3000);
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
