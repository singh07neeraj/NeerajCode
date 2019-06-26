package javaMain.JOL.accounts;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenJOLMenues;

public class OpenHouseholdAccount extends TestBase {

	public static boolean OpenHouseholdAccount_functions(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		String DOBType,Page1BtnOptions,IDDateType,AddressType,Page2BtnOptions,Page3BtnOptions,Page4BtnOptions;
		boolean runResult = true;
		try {

		if (isMasterClassRun) {
			
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				DOBType = ReadDataSQL(TCName, ScenarioCount, "DOBType");
				Page1BtnOptions = ReadDataSQL(TCName, ScenarioCount, "Page1BtnOptions");
				Page2BtnOptions = ReadDataSQL(TCName, ScenarioCount, "Page2BtnOptions");
				IDDateType = ReadDataSQL(TCName, ScenarioCount, "IDDateType");
				Page3BtnOptions = ReadDataSQL(TCName, ScenarioCount, "Page3BtnOptions");
				AddressType = ReadDataSQL(TCName, ScenarioCount, "AddressType");
				Page4BtnOptions = ReadDataSQL(TCName, ScenarioCount, "Page4BtnOptions");
				
						
				
			}

			else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				DOBType = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("DOBType");
				Page1BtnOptions = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Page1BtnOptions");
				Page2BtnOptions = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Page2BtnOptions");
				IDDateType = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("IDDateType");
				Page3BtnOptions = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Page3BtnOptions");
				AddressType = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AddressType");
				Page4BtnOptions = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Page4BtnOptions");
				
							
			}
			
			OpenJOLMenues.openAccountMenu("OpenHouseholdAccount");
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			Utils.wait(5);
			
			
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "idTypeDropDown_clk", "Household_Jol")), By.xpath(getObj("Propval1", "idTypeDropDown", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "IDType"), "ID type drop down");
			
			Utils.sendKeys(By.xpath(getObj("Propval1", "IDNumber", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "IDNumber"));
			
			// DOb Type check boxes
			if (Integer.parseInt(DOBType) == 1) 
			{
				Utils.click(By.xpath(getObj("Propval1", "DOBHijriCheckbox", "Household_Jol")), "DOB Hijri checkBox");
				
				Utils.click(By.xpath(getObj("Propval1", "DObDropDown", "Household_Jol")),"DOB drop down");
				//Utils.wait(3);
				Utils.sendKeys(By.xpath(getObj("Propval1", "DOBField", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "Hijri_DOB"),"Hijri DOB");

			} 
			else if (Integer.parseInt(DOBType) == 2)
			{
				Utils.click(By.xpath(getObj("Propval1", "DOBGregorianCheckbox", "Household_Jol")), "DOB Gregorian checkBox");
				
				Utils.click(By.xpath(getObj("Propval1", "DObDropDown", "Household_Jol")),"DOB drop down");
				//Utils.wait(3);
				Utils.sendKeys(By.xpath(getObj("Propval1", "DOBField", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "Gregorian_DOB"),"Gregorian DOB");

			}

			
			Utils.click(By.xpath(getObj("Propval1", "searchBtn", "Household_Jol")),"search button");
			
			
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "titleDropdown_clk", "Household_Jol")), By.xpath(getObj("Propval1", "title", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "Title"), "title dropdown");
			
			
			Utils.sendKeys(By.xpath(getObj("Propval1", "firstName", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "FirstName"),"FirstName text box");
			Utils.sendKeys(By.xpath(getObj("Propval1", "secondName", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "SecondName"),"SecondName text box");
			Utils.sendKeys(By.xpath(getObj("Propval1", "thirdName", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "ThirdName"),"ThirdName text box");
			Utils.sendKeys(By.xpath(getObj("Propval1", "familyName", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "FamilyName"),"FamilyName text box");

			Utils.sendKeys(By.xpath(getObj("Propval1", "firstNameAr", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "FirstNameAR"),"FirstNameAR text box");
			Utils.sendKeys(By.xpath(getObj("Propval1", "secondNameAr", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "SecondNameAR"),"SecondNameAR text box");
			Utils.sendKeys(By.xpath(getObj("Propval1", "thirdNameAr", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "ThirdNameAR"),"ThirdNameAR text box");
			Utils.sendKeys(By.xpath(getObj("Propval1", "familyNameAr", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "FamilyNameAR"),"FamilyNameAR text box");

			if (Integer.parseInt(Page1BtnOptions) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "nextBtn", "Household_Jol")), "Successfully clicked next button.");
			} else if (Integer.parseInt(Page1BtnOptions) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "cancelBtn", "Household_Jol")), "Successfully clicked cancel button.");
				return runResult;
			}
			// continue to next page n fill form

			Utils.sendValDropdown(By.xpath(getObj("Propval1", "genderInput", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "Gender"),"Gender dropdown");
			Utils.wait(5);
			
			Utils.click(By.xpath(getObj("Propval1", "hijriDOBDD_clk", "Household_Jol")), "Successfully clicked on Hijri DOB");
			Utils.sendKeys(By.xpath(getObj("Propval1", "hijriDOBInput", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account","Hijri_DOB"),"Hijri_DOB text box"); 
			//Utils.pressTab();
			
			Utils.click(By.xpath(getObj("Propval1", "gergorianDOBDD_clk", "Household_Jol")), "Successfully clicked on Gregorian DOB");
			Utils.sendKeys(By.xpath(getObj("Propval1","gergorianDOB", "Household_Jol")),Input.ReadTestData("JOL Account - Open Household Account", "Gregorian_DOB"),"Gregorian_DOB text box");
			//Utils.pressTab();

			Utils.sendKeys(By.xpath(getObj("Propval1", "nationality", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "Nationality"),"Nationality text box");

			Utils.sendKeys(By.xpath(getObj("Propval1", "countryOfBirth", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "CountryOfBirth"),"CountryOfBirth text box");
			Utils.sendKeys(By.xpath(getObj("Propval1", "placeOfBirth", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "PlaceOfBirth"),"PlaceOfBirth text box");

			
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "maritalStatusDD_clk", "Household_Jol")), By.xpath(getObj("Propval1", "maritalStatus", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "MaritalStatus"), "MaritalStatus dropdown");
			
			
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "educationalLevelDD_clk", "Household_Jol")), By.xpath(getObj("Propval1", "educationalLevel", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "EducationLevel"), "EducationLevel dropdown");
			
					
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "residenceStatusDD_clk", "Household_Jol")), By.xpath(getObj("Propval1", "residenceStatus", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "ResidenceStatus"), "ResidenceStatus dropdown");
			
			Utils.sendKeys(By.xpath(getObj("Propval1", "noOfDependents", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "NoOfDependencies"),"NoOfDependencies text box");
			
			// clicking on language dropdown icon.
						
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "languagePrefDD_clk", "Household_Jol")), By.xpath(getObj("Propval1", "languagePref", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "LanguagePreference"), "LanguagePreference dropdown");
			
			if (Integer.parseInt(Page2BtnOptions) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "nextBtn", "Household_Jol")), "Successfully clicked next button.");
			} else if (Integer.parseInt(Page2BtnOptions) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "backBtn", "Household_Jol")), "Successfully clicked back button.");
				Utils.click(By.xpath(getObj("Propval1", "nextBtn", "Household_Jol")), "Successfully clicked next button.");
				Utils.click(By.xpath(getObj("Propval1", "nextBtn", "Household_Jol")), "Successfully clicked next button.");
			} else if (Integer.parseInt(Page2BtnOptions) == 3) {
				Utils.click(By.xpath(getObj("Propval1", "cancelBtn", "Household_Jol")), "Successfully clicked cancel button.");
				return runResult;
			}

			Utils.sendKeys(By.xpath(getObj("Propval1", "placeOfIssue", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "PlaceOfIsssue"),"PlaceOfIsssue text box");

			if (Integer.parseInt(IDDateType) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "idDateHijri", "Household_Jol")), "Successfully selected date type as Hijri.");
				
				Utils.click(By.xpath(getObj("Propval1", "idIssueDateDD_clk", "Household_Jol")), "Id Issue date dropdown click");
				Utils.sendKeys(By.xpath(getObj("Propval1", "idIssueDate", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "IDIssueDate_Hijri"),"IDIssueDate Hijri text box");
				
				Utils.click(By.xpath(getObj("Propval1", "idExpiryDateDD_clk", "Household_Jol")), "Id Expiry date dropdown click");
				Utils.sendKeys(By.xpath(getObj("Propval1", "idExpiryDate", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "IDExpiryDate_Hijri"),"IDExpiryDate Hijri text box");

			} else if (Integer.parseInt(IDDateType) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "idDateGregorian", "Household_Jol")), "Successfully selected date type as gregorian");
				Utils.click(By.xpath(getObj("Propval1", "idIssueDateDD_clk", "Household_Jol")), "Id Issue date dropdown click");
				Utils.sendKeys(By.xpath(getObj("Propval1", "idIssueDate", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "IDIssueDate_Gregorian"),"IDIssueDate Gregorian text box");
				
				Utils.click(By.xpath(getObj("Propval1", "idExpiryDateDD_clk", "Household_Jol")), "Id Expiry date dropdown click");
				Utils.sendKeys(By.xpath(getObj("Propval1", "idExpiryDate", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "IDExpiryDate_Gregorian"),"IDIssueDate Gregorian text box");
	
			}

			if (Integer.parseInt(Page3BtnOptions) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "nextBtn", "Household_Jol")), "Successfully clicked next button.");
			} else if (Integer.parseInt(Page3BtnOptions) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "backBtn", "Household_Jol")), "Successfully clicked back button.");
				Utils.click(By.xpath(getObj("Propval1", "nextBtn", "Household_Jol")), "Successfully clicked next button.");
				Utils.click(By.xpath(getObj("Propval1", "nextBtn", "Household_Jol")), "Successfully clicked next button.");
				// return b;
			} else if (Integer.parseInt(Page3BtnOptions) == 3) {
				Utils.click(By.xpath(getObj("Propval1", "cancelBtn", "Household_Jol")), "Successfully clicked cancel button.");
				return runResult;
			}

			
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "City_DD_Clk", "Household_Jol")), By.xpath(getObj("Propval1", "City_DD", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "PlaceOfIsssue"), "City dropdown");
			
			Utils.sendKeys(By.xpath(getObj("Propval1", "PostalCode_txt", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "PostalCode"),"PostalCode text box");
			
			Utils.sendKeys(By.xpath(getObj("Propval1", "UnitNum_National", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "UnitNumber"),"UnitNumber text box");
			Utils.sendKeys(By.xpath(getObj("Propval1", "PhoneNum_National", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "PhoneNumber"),"PhoneNumber text box");
			Utils.sendKeys(By.xpath(getObj("Propval1", "MobileNum_National", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "MobileNumber"),"MobileNumber text box");
			Utils.sendKeys(By.xpath(getObj("Propval1", "Email_National", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "Email"),"Email text box");
			
			Utils.sendKeys(By.xpath(getObj("Propval1", "PhoneNum_Mailing", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "PhoneNumber"),"PhoneNumber mailing text box");
			Utils.sendKeys(By.xpath(getObj("Propval1", "MobileNum_Mailing", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "MobileNumber"),"MobileNumber mailing text box");
			Utils.sendKeys(By.xpath(getObj("Propval1", "Email_Mailing", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "Email"),"Email mailing text box");

			if (Integer.parseInt(AddressType) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "AddressType_Physical_RDB", "Household_Jol")), "Successfully clicked AddressType Physical radio button.");
			}
			else if (Integer.parseInt(AddressType) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "AddressType_Wasel_RDB", "Household_Jol")), "Successfully clicked AddressType Wasel radio button.");
			}
			else if (Integer.parseInt(AddressType) == 3) {
				Utils.click(By.xpath(getObj("Propval1", "AddressType_POBox_RDB", "Household_Jol")), "Successfully clicked AddressType POBox radio button.");
			}
			else if (Integer.parseInt(AddressType) == 4) {
				Utils.click(By.xpath(getObj("Propval1", "AddressType_National_RDB", "Household_Jol")), "Successfully clicked AddressType National radio button.");
			}
			
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "BuildingNum_Mailing", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "BuildingNumber"),"BuildingNumber mailing text box");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "UnitNum_Mailing", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "UnitNumber"),"UnitNumber mailing text box");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "LandMark_Mailing", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "LandMark"),"LandMark mailing text box");
			
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Other_Mailing", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "Others"),"Others mailing text box");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "POBoxNum_Mailing", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "POBoxNumber"),"POBoxNumber mailing text box");
			
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "StreetNameMailing_txt", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "Streetname"),"Streetname mailing text box");
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "PostalCodeMailing_txt", "Household_Jol")), Input.ReadTestData("JOL Account - Open Household Account", "PostalCode"),"PostalCode mailing text box");
			
			Utils.click(By.xpath(getObj("Propval1", "termsNConditions", "Household_Jol")), "Successfully clicked terms and conditions checkbox .");

			if (Integer.parseInt(Page4BtnOptions) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "proceedbtnExecPg4", "Household_Jol")), "Successfully clicked proceed button.");
			} else if (Integer.parseInt(Page4BtnOptions) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "backBtn", "Household_Jol")), "Successfully clicked back button.");
				// return b;
			} else if (Integer.parseInt(Page4BtnOptions) == 3) {
				Utils.click(By.xpath(getObj("Propval1", "cancelBtn", "Household_Jol")), "Successfully clicked cancel button.");
				return runResult;
			}
			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMsg", "Household_Jol")), " Success Message"));
				Log.pass(" Your Open Household Account request has been completed successfully." + Utils.getText(By.xpath(getObj("Propval1", "SuccessMsg", "Household_Jol"))));
				Utils.logPassImage("Open Household Account request- Pass");

			} catch (AssertionError | Exception e) {

				Log.fail(" Unable to Open Account... error message displayed on the screen is : " + Utils.getText(By.xpath(getObj("Propval1", "ErrorMsg", "Household_Jol"))));
				Utils.logFailImage("Open Household Account -Fail");
				throw e;

			}
		}

		catch (AssertionError | Exception e) {
			runResult = false;
			e.printStackTrace();
			throw e;
		}
		return runResult;
	}
}