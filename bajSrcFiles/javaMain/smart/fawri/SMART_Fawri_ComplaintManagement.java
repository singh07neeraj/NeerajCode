package javaMain.smart.fawri;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenMenuesSmart;

public class SMART_Fawri_ComplaintManagement extends TestBase{
	
	public static String AccountNumber,TransferVia,BeneficiaryType,Status,AmountFrom,AmountTo,StartDate_Date_Previous,StartDate_Month_Previous,
	StartDate_Year_Previous,StartDate_Date_Future,StartDate_Month_Future,StartDate_Year_Future,ComplaintType,MobileNumber,ComplaintDesc,Exec_Proceed,Purpose,
	PaymentDetails,Proceed, Confirm, OTPProceed, CancelYes, BeneficiaryActivationMode,TestType;
	public static boolean fawriComplaintManagement (String TCName, int ScenarioCount, Object[] tCsDataset)
			throws Exception {
				
		try {

			if (true)
			{

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AccountNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				TransferVia = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransferVia"));
				BeneficiaryType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryType"));
				Status = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Status"));
				AmountFrom = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AmountFrom"));
				AmountTo = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AmountTo"));
				StartDate_Date_Previous = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Date_Previous"));
				StartDate_Month_Previous = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Month_Previous"));
				StartDate_Year_Previous = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Year_Previous"));
				StartDate_Date_Future = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Date_Future"));
				StartDate_Month_Future = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Month_Future"));
				StartDate_Year_Future = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Year_Future"));
				ComplaintType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ComplaintType"));
				MobileNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "MobileNumber"));
				ComplaintDesc = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ComplaintDesc"));
				Exec_Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Exec_Proceed"));
								
				Purpose = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Purpose"));
				PaymentDetails = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "PaymentDetails"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				CancelYes = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CancelYes"));
				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));		      

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				TransferVia = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TransferVia"));
				BeneficiaryType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryType"));
				Status = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Status"));
				AmountFrom = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AmountFrom"));
				AmountTo = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AmountTo"));
				StartDate_Date_Previous = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Date_Previous"));
				StartDate_Month_Previous = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Month_Previous"));
				StartDate_Year_Previous= Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Year_Previous"));
				StartDate_Date_Future = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Date_Future"));
				StartDate_Month_Future = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Month_Future"));
				StartDate_Year_Future= Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Year_Future"));
				ComplaintType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ComplaintType"));
				MobileNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("MobileNumber"));
				ComplaintDesc= Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ComplaintDesc"));
				Exec_Proceed= Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Exec_Proceed"));
								
				Purpose = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Purpose"));
				PaymentDetails = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("PaymentDetails"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				CancelYes = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CancelYes"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));
				
			}
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			OpenMenuesSmart.openFawriMenu("ComplaintManagement");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "fawriComplaintMgmt_title", "SMART_FAWRI_COMPLAINT_MANAGEMENT")), "Complaint Management home page"));

				Log.pass(" Complaint Management home page appearing successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "fawriComplaintMgmt_title", "SMART_FAWRI_COMPLAINT_MANAGEMENT"))));

				Utils.logPassImage("Complaint Management home page appearing-pass");


			} catch (AssertionError | Exception e) {

				Log.fail("Complaint Management home page not appearing");
				Utils.logFailImage("Complaint Management home page not appearing-fail");

				throw e;

			}
			Utils.click_Smart(By.xpath(getObj("Propval1", "Beneficiary_lnk", "SMART_FAWRI_COMPLAINT_MANAGEMENT")), "Beneficiary link");
			Utils.wait(2);
			BeneficiaryType="(//p[contains(text(),'"+BeneficiaryType+"')])[1]";
			Utils.click_Smart(By.xpath(BeneficiaryType), "Click on Beneficiary Type");
			//Select Status
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "TransactionStatus_DD", "SMART_FAWRI_COMPLAINT_MANAGEMENT")),Status, "Status DropDOwn");
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "AmountFrom_txt", "SMART_FAWRI_COMPLAINT_MANAGEMENT")),AmountFrom,"AmountFrom text box");
			Utils.click_Smart(By.xpath(getObj("Propval1", "AmountTo_lnk", "SMART_FAWRI_COMPLAINT_MANAGEMENT")), "AmountTo link");
			Utils.scrollIntoView(By.xpath(getObj("Propval1", "Beneficiary_lnk", "SMART_FAWRI_COMPLAINT_MANAGEMENT")));
			Utils.sendKeys_Smart1(By.xpath(getObj("Propval1", "AmountTo_txt", "SMART_FAWRI_COMPLAINT_MANAGEMENT")),AmountTo,"AmountTo text box");
			Utils.click_Smart(By.xpath(getObj("Propval1", "StartDate_lnk", "SMART_FAWRI_COMPLAINT_MANAGEMENT")), "StartDate link");
			
			Utils.wait(2);
			//Utils.click_Smart(By.xpath(getObj("Propval1", "StartDate_lnk", "SMART_FAWRI_COMPLAINT_MANAGEMENT")), "Start date link");
			Changedate_Smart(StartDate_Date_Future, "DateIncreasing_clk", "SMART_FAWRI_COMPLAINT_MANAGEMENT", " '+' button to select future date");
			Changedate_Smart(StartDate_Month_Future, "MonthIncreasing_clk", "SMART_FAWRI_COMPLAINT_MANAGEMENT", " '+' button to select future month");
			Changedate_Smart(StartDate_Year_Future, "YearIncreasing_clk", "SMART_FAWRI_COMPLAINT_MANAGEMENT", " '+' button to select future Year");
			Changedate_Smart(StartDate_Date_Previous, "DateDecreasing_clk", "SMART_FAWRI_COMPLAINT_MANAGEMENT", " '-' button to select previous date");
			Changedate_Smart(StartDate_Month_Previous, "MonthDecreasing_clk", "SMART_FAWRI_COMPLAINT_MANAGEMENT", " '-' button to select previous Month");
			Changedate_Smart(StartDate_Year_Previous, "YearDecreasing_clk", "SMART_FAWRI_COMPLAINT_MANAGEMENT", " '-' button to select previous Year");
			

			Utils.click_Smart(By.xpath(getObj("Propval1", "Search_btn", "SMART_FAWRI_COMPLAINT_MANAGEMENT")), "Search button");
			Utils.wait(10);
				try {
					Assert.assertTrue(Utils.assertDisplayed_Smart(By.xpath(getObj("Propval1", "Error_AfterSearch", "SMART_FAWRI_COMPLAINT_MANAGEMENT")), "Error After clicking on search button"));
					
					Log.pass("No results found on the screen...");
					Utils.logPassImage("No results found on the screen-pass");
					return true;
					

				} catch (AssertionError | Exception e) {


					Log.pass("Complaint management search results displayed on the screen");
					Utils.logPassImage("Search results displayed on the screen");

				}
				Utils.scrollIntoView(By.xpath(getObj("Propval1", "Transaction_Row_Click", "SMART_FAWRI_COMPLAINT_MANAGEMENT")));
				Utils.click_Smart(By.xpath(getObj("Propval1", "Transaction_Row_Click", "SMART_FAWRI_COMPLAINT_MANAGEMENT")), "Transactions Row click");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "TransactionDetails_tab", "SMART_FAWRI_COMPLAINT_MANAGEMENT")), "Transaction Details tab"));
					Log.pass(" Transaction details tab appearing as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "TransactionDetails_tab", "SMART_FAWRI_COMPLAINT_MANAGEMENT"))));
					Utils.logPassImage("Transaction details tab appearing-pass");

				} catch (AssertionError | Exception e) {

					Log.fail("Transaction details tab not appearing");
					Utils.logFailImage("Transfer details tab not appearing-fail");
					throw e;

				}

				Utils.click_Smart(By.xpath(getObj("Propval1", "ComplaintDetails_tab", "SMART_FAWRI_COMPLAINT_MANAGEMENT")), "ComplaintDetails tab");
				Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "ComplaintType_DD", "SMART_FAWRI_COMPLAINT_MANAGEMENT")),ComplaintType, "Complaint Type DropDOwn");
				Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "MobileNumber_txt", "SMART_FAWRI_COMPLAINT_MANAGEMENT")),MobileNumber,"MobileNumber text box");
				Utils.pressTab();
				Utils.scrollIntoView(By.xpath(getObj("Propval1", "ComplaintDesc_txt", "SMART_FAWRI_COMPLAINT_MANAGEMENT")));
				Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "ComplaintDesc_txt", "SMART_FAWRI_COMPLAINT_MANAGEMENT")),ComplaintDesc,"Complaint Description text box");
				Utils.pressTab();
				
				if (Exec_Proceed.equalsIgnoreCase("true")) 
				{
					Utils.click_Smart(By.xpath(getObj("Propval1", "ProceedBtn", "SMART_FAWRI_COMPLAINT_MANAGEMENT")), "Proceed button");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
					Utils.wait(5);
					
				}
				else
				{
					Utils.click_Smart(By.xpath(getObj("Propval1", "CancelBtn", "SMART_FAWRI_COMPLAINT_MANAGEMENT")), "cancel button");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
					try {
						Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Homepage_OnCancel", "SMART_FAWRI_COMPLAINT_MANAGEMENT")), "Home page"));
						Log.pass("Successfully cancelled the Add new fawri beneficiary transaction and navigated to home page.");
						Utils.logPassImage("Successfully Cancelled Add new fawri beneficiary trasaction");
						return true;

					} catch (AssertionError | Exception e) {

						Log.fail("Unable to cancel transaction..error..");
						Utils.logFailImage("Unable to cancel transaction..error.");
						throw e;

					}
					
				}
				
				if (Confirm.equalsIgnoreCase("true")) {
					// Click on Confirm Button//
					Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")), "Confirm Button");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				}

				else
				{
					// Click on Cancel Button//
					Utils.click(By.xpath(getObj("Propval1", "CancelBtn", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),
							"Cancel Button on ConfirmationPage");

					if (CancelYes.equalsIgnoreCase("true")) {

						// Click on Yes Button to Cancel the Transaction//
						Utils.click(By.xpath(getObj("Propval1", "Cancel_Yes_Btn", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),
								"Yes Button to cancel Transaction");

						return runResult;

					}
					else
					{

						// Click on No Button //
						Utils.click(By.xpath(getObj("Propval1", "Cancel_No_Btn", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),
								"No Button to Continue");

						// Click on Confirm Button//
						Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), "Confirm Button");
						Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
						
					}

				}
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "ComplaintMgmt_SuccessMsg", "SMART_FAWRI_COMPLAINT_MANAGEMENT")), "Complaint Management reuslts page"));
					Log.pass("Your complaint has been logged sucessfully. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "ComplaintMgmt_SuccessMsg", "SMART_FAWRI_COMPLAINT_MANAGEMENT"))));
					Utils.logPassImage("Your complaint has been logged sucessfully-pass");
					
				} catch (AssertionError | Exception e) {

					Log.fail("Your complaint request has failed");
					Utils.logFailImage("Your complaint request has failed-fail");
					throw e;

				}
			
		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}
	public static boolean Changedate_Smart(String Datetype, String ElementName, String PageName, String Description) throws Exception {

		try {
			Utils.wait(2);
			for (int i = 0; i < Integer.parseInt(Datetype); i++) {
				Utils.click_Smart(By.xpath(getObj("Propval1", ElementName, PageName)), Description);	

			}
		}

		catch (Exception e) {
			Log.error("Unable to change date" + ExceptionUtils.getStackTrace(e));
			Utils.logFailImage("Error");
			runResult = false;
			throw e;

		}

		return runResult;
	}
	
}
