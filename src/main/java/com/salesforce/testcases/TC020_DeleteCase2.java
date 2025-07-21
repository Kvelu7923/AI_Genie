package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC020_DeleteCase2 extends ProjectSpecificMethods {

    @BeforeTest
    public void setValues() {
    	testcaseName = "TC020_DeleteCase";
        testDescription = "Verify an existing case can be deleted successfully";
        authors = "Jagadish";
        category = "Case Management";
        excelFileName = "DeleteCase2";
    }

    @Test(dataProvider = "fetchData",invocationCount = 10)
    public void runDeleteCase(String search) {
        new LoginPage()
            .enterUsername()
            .enterPassword()
            .clickLogin()
            .clickAppLauncher()
            .clickViewAll()
            .enterSearchField(search)
            .clickCasesLink()
            .clickShowActionDD()
            .clickDeleteOption()
            .confirmDeletion();
    }
}
