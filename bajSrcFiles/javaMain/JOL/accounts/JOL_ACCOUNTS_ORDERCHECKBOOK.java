package javaMain.JOL.accounts;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */

public class JOL_ACCOUNTS_ORDERCHECKBOOK extends TestBase {
	public static String Menu,Proceed,Confirm,nextstep,CancelYes;
	public static boolean JOL_ACCOUNTS_ORDERCHECKBOOK_Func(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception{
		
		try {


			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				Menu = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Menu"));
				Proceed =Utils.setValue( ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				nextstep = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "nextstep"));
				CancelYes = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CancelYes"));
			}

			else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				
				Menu = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Menu"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				nextstep =Utils.setValue( (String) Utils.getUiData(dataset[scenarioCount - 1]).get("nextstep"));
				CancelYes =Utils.setValue( (String) Utils.getUiData(dataset[scenarioCount - 1]).get("CancelYes"));
			}


			System.out.println("............."+nextstep);

			Utils.wait(2);
			// Click on Accounts Tab//
			Utils.click(By.xpath(getObj("Propval1", "AccountsTab", "OrderCheckBook")),"Accounts link");
			Utils.wait(4);
			// Click Beneficiaries Link on the left Panel//
			Utils.click(By.xpath(getObj("Propval1", "Checks", "OrderCheckBook")),"Checks link");
			Utils.wait(4);
			Utils.click(By.xpath(getObj("Propval1", "OrderCheckBookLnk_Menu_Y", "OrderCheckBook")),"Order Checkbook link");
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			
			
			Utils.ClearText(By.xpath(getObj("Propval1", "Account", "OrderCheckBook")));
			Utils.clickDropdownAndSendValue(
					By.xpath(getObj("Propval1", "Accountdropdown", "OrderCheckBook")),
					By.xpath(getObj("Propval1", "Account", "OrderCheckBook")),
					Input.ReadTestData("OrderCheckBook", "AccountNumber"));


			Utils.ClearText(By.xpath(getObj("Propval1", "Branch", "OrderCheckBook")));
			Utils.clickDropdownAndSendValue(
					By.xpath(getObj("Propval1", "Branchdropdown", "OrderCheckBook")),
					By.xpath(getObj("Propval1", "Branch", "OrderCheckBook")),
					Input.ReadTestData("OrderCheckBook", "Branch"));

