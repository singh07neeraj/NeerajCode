package javaMain.common_Functions;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AccountNumber;
import static javaMain.common_Functions.AppData.AddAnotherTxn;
import static javaMain.common_Functions.AppData.BankAddress;
import static javaMain.common_Functions.AppData.BankCityBranch;
import static javaMain.common_Functions.AppData.BeneficiaryCategory;
import static javaMain.common_Functions.AppData.BeneficiaryType;
import static javaMain.common_Functions.AppData.Category;
import static javaMain.common_Functions.AppData.ExecutionTime;
import static javaMain.common_Functions.AppData.Frequency;
import static javaMain.common_Functions.AppData.FromAcc;
import static javaMain.common_Functions.AppData.Fullname;
import static javaMain.common_Functions.AppData.FutureDate;
import static javaMain.common_Functions.AppData.IBANNumber;
import static javaMain.common_Functions.AppData.NextDate;
import static javaMain.common_Functions.AppData.NickName;
import static javaMain.common_Functions.AppData.Nickname;
import static javaMain.common_Functions.AppData.PaymentDetails;
import static javaMain.common_Functions.AppData.Purpose;
import static javaMain.common_Functions.AppData.SwiftCode;
import static javaMain.common_Functions.AppData.ToAcc;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;

public class JolCommonFunctions extends TestBase {

	public static boolean addAnotherTxn(int count, String fromAcc, String ToAcc, String Amount) throws Exception {

		for (int i = 1; i <= count; i++) {
			try {
				// Add another transaction
				Log.info("Started adding another transaction.Total transactions to be added are : " + count);
				Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "JOL_INTLTransfer")), "Add another transaction");
				Utils.enterOTPAndProceed();
				Utils.wait(3);
				Utils.enterOTPAndProceed();
				Utils.sendKeys(By.xpath(getObj("Propval1", "FromAcctCombo", "JOL_Transfers_BetweenMyAccts")), fromAcc, "From Account Dropdown");
				Utils.pressKeyDown();
				Utils.pressKeyDown();
				Utils.pressEnter();

				Log.info("Successfully Entered To Account Number...");
				Utils.sendValDropdown(By.xpath(getObj("Propval1", "toAcctCombo", "JOL_Transfers_BetweenMyAccts")), ToAcc, "To Account Dropdown.");

				Utils.pressKeyDown();
				Utils.pressKeyDown();
				Utils.pressEnter();

