package javaMain.JOL.transfer;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static Utilities.ReadData.readConfigXml;
import static javaMain.common_Functions.AppData.ATMEnabled;
import static javaMain.common_Functions.AppData.AddAnotherTxn;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.BeneficiaryActivationMode;
import static javaMain.common_Functions.AppData.BeneficiaryActivationModeModified;
import static javaMain.common_Functions.AppData.BeneficiaryType;
import static javaMain.common_Functions.AppData.CancelYes;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.Currency;
import static javaMain.common_Functions.AppData.DeleteAnotherTxn;
import static javaMain.common_Functions.AppData.IVREnabled;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.OTPCancelConfirm;
import static javaMain.common_Functions.AppData.OTPProceed;
import static javaMain.common_Functions.AppData.Procced;
import static javaMain.common_Functions.AppData.SMARTEnabled;

import org.openqa.selenium.By;

import Utilities.Input;
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

public class JOL_TRANSFERS_ADD_NEW_BENEFICIARY extends TestBase {

	@SuppressWarnings("unused")
	public static Boolean JOL_TRANSFERS_ADD_NEW_BENEFICIARY_Func(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				BeneficiaryType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryType"));
				BeneficiaryActivationMode = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryActivationMode"));
				SMARTEnabled = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "SMARTEnabled"));
				ATMEnabled = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ATMEnabled"));
				IVREnabled = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "IVREnabled"));
				Procced = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Procced"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				OTPCancelConfirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPCancelConfirm"));
				CancelYes = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CancelYes"));
				Currency = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Currency"));
				BeneficiaryActivationModeModified = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryActivationModeModified"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				AddAnotherTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AddAnotherTxn"));
				DeleteAnotherTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "DeleteAnotherTxn"));
			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				BeneficiaryType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryType"));
				BeneficiaryActivationMode = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryActivationMode"));
				SMARTEnabled = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("SMARTEnabled"));
				ATMEnabled = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ATMEnabled"));
				IVREnabled = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("IVREnabled"));
				Procced = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Procced"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				OTPCancelConfirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPCancelConfirm"));
				CancelYes = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CancelYes"));
				Currency = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Currency"));
				BeneficiaryActivationModeModified = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryActivationModeModified"));
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
				AddAnotherTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AddAnotherTxn"));
				DeleteAnotherTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("DeleteAnotherTxn"));
			}

			// Delete existing beneficiaries

			try {
				// Click on Transfer Tab//
				Utils.click(By.xpath(getObj("Propval1", "TransfersLnk", "Add_New_Beneficiary")), "Transfer Link");
				// Click Beneficiaries Link on the left Panel//
				Utils.click(By.xpath(getObj("Propval1", "BeneficiariesLnk", "Add_New_Beneficiary")), "Beneficiaries Link");
				// Click AddNewBeneficiary Link under Beneficiaries link//
				Utils.click(By.xpath(getObj("Propval1", "BeneficiarymanagementLnk", "Add_New_Beneficiary")), "Beneficiary Management Link");
				
				Log.pass("Started trying to delete already existing beneficiaries.");
				// Click on Delete Button//
				Utils.clickSafely(By.xpath(getObj("Propval1", "DeleteBen", "Add_New_Beneficiary")), "Delete Button");
				// Click on Confirm Button//
				Utils.clickSafely(By.xpath(getObj("Propval1", "ConfirmBtn", "Add_New_Beneficiary")), "Confirm Button");
			}

			catch (Exception e) {

				Log.info("Unable to delete beneficiaries, or no beneficiary present on screen to be deleted");

			}

			// Open Beneficiary screen.
			Utils.mouseHover(By.xpath(getObj("Propval1", "TransfersLnk", "Add_New_Beneficiary")));
			Utils.clickSafely(By.xpath(getObj("Propval1", "Add_New_Beneficiary_Menu_N", "Add_New_Beneficiary")), "AddBeneficiary Link");
			Utils.enterOTPAndProceed();

			if (Integer.parseInt(BeneficiaryType) == 1)// WithinBAJ will be selected//
			{
				Log.pass("Beneficiary type to be selected is : Within BAJ ");
				// Select Within Bank AlJazira//
				Utils.sendKeys_DD(By.xpath(getObj("Propval1", "BeneficiaryType", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "BenTypeWithinBAJ"));
				// Enter the Nickname//
				Utils.sendKeys(By.xpath(getObj("Propval1", "Nickname_AddNewBen", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "Nickname_WithInBAJ"), "Nick Name");
				// Enter a valid Account Number//
				Utils.sendKeys(By.xpath(getObj("Propval1", "AccountNo_AddNewBen", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "AccountNumber"), "AccountNumber");

			} else if (Integer.parseInt(BeneficiaryType) == 2)// Local Beneficiary will be selected.

			{
				Log.pass("Beneficiary type to be selected is : Local ");
				// Select Local Beneficiary //
				Utils.sendKeys_DD(By.xpath(getObj("Propval1", "BeneficiaryType", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "BenTypeLocal"));
				// Enter FullName//
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Fullname_AddNewBen", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "FullName_LocalBen"), "Fullname");
				// Enter NickName//
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Nickname_AddNewBen", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "Nickname_LocalBen"), "Nickname");
				// Enter IBAN Number//
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "IBAN_AddNewBen", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "IBANNumber_LocalBen"), "IBAN Number");

			}

			else if (Integer.parseInt(BeneficiaryType) == 3)// International Beneficiary will be selected
			{
				Log.pass("Beneficiary type to be selected is : International ");
				// Select International Beneficiary //
				Utils.sendKeys_DD(By.xpath(getObj("Propval1", "BeneficiaryType", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "BenTypeIntl"));

				// Enter FullName//
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Fullname_AddNewBen", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "Fullname_IntlBen"), "Fullname");
				// Enter NickName//
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Nickname_AddNewBen", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "Nickname_IntlBen"), "Nickname");
				// Enter SwiftCode//
				Utils.sendKeys(By.xpath(getObj("Propval1", "SwiftCode_AddNewBen", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "SwiftCode"), "SwiftCode");
				Utils.pressTab();
				// Click on Bank Address TextBox//
				Utils.click(By.xpath(getObj("Propval1", "Whitespace", "Add_New_Beneficiary")), "Blank Space");
				// Enter Bank Address//
				Utils.sendKeys(By.xpath(getObj("Propval1", "BankAddress", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "BankAddress"), "BankAddress");
				// Enter Bank City Branch//
				Utils.sendKeys(By.xpath(getObj("Propval1", "BankCityBranch", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "BankCityBranch"), "BankCityBranch");
				// Enter IBAN International//
				Utils.sendKeys(By.xpath(getObj("Propval1", "IBAN_International", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "IBANNumber_Intl"), "IBANNumber");

				// Enter Currency//
				if (Integer.parseInt(Currency) == 1) {
					Utils.sendKeys(By.xpath(getObj("Propval1", "Currency_International", "Add_New_Beneficiary")), "AED", "Currency ");
					Log.pass("Successfully selected currency : " + "AED");
				} else if (Integer.parseInt(Currency) == 2) {
					Utils.sendKeys(By.xpath(getObj("Propval1", "Currency_International", "Add_New_Beneficiary")), "USD", " Currency ");
					Log.pass("Successfully selected currency : " + "USD");
				}

			}

			// Select the Beneficiary Activation Mode//

			if (Integer.parseInt(BeneficiaryActivationMode) == 1) {

				if (AppData.getLanguage().equalsIgnoreCase("EN")) {

					Utils.sendKeys(By.xpath(getObj("Propval1", "BeneficiaryActivationMode", "Add_New_Beneficiary")), "Request an Automated Call Back", "Request an Automated Call Back");
				} else {

					Utils.sendKeys(By.xpath(getObj("Propval1", "BeneficiaryActivationMode", "Add_New_Beneficiary")), "«” ﬁ»«· „ﬂ«·„… ¬·Ì… „‰ ‰Ÿ«„ «·Ã“Ì—… ›Ê‰", "Call the Toll-Free Number");
				}
			} else if (Integer.parseInt(BeneficiaryActivationMode) == 2) {

				if (AppData.getLanguage().equalsIgnoreCase("EN")) {
					Utils.sendKeys(By.xpath(getObj("Propval1", "BeneficiaryActivationMode", "Add_New_Beneficiary")), "Call the Toll-Free Number", "Call the Toll-Free Number");
				} else {

					Utils.sendKeys(By.xpath(getObj("Propval1", "BeneficiaryActivationMode", "Add_New_Beneficiary")), "«·≈ ’«· »«·—ﬁ„ «·„ÊÕœ", "Call the Toll-Free Number");
				}

			}

			Utils.pressTab();
			Utils.pressTab();
			Utils.pressTab();

			if (Integer.parseInt(SMARTEnabled) == 1) {
				// Check Smart Enabled Checkbox//
				Utils.click(By.xpath(getObj("Propval1", "SmartChckBx", "Add_New_Beneficiary")), "Smart Check Box");
				Utils.click(By.xpath(getObj("Propval1", "SmartChckBx", "Add_New_Beneficiary")), "Smart Check Box");

			}
			if (Integer.parseInt(SMARTEnabled) == 0) { // Uncheck Smart Enabled Checkbox//
				Utils.click(By.xpath(getObj("Propval1", "SmartChckBx", "Add_New_Beneficiary")), "Smart Check Box");
			}

			if (Integer.parseInt(ATMEnabled) == 1) { // Check ATM Enabled Checkbox//
				Utils.click(By.xpath(getObj("Propval1", "ATMChckBx", "Add_New_Beneficiary")), "ATM Check Box");

			}

			if (Integer.parseInt(IVREnabled) == 1) {
				// Check IVR Enabled Checkbox//
				Utils.click(By.xpath(getObj("Propval1", "IVRChckBx", "Add_New_Beneficiary")), "IVR Enabled");
			}

			if (Integer.parseInt(AddAnotherTxn) > 0) {
				// Add another transaction based on the count of key AddAnotherTxn .
				TransferModuleCommonFunctions.addAnotherBeneficiaryJOL();
			}
			if (Integer.parseInt(DeleteAnotherTxn) > 0) {
				// Delete the transactions.
				TransferModuleCommonFunctions.deleteBeneficiaryJOL(Integer.parseInt(DeleteAnotherTxn));
			}

			if (Integer.parseInt(Procced) == 1) {
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "Add_New_Beneficiary")), "Proceed Button");

			} else if (Integer.parseInt(Procced) == 3) {
				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "Add_New_Beneficiary")), "Cancel Button");
				Log.pass("Successfully cancelled the transaction as required");
				return runResult;
			}

			if (Integer.parseInt(Confirm) == 1) {
				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "Add_New_Beneficiary")), "Confirm Button");

				// Enter OTP//
				Utils.sendKeys(By.xpath(getObj("Propval1", "OTP", "Add_New_Beneficiary")), readConfigXml("OTP"), "OTP");

				if (Integer.parseInt(OTPProceed) == 1) {

					// Click on OTP Proceed//
					Utils.click(By.xpath(getObj("Propval1", "OTPProceedBtn", "Add_New_Beneficiary")), "Proceed Button on OTP Page");

				}

				else if (Integer.parseInt(OTPProceed) == 2) {

					// Click on BackButton on OTP Page//
					Utils.click(By.xpath(getObj("Propval1", "ModifyBtn", "Add_New_Beneficiary")), "Back Button");
					Utils.enterOTPAndProceed();
					// Click on Confirm Button//
					Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "Add_New_Beneficiary")), "Confirm Button");
					Utils.enterOTPAndProceed();

				} else if (Integer.parseInt(OTPProceed) == 3) {

					// Click on Cancel Button OTP Page//
					Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "Add_New_Beneficiary")), "Cancel Button on OTP Page");

					if (Integer.parseInt(OTPCancelConfirm) == 1) {

						// Click on Confirm to cancel//
						Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn_Confirm", "Add_New_Beneficiary")), "Confirm Button to cancel the transaction");
						return true;

					} else if (Integer.parseInt(OTPCancelConfirm) == 2) {

						// Click on Cancel to revert//
						Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn_Cancel", "Add_New_Beneficiary")), "Cancel Button to continue the transaction.");
						// Click on OTP Proceed//
						Utils.click(By.xpath(getObj("Propval1", "OTPProceedBtn", "Add_New_Beneficiary")), "Proceed Button on the OTP Page");

					}
				}

				else {

					// Click on OTP Proceed//
					Utils.clickSafely(By.xpath(getObj("Propval1", "OTPProceedBtn", "Add_New_Beneficiary")), "Proceed Button on OTP Page");
				}
			}

			else if (Integer.parseInt(Confirm) == 2) {

				Log.pass("Successfully started modifying the transaction");
				// Click on Modify Button//
				Utils.click(By.xpath(getObj("Propval1", "ModifyBtn", "Add_New_Beneficiary")), "Modify Button");

				// Select the Beneficiary Activation Mode Change//MAY REQUIRE A TWEAK

				if (Integer.parseInt(BeneficiaryActivationModeModified) == 1) {

					if (AppData.getLanguage().equalsIgnoreCase("EN")) {

						Utils.sendKeys(By.xpath(getObj("Propval1", "BeneficiaryActivationMode", "Add_New_Beneficiary")), "Request an Automated Call Back", "Request an Automated Call Back");
					} else {
						Utils.sendKeys(By.xpath(getObj("Propval1", "BeneficiaryActivationMode", "Add_New_Beneficiary")), "«” ﬁ»«· „ﬂ«·„… ¬·Ì… „‰ ‰Ÿ«„ «·Ã“Ì—… ›Ê‰", "Request an Automated Call Back");
					}

				} else if (Integer.parseInt(BeneficiaryActivationModeModified) == 2) {

					if (AppData.getLanguage().equalsIgnoreCase("EN")) {
						Utils.sendKeys(By.xpath(getObj("Propval1", "BeneficiaryActivationMode", "Add_New_Beneficiary")), "Call the Toll-Free Number", "Call the Toll-Free Number");
					} else {
						Utils.sendKeys(By.xpath(getObj("Propval1", "BeneficiaryActivationMode", "Add_New_Beneficiary")), "«·≈ ’«· »«·—ﬁ„ «·„ÊÕœ", "Call the Toll-Free Number");
					}

				}

				else if (Integer.parseInt(BeneficiaryActivationMode) == 2) {

					Utils.pressEnter();
					Utils.wait(1);
					Utils.pressTab();
					// Click on Proceed Button//
					Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "Add_New_Beneficiary")), "Proceed Button");
					// Click on Confirm Button//
					Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "Add_New_Beneficiary")), "Confirm Button");
					// Enter OTP//
					Utils.sendKeys(By.xpath(getObj("Propval1", "OTP", "Add_New_Beneficiary")), readConfigXml("OTP"), "OTP");
					// Click on OTP Proceed//
					Utils.click(By.xpath(getObj("Propval1", "OTPProceedBtn", "Add_New_Beneficiary")), "Proceed Button on OTP Page");
				}
			}

			else if (Integer.parseInt(Confirm) == 3) {

				Utils.enterOTPAndProceed();
				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "Add_New_Beneficiary")), "Cancel Button");

				if (Integer.parseInt(CancelYes) == 1) {
					// Click on Yes Button to Cancel the Transaction//
					Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn_Confirm", "Add_New_Beneficiary")), "Yes Button to Cancel the transaction");

					return runResult;

				} else if (Integer.parseInt(CancelYes) == 2) {

					// Click on No Button //
					Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn_Cancel", "Add_New_Beneficiary")), "No Button ");
					// Click on Confirm Button//
					Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "Add_New_Beneficiary")), "Confirm Button");

				}

			}

			if (AdditionalActions.equalsIgnoreCase("true")) {

				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				TransferModuleCommonFunctions.addFavSendEmailDownloadPdfNprintFuncAddBeneficiary(Input.ReadTestData(TCName, "Nickname_WithInBAJ"));
				Log.pass("AfterTxfrAdditionalOptions hav passed successfully.");

			}

			if (NewTxn.equalsIgnoreCase("true")) {

				Utils.scrollDownVertically();

				Utils.click(By.xpath(getObj("Propval1", "newTxnBtn", "JOL_INTLTransfer")), "Add new Transaction button");
				Utils.wait(5);
				Utils.waitTillSaudiWaitIconDisappears();
				Utils.assertDisplayed(By.xpath(getObj("Propval1", "addanotherTransaction", "JOL_INTLTransfer")), "Add another transaction");
				Log.pass(" New transaction screen is displayed successfully");
				Utils.logPassImage("New Transaction");
				Utils.scrollUpVertically();
			}
		}

		catch (AssertionError | Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}
}
