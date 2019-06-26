package javaTestCases.eCorp.accounts;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import javaMain.eCorp.accounts.eCorp_ACCOUNTS_eCorp_OrderCheckBook;

public class eCorp_ACCOUNTS_ORDERCHECKBOOK_Test  extends TestBase {


	
	@Test
	public void JOL_ACCOUNTS_ORDERCHECKBOOK() {

		TCName = "eCorp Account - OrderChechBook";
		extentSetUp();
		
		if(true) {
			// RowCount(TCName)
			for (scenarioCount = 1; scenarioCount <=RowCount(TCName); scenarioCount++) {
				
			
			try {
				eCorp_ACCOUNTS_eCorp_OrderCheckBook.eCorp_ACCOUNTS_eCorp_OrderCheckBook_Func(TCName,scenarioCount,dataset);
				Log.pass("<mark>"+ TCName + " : Scenario -> " + scenarioCount + " has passed."+"</mark>");

			} catch (Exception e) {

				Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
			}

		}
		
		}
		
		else {
			
			for (scenarioCount = 1; scenarioCount <= dataset.length; scenarioCount++) {
				
				try {
					eCorp_ACCOUNTS_eCorp_OrderCheckBook.eCorp_ACCOUNTS_eCorp_OrderCheckBook_Func(TCName,scenarioCount,dataset);
					Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

				} catch (Exception e) {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
				}

			}
			
			
			
			
		}
		
	}

}
