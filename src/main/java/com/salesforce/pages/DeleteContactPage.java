package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class DeleteContactPage extends ProjectSpecificMethods {


	public DeleteContactPage clickActionDropdown() {

		click(locateElement(Locators.XPATH, "(//button[contains(@class,'slds-button slds-button_icon-border')])[1]"));
		reportStep("Clicked dropdown Successfully", "pass");
		return this;
	}
	public DeleteContactPage clickDeleteOption() {        
		clickUsingJs(locateElement(Locators.XPATH, "//a[@title='Delete']//div"));
		reportStep("Delete clicked Successfully", "pass");
		return this;
	}
	public DeleteContactPage confirmDelete() {
		click(locateElement(Locators.XPATH, "//span[text()='Delete']"));
		reportStep("Delete button Clicked Successfully", "pass");
		return this;
	}
	
}
