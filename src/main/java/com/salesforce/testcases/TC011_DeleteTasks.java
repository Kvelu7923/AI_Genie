package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC011_DeleteTasks extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "TC011_DeleteTasks";
		testDescription ="Verify that an existing Task can be deleted successfully";
		authors="Easwar";
		category ="Smoke";
		excelFileName="DeleteTask";
	}
	
	@Test(dataProvider = "fetchData",dependsOnMethods = "com.salesforce.testcases.TC009_CreateTasks.runCreateTasks")
	public void runDeleteTasks(String app,String text) {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.enterSearchField(app)
		.clickSales()
		.clickTasksTab()
		.selectTableView()
		.clickEditDropdown()
		.clickDeleteButton()
		.verifyTaskDeleted(text);

	}
}
