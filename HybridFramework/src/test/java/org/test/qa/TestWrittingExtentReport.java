package org.test.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestWrittingExtentReport {
	WebDriver driver;
	
	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest test;
	static SoftAssert soft;
	
	@Test  
	public void TC001_FBLogin() {
		try {
			soft=new SoftAssert();
			spark = new ExtentSparkReporter("C:\\Framework\\HybridFramework\\Reports\\Extent.html");
			
			
			spark.config().setDocumentTitle("Automation Reporting Test");
			spark.config().setReportName("ExtentReport1");
			spark.config().setTheme(Theme.STANDARD);
			
			extent = new ExtentReports();
			extent.attachReporter(spark);
			
			test = extent.createTest("TC001_FBLogin");
			
			test.info("Lauching the browser ----------");
			driver = new ChromeDriver();
			
			test.info("Loading the URL-----------");
			driver.get("https://www.Google.com/");
			
			
			soft.assertEquals(driver.getTitle(), "Google");
			
			//if(driver.getTitle().equals("Google2")) {
			 // test.log(Status.PASS, "TC001 is passed");
		//}
			//else {
				//test.log(Status.FAIL, "Test Cases is failed");
		//	}
		
			
			  
			
			
			extent.flush();
			soft.assertAll();
			driver.quit();
		}catch (Exception e) {
			
			e.printStackTrace();
			
			
			
			
			
			
		}
	}
	
	

}
