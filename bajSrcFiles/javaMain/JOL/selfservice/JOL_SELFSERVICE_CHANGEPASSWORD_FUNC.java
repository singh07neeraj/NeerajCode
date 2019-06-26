package javaMain.JOL.selfservice;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.ConfirmNewPassword;
import static javaMain.common_Functions.AppData.NewPassword;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.OTPProceed;
import static javaMain.common_Functions.AppData.OldPassword;
import static javaMain.common_Functions.AppData.Proceed;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.JOL.transfer.TransferModuleCommonFunctions;

public class JOL_SELFSERVICE_CHANGEPASSWORD_FUNC extends TestBase {

	public static Boolean changepassword(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {
			
			if (isMasterClassRun) {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));

			} else {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));

			}

			OldPassword = Input.ReadTestData(TCName, "OldPassword");
			NewPassword = Input.ReadTestData(TCName, "NewPassword");
			ConfirmNewPassword = Input.ReadTestData(TCName, "NewPassword");
			
			
			Utils.click(By.xpath(getObj("Propval1", "SelfServices", "JOL_SELFSERVICE_changepassword")), "Self Services");
			Utils.click(By.xpath(getObj("Propval1", "changepassword", "JOL_SELFSERVICE_changepassword")), "change password");

			// View Status Landed Page
			String ViewStatus = Utils.getTextNoException(By.xpath(getObj("Propval1", "LandPage", "JOL_SELFSERVICE_changepassword")));
			Log.info("Landed Page Title is :" + ViewStatus);

			Utils.sendKeys(By.xpath(getObj("Propval1", "OldPassword", "JOL_SELFSERVICE_changepassword")), OldPassword, "OldPassword text box");
			Utils.sendKeys(By.xpath(getObj("Propval1", "NewPassword", "JOL_SELFSERVICE_changepassword")), NewPassword, "NewPassword text box");
			Utils.sendKeys(By.xpath(getObj("Propval1", "ConfirmNewPassword", "JOL_SELFSERVICE_changepassword")), NewPassword, "ConfirmNewPassword text box");
			

			if (Integer.parseInt(Proceed) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "proceed", "JOL_SELFSERVICE_changepassword")), "Proceed");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "JOL_SELFSERVICE_changepassword")), "cancel");
				return true;
			}

			int confirm1 = Utils.getSizeNoException(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changepassword")));

			if (confirm1 == 0) {
				Log.fail("Please enter valid password");
				return false;
			} else {
				// View Status Landed Page
				ViewStatus = Utils.getTextNoException(By.xpath(getObj("Propval1", "PasswordValid_msg", "JOL_SELFSERVICE_changepassword")));
				Log.pass("Landed Page Title is :" + ViewStatus);

			}

			if (Integer.parseInt(Confirm) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changepassword")), "confirm");
			}

			else if (Integer.parseInt(Confirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "JOL_SELFSERVICE_changepassword")), "modify");

				Utils.sendKeys(By.xpath(getObj("Propval1", "OldPassword", "JOL_SELFSERVICE_changepassword")), OldPassword, "OldPassword text box");
				Utils.sendKeys(By.xpath(getObj("Propval1", "NewPassword", "JOL_SELFSERVICE_changepassword")), NewPassword, "NewPassword text box");
				Utils.sendKeys(By.xpath(getObj("Propval1", "ConfirmNewPassword", "JOL_SELFSERVICE_changepassword")), NewPassword, "ConfirmNewPassword text box");

				Utils.click(By.xpath(getObj("Propval1", "proceed", "JOL_SELFSERVICE_changepassword")), "Proceed");

				Utils.click(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changepassword")), "confirm");

			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "JOL_SELFSERVICE_changepassword")), "cancel");

				Utils.click(By.xpath(getObj("Propval1", "OTPCancelConfirm", "JOL_SELFSERVICE_changepassword")), "cancel");
				Log.pass("Confirm is cancelled successfully");
				return true;

			}

			if (Integer.parseInt(OTPProceed) == 1) {
				Utils.enterOTPAndProceed();
			} else if (Integer.parseInt(OTPProceed) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "OTPBack", "JOL_SELFSERVICE_changepassword")), "OTP Back button");
				Utils.click(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changepassword")), "OTP Back confirm button");
				Utils.enterOTPAndProceed();
			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel_OTP", "JOL_SELFSERVICE_changepassword")), "cancel button on OTP page");

				Utils.click(By.xpath(getObj("Propval1", "OTPCancelConfirm", "JOL_SELFSERVICE_changepassword")), "cancel confirm button on OTP page");
				Log.pass("OTP is canceled successfully");
				return true;
			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "Card")), "Success Message"));
				Log.pass("Change Password completed successfully.New password is : "+ NewPassword);
				Utils.logPassImage("Change Password-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Change Password failed...Message:" + Utils.getTextNoException(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("Change Password-Fail");
				throw e;
			}

			Utils.wait(5);
			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				TransferModuleCommonFunctions.addFavSendEmailDownloadPdfNprint();
			}

			if (NewTxn.equalsIgnoreCase("true")) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "JOL_SELFSERVICE_changepassword")), "New Transaction");
				int y = Utils.getSizeNoException(By.xpath(getObj("Propval1", "proceed", "JOL_SELFSERVICE_changepassword")));
				if (y > 0) {
					Log.pass("New Transaction is landed successfully");
				} else {
					Log.fail("New Transaction is not landed successfully");

				}

			}

		}

		catch (Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFunc(String Nickname) throws Exception {
		List<WebElement> FavTrans = null;

		try {
			Utils.wait(3);
			FavTrans = driver.findElements(By.xpath(getObj("Propval1", "FavTrans_List", "JOL_SELFSERVICE_changepassword")));
			int numberOfFavTransList = FavTrans.size();
			for (int i = 1; i < numberOfFavTransList; i++) {

				Utils.mouseHover(By.xpath(getObj("Propval1", "FavTrans_List_link", "JOL_SELFSERVICE_changepassword")));
				Utils.wait(2);
				Utils.clickSafely(By.xpath(getObj("Propval1", "FavTrans_List_Del_img", "JOL_SELFSERVICE_changepassword")), "Delete");
				Utils.wait(2);
				Utils.pressTab();
				Utils.wait(2);
				Utils.pressEnter();
				Utils.wait(6);
			}

			// to click on additional options
			Log.info("Started clicking on additional options");
			Utils.click(By.xpath(getObj("Propval1", "AddAsFavourite", "JOL_SELFSERVICE_changepassword")), "Add As Favourite link");

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
			Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_Txt", "JOL_SELFSERVICE_changepassword")), Nickname, "Save as favourite nick name");
			Utils.click(By.xpath(getObj("Propval1", "AddAsFav_Save_Btn", "JOL_SELFSERVICE_changepassword")), "Add As Favourite Save button");
			Utils.wait(3);

			// to click Export PDF link
			Utils.click(By.xpath(getObj("Propval1", "ExportPDF", "JOL_SELFSERVICE_changepassword")), "Export PDF link");
			Utils.wait(3);
			// to click Print link
			Utils.click(By.xpath(getObj("Propval1", "Print", "JOL_SELFSERVICE_changepassword")), "Print link");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.wait(3);
			// to click Send By Email link
			Utils.click(By.xpath(getObj("Propval1", "SendByEmail", "JOL_SELFSERVICE_changepassword")), "Send By Email link");
			Utils.wait(3);
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "JOL_SELFSERVICE_changepassword")), ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "JOL_SELFSERVICE_changepassword")), ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "JOL_SELFSERVICE_changepassword")), ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "JOL_SELFSERVICE_changepassword")), ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "JOL_SELFSERVICE_changepassword")), ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn", "JOL_SELFSERVICE_changepassword")), "Send by Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			Utils.pressEnter();
			Utils.wait(3);
			Utils.pressEscapeKey(3);
			// driver.findElement(By.id("lelo")).click();
			// add success assertion
		}

		catch (Exception e) {

			Log.fail("addFavSendEmailDownloadPdfNprintFunc has failed..error " + Utils.getTextNoException(By.xpath(getObj("Propval1", "ErrorMsg_SendByEmail", "Additional_Options"))));
			runResult = false;
			throw e;
		}

		return runResult;
	}

}
