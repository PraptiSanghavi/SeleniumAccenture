package Assignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class NewUserRegistration_Module39_1Exercise 
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
	  driver.get("https://lkmdemoaut.accenture.com/TestMeApp/RegisterUser.htm");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("PraptiSan");
	  driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Prapti");
	  driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Sanghavi");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("poojapooja");
	  driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("poojapooja");
	  driver.findElement(By.xpath("//span[contains(.,'Female')]")).click();
	  driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("prapti@gmail.com");
	  driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys("8900098000");
	  driver.findElement(By.xpath("//input[@name='dob']")).sendKeys("11/08/1996");
	  driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("Thane, Mumbai");
	  
	  Select securityQue = new Select(driver.findElement(By.id("securityQuestion")));
	  securityQue.selectByValue("411010");
	  driver.findElement(By.name("answer")).sendKeys("Mumbai");
	    
	  driver.findElement(By.xpath("//input[@name='Submit']")).submit();
	  
  }
  
  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
