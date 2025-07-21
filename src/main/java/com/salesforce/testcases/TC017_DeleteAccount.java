package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC017_DeleteAccount extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "TC017_DeleteAccount";
		testDescription ="Verify that an existing Account can be deleted successfully";
		authors="Hari";
		category ="Smoke";
		excelFileName="DeleteAccount";
		
	}
	
	@Test( dataProvider = "fetchData",dependsOnMethods = "com.salesforce.testcases.TC021_CreateAccount.runCreateAccount")
	public void runCreateAccount(String appName,String tabName,String accountName) {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.selectApp(appName)
		.clickTab(tabName)
		.searchAccountName(accountName)
		.clickShowActionDD()
		.clickDelete()
		.confirmDeletion()
		.verifyToastMessage(accountName);		
	}
}
