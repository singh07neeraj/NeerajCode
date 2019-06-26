package javaTestCases.eCorp.PointOfSales;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.eCorp.PointOfSales.eCorp_POINTOFSALES_REQUESTNEWPOS_FUNC;

public class eCorp_POINTOFSALES_REQUESTNEWPOS_TEST extends TestBase

{

	@Test
	public void POSSettlementStatement () {

		TCName = "eCorp Point Of Sales-Request New POS";
		extentSetUp();
		if (true) {
//
			for (scenarioCount = 1; scenarioCount <= RowCount(TCName) ; scenarioCount++) {
				
				try {
					
					eCorp_POINTOFSALES_REQUESTNEWPOS_FUNC.REQUESTNEWPOS(TCName,
							scenarioCount, dataset);
					Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName
							+ " : Scenario -> " + scenarioCount + " has passed." + "</mark>");
					
				} catch (AssertionError | Exception e) {

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
				eCorp_POINTOFSALES_REQUESTNEWPOS_FUNC.REQUESTNEWPOS(TCName,
						scenarioCount, dataset);
				Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName
						+ " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

			} catch (AssertionError | Exception e) {

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
