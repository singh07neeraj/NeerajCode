package javaTestCases.JOL.creditcards;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.JOL.creditcards.JOL_CREDIT_CARDS_RequestASupplementaryCard_FUNC;

public class Jol_CreditCards_RequestASupplementaryCard_Test extends TestBase

{

	@SuppressWarnings("unused")
	@Test
	public void JOL_CREDIT_CARDS_RequestASupplementaryCard() {

		TCName = "JOL Credit Cards-Request Supplementary Card";
		extentSetUp();
		if (isMasterClassRun) {
			
			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {
				try {
					Log.info("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has started." + "</mark>");
					JOL_CREDIT_CARDS_RequestASupplementaryCard_FUNC.RequestASupplementaryCard(TCName, scenarioCount, dataset);
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
				Log.info("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has started." + "</mark>");
				JOL_CREDIT_CARDS_RequestASupplementaryCard_FUNC.RequestASupplementaryCard(TCName, scenarioCount, dataset);
				Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

			} catch (AssertionError | Exception e) {

				Utils.pressEscapeKey(4);
				Utils.refreshScreeen();
				Utils.logFailImage(TCName + " " + scenarioCount + "failed");
				Log.fail("<mark style='background-color: white; color: red;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has failed." + "</mark>" + System.lineSeparator() + ExceptionUtils.getStackTrace(e).trim());
			}

		}

		// }

	}

}
