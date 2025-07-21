package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC010_EditTasks extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "TC010_EditTasks";
		testDescription ="Verify that an existing Task can be edited and updated successfully";
		authors="Easwar";
		category ="Smoke";
		excelFileName="EditTask";
	}
	
	@Test(dataProvider = "fetchData",dependsOnMethods = {"com.salesforce.testcases.TC009_CreateTasks.runCreateTasks"})
	public void runEditTasks(String app,String num,String priority,String text) {
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
		.clickEditButton()
		.enterDate(num)
		.selectPriority(priority)
		.clickSaveEditButton()
		.verifyEditIsSaved(text);

	}

}
