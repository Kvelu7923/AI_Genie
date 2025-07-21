package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {

	public HomePage verifyHomePage() {
		verifyDisplayed(locateElement(Locators.XPATH, "//span[text()='Home']"));
		reportStep("Homepage is loaded Successfully", "pass");
		return this;
	}

	public HomePage clickAppLauncher() {
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='App Launcher']//div[@class='slds-icon-waffle']")));
		click(locateElement(Locators.XPATH, "//button[@title='App Launcher']//div[@class='slds-icon-waffle']"));
		reportStep("App Launcher clicked successfully", "pass");
		return this;
	}

	public HomePage clickViewAll() {
		click(locateElement(Locators.XPATH, "//button[text()='View All']"));
		reportStep("View All link clicked successfully", "pass");
		return this;
	}

	public HomePage enterSearchField(String search) {
		clearAndType(locateElement(Locators.XPATH, "//input[@placeholder='Search apps or items...']"), search);
		reportStep("Search Field entered successfully", "pass");
		return this;
	}

	public CasePage clickCasesLink() {
		click(locateElement(Locators.XPATH, "(//p[@class='slds-truncate']/mark[text()='Cases'])[1]"));
		reportStep("Cases is clicked sucessfully", "pass");
		return new CasePage();
	}

	public LegalEntity clickLegalEntity() {
		click(locateElement(Locators.XPATH, "(//p[@class='slds-truncate']/mark[text()='Legal Entities'])"));
		reportStep("Sales is clicked sucessfully", "pass");
		return new LegalEntity();
	}

	public CreateLegalEntityPage enterAppName(String search) {
		clearAndType(locateElement(Locators.XPATH, "//input[@placeholder='Search apps or items...']"), search);
		reportStep("Search Field entered successfully", "pass");
		return new CreateLegalEntityPage();
	}

	public LeadsPage clickLeadsTab() {
		clickUsingJs(locateElement(Locators.XPATH, "//a[@title='Leads']"));
		reportStep("Lead tab is clicked successfully", "pass");
		return new LeadsPage();
	}

	public AccountPage selectApp(String selectApp) {
		clearAndType(locateElement(Locators.XPATH, "//input[@placeholder='Search apps or items...']"), selectApp);
		click(locateElement(Locators.XPATH, "(//mark[text()='" + selectApp + "'])[3]"));
		reportStep("Sales clicked successfully", "pass");
		return new AccountPage();
	}

	public IndividualsPage clickIndividualsLink() {
		click(locateElement(Locators.XPATH, "//mark[text()='Individuals']"));
		reportStep("Individuals link clicked successfully", "pass");
		return new IndividualsPage();
	}

	public WorkTypeGroupPage clickWorkTypeGroupLink() {
		click(locateElement(Locators.XPATH, "//mark[text()='Work Type']"));
		reportStep("Work Type Groups link clicked successfully", "pass");
		return new WorkTypeGroupPage();
	}

	public HomePage clickSales() {
		click(locateElement(Locators.XPATH, "(//p[@class='slds-truncate']/mark[text()='Sales'])[3]"));
		reportStep("Sales is clicked sucessfully", "pass");
		return this;
	}

	public OpportunityPage clickOpportunities() {
		clickUsingJs(locateElement(Locators.XPATH, "//span[text()='Opportunities']"));
		reportStep("Clicked Opportunities Successfully", "pass");
		return new OpportunityPage();
	}

	public TasksPage clickTasksTab() {
		clickUsingJs(locateElement(Locators.XPATH, "//span[text()='Tasks']"));
		reportStep("Tasks Tab is clicked sucessfully", "pass");
		return new TasksPage();
	}

	public HomePage typeSales() {
		typeAndEnter(locateElement(Locators.XPATH,
				"//div[contains(@class,'slds-form-element__control slds-grow')]//input[1]"), "Sales");
		reportStep("Search for sales is done successfully", "pass");
		return this;
	}

	public ContactPage clickContact() {
		clickUsingJs(locateElement(Locators.XPATH, "//span[text()='Contacts']"));
		reportStep("Clicked Contacts Successfully", "pass");
		return new ContactPage();
	}

}
