package javaTestCases.smart.fawri;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import static Utilities.ReadData.*;
import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;

public class SMART_Fawri_TransferHistoryTest extends TestBase{


	@Test
	public void SMART_Fawri_TransferHistory(){
		
		TCName = "Smart Fawri - transfer history";
		extentSetUp();
		
		if(true) {
			
			//for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {
				
			for (scenarioCount = 2; scenarioCount <= 2; scenarioCount++) {
			try {
				javaMain.smart.fawri.SMART_Fawri_TransferHistory.fawriTransferHistory(TCName,scenarioCount,dataset);
				Log.pass("<mark>"+ TCName + " : Scenario -> " + scenarioCount + " has passed."+"</mark>");

			} catch (AssertionError | Exception e)  {

				Utils.pressEscapeKey(3);
				Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
			}

		}
		
		}
		
		else {
			
			for (scenarioCount = 1; scenarioCount <= dataset.length; scenarioCount++) {
				
				try {
					javaMain.smart.fawri.SMART_Fawri_TransferHistory.fawriTransferHistory(TCName,scenarioCount,dataset);
					Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

				} catch (AssertionError | Exception e)  {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
				}

			}
			
			
			
			
		}
		
	}


}
