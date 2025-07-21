package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC016_EditAccount extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "TC016_EditAccount";
		testDescription ="Verify that an existing Account can be edited and updated successfully with valid data";
		authors="Vinoth";
		category ="Smoke";
		excelFileName="EditAccount";
		
	}
	
	@Test( dataProvider = "fetchData",dependsOnMethods = "com.salesforce.testcases.TC021_CreateAccount.runCreateAccount")
	public void runCreateAccount(String appName,String tabName,String uName) {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.selectApp(appName)
		.clickTab(tabName)
		.clickShowActionDD()
		.clickEdit()
		.enterUpdatedName(uName)
		.clickSaveButton();
		
		
	}
		

}
