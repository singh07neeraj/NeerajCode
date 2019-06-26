package javaTestCases.JOL.fawri;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.JOL.fawri.JOL_FAWRI_MONEYTRANSFERS;


 public class JOL_FAWRI_MONEYTRANSFERS_TEST extends TestBase {
	
	
	
	@Test
	public void JOL_FAWRI_MONEYTRANSFERS() {

		TCName = "JOL Fawri - MoneyTransfers";
	    extentSetUp();
		
		if (isMasterClassRun) {
			
		
			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {
			
			try {
				Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has started." + "</mark>");
				JOL_FAWRI_MONEYTRANSFERS.JOL_FAWRI_MONEYTRANSFERS_functions(TCName, scenarioCount, dataset);
				Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

			} catch (AssertionError | Exception e)  {

				Utils.pressEscapeKey(4);
				Utils.refreshScreeen();
				Utils.logFailImage(TCName + " " + scenarioCount + "failed");
				Log.fail("<mark style='background-color: white; color: red;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has failed." + "</mark>" + System.lineSeparator() + ExceptionUtils.getStackTrace(e).trim());
			}
			}
		}

		else {

			try {
				Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has started." + "</mark>");
				JOL_FAWRI_MONEYTRANSFERS.JOL_FAWRI_MONEYTRANSFERS_functions(TCName, scenarioCount, dataset);
				Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

			}  catch (AssertionError | Exception e)  {

				Utils.pressEscapeKey(4);
				Utils.refreshScreeen();
				Utils.logFailImage(TCName + " " + scenarioCount + "failed");
				Log.fail("<mark style='background-color: white; color: red;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has failed." + "</mark>" + System.lineSeparator() + ExceptionUtils.getStackTrace(e).trim());
			}

			// }
		}
	}
}
