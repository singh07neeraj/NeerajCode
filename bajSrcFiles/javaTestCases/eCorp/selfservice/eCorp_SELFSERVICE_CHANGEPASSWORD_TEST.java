package javaTestCases.eCorp.selfservice;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import javaMain.eCorp.selfservice.eCorp_SELFSERVICE_CHANGEPASSWORD_FUNC;

public class eCorp_SELFSERVICE_CHANGEPASSWORD_TEST extends TestBase{
	
	@Test
	public void JOL_SELFSERVICE_ChangePassword() {

		TCName = "eCorp Self Service-Change Password";
		extentSetUp();
		
		if(true) {
			
			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {
	
				
			try {
				eCorp_SELFSERVICE_CHANGEPASSWORD_FUNC.changepassword(TCName,scenarioCount,dataset);
				Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

			} catch (Exception e) {

				
				Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
			}

		}
		
		}
		
		else {
			
		//	for (scenarioCount = 1; scenarioCount <= 1;) {
				
				try {
					eCorp_SELFSERVICE_CHANGEPASSWORD_FUNC.changepassword(TCName,scenarioCount,dataset);
					Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

				} catch (Exception e) {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
				}

		//	}
			
			
		}
		
	}
}
