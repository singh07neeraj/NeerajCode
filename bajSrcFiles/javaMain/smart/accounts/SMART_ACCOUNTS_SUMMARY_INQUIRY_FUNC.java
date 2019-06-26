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

public class SMART_ACCOUNTS_SUMMARY_INQUIRY_FUNC extends TestBase{
	static String AccountDetails;
	public static boolean SmartAccountsSummaryEnquiryFunction(String TCName, int ScenarioCount, Object[] tCsDataset)
			throws Exception {

		String AccountCofig,NickNameCancelSave,otherActions,TransactionsRow,Transactions,Remarks,Tag,SendSMS,SendEMail,Email,AccountNumber;
		
		boolean TranExecStatus=false;
		try {

			if (true) {
				
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				Transactions=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Transactions"));
				TransactionsRow=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransactionsRow"));
				Remarks=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Remarks"));
				Tag=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Tag"));
				SendSMS=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "SendSMS"));
				SendEMail=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "SendEMail"));
				Email=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Email"));
				AccountNumber=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
		
			}

			else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				Transactions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Transactions"));
				TransactionsRow = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TransactionsRow"));
				Remarks = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Remarks"));
				Tag = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Tag"));
				SendSMS = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("SendSMS"));
				SendEMail = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("SendEMail"));
				Email = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Email"));
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
			}
			
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			
			Utils.wait(5);
			OpenMenuesSmart.openAccountMenu("AccountsSummary");
			
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			
			
			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "AccountsSummary_title", "SMART_ACCOUNTS_SUMMARY_INQUIRY")), "Accounts summary home page"));
				
				Log.pass(" Accounts summary home page appearing successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "AccountsSummary_title", "SMART_ACCOUNTS_SUMMARY_INQUIRY"))));
				
				Utils.logPassImage("Accounts summary home page-pass");
				

			} catch (AssertionError | Exception e) {

				Log.fail("Accounts summary home page not appearing");
				Utils.logFailImage("Accounts summary home page-fail");
				
				throw e;

			}

			
			//AccountDetails="//*[contains(text(),'"	+ Input.ReadTestData("SMART_ACCOUNTS_SUMMARY_INQUIRY", "AccountNumber")+ "')]";
			AccountDetails="//*[contains(text(),'"+AccountNumber+"')]";
			
			//*[contains(text(),'0104-80158059-002')]
			Utils.click(By.xpath(AccountDetails), "Click on Account Number");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			
			if (Transactions.equalsIgnoreCase("true")) {
				
			
			Utils.click(By.xpath(getObj("Propval1", "Transactions", "SMART_ACCOUNTS_SUMMARY_INQUIRY")), "Click Transactions link");
			
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			
			String Transactions_RowNum="//*[@id = 'aljazira_mobile_SelectableList_CustomListItem_"+TransactionsRow+"']";
			Utils.click(By.xpath(Transactions_RowNum), "Click on Transactions row Number");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "Remarks", "SMART_ACCOUNTS_SUMMARY_INQUIRY")), "Click Remarks text");
			Utils.sendKeys(By.xpath(getObj("Propval1", "Remarks", "SMART_ACCOUNTS_SUMMARY_INQUIRY")),Remarks,"Remarks text box");
			
				
			Utils.click(By.xpath(getObj("Propval1", "TagDropDown_clk","SMART_ACCOUNTS_SUMMARY_INQUIRY")), "click Tag drop down");
				
			Tag="//*[contains(text(),'"+Tag+"')]";
			Utils.click(By.xpath(Tag), "Click on Tag");
			
			Utils.click(By.xpath(getObj("Propval1", "Save_btn", "SMART_ACCOUNTS_SUMMARY_INQUIRY")),
					"click Save btn");
				
			Utils.wait(5);
			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMsg_TransactionDetails", "SMART_ACCOUNTS_SUMMARY_INQUIRY")), "success message on Transaction details page"));
				Log.pass(" Transaction details have been saved appearing. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "SuccessMsg_TransactionDetails", "SMART_ACCOUNTS_SUMMARY_INQUIRY"))));
				Utils.logPassImage("Transaction details successful-pass");
				
			} catch (AssertionError | Exception e) {

				Log.fail("Transaction details have not been saved");
				Utils.logFailImage("Transaction details unsuccessful-fail");
				
				throw e;

			}
			Utils.click(By.xpath(getObj("Propval1", "Accept_btn", "SMART_ACCOUNTS_SUMMARY_INQUIRY")),
					"click Accept btn");
			TranExecStatus=true;
			
			}
			if (SendSMS.equalsIgnoreCase("true")) {
				if (TranExecStatus) {
					
					Utils.wait(5);
					OpenMenuesSmart.openAccountMenu("AccountsSummary");
					
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
					
					
					try {
						Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "AccountsSummary_title", "SMART_ACCOUNTS_SUMMARY_INQUIRY")), "Accounts summary home page"));
						
						Log.pass(" Accounts summary home page appearing successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "AccountsSummary_title", "SMART_ACCOUNTS_SUMMARY_INQUIRY"))));
						
						Utils.logPassImage("Accounts summary home page-pass");
						

					} catch (AssertionError | Exception e) {

						Log.fail("Accounts summary home page not appearing");
						Utils.logFailImage("Accounts summary home page-fail");
						
						throw e;

					}
					Utils.click(By.xpath(AccountDetails), "Click on Account Number");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
					
				}
				
				Utils.click(By.xpath(getObj("Propval1", "SendSMS_btn", "SMART_ACCOUNTS_SUMMARY_INQUIRY")),
						"click Send SMS btn");
				Utils.click(By.xpath(getObj("Propval1", "SendSMS_SendBtn", "SMART_ACCOUNTS_SUMMARY_INQUIRY")),
						"click Send btn on Send SMS window");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				Utils.click(By.xpath(getObj("Propval1", "SentSMS_AcceptBtn", "SMART_ACCOUNTS_SUMMARY_INQUIRY")),
						"click Accept btn on Sent by SMS window");
				
				
				
			}
			if (SendEMail.equalsIgnoreCase("true")) {
				if (TranExecStatus) {
					
					Utils.wait(5);
					OpenMenuesSmart.openAccountMenu("AccountsSummary");
					
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
					
					
					try {
						Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "AccountsSummary_title", "SMART_ACCOUNTS_SUMMARY_INQUIRY")), "Accounts summary home page"));
						
						Log.pass(" Accounts summary home page appearing successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "AccountsSummary_title", "SMART_ACCOUNTS_SUMMARY_INQUIRY"))));
						
						Utils.logPassImage("Accounts summary home page-pass");
						

					} catch (AssertionError | Exception e) {

						Log.fail("Accounts summary home page not appearing");
						Utils.logFailImage("Accounts summary home page-fail");
						
						throw e;

					}
					AccountDetails="//*[contains(text(),'"+AccountNumber+"')]";

					Utils.click(By.xpath(AccountDetails), "Click on Account Number");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
					
				}
				Utils.click(By.xpath(getObj("Propval1", "SendEmail_btn", "SMART_ACCOUNTS_SUMMARY_INQUIRY")),
						"click Send Email btn");
				Utils.wait(5);
				
				Utils.click(By.xpath(getObj("Propval1", "OtherEmail_rdb", "SMART_ACCOUNTS_SUMMARY_INQUIRY")),
					"Other email radio button");
				Utils.click(By.xpath(getObj("Propval1", "OtherEmail_txt", "SMART_ACCOUNTS_SUMMARY_INQUIRY")),
						"click Email text box");
				Utils.sendKeys(By.xpath(getObj("Propval1", "OtherEmail_txt","SMART_ACCOUNTS_SUMMARY_INQUIRY")),
						Email,"Email text box");
				
				Utils.click(By.xpath(getObj("Propval1", "SendEmail_SendBtn", "SMART_ACCOUNTS_SUMMARY_INQUIRY")),
						"click Send btn on Send Email window");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "ErrorMsg_SentMail", "SMART_ACCOUNTS_SUMMARY_INQUIRY")), "Error message on sent mail"));
					
					Log.fail(" Error message appearing on sent mail page. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "ErrorMsg_SentMail", "SMART_ACCOUNTS_SUMMARY_INQUIRY"))));
					
					Utils.logFailImage("Sent mail unsuccessful-fail");
					Utils.click(By.xpath(getObj("Propval1", "SentEmail_AcceptBtn", "SMART_ACCOUNTS_SUMMARY_INQUIRY")),
						"click Accept btn on Sent by Email window");
					return runResult;

				} catch (AssertionError | Exception e) {

					Log.pass("Mail sent successfully");
					Utils.logPassImage("Sent mail successful-pass");
					
					

				}
				
				
				
				
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
