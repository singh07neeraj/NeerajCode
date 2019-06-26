package javaMain.common_Functions;

import static Utilities.Input.ReadTestData;

import Utilities.GUI_Page1;
import Utilities.TestBase;

/***
 * @description this class contains all the global variables like environment
 *              details, account sets, user login details and JSON keys etc.
 * @author baj80000892
 *
 */
public class AppData extends TestBase {

	public static boolean runResult = true;

	// JSON keys. Use below place to enter new Keys if needed.
	public static String Proceed, TestType, PortfolioType, PortfolioNum, Type, EXEC, AddAnotherTxn, DeleteAnotherTxn, Account, FromAcc = null, TransferType, BenificiaryCategory, validateTxfrFunds, Initiator, ToAcc = null, BeneficiaryType, NewTxn,
			email, InvalidEmail, modifyEmail, BeneficiaryActivationMode, SMARTEnabled, ATMEnabled, IVREnabled, Procced, Confirm, isTermsNconditionsChecked1, OTPCancelConfirm, CancelYes, Currency, BeneficiaryActivationModeModified, AddNewBeneficiary,
			deleteBeneficiary, cancelEdit, Modify, Result, CancelConfirm, sendEmail, ProceedEmail, ExcelPdfPrintActions = null, executeFlag, confirmFlag, proceedFlag, AuthConfirm, StartDate, endDate, ExecutionTime, isTermsNconditionsChecked,
			ZeroBalAcc, NextDate, FutureDate, TxfrAmountType, NegativeAmount, AmountLessThan100USD, AdditionalActions, ViewDetails, editBeneficiary, validateAddBeneficiaryPage, saveAsFav, tagName, remarks, showDetails, deleteDetails,
			skipNextTransfer, edit, confirmSkip, Frequency, BeneficiaryCategory, Fullname, Nickname, AccountNumber, IBANNumber, SwiftCode, Nickname_Modified, AddAnotherTransaction, BankAddress, BankCityBranch, Category, Purpose, ProceedType,
			ConfirmType, PaymentDetails, NickName, Amount, Home, Approve, Reject, Cancel, OldPassword, NewPassword, ConfirmNewPassword, RejectCancel, AMOUNT, Status, CurrencyFrom, CurrencyTo, Transaction, Record, txnViewBtn, MOLID, details,
			termConditions, TransferVia, selectTnCfrompopup, AdditionalOptions, OrderStatus, nextstep, FromAccount, Range, checkNo, EndDate, RequestType, TicketId, other, POSID, City, checkNo2, Reason, OTPProceed, FullName,
			AfterTxfrAdditionalOptions, ComputerNumber, DateFrom, DateTo, MerchantReferenceNumber, Scheme, TransactionID, TransactionType, BankReferenceNumber, Service, AccountInfoUpdate, OrdersType, SymbolType, Nationality, IDType, CivilianId,
			GroupDivision, DirectReportId, phoneAndExt, DirectReportName, Mobile, dateFrom, dateTo, BuySellMenu, Menu, TCButton, CheckBox, AdvanceSearch, DebitCard, C_ACCT, limit, Limit, BuySell, Company, Subscribe, Seq,
			validateSubsAndRedemptionHistoryLink, verifySubscribeBtn, SearchType, otherActions, isNegative, SendSMS, SendEMail, Branch, Provider, NickNameCancelSave, AccountCofig;

	// .................. Do not alter below code without
	// discussing...........................Wrong change impact=Severe. Only Abo or
	// Alok should change below code. //

	public static String CurrentChannel;
	public static String CurrentEnvironment;
	public static String CurrentBrowser;
	public static String CurrentLanguage;
	public static String CurrentEmails;

	public static int TestDataSet;
	public static String Username;
	public static String Password;
	public static String Otp;

	public static String Email;
	public static String runLanguage;
	public static String Channel;

