package javaMain.JOL.transfer;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AddAnotherTxn;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.AmountLessThan100USD;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.DeleteAnotherTxn;
import static javaMain.common_Functions.AppData.ExecutionTime;
import static javaMain.common_Functions.AppData.FromAcc;
import static javaMain.common_Functions.AppData.FutureDate;
import static javaMain.common_Functions.AppData.NegativeAmount;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.NextDate;
import static javaMain.common_Functions.AppData.Procced;
import static javaMain.common_Functions.AppData.TransferType;
import static javaMain.common_Functions.AppData.TxfrAmountType;
import static javaMain.common_Functions.AppData.ZeroBalAcc;
import static javaMain.common_Functions.AppData.isTermsNconditionsChecked;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.OpenJOLMenues;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_TRANSFERS_INTERNATIONAL extends TestBase {

	@SuppressWarnings("unused")
	public static Boolean JOL_TRANSFERS_INTERNATIONAL_functions(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				TransferType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransferType"));
				TxfrAmountType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TxfrAmountType"));
				AddAnotherTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AddAnotherTxn"));
				DeleteAnotherTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "DeleteAnotherTxn"));
				ExecutionTime = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "EXEC"));
				NextDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NextDate")); // Start and end dates can be read from excel sheet also if required.
				FutureDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "FutureDate"));
				Procced = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Procced"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				Procced = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Procced"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				NegativeAmount = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NegativeAmount"));
				AmountLessThan100USD = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AmountLessThan100USD"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				ZeroBalAcc = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ZeroBalAcc"));
				isTermsNconditionsChecked = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isTermsNconditionsChecked"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				TransferType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransferType"));
				TxfrAmountType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TxfrAmountType"));
				AddAnotherTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AddAnotherTxn"));
				DeleteAnotherTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("DeleteAnotherTxn"));
				ExecutionTime = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("EXEC"));
				NextDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NextDate"));
				FutureDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("FutureDate"));
				Procced = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Procced"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				Procced = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Procced"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
				NegativeAmount = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NegativeAmount"));
				AmountLessThan100USD = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AmountLessThan100USD"));
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				ZeroBalAcc = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ZeroBalAcc"));
				isTermsNconditionsChecked = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isTermsNconditionsChecked"));

			}

			if (TransferType.equalsIgnoreCase("SarToBeneficiary")) {

				// FromAcc = ReadTestData(AppConstants.accountSet, "FromAccountSAR");

				FromAcc = AppData.getFromAccountSAR();
			}

			else if (TransferType.equalsIgnoreCase("ForeignToBeneficiary")) {

				// FromAcc = ReadTestData(AppConstants.accountSet, "FromAccountForeign");
				FromAcc = AppData.getFromAccountForeign();
			}

			OpenJOLMenues.openTransfersMenu("International");

			if (ZeroBalAcc.equalsIgnoreCase("true")) {

				Log.info("Selecting zero balance account number... " + Input.ReadTestData(AppData.accountSet, "ZeroBalAccNumber"));
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdown", "JOL_INTLTransfer")), By.xpath(getObj("Propval1", "AccountNumber", "JOL_INTLTransfer")), Input.ReadTestData(AppData.accountSet, "ZeroBalAccNumber"),"From Account");
			}
			else {
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdown", "JOL_INTLTransfer")), By.xpath(getObj("Propval1", "AccountNumber", "JOL_INTLTransfer")), FromAcc,"From Account");
			}
			Log.pass("Selected Account Number is :" + FromAcc);
			
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryDropdownDropdown", "JOL_INTLTransfer")), By.xpath(getObj("Propval1", "Beneficiary", "JOL_INTLTransfer")), AppData.getBeneficiary_Intl(),"Beneficiary");
			Log.pass("Selected Beneficiary Name  is :" + AppData.getBeneficiary_Intl());

			if (NegativeAmount.equalsIgnoreCase("true")) {

				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), AppData.getAmountNegative(), " Transfer Amount"); // Enter negative amoutn from account set.
				Utils.logPassImage("Invalid Amount");
				Utils.click(By.xpath(getObj("Propval1", "CheckBox", "JOL_INTLTransfer")), "terms and conditions ");

				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "JOL_INTLTransfer")), "Confirm"));
					Log.pass(" User is unable to complete international transfer with negative amount as expected.Terminating transaction.");
					Utils.click(By.xpath(getObj("Propval1", "cancelButton", "JOL_INTLTransfer")), "Cancel");
					Log.pass("International transfer from zero balance account cancelled successfully");
					Utils.logPassImage("Transfer Result");
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("User was able to proceed with transfer even with negative amount... Test case failed.");
					Utils.logFailImage("Transfer Result");
					throw e;
				}

			}
			// User trying to complete transaction with zero balance account.
			else if (ZeroBalAcc.equalsIgnoreCase("true")) {

				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), AppData.getAmount_International(), " Transfer Amount");
				Utils.click(By.xpath(getObj("Propval1", "CheckBox", "JOL_INTLTransfer")), "terms and conditions ");
				Utils.scrollDownVertically();
				Utils.enterOTPAndProceed();
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "JOL_INTLTransfer")), "Proceed ");
				Utils.logPassImage("Zero Balance Account");
				Utils.wait(3);
				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "JOL_INTLTransfer")), "Confirm"));
					Log.pass(" User is unable to complete international transfer with zero balanac account as expected.Terminating transaction.");
					Utils.click(By.xpath(getObj("Propval1", "cancelButton", "JOL_INTLTransfer")), "Cancel");
					Log.pass("International transfer from zero balance account cancelled successfully");
					Utils.logPassImage("Transfer Result");
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("User was able to proceed with transfer even with zero balance account... Test case failed.");
					Utils.logFailImage("Transfer Result");
					throw e;
				}
			}
			// User trying to complete transaction without checking terms and conditions.

			else if (isTermsNconditionsChecked.equalsIgnoreCase("false")) {

				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), AppData.getAmount_International(), " Transfer Amount");
				// Utils.click(By.xpath(getObj("Propval1", "CheckBox", "JOL_INTLTransfer")),
				// "terms and conditions ");
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "JOL_INTLTransfer")), "Proceed ");
				Utils.scrollDownVertically();
				Utils.wait(3);

				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "JOL_INTLTransfer")), "Confirm"));
					Log.pass(" User is unable to complete international transfer without accepting terms and conditions as expected.Terminating transaction.");
					Utils.logPassImage("Transfer Screen");
					Utils.click(By.xpath(getObj("Propval1", "cancelButton", "JOL_INTLTransfer")), "Cancel");
					Log.pass("International transfer cancelled successfully");
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("User was able to proceed with transfer even without accepting terms and conditions.. Test case failed.");
					Utils.logFailImage("Transfer Result");
					throw e;

				}

			} else {

				if (AmountLessThan100USD.contentEquals("true")) {

					// Amount as 1 will be less than 100 USD in any currency hence can eb used to
					// this scenario.
					Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), "10", " Transfer Amount");
					Log.pass("Trying to transfer USD 10 to check condition that user should not be able to transfer less than 100 USD");
				} else {
					Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), AppData.getAmount_International(), " Transfer Amount");
				}

			}

			// Enter Category type
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "category", "JOL_INTLTransfer")), By.xpath(getObj("Propval1", "categoryInput", "JOL_INTLTransfer")), Input.ReadTestData(TCName, "Category"), "Category");
			// Enter Purpose
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "purposeDropdown", "JOL_INTLTransfer")), By.xpath(getObj("Propval1", "purposeInput", "JOL_INTLTransfer")), Input.ReadTestData(TCName, "Purpose"), "Purpose");
			// Enter Payment details
			Utils.sendKeys(By.xpath(getObj("Propval1", "paymentDetails", "JOL_INTLTransfer")), Input.ReadTestData(TCName, "Payment Details"), "Payment Details");

			if (!TxfrAmountType.equalsIgnoreCase("SAR")) {

				Utils.click(By.xpath(getObj("Propval1", "TxfrAmountType", "JOL_INTLTransfer")), "transfer amount type radio box.");
				Log.pass("Selected transfer currency type is : " + TxfrAmountType);
			}

			// Execute Time
			if (Integer.parseInt(ExecutionTime) == 1) {
				TransferModuleCommonFunctions.selectExecuteNow();
			} else if (Integer.parseInt(ExecutionTime) == 2) {
				TransferModuleCommonFunctions.selectScheduled();
			} else {
				TransferModuleCommonFunctions.selectStandingOrder();
			}

			Utils.wait(1);
			Utils.click(By.xpath(getObj("Propval1", "CheckBox", "JOL_INTLTransfer")), "Condition Checked ");
			Utils.wait(2);

			// Add more transactions

			if (Integer.parseInt(AddAnotherTxn) > 0) {
				// Add another transaction based on the count of key AddAnotherTxn in child
				// table.
				TransferModuleCommonFunctions.addAnotherInternationalTxn(Integer.parseInt(AddAnotherTxn));
			}
			if (Integer.parseInt(DeleteAnotherTxn) > 0) {

				// Delete one of the recently added another transactions.
				TransferModuleCommonFunctions.deleteAnotherTxn(Integer.parseInt(DeleteAnotherTxn));
			}

			if (Integer.parseInt(Procced) == 1) {
				Utils.enterOTPAndProceed();
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "JOL_INTLTransfer")), "Proceed ");
			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "cancelButton", "JOL_INTLTransfer")), "Cancel");
				Log.pass("International transfer cancelled successfully");
				Utils.logPassImage("Cancel Result");
				return true;
			}

			if (Integer.parseInt(Confirm) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "JOL_INTLTransfer")), "Confirm");

			} else if (Integer.parseInt(Confirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "JOL_INTLTransfer")), "Modify");
				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), AppData.getAmount_ModifyIntl());

				Utils.click(By.xpath(getObj("Propval1", "CheckBox", "JOL_INTLTransfer")), "Clicked on Check BOx");
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "JOL_INTLTransfer")), "Clicked on Proceed");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "JOL_INTLTransfer")), "Clicked on Confirm");
				Utils.logPassImage("Confirm Result");
			} else {

				Utils.click(By.xpath(getObj("Propval1", "cancelButton", "JOL_INTLTransfer")), "Cancel International Transfer");
				Utils.click(By.xpath(getObj("Propval1", "yes", "JOL_INTLTransfer")), " ' Yes' to tancel the transaction.");
				Log.pass("International transfer cancelled successfully");
				Utils.logPassImage("Cancel transfer Result");
				return true;
			}

			// .............This code will run only when AmountLessThan100USD=true in DB.
			// 6069 error scenario.

			if (AmountLessThan100USD.contentEquals("true")) {

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "6069ErrorMsg", "JOL_INTLTransfer")), "6069ErrorMsg"));
					Log.pass(" Internation transfer has failed as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "6069ErrorMsg", "JOL_INTLTransfer"))));
					Utils.logPassImage("Transfer Result-Pass");
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail(" Internation transfer has worked successfully against expectations. Should have failed.Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "Card"))));
					Utils.logFailImage("Transfer Result-Fail");
					throw e;

				}

			}

			// After clicking on confirm txn, TC may pass or fail.Below Code will check for
			// success/fail message and act accordingly.
			int eleSize = 0;

			try {
				eleSize = Utils.getSize(By.xpath(getObj("Propval1", "SuccessMessage", "Card")));
			} catch (Exception e) {
				gException = e;
			}

			if (eleSize == 0) {

				String Fail = Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card")));
				Utils.logPassImage("Transfer Result");
				Log.fail(" Internation transfer has failed.. Error message displayed is : " + Fail);
				throw gException;

			} else {

				String successMsg = Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "Card")));
				Log.pass(" Internation transfer has passed. Message displayed is : : " + successMsg);
				Utils.logPassImage("Transfer Result");

				if (AdditionalActions.equalsIgnoreCase("true")) {

					// Enter tag
					Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "tagDropDown", "JOL_INTLTransfer")), By.xpath(getObj("Propval1", "tagInput", "JOL_INTLTransfer")), Input.ReadTestData(TCName, "TagValue"), "Tag Name");
					// Enter remarks
					Utils.sendKeys(By.xpath(getObj("Propval1", "remarksInput", "JOL_INTLTransfer")), Input.ReadTestData(TCName, "Remarks"), "Remarks");

					Utils.click(By.xpath("//*[@id='dijit_form_Button_4_label']"), "Save transaction", 10); // will improve when get stable x path.
					Utils.wait(3);
					Utils.pressEscapeKey(3);

					Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
					TransferModuleCommonFunctions.addFavSendEmailDownloadPdfNprint();
				}

			}

			if (Integer.parseInt(NewTxn) == 1) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "newTxnBtn", "JOL_INTLTransfer")), "Add new Transaction button");
				Utils.wait(11);
				Utils.assertDisplayed(By.xpath(getObj("Propval1", "addanotherTransaction", "JOL_INTLTransfer")), "Add another transaction");
				Log.pass(" New transaction screen is displayed successfully");
				Utils.logPassImage("New Transaction");
			}

		} catch (Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}
}
