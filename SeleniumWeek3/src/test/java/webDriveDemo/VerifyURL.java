package webDriveDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class VerifyURL 
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
	  driver.get("https://en.wikipedia.org/wiki/Main_Page");
	  
	  //store runtime page title
	  System.out.println("Home Page Title - "+ driver.getTitle());
	  assertEquals(driver.getTitle(), "Wikipedia, the free encyclopedia");
	  
	  driver.findElement(By.linkText("Biography")).click();
	  assertEquals(driver.getTitle(), "Portal:Biography - Wikipedia");
	  
	  //Returns current page URL
	  System.out.println("Current page URL is: " + driver.getCurrentUrl());
	  
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
