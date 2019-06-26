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
public class JOL_ACCOUNT_REQUEST_STEMENT_BYMAIL_FUNC extends TestBase {
	
	public static Boolean jolaccountemail(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception{

		String Proceed, Confirm, NextDate, FutureDate,nextstep;
		try {


			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				NextDate=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NextDate"));
				FutureDate=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "FutureDate"));
				nextstep=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "nextstep"));

			}

			else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm =Utils.setValue( (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				NextDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NextDate"));
				FutureDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("FutureDate"));
				nextstep = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("nextstep"));
			}
			System.out.println("nextstep"+nextstep);
			// click on Account Top
			Utils.click(By.xpath(getObj("Propval1", "Accounts", "JOL_ACCOUNT_REQUEST_STEMENT")),"Accounts link");

			Utils.wait(5);

			// Click on Account Summary
			Utils.click(By.xpath(getObj("Propval1", "Requestemail", "JOL_ACCOUNT_REQUEST_STEMENT")),"Request Statement by Mail link");


			Utils.ClearText(By.xpath(getObj("Propval1", "Account", "JOL_ACCOUNT_REQUEST_STEMENT")));
			Utils.clickDropdownAndSendValue(
					By.xpath(getObj("Propval1", "Accountdropdown", "JOL_ACCOUNT_REQUEST_STEMENT")),
					By.xpath(getObj("Propval1", "Account", "JOL_ACCOUNT_REQUEST_STEMENT")),
					Input.ReadTestData("JOL_ACCOUNT_REQUEST_STEMENT", "AccountNumber"),"Account drop down");


			WebElement StartDate = driver.findElement(By.xpath(getObj("Propval1", "StartDate", "JOL_ACCOUNT_REQUEST_STEMENT")));
			StartDate.sendKeys(Utils.DateValue((Integer.parseInt(NextDate))));

			WebElement endtDate = driver.findElement(By.xpath(getObj("Propval1", "endDate", "JOL_ACCOUNT_REQUEST_STEMENT")));
			endtDate.sendKeys(Utils.DateValue((Integer.parseInt(FutureDate))));

			Utils.wait(4);
			if (Integer.parseInt(Proceed) == 1) {
				// Click on Proceed Button
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "JOL_ACCOUNT_REQUEST_STEMENT")),"Proceed button");
			}

			else {
				// Click on Cancel
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "JOL_ACCOUNT_REQUEST_STEMENT")),"Cancel button");
				return runResult;
			}

			int x=Utils.getSize(By.xpath(getObj("Propval1", "Confirm", "JOL_ACCOUNT_REQUEST_STEMENT")));

			if(x==0)
			{
				Log.fail("Please review the account number/ start/ end date on home page");
				return false;
			}
			Utils.wait(3);
			if (Integer.parseInt(Confirm) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "JOL_ACCOUNT_REQUEST_STEMENT")),"Confirm button");

				Utils.wait(10);
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMsg", "JOL_ACCOUNT_REQUEST_STEMENT")), " Success Message on results page"));
					Log.pass(" Your Statement By Mail request has been completed successfully...Message displayed is" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMsg", "JOL_ACCOUNT_REQUEST_STEMENT"))));
					Utils.logPassImage("Your Statement By Mail request has been completed- Pass");

				} catch (AssertionError | Exception e) {

					Log.fail(" Your Statement By Mail request has failed!");
					Utils.logFailImage("Your Statement By Mail request has failed -Fail");
					throw e;

				}
				
				addFavSendEmailDownloadPdfNprintFunc("TestAutomation");
			}

			else if (Integer.parseInt(Confirm) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "Modfy", "JOL_ACCOUNT_REQUEST_STEMENT")),"Modify button");


				Utils.ClearText(By.xpath(getObj("Propval1", "Account", "JOL_ACCOUNT_REQUEST_STEMENT")));
				Utils.clickDropdownAndSendValue(
						By.xpath(getObj("Propval1", "Accountdropdown", "JOL_ACCOUNT_REQUEST_STEMENT")),
						By.xpath(getObj("Propval1", "Account", "JOL_ACCOUNT_REQUEST_STEMENT")),
						Input.ReadTestData("JOL_ACCOUNT_REQUEST_STEMENT", "ModifyAccountNumber"),"Account drop down");


				Utils.wait(3);
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "JOL_ACCOUNT_REQUEST_STEMENT")),"Proceed button");
				Utils.wait(3);
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "JOL_ACCOUNT_REQUEST_STEMENT")),"Confirm button");

				Utils.wait(10);

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMsg", "JOL_ACCOUNT_REQUEST_STEMENT")), " Success Message on results page"));
					Log.pass(" Your Statement By Mail request has been completed successfully...Message displayed is" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMsg", "JOL_ACCOUNT_REQUEST_STEMENT"))));
					Utils.logPassImage("Your Statement By Mail request has been completed- Pass");

				} catch (AssertionError | Exception e) {

					Log.fail(" Your Statement By Mail request has failed!");
					Utils.logFailImage("Your Statement By Mail request has failed -Fail");
					throw e;

				}
				
				addFavSendEmailDownloadPdfNprintFunc("TestAutomation");
			}
			else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "JOL_ACCOUNT_REQUEST_STEMENT")),"Cancel button");
				Utils.wait(3);
				Utils.click(By.xpath(getObj("Propval1", "Cancelyes", "JOL_ACCOUNT_REQUEST_STEMENT")),"CancelYes button");
				return runResult;
			}



			if (nextstep.equalsIgnoreCase("NewTransaction"))

			{
				Utils.click(By.xpath(getObj("Propval1", "NewTransaction", "JOL_ACCOUNT_REQUEST_STEMENT")),"New Transaction button");

				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "ProceedBtn", "JOL_ACCOUNT_REQUEST_STEMENT")), "Request Statement by Mail home page"));
					Log.pass(" Request Statement by Mail home page has been displayed");
					Utils.logPassImage("Request Statement by Mail home page displayed- Pass");

				} catch (AssertionError | Exception e) {

					Log.fail("  Request Statement by Mail home page has not been displayed...should be failed... ");
					Utils.logFailImage(" Request Statement by Mail home page not displayed -Fail");
					throw e;

				}
					
				
			}
			else
			{
				Utils.click(By.xpath(getObj("Propval1", "Home", "JOL_ACCOUNT_REQUEST_STEMENT")),"Home button");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomeGraphic", "JOL_ACCOUNT_REQUEST_STEMENT")), "Customer position page"));

					Log.pass("Customer position page has been displayed as expected. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "HomeGraphic", "JOL_ACCOUNT_REQUEST_STEMENT"))));

					Utils.logPassImage("Customer position page displayed-pass");


				} catch (AssertionError | Exception e) {

					Log.fail("Customer position page not displayed...should fail");
					Utils.logFailImage("Customer position page not displayed-fail");

					throw e;

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

	public static boolean addFavSendEmailDownloadPdfNprintFunc(String Nickname) throws Exception {

		List<WebElement> FavTrans=null;
		try {
			Utils.wait(3);
			FavTrans = driver.findElements(By.xpath(getObj("Propval1", "FavTrans_List", "JOL_ACCOUNT_REQUEST_STEMENT")));
			int numberOfFavTransList = FavTrans.size();
			for (int i = 1; i <numberOfFavTransList; i++) 
			{
				
				Utils.mouseHover(By.xpath(getObj("Propval1", "FavTrans_List_link", "JOL_ACCOUNT_REQUEST_STEMENT")));	
				//Utils.mouseHover(By.xpath(getObj("Propval1", "FavTrans_List_Del_img", "JOL_ACCOUNT_REQUEST_STEMENT")));
				Utils.wait(5);
				Utils.click(By.xpath(getObj("Propval1", "FavTrans_List_Del_img", "JOL_ACCOUNT_REQUEST_STEMENT")), "Click on delete");
				Utils.wait(2);
				Utils.pressTab();
				Utils.wait(2);
				Utils.pressEnter();
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			}
			// to click on additional options
			Log.info("Started clicking on additional options");
			Utils.click(By.xpath(getObj("Propval1", "AddAsFavourite", "JOL_ACCOUNT_REQUEST_STEMENT")), "Add As Favourite link");
			
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
			Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_Txt", "JOL_ACCOUNT_REQUEST_STEMENT")), Nickname, "Save as favourite nick name");
			Utils.click(By.xpath(getObj("Propval1", "AddAsFav_Save_Btn", "JOL_ACCOUNT_REQUEST_STEMENT")), "Add As Favourite Save button");
			Utils.wait(3);
			
			//to click Export PDF link
			Utils.click(By.xpath(getObj("Propval1", "ExportPDF", "JOL_ACCOUNT_REQUEST_STEMENT")), "Export PDF link");
			Utils.wait(3);
			//to click Print link
			Utils.click(By.xpath(getObj("Propval1", "Print", "JOL_ACCOUNT_REQUEST_STEMENT")), "Print link");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.wait(3);
			//to click Send By Email link
			Utils.click(By.xpath(getObj("Propval1", "SendByEmail", "JOL_ACCOUNT_REQUEST_STEMENT")), "Send By Email link");
			Utils.wait(3);
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "JOL_ACCOUNT_REQUEST_STEMENT")), ReadTestData("AccountSet1", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "JOL_ACCOUNT_REQUEST_STEMENT")), ReadTestData("AccountSet1", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "JOL_ACCOUNT_REQUEST_STEMENT")), ReadTestData("AccountSet1", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "JOL_ACCOUNT_REQUEST_STEMENT")), ReadTestData("AccountSet1", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "JOL_ACCOUNT_REQUEST_STEMENT")), ReadTestData("AccountSet1", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn", "JOL_ACCOUNT_REQUEST_STEMENT")), "Send by Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			Utils.pressEnter();
			Utils.wait(3);
			Utils.pressEscapeKey(3);
			//driver.findElement(By.id("lelo")).click();
			// add success assertion
			Utils.wait(3);
			/*
			 * FavTrans = driver.findElements(By.xpath(getObj("Propval1", "FavTrans_List",
			 * "JOL_ACCOUNT_REQUEST_STEMENT"))); int numberOfFavTransList = FavTrans.size();
			 * for (int i = 1; i <=numberOfFavTransList; i++) {
			 * Utils.mouseHover(By.xpath("(//img[@title='Delete'])["+i+"]")); Utils.wait(2);
			 * Utils.click(By.xpath("(//img[@title='Delete'])["+i+"]"), "Click on delete");
			 * Utils.wait(3); Utils.pressTab(); Utils.wait(2); Utils.pressEnter();
			 * Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']")); }
			 */
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
