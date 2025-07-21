package com.salesforce.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class TasksPage extends ProjectSpecificMethods {

	public TasksPage clickNewTask() {
		pause(3000);
		click(locateElement(Locators.XPATH,
				"//span[text()='Show more actions']/preceding-sibling::lightning-primitive-icon"));
		pause(3000);
		clickUsingJs(locateElement(Locators.XPATH, "//div[text()='New Task']"));
		reportStep("New task is clicked sucessfully", "pass");
		return this;
	}

	public TasksPage selectContact() {
		click(locateElement(Locators.XPATH, "//input[@placeholder='Search Contacts...']"));
		click(locateElement(Locators.XPATH, "//div[contains(@class,'primaryLabel')]//span"));
		reportStep("Contact is selected sucessfully", "pass");
		return this;
	}

	public TasksPage enterCommet(String comment) {
		clearAndType(locateElement(Locators.XPATH, "(//span[text()='Comments'])[2]/following::textarea"), comment);
		reportStep("Contact is selected sucessfully", "pass");
		return this;
	}

	public TasksPage clickSaveButton() {
		click(locateElement(Locators.XPATH, "//span[text()='Save']"));
		reportStep("Save button is clicked sucessfully", "pass");
		return this;
	}

	public TasksPage verifyTheMessage() {
		String elementText = getElementText(
				locateElement(Locators.XPATH, "//span[@class='genericError uiOutputText']"));
		if (elementText.contains("Review the errors on this page.")) {
			reportStep("verified successfully", "pass");
		} else
			reportStep("not verified successfully", "fail");
		return this;
	}

	public TasksPage enterSubject(String subject) {
		clearAndType(locateElement(Locators.XPATH, "//label[text()='Subject']/following::input"), subject);
		reportStep(" Subject is entered successfully", "pass");
		return this;
	}

	public TasksPage selectStatus(String status) {
		click(locateElement(Locators.XPATH, "(//span[text()='Status'])[2]/following::a"));
		click(locateElement(Locators.XPATH, "//a[@title='" + status + "']"));
		reportStep("Status is selected sucessfully", "pass");
		return this;
	}

	public TasksPage verifyTasksCreated(String text) {
		String elementText = getElementText(locateElement(Locators.XPATH,
				"//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]"));
		if (elementText.contains(text)) {
			reportStep("Task created successfully", "pass");
		} else
			reportStep("Task not created successfully", "fail");
		return this;
	}

	public TasksPage selectRecentlyViewed() {
		click(locateElement(Locators.XPATH, "//button[@title='Select a List View: Tasks']"));
		clickUsingJs(locateElement(Locators.XPATH, "//a[@role='option']//span[text()='Recently Viewed']"));
		reportStep("Recently Viewed is selected sucessfully", "pass");
		return this;
	}

	public TasksPage selectTableView() {
		click(locateElement(Locators.XPATH, "//button[@title='Select list display']"));
		clickUsingJs(locateElement(Locators.XPATH, "//span[text()='Table']"));
		reportStep(" Table View is selected sucessfully", "pass");
		return this;
	}

	public TasksPage clickEditDropdown() {
		click(locateElement(Locators.XPATH, "//span[@class='slds-icon_container slds-icon-utility-down']/span"));
		reportStep("Edit dropdown is clicked sucessfully", "pass");
		return this;
	}

	public TasksPage clickEditButton() {
		clickUsingJs(locateElement(Locators.XPATH, "//div[text()='Edit']"));
		reportStep("Edit button is clicked sucessfully", "pass");
		return this;
	}

	public String addDate(int num) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, num);
		String format = sdf.format(cal.getTime());
		System.out.println(format);
		return format;
	}

	public TasksPage enterDate(String num) {
		
		String selectDate = addDate(Integer.parseInt(num));
		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
		WebElement FromDate = locateElement(Locators.XPATH, "//label[text()='Due Date']/following::input");
		js.executeScript("arguments[0]. value='" + selectDate + "';", FromDate);
		reportStep(" Date is entered successfully", "pass");
		return this;
	}

	public TasksPage selectPriority(String priority) {
		clickUsingJs(locateElement(Locators.XPATH, "(//span[text()='Priority'])[2]/following::a"));
		clickUsingJs(locateElement(Locators.XPATH, "//a[text()='" + priority + "']"));
		reportStep("Priority is selected sucessfully", "pass");
		return this;
	}

	public TasksPage clickSaveEditButton() {
		click(locateElement(Locators.XPATH, "(//span[text()='Save'])[2]"));
		reportStep("Save button is clicked sucessfully", "pass");
		return this;
	}

	public TasksPage verifyEditIsSaved(String text) {
		pause(2000);
		String elementText = getElementText(locateElement(Locators.XPATH,
				"//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]"));
		if (elementText.contains(text)) {
			reportStep("Task edited successfully", "pass");
		} else
			reportStep("Task not edited successfully", "fail");
		return this;
	}

	public TasksPage clickDeleteButton() {
		click(locateElement(Locators.XPATH, "//a[@data-target-selection-name='sfdc:StandardButton.Task.Delete']"));
		click(locateElement(Locators.XPATH, "//span[normalize-space()='Delete']"));
		reportStep("Delete button is clicked sucessfully", "pass");
		return this;
	}

	public TasksPage verifyTaskDeleted(String text) {
		pause(2000);
		String elementText = getElementText(locateElement(Locators.XPATH,
				"//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]"));
		if (elementText.contains(text)) {
			reportStep("Task deleted successfully", "pass");
		} else
			reportStep("Task not deleted successfully", "fail");
		return this;
	}

}
