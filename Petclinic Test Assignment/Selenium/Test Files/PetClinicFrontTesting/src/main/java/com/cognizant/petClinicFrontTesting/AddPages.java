package com.cognizant.petClinicFrontTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddPages {

	// TextBoxes
	@FindBy(id = "firstName")
	private WebElement firstName;

	@FindBy(id = "lastName")
	private WebElement lastName;

	@FindBy(id = "address")
	private WebElement address;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "telephone")
	private WebElement telephone;

	@FindBy(id = "specialties")
	private WebElement specialties;

	// Buttons
	@FindBy(xpath = "/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]")
	private WebElement saveOwnerBtn;

	@FindBy(xpath = "//*[@id=\"vet\"]/div[5]/div/button[2]")
	private WebElement saveVetBtn;

	@FindBy(xpath = "//*[@id=\"vet\"]/div[5]/div/button[1]")
	private WebElement vetBackBtn;

	@FindBy(xpath = "/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[1]")
	private WebElement ownerBackBtn;

	// Getters
	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getTelephone() {
		return telephone;
	}

	public WebElement getSaveOwnerBtn() {
		return saveOwnerBtn;
	}

	public WebElement getSaveVetBtn() {
		return saveVetBtn;
	}

	public WebElement getVetBackBtn() {
		return vetBackBtn;
	}

	public WebElement getOwnerBackBtn() {
		return ownerBackBtn;
	}
}
