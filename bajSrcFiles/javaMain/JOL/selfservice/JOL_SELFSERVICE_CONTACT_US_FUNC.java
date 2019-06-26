package javaMain.JOL.selfservice;

import static Utilities.ReadData.getObj;

import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenJOLMenues;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_SELFSERVICE_CONTACT_US_FUNC extends TestBase {

	public static Boolean ContactUs(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			OpenJOLMenues.openSelfServicesMenu("Contactus");

			// Verify landing page
			String Balance = Utils.getTextNoException(By.xpath(getObj("Propval1", "LandPage", "JOL_SELFSERVICE_CUSTOMERPROFILE")));

			Log.pass("Landed Page is  :" + Balance);

			// Page Validation
			String email = Utils.getTextNoException(By.xpath(getObj("Propval1", "email", "JOL_SELFSERVICE_CONTACT_US")));

			if (email == null) {
				Log.error("Contact Us Page is not displayed.........." + email);
				Utils.logFailImage("Self Service- Contact Us");

			} else {
				Log.pass("Contact Page displayed.................." + email);
				Log.pass("Email value displayed on page is : " + Utils.getTextNoException(By.xpath("//*[contains(@href,'mailto:')]")));
				Utils.logPassImage("Landing Page");
			}

		}

		catch (Exception e) {
			throw e;
		}
		return runResult;
	}

}
