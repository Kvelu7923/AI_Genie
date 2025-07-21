package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC014_DeleteContact extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "TC014_DeleteContact";
		testDescription ="Verify that an existing Contact can be deleted successfully";
		authors="Hari";
		category ="Smoke";
		excelFileName="EditContact";
		
	}
	
	@Test(dataProvider = "fetchData",dependsOnMethods = {"com.salesforce.testcases.TC007_CreateContact.runCreateContact"})
	public void runCreateContact(String contactName,String phno) {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.typeSales()
		.clickSales()
		.clickContact()
		.searchContactName(contactName)
		.clickActionDropdown()
        .clickDeleteOption()
        .confirmDelete();
	}

}
