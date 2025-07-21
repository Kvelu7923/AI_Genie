package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC009_CreateTasks extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "TC009_CreateTasks";
		testDescription ="Verify that a new Task can be created successfully using valid input data";
		authors="Vineeth";
		category ="Smoke";
		excelFileName="CreateNewTask";
	}
	
	@Test(dataProvider = "fetchData")
	public void runCreateTasks(String app,String subject,String status,String verifyText) {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()	
		.enterSearchField(app)
		.clickSales()
		.clickTasksTab()
		.clickNewTask()
		.enterSubject(subject)
		.selectContact()
		.selectStatus(status)
		.clickSaveButton()
		.verifyTasksCreated(verifyText);

	}

}
