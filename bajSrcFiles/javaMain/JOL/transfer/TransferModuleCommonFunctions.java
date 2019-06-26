package javaMain.JOL.transfer;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AccountNumber;
import static javaMain.common_Functions.AppData.AddAnotherTxn;
import static javaMain.common_Functions.AppData.BankAddress;
import static javaMain.common_Functions.AppData.BankCityBranch;
import static javaMain.common_Functions.AppData.BeneficiaryCategory;
import static javaMain.common_Functions.AppData.BeneficiaryType;
import static javaMain.common_Functions.AppData.Currency;
import static javaMain.common_Functions.AppData.ExecutionTime;
import static javaMain.common_Functions.AppData.FromAcc;
import static javaMain.common_Functions.AppData.Fullname;
import static javaMain.common_Functions.AppData.IBANNumber;
import static javaMain.common_Functions.AppData.Nickname;
import static javaMain.common_Functions.AppData.SwiftCode;
import static javaMain.common_Functions.AppData.TxfrAmountType;
import static javaMain.common_Functions.AppData.sendEmail;

import java.util.Random;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;

public class TransferModuleCommonFunctions extends TestBase {

	public static void selectExecuteNow() {

		Assert.assertTrue(Utils.assertDisplayed(By.xpath("//*[@aria-checked='true' and @value='IMMEDIATE']"), "Execute now"));
		Log.pass("Execute now is already selected by default. Keeping it selected as per reuirement.");

	}

