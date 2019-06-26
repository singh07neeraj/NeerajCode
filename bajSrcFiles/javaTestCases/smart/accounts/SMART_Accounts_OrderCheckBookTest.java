package javaTestCases.smart.accounts;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.smart.accounts.SMART_ACCOUNTS_REPORT_LOST_STOLENCHEQUES_FUNC;
import javaMain.smart.accounts.SMART_Accounts_OrderCheckBook_Func;

public class SMART_Accounts_OrderCheckBookTest extends TestBase{


	@Test
	public void SMART_Accounts_OrderCheckBook(){
		
		TCName = "Smart Account - Order check book";
		extentSetUp();
		
		if(true) {
			
			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {
				
			//for (scenarioCount = 1; scenarioCount <= 1; scenarioCount++) {
			try {
				SMART_Accounts_OrderCheckBook_Func.SmartAccountsOrderCheckBook(TCName,scenarioCount,dataset);
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
					SMART_Accounts_OrderCheckBook_Func.SmartAccountsOrderCheckBook(TCName,scenarioCount,dataset);
					Log.pass(TCName + " : Scenario -> " + scenarioCount + " has passed.");

				} catch (AssertionError | Exception e)  {

					Log.fail(TCName + " : Scenario -> " + scenarioCount + " has failed.."+ExceptionUtils.getStackTrace(e).trim());
				}

			}
			
			
			
			
		}
		
	}


}
