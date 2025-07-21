package com.salesforce.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class CasePage extends ProjectSpecificMethods {

    public CasePage clickNewCase() {
        click(locateElement(Locators.XPATH, "//div[@title='New']"));
        reportStep("new case clicked successfully", "pass");
        return this;
    }

    public CasePage clickContactName() {
        click(locateElement(Locators.XPATH, "//label[text()='Contact Name']/following::input[1]"));
        reportStep("Contact Name clicked successfully", "pass");
        return this;
    }

    public CasePage clickNewContact() {
        click(locateElement(Locators.XPATH, "//span[@title='New Contact']"));
        reportStep("New contact clicked successfully", "pass");
        return this;
    }

    public CasePage selectSalutation(String salutation) {
        click(locateElement(Locators.XPATH, "//label[text()='Salutation']/following::button"));
        click(locateElement(Locators.XPATH, String.format("//span[@title='%s']", salutation)));
        reportStep("Selected salutation: " + salutation, "pass");
        return this;
    }


    public CasePage enterFirstName(String firstName) {
        clearAndType(locateElement(Locators.XPATH, "//label[text()='First Name']/following::input[1]"), firstName);
        reportStep("Entered first name: " + firstName, "pass");
        return this;
    }

    public CasePage enterLastName(String lastName) {
        clearAndType(locateElement(Locators.XPATH, "//label[text()='Last Name']/following::input[1]"), lastName);
        reportStep("Entered last name: " + lastName, "pass");
        return this;
    }

    public CasePage clickSave() {
        String xpath = "(//button[text()='Save'])[2]";
        verifyDisplayed(locateElement(Locators.XPATH, xpath));
        click(locateElement(Locators.XPATH, xpath));
        reportStep("Save Button clicked successfully", "pass");
        return this;
        
    }

    public CasePage selectCaseOrigin(String origin) {
        clickUsingJs(locateElement(Locators.XPATH, "//label[text()='Case Origin']/following::button[1]"));
        WebElement originOption = locateElement(Locators.XPATH, String.format("//span[@title='%s']", origin));
        clickUsingJs(originOption);
        reportStep("case orgin selected successfully", "pass");
        return this;
    }

    public CasePage selectStatus(String status) {
        click(locateElement(Locators.XPATH, "//label[text()='Status']/following::button[1]"));
        WebElement statusOpt = locateElement(Locators.XPATH, String.format("//label[text()='Status']/following::button[1]/following::span[@title='%s']", status));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", statusOpt);
        js.executeScript("arguments[0].click();", statusOpt);
        reportStep("Status selected successfully", "pass");
        return this;
    }

    public CasePage slaViolation(String value) {
        click(locateElement(Locators.XPATH, "//label[text()='SLA Violation']/following::button[1]"));
        WebElement slaOption = locateElement(Locators.XPATH, String.format("//label[text()='SLA Violation']/following::button[1]/following::span[text()='%s']", value));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", slaOption);
        js.executeScript("arguments[0].click();", slaOption);
        reportStep("SLA Violation set to: " + value, "pass");
        return this;
    }

    public CasePage enterSubject(String subject) {
        clearAndType(locateElement(Locators.XPATH, "//label[text()='Subject']/following::input[1]"), subject);
        reportStep("Subject entered successfully", "pass");
        return this;
    }

    public CasePage enterDescription(String description) {
        clearAndType(locateElement(Locators.XPATH, "//label[text()='Description']/following::textarea[1]"), description);
        reportStep("description entered successfully successfully", "pass");
        return this;
    }

    public CasePage clickSaveCase() {
        click(locateElement(Locators.XPATH, "//button[text()='Save']"));
        reportStep("Save Button clicked successfully", "pass");
        return this;
    }

    public CasePage clickEdit() {
        verifyDisplayed(locateElement(Locators.XPATH, "//button[text()='Edit']"));
        click(locateElement(Locators.XPATH, "//button[text()='Edit']"));
        return this;
    }

    public CasePage clickDelete() {
        click(locateElement(Locators.XPATH, "//button[text()='Delete']"));
        reportStep("Delete clicked successfully", "pass");
        return this;
    }
	public CasePage clickShowActionDD() {
		pause(3000);
		click(locateElement(Locators.XPATH,
				"(//button[contains(@class,'slds-button slds-button_icon-border')])[1]"));
		reportStep("Show Actions DD clicked successfully", "pass");
		return this;
	}
	
	public CasePage clickDeleteOption() {
        click(locateElement(Locators.XPATH, "//a[@title='Delete']"));
        reportStep("Edit is clicked successfully", "pass");
        return this;
    }
	

    public CasePage confirmDeletion() {
    	WebElement confirmDelete = locateElement(Locators.XPATH, "//button[@title='Delete']");
    	click(confirmDelete);
        reportStep("Delete Button clicked successfully", "pass");
        return this;
    }

    
    // ----------- Verifications ------------------

    public CasePage verifyCreatedCase(String text) {
        verifyPartialText(locateElement(Locators.XPATH, "//span[@class='toastMessage slds-text-heading--small forceActionsText']"), text);
        reportStep(text + " case is created", "pass");
        return this;
    }

    public CasePage verifyEditCases(String text) {
        verifyPartialText(locateElement(Locators.XPATH, "//span[@class='toastMessage slds-text-heading--small forceActionsText']"), text);
        reportStep(text + " case is edited", "pass");
        return this;
    }

    public CasePage verifyDeleteCases(String text) {
        verifyPartialText(locateElement(Locators.XPATH, "//span[@class='toastMessage slds-text-heading--small forceActionsText']"), text);
        reportStep(text + " case is deleted", "pass");
        return this;
    }

    public CasePage verifyToastMessage(String expectedText) {
        verifyPartialText(locateElement(Locators.XPATH, "//span[contains(text(),'" + expectedText + "')]"), expectedText);
        reportStep("Toast Message verified with: " + expectedText, "pass");
        return this;
    }
}
