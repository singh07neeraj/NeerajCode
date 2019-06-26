package javaTestCases.smart.fawri;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import static Utilities.ReadData.*;
import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.smart.fawri.SMART_Fawri_AddNewFawriBeneficiary_Func;

public class SMART_Fawri_MoneyTransferTest extends TestBase{


	@Test
	public void SMART_Fawri_MoneyTransfer(){
		
		TCName = "Smart Fawri - fawri money transfer";
		extentSetUp();
		
		if(true) {
			
			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {
				
			//for (scenarioCount = 4; scenarioCount <= 4; scenarioCount++) {
			try {
				javaMain.smart.fawri.SMART_Fawri_MoneyTransfer.fawriMoneyTransfer(TCName,scenarioCount,dataset);
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
					javaMain.smart.fawri.SMART_Fawri_MoneyTransfer.fawriMoneyTransfer(TCName,scenarioCount,dataset);
					Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

				} catch (AssertionError | Exception e)  {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
				}

			}
			
			
			
			
		}
		
	}


}
