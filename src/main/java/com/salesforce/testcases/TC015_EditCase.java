package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC015_EditCase extends ProjectSpecificMethods {

    @BeforeTest
    public void setValues() {
    	 testcaseName = "TC015_EditCase";
    	    testDescription = "Verify an existing case can be edited successfully with new status and origin";
    	    authors = "Jagadish";
    	    category = "Case Management";
    	    excelFileName = "EditCase";
    }

    @Test(dataProvider = "fetchData")
    public void runEditCase(String search,String salutation,String firstName, String lastName, String status, String origin, String subject, String description,String editStatus,String editOrigin,String sla) {
 

        new LoginPage()
            .enterUsername()
            .enterPassword()
            .clickLogin()
            .clickAppLauncher()
            .clickViewAll()
            .enterSearchField(search)
            .clickCasesLink()
            .clickNewCase()
            .clickContactName()
            .clickNewContact()
            .selectSalutation(salutation)
            .enterFirstName(firstName)
            .enterLastName(lastName)
            .clickSave()
            .selectStatus(status)
            .selectCaseOrigin(origin)
            .enterSubject(subject)
            .enterDescription(description)
            .clickSaveCase()
            .verifyCreatedCase(firstName)
            .clickEdit()
            .selectStatus(editStatus)
            .selectCaseOrigin(editOrigin)
            .clickSaveCase()
            .verifyEditCases(firstName);
            
        
            
            
    }
}
