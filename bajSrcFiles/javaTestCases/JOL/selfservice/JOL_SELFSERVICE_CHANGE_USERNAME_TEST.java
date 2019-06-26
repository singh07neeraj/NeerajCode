package javaTestCases.JOL.selfservice;

import Utilities.Log;
import Utilities.TestBase;
import javaMain.JOL.selfservice.JOL_SELFSERVICE_CHANGE_USERNAME_FUNC;
import static Utilities.ReadData.*;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

public class JOL_SELFSERVICE_CHANGE_USERNAME_TEST extends TestBase

{

	@Test
	public void JOL_SELFSERVICE_MESSAGE_BOX_Audit() {

		TCName = "JOL Self Service-Change UserName";
		extentSetUp();

		if (isMasterClassRun) {

			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {

				try {
					JOL_SELFSERVICE_CHANGE_USERNAME_FUNC.changeusername(TCName, scenarioCount, dataset);
					Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

				} catch (Exception e) {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.." + ExceptionUtils.getStackTrace(e).trim());
				}

			}

		}

		else {

			// for (scenarioCount = 1; scenarioCount <= 1; ) {

			try {
				JOL_SELFSERVICE_CHANGE_USERNAME_FUNC.changeusername(TCName, scenarioCount, dataset);
				Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

			} catch (Exception e) {

				Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.." + ExceptionUtils.getStackTrace(e).trim());
			}

			// }

		}

	}
}
