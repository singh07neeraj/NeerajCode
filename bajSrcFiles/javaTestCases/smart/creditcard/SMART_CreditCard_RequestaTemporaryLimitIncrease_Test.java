package javaTestCases.smart.creditcard;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;


public class SMART_CreditCard_RequestaTemporaryLimitIncrease_Test extends TestBase{


	@Test
	public void RequestaTemporaryLimitIncrease(){
		
		TCName = "Smart Credit Cards - Request a Temporary Limit Increase";
		extentSetUp();
		
		if(true) {
			
			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {
			try {
				javaMain.smart.creditcard.SMART_CreditCard_RequestaTemporaryLimitIncrease_Func.RequestaTemporaryLimitIncrease(TCName,scenarioCount,dataset);
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
					javaMain.smart.creditcard.SMART_CreditCard_RequestaTemporaryLimitIncrease_Func.RequestaTemporaryLimitIncrease(TCName,scenarioCount,dataset);
					Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

				} catch (AssertionError | Exception e)  {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
				}

			}
			
			
			
			
		}
		
	}


}
