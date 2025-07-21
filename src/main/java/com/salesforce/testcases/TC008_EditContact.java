package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC008_EditContact extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "TC008_EditContact";
		testDescription ="Verify that an existing Contact can be updated successfully with new data";
		authors="Hari";
		category ="Smoke";
		excelFileName="EditContact";
		
	}
	
	@Test(dataProvider = "fetchData",dependsOnMethods = {"com.salesforce.testcases.TC007_CreateContact.runCreateContact"})
	public void editContact(String contactName,String phno) {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.typeSales()
		.clickSales()
		.clickContact()
		.searchContact(contactName)
		.clickDropdown()
		.clickEdit()
		.enterPhoneNumber(phno)
		.clickSaveOnEdit()
		.verifyToastMessage(contactName);
	}

}
