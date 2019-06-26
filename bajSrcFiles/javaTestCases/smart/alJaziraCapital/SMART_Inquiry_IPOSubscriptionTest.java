package javaTestCases.smart.alJaziraCapital;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;

public class SMART_Inquiry_IPOSubscriptionTest extends TestBase{

	

	@Test
	public void SMART_alJaziraCapital_Inquiry_IPOSubscription(){
		
		TCName = "Smart alJaziraCapital - Inquiry IPO Subscription";
		extentSetUp();
		
		if(isMasterClassRun) {
			
			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {
			try {
				javaMain.smart.alJaziraCapital.SMART_Inquiry_IPOSubscription.alJaziraCapitalInquiryIPOSubscription(TCName,scenarioCount,dataset);
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
					javaMain.smart.alJaziraCapital.SMART_Inquiry_IPOSubscription.alJaziraCapitalInquiryIPOSubscription(TCName,scenarioCount,dataset);
					Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

				} catch (AssertionError | Exception e)  {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
				}

			}
			
			
			
			
		}
		
	}



}
