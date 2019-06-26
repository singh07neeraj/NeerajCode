package javaTestCases.eCorp.accounts;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import javaMain.eCorp.accounts.eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES;

public class eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES_TEST extends TestBase

{
	
	@Test
	public void eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES() {

		TCName = "eCorp Account - Report Lost Stolen Cheques";
		extentSetUp();
		
		if(true) {
			
			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {
	
				
			try {
				eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES.JOLACCOUNTREPORTLOSTSTOLENCHEQUES(TCName,scenarioCount,dataset);
				Log.pass("<mark>"+ TCName + " : Scenario -> " + scenarioCount + " has passed."+"</mark>");

			} catch (Exception e) {

				Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
			}

		}
		
		}
		
		else {
			
			for (scenarioCount = 1; scenarioCount <= dataset.length; scenarioCount++) {
				
				try {
					eCorp_ACCOUNT_REPORT_LOST_STOLEN_CHEQUES.JOLACCOUNTREPORTLOSTSTOLENCHEQUES(TCName,scenarioCount,dataset);
					Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

				} catch (Exception e) {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
				}

			}
			
			
			
			
		}
		
	}

	
}
