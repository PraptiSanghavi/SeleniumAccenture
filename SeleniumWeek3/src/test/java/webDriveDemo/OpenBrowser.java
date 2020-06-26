package webDriveDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OpenBrowser 
{
	WebDriver driver;

	@BeforeTest
	public void beforeTest() 
	{
	
		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		//open chrome browser
		driver = new ChromeDriver();
		//to maximize the window
		driver.manage().window().maximize();
	}
	
	@Test
	public void f() throws InterruptedException 
	{
		//navigate to website
		driver.get("https://mvnrepository.com/");
		//wait for 3 seconds
		Thread.sleep(3000);
	}

	@AfterTest
	public void afterTest() 
	{
		//close the browser
		driver.close();
	}

}
