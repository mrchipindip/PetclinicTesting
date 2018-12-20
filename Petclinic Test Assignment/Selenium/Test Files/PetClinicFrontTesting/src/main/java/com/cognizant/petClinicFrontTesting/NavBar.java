package com.cognizant.petClinicFrontTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBar {

	// Owners
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
	private WebElement ownersTabBtn;

	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a")
	private WebElement ownersAllBtn;

	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[2]/a")
	private WebElement ownersAddBtn;

	// Vets
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[3]/a")
	private WebElement vetsTabBtn;

	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[3]/ul/li[1]/a")
	private WebElement vetsAllBtn;

	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[3]/ul/li[2]/a")
	private WebElement vetsAddBtn;

	// Getters
	public WebElement getOwnersTabBtn() {
		return ownersTabBtn;
	}

	public WebElement getOwnersAllBtn() {
		return ownersAllBtn;
	}

	public WebElement getOwnersAddBtn() {
		return ownersAddBtn;
	}

	public WebElement getVetsTabBtn() {
		return vetsTabBtn;
	}

	public WebElement getVetsAllBtn() {
		return vetsAllBtn;
	}

	public WebElement getVetsAddBtn() {
		return vetsAddBtn;
	}
}
