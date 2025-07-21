package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class LegalEntity extends ProjectSpecificMethods {

	public CreateLegalEntityPage clickNewLegalEntity() {
		click(locateElement(Locators.XPATH, "//div[text()='New']"));
		reportStep("Cliked New button Successfully", "pass");

		return new CreateLegalEntityPage();
	}
	
	public EditLegalEntityPage searchLegalEntity(String contactName) {
		
		typeAndEnter(locateElement(Locators.XPATH, "(//input[@type='search'])[2]"), contactName);
		reportStep("Search for Existing Contact is Successful", "pass");

			return new EditLegalEntityPage();
	}
}
