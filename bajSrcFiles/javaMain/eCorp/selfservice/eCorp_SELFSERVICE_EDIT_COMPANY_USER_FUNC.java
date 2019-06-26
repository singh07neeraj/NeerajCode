package javaMain.eCorp.selfservice;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.CivilianId;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.DirectReportId;
import static javaMain.common_Functions.AppData.DirectReportName;
import static javaMain.common_Functions.AppData.Email;
import static javaMain.common_Functions.AppData.GroupDivision;
import static javaMain.common_Functions.AppData.IDType;
import static javaMain.common_Functions.AppData.Mobile;
import static javaMain.common_Functions.AppData.Nationality;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.isNegative;
import static javaMain.common_Functions.AppData.phoneAndExt;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.eCorpCommonFunctions;
/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_SELFSERVICE_EDIT_COMPANY_USER_FUNC extends TestBase {

	public static Boolean EDIT_COMPANY_USER(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				Mobile = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Mobile"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				Nationality = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Nationality"));
				IDType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "IDType"));
				CivilianId = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CivilianId"));
				GroupDivision = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "GroupDivision"));
				DirectReportId = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "DirectReportId"));
				DirectReportName = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "DirectReportName"));
				phoneAndExt = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "phoneAndExt"));
				Mobile = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Mobile"));
				Email = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Email"));

			} else {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				Mobile = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Mobile"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				Nationality = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Nationality ");
				IDType = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("IDType");
				CivilianId = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("CivilianId");
				GroupDivision = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("GroupDivision");
				DirectReportId = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("DirectReportId");
				DirectReportName = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("DirectReportName");
				phoneAndExt = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("phoneAndExt");
				Mobile = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Mobile");
				Email = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Email");

			}

			Utils.click(By.xpath(getObj("Propval1", "SelfServiceLnk", "eCorp_EditCompanyUser")), "Self Services");

			Utils.click(By.xpath(getObj("Propval1", "EditCompanyUser", "eCorp_EditCompanyUser")), "Edit Company User");

			// Verify landing page
			String Balance = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_EditCompanyUser")));

			Log.pass("Landed Page is  :" + Balance);

			Utils.ClearText(By.xpath(getObj("Propval1", "nationalit", "eCorp_EditCompanyUser")));

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "nationalitDropdown", "eCorp_EditCompanyUser")), By.xpath(getObj("Propval1", "nationalit", "eCorp_EditCompanyUser")), Nationality, "Nationality");

			Utils.ClearText(By.xpath(getObj("Propval1", "idtype", "eCorp_EditCompanyUser")));
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "idtypeDropdown", "eCorp_EditCompanyUser")), By.xpath(getObj("Propval1", "idtype", "eCorp_EditCompanyUser")), IDType, "IDType");

			Utils.ClearText(By.xpath(getObj("Propval1", "nationalit", "eCorp_EditCompanyUser")));

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "nationalitDropdown", "eCorp_EditCompanyUser")), By.xpath(getObj("Propval1", "nationalit", "eCorp_EditCompanyUser")), Nationality, "Nationality");

			Utils.sendKeys(By.xpath(getObj("Propval1", "civilianId", "eCorp_EditCompanyUser")), CivilianId, "CivilianId");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "expiryDateDropdown", "eCorp_EditCompanyUser")), By.xpath(getObj("Propval1", "expiryDate", "eCorp_EditCompanyUser")), "10/10/2019", "expiryDate");

			Utils.ClearText(By.xpath(getObj("Propval1", "groupDivision", "eCorp_EditCompanyUser")));
			Utils.sendKeys(By.xpath(getObj("Propval1", "groupDivision", "eCorp_EditCompanyUser")), GroupDivision, "groupDivision");

			Utils.ClearText(By.xpath(getObj("Propval1", "directReportId", "eCorp_EditCompanyUser")));
			Utils.sendKeys(By.xpath(getObj("Propval1", "directReportId", "eCorp_EditCompanyUser")), DirectReportId, "direct Report Id");

			Utils.ClearText(By.xpath(getObj("Propval1", "directReportName", "eCorp_EditCompanyUser")));
			Utils.sendKeys(By.xpath(getObj("Propval1", "directReportName", "eCorp_EditCompanyUser")), DirectReportName, "direct Report Name");

			Utils.ClearText(By.xpath(getObj("Propval1", "phoneAndExt", "eCorp_EditCompanyUser")));
			Utils.sendKeys(By.xpath(getObj("Propval1", "phoneAndExt", "eCorp_EditCompanyUser")), phoneAndExt, "phone And Ext");

			Utils.ClearText(By.xpath(getObj("Propval1", "mobilePhoneInput", "eCorp_EditCompanyUser")));

			Utils.sendKeys(By.xpath(getObj("Propval1", "mobilePhoneInput", "eCorp_EditCompanyUser")), Mobile, "mobile Phone Input");
			Utils.sendKeys(By.xpath(getObj("Propval1", "email", "eCorp_EditCompanyUser")), Email, "Email");

			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "eCorp_EditCompanyUser")), "Proceed");

			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "eCorp_EditCompanyUser")), "Proceed Cancel");

				Utils.logPassImage(TCName);
				return runResult;

			}

			if (isNegative.equalsIgnoreCase("true")) {
				try {

					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "eCorp_EditCompanyUser")), "Result Details."));
					Log.pass("User is not able to proceed without enter all the mandatory fields ");
					Utils.logPassImage(TCName);
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("User is able to proceed with enter invalid computer name hecne test case fail. ");
					Utils.logFailImage(TCName);

				}

			}
			if (Integer.parseInt(Confirm) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_EditCompanyUser")), "Confirm");

			} else if (Integer.parseInt(Confirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "eCorp_EditCompanyUser")), "Modify");
				Utils.sendKeys(By.xpath(getObj("Propval1", "mobilePhoneInput", "eCorp_EditCompanyUser")), Mobile, "mobile Phone Input");
				Utils.sendKeys(By.xpath(getObj("Propval1", "email", "eCorp_EditCompanyUser")), "sbugshan@baj.com.sa", "Email");

				// Enter Company name

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "eCorp_EditCompanyUser")), "Modify Proceed");

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_EditCompanyUser")), "Modify Confirm");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "eCorp_EditCompanyUser")), "Confirm Cancel");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "eCorp_EditCompanyUser")), "Confirm Cancel yes");
				Log.pass("Click on Confirm Return ......");
				Utils.logPassImage(TCName);
				return runResult;
			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "eCorp_EditCompanyUser")), "Success Message"));
				Log.pass("AddCompany CR Details successfully." + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "eCorp_EditCompanyUser"))));
				Utils.logPassImage("AddCompany CR Details-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("AddCompany CR Details failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "eCorp_EditCompanyUser"))));
				Utils.logFailImage("AddCompany CR Details-Fail");
				throw e;
			}

			Utils.wait(2);
			Utils.logPassImage(TCName);
			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

			if (Integer.parseInt(NewTxn) == 1) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "eCorp_EditCompanyUser")), "New Transaction");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "eCorp_EditCompanyUser")), "proceed"));
				Utils.logPassImage("Additional Actions");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "eCorp_EditCompanyUser")), "Home Button.");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomepageSuccess", "eCorp_EditCompanyUser")), "HomepageSuccess"));
				Utils.logPassImage("Additional Actions");

			}
		}

		catch (Exception e) {
			runResult = false;
			e.printStackTrace();

			return runResult;
		}
		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFuncBeneficiary(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_EditCompanyUser")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_EditCompanyUser")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_EditCompanyUser")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_EditCompanyUser")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_EditCompanyUser")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_EditCompanyUser")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "eCorp_EditCompanyUser")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_EditCompanyUser")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_EditCompanyUser")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_EditCompanyUser")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_EditCompanyUser")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_EditCompanyUser")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_EditCompanyUser")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "eCorp_EditCompanyUser")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_EditCompanyUser")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "eCorp_EditCompanyUser")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			// Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon",
			// "eCorp_EditCompanyUser")), "Excel Download");
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "eCorp_EditCompanyUser")), "Print Button");
			// close all other tabs except the main one. i.e 1st page.
			Utils.closeOtherTabs();

		}

		catch (Exception e) {
			Log.error("Unable to send email semail, print and download pdf etc.");
			Utils.logFailImage("Error");
			runResult = false;
			throw e;

		}

		return runResult;
	}

}
