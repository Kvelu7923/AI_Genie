package test.api.salesforce;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.api.base.APIBase;

public class TC002_EditLead extends APIBase {

	@BeforeTest
	public void setValues() {
		testcaseName = "TC_002_Edit Case";
		testDescription = "Creates and verifies a new Salesforce Case using data from Excel";
		authors = "Kathir";
		category = "Lead Creation";
		// excelFileName = "CreateCase";
	}

	@Test (dependsOnMethods ="test.api.salesforce.TC001_CreateLead.runCreateNewCase")
	public void runCreateNewCase() {
		String body = "{\r\n"
				+ "\"FirstName\": \"Fire\",\r\n"
				+ "\"Title\": \"SDET\",\r\n"
				+ "\"Street\": \"Lion Street\",\r\n"
				+ "\"City\" : \"Valliur\",\r\n"
				+ "\"State\": \"Tamil Nadu\",\r\n"
				+ "\"PostalCode\":\"1999\",\r\n"
				+ "\"Country\":\"Ninja World\",\r\n"
				+ "\"MobilePhone\":\"8428543434\",\r\n"
				+ "\"Email\":\"majay3574@gmail.com\",\r\n"
				+ "\"Website\":\"www.ninjaworld.com\"\r\n"
				+ "}";
		
		api().patch(body, "/lead/"+id).validateStatus(204);

	}
}
