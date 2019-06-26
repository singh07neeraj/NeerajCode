package javaMain.smart.accounts;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenMenuesSmart;

public class SMART_ACCOUNTS_REPORT_LOST_STOLENCHEQUES_FUNC extends TestBase{
	static String AccountDetails;
	public static boolean SmartAccountsReportLostStolenCheques(String TCName, int ScenarioCount, Object[] tCsDataset)
			throws Exception {

		String AccountNumber,Range,FirstChequeNo,LastChequeNo,Reason,Proceed;
		
		boolean TranExecStatus=false;
		try {

			if (true) {
				
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AccountNumber=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				Range=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Range"));
				FirstChequeNo=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "FirstChequeNo"));
				LastChequeNo=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "LastChequeNo"));
				Reason=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Reason"));
				Proceed=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				
			}

			else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				Range = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Range"));
				FirstChequeNo = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("FirstChequeNo"));
				LastChequeNo = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("LastChequeNo"));
				Reason = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Reason"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
			}
			
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			
			Utils.wait(5);
			OpenMenuesSmart.openAccountMenu("LostOrStolenCheque");
			
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			
			
			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "OrderCheckBook_title", "SMART_ACCOUNTS_ORDER_CHECK_BOOK")), "Order Check Book home page"));
				
				Log.pass(" Order Check Book home page appearing successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "OrderCheckBook_title", "SMART_ACCOUNTS_ORDER_CHECK_BOOK"))));
				
				Utils.logPassImage("Order Check Book home page-pass");
				

			} catch (AssertionError | Exception e) {

				Log.fail("Order Check Book home page not appearing");
				Utils.logFailImage("Order Check Book home page-fail");
				
				throw e;

			}
		
		
			AccountDetails="//*[contains(text(),'"+AccountNumber+"')]";
			
			Utils.click(By.xpath(AccountDetails), "Click on Account Number");
			
			//Utils.click(By.xpath(getObj("Propval1", "Branch_clk", "SMART_ACCOUNTS_ORDER_CHECK_BOOK")), "Branch link");
			
			
			Range="//p[contains(text(),'"+Range+"')]";
			
			Utils.click(By.xpath(Range), "Click on Range");
			
			if (Range.equalsIgnoreCase("Range")) {
				Utils.sendKeys(By.xpath(getObj("Propval1", "FirstChequeNumber_txt", "SMART_ACCOUNTS_REPORT_LOST_STOLEN_CHEQUES")),FirstChequeNo,"FirstChequeNo text box");
				Utils.sendKeys(By.xpath(getObj("Propval1", "LastChequeNumber_txt", "SMART_ACCOUNTS_REPORT_LOST_STOLEN_CHEQUES")),LastChequeNo,"LastChequeNo text box");
			}
			else
			{
				Utils.sendKeys(By.xpath(getObj("Propval1", "ChequeNumber_txt", "SMART_ACCOUNTS_REPORT_LOST_STOLEN_CHEQUES")),FirstChequeNo,"ChequeNo text box");
			}
			
			Utils.click(By.xpath(getObj("Propval1", "Reason_lnk", "SMART_ACCOUNTS_REPORT_LOST_STOLEN_CHEQUES")), "Reason link");
			
			Reason="//p[contains(text(),'"+Reason+"')]";
			
			Utils.click(By.xpath(Reason), "Click on Range");
			
			Utils.click(By.xpath(getObj("Propval1", "AccepTerms_btn", "SMART_ACCOUNTS_REPORT_LOST_STOLEN_CHEQUES")), "Accept terms btn");
			if (Proceed.equalsIgnoreCase("true")) {
					
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "SMART_ACCOUNTS_REPORT_LOST_STOLEN_CHEQUES")), "Proceed btn");	
					
			}
			else
			{
				Utils.click(By.xpath(getObj("Propval1", "cancel", "SMART_ACCOUNTS_REPORT_LOST_STOLEN_CHEQUES")), "cancel btn");	
				return runResult;
			}
			
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.click(By.xpath(getObj("Propval1", "Confirm", "SMART_ACCOUNTS_REPORT_LOST_STOLEN_CHEQUES")), "Confirm btn");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			
				try {
					
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "StopChequeReq_FailureMsg", "SMART_ACCOUNTS_REPORT_LOST_STOLEN_CHEQUES")), "Error message on stop cheque req final page"));
					Log.pass("Your Stop Check request has completed successfully");
					Utils.logPassImage("stop cheque request successful-pass");
					

				} catch (AssertionError | Exception e) {
										
					Log.fail(" Error message appearing on stop cheque request page. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "StopChequeReq_FailureMsg", "SMART_ACCOUNTS_REPORT_LOST_STOLEN_CHEQUES"))));
					Utils.logFailImage("stop cheque request unsuccessful-fail");
					
					throw e;

				}
				
								
			}
			
		
		catch (Exception e) {
			runResult = false;
			e.printStackTrace();
			throw e;
		}
		return runResult;
	}
	
	
}
