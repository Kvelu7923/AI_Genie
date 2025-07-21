package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC001_CreateNewCase extends ProjectSpecificMethods {

    @BeforeTest
    public void setValues() {
        testcaseName = "TC_001_Create New Case";
        testDescription = "Creates and verifies a new Salesforce Case using data from Excel";
        authors = "Jagadish";
        category = "Case Management";
        excelFileName = "CreateCase"; 
    }

    @Test(dataProvider = "fetchData")
    public void runCreateNewCase(String search,String salutation,String firstName,String lastName, String status, String origin, String subject, String description) {
       

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
            .verifyCreatedCase(firstName);
    }
}
