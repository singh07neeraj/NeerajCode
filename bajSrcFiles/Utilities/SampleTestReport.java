/*package Utilities;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class SampleTestReport {

	@Test
	public static void testReport() {

		com.aventstack.extentreports.reporter.ExtentHtmlReporter htmlReporter = new com.aventstack.extentreports.reporter.ExtentHtmlReporter("D:\\JSON\\alok.html");

		com.aventstack.extentreports.ExtentReports extent = new com.aventstack.extentreports.ExtentReports();

		extent.attachReporter(htmlReporter);

		com.aventstack.extentreports.ExtentTest TestCase1 = extent.createTest(" TC# 1 Running on [ JOL channel ] " + "", "Bank Aljazzera_UAT");

		TestCase1.log(Status.PASS, "[1]  Click on add Beneficiary Within Bank AlJazira");

		// Generate Report
		extent.flush();

		// Sending email - for edit the email config or the recipients go to
		// Configuration.XML file
		// BAJ_General_SendEmail SendEmail = new BAJ_General_SendEmail();
		// SendEmail.sendEmail(HTMLReportLocation,1,0,0,TestCasesCount,CurrentDate);
		// driver.quit();
		// driver.close();

	}

}
*/