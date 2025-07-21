package com.salesforce.pages;

	import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebElement;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;
 
	public class CreateNewOpportunitiesPage extends ProjectSpecificMethods {

	    private static final String OPPORTUNITY_NAME_INPUT = "//label[text()='Opportunity Name']/following::input[1]";
	    private static final String CLOSE_DATE_INPUT = "//label[text()='Close Date']/following::input[1]";
	   // private static final String TODAY_BUTTON = "//button[text()='Today']";
	    private static final String STAGE_DROPDOWN = "//label[text()='Stage']/following::button[1]";
	    private static final String NEEDS_ANALYSIS_STAGE = "//div[@aria-label='Stage']//span[text()='Needs Analysis']";
	    private static final String SAVE_BUTTON = "//button[@name='SaveEdit']";

	    public CreateNewOpportunitiesPage enterOpportunityName(String oppName) {
	        clearAndType(locateElement(Locators.XPATH, OPPORTUNITY_NAME_INPUT), oppName);
	        reportStep("Entered Opportunity Name: " + oppName, "pass");
	        return this;
	    }
//
//	    public CreateNewOpportunitiesPage selectCloseDate() {
//	        click(locateElement(Locators.XPATH, CLOSE_DATE_INPUT));
//	        clickUsingJs(locateElement(Locators.XPATH, TODAY_BUTTON));
//	        reportStep("Selected Close Date as Today", "pass");
//	        return this;
//	    }

	    public CreateNewOpportunitiesPage selectCloseDate() {
			click(Locators.XPATH, CLOSE_DATE_INPUT);
			LocalDate today = LocalDate.now();
			LocalDate targetDate = today.plusDays(5);
			String targetDay = String.valueOf(targetDate.getDayOfMonth());
			String monthName = targetDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
			while (true) {
				WebElement monthElement = locateElement(Locators.XPATH, "//h2[contains(@id,'month-title')]");
				String displayedMonthYear = getElementText(monthElement);
				if (displayedMonthYear.equalsIgnoreCase(monthName)) {
					break;
				}
				click(locateElement(Locators.XPATH, "//button[@title='Next Month']"));
			}
			List<WebElement> allDays = locateElements(Locators.XPATH,
					"//table[@class='slds-datepicker__month']//span[@class='slds-day']");
			for (WebElement day : allDays) {
				if (day.getText().equals(targetDay)) {
					day.click();
					break;
				}
			}
			reportStep("Due date selected successfully", "pass");
			return this;
		}
	    
	    public CreateNewOpportunitiesPage selectStage() {
	        clickUsingJs(locateElement(Locators.XPATH, STAGE_DROPDOWN));
	        click(locateElement(Locators.XPATH, NEEDS_ANALYSIS_STAGE));
	        reportStep("Selected Stage as: Needs Analysis", "pass");
	        return this;
	    }

	    public VerifyOpportunity clickSave() {
	        click(locateElement(Locators.XPATH, SAVE_BUTTON));
	        reportStep("Clicked Save button", "pass");
	        return new VerifyOpportunity();
	    }
	}



