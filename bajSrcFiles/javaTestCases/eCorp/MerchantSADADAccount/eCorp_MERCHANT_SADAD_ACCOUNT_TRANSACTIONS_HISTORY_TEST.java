package javaTestCases.eCorp.MerchantSADADAccount;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.eCorp.MerchantSADADAccount.eCorp_MERCHANT_SADAD_ACCOUNT_TRANSACTIONS_HISTORY_FUNC;

public class eCorp_MERCHANT_SADAD_ACCOUNT_TRANSACTIONS_HISTORY_TEST extends TestBase

{

	@Test
	public void PayrollFileTemplate() {

		TCName = "eCorp Merchant SADAD Account-Transactions History";
		extentSetUp();

		if (true) {

			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {
				
				try {
					eCorp_MERCHANT_SADAD_ACCOUNT_TRANSACTIONS_HISTORY_FUNC.TransactionsHistory(TCName, scenarioCount, dataset);
					Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

				} catch (AssertionError |Exception e) {
					

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
					eCorp_MERCHANT_SADAD_ACCOUNT_TRANSACTIONS_HISTORY_FUNC.TransactionsHistory(TCName, scenarioCount, dataset);
					Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

				} catch (AssertionError | Exception e) {


					Utils.pressEscapeKey(4);
					Utils.refreshScreeen();
					Utils.logFailImage(TCName + " " + scenarioCount + "failed");
					Log.fail("<mark style='background-color: white; color: red;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has failed." + "</mark>" + System.lineSeparator() + ExceptionUtils.getStackTrace(e).trim());

				}

		//	}

		}

	}
}
