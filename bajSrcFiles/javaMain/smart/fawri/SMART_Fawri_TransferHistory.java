package javaMain.smart.fawri;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static Utilities.ReadData.readConfigXml;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenMenuesSmart;

public class SMART_Fawri_TransferHistory extends TestBase{
	
	public static String AccountNumber,TransferVia,BeneficiaryType,Status,AmountFrom,AmountTo,StartDate_Date_Previous,StartDate_Month_Previous,StartDate_Year_Previous,StartDate_Date_Future,StartDate_Month_Future,StartDate_Year_Future,AMOUNT,Category,Purpose,PaymentDetails,Proceed, Confirm, OTPProceed, CancelYes, BeneficiaryActivationMode,TestType;
	public static boolean fawriTransferHistory (String TCName, int ScenarioCount, Object[] tCsDataset)
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
				
				
				AMOUNT = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AMOUNT"));
				Category = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Category"));
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
				
				
				AMOUNT = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AMOUNT"));
				Category = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Category"));
				Purpose = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Purpose"));
				PaymentDetails = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("PaymentDetails"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				CancelYes = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CancelYes"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));
				
			}
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			OpenMenuesSmart.openFawriMenu("TransfersHistory");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "fawriTransferHistory_title", "SMART_FAWRI_TRANSFER_HISTORY")), "Transfer History home page"));

				Log.pass(" Transfer History home page appearing successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "fawriTransferHistory_title", "SMART_FAWRI_TRANSFER_HISTORY"))));

				Utils.logPassImage("Transfer History home page appearing-pass");


			} catch (AssertionError | Exception e) {

				Log.fail("Transfer History home page not appearing");
				Utils.logFailImage("Transfer History home page not appearing-fail");

				throw e;

			}
			Utils.click_Smart(By.xpath(getObj("Propval1", "Beneficiary_lnk", "SMART_FAWRI_TRANSFER_HISTORY")), "Beneficiary link");
			Utils.wait(2);
			BeneficiaryType="(//p[contains(text(),'"+BeneficiaryType+"')])[1]";
			Utils.click_Smart(By.xpath(BeneficiaryType), "Click on Beneficiary Type");
			//Select Status
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "TransactionStatus_DD", "SMART_FAWRI_TRANSFER_HISTORY")),Status, "Status DropDOwn");
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "AmountFrom_txt", "SMART_FAWRI_TRANSFER_HISTORY")),AmountFrom,"AmountFrom text box");
			Utils.click_Smart(By.xpath(getObj("Propval1", "AmountTo_lnk", "SMART_FAWRI_TRANSFER_HISTORY")), "AmountTo link");
			Utils.scrollIntoView(By.xpath(getObj("Propval1", "Beneficiary_lnk", "SMART_FAWRI_TRANSFER_HISTORY")));
			Utils.sendKeys_Smart1(By.xpath(getObj("Propval1", "AmountTo_txt", "SMART_FAWRI_TRANSFER_HISTORY")),AmountTo,"AmountTo text box");
			Utils.click_Smart(By.xpath(getObj("Propval1", "StartDate_lnk", "SMART_FAWRI_TRANSFER_HISTORY")), "StartDate link");
			
			Utils.wait(2);
			//Utils.click_Smart(By.xpath(getObj("Propval1", "StartDate_lnk", "SMART_FAWRI_TRANSFER_HISTORY")), "Start date link");
			Changedate_Smart(StartDate_Date_Future, "DateIncreasing_clk", "SMART_FAWRI_TRANSFER_HISTORY", " '+' button to select future date");
			Changedate_Smart(StartDate_Month_Future, "MonthIncreasing_clk", "SMART_FAWRI_TRANSFER_HISTORY", " '+' button to select future month");
			Changedate_Smart(StartDate_Year_Future, "YearIncreasing_clk", "SMART_FAWRI_TRANSFER_HISTORY", " '+' button to select future Year");
			Changedate_Smart(StartDate_Date_Previous, "DateDecreasing_clk", "SMART_FAWRI_TRANSFER_HISTORY", " '-' button to select previous date");
			Changedate_Smart(StartDate_Month_Previous, "MonthDecreasing_clk", "SMART_FAWRI_TRANSFER_HISTORY", " '-' button to select previous Month");
			Changedate_Smart(StartDate_Year_Previous, "YearDecreasing_clk", "SMART_FAWRI_TRANSFER_HISTORY", " '-' button to select previous Year");
			

			Utils.click_Smart(By.xpath(getObj("Propval1", "Search_btn", "SMART_FAWRI_TRANSFER_HISTORY")), "Search button");
			Utils.wait(10);
			if (Proceed.equalsIgnoreCase("true"))
			{

				try {
					Assert.assertTrue(Utils.assertDisplayed_Smart(By.xpath(getObj("Propval1", "Error_AfterSearch", "SMART_FAWRI_TRANSFER_HISTORY")), "Error After clicking on search button"));
					

					Log.pass("No results found on the screen...");
					Utils.logPassImage("No results found on the screen-pass");
					return true;
					

				} catch (AssertionError | Exception e) {

					Log.pass("Complaint management search results displayed on the screen");
					Utils.logPassImage("Search results displayed on the screen");

				}
				
				Utils.click_Smart(By.xpath(getObj("Propval1", "Transfers_Row_Click", "SMART_FAWRI_TRANSFER_HISTORY")), "Transfers Row click");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));


				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "TransferDetails_Title", "SMART_FAWRI_TRANSFER_HISTORY")), "TransferDetails Home page"));
					Log.pass(" Transfer details home page appearing as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "TransferDetails_Title", "SMART_FAWRI_TRANSFER_HISTORY"))));
					Utils.logPassImage("Transfer details home page appearing-pass");

				} catch (AssertionError | Exception e) {

					Log.fail("Transfer details home page not appearing");
					Utils.logFailImage("Transfer details home page not appearing-fail");
					throw e;

				}

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Status_Validation", "SMART_FAWRI_TRANSFER_HISTORY")), "Transfer status"));
					Log.pass(" Transfer Status appearing as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "Status_Validation", "SMART_FAWRI_TRANSFER_HISTORY"))));
					Utils.logPassImage("Transfer Status appearing-pass");

				} catch (AssertionError | Exception e) {

					Log.fail("Transfer Status not appearing");
					Utils.logFailImage("Transfer Status not appearing-fail");
					throw e;

				}
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "ProductType_Validation", "SMART_FAWRI_TRANSFER_HISTORY")), "Product type"));
					Log.pass("Product type appearing as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "ProductType_Validation", "SMART_FAWRI_TRANSFER_HISTORY"))));
					Utils.logPassImage("Product type appearing as expected-pass");

				} catch (AssertionError | Exception e) {

					Log.fail("Product type not appearing");
					Utils.logFailImage("Product type not appearing-fail");
					throw e;

				}
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
