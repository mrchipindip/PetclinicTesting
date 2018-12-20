package com.cognizant.petClinicFrontTesting;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class VetAdd {

	static ExtentReports reports;
	ExtentTest test;
	WebDriver driver;

	@BeforeClass
	public static void initial() {
		reports = new ExtentReports(Constants.REPORTFOLDERPATH + "VetAddReport.html", true);
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
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void addVetTestDropDown() {
		String fname = "FirstNameAddDropDown";
		String lname = "LastNameAddDropDown";

		driver.manage().window().maximize();
		driver.get(Constants.URL);
		test = reports.startTest("Add vet record via drop down.");

		NavBar navBar = PageFactory.initElements(driver, NavBar.class);
		AddPages addPage = PageFactory.initElements(driver, AddPages.class);
		VetsPage vetsPage = PageFactory.initElements(driver, VetsPage.class);
		Actions action = new Actions(driver);

		try {

			Thread.sleep(1000);
			navBar.getVetsTabBtn().click();
			navBar.getVetsAddBtn().click();
			Thread.sleep(1000);
			addPage.getFirstName().sendKeys(fname);
			addPage.getLastName().sendKeys(lname);
			addPage.getTypeDropDown().click();
			action.sendKeys(Keys.ARROW_DOWN).perform();
			action.sendKeys(Keys.ENTER).perform();
			addPage.getSaveVetBtn().click();

			Thread.sleep(1000);
			if (vetsPage.getVets().getText().contains(fname + " " + lname)) {
				test.log(LogStatus.PASS, "Add vet via drop down successful.");
			} else {
				test.log(LogStatus.FAIL, "Add vet via drop down UNSUCCESSFUL.");
				fail();
			}

		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getStackTrace().toString());
			fail();
		} finally {
			reports.endTest(test);
			reports.flush();
		}
	}

	@Test
	public void addVetTestVetsPage() {
		String fname = "FirstNameViaVetsPage";
		String lname = "LastNameViaVetsName";

		driver.manage().window().maximize();
		driver.get(Constants.URL);
		test = reports.startTest("Add vet record via ./vets/ page.");

		NavBar navBar = PageFactory.initElements(driver, NavBar.class);
		AddPages addPage = PageFactory.initElements(driver, AddPages.class);
		VetsPage vetsPage = PageFactory.initElements(driver, VetsPage.class);
		Actions action = new Actions(driver);

		try {

			Thread.sleep(1000);
			navBar.getVetsTabBtn().click();
			navBar.getVetsAllBtn().click();
			Thread.sleep(1000);
			vetsPage.getAddBtn().click();
			Thread.sleep(1000);
			addPage.getFirstName().sendKeys(fname);
			addPage.getLastName().sendKeys(lname);
			addPage.getTypeDropDown().click();
			action.sendKeys(Keys.ARROW_DOWN).perform();
			action.sendKeys(Keys.ENTER).perform();
			addPage.getSaveVetBtn().click();

			Thread.sleep(1000);
			if (vetsPage.getVets().getText().contains(fname + " " + lname)) {
				test.log(LogStatus.PASS, "Add vet via ./vets/ page successful.");
			} else {
				test.log(LogStatus.FAIL, "Add vet via ./vets/ page UNSUCCESSFUL.");
				fail();
			}

		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getStackTrace().toString());
			fail();
		} finally {
			reports.endTest(test);
			reports.flush();
		}
	}

	@Test
	public void addInvalidEntries() {
		String fname = "f";
		String lname = "l";

		driver.manage().window().maximize();
		driver.get(Constants.URL);
		test = reports.startTest("Add INVALID vet record via drop down.");

		NavBar navBar = PageFactory.initElements(driver, NavBar.class);
		AddPages addPage = PageFactory.initElements(driver, AddPages.class);

		try {

			Thread.sleep(1000);
			navBar.getVetsTabBtn().click();
			navBar.getVetsAddBtn().click();
			Thread.sleep(1000);
			addPage.getFirstName().sendKeys(fname);
			addPage.getLastName().sendKeys(lname);

			if (addPage.getSaveVetBtn().getText().contains("disabled")) {
				test.log(LogStatus.PASS, "Disable save button successful.");
			} else {
				test.log(LogStatus.FAIL, "Disable save button UNSUCCESSFUL.");
				fail();
			}

		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getStackTrace().toString());
			fail();
		} finally {
			reports.endTest(test);
			reports.flush();
		}
	}

}
