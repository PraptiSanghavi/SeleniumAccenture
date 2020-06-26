package webDriveDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class WindowsDemo 
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
	  driver.get("https://the-internet.herokuapp.com/windows");
	  System.out.println(driver.getTitle());
	  
	  String ParentWH = driver.getWindowHandle();
	  System.out.println("Parent Window Handle: "+ParentWH);
	  
	  driver.findElement(By.linkText("Click Here")).click();
	  
	  Set<String> allWH = driver.getWindowHandles();
	  for (String singleWH:allWH)
	  {
		driver.switchTo().window(singleWH);
		System.out.println("ChildWH is: "+ singleWH);
	  }
	  
	  System.out.println("Switched to Child Window");
	  System.out.println(driver.getTitle());
	  
	  System.out.println("Switching to Parent Window");
	  driver.switchTo().window(ParentWH);
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
