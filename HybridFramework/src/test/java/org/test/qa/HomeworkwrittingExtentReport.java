package org.test.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class HomeworkwrittingExtentReport {
WebDriver driver;
	
	ExtentSparkReporter spark1;
	ExtentReports extent;
	ExtentTest test;
	static SoftAssert soft;
	
	@BeforeSuite     
	public void setup() {

	   ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Framework\\HybridFramework\\Reports\\Extent1.html");
		spark.config().setDocumentTitle("Automation Reporting Test");
		spark.config().setReportName("ExtentReport");
		spark.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		extent.setSystemInfo("Tester", "Laxmi");
		extent.setSystemInfo("Environment", "QA");
	}
	
	@BeforeMethod
	public void setup1() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		test = extent.createTest("Test Cases Started");
		
		
	}
	
	@Test
	public void testMethod() {
		test = extent.createTest("TC001_Login");
		
		test.info("Lauching the browser ----------");
		driver = new ChromeDriver();
		soft.assertEquals(driver.getTitle(), "");
		
		}
	@Test
	public void logoutTest() {
		test = extent.createTest("TC002_Submit");

	    test.info("Starting SubmitButton");

	    System.out.println("Submit successful");

	    test.pass("Submit passed");
	}
	
	
	@AfterMethod
	public void tearDown() {
	}
	
	@AfterSuite
	public void endReport() {
		extent.flush();
		
	}
	
	}