	public static String FromAccountSAR;
	public static String FromAccountForeign;
	public static String ToAccountSAR;
	public static String ToAccountForeign;
	public static String Beneficiary_Local;
	public static String Beneficiary_Intl;
	public static String Beneficiary_WithinBaj;
	public static String TransferFrequency_OwnAcc;
	public static String Amount_Local;
	public static String Amount_OwnAcc;
	public static String Amount_International;
	public static String Amount_Negative;
	public static String Amount_WithinBaj;
	public static String Amount_WithinBajModify;
	public static String Amount_ModifyOwnAcc;
	public static String Amount_ModifyIntl, Amount_ModifyLocal;

	public static String testDataSheetName;
	public static String testDataFilePath;
	public static String objXmlPath;
	public static String accountSet;

	public static String TStableName;
	public static String masterTableName;

	static {

		// GUI getters and setters need to update the below variable values as entered.

		accountSet = "AccountSet1"; // Should be passed from GUI if user wants to use different set of Account Sets.

		CurrentEnvironment = GUI_Page1.getjComboBoxEnvironment();
		CurrentBrowser = GUI_Page1.getjComboBoxBrowser();
		Email = GUI_Page1.getTextFieldEmails();
		runLanguage = GUI_Page1.getjComboBoxLanguage();
		Channel = GUI_Page1.getjComboBoxChannel();

		if (CurrentBrowser == null) {
			CurrentBrowser = "chrome"; // IE //firefox // Manual set up in case user runs TC without using GUI. i.e uses
								// testNG.xml or individual classes..
		}
		
		if (Channel == null) {
			Channel = "JOL"; // JOL //eCorp // Manual set up in case user runs TC without using GUI. i.e uses
								// testNG.xml or individual classes..
		}
		if (runLanguage == null) {
			runLanguage = "Arabic"; // EN // Arabic //Manual set up in case user runs TC without using GUI. i.e uses
									// testNG.xml or individual classes..
		}

		setMasternChildTSTables(Channel); // will set up the test run type i.e channel JOL/E corp smart etc.

		if (runLanguage.equalsIgnoreCase("Arabic")) {
			TestDataSet = 2;
			logger.info("Arabic Data set will be used for test case exceution as language selected from GUI is 'Arabic'");
		} else {
			TestDataSet = 1;
			logger.info("English Data set will be used for test case exceution as language selected from GUI is 'English'");
		}
		Username = ReadTestData("GlobalVariables", "Login_UserName");
		Password = ReadTestData("GlobalVariables", "Login_Password");
		Otp = ReadTestData("GlobalVariables", "Application OTP");

		// Default values from test data sheet as per account set provided in variable
		// accountSet.
		FromAccountSAR = ReadTestData(accountSet, "FromAccountSAR");
		FromAccountForeign = ReadTestData(accountSet, "FromAccountForeign");
		ToAccountSAR = ReadTestData(accountSet, "ToAccountSAR");
		ToAccountForeign = ReadTestData(accountSet, "ToAccountForeign");
		Beneficiary_Local = ReadTestData(accountSet, "Beneficiary_Local");
		Beneficiary_Intl = ReadTestData(accountSet, "Beneficiary_Intl");
		Beneficiary_WithinBaj = ReadTestData(accountSet, "Beneficiary_WithinBaj");
		TransferFrequency_OwnAcc = ReadTestData(accountSet, "TransferFrequency_OwnAcc");
		Amount_Local = ReadTestData(accountSet, "Amount_Local");
		Amount_OwnAcc = ReadTestData(accountSet, "Amount_OwnAcc");
		Amount_International = ReadTestData(accountSet, "Amount_International");
		Amount_Negative = ReadTestData(accountSet, "Amount_Negative");
		Amount_WithinBaj = ReadTestData(accountSet, "Amount_WithinBaj");
		Amount_WithinBajModify = ReadTestData(accountSet, "Amount_WithinBajModify");
		Amount_ModifyOwnAcc = ReadTestData(accountSet, "Amount_ModifyOwnAcc");
		Amount_ModifyIntl = ReadTestData(accountSet, "Amount_ModifyIntl");
		Amount_ModifyLocal = ReadTestData(accountSet, "Amount_ModifyLocal");

	}

