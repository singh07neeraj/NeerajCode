package javaTestCases.eCorp.PointOfSales;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.eCorp.PointOfSales.eCorp_POINTOFSALES_POSSETTLEMENTSTATEMENT_DETAILS_FUNC;

public class eCorp_POINTOFSALES_POSSETTLEMENTSTATEMENT_DETAILS_TEST extends TestBase

{

	@Test
	public void POSSettlementStatementDetails  () {

		TCName = "eCorp Point Of Sales-POS Settlement Statement Details";
		extentSetUp();
		if (true) {
//
			for (scenarioCount = 1; scenarioCount <=RowCount(TCName) ; scenarioCount++) {
				
				try {
					
					eCorp_POINTOFSALES_POSSETTLEMENTSTATEMENT_DETAILS_FUNC.POSSettlementStatementDetails(TCName,
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
				eCorp_POINTOFSALES_POSSETTLEMENTSTATEMENT_DETAILS_FUNC.POSSettlementStatementDetails(TCName,
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
