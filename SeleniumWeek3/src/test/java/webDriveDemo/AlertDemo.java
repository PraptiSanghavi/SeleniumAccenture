package webDriveDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AlertDemo 
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

	@Test(priority=1)
	public void alertWithOk() 
	{
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.xpath("//a[@href='#OKTab']")).click();
		driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();

		Alert alertBox = driver.switchTo().alert();

		String alertMsg = alertBox.getText();
		System.out.println("Alert Message: "+ alertMsg);

		//Ok Button
		alertBox.accept();
	}

	@Test(priority=2)
	public void alertWithOkCancel()
	{
		driver.navigate().to("http://demo.automationtesting.in/Alerts.html");

		driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		Alert alertBox = driver.switchTo().alert();

		String alertMsg = alertBox.getText();
		System.out.println("Alert Message: "+ alertMsg);

		//Cancel Button
		alertBox.dismiss();
	}

	@Test(priority=3)
	public void alertWithTextbox()
	{
		driver.navigate().to("http://demo.automationtesting.in/Alerts.html");

		driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

		Alert alertBox = driver.switchTo().alert();
		String alertMsg = alertBox.getText();
		System.out.println("Alert Message: "+ alertMsg);

		alertBox.sendKeys("Prapti");
		alertBox.accept();





	}

	@AfterTest
	public void afterTest() 
	{
	}

}
