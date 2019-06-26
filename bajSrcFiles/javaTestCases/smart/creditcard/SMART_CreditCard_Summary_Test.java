package javaTestCases.smart.creditcard;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;

public class SMART_CreditCard_Summary_Test extends TestBase {

	@Test
	public void SMART_Fawri_AddNewFawriBeneficiary() {

		TCName = "Smart Credit Cards - Credit Cards Summary";
		extentSetUp();

		if (isMasterClassRun) {

			for (scenarioCount = 1; scenarioCount <= 1; scenarioCount++) {
				try {
					javaMain.smart.creditcard.SMART_CreditCard_Summary_Func.CreditCardsSummary(TCName, scenarioCount, dataset);
					Log.pass("<mark>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

				} catch (AssertionError | Exception e) {

					Utils.pressEscapeKey(3);
					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.." + ExceptionUtils.getStackTrace(e).trim());
				}

			}

		}

		else {

			for (scenarioCount = 1; scenarioCount <= dataset.length; scenarioCount++) {

				try {
					javaMain.smart.creditcard.SMART_CreditCard_Summary_Func.CreditCardsSummary(TCName, scenarioCount, dataset);
					Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

				} catch (AssertionError | Exception e) {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.." + ExceptionUtils.getStackTrace(e).trim());
				}

			}

		}

	}

}
