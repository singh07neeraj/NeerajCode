package javaMain.JOL.selfservice;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.DateFrom;
import static javaMain.common_Functions.AppData.DateTo;
import static javaMain.common_Functions.AppData.TestType;

import org.openqa.selenium.By;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.JOL.transfer.TransferModuleCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_SELFSERVICE_ORDERSTATUS_FUNC extends TestBase {

	public static Boolean OrderStatus(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				ReadData.getJsonData("JOL Transfers - Add New Benificiary", 4, "DataSet");

				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				DateFrom = Input.ReadTestData(TCName, "DateFrom");
				DateTo = Input.ReadTestData(TCName, "DateTo");
				

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));
				DateFrom = Input.ReadTestData(TCName, "DateFrom");
				DateTo = Input.ReadTestData(TCName, "DateTo");
		
			}

			if (TestType.equalsIgnoreCase("N")) {
				DateFrom = Input.ReadTestData(TCName, "DateFromInvalid");
				DateTo = Input.ReadTestData(TCName, "DateToInvalid");
			}

			Utils.click(By.xpath(getObj("Propval1", "SelfServices", "JOL_SELFSERVICE_ORDERSTATUS")), "Self Services");

			Utils.click(By.xpath(getObj("Propval1", "OrderStatus", "JOL_SELFSERVICE_ORDERSTATUS")), "Order Status");

			Utils.wait(4);

			// My Financial Position
			String StatusPage = Utils.getTextNoException(By.xpath(getObj("Propval1", "landedPage", "JOL_SELFSERVICE_ORDERSTATUS")));
			Log.pass("Order Status Page is Landed With Text Value:" + StatusPage);

			int size = Utils.getSizeNoException(By.xpath(getObj("Propval1", "landedPage", "JOL_SELFSERVICE_ORDERSTATUS")));

			if (size > 0) {
				Log.pass("Self service order status page is displayed successfully...................");
			} else {

				Log.fail("SELFSERVICE ORDERSTATUS Page is not displayed..........");
				return runResult;
			}

			Utils.sendKeys(By.xpath(getObj("Propval1", "FromDate", "JOL_SELFSERVICE_ORDERSTATUS")), DateFrom, "From Date");
			Utils.sendKeys(By.xpath(getObj("Propval1", "TODate", "JOL_SELFSERVICE_ORDERSTATUS")), DateTo, "To Date");

			if (TestType.equalsIgnoreCase("N")) {

				Log.pass("Starting negative test scenario. Searching using invalid dates");
				Utils.sendKeys(By.xpath(getObj("Propval1", "FromDate", "JOL_SELFSERVICE_MESSAGE_BOX")), DateFrom, "From Date");
				Utils.sendKeys(By.xpath(getObj("Propval1", "TODate", "JOL_SELFSERVICE_MESSAGE_BOX")), DateTo, "To Date");
				
				int error = Utils.getSizeNoException(By.xpath(getObj("Propval1", "error", "JOL_SELFSERVICE_ORDERSTATUS")));
				if (error > 0) {
					Utils.logPassImage("Error Message Appeared");
					Log.pass("Error Message Appeared Successfully");
					return true;
				} else {
					Utils.logFailImage("Error Message is not showing with invalid data");
					Log.fail("Error Message is not showing. TS failed.");
					return false;

				}

			} else {

				Utils.pressEnter();
				Utils.click(By.xpath(getObj("Propval1", "Search", "JOL_SELFSERVICE_ORDERSTATUS")), "Search");
				String Balance1 = Utils.getText(By.xpath(getObj("Propval1", "ItemDisplay", "JOL_SELFSERVICE_ORDERSTATUS")));
				Log.pass("Total Search :" + Balance1 + " Displayed on Page.....");
				Utils.logPassImage("JOL_SELFSERVICE_MESSAGE_BOX");
			}
			
			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				TransferModuleCommonFunctions.sendEmailDownloadExcelnPrintFunc();
			}
			
		} catch (Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
