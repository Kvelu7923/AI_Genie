
package com.salesforce.pages;

	import com.framework.selenium.api.design.Locators;
	import com.framework.testng.api.base.ProjectSpecificMethods;

	public class EditOpportunityPage extends ProjectSpecificMethods {

	    // Global variables for XPath locators
	    private static final String CLOSE_DATE_INPUT = "//label[text()='Close Date']/following::input[1]";
	    private static final String TOMORROW_DATE = "//td[@class='slds-is-today']//following::td";
	    private static final String STAGE_DROPDOWN = "//label[text()='Stage']/following::button[1]";
	    private static final String PERCEPTION_ANALYSIS_STAGE = "//div[@aria-label='Stage']//span[text()='Perception Analysis']";
	    private static final String DESCRIPTION_TEXTAREA = "//label[text()='Description']/following::textarea[1]";
	    private static final String SAVE_BUTTON = "//button[@name='SaveEdit']";

	    public EditOpportunityPage editCloseDateasTomorrow() {
	        click(locateElement(Locators.XPATH, CLOSE_DATE_INPUT));
	        clickUsingJs(locateElement(Locators.XPATH, TOMORROW_DATE));
	        reportStep("close date edited successfully", "pass");
	        return this;
	    }

	    public EditOpportunityPage editStage() {
	        clickUsingJs(locateElement(Locators.XPATH, STAGE_DROPDOWN));
	        click(locateElement(Locators.XPATH, PERCEPTION_ANALYSIS_STAGE));
	        reportStep("Stage edited successfully", "pass");
	        return this;
	    }

	    public EditOpportunityPage editDescription() {
	        moveToElement(locateElement(Locators.XPATH, DESCRIPTION_TEXTAREA));
	        clearAndType(locateElement(Locators.XPATH, DESCRIPTION_TEXTAREA), "salesforce");
	        reportStep("Description edited successfully", "pass");
	        return this;
	    }

	    public VerifyOpportunity clickSave() {
	        click(locateElement(Locators.XPATH, SAVE_BUTTON));
	        reportStep("Opportunity veried successfully", "pass");
	        return new VerifyOpportunity();
	    }
	}

