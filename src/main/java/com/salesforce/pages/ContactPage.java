package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class ContactPage extends ProjectSpecificMethods {

	public CreateContactPage clickNewContact() {
		click(locateElement(Locators.XPATH, "//div[text()='New']"));
		reportStep("Cliked New button Successfully", "pass");

		return new CreateContactPage();
	}
	
	
	public EditContactPage searchContact(String contactName) {
		
		typeAndEnter(locateElement(Locators.XPATH, "(//input[@type='search'])[2]"), contactName);
		reportStep("Search for Existing Contact is Successful", "pass");
			return new EditContactPage();
	}
	public DeleteContactPage searchContactName(String contactName) {
		
		typeAndEnter(locateElement(Locators.XPATH, "(//input[@type='search'])[2]"), contactName);
		reportStep("Search for Existing Contact is Successful", "pass");
			return new DeleteContactPage();
	}
     public EditContactPage selectEdit() {
		pause(3000);
		click(locateElement(Locators.XPATH, "//span[@class='slds-icon_container slds-icon-utility-down']/span"));
		reportStep("Edit Contact is selelcted Successfully", "pass");
	
		return new EditContactPage();
	}
     public ContactPage clickActionDropdown() {
    	    pause(2000);
    	    click(locateElement(Locators.XPATH, "//span[@class='slds-icon_container slds-icon-utility-down']/span"));
    	    reportStep("Action dropdown clicked successfully", "pass");
    	    return this;
    	}

    	public ContactPage clickDeleteOption() {
    	    click(locateElement(Locators.XPATH, "//a[@title='Delete']"));
    	    reportStep("Delete option clicked successfully", "pass");
    	    return this;
    	}

    	public ContactPage confirmDelete() {
    	    click(locateElement(Locators.XPATH, "//button[@title='Delete']"));
    	    reportStep("Delete confirmed successfully", "pass");
    	    return this;
    	}

   

     
     
     //

	
}
