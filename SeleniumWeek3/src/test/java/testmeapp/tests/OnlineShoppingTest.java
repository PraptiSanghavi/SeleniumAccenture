package testmeapp.tests;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testmeapp.utility.Drivers;

public class OnlineShoppingTest 
{
	WebDriver driver;
	//builds a new report using the HTML template 
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	//helps to generate the logs in test report.
	ExtentTest logger;
	String expected,actual;

	@BeforeTest
	public void startReportBeforeTest()
	{
		driver = Drivers.getDriver("chrome");
		driver.manage().window().maximize();

		// initialize the HtmlReporter
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") 
				+ "/extent-reports/" + new SimpleDateFormat("hh-mm-ss-ms-dd-MM-yyyy")
				.format(new Date()) + ".html");
		
		//initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//To add system or environment info by using the setSystemInfo method.
		extent.setSystemInfo("Host Name", "GFT NexGen Testing Stream");
		extent.setSystemInfo("Environment", "Automation Testing Selenium");
		extent.setSystemInfo("User Name", "Pratiksha Daptare");

		//configuration items to change the look and feel
        //add content, manage tests etcs
		htmlReporter.config().setDocumentTitle("AGP-BatchReport");
		htmlReporter.config().setReportName("AGP-Batch-extentReport");
		htmlReporter.config().setTheme(Theme.STANDARD);	
	}

	@Test(priority = 1, description="Performs a successful User registration")
	public void testRegistration() throws InterruptedException 
	{
		logger = extent.createTest("TestRegistration");

		//driver.get("http://172.31.36.202:443/TestMeApp/fetchcat.htm");
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
		driver.findElement(By.linkText("SignUp")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("userName"))));

		driver.findElement(By.name("userName")).sendKeys("Amu2000");
		driver.findElement(By.name("firstName")).sendKeys("Amu");
		driver.findElement(By.name("lastName")).sendKeys("Shah");
		driver.findElement(By.name("password")).sendKeys("qwerty09");
		driver.findElement(By.name("confirmPassword")).sendKeys("qwerty09");
		driver.findElement(By.xpath("//span[contains(.,'Female')]")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("amu2000@gmail.com");
		driver.findElement(By.name("mobileNumber")).sendKeys("9712354295");
		driver.findElement(By.name("dob")).sendKeys("09/08/1970");
		driver.findElement(By.name("address")).sendKeys("B-1 Prabhupujan Flats, Near Navroji Hall, Dafnala Road, Thane, Mumbai");

		Select securityQue = new Select(driver.findElement(By.xpath("//select[@name='securityQuestion']")));
		  securityQue.selectByValue("411010");
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.findElement(By.name("Submit")).isDisplayed());
		driver.findElement(By.name("Submit")).click();
		
		
	}
	
	@Test(priority = 2, description="Performs successful registered user login")
	public void testLogin() 
	{
		logger = extent.createTest("TestLogin");

		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
		driver.findElement(By.linkText("SignIn")).click();

		driver.findElement(By.name("userName")).sendKeys("Amu2000");
		driver.findElement(By.name("password")).sendKeys("qwerty09");
		driver.findElement(By.name("Login")).click();
		
		actual = "SignOut";
		expected = driver.findElement(By.xpath("//a[@href='logout.htm']")).getText();
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 3, description="Performs successfully adding products to the Cart by the registered user")
	public void testCart() throws InterruptedException 
	{
		logger = extent.createTest("TestCart");
		
		driver.findElement(By.name("products")).sendKeys("Carpet");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		driver.findElement(By.partialLinkText("Add to cart")).click();
		driver.findElement(By.partialLinkText("Cart")).click();
		
	}

	@Test(priority = 4, description = "Performs successful payment by the registered user")
	public void testPayment() throws InterruptedException 
	{
		logger = extent.createTest("TestPayment");

		driver.findElement(By.partialLinkText("Checkout")).click();
		driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(), 'Andhra Bank')]")).click();
		driver.findElement(By.xpath("//a[@id='btn']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@456");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
		driver.findElement(By.xpath("//input[@value='PayNow']")).click();
		
		actual = "Your order has been confirmed";
		expected = driver.findElement(By.xpath("//p[contains(.,'Your order has been confirmed')]")).getText();
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void getResultAfterMethod(ITestResult result)
	{	
		if(result.getStatus() == ITestResult.FAILURE) 
		{
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case FAILED", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case FAILED", ExtentColor.RED));
		}
		else if(result.getStatus() == ITestResult.SUCCESS) 
		{
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" -Test Case PASSED ", ExtentColor.GREEN));
		}
		else if (result.getStatus() == ITestResult.SKIP)
		{
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case SKIPPED", ExtentColor.ORANGE));
		}
	}

	@AfterTest
	public void endReportAfterTest()
	{
		//to write or update test information to reporter
		extent.flush();
		
		driver.close();
	}

}
