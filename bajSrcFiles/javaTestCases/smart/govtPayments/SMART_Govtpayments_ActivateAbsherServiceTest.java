package javaTestCases.smart.govtPayments;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;

public class SMART_Govtpayments_ActivateAbsherServiceTest extends TestBase{
	

	@Test
	public void SMART_Govtpayments_ActivateAbsherService(){
		
		TCName = "Smart GovtPayments - Activate Absher Service";
		extentSetUp();
		
		if(isMasterClassRun) {
			
			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {
				
			//for (scenarioCount = 3; scenarioCount <= 3; scenarioCount++) {
			try {
				javaMain.smart.govtPayments.SMART_Govtpayments_ActivateAbsherService.Govtpayments_ActivateAbsherService(TCName,scenarioCount,dataset);
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
					javaMain.smart.govtPayments.SMART_Govtpayments_ActivateAbsherService.Govtpayments_ActivateAbsherService(TCName,scenarioCount,dataset);
					Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

				} catch (AssertionError | Exception e)  {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
				}

			}
			
			
			
			
		}
		
	}



}
