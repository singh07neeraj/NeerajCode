package javaMain.eCorp.accounts;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AdditionalOptions;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.FromAccount;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.Range;
import static javaMain.common_Functions.AppData.Reason;
import static javaMain.common_Functions.AppData.checkNo;
import static javaMain.common_Functions.AppData.checkNo2;
import static javaMain.common_Functions.AppData.isNegative;
import static javaMain.common_Functions.AppData.nextstep;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.eCorpCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES extends TestBase {

	@SuppressWarnings("unused")
	public static boolean JOLACCOUNTREPORTLOSTSTOLENCHEQUES(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {
				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				nextstep = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "nextstep"));
				FromAccount = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "FromAccount"));
				Range = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Range"));
				checkNo = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "checkNo"));
				checkNo2 = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "checkNo2"));
				Reason = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Reason"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				AdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AdditionalOptions"));

			}

			else {
				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				nextstep = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("nextstep"));
				FromAccount = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("FromAccount"));
				Range = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Range"));
				checkNo = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("checkNo"));
				checkNo2 = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("checkNo2"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				Reason = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Reason"));
				AdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AdditionalOptions"));
			}

			// click on Account Top
			Utils.click(By.xpath(getObj("Propval1", "Accounts", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Accounts link");

			Utils.wait(5);
			// Click on Checks link
			Utils.click(By.xpath(getObj("Propval1", "checks", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Checks link");
			Utils.wait(5);
			// Click Stolen Button
			Utils.click(By.xpath(getObj("Propval1", "stolen", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Report lost or Stolen cheque link");

			Utils.wait(4);
			if (isNegative.equalsIgnoreCase("true")) {
				Utils.click(By.xpath(getObj("Propval1", "Accountdropdown", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Accountdropdown");
				Utils.sendKeys(By.xpath(getObj("Propval1", "Account", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), ReadTestData(TCName, "InvalidAccountNumber"), "InvalidAccountNumber");

			} else {
				Utils.ClearText(By.xpath(getObj("Propval1", "Account", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")));
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "Accountdropdown", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), By.xpath(getObj("Propval1", "Account", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")),
						ReadTestData(TCName, "FromAccount"));
			}
			Utils.ClearText(By.xpath(getObj("Propval1", "Range", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")));
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "RangeDropDown", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), By.xpath(getObj("Propval1", "Range", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), ReadTestData(TCName, "Range"));

			if (Range.equalsIgnoreCase("Range")) {

				Utils.sendKeys(By.xpath(getObj("Propval1", "range1", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), ReadTestData(TCName, "checkNo"), "FirstCheck");
				Utils.sendKeys(By.xpath(getObj("Propval1", "range2", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), ReadTestData(TCName, "checkNo2"), "LastCheck");

			} else {

				Utils.sendKeys(By.xpath(getObj("Propval1", "check", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), ReadTestData(TCName, "checkNo"));

			}

			Utils.ClearText(By.xpath(getObj("Propval1", "Reason", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")));
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "ReasonDropDown", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), By.xpath(getObj("Propval1", "Reason", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")),
					ReadTestData(TCName, "Reason"));

			// Click on Agree
			Utils.click(By.xpath(getObj("Propval1", "Agree", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "I Agree checkbox");
			Utils.wait(5);

			if (Integer.parseInt(Proceed) == 1) {
				// Click on Proceed Button
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Proceed button");

			} else {
				// Click on Cancel Button
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Cancel button");
				return runResult;
			}

			if (isNegative.equalsIgnoreCase("true")) {
				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Confirm"));
					Log.pass("User is not able to proceed with invalid data.. Test Case pass ");
					Utils.logPassImage(TCName);
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("Users is able to proceed with invalid data hecne test case fail" + e.getStackTrace());
					Utils.logFailImage(TCName);
					throw e;
				}
			}
			if (Integer.parseInt(Confirm) == 1) {
				// Click on Confirm button
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Confirm button");

			} else if (Integer.parseInt(Confirm) == 2) {
				// Click on Modify

				Utils.click(By.xpath(getObj("Propval1", "Modfy", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Modify button");
				Utils.wait(5);
				/*
				 * Utils.sendKeys(By.xpath(getObj("Propval1", "check",
				 * "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "123567");
				 */

				// Click on Agree
				Utils.click(By.xpath(getObj("Propval1", "Agree", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "I Agree checkbox");

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Proceed button");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Confirm button");

				Log.pass("displayed message is :" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMsg", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES"))));

				Utils.logPassImage(TCName);
			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Cancel button");

				Utils.wait(5);
				Utils.click(By.xpath(getObj("Propval1", "Cancelyes", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Cancelyes button");
				Utils.logPassImage(TCName);
				return runResult;
			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMsg", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "SuccessMsg"));
				Log.pass("Your Stop Check request is successfully Done.....................");
				Log.pass("Success message is :" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMsg", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES"))));

			} catch (AssertionError | Exception e) {
				Log.fail("our Stop Check request has failed! :" + e.getStackTrace());
				Utils.logFailImage(TCName);
				throw e;
			}
			if (AdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

			if (nextstep.equalsIgnoreCase("NewTransaction"))

			{
				Utils.click(By.xpath(getObj("Propval1", "NewTransaction", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "New Transaction");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "ProceedBtn", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "ProceedBtn"));
				Log.pass("New Transaction Page is  landed succesfully");
				Utils.logPassImage(TCName);

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Home button");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomeGraphic", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "HomeGraphic"));
				int y = Utils.getSizeNoException(By.xpath(getObj("Propval1", "HomeGraphic", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")));

				Log.pass("Home Page is  landed succesfully");

				Utils.logPassImage(TCName);

			}

		} catch (Exception e) {
			runResult = false;
			e.printStackTrace();
			throw e;
		}
		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFunc(String Nickname) throws Exception {
		List<WebElement> FavTrans = null;
		try {
			Utils.wait(3);
			FavTrans = driver.findElements(By.xpath(getObj("Propval1", "FavTrans_List", "JOL_ACCOUNT_REQUEST_STEMENT")));
			int numberOfFavTransList = FavTrans.size();
			for (int i = 1; i < numberOfFavTransList; i++) {

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
			Utils.click(By.xpath(getObj("Propval1", "AddAsFavourite", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Add As Favourite link");

			// Nickname="TestAutomation";

			char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			StringBuilder sb = new StringBuilder(10);
			Random random = new Random();
			for (int i = 0; i < 10; i++) {
				char c = chars[random.nextInt(chars.length)];
				sb.append(c);
			}
			String output = sb.toString();
			Nickname = Nickname + "_" + output;
			Utils.wait(5);
			Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_Txt", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), Nickname, "Save as favourite nick name");
			Utils.click(By.xpath(getObj("Propval1", "AddAsFav_Save_Btn", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Add As Favourite Save button");
			Utils.wait(3);

			// to click Export PDF link
			Utils.click(By.xpath(getObj("Propval1", "ExportPDF", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Export PDF link");
			Utils.wait(3);
			// to click Print link
			Utils.click(By.xpath(getObj("Propval1", "Print", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Print link");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.wait(3);
			// to click Send By Email link
			Utils.click(By.xpath(getObj("Propval1", "SendByEmail", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Send By Email link");
			Utils.wait(3);
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn", "eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Send by Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			Utils.pressEnter();
			Utils.wait(3);
			Utils.pressEscapeKey(3);
			// driver.findElement(By.id("lelo")).click();
			// add success assertion
		}

		catch (Exception e) {

			Log.fail("addFavSendEmailDownloadPdfNprintFunc has failed..error " + Utils.getText(By.xpath(getObj("Propval1", "ErrorMsg_SendByEmail", "Additional_Options"))));

			Log.error("Unable to click on additional options" + ExceptionUtils.getStackTrace(e));
			runResult = false;
			throw e;
		}

		return runResult;
	}

}
