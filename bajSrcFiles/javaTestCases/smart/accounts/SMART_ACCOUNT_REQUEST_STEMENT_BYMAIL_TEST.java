package javaTestCases.smart.accounts;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import javaMain.JOL.accounts.JOL_ACCOUNT_REQUEST_STEMENT_BYMAIL_FUNC;
import javaMain.smart.accounts.SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL_FUNC;

public class SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL_TEST extends TestBase{
	@Test
	public void SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL() {

		TCName = "SMART Account - Request Statement By Mail";
		extentSetUp();
		
		//if(isMasterClassRun) {
		if(isMasterClassRun) {
			
			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {
	
			//for (scenarioCount = 4; scenarioCount <= 4; scenarioCount++) {
					
			try {
				SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL_FUNC.smartaccountemail(TCName,scenarioCount,dataset);
				Log.pass("<mark>"+ TCName + " : Scenario -> " + scenarioCount + " has passed."+"</mark>");

			}catch (AssertionError | Exception e)  {

				Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
			}

		}
		
		}
		
		else {
			
			for (scenarioCount = 1; scenarioCount <= dataset.length; scenarioCount++) {
				
				try {
					SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL_FUNC.smartaccountemail(TCName,scenarioCount,dataset);
					Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

				} catch (AssertionError | Exception e)  {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
				}

			}
			
			
			
			
		}
		
	}

}
