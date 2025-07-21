package test.api.salesforce;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.api.base.APIBase;

public class TC001_CreateLead extends APIBase {

	
	 @BeforeTest
	    public void setValues() {
	        testcaseName = "TC_001_Create New Case";
	        testDescription = "Creates and verifies a new Salesforce Case using data from Excel";
	        authors = "Kathir";
	        category = "Lead Creation";
	        //excelFileName = "CreateCase"; 
	    }

	    @Test//(dataProvider = "fetchData")
	    public void runCreateNewCase() {
	    	 id= (String) api().post("{\r\n"
	    	 		+ "    \"FirstName\": \"kathir\",\r\n"
	    	 		+ "    \"LastName\": \"A\",\r\n"
	    	 		+ "    \"Company\": \"Testleaf\"\r\n"
	    	 		+ "}", "/lead")
             .validateStatus(201)
             .validateBodyContains("id").getValueFromJsonResponse("id");

	    	            System.out.println("Created Lead ID: " + id);
	    }
}
