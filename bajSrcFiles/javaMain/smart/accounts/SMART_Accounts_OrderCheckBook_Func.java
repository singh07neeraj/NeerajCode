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

public class SMART_Accounts_OrderCheckBook_Func extends TestBase{
	static String AccountDetails;
	public static boolean SmartAccountsOrderCheckBook(String TCName, int ScenarioCount, Object[] tCsDataset)
			throws Exception {

		String AccountNumber,Branch,FirstChequeNo,LastChequeNo,Reason,Proceed;
		
		
		try {

			if (true) {
				
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AccountNumber=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				Branch=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Branch"));
				Proceed=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				
			}

			else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				Branch = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Branch"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				
			}
			
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			
			Utils.wait(5);
			OpenMenuesSmart.openAccountMenu("OrderCheckBook");
			
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
		
		
			AccountDetails="//p[contains(text(),'"+AccountNumber+"')]";
			
			Utils.click(By.xpath(AccountDetails), "Click on Account Number");
			
			Utils.click(By.xpath(getObj("Propval1", "Branch_clk", "SMART_ACCOUNTS_ORDER_CHECK_BOOK")), "Branch link");	
			Utils.wait(5);
			Branch="//p[contains(text(),'"+Branch+"')]";
			
			Utils.click_Smart(By.xpath(Branch), "Click on Branch");
			
			if (Proceed.equalsIgnoreCase("true")) {
					
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "SMART_ACCOUNTS_ORDER_CHECK_BOOK")), "Proceed btn");	
					
			}
			else
			{
				Utils.click(By.xpath(getObj("Propval1", "cancel", "SMART_ACCOUNTS_ORDER_CHECK_BOOK")), "cancel btn");	
				return runResult;
			}
			Utils.wait(5);
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "Confirm", "SMART_ACCOUNTS_ORDER_CHECK_BOOK")), "Confirm btn");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			
			
			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "OrderCheckBook_SuccessMsg", "SMART_ACCOUNTS_ORDER_CHECK_BOOK")), "Order check book results page"));
				Log.pass(" Your Order Checkbook request has been completed successfully. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "OrderCheckBook_SuccessMsg", "SMART_ACCOUNTS_ORDER_CHECK_BOOK"))));
				Utils.logPassImage("  Your Order Checkbook request Successful-pass");
				//return true;

			} catch (AssertionError | Exception e) {

				Log.fail(" Your Order Checkbook request not Successful. Should have failed.");
				Utils.logFailImage(" Your Order Checkbook requestnot Successful-fail");
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
