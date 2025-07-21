package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC024_EditLegalEntity extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "TC024_EditLegalEntity";
		testDescription ="Verify the LegalEntity is edited successfully";
		authors="Hari";
		category ="Smoke";
		excelFileName="EditLegalEntity";
		
	}
	
	@Test(dataProvider = "fetchData",dependsOnMethods = {"com.salesforce.testcases.TC025_CreateLegalEntity.runCreateLegalEntity"})
	public void runEditLegalEntity(String searchField,String searchLEName,String cName,String des) {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.enterSearchField(searchField)
		.clickLegalEntity()
		.searchLegalEntity(searchLEName)
		.clickDropdown()
		.clickEdit()
		.enterCompanyName(cName)
		.enterDescription(des)
		.clickStatusDropDown()
		.selectStatus()
		.clickSaveOnEdit()
		.verifyToastMeassage()
		.clickLegalEntityName(searchLEName)
		.verifyEnteredCompanyName(cName)
		.verifyDescription(des);
		
		
	}

}
