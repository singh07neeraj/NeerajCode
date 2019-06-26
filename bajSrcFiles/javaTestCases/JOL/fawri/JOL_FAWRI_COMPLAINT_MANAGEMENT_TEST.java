package javaTestCases.JOL.fawri;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;

public class JOL_FAWRI_COMPLAINT_MANAGEMENT_TEST extends TestBase {
	@Test
	public void JOL_FAWRI_COMPLAINT_MANAGEMENT() {

		TCName = "JOL Fawri  - Complaint Management";
		extentSetUp();

		if (isMasterClassRun) {

			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {
				try {
					Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has started." + "</mark>");
					javaMain.JOL.fawri.JOL_FAWRI_COMPLAINT_MANAGEMENT.JOL_FAWRI_COMPLAINT_MANAGEMENT_Func(TCName, scenarioCount, dataset);
					Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

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
				Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has started." + "</mark>");
				javaMain.JOL.fawri.JOL_FAWRI_COMPLAINT_MANAGEMENT.JOL_FAWRI_COMPLAINT_MANAGEMENT_Func(TCName, scenarioCount, dataset);
				Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

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
