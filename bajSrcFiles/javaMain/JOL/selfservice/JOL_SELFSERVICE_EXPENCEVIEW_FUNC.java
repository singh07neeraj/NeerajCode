package javaMain.JOL.selfservice;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.DateFrom;
import static javaMain.common_Functions.AppData.DateTo;
import static javaMain.common_Functions.AppData.TestType;

import org.openqa.selenium.By;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenJOLMenues;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_SELFSERVICE_EXPENCEVIEW_FUNC extends TestBase {

	public static Boolean Expenceview(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));

				DateFrom = Input.ReadTestData(TCName, "DateFrom");
				DateTo = Input.ReadTestData(TCName, "DateTo");

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");

				TestType = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType");
				
				DateFrom = Input.ReadTestData(TCName, "DateFrom");
				DateTo = Input.ReadTestData(TCName, "DateTo");
			}

			if (TestType.equalsIgnoreCase("N")) {
				DateFrom = Input.ReadTestData(TCName, "DateFromInvalid");
				DateTo = Input.ReadTestData(TCName, "DateToInvalid");
			}

			// Open Expense view

			OpenJOLMenues.openSelfServicesMenu("ExpenseView");
			Utils.wait(5);
			// My Financial Position
			String Balance = Utils.getTextNoException(By.xpath(getObj("Propval1", "MyFinancialPosition", "JOL_SELFSERVICE_EXPENCEVIEW")));
			Log.pass("My Financial Position Balance is : " + Balance);
			Utils.sendKeys(By.xpath(getObj("Propval1", "FromDate", "JOL_SELFSERVICE_MESSAGE_BOX")), DateFrom, "From Date");
			Utils.sendKeys(By.xpath(getObj("Propval1", "TODate", "JOL_SELFSERVICE_MESSAGE_BOX")), DateTo, "To Date");
			Utils.pressTab();
			Utils.logPassImage("My Financial Position Balance ");

			if (TestType.equalsIgnoreCase("N")) {

				Log.pass("Starting negative test scenario. Searching using invalid dates");
				Utils.sendKeys(By.xpath(getObj("Propval1", "FromDate", "JOL_SELFSERVICE_MESSAGE_BOX")), DateFrom, "From Date");
				Utils.sendKeys(By.xpath(getObj("Propval1", "TODate", "JOL_SELFSERVICE_MESSAGE_BOX")), DateTo, "To Date");
				Utils.pressTab();
				int error = Utils.getSizeNoException(By.xpath(getObj("Propval1", "error", "JOL_SELFSERVICE_EXPENCEVIEW")));
				if (error > 0) {
					Utils.logPassImage("JOL_SELFSERVICE_MESSAGE_BOX");
					Log.pass("Error Message Appeared Successfully");
					return true;
				} else {
					Utils.logFailImage("JOL_SELFSERVICE_MESSAGE_BOX");
					Log.fail("Error Message is not showing");
					return false;

				}

			}

			else

			{

				Utils.pressEnter();

				Utils.click(By.xpath(getObj("Propval1", "Search", "JOL_SELFSERVICE_EXPENCEVIEW")), "Search");
				//*[contains(text(),'»ÕÀ')]
				String DisplayBalance = Utils.getTextNoException(By.xpath(getObj("Propval1", "MyFinancialPosition", "JOL_SELFSERVICE_EXPENCEVIEW")));
				Log.pass("My Financial Position Total balance is  : " + DisplayBalance);

				// Click on ExpensesPaymentsbycategory

				Utils.click(By.xpath(getObj("Propval1", "ExpensesPaymentsbycategory", "JOL_SELFSERVICE_EXPENCEVIEW")), "Expense Payment Category");

				String Balance1 = Utils.getTextNoException(By.xpath(getObj("Propval1", "Balance", "JOL_SELFSERVICE_EXPENCEVIEW")));

				Log.pass("After Search My Financial Position Balance is :" + Balance1);

				if (Balance1 == null) {
					Utils.logFailImage("JOL_SELFSERVICE_MESSAGE_BOX");
					Log.error("SELFSERVICE EXPENCEVIEW Page is not displayed.......... " + Balance1);
				} else {
					Utils.logPassImage("JOL_SELFSERVICE_MESSAGE_BOX");
					Log.pass("SELFSERVICE EXPENCEVIEW displayed.................." + Balance1);
				}

				return true;
			}

		}

		catch (Exception e) {
			runResult = false;
			throw e;

		}

	}
}
