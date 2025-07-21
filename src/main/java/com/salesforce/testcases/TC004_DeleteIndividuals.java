package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC004_DeleteIndividuals extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "TC004_DeleteIndividuals";
		testDescription ="Verify that Individual records can be deleted successfully";
		authors="Harrish";
		category ="Individuals";
		excelFileName="DeleteIndividuals";
		
		
	}
	
	@Test( dataProvider = "fetchData",dependsOnMethods = {"com.salesforce.testcases.TC002_CreateIndividuals.createNewIndividuals"})
	public void deleteIndividuals(String search,String name,String verifyMsg) {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.enterSearchField(search)
		.clickIndividualsLink()
		.enterIndividualSearchField(name)		
		.clickShowActionDD()
		.clickDeleteLink()
		.clickPoupDeleteButton()
		.verifyDeleteIndividuals(verifyMsg);

	}

}