	// Logic to set up Test scenario table name using which test data and JSON data
	// will be read from DB/excel and supplied to tets cases.

	public static void setMasternChildTSTables(String strChannel) {

		if (strChannel.equalsIgnoreCase("JOL") || strChannel.equalsIgnoreCase("AlJazira Online")) {

			masterTableName = "JOL_MasterTable";
			TStableName = "JOL_Test_Scenarios";
			testDataSheetName = "JOL_TestData";
			testDataFilePath = System.getProperty("user.dir") + "\\bajSrcFiles\\resources\\TestData\\TestData_All.xlsx";
			objXmlPath = System.getProperty("user.dir") + "\\bajSrcFiles\\resources\\pageObjects\\pageObjJOL\\objJOL.xml";

		}
		else	if (strChannel.equalsIgnoreCase("eCorp") || strChannel.equalsIgnoreCase("AlJazira Corporate")) {

			masterTableName = "eCorp_MasterTable";
			TStableName = "eCorp_Test_Scenarios";
			testDataSheetName = "eCorp_TestData";
			testDataFilePath = System.getProperty("user.dir") + "\\bajSrcFiles\\resources\\TestData\\TestData_All.xlsx";
			objXmlPath = System.getProperty("user.dir") + "\\bajSrcFiles\\resources\\pageObjects\\pageObjECorp\\objEcorp.xml";

		}
		else if (strChannel.equalsIgnoreCase("Smart") || strChannel.equalsIgnoreCase("AlJazira Smart")) {

			masterTableName = "Smart_MasterTable";
			TStableName = "Smart_Test_Scenarios";
			testDataSheetName = "smart_TestData";
			testDataFilePath = System.getProperty("user.dir") + "\\bajSrcFiles\\resources\\TestData\\TestData_All.xlsx";
			objXmlPath = System.getProperty("user.dir") + "\\bajSrcFiles\\resources\\pageObjects\\pageObjSmart\\objSmart.xml";

		}

		logger.info("Selected browser name is : " + CurrentBrowser);
		logger.info("Selected channel name is : " + runLanguage);
		logger.info("Selected data set is : " + TestDataSet);
		logger.info("Selected language name is : " + strChannel);
		logger.info("Selected master table name is : " + masterTableName);
		logger.info("Selected Test Scenario table name is : " + TStableName);
		logger.info("Selected Test Data sheet  name is : " + testDataSheetName);
		logger.info("Selected Test Data file path is : " + testDataFilePath);
		logger.info("Selected Object xml file path is : " + objXmlPath);
	}

	public static String getMasterTableName() {
		return masterTableName;
	}

	public static String getTStableName() {
		return TStableName;
	}

	public static int getTestDataSet() {
		return TestDataSet;
	}

	public static void setTestDataSet(int testDataSet) {
		TestDataSet = testDataSet;
	}

	public static String getEmail() {
		return Email;
	}

	public static void setEmail(String email) {
		Email = email;
	}

	public static String getLanguage() {
		return runLanguage;
	}

	public static void setLanguage(String language) {
		runLanguage = language;
	}

	public static String getChannel() {
		return Channel;
	}

	public static void setChannel(String channel) {
		Channel = channel;
	}

	// Method to test code whether variables are getting value properly or not.
	public static void main(String[] args) {

	}

	// Getters and Setters for above puublic variables.

	public static String getUsername() {
		return Username;
	}

	public static void setUsername(String username) {
		Username = username;
	}

	public static String getPassword() {
		return Password;
	}

	public static void setPassword(String password) {
		Password = password;
	}