	public static void selectScheduled() throws Exception {

		Utils.click(By.xpath(getObj("Propval1", "Schedule", "JOL_INTLTransfer")), "Schedule");
		Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "nickName_ns", "JOL_INTLTransfer")), ReadTestData(TCName, "NickName"), "Nick Name");
		Utils.wait(2);

		WebElement Date = driver.findElement(By.xpath(getObj("Propval1", "txfrByDate", "JOL_INTLTransfer")));
		Date.sendKeys(ReadTestData(TCName, "EndDate"));
		Log.pass("Entered End Date is :" + ReadTestData(TCName, "EndDate"));
	}

	public static void selectStandingOrder() throws Exception {

		Utils.click(By.xpath(getObj("Propval1", "stdorder", "JOL_INTLTransfer")), "Standard Order");
		Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "STDNickName", "JOL_INTLTransfer")), ReadTestData(TCName, "NickName"), "Nick Name");
		Utils.wait(3);

		WebElement StartDate = driver.findElement(By.xpath(getObj("Propval1", "StartDate", "JOL_INTLTransfer")));
		StartDate.sendKeys(ReadTestData(TCName, "StartDate"));
		Log.pass("Entered Sart Date is :" + ReadTestData(TCName, "StartDate"));

		WebElement endtDate = driver.findElement(By.xpath(getObj("Propval1", "endDate", "JOL_INTLTransfer")));
		endtDate.sendKeys(ReadTestData(TCName, "EndDate"));
		Log.pass("Entered End  Date is :" + ReadTestData(TCName, "EndDate"));

		WebElement Frequency = driver.findElement(By.xpath(getObj("Propval1", "Frequency", "JOL_INTLTransfer")));
		Frequency.sendKeys(Input.ReadTestData(TCName, "Frequency"));
		Log.pass("Entered frequency is :" + ReadTestData(TCName, "Frequency"));
	}

	public static boolean addAnotherTxn(int count, String fromAcc, String ToAcc, String Amount) throws Exception {

		for (int i = 1; i <= count; i++) {
			try {
				// Add another transaction
				Log.info("Started adding another transaction.Total transactions to be added are : " + count);
				Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "JOL_INTLTransfer")), "Add another transaction");
				Utils.enterOTPAndProceed();
				Utils.wait(3);
				Utils.enterOTPAndProceed();
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "FromAcctCombo", "JOL_Transfers_BetweenMyAccts")), fromAcc, "From Account Dropdown");
				Utils.pressKeyDown();
				Utils.pressKeyDown();
				Utils.pressEnter();

				Log.info("Successfully Entered To Account Number...");
				Utils.sendValDropdown(By.xpath(getObj("Propval1", "toAcctCombo", "JOL_Transfers_BetweenMyAccts")), ToAcc, "To Account Dropdown.");

				Utils.pressKeyDown();
				Utils.pressKeyDown();
				Utils.pressEnter();

				Log.info("Successful Entered From Account Number...");
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), Amount, "Amount");

				if (Integer.parseInt(ExecutionTime) == 1) {
					TransferModuleCommonFunctions.selectExecuteNow();
				} else if (Integer.parseInt(ExecutionTime) == 2) {
					TransferModuleCommonFunctions.selectScheduled();
				} else {
					TransferModuleCommonFunctions.selectStandingOrder();
				}

				Log.pass("Successfully added another transaction. Count No.= " + i);
			}

			catch (Exception e) {

				Log.fail("Unable to add another transaction number.." + count + "  error.." + ExceptionUtils.getStackTrace(e));
				runResult = false;
				throw e;
			}

		}
		return runResult;
	}

	public static boolean addAnotherBeneficiaryECorp() throws Exception {

		Log.info("Started adding another Beneficiary.Total Beneficiaries to be added are : " + Integer.parseInt(AddAnotherTxn));

		Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "Add_New_Beneficiary")), "Add another transaction");

		for (int i = 1; i <= Integer.parseInt(AddAnotherTxn); i++) {
			try {
				Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "Add_New_Beneficiary")), "Add another transaction");
				if (Integer.parseInt(BeneficiaryType) == 1)// WithinBAJ will be selected//
				{

					// Select Within Bank AlJazira//
					Utils.sendKeys_DD(By.xpath(getObj("Propval1", "BeneficiaryType", "Add_New_Beneficiary")), "Within Bank AlJazira");
					// Enter the Nickname//
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Nickname_AddNewBen", "Add_New_Beneficiary")), Nickname, "Nickname");
					// Enter a valid Account Number//
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "AccountNo_AddNewBen", "Add_New_Beneficiary")), AccountNumber, "AccountNumber");

				} else if (Integer.parseInt(BeneficiaryType) == 2)// Local Beneficiary will be selected.

				{
					// Select Local Beneficiary //
					Utils.sendKeys_DD(By.xpath(getObj("Propval1", "BeneficiaryType", "Add_New_Beneficiary")), "Local Beneficiary");

					Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryCategoryDropdown", "Add_New_Beneficiary")), By.xpath(getObj("Propval1", "BeneficiaryCategoryInput", "Add_New_Beneficiary")), BeneficiaryCategory,
							"Beneficiary Category dropdown.");
					// Enter FullName//
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Fullname_AddNewBen", "Add_New_Beneficiary")), Fullname, "Fullname");
					// Enter NickName//
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Nickname_AddNewBen", "Add_New_Beneficiary")), Nickname, "Nickname");
					// Enter IBAN Number//
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "IBAN_AddNewBen", "Add_New_Beneficiary")), IBANNumber, "IBAN Number");
					Utils.pressTab();

				}

				else if (Integer.parseInt(BeneficiaryType) == 3)// International Beneficiary will be selected
				{
					// Select International Beneficiary //
					Utils.sendKeys_DD(By.xpath(getObj("Propval1", "BeneficiaryType", "Add_New_Beneficiary")), "International Beneficiary");

					Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryCategoryDropdown", "Add_New_Beneficiary")), By.xpath(getObj("Propval1", "BeneficiaryCategoryInput", "Add_New_Beneficiary")), BeneficiaryCategory,
							"Beneficiary Category dropdown.");

					// Enter FullName//
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Fullname_AddNewBen", "Add_New_Beneficiary")), Fullname, "Fullname");
					// Enter NickName//
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Nickname_AddNewBen", "Add_New_Beneficiary")), Nickname, "Nickname");
					// Enter SwiftCode//
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "SwiftCode_AddNewBen", "Add_New_Beneficiary")), SwiftCode, "SwiftCode");
					Utils.pressTab();
					// Enter Bank Address//
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "BankAddress", "Add_New_Beneficiary")), BankAddress, "BankAddress");
					// Enter Bank City Branch//
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "BankCityBranch", "Add_New_Beneficiary")), BankCityBranch, "BankCityBranch");
					// Enter IBAN International//
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "IBAN_International", "Add_New_Beneficiary")), IBANNumber, "IBANNumber");

					Utils.pressTab();

				}

				Log.pass("Successfully added another beneficiary. Count = " + i);
				Utils.logPassImage("Add another beneficiary Result");

			}

			catch (Exception e) {

				Log.fail("Unable to add another beneficiary .." + i + "  error.." + ExceptionUtils.getStackTrace(e).trim());
				Utils.logFailImage("Add another beneficiary Result");
				runResult = false;
				throw e;
			}

		}
		Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "Add_New_Beneficiary")), "Add another transaction");
		return runResult;
	}

	public static boolean addAnotherBeneficiaryJOL() throws Exception {

		Log.info("Started adding another Beneficiary.Total Beneficiaries to be added are : " + Integer.parseInt(AddAnotherTxn));

		Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "Add_New_Beneficiary")), "Add another transaction");

		for (int i = 1; i <= Integer.parseInt(AddAnotherTxn); i++) {
			try {
				Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "Add_New_Beneficiary")), "Add another transaction");
				if (Integer.parseInt(BeneficiaryType) == 1)// WithinBAJ will be selected//
				{

					Log.pass("Beneficiary type to be selected is : Within BAJ ");
					// Select Within Bank AlJazira//
					Utils.sendKeys_DD(By.xpath(getObj("Propval1", "BeneficiaryType", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "BenTypeWithinBAJ"));
					// Enter the Nickname//
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Nickname_AddNewBen", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "Nickname_WithInBAJ"), "Nick Name");
					// Enter a valid Account Number//
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "AccountNo_AddNewBen", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "AccountNumber"), "AccountNumber");

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
					Utils.pressTab();

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
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "SwiftCode_AddNewBen", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "SwiftCode"), "SwiftCode");
					Utils.pressTab();
					// Click on Bank Address TextBox//
					Utils.click(By.xpath(getObj("Propval1", "Whitespace", "Add_New_Beneficiary")), "Blank Space");
					// Enter Bank Address//
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "BankAddress", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "BankAddress"), "BankAddress");
					// Enter Bank City Branch//
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "BankCityBranch", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "BankCityBranch"), "BankCityBranch");
					// Enter IBAN International//
					Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "IBAN_International", "Add_New_Beneficiary")), Input.ReadTestData(TCName, "IBANNumber_Intl"), "IBANNumber");
					Utils.pressTab();
					Utils.wait(3);
					// Enter Currency//
					if (Integer.parseInt(Currency) == 1) {
						Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Currency_International", "Add_New_Beneficiary")), "AED", "Currency ");
						Log.pass("Successfully selected currency : " + "AED");
					} else if (Integer.parseInt(Currency) == 2) {
						Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Currency_International", "Add_New_Beneficiary")), "USD", " Currency ");
						Log.pass("Successfully selected currency : " + "USD");
					}

					Utils.pressTab();

				}

				Log.pass("Successfully added another beneficiary. Count = " + i);
				Utils.logPassImage("Add another beneficiary Result");

			}

			catch (Exception e) {

				Log.fail("Unable to add another beneficiary .." + i + "  error.." + ExceptionUtils.getStackTrace(e).trim());
				Utils.logFailImage("Add another beneficiary Result");
				runResult = false;
				throw e;
			}

		}
		Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "Add_New_Beneficiary")), "Add another transaction");
		return runResult;
	}

	public static boolean deleteBeneficiaryJOL(int count) throws Exception {

		Log.info("Started deleting another beneficiary.Total beneficiary to be deleted are : " + count);

		for (int i = 1; i <= count; i++) {
			try {
				// deleting another transaction

				Utils.click(By.xpath(getObj("Propval1", "deleteAnotherAccIcon", "JOL_Transfers_BetweenMyAccts")), "Delete another transaction.");
				Utils.waitTillSaudiWaitIconDisappears();
				Utils.wait(2);

				Log.pass("Successfully deleted another beneficiary. Count= " + i);
			}

			catch (Exception e) {
				Log.fail("Unable to delete another beneficiary .." + i + "  error.." + ExceptionUtils.getStackTrace(e).trim());
				runResult = false;
				throw e;

			}

		}
		return runResult;
	}

	public static boolean addAnotherInternationalTxn(int count) throws Exception {

		Log.info("Started adding another transaction.Total transactions to be added are : " + count);

		for (int i = 1; i <= count; i++) {
			try {

				Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "JOL_INTLTransfer")), "Add another transaction");
				Utils.enterOTPAndProceed();
				Utils.wait(3);

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdown", "JOL_INTLTransfer")), By.xpath(getObj("Propval1", "AccountNumber", "LocalTransfers")), FromAcc);

				Log.pass("Selected Account Number is   is :" + FromAcc);

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryDropdownDropdown", "JOL_INTLTransfer")), By.xpath(getObj("Propval1", "Beneficiary", "JOL_INTLTransfer")), AppData.getBeneficiary_Intl());
				Log.pass("Selected Beneficiary Name  is :" + AppData.getBeneficiary_Intl());

				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), AppData.getAmount_International(), "Transfer Amount");

				if (!TxfrAmountType.equalsIgnoreCase("SAR")) {

					Utils.clickSafely(By.xpath(getObj("Propval1", "TxfrAmountType", "JOL_INTLTransfer")), "transfer amount type radio box.");
					// add selected radio box curr type code later.
				}

				// Execute Time
				if (Integer.parseInt(ExecutionTime) == 1) {

					TransferModuleCommonFunctions.selectExecuteNow();
				}

				else if (Integer.parseInt(ExecutionTime) == 2) {

					TransferModuleCommonFunctions.selectScheduled();

				} else {

					TransferModuleCommonFunctions.selectStandingOrder();

				}

				Utils.wait(1);
				Utils.click(By.xpath(getObj("Propval1", "CheckBox", "JOL_INTLTransfer")), "Condition Checked ");
				Utils.wait(2);
				Log.pass("Successfully added another transaction. Count= " + i);
				Utils.logPassImage("Add another transaction Result");

			}

			catch (Exception e) {

				Log.fail("Unable to add another transaction number.." + i + "  error.." + ExceptionUtils.getStackTrace(e).trim());
				Utils.logFailImage("Add another transaction Result");
				runResult = false;
				throw e;
			}

		}
		return runResult;
	}

	public static boolean addAnotherTxnWithinBaj(int count) throws Exception {

		Log.info("Started adding another transaction.Total transactions to be added are : " + count);

		for (int i = 1; i <= count; i++) {
			try {

				Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "JOL_INTLTransfer")), "Add another transaction");
				Utils.enterOTPAndProceed();
				Utils.wait(3);
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdownDropdown", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "AccountNumber", "WithinBaj_Transfers")), FromAcc, "From Account");

				if (!TxfrAmountType.equalsIgnoreCase("SAR")) {
					Utils.clickSafely(By.xpath(getObj("Propval1", "TxfrAmountType", "JOL_INTLTransfer")), "transfer amount type radio box.");
				}

				// Select Beneficiary
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryDropdownDropdown", "LocalTransfers")), By.xpath(getObj("Propval1", "Beneficiary", "LocalTransfers")), AppData.getBeneficiary_WithinBaj(), "Beneficiary");
				Log.pass("Entered Beneficiary name is :" + AppData.getBeneficiary_WithinBaj());
				// Enter Amount //
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "AmountTxt", "WithinBaj_Transfers")), AppData.getAmount_WithinBaj(), "Amount_WithinBaj");
				// Enter Category type
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "category", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "categoryInput", "WithinBaj_Transfers")), Input.ReadTestData(TCName, "Category"), "Category");
				// Enter Purpose
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "purposeDropdown", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "purposeInput", "WithinBaj_Transfers")), Input.ReadTestData(TCName, "Purpose"), "Purpose");
				// Enter Payment details
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "paymentDetails", "WithinBaj_Transfers")), Input.ReadTestData(TCName, "Payment Details"), "Payment Details");

				// Execute Time
				// Execute now
				if (Integer.parseInt(ExecutionTime) == 1) {
					TransferModuleCommonFunctions.selectExecuteNow();
				} else if (Integer.parseInt(ExecutionTime) == 2) {
					TransferModuleCommonFunctions.selectScheduled();
				} else {
					TransferModuleCommonFunctions.selectStandingOrder();
				}
				Utils.wait(1);
				// Click on Terms and Conditions CheckBox //
				Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "WithinBaj_Transfers")), "Click on Check Box");

				Utils.wait(2);
				Log.pass("Successfully added another transaction. Count= " + i);
				Utils.logPassImage("Add another transaction Result");

			}

			catch (Exception e) {

				Log.fail("Unable to add another transaction number.. " + i + "  error..");
				Utils.logFailImage("Add another transaction Result");
				runResult = false;
				throw e;
			}

		}
		return runResult;
	}

	public static boolean addAnotherTxnLocal(int count) throws Exception {

		Log.pass("Started adding another transaction.Total transactions to be added are : " + count);

		for (int i = 1; i <= count; i++) {
			try {

				Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "JOL_INTLTransfer")), "Add another transaction");
				Utils.enterOTPAndProceed();
				Utils.wait(3);
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdownDropdown", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "AccountNumber", "WithinBaj_Transfers")), FromAcc);

				// Select Beneficiary
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryDropdownDropdown", "LocalTransfers")), By.xpath(getObj("Propval1", "Beneficiary", "LocalTransfers")), AppData.getBeneficiary_Local());
				Log.pass("Enter Beneficiary name is :" + AppData.getBeneficiary_Local());
				// Enter Amount //
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "AmountTxt", "WithinBaj_Transfers")), AppData.getAmount_Local(), "Amount_WithinBaj");

				// Enter Category type
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "category", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "categoryInput", "WithinBaj_Transfers")), Input.ReadTestData(TCName, "Category"), "Category");
				// Enter Purpose
				Utils.wait(3);
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "purposeDropdown", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "purposeInput", "WithinBaj_Transfers")), Input.ReadTestData(TCName, "Purpose"), "Purpose");
				// Enter Payment details
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "paymentDetails", "WithinBaj_Transfers")), Input.ReadTestData(TCName, "PaymentDetails"), "Payment Details");

				// Execute Time
				if (Integer.parseInt(ExecutionTime) == 1) {
					TransferModuleCommonFunctions.selectExecuteNow();
				} else if (Integer.parseInt(ExecutionTime) == 2) {
					TransferModuleCommonFunctions.selectScheduled();
				} else {
					TransferModuleCommonFunctions.selectStandingOrder();
				}

				Utils.wait(1);
				// Click on Terms and Conditions CheckBox //
				Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "WithinBaj_Transfers")), "Click on Check Box");

				Utils.wait(2);
				Log.pass("Successfully added another transaction. Count No. = " + i);
				Utils.logPassImage("Add another transaction Result");

			}

			catch (Exception e) {

				Log.fail("Unable to add another transaction number.." + i + "  error.." + ExceptionUtils.getStackTrace(e).trim());
				Utils.logFailImage("Add another transaction Result");
				runResult = false;
				throw e;
			}

		}
		return runResult;
	}

	public static boolean deleteCharityTxn(int count) throws Exception {

		for (int i = 1; i <= count; i++) {
			try {
				// deleting another transaction
				Log.info("Started deleting another transactions.Total transactions to be deleted are : " + count);

				Utils.click(By.xpath(getObj("Propval1", "deleteAnotherAccIcon", "JOL_Transfers_BetweenMyAccts")), "Delete another transaction.");
				Utils.wait(4);
				Utils.waitTillSaudiWaitIconDisappears();
				Log.pass("Successfully deleted another transaction. Count= " + 1);
			} catch (Exception e) {
				Log.fail("Unable to delete another transaction number.." + 2 + "  error.. ");
				runResult = false;
				throw e;
			}

		}
		return runResult;
	}

	public static boolean addAnotherCharityTxn(int count, String fromAcc) throws Exception {

		for (int i = 1; i <= count; i++) {
			try {

				Log.info("Started adding another transaction.Total transactions to be added are : " + count);
				Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "JOL_INTLTransfer")), "Add another transaction");
				Utils.enterOTPAndProceed();
				Utils.wait(3);

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdownDropdown", "LocalTransfers")), By.xpath(getObj("Propval1", "AccountNumber", "LocalTransfers")), fromAcc, "From Account");

				Log.pass("Selected Account Number is : " + fromAcc);

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryDropdownDropdown", "LocalTransfers")), By.xpath(getObj("Propval1", "Beneficiary", "LocalTransfers")), ReadTestData(TCName, "Beneficiary"), "Beneficiary");
				Log.pass("Selected Beneficiary Name is :" + ReadTestData(TCName, "Beneficiary"));
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), ReadTestData(TCName, "DonationAmount"), "Donation Amount");
				// Enter Payment details
				Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "paymentDetails", "JOL_charity")), Input.ReadTestData(TCName, "PaymentDetails"), "Payment Details");

				if (ExecutionTime == null) {
					// Default execution time as NOW in case user does not give any value in JSON.
					ExecutionTime = "1";
				}

				// Execute Time
				if (Integer.parseInt(ExecutionTime) == 1) {

					TransferModuleCommonFunctions.selectExecuteNow();
				}

				else if (Integer.parseInt(ExecutionTime) == 2) {

					TransferModuleCommonFunctions.selectScheduled();

				} else {

					TransferModuleCommonFunctions.selectStandingOrder();

				}
				Log.pass("Successfully added another transaction. Count= " + i);
			}

			catch (Exception e) {

				Log.fail("Unable to add another transaction number.." + i + "  error.. ");
				runResult = false;
				throw e;
			}

		}
		return runResult;
	}

	public static boolean deleteAnotherTxn(int count) throws Exception {

		Log.info("Started deleting another transactions.Total transactions to be deleted are : " + count);

		for (int i = 1; i <= count; i++) {
			try {
				// deleting another transaction

				Utils.click(By.xpath(getObj("Propval1", "deleteAnotherAccIcon", "JOL_Transfers_BetweenMyAccts")), "Delete another transaction.");
				Utils.wait(4);
				Utils.waitTillSaudiWaitIconDisappears();
				Log.pass("Successfully deleted another transaction. Count= " + i);
			}

			catch (Exception e) {
				Log.fail("Unable to delete another transaction number.." + i + "  error.." + ExceptionUtils.getStackTrace(e).trim());
				runResult = false;
				throw e;

			}

		}
		return runResult;
	}

	public static boolean deleteBeneficiaryEcorp(int count) throws Exception {

		Log.info("Started deleting another beneficiary.Total beneficiary to be deleted are : " + count);

		for (int i = 1; i <= count; i++) {
			try {
				// deleting another transaction

				Utils.click(By.xpath(getObj("Propval1", "deleteAnotherAccIcon", "JOL_Transfers_BetweenMyAccts")), "Delete another transaction.");
				Utils.wait(8);

				Log.pass("Successfully deleted another beneficiary. Count= " + i);
			}

			catch (Exception e) {
				Log.fail("Unable to delete another beneficiary .." + i + "  error.." + ExceptionUtils.getStackTrace(e).trim());
				runResult = false;
				throw e;

			}

		}
		return runResult;
	}

	public static boolean sendEmailDownloadExcelnPrintFunc() throws Exception {

		try {

			// Download report in pdf format.
			Utils.clickSafely(By.xpath(getObj("Propval1", "pdfDownloadIcon", "AlZCapital")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.wait(3);
			Utils.moveToElement(By.id("logo"));
			Utils.wait(3);
			// Download report in excel format.
			Utils.clickSafely(By.xpath(getObj("Propval1", "excelDownloadIcon", "AlZCapital")), "Excel Download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.wait(3);
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.clickSafely(By.xpath(getObj("Propval1", "printBtnIcon", "AlZCapital")), "Print Button");
			// close all other tabs except the main one. i.e 1st page.
			Utils.closeOtherTabs();

			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "AlZCapital")), "Send Email Icon");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "sendEmailTo", "AlZCapital")), ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "sendEmailCC", "AlZCapital")), ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "bccEmail", "AlZCapital")), ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "emailSubject", "AlZCapital")), ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "sendEMailMsgBox", "AlZCapital")), ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");

			if (sendEmail == null) {

				sendEmail = "2";
			}

			// Send email if proceed=1 in DB
			if (Integer.parseInt(sendEmail) == 1) {
				Utils.clickSafely(By.xpath(getObj("Propval1", "sendBtnEle", "AlZCapital")), "Send Email Button");
			}
			// Hit cancel email if Proceed=2 in DB.
			else if (Integer.parseInt(sendEmail) == 2) {
				Utils.clickSafely(By.xpath(getObj("Propval1", "cancelemailBtnEle", "AlZCapital")), "Cancel Email Button");
				Log.pass("Successfully cancelled send email functionality as expected");
			}

			Utils.wait(2);
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "SaudiWaitLogo", "LogInLandingPage")));
			Utils.pressEscapeKey(3);

			Log.pass("Successfully completed other actions like send email, download pdf, excel and print search result etc.");
		}

		catch (Exception e) {
			Log.fail("Unable to complete other actions like send email, download pdf, excel and print search result etc error..");
			Utils.logFailImage(TCName + "  Scenario count -" + ScenarioCount + " - sendEmailDownloadExcelnPrintFunc-error");
			runResult = false;
			throw e;

		}

		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFunc(String Nickname) throws Exception {

		try {
			// to click on additional options
			Log.info("Started clicking on additional options");
			Utils.pressEscapeKey(3);
			Utils.wait(5);
			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "AddAsFavourite", "Additional_Options")), "Add As Favourite link");

			Utils.wait(5);
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "NickName_Txt", "Additional_Options")), Nickname, "Save as favourite nick name");
			Utils.click(By.xpath(getObj("Propval1", "AddAsFav_Save_Btn", "Additional_Options")), "Add As Favourite Save button");
			Log.pass("Successfully saved transaction as favourite.Waiting for page to load properly..");
			Utils.wait(8);

			// to click Export PDF link
			Utils.click(By.xpath(getObj("Propval1", "ExportPDF", "Additional_Options")), "Export PDF link");
			Log.pass("Export to pdf operation completed successfully");
			Utils.wait(3);
			// to click Print link
			Utils.click(By.xpath(getObj("Propval1", "Print", "Additional_Options")), "Print link");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.wait(3);
			// to click Send By Email link
			Utils.click(By.xpath(getObj("Propval1", "SendByEmail", "Additional_Options")), "Send By Email link");
			Utils.wait(3);
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "sendEmailTo", "AlZCapital")), ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "sendEmailCC", "AlZCapital")), ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "bccEmail", "AlZCapital")), ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "emailSubject", "AlZCapital")), ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "sendEMailMsgBox", "AlZCapital")), ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn", "Additional_Options")), "Send by Email Button");
			Utils.wait(10);
			Utils.waitTillSaudiWaitIconDisappears();
			Utils.pressEscapeKey(3);
			Log.pass("Send email function completed successfully");
			// add success assertion.

		}

		catch (Exception e) {
			Utils.waitTillSaudiWaitIconDisappears();
			Log.fail("addFavSendEmailDownloadPdfNprintFunc has failed..error " + Utils.getTextNoException(By.xpath(getObj("Propval1", "ErrorMsg_SendByEmail", "Additional_Options"))));
			Utils.pressEscapeKey(3);
			runResult = false;
			throw e;
		}

		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFuncAddBeneficiary(String Nickname) throws Exception {

		try {
			// to click on additional options
			Log.info("Started clicking on additional options");

			// to click Export PDF link
			Utils.click(By.xpath(getObj("Propval1", "ExportPDF", "Additional_Options")), "Export PDF link");
			Log.pass("Export to pdf operation completed successfully");
			Utils.wait(3);
			// to click Print link
			Utils.click(By.xpath(getObj("Propval1", "Print", "Additional_Options")), "Print link");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.wait(3);
			// to click Send By Email link
			Utils.click(By.xpath(getObj("Propval1", "SendByEmail", "Additional_Options")), "Send By Email link");
			Utils.wait(3);
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "sendEmailTo", "AlZCapital")), ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "sendEmailCC", "AlZCapital")), ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "bccEmail", "AlZCapital")), ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "emailSubject", "AlZCapital")), ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "sendEMailMsgBox", "AlZCapital")), ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");

			if (sendEmail == null) {
				sendEmail = "1"; // Setting send email = true in case user does not give any value in DB JSON.
			}
			// Send email if proceed=1 in DB
			if (Integer.parseInt(sendEmail) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn", "Additional_Options")), "Send  Email Button");
			}
			// Hit cancel email if Proceed=2 in DB.
			else if (Integer.parseInt(sendEmail) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "Additional_Options")), "Cancel Email Button");
			} else {

				Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn", "Additional_Options")), "Send  Email Button");
			}
			Utils.waitTillSaudiWaitIconDisappears();
			Utils.pressEscapeKey(3);
			Log.pass("Send email function completed successfully");

		}

		catch (Exception e) {

			Log.fail("addFavSendEmailDownloadPdfNprintFunc has failed..error ");
			Utils.pressEscapeKey(3);
			Utils.refreshScreeen();
			runResult = false;
			throw e;
		}

		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintCharity() throws Exception {

		try {
			// to click on additional options
			Log.info("Started clicking on additional options");
			Utils.clickSafely(By.xpath(getObj("Propval1", "AddAsFavourite", "Additional_Options")), "Add As Favourite link");

			Utils.wait(5);
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "NickName_Txt", "Additional_Options")), Input.ReadTestData(TCName, "Nick Name"), "Save as favourite nick name");
			Utils.clickSafely(By.xpath(getObj("Propval1", "AddAsFav_Save_Btn", "Additional_Options")), "Add As Favourite Save button");
			Log.pass("Successfully saved transaction as favourite.");
			Utils.wait(3);

			// to click Export PDF link
			Utils.clickSafely(By.xpath(getObj("Propval1", "ExportPDF", "Additional_Options")), "Export PDF link");
			Log.pass("Export to pdf operation completed successfully");
			Utils.wait(3);
			// to click Print link
			Utils.clickSafely(By.xpath(getObj("Propval1", "Print", "Additional_Options")), "Print link");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.wait(3);
			// to click Send By Email link
			Utils.clickSafely(By.xpath(getObj("Propval1", "SendByEmail", "Additional_Options")), "Send By Email link");
			Utils.wait(3);
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "sendEmailTo", "JOL_charity")), ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "sendEmailCC", "JOL_charity")), ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "bccEmail", "JOL_charity")), ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "emailSubject", "JOL_charity")), ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "sendEMailMsgBox", "JOL_charity")), ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "sendBtnEmail", "JOL_charity")), "Send by Email Button");
			Utils.pressEscapeKey(3);
			Log.pass("Send email function completed successfully");
			// add success assertion.

		}

		catch (Exception e) {

			Log.fail("addFavSendEmailDownloadPdfNprintFunc has failed..error " + Utils.getText(By.xpath(getObj("Propval1", "ErrorMsg_SendByEmail", "Additional_Options"))));
			Utils.pressEscapeKey(3);
			runResult = false;
			throw e;
		}

		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprint() throws Exception {

		try {

			Nickname = null;
			// to click on additional options
			Log.info("Started clicking on Transaction Details");
			Utils.click(By.xpath(getObj("Propval1", "AddAsFavourite", "Additional_Options")), "Add As Favourite link");

			char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			StringBuilder sb = new StringBuilder(5);
			Random random = new Random();

			for (int i = 0; i < 5; i++) {
				char c = chars[random.nextInt(chars.length)];
				sb.append(c);
			}

			Nickname = Input.ReadTestData(TCName, "NickName") + "_" + sb.toString();
			Utils.wait(5);
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "NickName_Txt", "Additional_Options")), Nickname, "Save as favourite nick name");
			Utils.clickSafely(By.xpath(getObj("Propval1", "AddAsFav_Save_Btn", "Additional_Options")), "Add As Favourite Save button");
			Utils.wait(3);

			// to click Export PDF link
			Utils.clickSafely(By.xpath(getObj("Propval1", "ExportPDF", "Additional_Options")), "Export PDF link");
			Utils.wait(3);
			// to click Print link
			Utils.clickSafely(By.xpath(getObj("Propval1", "Print", "Additional_Options")), "Print link");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.wait(3);
			// to click Send By Email link
			Utils.clickSafely(By.xpath(getObj("Propval1", "SendByEmail", "Additional_Options")), "Send By Email link");
			Utils.wait(3);
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "sendEmailTo", "AlZCapital")), ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "sendEmailCC", "AlZCapital")), ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "bccEmail", "AlZCapital")), ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "emailSubject", "AlZCapital")), ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "sendEMailMsgBox", "AlZCapital")), ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");

			if (sendEmail == null) {
				sendEmail = "1"; // Setting send email = true in case user does not give any value in DB JSON.
			}
			// Send email if proceed=1 in DB
			if (Integer.parseInt(sendEmail) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn", "Additional_Options")), "Send  Email Button");
			}
			// Hit cancel email if Proceed=2 in DB.
			else if (Integer.parseInt(sendEmail) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "Additional_Options")), "Cancel Email Button");
			} else {

				Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn", "Additional_Options")), "Send  Email Button");
			}
			Utils.wait(6);
			Utils.waitTillSaudiWaitIconDisappears();
			Utils.pressEscapeKey(3);
			Log.pass("Send email function completed successfully");
			// add success assertion when send email starts working.
			
		}

		catch (Exception e) {

			Log.warn("addFavSendEmailDownloadPdfNprintFunc has failed..error " + Utils.getTextNoException(By.xpath(getObj("Propval1", "ErrorMsg_SendByEmail", "Additional_Options"))));
			Utils.logWarnImage(TCName + " send email failure");
			runResult = false;
			throw e;
		}

		return runResult;
	}

	/***
	 * @description this method will compare the values like beneficiary name, from
	 *              account and amount etc after a transfer is successfully done.
	 * @param fromAccInput - From Acc entered in GUI by user
	 * @param              beneficiaryInput- Beneficiary name entered by user in
	 *                     application.
	 * @param              categoryInput- Categury input by user.
	 * @param              purposeInput- Purpose input by user in UI
	 * @param              paymentDetailsInput- Payment details input by user in
	 *                     screen.
	 * @param              ExecutionTimeInput- Execution time e.g execute now,
	 *                     schedule or others.
	 * @author baj80000892\Alok Rai
	 */
	public static void compareTransferDetails(String fromAccInput, String beneficiaryInput, String categoryInput, String purposeInput, String paymentDetailsInput, String ExecutionTimeInput) {

		try {

			String refNum = Utils.getText(By.xpath("//*[contains(text(),'Reference Number')]//following-sibling::span"));
			String fromAcc = Utils.getText(By.xpath("//*[contains(text(),'From Account')]//following-sibling::span"));
			String Beneficiary = Utils.getText(By.xpath("//*[contains(text(),'Beneficiary')]//following-sibling::span"));
			String name = Utils.getText(By.xpath("//*[contains(text(),'Name')]//following-sibling::span"));
			String category = Utils.getText(By.xpath("//*[contains(text(),'Category')]"));
			String purpose = Utils.getText(By.xpath("//*[contains(text(),'Purpose')]"));
			String paymentDetails = Utils.getText(By.xpath("//*[contains(text(),'Payment Details')]"));
			String ExecutionTime = Utils.getText(By.xpath("//*[contains(text(),'Execution Time')]"));

			Log.pass("Reference Number displayed on screen is : " + refNum);

			Assert.assertTrue(fromAcc.equalsIgnoreCase(fromAccInput));
			Assert.assertTrue(Beneficiary.equalsIgnoreCase(beneficiaryInput));

			Assert.assertTrue(category.equalsIgnoreCase(categoryInput));
			Assert.assertTrue(purpose.equalsIgnoreCase(purposeInput));

			Assert.assertTrue(paymentDetails.equalsIgnoreCase(paymentDetailsInput));
			Assert.assertTrue(ExecutionTime.equalsIgnoreCase(ExecutionTimeInput));
		}

		catch (AssertionError | Exception e) {

			Log.fail("compareTransferDetails has failed. Transfer pre and post details do not match..error..");
			throw e;
		}
	}

}
