package javaMain.eCorp.ThriftSavingPlan;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.eCorpCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_THRIFTSAVINGPLAN_VIEW_FUNC extends TestBase {

	public static Boolean ViewContributorFileValidation(String TCName, int ScenarioCount, Object[] tCsDataset)
			throws Exception {
		Utils.refreshScreeen();
		try {

			Utils.click(By.xpath(
					getObj("Propval1", "ThriftSavingPlan", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")),
					"Thrift Saving Plan");

			Utils.click(By.xpath(getObj("Propval1", "ViewContributorFileValidation",
					"eCorp_ThriftSavingPlan_ViewContributorFileValidation")), "View Contributor File Template");

			// Verify landing page
			String LandPage = Utils.getText(
					By.xpath(getObj("Propval1", "LandPage", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")));

			Log.pass("Landed Page is  :" + LandPage);
			Utils.logPassImage(TCName);
			// Page Validation

			String Results = Utils.getText(
					By.xpath(getObj("Propval1", "Results", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")));

			Log.pass("search result first page   :" + Results);
			Utils.logPassImage(TCName);
			// Page Validation

			Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
			eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
			Log.pass(
					"Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
			Utils.logPassImage("Additional Actions");

			/*
			 * addFavSendEmailDownloadPdfNprintFuncBeneficiary(TCName);
			 * Utils.logPassImage(TCName);
			 */

		}

		catch (Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}

	public static Boolean ViewUploadedContributorFiles(String TCName, int ScenarioCount, Object[] tCsDataset)
			throws Exception {

		String AfterTxfrAdditionalOptions, isNegative, Status, NextDate, FutureDate, NewTxn;
		try {

			if (true) {

				Log.pass("Data set for this scenario is " + System.lineSeparator()
						+ ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				Status = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Status"));

				AfterTxfrAdditionalOptions = Utils
						.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));

				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				NextDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NextDate"));
				FutureDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "FutureDate"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
			} else {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				AfterTxfrAdditionalOptions = Utils.setValue(
						(String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				Status = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Status"));

				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				NextDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NextDate"));
				FutureDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("FutureDate"));
				NewTxn = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn");
			}

			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "ThriftSavingPlan", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")),"Thrift Saving Plan");

			Utils.click(By.xpath(getObj("Propval1", "ViewUploadedContributorFiles",	"eCorp_ThriftSavingPlan_ViewContributorFileValidation")),"View Uploaded Contributor Files");

			// Verify landing page
			String LandPage = Utils.getText(
					By.xpath(getObj("Propval1", "LandPage", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")));

			Log.pass("Landed Page is  :" + LandPage);
			Utils.logPassImage(TCName);
				
			Utils.click(By.xpath(getObj("Propval1", "StartDateDropDown",	"eCorp_ThriftSavingPlan_ViewContributorFileValidation")),"Start Date DropDown");
			Utils.sendKeys(By.xpath(getObj("Propval1", "StartDate", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")),NextDate, "NextDate");
			
			Utils.click(By.xpath(getObj("Propval1", "EndDateDropDown",	"eCorp_ThriftSavingPlan_ViewContributorFileValidation")),"End Date DropDown");
			Utils.sendKeys(By.xpath(getObj("Propval1", "EndDate", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")),FutureDate, "FutureDate");
			
			
			/*Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "StartDateDropDown","eCorp_ThriftSavingPlan_ViewContributorFileValidation")),
					By.xpath(getObj("Propval1", "StartDate", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")),NextDate, "NextDate");
			Utils.wait(2);
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "EndDateDropDown","eCorp_ThriftSavingPlan_ViewContributorFileValidation")),
					By.xpath(getObj("Propval1", "EndDate", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")),FutureDate, "FutureDate");
				Utils.wait(2);*/
			
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "StatusDropDown","eCorp_ThriftSavingPlan_ViewContributorFileValidation")),
					By.xpath(getObj("Propval1", "Status", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")),	Status, "Status");

			if (isNegative.equalsIgnoreCase("true")) {

				try {

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Error", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")),"Error"));
					Log.pass("Not able to search with invalid date. Please use valid date and try search");
					Utils.logPassImage(TCName);
					return true;

				} catch (AssertionError | Exception e) {

					Log.pass("Please review please for invalid error or make isNegative is false");
					Utils.logFailImage(TCName);
					return false;

				}
			}

			
			Utils.click(By.xpath(getObj("Propval1", "Search", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")),"Search");
			Utils.wait(3);
			
			String Result1 = Utils.getText(By.xpath(getObj("Propval1", "Result1", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")));

			Log.pass("Landed Page is  :" + Result1);
			Utils.logPassImage(TCName);
			
			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass(
						"Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");

			}
			/*
			 * addFavSendEmailDownloadPdfNprintFuncBeneficiary(TCName);
			 * Utils.logPassImage(TCName);
			 */

		}

		catch (Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}
	
	public static Boolean ViewContributorFileDetails(String TCName, int ScenarioCount, Object[] tCsDataset)
			throws Exception {

		String AfterTxfrAdditionalOptions, isNegative, Status, NextDate, FutureDate, NewTxn,AccountCofig,EmployeeID,ProfitSharing;
		try {

			if (true) {

				Log.pass("Data set for this scenario is " + System.lineSeparator()
						+ ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				Status = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Status"));

				AfterTxfrAdditionalOptions = Utils
						.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));

				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				NextDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NextDate"));
				FutureDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "FutureDate"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				AccountCofig = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountCofig"));
				EmployeeID = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "EmployeeID"));
				ProfitSharing = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ProfitSharing"));
			} else {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				AfterTxfrAdditionalOptions = Utils.setValue(
						(String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				Status = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Status"));

				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				NextDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NextDate"));
				FutureDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("FutureDate"));
				NewTxn = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn");
				AccountCofig = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountCofig");
				EmployeeID = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("EmployeeID");
				ProfitSharing = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("ProfitSharing");
			}

			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "ThriftSavingPlan", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")),"Thrift Saving Plan");

			Utils.click(By.xpath(getObj("Propval1", "ViewContributorFileDetails",	"eCorp_ThriftSavingPlan_ViewContributorFileValidation")),"View Contributor File Details");

			// Verify landing page
			String LandPage = Utils.getText(
					By.xpath(getObj("Propval1", "LandPage", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")));

			Log.pass("Landed Page is  :" + LandPage);
			Utils.logPassImage(TCName);
				
			Utils.click(By.xpath(getObj("Propval1", "StartDateDropDown",	"eCorp_ThriftSavingPlan_ViewContributorFileDetails")),"Start Date DropDown");
			Utils.sendKeys(By.xpath(getObj("Propval1", "StartDate", "eCorp_ThriftSavingPlan_ViewContributorFileDetails")),NextDate, "NextDate");
			
			Utils.click(By.xpath(getObj("Propval1", "EndDateDropDown",	"eCorp_ThriftSavingPlan_ViewContributorFileDetails")),"End Date DropDown");
			Utils.sendKeys(By.xpath(getObj("Propval1", "EndDate", "eCorp_ThriftSavingPlan_ViewContributorFileDetails")),FutureDate, "FutureDate");
						
			Utils.click(By.xpath(getObj("Propval1", "NominatedAccountDropDown",	"eCorp_ThriftSavingPlan_ViewContributorFileDetails")),"End Date DropDown");
			Utils.sendKeys(By.xpath(getObj("Propval1", "NominatedAccount", "eCorp_ThriftSavingPlan_ViewContributorFileDetails")),AccountCofig, "NominatedAccount");
			
			Utils.sendKeys(By.xpath(getObj("Propval1", "EmployeeNo", "eCorp_ThriftSavingPlan_ViewContributorFileDetails")),EmployeeID, "EmployeeNo");
			
			Utils.click(By.xpath(getObj("Propval1", "profitSharingDropDown",	"eCorp_ThriftSavingPlan_ViewContributorFileDetails")),"End Date DropDown");
			Utils.sendKeys(By.xpath(getObj("Propval1", "profitSharing", "eCorp_ThriftSavingPlan_ViewContributorFileDetails")),ProfitSharing, "ProfitSharing");
			
			
			
		

			if (isNegative.equalsIgnoreCase("true")) {

				try {

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Error", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")),"Error"));
					Log.pass("Not able to search with invalid date. Please use valid date and try search");
					Utils.logPassImage(TCName);
					return true;

				} catch (AssertionError | Exception e) {

					Log.pass("Please review please for invalid error or make isNegative is false");
					Utils.logFailImage(TCName);
					return false;

				}
			}

			
			Utils.click(By.xpath(getObj("Propval1", "Search", "eCorp_ThriftSavingPlan_ViewContributorFileDetails")),"Search");
			Utils.wait(3);
			
			String Result1 = Utils.getText(By.xpath(getObj("Propval1", "Result1", "eCorp_ThriftSavingPlan_ViewContributorFileValidation")));

			Log.pass("Landed Page is  :" + Result1);
			Utils.logPassImage(TCName);
			
			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass(
						"Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");

			}
			/*
			 * addFavSendEmailDownloadPdfNprintFuncBeneficiary(TCName);
			 * Utils.logPassImage(TCName);
			 */

		}

		catch (Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}
}
