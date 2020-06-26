package webDriveDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class FrameDemo 
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
  public void f() throws InterruptedException 
  {
	  driver.get("https://selenium.dev/selenium/docs/api/java/index.html");
	  
	  driver.switchTo().frame(0);
	  Thread.sleep(3000);
	  
	  driver.findElement(By.linkText("org.openqa.selenium.chrome")).click();
	  Thread.sleep(3000);
	  System.out.println(driver.getTitle());
	  
	  //Switch to Main Page
	  driver.switchTo().defaultContent();
	  Thread.sleep(3000);
	  
	  driver.switchTo().frame("packageFrame");
	  Thread.sleep(3000);
	  
	  driver.findElement(By.linkText("ChromeDriver")).click();
	  Thread.sleep(3000);
	  System.out.println(driver.getTitle());
	  
	  //Switch to Main Page
	  driver.switchTo().defaultContent();
	  Thread.sleep(2000);
	  
	  driver.switchTo().frame("classFrame");
	  Thread.sleep(3000);
	  
	  driver.findElement(By.linkText("HasCapabilities")).click();
	  Thread.sleep(2000);
	  System.out.println(driver.getTitle());
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
