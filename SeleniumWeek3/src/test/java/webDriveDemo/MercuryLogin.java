package webDriveDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class MercuryLogin 
{
	//instance of WebDriver
	WebDriver driver;
  
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
	  //open chrome driver
	  driver = new ChromeDriver();
	  //to maximize the chrome browser
	  driver.manage().window().maximize();
  }

  @Test
  public void login() throws InterruptedException 
  {
	  driver.get("http://www.newtours.demoaut.com/");
	  driver.findElement(By.name("userName")).sendKeys("mercury");
	  driver.findElement(By.name("password")).sendKeys("mercury");
	  driver.findElement(By.name("login")).click();
	  
	  Thread.sleep(3000);
	  driver.findElement(By.linkText("SIGN-OFF")).click();
  }
  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
