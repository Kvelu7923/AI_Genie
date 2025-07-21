package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class LeadsPage extends ProjectSpecificMethods {

	public LeadsPage clickNewLeadsButton() {
		clickUsingJs(locateElement(Locators.XPATH, "//div[@title='New']"));
		reportStep("create new lead button is clicked successfully", "pass");
		return this;
	}
	public LeadsPage clickDropdown() {
		pause(3000);
		click(locateElement(Locators.XPATH,
				"(//button[contains(@class,'slds-button slds-button_icon-border')])[1]"));
		reportStep("Dropdown clicked successfully", "pass");
		return this;
	}
	public LeadsPage clickEdit() {
		
        click(locateElement(Locators.XPATH, "//a[@title='Edit']"));
        reportStep("Edit is clicked successfully", "pass");
        return this;
    }
	public LeadsPage enterNewName(String newName) {
		clearAndType(locateElement(Locators.XPATH, "//input[@name='firstName']"), newName);
		reportStep(newName + "New Name entered successfully", "pass");
		return this;
	}
	
	public LeadsPage clickSaveButton() {
		click(locateElement(Locators.XPATH, "//button[@name='SaveEdit']"));
		reportStep("Save Button clicked successfully", "pass");
		return this;
	}
	
	public LeadsPage verifyUpdatedName(String newName) {
		verifyPartialText(locateElement(Locators.XPATH,
				"//span[@class='toastMessage slds-text-heading--small forceActionsText']"), newName);
		reportStep(newName + "Work Type Created Successfully", "pass");
		return this;
	}
	public LeadsPage selectSalutationDropdown() {
		click(locateElement(Locators.XPATH, "//label[text()='Salutation']//following::button[1]"));
		click(locateElement(Locators.XPATH, "//span[text()='Mr.']"));
		reportStep("Salutation  is selected successfully", "pass");
		return this;
	}
	
	public LeadsPage enterFirstName(String firstName) {
		clearAndType(locateElement(Locators.XPATH, "//label[text()='First Name']/following::input"), firstName);
		reportStep("First name is entered successfully", "pass");
		return this;
	}

	public LeadsPage enterLastName(String lastName) {
		clearAndType(locateElement(Locators.XPATH, "//label[text()='Last Name']/following::input"), lastName);
		reportStep("Last name is entered successfully", "pass");
		return this;

	}
	public LeadsPage enterCompanyName(String companyName) {
		clearAndType(locateElement(Locators.XPATH, "//label[text()='Company']/following::input"), companyName);
		reportStep("Company name is entered successfully", "pass");
		return this;
	}

	public LeadsPage clickSaveLead() {
		pause(3000);
		click(locateElement(Locators.XPATH, "//button[@name='SaveEdit']"));
		reportStep("save button is  clicked  successfully", "pass");
		return this;
	}

	public LeadsPage verifyLeadCreated(String firstName) {
		verifyPartialText(locateElement(Locators.XPATH,
				"//span[@class='toastMessage slds-text-heading--small forceActionsText']"), firstName);
		reportStep(firstName + "Name Matches is loaded", "pass");
		return this;
	}
	
	
	
}
