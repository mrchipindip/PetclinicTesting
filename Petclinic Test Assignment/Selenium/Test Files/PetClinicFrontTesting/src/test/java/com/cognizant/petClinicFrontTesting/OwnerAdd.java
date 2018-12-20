package com.cognizant.petClinicFrontTesting;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OwnerAdd {
	WebDriver driver;
	static ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public static void initial() {

		reports = new ExtentReports(Constants.REPORTFOLDERPATH + "OwnerAddReport.html", true);
	}

	@Before
	public void setup() {
		System.setProperty(Constants.DRIVER, Constants.DRIVERFILEPATH);
		driver = new ChromeDriver();
	}

	@Test
	public void addOwnerDropdown() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		test = reports.startTest("Add owner test from dropdown menu");

		driver.get(Constants.URL);
		Thread.sleep(2000);

		NavBar navBar = PageFactory.initElements(driver, NavBar.class);
		AddPages addPage = PageFactory.initElements(driver, AddPages.class);
		OwnersPage ownersPage = PageFactory.initElements(driver, OwnersPage.class);

		try {
			navBar.getOwnersTabBtn().click();
			Thread.sleep(500);
			navBar.getOwnersAddBtn().click();

			Thread.sleep(1000);
			test.log(LogStatus.INFO, "Add owner clicked");

			addPage.getFirstName().sendKeys("Celeste");
			addPage.getLastName().sendKeys("Brant");
			addPage.getAddress().sendKeys("anchorage way");
			addPage.getCity().sendKeys("Manchester");
			addPage.getTelephone().sendKeys("75777584");
			Thread.sleep(1000);
			addPage.getSaveOwnerBtn().click();
			Thread.sleep(1000);

			for (WebElement el : ownersPage.getOwnersNames()) {
				if (!el.getText().contains("Celeste")) {
					break;
				} else {
					test.log(LogStatus.PASS, "Owner add succesful");
				}
				test.log(LogStatus.FAIL, "Owner added not in owner's list succesful");
				fail();
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Exception caught");

			fail();

		} finally {
			reports.endTest(test);
			reports.flush();
		}

	}

	@Test
	public void addOwnerPage() throws InterruptedException {
		driver.manage().window().maximize();
		test = reports.startTest("Add owner test from Owner's page");

		driver.get(Constants.URL);
		Thread.sleep(2000);

		NavBar navBar = PageFactory.initElements(driver, NavBar.class);
		AddPages addPage = PageFactory.initElements(driver, AddPages.class);
		OwnersPage ownersPage = PageFactory.initElements(driver, OwnersPage.class);

		try {
			navBar.getOwnersTabBtn().click();
			Thread.sleep(500);

			navBar.getOwnersAllBtn().click();
			Thread.sleep(1000);
			test.log(LogStatus.INFO, "All owners clicked");

			ownersPage.getAddOwnerBtn().click();

			addPage.getFirstName().sendKeys("Jose Maria");
			addPage.getLastName().sendKeys("Brant");
			addPage.getAddress().sendKeys("anchorage way");
			addPage.getCity().sendKeys("Manchester");
			addPage.getTelephone().sendKeys("75777584");
			Thread.sleep(1000);
			addPage.getSaveOwnerBtn().click();
			test.log(LogStatus.INFO, "Owner add button clicked");

			Thread.sleep(1000);

			for (WebElement el : ownersPage.getOwnersNames()) {
				if (!el.getText().contains("Jose Maria")) {
					break;
				} else {
					test.log(LogStatus.PASS, "Owner add succesful");
				}
				test.log(LogStatus.FAIL, "Owner added not in owner's list succesful");
				fail();
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Exception caught");

			fail();

		} finally {
			reports.endTest(test);
			reports.flush();
		}
	}

	@Test
	public void addOwnerPageInvalidInput() throws InterruptedException {
		driver.manage().window().maximize();
		test = reports.startTest("Add owner test from Owner's page with an invalid input");

		driver.get(Constants.URL);
		Thread.sleep(2000);

		NavBar navBar = PageFactory.initElements(driver, NavBar.class);
		AddPages addPage = PageFactory.initElements(driver, AddPages.class);
		OwnersPage ownersPage = PageFactory.initElements(driver, OwnersPage.class);

		navBar.getOwnersTabBtn().click();
		Thread.sleep(500);

		navBar.getOwnersAllBtn().click();
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "All owners clicked");

		ownersPage.getAddOwnerBtn().click();

		addPage.getFirstName().sendKeys("J");
		addPage.getLastName().sendKeys("Brant");
		addPage.getAddress().sendKeys("anchorage way");
		addPage.getCity().sendKeys("Manchester");
		addPage.getTelephone().sendKeys("75777584");
		Thread.sleep(1000);
		if (addPage.getSaveOwnerBtn().getText().contains("disabled")) {
			test.log(LogStatus.PASS, "Cannot add user as invalid input- succesful test");
		} else {
			test.log(LogStatus.FAIL, "Can add user as invalid input- unsuccesful test");

		}

	}

	@After
	public void teardown() {
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}
}
