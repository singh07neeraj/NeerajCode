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
import static javaMain.common_Functions.AppData.*;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES extends TestBase {

	public static boolean JOLACCOUNTREPORTLOSTSTOLENCHEQUES(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				nextstep = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "nextstep"));
				checkNo = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "checkNo"));
				checkNo2 = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "checkNo2"));

			}

			else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				nextstep = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("nextstep"));
				checkNo = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("checkNo"));
				checkNo2 = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("checkNo2"));
			}

			// click on Account Top
			Utils.click(By.xpath(getObj("Propval1", "Accounts", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Accounts link");
			Utils.wait(2);
			// Click on Checks link
			Utils.click(By.xpath(getObj("Propval1", "checks", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Checks link");
			Utils.wait(3);
			// Click Stolen Button
			Utils.click(By.xpath(getObj("Propval1", "stolen", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Report lost or Stolen cheque link");

			Utils.wait(5);

			Utils.ClearText(By.xpath(getObj("Propval1", "Account", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")));
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "Accountdropdown", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), By.xpath(getObj("Propval1", "Account", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")),
					Input.ReadTestData(TCName, "AccountNumber"));

			Utils.ClearText(By.xpath(getObj("Propval1", "Range", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")));
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "RangeDropDown", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), By.xpath(getObj("Propval1", "Range", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")),
					Input.ReadTestData(TCName, "Range"));

			if (Input.ReadTestData(TCName, "Range").equalsIgnoreCase("Single") || Input.ReadTestData(TCName, "Range").equalsIgnoreCase("„—… Ê«Õœ…")) {
				Utils.sendKeys(By.xpath(getObj("Propval1", "check", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), checkNo, "check text box");

			} else {
				Utils.sendKeys(By.xpath(getObj("Propval1", "range1", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), checkNo, "FirstCheck");
				Utils.sendKeys(By.xpath(getObj("Propval1", "range2", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), checkNo2, "LastCheck");
			}

			Utils.ClearText(By.xpath(getObj("Propval1", "Reason", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")));
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "ReasonDropDown", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), By.xpath(getObj("Propval1", "Reason", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")),
					Input.ReadTestData(TCName, "Reason"));

			// Click on Agree
			Utils.click(By.xpath(getObj("Propval1", "Agree", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "I Agree checkbox");
			Utils.wait(5);
			if (Integer.parseInt(Proceed) == 1) {
				// Click on Proceed Button
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Proceed button");

			} else {
				// Click on Cancel Button
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Cancel button");
				return runResult;
			}

			int x = Utils.getSize(By.xpath(getObj("Propval1", "Confirm", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")));

			if (x == 0) {
				Log.fail("Not able to proceed further please review account number/range/reason again");
				return false;
			}
			
			if (Integer.parseInt(Confirm) == 1) {
				// Click on Confirm button
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Confirm button");

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMsg", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), " Success Message on results page"));
					Log.pass(" Your Stop Check request has been completed successfully." + Utils.getText(By.xpath(getObj("Propval1", "SuccessMsg", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES"))));
					Utils.logPassImage("Your Stop Check request has been completed- Pass");

				} catch (AssertionError | Exception e) {

					Log.fail(" Your Stop Check request has failed!");
					Utils.logFailImage("Your Stop Check request has failed -Fail");
					throw e;

				}

			} else if (Integer.parseInt(Confirm) == 2) {
				// Click on Modify

				Utils.click(By.xpath(getObj("Propval1", "Modfy", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Modify button");
				Utils.wait(5);

				// Click on Agree
				Utils.click(By.xpath(getObj("Propval1", "Agree", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "I Agree checkbox");
				Utils.wait(5);

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Proceed button");
				Utils.wait(5);
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Confirm button");

				Utils.wait(5);

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMsg", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), " Success Message on results page"));
					Log.pass(" Your Stop Check request has been completed successfully." + Utils.getText(By.xpath(getObj("Propval1", "SuccessMsg", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES"))));
					Utils.logPassImage("Your Stop Check request has been completed- Pass");

				} catch (AssertionError | Exception e) {

					Log.fail(" Your Stop Check request has failed!");
					Utils.logFailImage("Your Stop Check request has failed -Fail");
					throw e;

				}

				addFavSendEmailDownloadPdfNprintFunc("TestAutomation");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Cancel button");

				Utils.wait(5);
				Utils.click(By.xpath(getObj("Propval1", "Cancelyes", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Cancelyes button");
				return runResult;
			}

			if (nextstep.equalsIgnoreCase("NewTransaction"))

			{
				Utils.click(By.xpath(getObj("Propval1", "NewTransaction", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "New Transaction");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "ProceedBtn", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Report Lost or Stolen Cheques home page"));
					Log.pass(" Report Lost or Stolen Cheques home page has been displayed");
					Utils.logPassImage("Report Lost or Stolen Cheques home page displayed- Pass");

				} catch (AssertionError | Exception e) {

					Log.fail("  Report Lost or Stolen Cheques home page has not been displayed...should be failed... ");
					Utils.logFailImage(" Report Lost or Stolen Cheques home page not displayed -Fail");
					throw e;

				}

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Home button");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomeGraphic", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Customer position page"));
					Log.pass("Customer position page has been displayed as expected. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "HomeGraphic", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES"))));
					Utils.logPassImage("Customer position page displayed-pass");

				} catch (AssertionError | Exception e) {

					Log.fail("Customer position page not displayed...should fail");
					Utils.logFailImage("Customer position page not displayed-fail");
					throw e;
				}

			}

		} catch (AssertionError | Exception e) {
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
			Utils.click(By.xpath(getObj("Propval1", "AddAsFavourite", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Add As Favourite link");

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
			Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_Txt", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), Nickname, "Save as favourite nick name");
			Utils.click(By.xpath(getObj("Propval1", "AddAsFav_Save_Btn", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Add As Favourite Save button");
			Utils.wait(3);

			// to click Export PDF link
			Utils.click(By.xpath(getObj("Propval1", "ExportPDF", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Export PDF link");
			Utils.wait(3);
			// to click Print link
			Utils.click(By.xpath(getObj("Propval1", "Print", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Print link");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.wait(3);
			// to click Send By Email link
			Utils.click(By.xpath(getObj("Propval1", "SendByEmail", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Send By Email link");
			Utils.wait(3);
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn", "JOL_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES")), "Send by Email Button");
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
