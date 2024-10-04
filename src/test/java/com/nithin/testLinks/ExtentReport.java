package com.nithin.testLinks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static void config() {
		
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\nithin\\testLinks\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Selenium Report");
		reporter.config().setDocumentTitle("Link Test Report");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nithin");
		ExtentTest test = extent.createTest("Web Page Testing");
		extent.flush();
	}

}
