package com.salesforce.pages;

import org.openqa.selenium.WebElement;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class AccountPage extends ProjectSpecificMethods {

	public AccountPage clickTab(String tabName) {
		WebElement tabElement = locateElement(Locators.XPATH, "//a[@title='" + tabName + "']");
		clickUsingJs(tabElement);
		
		reportStep("Navigated to accounts tab successfully", "pass");
		return new AccountPage();
	}
	
	public AccountPage searchAccountName(String accountName) {
		clearAndType(locateElement(Locators.XPATH, "//input[@name='Account-search-input']"), accountName);
		reportStep("App name entered successfully", "pass");
		return this;
	}
	public AccountPage clickNewAccount() {
		click(locateElement(Locators.XPATH, "//div[@title='New']"));
		reportStep("New account clicked successfully", "pass");
		return this;
	}
	public AccountPage enterAccountName(String name) {
		clearAndType(locateElement(Locators.XPATH, "//input[@name='Name']"), name);
		reportStep("Account name entered successfully", "pass");
		return this;
	}

	public AccountPage enterPhone(String phone) {
		clearAndType(locateElement(Locators.XPATH, "//input[@name='Phone']"), phone);
		reportStep("Phone number entered successfully", "pass");
		return this;
	}

	public AccountPage enterWebsite(String website) {
		clearAndType(locateElement(Locators.XPATH, "//input[@name='Website']"), website);
		reportStep("website entered successfully", "pass");
		return this;
	}

	public AccountPage selectIndustry(String industry) {
		WebElement dropDown = (locateElement(Locators.XPATH, "//button[@aria-label='Industry']/span"));
		clickUsingJs(dropDown);
		click(locateElement(Locators.XPATH, "//span[@title='" + industry + "']"));
		reportStep("Industry selected successfully", "pass");
		return this;
	}
	public AccountPage clickSaveAccount() {
		click(locateElement(Locators.XPATH, "//button[@name='SaveEdit']"));
		reportStep("Save Button clicked successfully", "pass");
		return this;
	}
	public AccountPage clickShowActionDD() {
		pause(3000);
		click(locateElement(Locators.XPATH,
				"(//button[contains(@class,'slds-button slds-button_icon-border')])[1]"));
		reportStep("Show Actions DD clicked successfully", "pass");
		return this;
	}
	
	public AccountPage clickEdit() {
        click(locateElement(Locators.XPATH, "//a[@title='Edit']"));
        reportStep("Edit is clicked successfully", "pass");
        return this;
    }
	
	public AccountPage clickDelete() {
        click(locateElement(Locators.XPATH, "//a[@title='Delete']"));
        reportStep("Edit is clicked successfully", "pass");
        return this;
    }

    public AccountPage confirmDeletion() {
    	WebElement confirmDelete = locateElement(Locators.XPATH, "//button[@title='Delete']");
    	click(confirmDelete);
        reportStep("Delete Button clicked successfully", "pass");
        return this;
    }
	
	public AccountPage enterUpdatedName(String uName) {
		clearAndType(locateElement(Locators.XPATH, "//input[@name='Name']"), uName);
		reportStep(uName + "New Name entered successfully", "pass");
		return this;
	}
	public AccountPage clickSaveButton() {

		click(locateElement(Locators.XPATH, "//button[@name='SaveEdit']"));
		reportStep("Save Button clicked successfully", "pass");
		return this;
	}
	
	   public AccountPage verifyToastMessage(String expectedText) {
	        verifyPartialText(locateElement(Locators.XPATH, "//span[contains(text(),'" + expectedText + "')]"), expectedText);
	        reportStep("Toast Message verified with: " + expectedText, "pass");
	        return this;
	    }
	
}
