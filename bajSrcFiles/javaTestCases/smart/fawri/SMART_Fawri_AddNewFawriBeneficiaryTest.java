package javaTestCases.smart.fawri;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;
import static Utilities.ReadData.RowCount;
import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.smart.fawri.SMART_Fawri_AddNewFawriBeneficiary_Func;

public class SMART_Fawri_AddNewFawriBeneficiaryTest extends TestBase {

	@Test
	public void SMART_Fawri_AddNewFawriBeneficiary() {

		TCName = "Smart Fawri - Add New fawri Beneficiary";
		extentSetUp();

		if (isMasterClassRun) {

			 for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {

		//	for (scenarioCount = 1; scenarioCount <= 1; scenarioCount++) {
				try {
					SMART_Fawri_AddNewFawriBeneficiary_Func.SMART_Fawri_AddNewFawriBeneficiary(TCName, scenarioCount, dataset);
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
					SMART_Fawri_AddNewFawriBeneficiary_Func.SMART_Fawri_AddNewFawriBeneficiary(TCName, scenarioCount, dataset);
					Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

				} catch (AssertionError | Exception e) {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.." + ExceptionUtils.getStackTrace(e).trim());
				}

			}

		}

	}

}
