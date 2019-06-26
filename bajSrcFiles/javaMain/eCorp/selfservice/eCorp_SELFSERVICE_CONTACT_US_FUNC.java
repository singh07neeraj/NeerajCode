package javaMain.eCorp.selfservice;

import static Utilities.ReadData.getObj;

import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_SELFSERVICE_CONTACT_US_FUNC extends TestBase {

	public static Boolean ContactUs(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			Utils.click(By.xpath(getObj("Propval1", "SelfServices", "eCorp_SELFSERVICE_CONTACT_US")), "Self Services");
			Utils.click(By.xpath(getObj("Propval1", "Contactus", "eCorp_SELFSERVICE_CONTACT_US")), "Contact us");

			// Verify landing page
			String Balance = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "JOL_SELFSERVICE_CUSTOMERPROFILE")));

			Log.pass("Landed Page is  :" + Balance);

			// Page Validation

			String email = Utils.getText(By.xpath(getObj("Propval1", "email", "eCorp_SELFSERVICE_CONTACT_US")));
			if (email == null) {
				Log.error("Contact Us Page is not displayed.........." + email);
			} else {
				Log.pass("Contact Page displayed.................." + email);
				Log.pass("Email value displayed on page is :" + Utils.getText(By.xpath("//*[contains(@href,'mailto:')]")));
			}
			
			Utils.click(By.xpath(getObj("Propval1", "relationshipManager", "eCorp_SELFSERVICE_CONTACT_US")), "Relationship Manager");

			Utils.logPassImage(TCName);
			
		}

		catch (Exception e) {
			runResult = false;
			e.printStackTrace();

			return runResult;
		}
		return runResult;
	}

}
