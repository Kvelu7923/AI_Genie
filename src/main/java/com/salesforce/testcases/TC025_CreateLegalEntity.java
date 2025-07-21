package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC025_CreateLegalEntity extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "TC025_CreateLegalEntity";
		testDescription ="Verify the legalEntity is created successfully";
		authors="hari";
		category ="Smoke";
		excelFileName="CreateLegalEntity";
		
	}
	
	@Test( dataProvider = "fetchData")
	public void runCreateLegalEntity(String search,String EntityName) {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.enterSearchField(search)
		.clickLegalEntity()
		.clickNewLegalEntity()
		.enterLegalEntityName(EntityName)
		.clickSave()
		.verifyToastMeassage();
	}

}
