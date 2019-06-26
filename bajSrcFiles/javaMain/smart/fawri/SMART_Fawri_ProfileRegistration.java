package javaMain.smart.fawri;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static Utilities.ReadData.readConfigXml;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenMenuesSmart;

public class SMART_Fawri_ProfileRegistration extends TestBase{


	public static String AccountNumber, TransferVia, BeneficiaryType, AMOUNT, Category, Purpose, Purpose_Modify, PaymentDetails, Proceed, Confirm, OTPProceed, CancelYes, BeneficiaryActivationMode, TestType;

	public static boolean fawriProfileRegistration(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				// not started this test case
				
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AccountNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				TransferVia = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransferVia"));
				BeneficiaryType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryType"));
				AMOUNT = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AMOUNT"));

				Category = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Category"));
				Purpose = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Purpose"));
				Purpose_Modify = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Purpose_Modify"));
				PaymentDetails = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "PaymentDetails"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));

				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				CancelYes = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CancelYes"));
				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				TransferVia = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TransferVia"));
				BeneficiaryType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryType"));
				AMOUNT = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AMOUNT"));
				Category = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Category"));
				Purpose = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Purpose"));
				Purpose_Modify = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Purpose_Modify"));
				PaymentDetails = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("PaymentDetails"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));

				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				CancelYes = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CancelYes"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));

			}
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			OpenMenuesSmart.openFawriMenu("MoneyTransfer");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "MoneyTransfer_title", "SMART_FAWRI_MONEY_TRANSFER")), "Money Transfer home page"));

				Log.pass(" Money Transfer home page appearing successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "MoneyTransfer_title", "SMART_FAWRI_MONEY_TRANSFER"))));

				Utils.logPassImage("Money Transfer home page appearing-pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Money Transfer home page not appearing");
				Utils.logFailImage("Money Transfer home page-fail");

				throw e;

			}
			

		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}


}
