package com.cognizant.petClinicFrontTesting;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnersPage {
	@FindBy(css = "td[class='ownerFullName']")
	private List<WebElement> ownersNames;

	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/div/button")
	private WebElement addOwnerBtn;

	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[1]/td[1]/a")
	private WebElement ownerName;

	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/button[2]")
	private WebElement editOwnerBtn;

	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/table[1]/tbody/tr[1]/td/b")
	private WebElement ownerInfoName;

	public List<WebElement> getOwnersNames() {
		return ownersNames;
	}

	public WebElement getAddOwnerBtn() {
		return addOwnerBtn;
	}

	public WebElement getOwnerName() {
		return ownerName;
	}

	public WebElement getEditOwnerBtn() {
		return editOwnerBtn;
	}

	public WebElement getOwnerInfoName() {
		return ownerInfoName;
	}
}
