package javaMain.JOL.selfservice;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.CancelYes;

import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_SELFSERVICE_CUSTOMERPROFILE_FUNC extends TestBase {

	public static Boolean CustomerViewProfile(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {
			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				CancelYes = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CancelYes"));

			} else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				CancelYes = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CancelYes"));

			}

			// Open customer profile page.
			Utils.click(By.xpath(getObj("Propval1", "SelfServices", "JOL_SELFSERVICE_CUSTOMERPROFILE")), "Self Services");

			Utils.click(By.xpath(getObj("Propval1", "CustomerProfile", "JOL_SELFSERVICE_CUSTOMERPROFILE")), "Customer Profile");

			// My Financial Position
			Utils.wait(4);
			String Balance = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "JOL_SELFSERVICE_CUSTOMERPROFILE")));

			Log.info("Landed Page is  :" + Balance);

			String val = driver.findElement(By.xpath(getObj("Propval1", "Name", "JOL_SELFSERVICE_CUSTOMERPROFILE"))).getAttribute("value");

			Log.info("Customer Name  displayed on screen is : " + val);

			if (val == null) {
				Utils.logFailImage("JOL_SELFSERVICE_MESSAGE_BOX");
				Log.error("SELFSERVICE CUSTOMERPROFILE Page is not displayed.........." + val);
			} else {
				Log.pass("SELFSERVICE CUSTOMERPROFILE displayed.................." + val);
				Utils.logPassImage("JOL_SELFSERVICE_MESSAGE_BOX");
				Log.info("Id number displayed on the screen is " + driver.findElement(By.name("idNumber")).getAttribute("value"));
			}

			Utils.ClearText(By.xpath(getObj("Propval1", "LandingPage", "JOL_SELFSERVICE_CUSTOMERPROFILE")));
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "LandingPageDropDown", "JOL_SELFSERVICE_CUSTOMERPROFILE")), By.xpath(getObj("Propval1", "LandingPage", "JOL_SELFSERVICE_CUSTOMERPROFILE")), ReadTestData(TCName, "Landingpage"));
			Log.pass("Selected value  " + ReadTestData(TCName, "Landingpage") + " as default landing page");

			if (Integer.parseInt(CancelYes) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "JOL_SELFSERVICE_CUSTOMERPROFILE")), "Cancel");

				int HomePage = Utils.getSizeNoException(By.xpath(getObj("Propval1", "HomePage", "JOL_SELFSERVICE_CUSTOMERPROFILE")));
				if (HomePage == 0) {
					Utils.logFailImage("JOL_SELFSERVICE_MESSAGE_BOX-pass");

					Log.fail("Cancel clicked is unsuccessfull");
					return false;
				} else {
					Utils.logPassImage("JOL_SELFSERVICE_MESSAGE_BOX-fail");

					Log.pass("Cancel clicked is successfull");

				}

			}
		}

		catch (Exception e) {
			runResult = false;
			throw e;

		}

		return runResult;
	}
}
