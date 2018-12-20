package com.cognizant.petClinicFrontTesting;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OwnerEdit {
	WebDriver driver;
	static ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public static void initial() {

		reports = new ExtentReports(Constants.REPORTFOLDERPATH + "OwnerEditReport.html", true);
	}

	@Before
	public void setup() {
		System.setProperty(Constants.DRIVER, Constants.DRIVERFILEPATH);
		driver = new ChromeDriver();
	}

	@Test
	public void editOwnerPage() throws InterruptedException {
		driver.manage().window().maximize();
		test = reports.startTest("Edit owner test from Owner's page");
		Boolean passedTest = false;

		driver.get(Constants.URL);
		Thread.sleep(2000);

		NavBar navBar = PageFactory.initElements(driver, NavBar.class);
		AddPages AddPages = PageFactory.initElements(driver, AddPages.class);
		OwnersPage ownersPage = PageFactory.initElements(driver, OwnersPage.class);

		navBar.getOwnersTabBtn().click();
		Thread.sleep(500);

		navBar.getOwnersAllBtn().click();
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "All owners clicked");

		ownersPage.getOwnerName().click();
		test.log(LogStatus.INFO, "Owner name clicked");
		Thread.sleep(500);

		ownersPage.getEditOwnerBtn().click();
		test.log(LogStatus.INFO, "Edit owner button clicked");
		Thread.sleep(1000);

		AddPages.getFirstName().sendKeys("Christopher");

		WebElement updateOwnerBtn = driver
				.findElement(By.xpath("/html/body/app-root/app-owner-edit/div/div/form/div[7]/div/button[2]"));
		updateOwnerBtn.click();
		Thread.sleep(1000);
		List<WebElement> editedName = driver
				.findElements(By.xpath("/html/body/app-root/app-owner-detail/div/div/table[1]"));
		for (WebElement entry : editedName) {
			System.out.println(entry.getText());
			if (entry.getText().contains("GeorgeChristopher")) {
				test.log(LogStatus.PASS, "Owner edited succesful");
				passedTest = true;
			}
		}
		if (!passedTest) {
			test.log(LogStatus.FAIL, "Owner edited unsuccesfully");
			fail();
		}
	}

	@After
	public void teardown() {
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}
}
