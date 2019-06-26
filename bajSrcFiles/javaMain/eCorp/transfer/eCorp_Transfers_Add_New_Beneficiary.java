package javaMain.eCorp.transfer;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AccountNumber;
import static javaMain.common_Functions.AppData.AddAnotherTxn;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.BankAddress;
import static javaMain.common_Functions.AppData.BankCityBranch;
import static javaMain.common_Functions.AppData.BeneficiaryCategory;
import static javaMain.common_Functions.AppData.BeneficiaryType;
import static javaMain.common_Functions.AppData.CancelYes;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.Currency;
import static javaMain.common_Functions.AppData.DeleteAnotherTxn;
import static javaMain.common_Functions.AppData.Fullname;
import static javaMain.common_Functions.AppData.IBANNumber;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.NickName;
import static javaMain.common_Functions.AppData.Nickname;
import static javaMain.common_Functions.AppData.Nickname_Modified;
import static javaMain.common_Functions.AppData.Procced;
import static javaMain.common_Functions.AppData.SwiftCode;

import org.openqa.selenium.By;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.OpenEcorpMenues;
import javaMain.common_Functions.eCorpCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */

public class eCorp_Transfers_Add_New_Beneficiary extends TestBase {


	@SuppressWarnings("unused")
	public static Boolean eCorp_Transfers_Add_New_Beneficiary_Func(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

		//	if (isMasterClassRun) {
				if (true) {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				BeneficiaryType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryType"));
				BeneficiaryCategory = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryCategory"));
				Procced = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Procced"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				CancelYes = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CancelYes"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				Currency = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Currency"));

				Fullname = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Fullname"));
				Nickname = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Nickname"));
				AccountNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				AddAnotherTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AddAnotherTxn"));

				DeleteAnotherTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "DeleteAnotherTxn"));
				IBANNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "IBANNumber"));

				SwiftCode = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "SwiftCode"));
				Nickname_Modified = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Nickname_Modified"));

				BankAddress = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BankAddress"));
				BankCityBranch = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BankCityBranch"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");

				BeneficiaryType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryType"));
				BeneficiaryCategory = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryCategory"));
				Procced = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Procced"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				CancelYes = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CancelYes"));
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
				Currency = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Currency"));

				Fullname = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Fullname"));
				Nickname = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Nickname"));
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				AddAnotherTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AddAnotherTxn"));

				DeleteAnotherTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("DeleteAnotherTxn"));
				IBANNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("IBANNumber"));
				SwiftCode = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("SwiftCode"));
				Nickname_Modified = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Nickname_Modified"));

				BankAddress = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BankAddress"));
				BankCityBranch = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BankCityBranch"));

			}
	

			if (AccountNumber.equalsIgnoreCase("0")) {

				AccountNumber = Input.ReadTestData(TCName, "AccountNumber");
			}
			/*
			 * if (BeneficiaryCategory.equalsIgnoreCase("0")) {
			 * 
			 * BeneficiaryCategory = Input.ReadTestData(TCName, "BeneficiaryCategory"); }
			 */
			
			if (SwiftCode.equalsIgnoreCase("0")) {

				SwiftCode = Input.ReadTestData(TCName, "SwiftCode");
			}
			
			if (BankAddress.equalsIgnoreCase("0")) {

				BankAddress = Input.ReadTestData(TCName, "BankAddress");
			}
			if (BankCityBranch.equalsIgnoreCase("0")) {

				BankCityBranch = Input.ReadTestData(TCName, "BankCityBranch");
			}
		
			if (Currency.equalsIgnoreCase("0")) {

				Currency = Input.ReadTestData(TCName, "Currency");
			}

			
			// Open Beneficiary screen.

			OpenEcorpMenues.openTransfersMenu("AddNewBeneficiary");

			if (Integer.parseInt(BeneficiaryType) == 1)// WithinBAJ will be selected//
			{
				

				// Select Within Bank AlJazira//
				Utils.sendKeys_DD(By.xpath(getObj("Propval1", "BeneficiaryType", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "BenTypeWithinBAJ"));
				// Enter the Nickname//
				Utils.sendKeys(By.xpath(getObj("Propval1", "Nickname_AddNewBen", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "Nickname_WithInBAJ"), "Nick Name");
				// Enter a valid Account Number//
				Utils.sendKeys(By.xpath(getObj("Propval1", "AccountNo_AddNewBen", "Add_New_Beneficiary")), AccountNumber, "AccountNumber");

			} else if (Integer.parseInt(BeneficiaryType) == 2)// Local Beneficiary will be selected.

			{ 

				// Select Local Beneficiary //
				Utils.sendKeys_DD(By.xpath(getObj("Propval1", "BeneficiaryType", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "BenTypeLocal"));

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryCategoryDropdown", "Add_New_Beneficiary")), By.xpath(getObj("Propval1", "BeneficiaryCategoryInput", "Add_New_Beneficiary")), BeneficiaryCategory,
						"Beneficiary Category dropdown.");

				// Enter FullName//  

				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Fullname_AddNewBen", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "FullName_LocalBen"), "Full Name");

				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Beneficiary_DD", "Add_New_Beneficiary")), AppData.getBeneficiary_Local(), "Beneficiary.");
				// Enter NickName//
				Utils.sendKeys(By.xpath(getObj("Propval1", "Nickname_AddNewBen", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "Nickname_LocalBen"), "Nick Name");
				// Enter IBAN Number//
				Utils.sendKeys(By.xpath(getObj("Propval1", "IBAN_AddNewBen", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "IBANNumber_LocalBen"), "IBAN Number");
				Utils.wait(2);
				Utils.pressTab();
				Utils.wait(4);
			}

			else if (Integer.parseInt(BeneficiaryType) == 3)// International Beneficiary will be selected
			{
				// Select International Beneficiary //
				Utils.sendKeys_DD(By.xpath(getObj("Propval1", "BeneficiaryType", "Add_New_Beneficiary")),  Input.ReadTestData(TCName, "BenTypeIntl"));

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryCategoryDropdown", "Add_New_Beneficiary")), By.xpath(getObj("Propval1", "BeneficiaryCategoryInput", "Add_New_Beneficiary")), BeneficiaryCategory,
						"Beneficiary Category dropdown.");

				// Enter FullName//
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Fullname_AddNewBen", "Add_New_Beneficiary")),  Input.ReadTestData(TCName, "Fullname_IntlBen"), "Fullname");
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Beneficiary_DD", "Add_New_Beneficiary")), AppData.getBeneficiary_Intl(), "Beneficiary.");

				// Enter NickName//
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Nickname_AddNewBen", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "Nickname_IntlBen"), "Nickname");
				// Enter SwiftCode//
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "SwiftCode_AddNewBen", "Add_New_Beneficiary")), SwiftCode, "SwiftCode");
				Utils.pressTab();
				// Enter Bank Address//
				Utils.wait(3);
				Utils.sendKeys(By.xpath(getObj("Propval1", "BankAddress", "Add_New_Beneficiary")), BankAddress, "BankAddress");
				// Enter Bank City Branch//
				Utils.sendKeys(By.xpath(getObj("Propval1", "BankCityBranch", "Add_New_Beneficiary")), BankCityBranch, "BankCityBranch");
				// Enter IBAN International//
				Utils.sendKeys(By.xpath(getObj("Propval1", "IBAN_International", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "IBANNumber_Intl"), "IBAN Number");
				Utils.wait(2);
				Utils.pressTab();
				Utils.wait(4);
				Utils.sendKeys(By.xpath(getObj("Propval1", "Currency_International", "Add_New_Beneficiary")), Currency, "Currency");
				Utils.wait(2);
			}

			// Add /delete beneficiaries

			if (Integer.parseInt(AddAnotherTxn) > 0) {

				// Add another transaction based on the count of key AddAnotherTxn .

				eCorpCommonFunctions.addAnotherBeneficiaryECorp();

			}
			if (Integer.parseInt(DeleteAnotherTxn) > 0) {

				// Delete the transactions.
				eCorpCommonFunctions.deleteBeneficiaryEcorp(Integer.parseInt(DeleteAnotherTxn));
			}

			Utils.enterOTPAndProceed();

			if (Integer.parseInt(Procced) == 1) {
				System.out.println(getObj("Propval1", "ProceedBtn", "Add_New_Beneficiary"));
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "Add_New_Beneficiary")), "Proceed Button");

			}

			else if (Integer.parseInt(Procced) == 3) {
				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "Add_New_Beneficiary")), "Cancel Button");
				Log.pass("Successfully cancelled 'Add New Beneficiary' transactions");
				return true;
			}

			if (Integer.parseInt(Confirm) == 1) {
				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "Add_New_Beneficiary")), "Confirm Button");

			}

			else if (Integer.parseInt(Confirm) == 2) {

				// Click on Modify Button//
				Utils.click(By.xpath(getObj("Propval1", "ModifyBtn", "Add_New_Beneficiary")), "Modify Button");

				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "Add_New_Beneficiary")), "Proceed Button");
				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "Add_New_Beneficiary")), "Confirm Button");

			}

			else if (Integer.parseInt(Confirm) == 3) {

				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "Add_New_Beneficiary")), "Cancel Button");

				if (Integer.parseInt(CancelYes) == 1) {
					// Click on Yes Button to Cancel the Transaction//
					Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn_Confirm", "Add_New_Beneficiary")), "Yes Button to Cancel the transaction");

					return runResult;

				} else if (Integer.parseInt(CancelYes) == 2) {

					// Click on No Button //
					Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn_Cancel", "Add_New_Beneficiary")), "No Button ");
					Utils.wait(4);
					// Click on Confirm Button//
					Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "Add_New_Beneficiary")), "Confirm Button");

				}

			}

			if (AdditionalActions.equalsIgnoreCase("true")) {

				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.addFavSendEmailDownloadPdfNprintFuncAddBeneficiary(NickName);
				Log.pass("AfterTxfrAdditionalOptions have  passed successfully.");

			}

			if (NewTxn.equalsIgnoreCase("true")) {

				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "newTxnBtn", "Add_New_Beneficiary")), "Add new Transaction button");
				Utils.wait(11);
				Utils.assertDisplayed(By.xpath(getObj("Propval1", "addanotherTransaction", "JOL_INTLTransfer")), "Add another transaction");
				Log.pass(" Add another  transaction screen is displayed successfully");
				Utils.logPassImage("New Transaction");
			}

			else {
				Log.pass("Starting navigation to home screen");
				Utils.clickSafely(By.xpath(getObj("Propval1", "HomeBtn", "Add_New_Beneficiary")), "Home Button");

			}

		}

		catch (AssertionError | Exception e) {

			runResult = false;
			throw e;

		}
		return runResult;
	}
}
