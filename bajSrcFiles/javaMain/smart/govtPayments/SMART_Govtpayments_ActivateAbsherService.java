package javaMain.smart.govtPayments;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenMenuesSmart;

public class SMART_Govtpayments_ActivateAbsherService extends TestBase{

	public static String MobileNumber,LanguageType;

	public static boolean Govtpayments_ActivateAbsherService(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				
				MobileNumber=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "MobileNumber"));
				LanguageType=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "LanguageType"));
				
				
				

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				
				MobileNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("MobileNumber"));
				LanguageType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("LanguageType"));
				
						
				

			}
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			OpenMenuesSmart.GovernmentServiceMenu("Active_Absher");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "MobileNumber_txt", "SMART_GOVTPAYMENTS_ACTIVEABSHER")), MobileNumber, "MobileNumber text box");
			Utils.click_Smart(By.xpath(getObj("Propval1", "Language_lnk", "SMART_GOVTPAYMENTS_ACTIVEABSHER")), "Language tab");
			Utils.wait(5);
			LanguageType = "//p[contains(text(),'" + LanguageType + "')]";
			Utils.click_Smart(By.xpath(LanguageType), "Click on Language Type");
			

			// Click on Proceed Button//
			Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "SMART_FAWRI_MONEY_TRANSFER")), "Proceed Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			// Click on Confirm Button//
			Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "SMART_FAWRI_MONEY_TRANSFER")), "Confirm Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			
			// Enter OTP//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "OTP", "SMART_FAWRI_MONEY_TRANSFER")), ReadData.readConfigXml("OTP"), "OTP Entered");

			// Click on OTP Proceed//
			Utils.click(By.xpath(getObj("Propval1", "OTPProceedBtn", "SMART_FAWRI_MONEY_TRANSFER")), "Proceed Button after entering OTP");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			
			// Error message found on screen, not able to code from here
			

		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
