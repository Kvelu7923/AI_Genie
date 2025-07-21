package test.api.salesforce;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.api.base.APIBase;

public class TC003_GetLead extends APIBase {

	@BeforeTest
	public void setValues() {
		testcaseName = "TC_00_Get Case";
		testDescription = "Creates and verifies a new Salesforce Case using data from Excel";
		authors = "Kathir";
		category = "Lead Creation";
		// excelFileName = "CreateCase";
	}

	@Test (dependsOnMethods ="test.api.salesforce.TC002_EditLead.runCreateNewCase")
	public void runCreateNewCase() {

		
		api().get("/lead").validateStatus(200);

	}
}
