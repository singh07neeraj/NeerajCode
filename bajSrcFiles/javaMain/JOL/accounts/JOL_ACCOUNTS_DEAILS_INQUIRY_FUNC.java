package javaMain.JOL.accounts;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_ACCOUNTS_DEAILS_INQUIRY_FUNC extends TestBase {

	public static boolean JolAccountDetails(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		String details,SendSMS,SendEMail;
		try {

			if (isMasterClassRun) {
				
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				details = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "details"));
				SendSMS = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "SendSMS"));
				SendEMail = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "SendEMail"));

			}

			else {
				
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				details = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("details"));
				SendSMS = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("SendSMS"));
				SendEMail = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("SendEMail"));
			}

			// click on Account Top
			Utils.click(By.xpath(getObj("Propval1", "Accounts", "JOL_ACCOUNTS_DEAILS_INQUIRY")), "Accounts link");

			// Click on Account Details
			Utils.click(By.xpath(getObj("Propval1", "details", "JOL_ACCOUNTS_DEAILS_INQUIRY")), "Account details link");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "JOL_ACCOUNTS_DEAILS_INQUIRY")));
			Utils.wait(3);
			Utils.ClearText(By.xpath(getObj("Propval1", "Account", "JOL_ACCOUNTS_DEAILS_INQUIRY")));
			// Select Account

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "Accountdropdown", "JOL_ACCOUNTS_DEAILS_INQUIRY")), By.xpath(getObj("Propval1", "Account", "JOL_ACCOUNTS_DEAILS_INQUIRY")),
					Input.ReadTestData(TCName, "AccountNumber"));

			String Nickname = Utils.getText(By.xpath(getObj("Propval1", "NickName", "JOL_ACCOUNTS_DEAILS_INQUIRY")));
			String Balance = Utils.getText(By.xpath(getObj("Propval1", "Balance", "JOL_ACCOUNTS_DEAILS_INQUIRY")));
			if (Nickname == null) {

				Log.fail("Account details page is not displayed..");
			} else {
				Log.pass("Account details page is displayed.. and Account user name is : " + Nickname + "Current Balance is :" + Balance);
			}

			if (Integer.parseInt(details) == 1) {
				try {

					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "NoResultsFound", "JOL_ACCOUNTS_DEAILS_INQUIRY")), "No Results found Details."));
					Log.pass("Search results displayed on screen ");
					// Click on Account Details
					Utils.click(By.xpath(getObj("Propval1", "AccountDetails", "JOL_ACCOUNTS_DEAILS_INQUIRY")), "Click on Account Details");

					// Click on PDF
					Utils.click(By.xpath(getObj("Propval1", "PDF", "JOL_ACCOUNTS_DEAILS_INQUIRY")), "Click on PDF");
					// Click on Print
					Utils.click(By.xpath(getObj("Propval1", "Print", "JOL_ACCOUNTS_DEAILS_INQUIRY")), "Click on Print");

					Utils.closeOtherTabs();

					// Enter Remark
					Utils.sendKeys(By.xpath(getObj("Propval1", "remarks", "JOL_ACCOUNTS_DEAILS_INQUIRY")), Input.ReadTestData(TCName, "Remarks"), "Remarks");

					// String handle= driver.getWindowHandle();

					// Select Tag
					Utils.click(By.xpath(getObj("Propval1", "Tagdropdown", "JOL_ACCOUNTS_DEAILS_INQUIRY")), "Tag drop down");
					Utils.wait(3);

					Utils.sendValDropdown(By.xpath(getObj("Propval1", "Tag", "JOL_ACCOUNTS_DEAILS_INQUIRY")), Input.ReadTestData(TCName, "Tag"), "Tag");
					Utils.wait(3);

					// Click on Save
					Utils.click(By.xpath(getObj("Propval1", "Save", "JOL_ACCOUNTS_DEAILS_INQUIRY")), "Save Details");
					Utils.wait(3);
					Utils.pressEnter();
					Utils.wait(3);
					Utils.pressEscapeKey(3);

				} catch (AssertionError | Exception e) {

					Log.pass("No search results displayed on screen. Displayed text is : " + Utils.getText(By.xpath(getObj("Propval1", "NoResultsFound", "JOL_ACCOUNTS_DEAILS_INQUIRY"))));
					
					return true;
				}
				
			}
			if (SendSMS.equalsIgnoreCase("true")) {

				// Click on SMS Send
				Utils.click(By.xpath(getObj("Propval1", "sms", "JOL_ACCOUNTS_DEAILS_INQUIRY")), "Send sms button");
				Utils.wait(1);
				// Click on Send SMS
				Utils.click(By.xpath(getObj("Propval1", "smssend", "JOL_ACCOUNTS_DEAILS_INQUIRY")), "send button");
				Utils.wait(3);
				Utils.pressEnter();
				Utils.wait(3);
			}
			if (SendEMail.equalsIgnoreCase("true")) {
				// Click on email Send
				Utils.click(By.xpath(getObj("Propval1", "email", "JOL_ACCOUNTS_DEAILS_INQUIRY")), "Email button");

				Utils.wait(3);

				// Click on email SMS

				Utils.click(By.xpath(getObj("Propval1", "emailsend", "JOL_ACCOUNTS_DEAILS_INQUIRY")), "send email button.");
				Utils.wait(5);
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "JOL_ACCOUNTS_DEAILS_INQUIRY")));
				Utils.pressEnter();
				
				}

		}

		catch (AssertionError | Exception e) {
			runResult = false;
			e.printStackTrace();
			throw e;
		}
		return runResult;
	}
}
