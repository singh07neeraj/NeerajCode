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

public class SMART_Govtpayments_PaymentRefundHistory extends TestBase{

	public static String Provider,Service,Nickname;

	public static boolean Govtpayments_PaymentRefundHistory(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				
				Provider = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Provider"));
				Service = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Service"));
				Nickname = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Nickname"));
				

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				
				Provider = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Provider"));
				Service = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Service"));
				Nickname = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Nickname"));
						
				
			}
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			OpenMenuesSmart.GovernmentServiceMenu("Payment_Refunds_History");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			Utils.click_Smart(By.xpath(getObj("Propval1", "Provider_lnk", "SMART_GOVTPAYMENTS_PAYMENT_REFUND")), "Provider tab");
			Utils.wait(3);			
						
			Provider = "//p[contains(text(),'" + Provider + "')]";
			Utils.click_Smart(By.xpath(Provider), "Click on Provider Type");
			Utils.wait(3);
			Service = "//p[contains(text(),'" + Service + "')]";
			Utils.click_Smart(By.xpath(Service), "Click on Service Type");
			Utils.wait(3);
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "NickName_txt", "SMART_GOVTPAYMENTS_PAYMENT_REFUND_HISTORY")), Nickname, "Nickname text box");
			
			Utils.click_Smart(By.xpath(getObj("Propval1", "Search_btn", "SMART_GOVTPAYMENTS_PAYMENT_REFUND_HISTORY")), "Search button");
			
			Utils.wait(10);
			//no results found on the screen...not able to script...
			

		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
