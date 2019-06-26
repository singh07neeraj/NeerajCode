package javaTestCases.JOL.transfer;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.JOL.transfer.JOL_ACCT_TRN_BETWEEN_OWN_ACCT;

public class JOL_TRANSFERS_TRN_BETWEEN_OWN_ACCT_TEST extends TestBase

{

	@Test
	public void JOL_ACCT_TRN_BETWEEN_OWN_ACCT() {

		TCName = "JOL Transfers-Transaction Between Own Acc";
		extentSetUp();

		if (isMasterClassRun) {

			for (scenarioCount = 3; scenarioCount <= RowCount(TCName); scenarioCount++) {

				try {
					Log.info("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has started." + "</mark>");
					JOL_ACCT_TRN_BETWEEN_OWN_ACCT.JOL_ACCT_TRN_BETWEEN_OWN_ACCT_functions(TCName, scenarioCount, dataset);
					Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");
					Utils.logPassImage(TCName + " " + scenarioCount + " passed");
				} catch (AssertionError | Exception e) {

					Utils.pressEscapeKey(4);
					Utils.refreshScreeen();
					Utils.logFailImage(TCName + " " + scenarioCount + "failed");
					Log.fail("<mark style='background-color: white; color: red;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has failed." + "</mark>" + System.lineSeparator() + ExceptionUtils.getStackTrace(e).trim());
				}
			}
		}

		else {

			// for (scenarioCount = 1; scenarioCount <= dataset.length; scenarioCount++) {

			try {
				Log.info("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has started." + "</mark>");
				JOL_ACCT_TRN_BETWEEN_OWN_ACCT.JOL_ACCT_TRN_BETWEEN_OWN_ACCT_functions(TCName, scenarioCount, dataset);
				Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");
				Utils.logPassImage(TCName + " " + scenarioCount + " passed");
			} catch (AssertionError | Exception e) {

				Utils.pressEscapeKey(4);
				Utils.refreshScreeen();
				Utils.logFailImage(TCName + " " + scenarioCount + "failed");
				Log.fail("<mark style='background-color: white; color: red;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has failed." + "</mark>" + System.lineSeparator() + ExceptionUtils.getStackTrace(e).trim());

			}
			// }
		}
	}
}
