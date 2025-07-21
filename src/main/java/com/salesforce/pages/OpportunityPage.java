package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class OpportunityPage extends ProjectSpecificMethods {

    // Global variables for XPath locators
    private static final String NEW_OPPORTUNITY_BUTTON = "//div[@title='New']";
    private static final String OPPORTUNITY_ACTION = "//span[@data-cell-type='lstOutputLookup']/following::span[@data-cell-type='lstListViewRowLevelAction']";
    private static final String EDIT_OPPORTUNITY_BUTTON = "//a[@title='Edit']";
    private static final String DELETE_OPPORTUNITY_BUTTON = "//a[@title='Delete']";
    private static final String CONFIRM_DELETE_BUTTON = "//button[@title='Delete']";

    public CreateNewOpportunitiesPage clickNewOpportunity() {
        click(locateElement(Locators.XPATH, NEW_OPPORTUNITY_BUTTON));
        reportStep("Clicked New Opportunity button successfully", "pass");
        return new CreateNewOpportunitiesPage();
    }

    public EditOpportunityPage clickEditOpportunity() {
        click(locateElement(Locators.XPATH, OPPORTUNITY_ACTION));
        click(locateElement(Locators.XPATH, EDIT_OPPORTUNITY_BUTTON));
        reportStep("Clicked Edit Opportunity button successfully", "pass");
        return new EditOpportunityPage();
    }

    public VerifyOpportunity deleteOpportunity() {
        click(locateElement(Locators.XPATH, OPPORTUNITY_ACTION));
        click(locateElement(Locators.XPATH, DELETE_OPPORTUNITY_BUTTON));
        click(locateElement(Locators.XPATH, CONFIRM_DELETE_BUTTON));
        reportStep("Deleted Opportunity successfully", "pass");
        return new VerifyOpportunity();
    }
}
