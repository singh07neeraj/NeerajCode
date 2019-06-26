package javaTestCases.eCorp.accounts;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import javaMain.eCorp.accounts.eCorp_ACCOUNTS_DEAILS_FUNC;

public class eCorp_ACCOUNTS_DEAILS_TEST extends TestBase

{

	@Test
	public void JOL_ACCOUNTS_DEAILS_INQUIRY() {

		TCName = "eCorp Account - Details";
		extentSetUp();

		if (true) {

			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {

				try {
					eCorp_ACCOUNTS_DEAILS_FUNC.eCorpAccountDetails(TCName, scenarioCount, dataset);
					Log.pass("<mark>"+ TCName + " : Scenario -> " + scenarioCount + " has passed."+"</mark>");

				} catch (Exception e) {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.." + ExceptionUtils.getStackTrace(e).trim());
				}

			}

		}

		else {

			for (scenarioCount = 1; scenarioCount <= dataset.length; scenarioCount++) {

				try {
					eCorp_ACCOUNTS_DEAILS_FUNC.eCorpAccountDetails(TCName, scenarioCount, dataset);
					Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

				} catch (Exception e) {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.." + ExceptionUtils.getStackTrace(e).trim());
				}

			}

		}

	}

}
