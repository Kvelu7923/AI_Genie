package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class VerifyEditLegalEntityPage extends ProjectSpecificMethods {

	public VerifyEditLegalEntityPage verifyToastMeassage() {

		legalEntityName = getElementText(locateElement(Locators.XPATH,
				"//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]"));
		System.out.println(legalEntityName);
		return this;
	}

	public VerifyEditLegalEntityPage clickLegalEntityName(String leName) {

		click(Locators.XPATH, "//a[@title='" + leName + "']");
		reportStep("Verified the LegalEntityName Clicked " + leName + " Successfully", "pass");
		return this;
	}

	public VerifyEditLegalEntityPage verifyEnteredCompanyName(String leName) {

		verifyPartialText(locateElement(Locators.XPATH, "//span[text()='Company Name']//following::span"), leName);

		reportStep("Verified the CompanyName Entered " + leName + " Successfully", "pass");
		return this;
	}

	public VerifyEditLegalEntityPage verifyDescription(String des) {

		verifyPartialText(locateElement(Locators.XPATH, "//span[text()='Description']//following::span"), des);

		reportStep("Verified the CompanyName Entered " + des + " Successfully", "pass");
		return this;
	}

}