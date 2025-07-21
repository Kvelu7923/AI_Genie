package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC023_EditLead  extends ProjectSpecificMethods{
	
	
	@BeforeTest
	public void setValues() {
		testcaseName="TC023_EditLead";
		testDescription="Verify the Lead can be edited successfully";
		authors="Harrish";
		category="Regression";
		excelFileName = "EditLead";
	}
	
	
	@Test(dataProvider = "fetchData",dependsOnMethods = {"com.salesforce.testcases.TC022_CreateLead.runCreateLead"})
	public void runEditLead(String selectApp ,String newName) {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.enterSearchField(selectApp)
		.clickSales()
		.clickLeadsTab()
		.clickDropdown()
		.clickEdit()
		.enterNewName(newName)
		.clickSaveButton()
		.verifyUpdatedName(newName);		

	}

}
