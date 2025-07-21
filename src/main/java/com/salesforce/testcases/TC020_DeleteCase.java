package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC020_DeleteCase extends ProjectSpecificMethods {

    @BeforeTest
    public void setValues() {
    	testcaseName = "TC020_DeleteCase";
        testDescription = "Verify an existing case can be deleted successfully";
        authors = "Jagadish";
        category = "Case Management";
        excelFileName = "DeleteCase";
    }

    @Test(dataProvider = "fetchData")
    public void runDeleteCase(String search,String salutation,String firstName,String lastName, String status, String origin, String subject, String description) {
     

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
            .clickDelete()
            .confirmDeletion()
        .verifyDeleteCases(firstName);
      
            
        
            
            
    }
}
