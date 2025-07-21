package com.salesforce.testcases;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;
public class TC013_CreateOpportunity extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setValues() {
		testcaseName = "TC013_CreateOpportunity";
		testDescription ="Verify that a new Opportunity is created successfully";
		authors="Udai";
		category ="Smoke";
		excelFileName="CreateOpportunity";
		
	}

	@Test(dataProvider = "fetchData")
	public void runCreateOpportunity(String oppName) {
		
		
		  new LoginPage() 
		  .enterUsername() 
		  .enterPassword() 
		  .clickLogin()
		  .clickAppLauncher() 
		  .clickViewAll() 
		  .typeSales() 
		  .clickSales()
		  .clickOpportunities() 
		  .clickNewOpportunity() 
		  .enterOpportunityName(oppName)
		  .selectCloseDate() 
		  .selectStage() 
		  .clickSave() 
		  .verifyOpportunityCreated();
		 
		
		
			
	}


}
