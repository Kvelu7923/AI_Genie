package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC012_DeleteWorkType extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "TC012_DeleteWorkType";
		testDescription ="Verify that an existing Work Type can be deleted successfully";
		authors="Ram";
		category ="WorkType";
		excelFileName="EditWorkTypeGroup";
		
	}
	
	@Test( dataProvider = "fetchData",dependsOnMethods = "com.salesforce.testcases.TC005_CreateWorkType.createWorkType")
	public void runLogin( String search,String name,String editName,String verifyMsg ) {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.enterSearchField(search)
		.clickWorkTypeGroupLink()
		.enterWorkTypeSearchField(name)
		.clickShowActionDD()
		.clickDeleteLink()
        .confirmDelete()
		.verifyWorkTypeGroups(verifyMsg);
		
		
	

	}

}
