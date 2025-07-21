package com.framework.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.framework.api.base.APIBase;
import com.framework.selenium.api.base.DriverInstance;

public abstract class Reporter extends DriverInstance {

	private static ExtentReports extent;
	private static final ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	private static final ThreadLocal<String> testName = new ThreadLocal<String>();

	private String fileName = "result.html";
	private String pattern = "dd-MMM-yyyy HH-mm-ss";

	public String testcaseName, testDescription, authors, category, dataFileName, dataFileType, excelFileName,
			sheetName;
	public static String folderName = "";

	@BeforeSuite(alwaysRun = true)
	public synchronized void startReport() {
		String date = new SimpleDateFormat(pattern).format(new Date());
		folderName = "reports/" + date;

		File folder = new File("./" + folderName);
		if (!folder.exists()) {
			folder.mkdir();
		}
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./" + folderName + "/" + fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(!true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Salesforce");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Salesforce");
		htmlReporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		APIBase api = new APIBase();
		api.generateOAuthToken();
	}
	

	@BeforeClass(alwaysRun = true)
	public synchronized void startTestCase() {
		ExtentTest parent = extent.createTest(testcaseName, testDescription);
		parent.assignCategory(category);
		parent.assignAuthor(authors);
		parentTest.set(parent);
		testName.set(testcaseName);
	}

	public synchronized void setNode() {
		ExtentTest child = parentTest.get().createNode(getTestName());
		test.set(child);
	}

	public abstract long takeSnap();


public void reportStep(String desc, String status, boolean bSnap) {
    synchronized (test) {
        if (test.get() == null) {
            throw new IllegalStateException("Test node is not initialized. Ensure setNode() is called before reportStep.");
        }

        // Start reporting the step and snapshot
        MediaEntityModelProvider img = null;
        if (bSnap && !(status.equalsIgnoreCase("INFO") || status.equalsIgnoreCase("skipped"))) {
            long snapNumber = 100000L;
            snapNumber = takeSnap();
            try {
                img = MediaEntityBuilder
                        .createScreenCaptureFromPath("./../../" + folderName + "/images/" + snapNumber + ".jpg")
                        .build();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (status.equalsIgnoreCase("pass")) {
            test.get().pass(desc, img);
        } else if (status.equalsIgnoreCase("fail")) {
            test.get().fail(desc, img);
            throw new RuntimeException("See the reporter for details.");
        } else if (status.equalsIgnoreCase("warning")) {
            test.get().warning(desc, img);
        } else if (status.equalsIgnoreCase("skipped")) {
            test.get().skip("The test is skipped due to dependency failure");
        } else if (status.equalsIgnoreCase("INFO")) {
            test.get().info(desc);
        }
    }
}


	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

	@AfterSuite(alwaysRun = true)
	public synchronized void endResult() {
		try {
			if (getDriver() != null) {
				getDriver().quit();
			}
		} catch (UnreachableBrowserException e) {
		}
		extent.flush();
	}

	public String getTestName() {
		return testName.get();
	}

	public Status getTestStatus() {
		return parentTest.get().getModel().getStatus();
	}
}