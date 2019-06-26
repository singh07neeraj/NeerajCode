package javaMain.JOL.transfer;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AddNewBeneficiary;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.BeneficiaryType;
import static javaMain.common_Functions.AppData.ExcelPdfPrintActions;
import static javaMain.common_Functions.AppData.ProceedEmail;
import static javaMain.common_Functions.AppData.Result;
import static javaMain.common_Functions.AppData.deleteBeneficiary;
import static javaMain.common_Functions.AppData.sendEmail;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenJOLMenues;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_TRANSFERS_BENEFICIARY_MANAGEMENT extends TestBase {

	public static Boolean JOL_TRANSFERS_BENEFICIARY_MANAGEMENT_functions(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {
				Log.pass("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AddNewBeneficiary = ReadDataSQL(TCName, ScenarioCount, "AddNewBeneficiary");
				BeneficiaryType = ReadDataSQL(TCName, ScenarioCount, "BeneficiaryType");
				deleteBeneficiary = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "deleteBeneficiary"));
				sendEmail = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "sendEmail"));
				ProceedEmail = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ProceedEmail"));
				ExcelPdfPrintActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ExcelPdfPrintActions"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AdditionalActions"));

			} else {
				Log.pass("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AddNewBeneficiary = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AddNewBeneficiary");
				BeneficiaryType = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryType");
				deleteBeneficiary = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("deleteBeneficiary"));
				sendEmail = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("sendEmail"));
				ProceedEmail = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ProceedEmail"));
				ExcelPdfPrintActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ExcelPdfPrintActions"));
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AdditionalActions"));
			}

			// Open Manage Beneficiaries page below-
			OpenJOLMenues.openTransfersMenu("BeneficiaryManagement");

			// Select Beneficiary type based on Beneficiary Type Value.
			if (Integer.parseInt(BeneficiaryType) == 1) {
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "beneficiarytype1DropdownDropdown", "BENEFICIARY_MANAGEMENT")), By.xpath(getObj("Propval1", "beneficiarytype1", "BENEFICIARY_MANAGEMENT")),
						ReadTestData(TCName, "Beneficiary_All"));
				Log.pass("Successfully selected All beneficiaries");

			} else if (Integer.parseInt(BeneficiaryType) == 2) {
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "beneficiarytype1DropdownDropdown", "BENEFICIARY_MANAGEMENT")), By.xpath(getObj("Propval1", "beneficiarytype1", "BENEFICIARY_MANAGEMENT")),
						ReadTestData(TCName, "Beneficiary_WithinBankBAJ"));
				Log.pass("Successfully selected Beneficiaris within BAJ");
			} else if (Integer.parseInt(BeneficiaryType) == 3) {
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "beneficiarytype1DropdownDropdown", "BENEFICIARY_MANAGEMENT")), By.xpath(getObj("Propval1", "beneficiarytype1", "BENEFICIARY_MANAGEMENT")),
						ReadTestData(TCName, "Beneficiary_Local"));
				Log.pass("Successfully selected Local Beneficiaries.");
			} else if (Integer.parseInt(BeneficiaryType) == 4) {
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "beneficiarytype1DropdownDropdown", "BENEFICIARY_MANAGEMENT")), By.xpath(getObj("Propval1", "beneficiarytype1", "BENEFICIARY_MANAGEMENT")),
						ReadTestData(TCName, "Beneficiary_International"));
				Log.pass("Successfully selected International Beneficiaries.");
			}

			// Click on Search
			Utils.click(By.xpath(getObj("Propval1", "Search", "BENEFICIARY_MANAGEMENT")), "Click on Search");
			Result = Utils.getText(By.xpath(getObj("Propval1", "SearchResult", "BENEFICIARY_MANAGEMENT")));
			Log.pass("Search Result displayed on screen is : " + Result);

			if (Integer.parseInt(deleteBeneficiary) == 1) {

				if (!Result.contains("0")) {
					// Click on Delete Button//
					Utils.click(By.xpath(getObj("Propval1", "DeleteBen", "Add_New_Beneficiary")), "Delete Button");
					// Click on Confirm Button//
					Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "Add_New_Beneficiary")), "Confirm Button");

					try {
						if (Utils.getSize(By.xpath("//*[@class='tit tit-green']")) > 0) {
							Log.pass("Successfully deleted Beneficiary.Message displayed is :" + Utils.getText(By.xpath("//*[@class='tit tit-green']")));
						}
					} catch (Exception e) {
						Log.error("Unable to delete beneficiary.. error while deleting.." + ExceptionUtils.getStackTrace(e));
					}

					Utils.click(By.id("dijit_form_Button_4"), "Back to Beneficiary Management");

				}

				else {

					Log.pass("No results displayed on screen. Hence Not able to delete the record as expected. ");
				}
			}

			if (AdditionalActions.equalsIgnoreCase("true")) {

				TransferModuleCommonFunctions.sendEmailDownloadExcelnPrintFunc();

			}

			if (Integer.parseInt(AddNewBeneficiary) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Newbeneficiary", "BENEFICIARY_MANAGEMENT")), "New Beneficiary");
				Utils.wait(5);
				Utils.waitTillSaudiWaitIconDisappears();
				try {
					
					Assert.assertTrue(Utils.assertDisplayed(By.className("toolbar"), "Add New Beneficiay page"));
					Log.pass("Add New Beneficiay page opened Succesfully as expected.........");
				}
				
				catch(AssertionError | Exception e) {
					
					Log.error("Add New Beneficiay page is Not Displayed........error.. " );
					Utils.logFailImage(TCName+ " Add New beneficiary page- Failed");
					throw e;
				}
			}

		}

		catch (AssertionError | Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}
}
