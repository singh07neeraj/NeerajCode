package javaMain.smart.govtPayments;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenMenuesSmart;

public class SMART_Govtpayments_Payment extends TestBase{

	public static String Provider,Service,CurrentOwnerID,VehicleSeqNumber;

	public static boolean Govtpayments_Payment(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				
				Provider = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Provider"));
				Service = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Service"));
				CurrentOwnerID = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CurrentOwnerID"));
				VehicleSeqNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "VehicleSeqNumber"));
				
				

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				
				Provider = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Provider"));
				Service = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Service"));
				CurrentOwnerID = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CurrentOwnerID"));
				VehicleSeqNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("VehicleSeqNumber"));
						
				

			}
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			OpenMenuesSmart.GovernmentServiceMenu("GPayment");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

					
						
			Provider = "//p[contains(text(),'" + Provider + "')]";
			Utils.click_Smart(By.xpath(Provider), "Click on Provider Type");
			Utils.wait(3);
			Service = "//p[contains(text(),'" + Service + "')]";
			Utils.click_Smart(By.xpath(Service), "Click on Service Type");
			Utils.wait(3);
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "CurrentOwner_ID", "SMART_GOVTPAYMENTS_PAYMENT")), CurrentOwnerID, "Current Owner ID text box");
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "Vehicle_SeqNumber", "SMART_GOVTPAYMENTS_PAYMENT")), VehicleSeqNumber, "Vehicle Sequence Number text box");
			
			Utils.click_Smart(By.xpath(getObj("Propval1", "Inquiry_btn", "SMART_GOVTPAYMENTS_PAYMENT")), "Inquiry button");
			
			Utils.wait(10);
			try {
				Assert.assertFalse(Utils.assertDisplayed_Smart(By.xpath(getObj("Propval1", "Error_msg", "SMART_GOVTPAYMENTS_PAYMENT")), "Error message"));
				
				Log.pass("Error not displayed....continue to next step");
				Utils.logPassImage("   Error not displayed-pass");
				

			} catch (AssertionError | Exception e) {
				
				Log.fail(" Unknown error displayed on screen. Message displayed is : " + Utils.getText_Smart(By.xpath(getObj("Propval1", "Error_msg", "SMART_GOVTPAYMENTS_PAYMENT"))));
				Utils.logFailImage("   Unknown error displayed on screen-fail");
				Utils.click_Smart(By.xpath(getObj("Propval1", "AcceptAlert_btn", "SMART_GOVTPAYMENTS_PAYMENT")), "AcceptAlert button");
				
				
				throw e;

			}
			

		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
