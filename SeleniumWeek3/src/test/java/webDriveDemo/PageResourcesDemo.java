package webDriveDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class PageResourcesDemo 
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
	  driver.get("http://www.newtours.demoaut.com/");
	  
	  System.out.println("Home Page Title - "+ driver.getTitle());
	  assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
	  
	  //To get Page Source
	  System.out.println(driver.getPageSource());
	  
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }
}
