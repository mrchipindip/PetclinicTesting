package com.cognizant.petClinicFrontTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VetsPage {
	@FindBy(id = "vets")
	private WebElement vets;

	@FindBy(xpath = "/html/body/app-root/app-vet-list/div/div/div/button[2]")
	private WebElement addBtn;

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getVets() {
		return vets;
	}
}