			// Select Branch//
			//	Utils.sendKeys_DD(By.xpath(getObj("Propval1", "Branch", "OrderCheckBook")), ReadDataSQL(TCName, ScenarioCount, "Branch"));
			Utils.wait(2);
			int ProceedType = Integer.parseInt(Proceed);
			if (ProceedType == 1) {
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "Add_New_Beneficiary")),"Proceed Button");

			}

			else if (ProceedType == 2) {
				// Click on OrderStatus//
				Utils.click(By.xpath(getObj("Propval1", "OrderStatus", "OrderCheckBook")),"OrderStatus button");
				return runResult;
			}

			else if (ProceedType == 3) {
				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "Add_New_Beneficiary")),"Cancel button");
				return runResult;
			}


			int confirmPage= Utils.getSize(By.xpath(getObj("Propval1", "ModifyBtn", "Add_New_Beneficiary")));

			if(confirmPage==0)
			{
				Log.fail("Not able to proceed next. Please review Account/ Branch is vaild ?");
				return false;
			}
			int ConfirmType = Integer.parseInt(Confirm);
			if (ConfirmType == 1) {
				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "Add_New_Beneficiary")),"Confirm Button");
			} else if (ConfirmType == 2) {

				// Click on Modify Button//
				Utils.click(By.xpath(getObj("Propval1", "ModifyBtn", "Add_New_Beneficiary")),"Modify button");

				Utils.wait(5);
				// Select other Account Number//
				//Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "AccountNoDD", "OrderCheckBook")), ReadDataSQL(TCName, ScenarioCount, "AccountNumberModified"));

				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "Add_New_Beneficiary")),"Proceed Button");

				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "Add_New_Beneficiary")),"Confirm Button");

			}

			else if (ConfirmType == 3) {

				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "Add_New_Beneficiary")),"Cancel button");

				int CancelYes = Integer.parseInt(ReadDataSQL(TCName, ScenarioCount, "CancelYes"));
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				if (CancelYes == 1) {

					// Click on Yes Button to Cancel the Transaction//
					Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn_Confirm", "Add_New_Beneficiary")),"Cancel_Yes button");
					try {
						Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "OrderCheckBook_HomePage", "OrderCheckBook")), "Orde CheckBook Home page"));

						Log.pass("Order check book home page displayed successfully, So the transaction cancelled successfully");

						Utils.logPassImage("Order check book home page displayed-pass");


					} catch (AssertionError | Exception e) {

						Log.fail("Order check book home page not displayed...So the transaction not cancelled");
						Utils.logFailImage("Order check book home page not displayed-fail");

						throw e;

					}
					return runResult;

				} else if (CancelYes == 2) {

					// Click on No Button //
					Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn_Cancel", "Add_New_Beneficiary")),"Cancel_No button");

					// Click on Confirm Button//
					Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "Add_New_Beneficiary")),"Confirm button");

				}

			}
			
			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage_ResultsPage", "OrderCheckBook")), "Success Message on Results Page"));

				Log.pass("Your Order Checkbook request has been completed successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage_ResultsPage", "OrderCheckBook"))));

				Utils.logPassImage("Your Order Checkbook request has been completed successfully-pass");


			} catch (AssertionError | Exception e) {

				Log.fail("Your Order Checkbook request has not been completed");
				Utils.logFailImage("Your Order Checkbook request has not been completed-fail");

				throw e;

			}

		
			addFavSendEmailDownloadPdfNprintFunc("TestAutomation");
			
			if(nextstep.equalsIgnoreCase("OrdersStatus"))
			{

				Utils.wait(3);
				Utils.click(By.xpath(getObj("Propval1", "OrdersStatus", "OrderCheckBook")),"Orders Status Search");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "OrdersStatusSearch", "OrderCheckBook")), "Orders Status page"));

					Log.pass("Order status page displayed successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "OrdersStatusSearch", "OrderCheckBook"))));

					Utils.logPassImage("Order status page displayed-pass");


				} catch (AssertionError | Exception e) {

					Log.fail("Order status page not displayed");
					Utils.logFailImage("Order status page not displayed-fail");

					throw e;

				}
				
				
			}

			else if (nextstep.equalsIgnoreCase("NewTransaction"))

			{
				Utils.wait(3);
				Utils.click(By.xpath(getObj("Propval1", "NewTransaction", "OrderCheckBook")),"New Transaction");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "OrderCheckBook_HomePage", "OrderCheckBook")), "Orde CheckBook Home page"));

					Log.pass("Order check book home page displayed successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "OrderCheckBook_HomePage", "OrderCheckBook"))));

					Utils.logPassImage("Order check book home page displayed-pass");


				} catch (AssertionError | Exception e) {

					Log.fail("Order check book home page not displayed");
					Utils.logFailImage("Order check book home page not displayed-fail");

					throw e;

				}
				
				

			}
			else
			{
				Utils.wait(3);
				Utils.click(By.xpath(getObj("Propval1", "Home", "OrderCheckBook")),"Home button");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomeGraphic", "OrderCheckBook")), "Customer position page"));

					Log.pass("Customer position page displayed successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "HomeGraphic", "OrderCheckBook"))));

					Utils.logPassImage("Customer position page displayed-pass");


				} catch (AssertionError | Exception e) {

					Log.fail("Customer position page not displayed");
					Utils.logFailImage("Customer position page not displayed-fail");

					throw e;

				}
				
				
			}
		}

		catch (AssertionError | Exception e) {
			runResult = false;
			e.printStackTrace();
			throw e;
		}
		return runResult;
	}
	
	public static boolean addFavSendEmailDownloadPdfNprintFunc(String Nickname) throws Exception {
		List<WebElement> FavTrans=null;
		try {
			Utils.wait(3);
			FavTrans = driver.findElements(By.xpath(getObj("Propval1", "FavTrans_List", "JOL_ACCOUNT_REQUEST_STEMENT")));
			int numberOfFavTransList = FavTrans.size();
			for (int i = 1; i <numberOfFavTransList; i++) 
			{
				
				Utils.mouseHover(By.xpath(getObj("Propval1", "FavTrans_List_link", "JOL_ACCOUNT_REQUEST_STEMENT")));	
				Utils.wait(2);
				Utils.click(By.xpath(getObj("Propval1", "FavTrans_List_Del_img", "JOL_ACCOUNT_REQUEST_STEMENT")), "Click on delete");
				Utils.wait(2);
				Utils.pressTab();
				Utils.wait(2);
				Utils.pressEnter();
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			}
			
			// to click on additional options
			Log.info("Started clicking on additional options");
			Utils.click(By.xpath(getObj("Propval1", "AddAsFavourite", "OrderCheckBook")), "Add As Favourite link");
			
			//Nickname="TestAutomation";
			
			char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			StringBuilder sb = new StringBuilder(10);
			Random random = new Random();
			for (int i = 0; i < 10; i++) {
			    char c = chars[random.nextInt(chars.length)];
			    sb.append(c);
			}
			String output = sb.toString();
			Nickname=Nickname+"_"+output;
			Utils.wait(5);
			Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_Txt", "OrderCheckBook")), Nickname, "Save as favourite nick name");
			Utils.click(By.xpath(getObj("Propval1", "AddAsFav_Save_Btn", "OrderCheckBook")), "Add As Favourite Save button");
			Utils.wait(3);
			
			//to click Export PDF link
			Utils.click(By.xpath(getObj("Propval1", "ExportPDF", "OrderCheckBook")), "Export PDF link");
			Utils.wait(3);
			//to click Print link
			Utils.click(By.xpath(getObj("Propval1", "Print", "OrderCheckBook")), "Print link");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.wait(3);
			//to click Send By Email link
			Utils.click(By.xpath(getObj("Propval1", "SendByEmail", "OrderCheckBook")), "Send By Email link");
			Utils.wait(3);
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "OrderCheckBook")), ReadTestData("AccountSet1", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "OrderCheckBook")), ReadTestData("AccountSet1", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "OrderCheckBook")), ReadTestData("AccountSet1", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "OrderCheckBook")), ReadTestData("AccountSet1", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "OrderCheckBook")), ReadTestData("AccountSet1", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn", "OrderCheckBook")), "Send by Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			Utils.pressEnter();
			Utils.wait(3);
			Utils.pressEscapeKey(3);
			}

		catch (Exception e) {
			
			Log.fail("addFavSendEmailDownloadPdfNprintFunc has failed..error "+ Utils.getText(By.xpath(getObj("Propval1", "ErrorMsg_SendByEmail", "Additional_Options"))));
			
			
			Log.error("Unable to click on additional options" + ExceptionUtils.getStackTrace(e));
			runResult = false;
			throw e;
		}


	return runResult;
}

}