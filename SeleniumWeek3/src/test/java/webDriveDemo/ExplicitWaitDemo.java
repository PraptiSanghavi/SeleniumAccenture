package webDriveDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class ExplicitWaitDemo 
{
	WebDriver driver;
 
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver","Resources/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  //it will add WAIT after each command
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  }

  @Test
  public void f() 
  {
	  driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	  driver.findElement(By.linkText("SignIn")).click();
	  driver.findElement(By.id("userName")).sendKeys("Lalitha");
	  driver.findElement(By.cssSelector("#password")).sendKeys("password123");
	  driver.findElement(By.xpath("//input[@name='Login']")).click();
	  
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignOut")));
	  driver.findElement(By.linkText("SignOut")).click();
  }
  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
