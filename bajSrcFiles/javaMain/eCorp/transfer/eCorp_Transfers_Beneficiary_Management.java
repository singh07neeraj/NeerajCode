package javaMain.eCorp.transfer;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AddNewBeneficiary;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.BeneficiaryType;
import static javaMain.common_Functions.AppData.BenificiaryCategory;
import static javaMain.common_Functions.AppData.CancelConfirm;
import static javaMain.common_Functions.AppData.Fullname;
import static javaMain.common_Functions.AppData.Initiator;
import static javaMain.common_Functions.AppData.Modify;
import static javaMain.common_Functions.AppData.Nickname;
import static javaMain.common_Functions.AppData.ProceedEmail;
import static javaMain.common_Functions.AppData.cancelEdit;
import static javaMain.common_Functions.AppData.deleteBeneficiary;
import static javaMain.common_Functions.AppData.editBeneficiary;
import static javaMain.common_Functions.AppData.validateTxfrFunds;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenEcorpMenues;
import javaMain.common_Functions.eCorpCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_Transfers_Beneficiary_Management extends TestBase {

	@SuppressWarnings("unused")
	public static Boolean eCorp_Transfers_Beneficiary_Management_Func(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AddNewBeneficiary = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AddNewBeneficiary"));
				BeneficiaryType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryType"));
				deleteBeneficiary = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "deleteBeneficiary"));
				editBeneficiary = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "editBeneficiary"));
				ProceedEmail = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ProceedEmail"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));

				cancelEdit = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "cancelEdit"));
				Modify = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Modify"));
				CancelConfirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CancelConfirm"));
				CancelConfirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CancelConfirm"));
				Initiator = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Initiator"));
				BenificiaryCategory = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BenificiaryCategory"));
				Fullname = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Fullname"));
				Nickname = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Nickname"));
				validateTxfrFunds = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "validateTxfrFunds"));

			} else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AddNewBeneficiary = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AddNewBeneficiary"));
				BeneficiaryType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryType"));
				deleteBeneficiary = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("deleteBeneficiary"));
				editBeneficiary = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("editBeneficiary"));
				ProceedEmail = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ProceedEmail"));
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));

				cancelEdit = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("cancelEdit"));
				Modify = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Modify"));
				CancelConfirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CancelConfirm"));

				Initiator = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Initiator"));
				BenificiaryCategory = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BenificiaryCategory"));
				Fullname = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Fullname"));
				Nickname = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Nickname"));
				validateTxfrFunds = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("validateTxfrFunds"));
			}

			// Open Manage Beneficiaries page below-
			OpenEcorpMenues.openTransfersMenu("BeneficiaryManagement");

			// Select Beneficiary type and category etc.

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "beneficiarytype1DropdownDropdown", "BENEFICIARY_MANAGEMENT")), By.xpath(getObj("Propval1", "beneficiarytype1", "BENEFICIARY_MANAGEMENT")), BeneficiaryType, "Beneficiary Type");
			Log.info("Successfully selected Beneficiary Type.");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "initiatorDropdown", "BENEFICIARY_MANAGEMENT")), By.xpath(getObj("Propval1", "initiatorInput", "BENEFICIARY_MANAGEMENT")), Initiator, "Beneficiary Type");
			Log.info("Successfully selected Initiator Type.");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryCatDropdown", "BENEFICIARY_MANAGEMENT")), By.xpath(getObj("Propval1", "BeneficiaryCatInput", "BENEFICIARY_MANAGEMENT")), BenificiaryCategory, "Beneficiary Type");
			Log.info("Successfully selected Beneficiary Category Type.");

			Utils.sendKeys(By.xpath(getObj("Propval1", "FullNameInput", "BENEFICIARY_MANAGEMENT")), Input.ReadTestData(TCName, "FullName"), "Full Name");

			Utils.sendKeys(By.xpath(getObj("Propval1", "NickNameInput", "BENEFICIARY_MANAGEMENT")),  Input.ReadTestData(TCName, "NickName"), "Nick Name");
			Utils.logPassImage("Search Parameters");
			// Click on Search
			Utils.click(By.xpath(getObj("Propval1", "Search", "BENEFICIARY_MANAGEMENT")), "Click on Search");

			Utils.wait(10);
			int CountOfResults = Utils.getSizeNoException(By.xpath(getObj("Propval1", "SearchResult", "BENEFICIARY_MANAGEMENT")));
			Log.info("Count of search results displayed on screen is : " + CountOfResults);
			
			if (CountOfResults==0) {

				Log.info("No records displayed after search, hence test scenarios like edit , delete beneficiary, validate funds transfer and send email print , pdf etc will be skipped.");
				deleteBeneficiary = "false";
				editBeneficiary = "false";
				AdditionalActions = "false";
				validateTxfrFunds = "false";
				return true;
			} else {
				Utils.mouseHover(By.xpath(getObj("Propval1", "TootlTip", "BENEFICIARY_MANAGEMENT")));
				Log.pass("On Mouse Hover- Beneficiary details are displayed successfully");
				Utils.logPassImage("Mouse Over details-Bebeficiary");
				Utils.mouseHover(By.className("toolbar"));
				Utils.wait(3);
			}

			if (validateTxfrFunds.equalsIgnoreCase("true")) {

				// Click on Delete Button//
				Utils.click(By.xpath(getObj("Propval1", "transferFunds", "BENEFICIARY_MANAGEMENT")), "Transfer funds");

				try {
					Utils.wait(5);
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "transferFundsBar", "BENEFICIARY_MANAGEMENT")), "Transfer funds  landing page icon "));
					Utils.logPassImage("Transfer details screen");
					Log.info("Successfully navigated to 'Transfer Funds' screen from beneficiary Management module as expected. Returning back to Beneficiary Management module.");
					Utils.click(By.xpath(getObj("Propval1", "cancelBtn", "BENEFICIARY_MANAGEMENT")), "Cancel Button");

				} catch (AssertionError | Exception e) {

					Log.fail("Unable to navigated to 'Transfer Funds' screen from beneficiary Management module.error...");
					Utils.logFailImage("Transfer Funds screen");
					throw e;
				}

			}

			if (deleteBeneficiary.equalsIgnoreCase("true")) {

				// Click on Delete Button//
				Utils.click(By.xpath(getObj("Propval1", "DeleteBen", "Add_New_Beneficiary")), "Delete Button");
				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "Add_New_Beneficiary")), "Confirm Button");

				try {
					Utils.wait(5);
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "successMsg", "BENEFICIARY_MANAGEMENT")), "Delete Beneficiary Success message"));
					Log.info("Successfully deleted Beneficiary.Message displayed is :" + Utils.getText(By.xpath(getObj("Propval1", "successMsg", "BENEFICIARY_MANAGEMENT"))));

				} catch (AssertionError | Exception e) {

					Log.fail("Unable to delete beneficiary.. error while deleting.." + ExceptionUtils.getStackTrace(e));
				}

				Utils.clickSafely(By.id(getObj("Propval1", "BankToBenManagement", "BENEFICIARY_MANAGEMENT")), "Back to Beneficiary Management");

			}

			if (editBeneficiary.equalsIgnoreCase("true")) {

				// Click on edit Button// EditedNickName
				Utils.click(By.xpath(getObj("Propval1", "editBtnBeneficiary", "BENEFICIARY_MANAGEMENT")), "Edit");

				Utils.sendKeys(By.xpath(getObj("Propval1", "nickName", "BENEFICIARY_MANAGEMENT")), Input.ReadTestData(TCName, "EditedNickName"), "Nick Name");
				Utils.logPassImage("Nick name");
				if (cancelEdit.equalsIgnoreCase("true")) {
					Utils.click(By.xpath(getObj("Propval1", "cancelBtn", "BENEFICIARY_MANAGEMENT")), "Cancel Button");
					return true;

				}

				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "BENEFICIARY_MANAGEMENT")), "Proceed Button");

				if (Modify.equalsIgnoreCase("true")) {
					Utils.click(By.xpath(getObj("Propval1", "ModifyBtnEditBen", "BENEFICIARY_MANAGEMENT")), "Modify Button");
					// Click on Proceed Button//
					Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "BENEFICIARY_MANAGEMENT")), "Proceed Button");
				}

				if (CancelConfirm.equalsIgnoreCase("true")) {
					Utils.click(By.xpath(getObj("Propval1", "cancelBtn", "BENEFICIARY_MANAGEMENT")), "Cancel Button");

					try {
						Utils.click(By.xpath(getObj("Propval1", "cancelYesBtn", "BENEFICIARY_MANAGEMENT")), "Yes to cancel the edit beneficiary process.");
					} catch (Exception e) {
						Utils.clickSafely(By.xpath("(//span[contains(text(),'Yes')])[2]"), "Yes to cancel the edit beneficiary process.");
					}

					Utils.enterOTPAndProceed();
					return true;
				}

				Utils.click(By.xpath(getObj("Propval1", "confirmBtn", "BENEFICIARY_MANAGEMENT")), "Confirm");
				Log.pass("Successfully edited the beneficiary details and confirmed it");
				Utils.logPassImage("Confirm Button");

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "successMsg", "BENEFICIARY_MANAGEMENT")), "Success Message"));
					Log.pass("Successfully edited the beneficiary details and confirmed it. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "successMsg", "BENEFICIARY_MANAGEMENT"))));
				} catch (AssertionError | Exception e) {
					Log.fail("Unable to edit the beneficiary details.. error..");
					Utils.logFailImage("Edit Beneficiary Error");
					throw e;
				}

				Utils.click(By.id(getObj("Propval1", "BankToBenManagement", "BENEFICIARY_MANAGEMENT")), "Back to Beneficiary Management");

			}

			if (AdditionalActions.equalsIgnoreCase("true")) {

				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");

			}

		}

		catch (Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}
}
