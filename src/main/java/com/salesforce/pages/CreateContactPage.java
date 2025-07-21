package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class CreateContactPage extends ProjectSpecificMethods {

	public CreateContactPage selectSalutation() {
			
		click(locateElement(Locators.XPATH, "(//div[contains(@class,'slds-combobox__form-element slds-input-has-icon')]//button)[2]"));
		clickUsingJs(locateElement(Locators.XPATH, "//span[text()='Mr.']"));
		reportStep("Salutation selected successfully", "pass");
		return this;

	}
	public CreateContactPage enterFirstName(String fname) {
		clearAndType(locateElement(Locators.XPATH, "//label[text()='First Name']/following::input"),fname);
		reportStep("First name entered successfully", "pass");
		return this;

	}

	
	public CreateContactPage enterLastName(String lname) {
		clearAndType(locateElement(Locators.XPATH, "//label[text()='Last Name']/following::input"),lname);
		reportStep("Last Name entered successfully", "pass");
		return this;

	}
	public VerifyNewContact clickSave() {
		click(locateElement(Locators.XPATH, "(//button[text()='Save'])[2]"));
		reportStep("Save Button clicked successfully", "pass");
		return new VerifyNewContact();

	}
	

}
