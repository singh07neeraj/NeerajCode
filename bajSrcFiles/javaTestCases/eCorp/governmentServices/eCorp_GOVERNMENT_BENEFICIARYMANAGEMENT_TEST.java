package javaTestCases.eCorp.governmentServices;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;

public class eCorp_GOVERNMENT_BENEFICIARYMANAGEMENT_TEST extends TestBase

{

	
	
	@Test
	public void GOVERNMENT_BENEFICIARYMANAGEMENT() {


		TCName = "eCorp Government BeneficiaryMgmt";
		extentSetUp();

		if (true) {

			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {

				try {

					javaMain.eCorp.governmentServices.eCorp_GOVERNMENT_BENEFICIARYMANAGEMENT_FUNC.BeneficiaryManagement(TCName, scenarioCount, dataset);
					Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName
							+ " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

				} catch (AssertionError |Exception e) {

					Utils.pressEscapeKey(4);
					Utils.refreshScreeen();
					Utils.logFailImage(TCName + " " + scenarioCount + "failed");
					Log.fail("<mark style='background-color: white; color: red;font-weight:bold'>" + TCName
							+ " : Scenario -> " + scenarioCount + " has failed." + "</mark>" + System.lineSeparator()
							+ ExceptionUtils.getStackTrace(e).trim());
				}

			}
		}

		else {

			try {
				javaMain.eCorp.governmentServices.eCorp_GOVERNMENT_BENEFICIARYMANAGEMENT_FUNC.BeneficiaryManagement(TCName,
						scenarioCount, dataset);
				Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName
						+ " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

			} catch (AssertionError |Exception e) {

				Utils.pressEscapeKey(4);
				Utils.refreshScreeen();
				Utils.logFailImage(TCName + " " + scenarioCount + "failed");
				Log.fail("<mark style='background-color: white; color: red;font-weight:bold'>" + TCName
						+ " : Scenario -> " + scenarioCount + " has failed." + "</mark>" + System.lineSeparator()
						+ ExceptionUtils.getStackTrace(e).trim());
			}

		}

	
		

	

	}
}
