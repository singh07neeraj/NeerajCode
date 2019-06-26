package javaMain.eCorp.ThriftSavingPlan;

import static Utilities.ReadData.getObj;

import org.openqa.selenium.By;

import Utilities.Input;
import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_THRIFTSAVINGPLAN_COMPANY_INQUIRY_FUNC extends TestBase {

	public static Boolean CompanyInquiry(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		Utils.refreshScreeen();
		try {
			
			Utils.click(By.xpath(getObj("Propval1", "ThriftSavingPlan", "eCorp_ThriftSavingPlan_CompanyInquiry")), "Thrift Saving Plan");

			Utils.click(By.xpath(getObj("Propval1", "CompanyInquiry", "eCorp_ThriftSavingPlan_CompanyInquiry")), "Company Inquiry");
			

			// Verify landing page
			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_ThriftSavingPlan_CompanyInquiry")));

			Log.pass("Landed Page is  :" + LandPage);
			Utils.logPassImage(TCName);
			// Page Validation

			
			addFavSendEmailDownloadPdfNprintFuncBeneficiary(TCName);
			Utils.logPassImage(TCName);
			
		}

		catch (Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFuncBeneficiary(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					"Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					"Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					"Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					"Send Email Button");
			Utils.waitForInVisibilityOfEle(
					By.xpath(getObj("Propval1", "WaitingElements", "eCorp_ThriftSavingPlan_CompanyInquiry")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					"pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					"Excel Download");
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "eCorp_ThriftSavingPlan_CompanyInquiry")),
					"Print Button");
			// close all other tabs except the main one. i.e 1st page.
			Utils.closeOtherTabs();

		}

		catch (Exception e) {
			Log.error("Unable to send email semail, print and download pdf etc.");
			Utils.logFailImage("Error");
			runResult = false;
			throw e;

		}

		return runResult;
	}

}
