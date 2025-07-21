package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class VerifyEditContactPage extends ProjectSpecificMethods{

public VerifyEditContactPage verifyToastMessage(String contactName) {
	
		verifyPartialText(locateElement(Locators.XPATH,
				"//span[@class='toastMessage slds-text-heading--small forceActionsText']"), contactName);
		reportStep(contactName + "Contact edited Successfully", "pass");
		
	return this;
	
}
}