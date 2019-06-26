/*
 * package javaMain.eCorp.transfer;
 * 
 * import static Utilities.Input.ReadTestData; import static
 * Utilities.ReadData.ReadDataSQL; import static Utilities.ReadData.getObj;
 * 
 * import java.util.Random;
 * 
 * import org.apache.commons.lang3.exception.ExceptionUtils; import
 * org.openqa.selenium.By; import org.openqa.selenium.WebElement;
 * 
 * import Utilities.Input; import Utilities.Log; import Utilities.TestBase;
 * import Utilities.Utils; import javaMain.common_Functions.AppConstants; import
 * javaMain.common_Functions.AppData;
 * 
 * public class TransferModuleCommonFunctions_Raj extends TestBase {
 * 
 * public static boolean addAnotherTxn(int count, String fromAcc, String ToAcc,
 * String Amount) throws Exception {
 * 
 * for (int i = 1; i <= count; i++) { try { // Add another transaction Log.
 * info("Started adding another transaction.Total transactions to be added are : "
 * + count); Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction",
 * "JOL_INTLTransfer")), "Add another transaction"); Utils.enterOTPAndProceed();
 * Utils.wait(3); Utils.enterOTPAndProceed();
 * Utils.sendKeys(By.xpath(getObj("Propval1", "FromAcctCombo",
 * "JOL_Transfers_BetweenMyAccts")), fromAcc, "From Account Dropdown");
 * Utils.pressKeyDown(); Utils.pressKeyDown(); Utils.pressEnter();
 * 
 * Log.info("Successfully Entered To Account Number...");
 * Utils.sendValDropdown(By.xpath(getObj("Propval1", "toAcctCombo",
 * "JOL_Transfers_BetweenMyAccts")), ToAcc, "To Account Dropdown.");
 * 
 * Utils.pressKeyDown(); Utils.pressKeyDown(); Utils.pressEnter();
 * 
 * Log.info("Successful Entered From Account Number...");
 * Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")),
 * Amount, "Amount");
 * Log.pass("Successfully added another transaction. Count No.= " + i); }
 * 
 * catch (Exception e) {
 * 
 * Log.error("Unable to add another transaction number.." + count + "  error.."
 * + ExceptionUtils.getStackTrace(e)); runResult = false; throw e; }
 * 
 * } return runResult; }
 * 
 * public static boolean addAnotherIntlTxn(int count, String fromAcc, String
 * TxfrAmountType, String EXEC, String NextDate, String FutureDate) throws
 * Exception {
 * 
 * for (int i = 1; i <= count; i++) { try {
 * 
 * Log.
 * info("Started adding another transaction.Total transactions to be added are : "
 * + count); Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction",
 * "JOL_INTLTransfer")), "Add another transaction"); Utils.enterOTPAndProceed();
 * Utils.wait(3);
 * 
 * Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1",
 * "AccountNumberDropdownDropdown", "LocalTransfers")),
 * By.xpath(getObj("Propval1", "AccountNumber", "LocalTransfers")), fromAcc);
 * 
 * Log.pass("Selected Account Number is   is :" + ReadTestData("LocalTransfer",
 * "AccountNumber"));
 * 
 * Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1",
 * "BeneficiaryDropdownDropdown", "LocalTransfers")),
 * By.xpath(getObj("Propval1", "Beneficiary", "LocalTransfers")),
 * AppData.getBeneficiary_Intl());
 * Log.pass("Selected Beneficiary  Number is   is :" +
 * AppData.getBeneficiary_Intl()); Utils.sendKeys(By.xpath(getObj("Propval1",
 * "AmountTxt", "JOL_INTLTransfer")), AppData.getAmount_International());
 * 
 * if (!TxfrAmountType.equalsIgnoreCase("SAR")) {
 * 
 * Utils.click(By.xpath(getObj("Propval1", "TxfrAmountType",
 * "JOL_INTLTransfer")), "transfer amount type radio box."); // add selected
 * radio box curr type code later. }
 * 
 * // Execute now if (Integer.parseInt(EXEC) == 1) {
 * Log.info("Execute now is already selected by default"); }
 * 
 * // Schedule transfer else if (Integer.parseInt(EXEC) == 2) {
 * 
 * Utils.click(By.xpath(getObj("Propval1", "Schedule", "JOL_INTLTransfer")),
 * "Clicked on Schedule "); Utils.sendKeys(By.xpath(getObj("Propval1",
 * "nickName_ns", "JOL_INTLTransfer")), "Automation");
 * 
 * WebElement Date = driver.findElement(By.xpath(getObj("Propval1",
 * "TransferDate", "JOL_INTLTransfer")));
 * Date.sendKeys(Utils.DateValue((Integer.parseInt(NextDate))));
 * 
 * } // Standing Order else {
 * 
 * Utils.click(By.xpath(getObj("Propval1", "stdorder", "JOL_INTLTransfer")),
 * "Clicked on Standard Order");
 * 
 * Utils.sendKeys(By.xpath(getObj("Propval1", "STDNickName",
 * "JOL_INTLTransfer")), "Automation");
 * 
 * WebElement StartDate = driver.findElement(By.xpath(getObj("Propval1",
 * "StartDate", "JOL_INTLTransfer")));
 * StartDate.sendKeys(Utils.DateValue((Integer.parseInt(NextDate))));
 * 
 * WebElement endtDate = driver.findElement(By.xpath(getObj("Propval1",
 * "endDate", "JOL_INTLTransfer")));
 * endtDate.sendKeys(Utils.DateValue((Integer.parseInt(FutureDate))));
 * 
 * WebElement Frequency = driver.findElement(By.xpath(getObj("Propval1",
 * "Frequency", "JOL_INTLTransfer"))); Frequency.sendKeys("Bimonthly");
 * 
 * } Utils.wait(1); Utils.click(By.xpath(getObj("Propval1", "CheckBox",
 * "JOL_INTLTransfer")), "Condition Checked "); Utils.wait(2);
 * Log.pass("Successfully added another transaction. Count= " + count); }
 * 
 * catch (Exception e) {
 * 
 * Log.error("Unable to add another transaction number.." + count + "  error.."
 * + ExceptionUtils.getStackTrace(e)); runResult = false; throw e; }
 * 
 * } return runResult; } public static boolean addAnotherIntlTxnCharity11(int
 * count, String fromAcc) throws Exception {
 * 
 * for (int i = 1; i <= count; i++) { try {
 * 
 * Log.
 * info("Started adding another transaction.Total transactions to be added are : "
 * + count); Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction",
 * "JOL_INTLTransfer")), "Add another transaction"); Utils.enterOTPAndProceed();
 * Utils.wait(3);
 * 
 * Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1",
 * "AccountNumberDropdownDropdown", "LocalTransfers")),
 * By.xpath(getObj("Propval1", "AccountNumber", "LocalTransfers")), fromAcc);
 * 
 * Log.pass("Selected Account Number is   is :" + ReadTestData("LocalTransfer",
 * "AccountNumber"));
 * 
 * Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1",
 * "BeneficiaryDropdownDropdown", "LocalTransfers")),
 * By.xpath(getObj("Propval1", "Beneficiary", "LocalTransfers")),
 * ReadTestData(TCName, "Beneficiary"));
 * Log.pass("Selected Beneficiary Name is :" + ReadTestData(TCName,
 * "Beneficiary")); Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt",
 * "JOL_INTLTransfer")), ReadTestData(TCName, "Donation Amount")); // Enter
 * Payment details Utils.sendKeys(By.xpath(getObj("Propval1", "paymentDetails",
 * "JOL_charity")), Input.ReadTestData(TCName, "Payment Details"),
 * "Payment Details");
 * Log.pass("Successfully added another transaction. Count= " + count); }
 * 
 * catch (Exception e) {
 * 
 * Log.error("Unable to add another transaction number.." + count + "  error.."
 * + ExceptionUtils.getStackTrace(e)); runResult = false; throw e; }
 * 
 * } return runResult; }
 * 
 * public static boolean deleteAnotherTxn(int count) throws Exception {
 * 
 * for (int i = 1; i <= count; i++) { try { // deleting another transaction Log.
 * info("Started deleting another transactions.Total transactions to be deleted are : "
 * + count);
 * 
 * Utils.click(By.xpath(getObj("Propval1", "deleteAnotherAccIcon",
 * "JOL_Transfers_BetweenMyAccts")), "Delete another transaction.");
 * Utils.wait(8);
 * 
 * Log.pass("Successfully deleted another transaction. Count= " + count); }
 * 
 * catch (Exception e) {
 * Log.error("Unable to delete another transaction number.." + count +
 * "  error.." + ExceptionUtils.getStackTrace(e)); runResult = false; throw e;
 * 
 * }
 * 
 * } return runResult; }
 * 
 * public static boolean sendEmailDownloadExcelnPrintFunc(int count, int
 * ScenarioCount) throws Exception {
 * 
 * try { // Start sending email , downloading pdf and printing etc.
 * Utils.wait(3); Log.info("Starting send email functionality");
 * Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "AlZCapital")),
 * "Send Email Icon"); Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo",
 * "AlZCapital")), ReadTestData("MarketInfo", "toEmail"), "to email ");
 * Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "AlZCapital")),
 * ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
 * Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "AlZCapital")),
 * ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
 * Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "AlZCapital")),
 * ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
 * Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "AlZCapital")),
 * ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
 * 
 * // Send email if proceed=1 in DB if (Integer.parseInt(ReadDataSQL(TCName,
 * ScenarioCount, "Proceed")) == 1) { Utils.click(By.xpath(getObj("Propval1",
 * "sendBtnEle", "AlZCapital")), "Send Email Button"); //assertion } // Hit
 * cancel email if Proceed=2 in DB. else if
 * (Integer.parseInt(ReadDataSQL(TCName, ScenarioCount, "Proceed")) == 2) {
 * Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "AlZCapital")),
 * "Cancel Email Button"); }
 * 
 * Utils.wait(2); Utils.pressExcapeActions(); // Download report in pdf format.
 * Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "AlZCapital")),
 * "pdf download"); Utils.wait(3); Utils.enterOTPAndProceed();
 * Utils.moveToElement(By.id("logo")); // Download report in excel format.
 * Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "AlZCapital")),
 * "Excel Download"); Utils.wait(3); Utils.enterOTPAndProceed();
 * Utils.moveToElement(By.id("logo")); // Print report.
 * Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "AlZCapital")),
 * "Print Button"); // close all other tabs except the main one. i.e 1st page.
 * Utils.closeOtherTabs(); }
 * 
 * catch (Exception e) {
 * Log.error("Unable to delete another transaction number.." + count +
 * "  error.." + ExceptionUtils.getStackTrace(e)); runResult = false; throw e;
 * 
 * }
 * 
 * return runResult; }
 * 
 * public static boolean addFavSendEmailDownloadPdfNprintFunc(String Nickname)
 * throws Exception {
 * 
 * 
 * try { // to click on additional options
 * Log.info("Started clicking on additional options");
 * Utils.click(By.xpath(getObj("Propval1", "AddAsFavourite",
 * "Additional_Options")), "Add As Favourite link");
 * 
 * //Nickname="TestAutomation";
 * 
 * char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray(); StringBuilder sb =
 * new StringBuilder(10); Random random = new Random(); for (int i = 0; i < 10;
 * i++) { char c = chars[random.nextInt(chars.length)]; sb.append(c); } String
 * output = sb.toString(); System.out.println(output);
 * Nickname=Nickname+"_"+output; Utils.wait(5);
 * Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_Txt",
 * "Additional_Options")), Nickname, "Save as favourite nick name");
 * Utils.click(By.xpath(getObj("Propval1", "AddAsFav_Save_Btn",
 * "Additional_Options")), "Add As Favourite Save button"); Utils.wait(3);
 * 
 * //to click Export PDF link Utils.click(By.xpath(getObj("Propval1",
 * "ExportPDF", "Additional_Options")), "Export PDF link"); Utils.wait(3); //to
 * click Print link Utils.click(By.xpath(getObj("Propval1", "Print",
 * "Additional_Options")), "Print link"); Utils.wait(3); Utils.closeOtherTabs();
 * Utils.wait(3); //to click Send By Email link
 * Utils.click(By.xpath(getObj("Propval1", "SendByEmail",
 * "Additional_Options")), "Send By Email link"); Utils.wait(3);
 * Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "AlZCapital")),
 * ReadTestData("MarketInfo", "toEmail"), "to email ");
 * Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "AlZCapital")),
 * ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
 * Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "AlZCapital")),
 * ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
 * Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "AlZCapital")),
 * ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
 * Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "AlZCapital")),
 * ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
 * 
 * Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn",
 * "Additional_Options")), "Send by Email Button");
 * 
 * //driver.findElement(By.id("lelo")).click(); // add success assertion }
 * 
 * catch (Exception e) {
 * 
 * Log.fail("addFavSendEmailDownloadPdfNprintFunc has failed..error "+
 * Utils.getText(By.xpath(getObj("Propval1", "ErrorMsg_SendByEmail",
 * "Additional_Options"))));
 * 
 * 
 * Log.error("Unable to click on additional options" +
 * ExceptionUtils.getStackTrace(e)); runResult = false; throw e; }
 * 
 * 
 * return runResult; }
 * 
 * 
 * public static boolean Account_TarnsDetailsPdfNPrint(String Nickname) throws
 * Exception {
 * 
 * 
 * try { // to click on additional options
 * Log.info("Started clicking on Transaction Details");
 * Utils.click(By.xpath(getObj("Propval1", "AddAsFavourite",
 * "Additional_Options")), "Add As Favourite link");
 * 
 * String details = null; if (Integer.parseInt(details) == 1) {
 * 
 * } //Nickname="TestAutomation";
 * 
 * char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray(); StringBuilder sb =
 * new StringBuilder(10); Random random = new Random(); for (int i = 0; i < 10;
 * i++) { char c = chars[random.nextInt(chars.length)]; sb.append(c); } String
 * output = sb.toString(); System.out.println(output);
 * Nickname=Nickname+"_"+output; Utils.wait(5);
 * Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_Txt",
 * "Additional_Options")), Nickname, "Save as favourite nick name");
 * Utils.click(By.xpath(getObj("Propval1", "AddAsFav_Save_Btn",
 * "Additional_Options")), "Add As Favourite Save button"); Utils.wait(3);
 * 
 * //to click Export PDF link Utils.click(By.xpath(getObj("Propval1",
 * "ExportPDF", "Additional_Options")), "Export PDF link"); Utils.wait(3); //to
 * click Print link Utils.click(By.xpath(getObj("Propval1", "Print",
 * "Additional_Options")), "Print link"); Utils.wait(3); Utils.closeOtherTabs();
 * Utils.wait(3); //to click Send By Email link
 * Utils.click(By.xpath(getObj("Propval1", "SendByEmail",
 * "Additional_Options")), "Send By Email link"); Utils.wait(3);
 * Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "AlZCapital")),
 * ReadTestData("MarketInfo", "toEmail"), "to email ");
 * Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "AlZCapital")),
 * ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
 * Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "AlZCapital")),
 * ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
 * Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "AlZCapital")),
 * ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
 * Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "AlZCapital")),
 * ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
 * 
 * Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn",
 * "Additional_Options")), "Send by Email Button");
 * 
 * //driver.findElement(By.id("lelo")).click(); // add success assertion }
 * 
 * catch (Exception e) {
 * 
 * Log.fail("addFavSendEmailDownloadPdfNprintFunc has failed..error "+
 * Utils.getText(By.xpath(getObj("Propval1", "ErrorMsg_SendByEmail",
 * "Additional_Options"))));
 * 
 * 
 * Log.error("Unable to click on additional options" +
 * ExceptionUtils.getStackTrace(e)); runResult = false; throw e; }
 * 
 * 
 * return runResult; }
 * 
 * }
 */