				Log.info("Successful Entered From Account Number...");
				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), Amount, "Amount");
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
	
	public static boolean deleteBeneficiaryEcorp(int count) throws Exception {

		Log.info("Started deleting another beneficiary.Total beneficiary to be deleted are : " + count);

		for (int i = 1; i <= count; i++) {
			try {
				// deleting another transaction

				Utils.click(By.xpath(getObj("Propval1", "deleteAnotherAccIcon", "JOL_Transfers_BetweenMyAccts")), "Delete another transaction.");
				Utils.waitTillSaudiWaitIconDisappears();Utils.wait(4);

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
	public static boolean addAnotherBeneficiaryECorp()throws Exception {

		Log.info("Started adding another Beneficiary.Total Beneficiaries to be added are : " + Integer.parseInt(AddAnotherTxn) );
		
		Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "Add_New_Beneficiary")), "Add another transaction");
		
		for (int i = 1; i <= Integer.parseInt(AddAnotherTxn) ; i++) {
			try {
				Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "Add_New_Beneficiary")), "Add another transaction");
				if (Integer.parseInt(BeneficiaryType) == 1)// WithinBAJ will be selected//
				{

					// Select Within Bank AlJazira//
					Utils.sendKeys_DD(By.xpath(getObj("Propval1", "BeneficiaryType", "Add_New_Beneficiary")), "Within Bank AlJazira");
					// Enter the Nickname//
					Utils.sendKeys(By.xpath(getObj("Propval1", "Nickname_AddNewBen", "Add_New_Beneficiary")), Nickname, "Nickname");
					// Enter a valid Account Number//
					Utils.sendKeys(By.xpath(getObj("Propval1", "AccountNo_AddNewBen", "Add_New_Beneficiary")), AccountNumber, "AccountNumber");

				} else if (Integer.parseInt(BeneficiaryType) == 2)// Local Beneficiary will be selected.

				{
					// Select Local Beneficiary //
					Utils.sendKeys_DD(By.xpath(getObj("Propval1", "BeneficiaryType", "Add_New_Beneficiary")), "Local Beneficiary");

					Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryCategoryDropdown", "Add_New_Beneficiary")), By.xpath(getObj("Propval1", "BeneficiaryCategoryInput", "Add_New_Beneficiary")), BeneficiaryCategory,
							"Beneficiary Category dropdown.");
					// Enter FullName//
					Utils.sendKeys(By.xpath(getObj("Propval1", "Fullname_AddNewBen", "Add_New_Beneficiary")), Fullname, "Fullname");
					// Enter NickName//
					Utils.sendKeys(By.xpath(getObj("Propval1", "Nickname_AddNewBen", "Add_New_Beneficiary")), Nickname, "Nickname");
					// Enter IBAN Number//
					Utils.sendKeys(By.xpath(getObj("Propval1", "IBAN_AddNewBen", "Add_New_Beneficiary")), IBANNumber, "IBAN Number");
					Utils.pressTab();

				}

				else if (Integer.parseInt(BeneficiaryType) == 3)// International Beneficiary will be selected
				{
					// Select International Beneficiary //
					Utils.sendKeys_DD(By.xpath(getObj("Propval1", "BeneficiaryType", "Add_New_Beneficiary")), "International Beneficiary");

					Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryCategoryDropdown", "Add_New_Beneficiary")), By.xpath(getObj("Propval1", "BeneficiaryCategoryInput", "Add_New_Beneficiary")), BeneficiaryCategory,
							"Beneficiary Category dropdown.");

					// Enter FullName//
					Utils.sendKeys(By.xpath(getObj("Propval1", "Fullname_AddNewBen", "Add_New_Beneficiary")), Fullname, "Fullname");
					// Enter NickName//
					Utils.sendKeys(By.xpath(getObj("Propval1", "Nickname_AddNewBen", "Add_New_Beneficiary")), Nickname, "Nickname");
					// Enter SwiftCode//
					Utils.sendKeys(By.xpath(getObj("Propval1", "SwiftCode_AddNewBen", "Add_New_Beneficiary")), SwiftCode, "SwiftCode");
					Utils.pressTab();
					// Enter Bank Address//
					Utils.sendKeys(By.xpath(getObj("Propval1", "BankAddress", "Add_New_Beneficiary")), BankAddress, "BankAddress");
					// Enter Bank City Branch//
					Utils.sendKeys(By.xpath(getObj("Propval1", "BankCityBranch", "Add_New_Beneficiary")), BankCityBranch, "BankCityBranch");
					// Enter IBAN International//
					Utils.sendKeys(By.xpath(getObj("Propval1", "IBAN_International", "Add_New_Beneficiary")), IBANNumber, "IBANNumber");

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
	public static boolean addAnotherInternationalTxn(int count, String fromAcc, String TxfrAmountType, String EXEC, String NextDate, String FutureDate) throws Exception {

		Log.info("Started adding another transaction.Total transactions to be added are : " + count);

		for (int i = 1; i <= count; i++) {
			try {

				Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "JOL_INTLTransfer")), "Add another transaction");
				Utils.enterOTPAndProceed();
				Utils.wait(3);

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdown", "JOL_INTLTransfer")), By.xpath(getObj("Propval1", "AccountNumber", "LocalTransfers")), fromAcc);

				Log.pass("Selected Account Number is   is :" + fromAcc);

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryDropdownDropdown", "JOL_INTLTransfer")), By.xpath(getObj("Propval1", "Beneficiary", "JOL_INTLTransfer")), AppData.getBeneficiary_Intl());
				Log.pass("Selected Beneficiary Name  is :" + AppData.getBeneficiary_Intl());

				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), AppData.getAmount_International(), "Transfer Amount");

				if (!TxfrAmountType.equalsIgnoreCase("SAR")) {

					Utils.click(By.xpath(getObj("Propval1", "TxfrAmountType", "JOL_INTLTransfer")), "transfer amount type radio box.");
					// add selected radio box curr type code later.
				}

				// Execute now
				if (Integer.parseInt(EXEC) == 1) {
					Log.info("Execute now is already selected by default");
				}

				// Schedule transfer
				else if (Integer.parseInt(EXEC) == 2) {

					Utils.click(By.xpath(getObj("Propval1", "Schedule", "JOL_INTLTransfer")), "Clicked on Schedule ");
					Utils.sendKeys(By.xpath(getObj("Propval1", "nickName_ns", "JOL_INTLTransfer")), "Automation");

					WebElement Date = driver.findElement(By.xpath(getObj("Propval1", "TransferDate", "JOL_INTLTransfer")));
					Date.sendKeys(Utils.DateValue((Integer.parseInt(NextDate))));

				}
				// Standing Order
				else {

					Utils.click(By.xpath(getObj("Propval1", "stdorder", "JOL_INTLTransfer")), "Clicked on Standard Order");

					Utils.sendKeys(By.xpath(getObj("Propval1", "STDNickName", "JOL_INTLTransfer")), "Automation");

					WebElement StartDate = driver.findElement(By.xpath(getObj("Propval1", "StartDate", "JOL_INTLTransfer")));
					StartDate.sendKeys(Utils.DateValue((Integer.parseInt(NextDate))));

					WebElement endtDate = driver.findElement(By.xpath(getObj("Propval1", "endDate", "JOL_INTLTransfer")));
					endtDate.sendKeys(Utils.DateValue((Integer.parseInt(FutureDate))));

					WebElement Frequency = driver.findElement(By.xpath(getObj("Propval1", "Frequency", "JOL_INTLTransfer")));
					Frequency.sendKeys("Bimonthly");

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

	public static boolean addAnotherTxnWithinBaj(int count, String fromAcc, String TxfrAmountType, String EXEC, String NextDate, String FutureDate) throws Exception {

		Log.info("Started adding another transaction.Total transactions to be added are : " + count);

		for (int i = 1; i <= count; i++) {
			try {

				Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "JOL_INTLTransfer")), "Add another transaction");
				Utils.enterOTPAndProceed();
				Utils.wait(3);
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdownDropdown", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "AccountNumber", "WithinBaj_Transfers")), fromAcc);

				/*
				 * if (!TxfrAmountType.equalsIgnoreCase("SAR")) {
				 * 
				 * Utils.click(By.xpath(getObj("Propval1", "TxfrAmountType",
				 * "JOL_INTLTransfer")), "transfer amount type radio box."); // add selected
				 * radio box curr type code later. }
				 */
				// Select Beneficiary
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryDropdownDropdown", "LocalTransfers")), By.xpath(getObj("Propval1", "Beneficiary", "LocalTransfers")), AppData.getBeneficiary_WithinBaj());
				Log.pass("Enter Beneficiary name is :" + ReadTestData(AppData.getBeneficiary_WithinBaj(), "Beneficiary_WithinBaj"));
				// Enter Amount //
				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "WithinBaj_Transfers")), AppData.getAmount_WithinBaj(), "Amount_WithinBaj");

				// Enter Category type
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "category", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "categoryInput", "WithinBaj_Transfers")), Input.ReadTestData(TCName, "Category"), "Category");
				// Enter Purpose
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "purposeDropdown", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "purposeInput", "WithinBaj_Transfers")), Input.ReadTestData(TCName, "Purpose"), "Purpose");
				// Enter Payment details
				Utils.sendKeys(By.xpath(getObj("Propval1", "paymentDetails", "WithinBaj_Transfers")), Input.ReadTestData(TCName, "Payment Details"), "Payment Details");
				// Execute now
				if (Integer.parseInt(EXEC) == 1) {
					Log.info("Execute now is already selected by default");
				}

				// Schedule transfer
				else if (Integer.parseInt(EXEC) == 2) {
					// Click on Scheduled Radio Button//
					Utils.click(By.xpath(getObj("Propval1", "Scheduled", "WithinBaj_Transfers")), "Click on Scheduled ");
					// Enter the Nickname//
					Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_Schedule", "WithinBaj_Transfers")), "Automation");
					Log.pass("Enter Nick Name : Automation");
					// Enter Date//

					WebElement Date = driver.findElement(By.xpath(getObj("Propval1", "ScheduleDate", "WithinBaj_Transfers")));
					Date.sendKeys(Utils.DateValue((Integer.parseInt(NextDate))));

				}
				// Standing Order
				else {
					// Click on Standing Order Radio Button//
					Utils.click(By.xpath(getObj("Propval1", "StandingOrder", "WithinBaj_Transfers")), "Click on Standarding Order");
					Utils.pressEnter();

					// Enter the Nickname//
					Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_StandingOrder", "WithinBaj_Transfers")), "Automation");

					// Enter Start Date//
					WebElement StartDate = driver.findElement(By.xpath(getObj("Propval1", "StartDate", "WithinBaj_Transfers")));
					StartDate.sendKeys(Utils.DateValue((Integer.parseInt(NextDate))));

					// Enter End Date//
					WebElement endtDate = driver.findElement(By.xpath(getObj("Propval1", "EndDate", "WithinBaj_Transfers")));
					endtDate.sendKeys(Utils.DateValue((Integer.parseInt(FutureDate))));

					// Select Frequency//
					WebElement Frequency = driver.findElement(By.xpath(getObj("Propval1", "Frequency", "WithinBaj_Transfers")));
					Frequency.sendKeys(Input.ReadTestData(TCName, "Frequency"));

				}
				Utils.wait(1);
				// Click on Terms and Conditions CheckBox //
				Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "WithinBaj_Transfers")), "Click on Check Box");

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
	public static boolean addAnotherTxnLocal(int count, String fromAcc, String TxfrAmountType, String EXEC, String NextDate, String FutureDate) throws Exception {

		Log.pass("Started adding another transaction.Total transactions to be added are : " + count);

		for (int i = 1; i <= count; i++) {
			try {

				Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "JOL_INTLTransfer")), "Add another transaction");
				Utils.enterOTPAndProceed();
				Utils.wait(3);
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdownDropdown", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "AccountNumber", "WithinBaj_Transfers")), fromAcc);

				// Select Beneficiary
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryDropdownDropdown", "LocalTransfers")), By.xpath(getObj("Propval1", "Beneficiary", "LocalTransfers")), AppData.getBeneficiary_Local(), "Beneficiary");
				Log.pass("Entered Beneficiary name is :" + AppData.getBeneficiary_Local());
				// Enter Amount //
				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "WithinBaj_Transfers")), AppData.getAmount_Local(), "Amount_Local ");
				// Enter Category type
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "category", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "categoryInput", "WithinBaj_Transfers")), Category, "Category");
				// Enter Purpose
				Utils.wait(4);
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "purposeDropdown", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "purposeInput", "WithinBaj_Transfers")), Purpose, "Purpose");
				// Enter Payment details
				Utils.sendKeys(By.xpath(getObj("Propval1", "paymentDetails", "WithinBaj_Transfers")), PaymentDetails, "Payment Details");
				
				// Execute now
				if (Integer.parseInt(EXEC) == 1) {
					Log.info("Execute now is already selected by default. Keepint it as selected as per requirement.");
				}

				// Schedule transfer
				else if (Integer.parseInt(EXEC) == 2) {
					// Click on Scheduled Radio Button//
					Utils.click(By.xpath(getObj("Propval1", "Scheduled", "WithinBaj_Transfers")), "Click on Scheduled ");
					// Enter the Nickname//
					Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_Schedule", "WithinBaj_Transfers")), NickName);
					Log.pass("Entered Nick Name :  "+NickName);
					// Enter Date//

					WebElement Date = driver.findElement(By.xpath(getObj("Propval1", "ScheduleDate", "WithinBaj_Transfers")));
					Date.sendKeys(NextDate);

				}
				// Standing Order
				else {
					
					// Click on Standing Order Radio Button//
					Utils.click(By.xpath(getObj("Propval1", "StandingOrder", "WithinBaj_Transfers")), " Standarding Order");
					Utils.pressEnter();

					// Enter the Nickname//
					Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_StandingOrder", "WithinBaj_Transfers")), NickName);

					// Enter Start Date//
					WebElement StartDate = driver.findElement(By.xpath(getObj("Propval1", "StartDate", "WithinBaj_Transfers")));
					StartDate.sendKeys(NextDate);

					// Enter End Date//
					WebElement endtDate = driver.findElement(By.xpath(getObj("Propval1", "EndDate", "WithinBaj_Transfers")));
					endtDate.sendKeys(FutureDate);

					// Select Frequency//
					WebElement Freq = driver.findElement(By.xpath(getObj("Propval1", "Frequency", "WithinBaj_Transfers")));
					Freq.sendKeys(Frequency);


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
	public static boolean addAnotherTxnBetweenOwnAcc(int count, String Amount) throws Exception {

		Log.pass("Started adding another transaction.Total transactions to be added are : " + count);

		for (int i = 1; i <= count; i++) {
			try {

				Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "JOL_INTLTransfer")), "Add another transaction");
				Utils.enterOTPAndProceed();
				Utils.wait(3);
				// Select from Account Number//
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdownDropdown", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "AccountNumber", "WithinBaj_Transfers")), FromAcc, "From account");
				Utils.sendValDropdown(By.xpath(getObj("Propval1", "toAcctCombo", "JOL_Transfers_BetweenMyAccts")), ToAcc, " To Account Dropdown.");
				// Enter Amount //
				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "WithinBaj_Transfers")), Amount, "Amount ");

				// Execute now
				if (Integer.parseInt(ExecutionTime) == 1) {
					// Click on Exec Now Radio Button//
					Utils.click(By.xpath(getObj("Propval1", "ExecNow", "WithinBaj_Transfers")), "Click on Execute Now");
					Log.pass("Execute now is already selected by default. Keepint it as selected as per requirement.");
				}

				else if (Integer.parseInt(ExecutionTime) == 2) {

					// Click on Scheduled Radio Button//
					Utils.click(By.xpath(getObj("Propval1", "Scheduled", "WithinBaj_Transfers")), "Click on Scheduled ");
					// Enter the Nickname//
					Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_Schedule", "WithinBaj_Transfers")), NickName," Nick Name");
					Log.pass("Entered Nick Name :  " + NickName);
					// Enter Date//

					WebElement Date = driver.findElement(By.xpath(getObj("Propval1", "ScheduleDate", "WithinBaj_Transfers")));
					Date.sendKeys(NextDate);

				}

				else if (Integer.parseInt(ExecutionTime) == 3) {

					// Click on Standing Order Radio Button//
					Utils.click(By.xpath(getObj("Propval1", "StandingOrder", "WithinBaj_Transfers")), " Standarding Order");
					Utils.pressEnter();

					// Enter the Nickname//
					Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_StandingOrder", "WithinBaj_Transfers")), NickName);

					// Enter Start Date//
					WebElement StartDate = driver.findElement(By.xpath(getObj("Propval1", "StartDate", "WithinBaj_Transfers")));
					StartDate.sendKeys(NextDate);

					// Enter End Date//
					WebElement endtDate = driver.findElement(By.xpath(getObj("Propval1", "EndDate", "WithinBaj_Transfers")));
					endtDate.sendKeys(FutureDate);

					// Select Frequency//
					WebElement Freq = driver.findElement(By.xpath(getObj("Propval1", "Frequency", "JOL_Transfers_BetweenMyAccts")));
					Freq.sendKeys(Frequency);

				}

				Utils.wait(1);
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
				Utils.wait(8);

				Log.pass("Successfully deleted another transaction. Count= " + i);
			}

			catch (Exception e) {
				Log.fail("Unable to delete another transaction number.." + count + "  error.." + ExceptionUtils.getStackTrace(e));
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

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdownDropdown", "LocalTransfers")), By.xpath(getObj("Propval1", "AccountNumber", "LocalTransfers")), fromAcc);

				Log.pass("Selected Account Number is   is :" + ReadTestData("LocalTransfer", "AccountNumber"));

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryDropdownDropdown", "LocalTransfers")), By.xpath(getObj("Propval1", "Beneficiary", "LocalTransfers")), ReadTestData(TCName, "Beneficiary"));
				Log.pass("Selected Beneficiary Name is :" + ReadTestData(TCName, "Beneficiary"));
				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), ReadTestData(TCName, "Donation Amount"));
				// Enter Payment details
				Utils.sendKeys(By.xpath(getObj("Propval1", "paymentDetails", "JOL_charity")), Input.ReadTestData(TCName, "Payment Details"), "Payment Details");
				Log.pass("Successfully added another transaction. Count= " + i);
			}

			catch (Exception e) {

				Log.fail("Unable to add another transaction number.." + count + "  error.." + ExceptionUtils.getStackTrace(e));
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

				Utils.click(By.xpath(getObj("Propval1", "deleteAnotherAccIcon", "JOL_Transfers_BetweenMyAccts")), "Delete another transaction.");			Utils.waitTillSaudiWaitIconDisappears();
				Utils.wait(4);

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

	public static boolean sendEmailDownloadExcelnPrintFunc(int ScenarioCount, String... proceedEmail) throws Exception {

		String sendEmail = "1";
		try {
			sendEmail = proceedEmail[0];
		} catch (Exception e) {
			sendEmail = "1";
		}

		try {

			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "AlZCapital")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.wait(3);
			Utils.moveToElement(By.id("logo"));
			Utils.wait(3);
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "AlZCapital")), "Excel Download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.wait(3);
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "AlZCapital")), "Print Button");
			// close all other tabs except the main one. i.e 1st page.
			Utils.closeOtherTabs();

			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "AlZCapital")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "AlZCapital")), ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "AlZCapital")), ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "AlZCapital")), ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "AlZCapital")), ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "AlZCapital")), ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");

			//*[contains(@class,'dijit dijitReset dijitInline buttonRed dijitButton')]
			
			// Send email if proceed=1 in DB
			if (Integer.parseInt(sendEmail) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "AlZCapital")), "Send Email Button");
			}
			// Hit cancel email if Proceed=2 in DB.
			else if (Integer.parseInt(sendEmail) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "AlZCapital")), "Cancel Email Button");
			} 
			
			Utils.wait(7);
			Utils.waitTillSaudiWaitIconDisappears();
			Utils.pressEscapeKey(5);
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
			Utils.click(By.xpath(getObj("Propval1", "AddAsFavourite", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Add As Favourite link");

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
			Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_Txt", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), Nickname, "Save as favourite nick name");
			Utils.click(By.xpath(getObj("Propval1", "AddAsFav_Save_Btn", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Add As Favourite Save button");
			Utils.wait(3);

			// to click Export PDF link
			Utils.click(By.xpath(getObj("Propval1", "ExportPDF", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Export PDF link");
			Utils.wait(3);
			// to click Print link
			Utils.click(By.xpath(getObj("Propval1", "Print", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Print link");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.wait(3);
			// to click Send By Email link
			Utils.click(By.xpath(getObj("Propval1", "SendByEmail", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Send By Email link");
			Utils.wait(3);
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Send by Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			Utils.pressEnter();
			Utils.wait(3);
			Utils.pressEscapeKey(3);
			// driver.findElement(By.id("lelo")).click();
			// add success assertion
		}

		catch (Exception e) {

			Log.fail("addFavSendEmailDownloadPdfNprintFunc has failed..error " + Utils.getText(By.xpath(getObj("Propval1", "ErrorMsg_SendByEmail", "Additional_Options"))));
			runResult = false;
			throw e;
		}

		return runResult;
	}
	public static boolean SendEmailDownloadPdfNprintFunc(String...  Nickname) throws Exception {

		try {
			// to click on additional options
			Log.info("Started clicking on additional options");
			Utils.pressEscapeKey(3);

			// to click Export PDF link
			Utils.click(By.xpath(getObj("Propval1", "ExportPDF", "Additional_Options")), "Export PDF link");
			Log.pass("Export to pdf operation completed successfully");
			Utils.wait(3);
			Utils.logPassImage("pdf Export");
			// to click Print link
			Utils.click(By.xpath(getObj("Propval1", "Print", "Additional_Options")), "Print link");
			Utils.wait(3);
			Utils.logPassImage("Print report");
			Utils.closeOtherTabs();
			Utils.wait(3);
			// to click Send By Email link
			Utils.click(By.xpath(getObj("Propval1", "SendByEmail", "Additional_Options")), "Send By Email link");
			Utils.wait(3);
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "AlZCapital")), ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "AlZCapital")), ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "AlZCapital")), ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "AlZCapital")), ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "AlZCapital")), ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");
			Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn", "Additional_Options")), "Send by Email Button");
			Utils.waitTillSaudiWaitIconDisappears();
			Utils.pressEscapeKey(3);
			Log.pass("Send email function completed successfully");
			// add success assertion.

		}

		catch (Exception e) {

			Log.fail("addFavSendEmailDownloadPdfNprintFunc has failed..error " );
			Utils.logFailImage("Send Email error");
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
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "AlZCapital")), ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "AlZCapital")), ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "AlZCapital")), ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "AlZCapital")), ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "AlZCapital")), ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "Additional_Options")), "Send by Email Button");
			Utils.waitTillSaudiWaitIconDisappears();Utils.pressEscapeKey(3);
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

	public static boolean SendEmailDownloadPdfNprintCharity() throws Exception {

		try {
			// to click on additional options
			Log.info("Started clicking on additional options");
			Utils.wait(3);

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
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "JOL_charity")), ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "JOL_charity")), ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "JOL_charity")), ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "JOL_charity")), ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "JOL_charity")), ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "sendBtnEmail", "JOL_charity")), "Send by Email Button");
			Utils.waitTillSaudiWaitIconDisappears();
			Utils.wait(2);
			Utils.pressEscapeKey(3);
			Log.pass("Send email function completed successfully");
			// add success assertion.

		}
		catch (Exception e) {

			Log.fail("SendEmailDownloadPdfNprintFunc has failed..error ");
			Utils.pressEscapeKey(3);
			runResult = false;
			throw e;
			
		}

		return runResult;
	}
	
	
	public static void addAsFav(String nickname) throws Exception {
		
		// to click on additional options
		Log.info("Started saving transaction as a favourite.");
		Utils.click(By.xpath(getObj("Propval1", "AddAsFavourite", "Additional_Options")), "Add As Favourite link");

		String details = null;
		if (Integer.parseInt(details) == 1) {

		}
		// Nickname="TestAutomation";

		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder(10);
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		System.out.println(output);
		Nickname = Nickname + "_" + output;
		Utils.wait(5);
		Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_Txt", "Additional_Options")), Nickname, "Save as favourite nick name");
		Utils.click(By.xpath(getObj("Propval1", "AddAsFav_Save_Btn", "Additional_Options")), "Add As Favourite Save button");			Utils.waitTillSaudiWaitIconDisappears();
		Utils.wait(3);
		
	}

	public static boolean Account_TarnsDetailsPdfNPrint(String Nickname) throws Exception {

		try {
			// to click on additional options
			Log.info("Started clicking on Transaction Details");
			Utils.click(By.xpath(getObj("Propval1", "AddAsFavourite", "Additional_Options")), "Add As Favourite link");

			String details = null;
			if (Integer.parseInt(details) == 1) {

			}
			// Nickname="TestAutomation";

			char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			StringBuilder sb = new StringBuilder(10);
			Random random = new Random();
			for (int i = 0; i < 10; i++) {
				char c = chars[random.nextInt(chars.length)];
				sb.append(c);
			}
			String output = sb.toString();
			System.out.println(output);
			Nickname = Nickname + "_" + output;
			Utils.wait(5);
			Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_Txt", "Additional_Options")), Nickname, "Save as favourite nick name");
			Utils.click(By.xpath(getObj("Propval1", "AddAsFav_Save_Btn", "Additional_Options")), "Add As Favourite Save button");
			Utils.wait(3);

			// to click Export PDF link
			Utils.click(By.xpath(getObj("Propval1", "ExportPDF", "Additional_Options")), "Export PDF link");
			Utils.wait(3);
			// to click Print link
			Utils.click(By.xpath(getObj("Propval1", "Print", "Additional_Options")), "Print link");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.wait(3);
			// to click Send By Email link
			Utils.click(By.xpath(getObj("Propval1", "SendByEmail", "Additional_Options")), "Send By Email link");
			Utils.wait(3);
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "AlZCapital")), ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "AlZCapital")), ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "AlZCapital")), ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "AlZCapital")), ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "AlZCapital")), ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn", "Additional_Options")), "Send by Email Button");			Utils.waitTillSaudiWaitIconDisappears();

			// driver.findElement(By.id("lelo")).click();
			// add success assertion
		}

		catch (Exception e) {

			Log.fail("addFavSendEmailDownloadPdfNprintFunc has failed..error " + Utils.getText(By.xpath(getObj("Propval1", "ErrorMsg_SendByEmail", "Additional_Options"))));

			Log.fail("Unable to click on additional options" + ExceptionUtils.getStackTrace(e));
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
