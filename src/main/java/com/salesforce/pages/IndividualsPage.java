package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class IndividualsPage extends ProjectSpecificMethods {

	public IndividualsPage clickNewButton() {

		click(locateElement(Locators.XPATH, "//div[text()='New']"));
		reportStep("New Button clicked successfully", "pass");
		return this;
	}

	public IndividualsPage selectSalutation() {

		click(locateElement(Locators.XPATH, "//span[text()='Salutation']/following::a"));
		click(locateElement(Locators.XPATH, "//a[text()='Mr.']"));
		reportStep(" Mr. selected successfully", "pass");
		return this;
	}

	public IndividualsPage enterFirstName(String fName) {
		clearAndType(locateElement(Locators.XPATH, "//span[text()='First Name']/following::input[1]"), fName);
		reportStep(fName + "First Name entered successfully", "pass");
		return this;
	}

	public IndividualsPage enterLastName(String lName) {
		clearAndType(locateElement(Locators.XPATH, "//span[text()='Last Name']/following::input[1]"), lName);
		reportStep(lName + "Last Name entered successfully", "pass");
		return this;
	}

	public IndividualsPage clickSaveButton() {

		click(locateElement(Locators.XPATH, "//button[@title='Save']"));
		reportStep("Save Button clicked successfully", "pass");
		return this;
	}

	public IndividualsPage verifyCreateIndividuals(String text) {
		verifyPartialText(locateElement(Locators.XPATH,
				"//span[@class='toastMessage slds-text-heading--small forceActionsText']"), text);
		reportStep(text + "Name Matches is loaded", "pass");
		return this;
	}

	public IndividualsPage enterIndividualSearchField(String search) {
		typeAndEnter(locateElement(Locators.XPATH, "//input[@placeholder='Search this list...']"), search);
		reportStep(search + "Search Field entered successfully", "pass");
		return this;
	}

	
	public IndividualsPage clickShowActionDD() { 
		pause(3000);
		click(locateElement(Locators.XPATH,
				"(//button[contains(@class,'slds-button slds-button_icon-border')])[1]"));
		reportStep("Show Actions DD clicked successfully", "pass");
		return this;
	}

	public IndividualsPage clickDeleteLink() {

		click(locateElement(Locators.XPATH, "//a[@title='Delete']"));
		reportStep("Delete Link is clicked successfully", "pass");
		return this;
	}

	public IndividualsPage clickPoupDeleteButton() {

		click(locateElement(Locators.XPATH, "//span[text()='Delete']"));
		reportStep("Delete Button is clicked successfully", "pass");
		return this;
	}
	
	public IndividualsPage verifyDeleteIndividuals(String text) {
		verifyPartialText(locateElement(Locators.XPATH,"//span[contains(@class,'toastMessage')]"), text);
		reportStep(text + "Name Matches is loaded", "pass");
		return this;
	}
	
	public IndividualsPage clickEditLink() {

        click(locateElement(Locators.XPATH, "//a[@title='Edit']"));
        reportStep("Edit Link is clicked successfully", "pass");
        return this;
    }
	
	public IndividualsPage verifyEditIndividuals(String text) {
        verifyPartialText(locateElement(Locators.XPATH,
                "//span[@class='toastMessage slds-text-heading--small forceActionsText']"), text);
        reportStep(text + "Name Matches is loaded", "pass");
        return this;
	}

}
