package javaTestCases.JOL.SADAD;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;


public class JOL_SADAD_FAQ_Test extends TestBase {
	
	


	@Test
	public void JOL_SADAD_FAQ() {

		TCName = "JOL Sadad - FAQ";
		extentSetUp();
		
		if(isMasterClassRun) {
			
			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {
	

			try {
				Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has started." + "</mark>");
				javaMain.JOL.SADAD.JOL_SADAD_FAQ.JOL_SADAD_FAQ_Func(TCName,scenarioCount,dataset);
				Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

			} catch (AssertionError | Exception e) {

				Utils.pressEscapeKey(4);
				Utils.refreshScreeen();
				Utils.logFailImage(TCName + " " + scenarioCount + "failed");
				Log.fail("<mark style='background-color: white; color: red;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has failed." + "</mark>" + System.lineSeparator() + ExceptionUtils.getStackTrace(e).trim());
			}

		}
		
		}
		
		else {
			
		//	for (scenarioCount = 1; scenarioCount <= dataset.length; scenarioCount++) {
				
				try {
					Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has started." + "</mark>");
					javaMain.JOL.SADAD.JOL_SADAD_FAQ.JOL_SADAD_FAQ_Func(TCName,scenarioCount,dataset);
					Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

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
