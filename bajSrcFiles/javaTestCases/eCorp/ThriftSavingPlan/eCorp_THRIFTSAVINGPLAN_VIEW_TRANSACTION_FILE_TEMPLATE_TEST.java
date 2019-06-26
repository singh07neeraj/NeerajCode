package javaTestCases.eCorp.ThriftSavingPlan;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.eCorp.ThriftSavingPlan.eCorp_THRIFTSAVINGPLAN_VIEW_TRANSACTION_FILE_TEMPLATE_FUNC;

public class eCorp_THRIFTSAVINGPLAN_VIEW_TRANSACTION_FILE_TEMPLATE_TEST extends TestBase

{

	@Test
	public void ViewContributorFileTemplate() {

		TCName = "eCorp Thrift Saving Plan-View Transaction File Template";
		extentSetUp();

		if (isMasterClassRun) {

			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {

				try {
					eCorp_THRIFTSAVINGPLAN_VIEW_TRANSACTION_FILE_TEMPLATE_FUNC.ViewTransactionFileTemplate(TCName, scenarioCount, dataset);
					Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

				} catch (Exception e) {


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
					eCorp_THRIFTSAVINGPLAN_VIEW_TRANSACTION_FILE_TEMPLATE_FUNC.ViewTransactionFileTemplate(TCName, scenarioCount, dataset);
					Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

				} catch (Exception e) {


					Utils.pressEscapeKey(4);
					Utils.refreshScreeen();
					Utils.logFailImage(TCName + " " + scenarioCount + "failed");
					Log.fail("<mark style='background-color: white; color: red;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has failed." + "</mark>" + System.lineSeparator() + ExceptionUtils.getStackTrace(e).trim());

				}

		//	}

		}

	}
}
