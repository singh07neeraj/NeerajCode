package javaTestCases.eCorp.accounts;


import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import javaMain.eCorp.accounts.eCorp_ACCOUNT_REQUEST_STEMENT_BYMAIL_FUNC;


public class eCorp_ACCOUNT_REQUEST_STEMENT_BYMAIL_TEST extends TestBase

{
	@Test
	public void JOL_ACCOUNT_REQUEST_STEMENT_BYMAIL() {

		TCName = "eCorp Account - Request Statement By Mail";
		extentSetUp();
		
		
		if(true) {
			
			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {
	

			try {
				eCorp_ACCOUNT_REQUEST_STEMENT_BYMAIL_FUNC.eCorpaccountemail(TCName,scenarioCount,dataset);
				Log.pass("<mark>"+ TCName + " : Scenario -> " + scenarioCount + " has passed."+"</mark>");

			} catch (Exception e) {

				Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
			}

		}
		
		}
		
		else {
			
			for (scenarioCount = 1; scenarioCount <= dataset.length; scenarioCount++) {
				
				try {
					eCorp_ACCOUNT_REQUEST_STEMENT_BYMAIL_FUNC.eCorpaccountemail(TCName,scenarioCount,dataset);
					Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

				} catch (Exception e) {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
				}

			}
			
			
			
			
		}
		
	}

}
