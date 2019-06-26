package javaMain.JOL.fawri;

import static Utilities.ReadData.getObj;

import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;

public class JOL_FAWRI_REGISTRATION_PROFILE extends TestBase {

	public static Boolean JOL_FAWRI_REGISTRATION_PROFILE_Func(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		try {

			// Click on Fawri Tab//
			Utils.click(By.xpath(getObj("Propval1", "FawriLnk", "FawriRegistrationProfile")), "Fawri Tab");
			// Click Fawri Management Link on the left Panel//
			Utils.click(By.xpath(getObj("Propval1", "FawriManagementLnk", "FawriRegistrationProfile")), "FawriManagementLnk");

			Log.pass(" Message displayed on screen is : " + Utils.getTextNoException(By.xpath("//*[@class='alert-txt']")));

			// Click Fawri Registration Profile on the left Panel//
			Utils.click(By.xpath(getObj("Propval1", "FawriRegistrationProfile_Menu_Y", "FawriRegistrationProfile")), "Fawri Registration Profile");

			String LandingPage = Utils.getTextNoException(By.xpath(getObj("Propval1", "RegistrationProfileHeading", "FawriRegistrationProfile")));
			int x = Utils.getSizeNoException(By.xpath(getObj("Propval1", "RegistrationProfileHeading", "FawriRegistrationProfile")));
			if (x > 0) {
				Log.pass("Landing Page is displayed and the name of the Landing Page is " + LandingPage);
			} else {
				Log.fail("Landing Page name is not displayed");
			}

			String ProfileExpiry = Utils.getTextNoException(By.xpath(getObj("Propval1", "ProfileExpiry", "FawriRegistrationProfile")));
			x = Utils.getSizeNoException(By.xpath(getObj("Propval1", "ProfileExpiry", "FawriRegistrationProfile")));
			if (x > 0) {
				Log.pass("Profile Expiry is displayed and the value is " + ProfileExpiry);
			} else {
				Log.fail("ProfileExpiry is not displayed");
			}

			String Title = Utils.getTextNoException(By.xpath(getObj("Propval1", "Title", "FawriRegistrationProfile")));
			x = Utils.getSizeNoException(By.xpath(getObj("Propval1", "Title", "FawriRegistrationProfile")));
			if (x > 0) {
				Log.pass("Title is displayed and the value is " + Title);
			} else {
				Log.fail("Title is not displayed");
			}

			String FirstName = Utils.getTextNoException(By.xpath(getObj("Propval1", "FirstName", "FawriRegistrationProfile")));
			x = Utils.getSizeNoException(By.xpath(getObj("Propval1", "FirstName", "FawriRegistrationProfile")));
			if (x > 0) {
				Log.pass("FirstName is displayed and the value is  " + FirstName);
			} else {
				Log.fail("FirstName is not displayed");
			}

			String FatherName = Utils.getTextNoException(By.xpath(getObj("Propval1", "FatherName", "FawriRegistrationProfile")));
			x = Utils.getSizeNoException(By.xpath(getObj("Propval1", "FatherName", "FawriRegistrationProfile")));
			if (x > 0) {
				Log.pass("FatherName is displayed and the value is  " + FatherName);
			} else {
				Log.fail("FatherName is not displayed");
			}

			String FamilyName = Utils.getTextNoException(By.xpath(getObj("Propval1", "FamilyName", "FawriRegistrationProfile")));
			x = Utils.getSizeNoException(By.xpath(getObj("Propval1", "FamilyName", "FawriRegistrationProfile")));
			if (x > 0) {
				Log.pass("FamilyName is displayed and the value is  " + FamilyName);
			} else {
				Log.fail("FamilyName is not displayed");
			}

			String Nationality = Utils.getTextNoException(By.xpath(getObj("Propval1", "Nationality", "FawriRegistrationProfile")));
			x = Utils.getSizeNoException(By.xpath(getObj("Propval1", "Nationality", "FawriRegistrationProfile")));
			if (x > 0) {
				Log.pass("Nationality is displayed and the value is  " + Nationality);
			} else {
				Log.fail("Nationality is not displayed");
			}

			String DateOfBirth = Utils.getTextNoException(By.xpath(getObj("Propval1", "DateOfBirth", "FawriRegistrationProfile")));
			x = Utils.getSizeNoException(By.xpath(getObj("Propval1", "DateOfBirth", "FawriRegistrationProfile")));
			if (x > 0) {
				Log.pass("DateOfBirth is displayed and the value is  " + DateOfBirth);
			} else {
				Log.fail("DateOfBirth is not displayed");
			}

			String ID = Utils.getTextNoException(By.xpath(getObj("Propval1", "ID", "FawriRegistrationProfile")));
			x = Utils.getSizeNoException(By.xpath(getObj("Propval1", "ID", "FawriRegistrationProfile")));
			if (x > 0) {
				Log.pass("ID is displayed and the value is  " + ID);
			} else {
				Log.fail("ID is not displayed");
			}

			String IDExpiryDate = Utils.getTextNoException(By.xpath(getObj("Propval1", "IDExpiryDate", "FawriRegistrationProfile")));
			x = Utils.getSizeNoException(By.xpath(getObj("Propval1", "IDExpiryDate", "FawriRegistrationProfile")));
			if (x > 0) {
				Log.pass("IDExpiryDate is displayed and the value is  " + IDExpiryDate);
			} else {
				Log.fail("IDExpiryDate is not displayed");
			}

		} catch (Exception e) {
			throw e;
		}

		return runResult;

	}

}
