package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class EditLegalEntityPage extends ProjectSpecificMethods {

	public EditLegalEntityPage clickDropdown() {
		clickUsingJs(locateElement(Locators.XPATH, "//button[.//span[text()='Show Actions']]"));
		reportStep("Clicked dropdown Successfully", "pass");
		return this;
	}

	public EditLegalEntityPage clickEdit() {
		clickUsingJs(locateElement(Locators.XPATH, "//a[@title='Edit']//div"));
		reportStep("Clicked Edit Successfully", "pass");
		return this;
	}

	public EditLegalEntityPage enterCompanyName(String cName) {
		typeAndEnter(locateElement(Locators.XPATH, "(//label[text()='Company Name']/following::input)"), cName);
		reportStep("Entered " + cName + "successfully ", "pass");
		return this;
	}

	public EditLegalEntityPage enterDescription(String description) {
		typeAndEnter(locateElement(Locators.XPATH, "(//label[text()='Description']/following::textarea)"), description);
		reportStep("Entered " + description + "successfully ", "pass");
		return this;
	}

	public EditLegalEntityPage clickStatusDropDown() {

		clickUsingJs(locateElement(Locators.XPATH, "//label[text()='Status']/following::button"));
		reportStep("Clicked dropdown Successfully", "pass");
		return this;
	}

	public EditLegalEntityPage selectStatus() {
		getDriver().executeScript("window.scrollBy(0, 500);");
		clickUsingJs(locateElement(Locators.XPATH, "//span[@title='Active']"));
		reportStep("Status selected Successfully", "pass");
		return this;
	}

	public VerifyEditLegalEntityPage clickSaveOnEdit() {
		click(locateElement(Locators.XPATH, "(//button[text()='Save'])"));
		reportStep("Clicked Save button Successfully", "pass");
		return new VerifyEditLegalEntityPage();

	}

}
