package com.cognizant.petClinicFrontTesting;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

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

	@Test
	public void editTest() {
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		test = reports.startTest("Edit vet record via drop down.");

		NavBar navBar = PageFactory.initElements(driver, NavBar.class);
		VetsPage vetsPage = PageFactory.initElements(driver, VetsPage.class);

		try {
			Thread.sleep(1000);
			navBar.getOwnersTabBtn().click();
			vetsPage.getEditBtn().click();
			
			
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getStackTrace().toString());
			fail();
		} finally {
			reports.endTest(test);
			reports.flush();
		}
	}
}
