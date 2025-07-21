package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC021_CreateAccount extends ProjectSpecificMethods{

	@BeforeTest
	public void setValues() {
		testcaseName = "TC015_CreateAccount";
		testDescription ="Verify that a new Account is created successfully";
		authors="Hari";
		category ="Smoke";
		excelFileName="CreateAccount";
		
	}
	
	@Test( dataProvider = "fetchData")
	public void runCreateAccount(String appName,String tabName,String accountName,String phone,String website,String industry) {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.selectApp(appName)
		.clickTab(tabName)
		.clickNewAccount()
		.enterAccountName(accountName)
		.enterPhone(phone)
		.enterWebsite(website)
		.selectIndustry(industry)
		.clickSaveAccount();
		
		
	
	}
}