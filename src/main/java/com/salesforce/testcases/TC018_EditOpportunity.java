package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC018_EditOpportunity extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "TC018_EditOpportunity";
		testDescription = "Verify that an existing Opportunity can be edited and updated successfully";
		authors = "Udai";
		category = "Smoke";
	}

	@Test()
	public void runEditOpportunity() {
		new LoginPage().enterUsername().enterPassword().clickLogin().clickAppLauncher().clickViewAll().typeSales()
				.clickSales().clickOpportunities().clickEditOpportunity().editCloseDateasTomorrow().editStage()
				.editDescription().clickSave().verifyOpportunityEdited();

	}

}