	public static String getOtp() {
		return Otp;
	}

	public static void setOtp(String otp) {
		Otp = otp;
	}

	// ........................ Accounts
	public static String getFromAccountSAR() {

		return FromAccountSAR;
	}

	public static void setFromAccountSAR(String fromAccountSAR) {

		FromAccountSAR = fromAccountSAR;
	}

	public static String getFromAccountForeign() {
		return FromAccountForeign;
	}

	public static void setFromAccountForeign(String fromAccountForeign) {
		FromAccountForeign = fromAccountForeign;
	}

	public static String getToAccountSAR() {
		return ToAccountSAR;
	}

	public static void setToAccountSAR(String toAccountSAR) {

		ToAccountSAR = toAccountSAR;

	}

	public static String getToAccountForeign() {
		return ToAccountForeign;
	}

	public static void setToAccountForeign(String toAccountForeign) {
		ToAccountForeign = toAccountForeign;
	}

	public static String getBeneficiary_Local() {
		return Beneficiary_Local;
	}

	public static void setBeneficiary_Local(String beneficiary_Local) {
		Beneficiary_Local = beneficiary_Local;
	}

	public static String getBeneficiary_Intl() {
		return Beneficiary_Intl;
	}

	public static void setBeneficiary_Intl(String beneficiary_Intl) {
		Beneficiary_Intl = beneficiary_Intl;
	}

	public static String getBeneficiary_WithinBaj() {
		return Beneficiary_WithinBaj;
	}

	public static void setBeneficiary_WithinBaj(String beneficiary_WithinBaj) {
		Beneficiary_WithinBaj = beneficiary_WithinBaj;
	}

	public static String getTransferFrequency_OwnAcc() {
		return TransferFrequency_OwnAcc;
	}

	public static void setTransferFrequency_OwnAcc(String transferFrequency_OwnAcc) {
		TransferFrequency_OwnAcc = transferFrequency_OwnAcc;
	}

	public static String getAmount_Local() {
		return Amount_Local;
	}

	public static void setAmount_Local(String amount_Local) {
		Amount_Local = amount_Local;
	}

	public static String getAmountBetween_OwnAcc() {
		return Amount_OwnAcc;
	}

	public static void setAmount_Own(String Amount_Own) {
		Amount_OwnAcc = Amount_Own;
	}

	public static String getAmount_International() {
		return Amount_International;
	}

	public static void setAmount_International(String amount_International) {
		Amount_International = amount_International;
	}

	public static String getAmountNegative() {
		return Amount_Negative;
	}

	public static void setAmount_International_Negative(String amount_International_Negative) {
		Amount_Negative = amount_International_Negative;
	}

	public static String getAmount_WithinBaj() {
		return Amount_WithinBaj;
	}

	public static void setAmount_WithinBaj(String amount_WithinBaj) {
		Amount_WithinBaj = amount_WithinBaj;
	}

	public static String getAmount_WithinBajModify() {
		return Amount_WithinBajModify;
	}

	public static void setAmount_WithinBajModify(String amount_WithinBajModify) {
		Amount_WithinBajModify = amount_WithinBajModify;
	}

	public static String getAmount_ModifyOwnAcc() {
		return Amount_ModifyOwnAcc;
	}

	public static void setAmount_ModifyOwnAcc(String amount_ModifyOwnAcc) {
		Amount_ModifyOwnAcc = amount_ModifyOwnAcc;
	}

	public static String getAmount_ModifyIntl() {
		return Amount_ModifyIntl;
	}

	public static void setAmount_ModifyIntl(String amount_ModifyIntl) {
		Amount_ModifyIntl = amount_ModifyIntl;
	}

	public static String getAmount_ModifyLocal() {
		return Amount_ModifyLocal;
	}

	public static void setAmount_ModifyLocal(String amount_ModifyLocal) {
		Amount_ModifyLocal = amount_ModifyLocal;
	}

}
