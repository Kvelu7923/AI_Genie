package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC019_DeleteOpportunity extends ProjectSpecificMethods{

	
	@BeforeTest
	public void setValues() {
		testcaseName = "TC019_DeleteOpportunity";
		testDescription ="Verify that an existing Opportunity can be deleted successfully";
		authors="Udai";
		category ="Smoke";
	}
	@Test()
	public void runDeleteOpportunity(){
	     		new LoginPage()
	     		.enterUsername()
	     		.enterPassword()
	     		.clickLogin()
	     		.clickAppLauncher()
	     		.clickViewAll()
	     		.typeSales()
	     		.clickSales()
	     		.clickOpportunities()
	     		.deleteOpportunity()
	     		.verifyOpportunityDeleted();
	}
}

