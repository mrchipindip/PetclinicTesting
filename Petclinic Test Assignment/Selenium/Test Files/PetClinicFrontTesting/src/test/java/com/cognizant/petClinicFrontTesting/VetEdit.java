package com.cognizant.petClinicFrontTesting;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class VetEdit {

	static ExtentReports reports;
	ExtentTest test;
	WebDriver driver;

	@BeforeClass
	public static void initial() {
		reports = new ExtentReports(Constants.REPORTFOLDERPATH + "VetEditReport.html", true);
	}

	@AfterClass
	public static void end() {
		reports.close();
	}

	@Before
	public void setup() {
		System.setProperty(Constants.DRIVER, Constants.DRIVERFILEPATH);
		driver = new ChromeDriver();
	}

	@After
	public void teardown() throws InterruptedException {
		reports.endTest(test);
		reports.flush();
		Thread.sleep(6000);
		driver.quit();
	}
}
