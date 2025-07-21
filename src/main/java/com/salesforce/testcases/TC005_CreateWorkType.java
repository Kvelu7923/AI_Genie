package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC005_CreateWorkType extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "TC005_CreateWorkType";
		testDescription ="Verify that a new Work Type can be created successfully using Excel input data";
		authors="Harrish";
		category ="WorkType";
		excelFileName="CreateWorkTypeGroup";
		
	}
	
	@Test( dataProvider = "fetchData")
	public void createWorkType(String search,String name,String desc,String dd,String verifyMsg) {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.enterSearchField(search)
		.clickWorkTypeGroupLink()
		.clickWorkTypeGroupTab()
		.clickNewWorkTypeGroup()
		.enterWorkTypeGroupName(name)
		.enterWorkTypeDesc(desc)
		.selectGroupType()
		.clickWorkTypeSaveButton()
		.verifyWorkTypeGroups(verifyMsg);
		
	

	}

}
