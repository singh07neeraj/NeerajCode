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

public class SMART_Govtpayments_PaymentRefund extends TestBase{

	public static String Provider,Service,CurrentOwnerID,VehicleSeqNumber,AccountNumber;

	public static boolean Govtpayments_PaymentRefund(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				
				Provider = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Provider"));
				Service = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Service"));
				CurrentOwnerID = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CurrentOwnerID"));
				VehicleSeqNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "VehicleSeqNumber"));
				AccountNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				
				

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				
				Provider = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Provider"));
				Service = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Service"));
				CurrentOwnerID = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CurrentOwnerID"));
				VehicleSeqNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("VehicleSeqNumber"));
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
						
				

			}
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			OpenMenuesSmart.GovernmentServiceMenu("Payments_Refund");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			
			
			Utils.click_Smart(By.xpath(getObj("Propval1", "Provider_lnk", "SMART_GOVTPAYMENTS_PAYMENT_REFUND")), "Provider tab");
			Utils.wait(3);					
			Provider = "//p[contains(text(),'" + Provider + "')]";
			Utils.click_Smart(By.xpath(Provider), "Click on Provider Type");
			Utils.wait(3);
			
			Service = "//p[contains(text(),'" + Service + "')]";
			Utils.click_Smart(By.xpath(Service), "Click on Service Type");
			Utils.wait(3);
			
			AccountNumber="//p[contains(text(),'"+AccountNumber+"')]";

			Utils.click_Smart(By.xpath(AccountNumber), "Click on Account Number");
			
			Utils.click_Smart(By.xpath(getObj("Propval1", "Search_btn", "SMART_GOVTPAYMENTS_PAYMENT_REFUND")), "Search button");
			
			Utils.wait(10);
			
			// No results found on screen, not able to code from here
			

		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
