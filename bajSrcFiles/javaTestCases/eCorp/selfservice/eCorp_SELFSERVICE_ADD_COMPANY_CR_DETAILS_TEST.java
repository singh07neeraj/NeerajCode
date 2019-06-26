package javaTestCases.eCorp.selfservice;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.eCorp.selfservice.eCorp_SELFSERVICE_ADD_COMPANY_CR_DETAILS_FUNC;

public class eCorp_SELFSERVICE_ADD_COMPANY_CR_DETAILS_TEST extends TestBase

{

	@Test
	public void NAQAADeposit() {

		TCName = "eCorp Self Service-Add Company CR Details";
		extentSetUp();

		if (true) {

			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {

				try {
					eCorp_SELFSERVICE_ADD_COMPANY_CR_DETAILS_FUNC.ADD_COMPANY_CR_DETAILS(TCName, scenarioCount, dataset);
					Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

				} catch (AssertionError |Exception e) {


					Utils.pressEscapeKey(4);
					Utils.refreshScreeen();
					Utils.logFailImage(TCName + " " + scenarioCount + "failed");
					Log.fail("<mark style='background-color: white; color: red;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has failed." + "</mark>" + System.lineSeparator() + ExceptionUtils.getStackTrace(e).trim());

				}

			}
		}

		else {

		//	for (scenarioCount = 1; scenarioCount <= 1; ) {

				try {
					eCorp_SELFSERVICE_ADD_COMPANY_CR_DETAILS_FUNC.ADD_COMPANY_CR_DETAILS(TCName, scenarioCount, dataset);
					Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

				} catch (AssertionError | Exception e) {


					Utils.pressEscapeKey(4);
					Utils.refreshScreeen();
					Utils.logFailImage(TCName + " " + scenarioCount + "failed");
					Log.fail("<mark style='background-color: white; color: red;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has failed." + "</mark>" + System.lineSeparator() + ExceptionUtils.getStackTrace(e).trim());

				}

		//	}

		}

	}
}
