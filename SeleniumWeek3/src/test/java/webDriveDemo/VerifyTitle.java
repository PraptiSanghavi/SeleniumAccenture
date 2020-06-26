package webDriveDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class VerifyTitle 
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
  public void verifyTitle() throws InterruptedException 
  {
	  driver.get("http://www.newtours.demoaut.com/");
	  
	  //store runtime page title
	  String pageTitle = driver.getTitle();
	  System.out.println("Actual Result: Home Page Title - "+ pageTitle);
	  assertEquals(pageTitle, "Welcome: Mercury Tours");
	  driver.findElement(By.linkText("REGISTER")).click();
	  
	  System.out.println("Actual Result: Register Page Title -  "+ driver.getTitle());
	  assertEquals(driver.getTitle(), "Register: Mercury Tours");
	  
	  driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Prapti");
	  driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Sanghavi");
	  driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8890044822");
	  driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Thane, Mumbai");
	  driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Mumbai");
	  driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Maharashtra");
	  driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("380004");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("prapti@gmail.com");
	  driver.findElement(By.xpath("//input[@name='email']")).sendKeys("PraptiSan");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("poojapooja");
	  driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("poojapooja");
	 
	  Select countryname = new Select(driver.findElement(By.name("country")));
	  countryname.selectByIndex(8);
	  Thread.sleep(3000);
	  
	  countryname.selectByValue("6");
	  Thread.sleep(3000);
	  
	  countryname.selectByVisibleText("INDIA");
	  Thread.sleep(3000);
	  
//	  driver.findElement(By.xpath("//input[@name='register']")).submit();
	  
	  
  }
  

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
