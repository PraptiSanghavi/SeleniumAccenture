package webDriveDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DemoNavigation 
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
	  driver.get("https://www.google.com/");
	  Thread.sleep(3000);
	  assertEquals(driver.getTitle(), "Google");
	  System.out.println("Current page URL is: " + driver.getCurrentUrl());
	  
	  driver.navigate().to("https://www.selenium.dev/");
	  assertEquals(driver.getTitle(), "SeleniumHQ Browser Automation");
	  System.out.println("Current page URL is: " + driver.getCurrentUrl());
	  Thread.sleep(3000);
	  
	  driver.navigate().back();
	  assertEquals(driver.getTitle(), "Google");
	  System.out.println("Current page URL is: " + driver.getCurrentUrl());
	  Thread.sleep(3000);
	  
	  driver.navigate().forward();
	  assertEquals(driver.getTitle(), "SeleniumHQ Browser Automation");
	  System.out.println("Current page URL is: " + driver.getCurrentUrl());
	  Thread.sleep(3000);
	  
	  driver.navigate().refresh();
	  assertEquals(driver.getTitle(), "SeleniumHQ Browser Automation");
	  System.out.println("Current page URL is: " + driver.getCurrentUrl());
	  Thread.sleep(3000);
	  
	  System.out.println("Page Refreshed");
	  System.out.println(driver.getPageSource());
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
