package javaTestCases.JOL.selfservice;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import javaMain.JOL.selfservice.JOL_SELFSERVICE_CHANGEPASSWORD_FUNC;

public class JOL_SELFSERVICE_CHANGEPASSWORD_TEST extends TestBase{
	
	@Test
	public void JOL_SELFSERVICE_ChangePassword() {

		TCName = "JOL Self Service-Change Password";
		extentSetUp();
		
		if(isMasterClassRun) {
			
			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {
				
			try {
				Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has started." + "</mark>");
				JOL_SELFSERVICE_CHANGEPASSWORD_FUNC.changepassword(TCName,scenarioCount,dataset);
				Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

			} catch (AssertionError | Exception e) {

				Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
			}

		}
		
		}
		
		else {
			
		//	for (scenarioCount = 1; scenarioCount <= 1;) {
				
				try {
					Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has started." + "</mark>");
					JOL_SELFSERVICE_CHANGEPASSWORD_FUNC.changepassword(TCName,scenarioCount,dataset);
					Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

				} catch (AssertionError | Exception e) {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
				}

		//	}
			
			
		}
		
	}
}
