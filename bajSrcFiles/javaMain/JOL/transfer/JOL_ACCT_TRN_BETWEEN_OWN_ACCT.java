package javaMain.JOL.transfer;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.Account;
import static javaMain.common_Functions.AppData.AddAnotherTxn;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.DeleteAnotherTxn;
import static javaMain.common_Functions.AppData.ExecutionTime;
import static javaMain.common_Functions.AppData.FromAcc;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.ToAcc;
import static javaMain.common_Functions.AppData.TransferType;

import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_ACCT_TRN_BETWEEN_OWN_ACCT extends TestBase {

	public static Boolean JOL_ACCT_TRN_BETWEEN_OWN_ACCT_functions(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				TransferType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransferType"));
				ExecutionTime = ReadDataSQL(TCName, ScenarioCount, "EXEC");
				AddAnotherTxn = ReadDataSQL(TCName, ScenarioCount, "AddAnotherTxn");
				DeleteAnotherTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "DeleteAnotherTxn"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				Account = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Account"));

			} else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				TransferType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TransferType"));
				ExecutionTime = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("EXEC");
				AddAnotherTxn = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AddAnotherTxn");
				DeleteAnotherTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("DeleteAnotherTxn"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				Account = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Account"));

			}

			if (TransferType.equalsIgnoreCase("SarToSar")) {

				FromAcc = AppData.getFromAccountSAR();
				ToAcc = AppData.getToAccountSAR();
			}

			else if (TransferType.equalsIgnoreCase("SarToForeign")) {

				FromAcc = AppData.getFromAccountSAR();
				ToAcc = AppData.getToAccountForeign();
			}

			else if (TransferType.equalsIgnoreCase("ForeignToSar")) {

				FromAcc = AppData.getFromAccountForeign();
				ToAcc = AppData.getToAccountSAR();

			} else if (TransferType.equalsIgnoreCase("ForeignToForeign")) {

				FromAcc = AppData.getFromAccountForeign();
				ToAcc = AppData.getToAccountForeign();
			}

			else {

				FromAcc = AppData.getFromAccountSAR();
				ToAcc = AppData.getToAccountSAR();

			}

			Utils.scrollUpVertically();
			Utils.mouseHover(By.xpath(getObj("Propval1", "TransfersLnk", "JOL_Transfers_BetweenMyAccts")));
			Utils.click(By.xpath(getObj("Propval1", "btwaccountTop", "JOL_Transfers_BetweenMyAccts")), "Between My Accounts");
			// Click on Left International tab

			Log.pass("Account Number used is : " + FromAcc);
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.sendKeys(By.xpath(getObj("Propval1", "FromAcctCombo", "JOL_Transfers_BetweenMyAccts")), FromAcc, "From Account Dropdown");
			Utils.pressKeyDown();
			Utils.pressKeyDown();
			Utils.pressEnter();

			Log.pass("Successful Entered 'From' Account Number...");

			Utils.sendValDropdown(By.xpath(getObj("Propval1", "toAcctCombo", "JOL_Transfers_BetweenMyAccts")), ToAcc, "To Account Dropdown.");

			Log.pass("Successful Entered 'To' Account Number...");

			Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), AppData.getAmount_Local(), "Amount");

			Log.pass("Minumum Amount allowed for valid txn is " + driver.findElement(By.xpath("//INPUT[@aria-valuemin]")).getAttribute("aria-valuemin"));
			Log.pass("Maximum Amount allowed for valid txn is " + driver.findElement(By.xpath("//INPUT[@aria-valuemax]")).getAttribute("aria-valuemax"));

			// Execute type
			/*
			 * if (Integer.parseInt(EXEC) == 1) {
			 * Log.pass("Execute now check box is selected by default"); }
			 * 
			 * else if (Integer.parseInt(EXEC) == 2) {
			 * 
			 * Utils.click(By.xpath(getObj("Propval1", "Schedule", "JOL_INTLTransfer")),
			 * "Schedule"); Utils.sendKeys(By.xpath(getObj("Propval1", "nickName_ns",
			 * "JOL_INTLTransfer")), "Automation", "Nick Name");
			 * 
			 * Utils.click(By.xpath(getObj("Propval1", "TransferDateDropDown",
			 * "JOL_INTLTransfer")), "Transfer Date Dropdown");
			 * Utils.sendKeys(By.xpath(getObj("Propval1", "TransferDateValue",
			 * "JOL_INTLTransfer")), Utils.DateValue(Integer.parseInt(ReadDataSQL(TCName,
			 * ScenarioCount, "NextDate"))), "Transfer Date");
			 * 
			 * } else {
			 * 
			 * Utils.click(By.xpath(getObj("Propval1", "stdorder", "JOL_INTLTransfer")),
			 * "Standing order"); Utils.sendKeys(By.xpath(getObj("Propval1", "STDNickName",
			 * "JOL_INTLTransfer")), "Automation", "Standard Nick Name");
			 * 
			 * try {
			 * 
			 * Utils.wait(6); WebElement StartDate =
			 * driver.findElement(By.xpath(getObj("Propval1", "StartDate",
			 * "JOL_INTLTransfer")));
			 * StartDate.sendKeys(Utils.DateValue((Integer.parseInt(ReadDataSQL(TCName,
			 * ScenarioCount, "NextDate")))));
			 * 
			 * WebElement endtDate = driver.findElement(By.xpath(getObj("Propval1",
			 * "endDate", "JOL_INTLTransfer")));
			 * endtDate.sendKeys(Utils.DateValue((Integer.parseInt(ReadDataSQL(TCName,
			 * ScenarioCount, "FutureDate")))));
			 * 
			 * WebElement Frequency = driver.findElement(By.xpath(getObj("Propval1",
			 * "Frequency", "JOL_Transfers_BetweenMyAccts")));
			 * Frequency.sendKeys(ReadTestData(AppData.getTransferFrequency_OwnAcc(),
			 * "TransferFrequency_OwnAcc"));
			 * 
			 * Log.pass("Successfully selected dates."); }
			 * 
			 * catch (Exception e) { Log.fail("Unable to select date values.. error " +
			 * ExceptionUtils.getStackTrace(e)); }
			 * 
			 * }
			 */
			
			// Execute Time
			if (Integer.parseInt(ExecutionTime) == 1) {
				TransferModuleCommonFunctions.selectExecuteNow();
			} else if (Integer.parseInt(ExecutionTime) == 2) {
				TransferModuleCommonFunctions.selectScheduled();
			} else {
				TransferModuleCommonFunctions.selectStandingOrder();
			}

			// Proceed

			if (Integer.parseInt(AddAnotherTxn) > 0) {

				// Add another transaction based on the count of key AddAnotherTxn in child
				// table.
				TransferModuleCommonFunctions.addAnotherTxn(Integer.parseInt(AddAnotherTxn), FromAcc, ToAcc, AppData.getAmount_Local());

			}
			if (Integer.parseInt(DeleteAnotherTxn) > 0) {

				// Delete one of the recently added another transactions.
				TransferModuleCommonFunctions.deleteAnotherTxn(Integer.parseInt(DeleteAnotherTxn));
			}

			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "JOL_INTLTransfer")), "Proceed Button");

			} else {
				// Cancel Button
				Utils.click(By.xpath(getObj("Propval1", "cancelButton", "JOL_INTLTransfer")), "Cancel Button");

				if (Utils.getSizeNoException(By.xpath(getObj("Propval1", "Confirm", "JOL_INTLTransfer"))) == 0) {
					Log.pass("Successfully cancelled the transaction.Returned to home page.");
					runResult = true;

				} else {
					runResult = false;
				}
				Log.error("Unable to cancel the transaction..");
				return runResult;
			}

			
			if (Utils.getSizeNoException(By.xpath(getObj("Propval1", "Confirm", "JOL_INTLTransfer"))) > 0) {
				Log.pass("Confirm Page is  displayed as expected.");
			}

			if (Integer.parseInt(Confirm) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "JOL_INTLTransfer")), "Confirm Button");
				Log.pass("Successfully Clicked on Confirm Schedule");

			} else if (Integer.parseInt(Confirm) == 2) {

				Log.pass("Successfully Clicked on Modifiy Schedule");
				Utils.click(By.xpath(getObj("Propval1", "modify", "JOL_INTLTransfer")), "Modify Button");
				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), AppData.getAmount_ModifyOwnAcc(), "Amount");
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "JOL_INTLTransfer")), "Proceed Button");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "JOL_INTLTransfer")), "Confirm Button");

			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "cancelButton", "JOL_INTLTransfer")), "Cancel Button");

				Utils.click(By.xpath(getObj("Propval1", "yes", "JOL_INTLTransfer")), "Yes Button");
				Log.pass("Successfully Clicked on 'Yes' option of Cancel transaction pop up.");
				return runResult;
			}

			int SuccessCount = Utils.getSizeNoException(By.xpath(getObj("Propval1", "SuccessMessage", "JOL_Transfers_BetweenMyAccts")));
			if (SuccessCount > 0) {
				Log.pass("Successfully completed transfer between my accounts");
				runResult = true;
			} else {
				String failMsg = Utils.getText(By.xpath(getObj("Propval1", "failMessage", "JOL_Transfers_BetweenMyAccts")));
				Log.error("Unable to complete transfer between my accounts. Error message is : " + failMsg);
				runResult = false;
			}

		} catch (Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}
}
