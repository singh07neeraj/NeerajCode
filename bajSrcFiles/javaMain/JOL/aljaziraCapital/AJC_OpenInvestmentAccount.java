package javaMain.JOL.aljaziraCapital;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.PortfolioNum;
import static javaMain.common_Functions.AppData.PortfolioType;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.TestType;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.OpenJOLMenues;

public class AJC_OpenInvestmentAccount extends TestBase {

	@SuppressWarnings("unused")
	public static boolean openInvestmentAccount(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {


		try {

			if (true) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AdditionalActions"));
				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));
				PortfolioNum = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "PortfolioNum"));

			}

			else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				Proceed = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed");
				Confirm = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm");
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AdditionalActions"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));
				PortfolioType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("PortfolioType"));


			}

			Utils.wait(3);
			// Open orders Inquiry page.
			OpenJOLMenues.openAljaziraCapitalMenu("OpenInvestmentAccount");
			
			Utils.clickSafely(By.xpath(getObj("Propval1", "termsCheckBox", "AlZCapital")), "Terms checkbox");

			Utils.clickSafely(By.xpath(getObj("Propval1", "MutualFundsProceedBtn", "AlZCapital")), "Proceed button");
			
			if (TestType.equalsIgnoreCase("P")) {

				Log.pass("Started executing positive scenario.");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "idTypeDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "idInput", "AlZCapital")), Input.ReadTestData(TCName,"IDType"), "ID Type");
				Utils.sendKeys(By.xpath(getObj("Propval1", "fathersNameInput", "AlZCapital")), Input.ReadTestData(TCName,"FatherName"), "Father's Name");
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "nationalityTypeDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "nationalityInput", "AlZCapital")), Input.ReadTestData(TCName,"Nationality"), "ID Type");

				Utils.sendKeys(By.xpath(getObj("Propval1", "PhNumInput", "AlZCapital")), Input.ReadTestData(TCName,"PhNum"), "Phone Number");
				Utils.sendKeys(By.xpath(getObj("Propval1", "mobileNumInput", "AlZCapital")), Input.ReadTestData(TCName,"MobNum"), "Mobile Number");
				Utils.sendKeys(By.xpath(getObj("Propval1", "emailInput", "AlZCapital")), Input.ReadTestData(TCName,"Email"), "Email");
				Utils.sendKeys(By.xpath(getObj("Propval1", "poboxINputOI", "AlZCapital")), Input.ReadTestData(TCName,"POBox"), "PO Box");
				Utils.sendKeys(By.xpath(getObj("Propval1", "cityInputOI", "AlZCapital")), Input.ReadTestData(TCName,"City"), "City");
				Utils.sendKeys(By.xpath(getObj("Propval1", "zipCodeInputOI", "AlZCapital")), Input.ReadTestData(TCName,"ZIpCode"), "ZIP Code");

				Utils.sendKeys(By.xpath(getObj("Propval1", "streetInput", "AlZCapital")), Input.ReadTestData(TCName,"Street"), "Street");
				Utils.sendKeys(By.xpath(getObj("Propval1", "majorLandmarkInput", "AlZCapital")), Input.ReadTestData(TCName,"MajorLandmark"), "Mazor Landmark");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "mailTypeDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "mailTypeInputOI", "AlZCapital")), Input.ReadTestData(TCName,"MailType"), "Mail Type");
				Utils.sendKeys(By.xpath(getObj("Propval1", "NumOfIdependentsInput", "AlZCapital")), Input.ReadTestData(TCName,"NoOfDependents"), "No. Of dependents");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "maritalStatusDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "maritalStatusInput", "AlZCapital")), Input.ReadTestData(TCName,"MaritalStatus"), "Marital Status");
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "residencetypeDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "residencetypeInput", "AlZCapital")), Input.ReadTestData(TCName,"ResType"), "Residence Type");
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "educationLevelDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "educationLevelInput", "AlZCapital")), Input.ReadTestData(TCName,"EduLevel"), "EduLevel");

				Utils.click(By.xpath(getObj("Propval1", "nextBtnOpenInvAcc", "AlZCapital")), "Next");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "empstatusdropDown", "AlZCapital")), By.xpath(getObj("Propval1", "empstatusInput", "AlZCapital")), Input.ReadTestData(TCName,"EMPStatus"), "Employment Status");
				Utils.sendKeys(By.xpath(getObj("Propval1", "coNameInput", "AlZCapital")), Input.ReadTestData(TCName,"Company Name"), "co Name Input");
				Utils.sendKeys(By.xpath(getObj("Propval1", "coAddress", "AlZCapital")),Input.ReadTestData(TCName,"Company Address"), "co Address");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "mailTypeDown", "AlZCapital")), By.xpath(getObj("Propval1", "mailTypeInput", "AlZCapital")),Input.ReadTestData(TCName,"MailType"), "mail Type Input");
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "countryDropdown1", "AlZCapital")), By.xpath(getObj("Propval1", "countryInputField", "AlZCapital")), Input.ReadTestData(TCName,"Country") ,"country Input Field");

				Utils.sendKeys(By.xpath(getObj("Propval1", "jobTitleInput", "AlZCapital")), Input.ReadTestData(TCName,"JobTitle"), "job Title Input");
				
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "boardDirectorClk_dd", "AlZCapital")), By.xpath(getObj("Propval1", "boardDirectorInput", "AlZCapital")), Input.ReadTestData(TCName,"BoardDirector"), "BoardDirector Dropdown");


				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "approxAnnualIncomeDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "annualIncomeInput", "AlZCapital")), Input.ReadTestData(TCName,"ApproxAnnualIncome"), "annual Income Input");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "networthDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "networthInput", "AlZCapital")), Input.ReadTestData(TCName,"ApproxNetworth"), "networth Input");
				Utils.sendKeys(By.xpath(getObj("Propval1", "InitDepositAmountInput", "AlZCapital")), Input.ReadTestData(TCName,"InitialDepositAmount"), "InitDepositAmountInput");

				Utils.sendKeys(By.xpath(getObj("Propval1", "bankyouDealWithInput", "AlZCapital")), Input.ReadTestData(TCName,"NameOfbankYouDeal"), "bank you Deal With");

				Utils.sendKeys(By.xpath(getObj("Propval1", "accNoAtYourBank", "AlZCapital")), Input.ReadTestData(TCName,"AcctNoAtBank"), "acc No At Your Bank");
				Utils.sendKeys(By.xpath(getObj("Propval1", "volWithUrBank", "AlZCapital")), Input.ReadTestData(TCName,"TotalValWithBank"), "vol With your Bank");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "investInSecDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "investinSecInput", "AlZCapital")), Input.ReadTestData(TCName,"CapitalInvestInSecurities"), "invest In Sec Dropdown Input");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "investInSecDropdownLong", "AlZCapital")), By.xpath(getObj("Propval1", "investinSecInputLong", "AlZCapital")), Input.ReadTestData(TCName,"HowLongIntendingtoInvest"), "How long are you intending to invest");
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "InvestObjDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "investinSecInputObj", "AlZCapital")), Input.ReadTestData(TCName,"GeneralInvestment"), "General Investment Objectives");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "ifInvestDecreasedropdown", "AlZCapital")), By.xpath(getObj("Propval1", "ifInvestDecreaseInput", "AlZCapital")), Input.ReadTestData(TCName,"WhatWouldYouDO"), "If Investment Decreases Suddenly.");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "expInBondsDropDown", "AlZCapital")), By.xpath(getObj("Propval1", "expInBondsInput", "AlZCapital")), Input.ReadTestData(TCName,"ExpInBonds"), "Do you have experience in Bonds ?");
				Utils.wait(3);
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "forExpBondsDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "forExpBondsInput", "AlZCapital")), Input.ReadTestData(TCName,"ExpInBondsFor"), "How long do you have exp in bonds ?");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "expInLocalSharesTradingDropDown", "AlZCapital")), By.xpath(getObj("Propval1", "expinlocalSharesInput", "AlZCapital")), Input.ReadTestData(TCName,"ExpInLocalShares"), "Do you have experiencelocal shares?");
				Utils.wait(3);
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "forExpLocalSharesDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "forExpLocalSharesInput", "AlZCapital")),Input.ReadTestData(TCName,"ExpInLocalSharesFor"), "How long do you have exp in local shares?");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "expInIntlSharesDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "intlSharesInput", "AlZCapital")), Input.ReadTestData(TCName,"ExpInInternationalShares"), "Do you have experience in international shares?");
				Utils.wait(3);
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "forExpIntlSharesDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "forExpIntlSharesInput", "AlZCapital")),Input.ReadTestData(TCName,"ExpInInternationalSharesFor"), "How long do you have exp in Intl shares?");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "expInInvestFundsDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "expInInvestFundsInput", "AlZCapital")), Input.ReadTestData(TCName,"ExpInInvestmentfunds"), "Do you have experience in investing in funds?");
				Utils.wait(3);
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "forExpInvstFundsDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "forExpInvestFundsInput", "AlZCapital")), Input.ReadTestData(TCName,"ExpInInvestmentfundsFor"), "How long do you have exp in  investing in funds?");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "investInOtherComDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "expInInvestOtherCompaniesInput", "AlZCapital")), Input.ReadTestData(TCName,"InvestAcctWithOtherCompanies"), "Have you invested in other companies?");
				Utils.wait(3);
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "forInvestInOtherCosDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "forInvestInOtherCosInput", "AlZCapital")), Input.ReadTestData(TCName,"InvestAcctWithOtherCompaniesSince"),
						"Since when have you invested in other companies?");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "diduattendcoursesYesNodropdown", "AlZCapital")), By.xpath(getObj("Propval1", "diduattendcoursesYesNoInout", "AlZCapital")), Input.ReadTestData(TCName,"AttendCourses"), "did you attent any course??");
				
				
				
			}

			if (TestType.equalsIgnoreCase("N")) {

				Log.pass("Started executing negative scenario using negative data.");
				Utils.sendKeys(By.xpath(getObj("Propval1", "PhNumInput", "AlZCapital")),"InvalidPhonenumber!@#!@#", "Phone Number");
				Utils.click(By.xpath(getObj("Propval1", "nextBtnOpenInvAcc", "AlZCapital")), "Next");
				Utils.wait(3);
				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "InvAccProceed", "AlZCapital")), "Proceed button"));
					Log.pass("User is not able to proceed with invalid data");
					Utils.logPassImage("User is not able to proceed with invalid data -Pass");
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("User is able to proceed with invalid data...Should fail");
					Utils.logFailImage("User is able to proceed with invalid data -Fail");
					throw e;

				}				
				

				
			}

			
			if (Integer.parseInt(Proceed) == 1) {
				// Click on Proceed Button
				Utils.click(By.xpath(getObj("Propval1", "InvAccProceed", "AlZCapital")), "Proceed Button.");
				

			} else {
				
				
				
				Utils.click(By.xpath(getObj("Propval1", "Back_btn", "AlZCapital")), "Back Button.");
				
				Utils.click(By.xpath(getObj("Propval1", "Next_btn", "AlZCapital")), "Next Button.");
				
				Utils.click(By.xpath(getObj("Propval1", "InvAccProceed", "AlZCapital")), "Proceed Button.");
				

			}

			if (Integer.parseInt(Confirm) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtnInvAcc", "AlZCapital")), "Confirm  Button.");
			}
			else {
				
				Utils.click(By.xpath(getObj("Propval1", "InvestAccModify", "AlZCapital")), "Modify  Button.");
				
				Utils.sendKeys(By.xpath(getObj("Propval1", "InitDepositAmountInput", "AlZCapital")), "8900", "Initial Deposit Amount");
				
				Utils.click(By.xpath(getObj("Propval1", "InvAccProceed", "AlZCapital")), "Proceed Button.");
				
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtnInvAcc", "AlZCapital")), "Confirm  Button.");
			}
			
			
			
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "accTypeDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "accTypeInput", "AlZCapital")), Input.ReadTestData(TCName,"AccountType"), "Account Type");
			
			Utils.click(By.xpath(getObj("Propval1", "InvAccProceed", "AlZCapital")), "Proceed Button.");
			Utils.click(By.xpath(getObj("Propval1", "termsNConditionsChkBox", "AlZCapital")), "terms  and Conditions ChkBox.");
			
			Utils.click(By.xpath(getObj("Propval1", "ConfirmBtnInvAcc", "AlZCapital")), "Confirm  Button.");

			Utils.enterOTPAndProceed();
			
			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "OpenInvestAccSuccessMsg", "AlZCapital")), " Success Message"));
				Log.pass(" Your Open Investment Account request has been completed successfully." + Utils.getText(By.xpath(getObj("Propval1", "OpenInvestAccSuccessMsg", "AlZCapital"))));
				Utils.logPassImage("Open Investment Account request- Pass");

			} catch (AssertionError | Exception e) {

				Log.fail(" Unable to Open Investment Account... ");
				Utils.logFailImage("Open Investment Account -Fail");
				throw e;

			}
			
			if (AdditionalActions.equalsIgnoreCase("true")) {

				Log.pass("Successfully started other actions like send email, download pdf, excel and print search result etc.");
				sendEmailDownloadExcelnPrintFunc(ScenarioCount, Proceed);

			}
					
		//	Utils.click(By.xpath(getObj("Propval1", "homebtn", "AlZCapital")), "Home  Button.");
			
						
			

		} catch (AssertionError | Exception e)  {
			runResult = false;
			throw e;
		}
		return runResult;
	}
	public static boolean sendEmailDownloadExcelnPrintFunc(int ScenarioCount, String... proceedEmail) throws Exception {

		String sendEmail = "1";
		try {
			sendEmail = proceedEmail[0];
		} catch (Exception e) {
			sendEmail = "1";
		}

		try {

			Utils.wait(3);
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "AlZCapital")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.wait(3);
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "AlZCapital")), "Print Button");
			// close all other tabs except the main one. i.e 1st page.
			Utils.closeOtherTabs();

			// Start sending email , downloading pdf and printing etc.
			Utils.wait(5);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "AlZCapital")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "AlZCapital")), ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "AlZCapital")), ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "AlZCapital")), ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "AlZCapital")), ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "AlZCapital")), ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");

			//*[contains(@class,'dijit dijitReset dijitInline buttonRed dijitButton')]
			
			// Send email if proceed=1 in DB
			if (Integer.parseInt(sendEmail) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "AlZCapital")), "Send Email Button");
			}
			// Hit cancel email if Proceed=2 in DB.
			else if (Integer.parseInt(sendEmail) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "AlZCapital")), "Cancel Email Button");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "AlZCapital")), "Send Email Button");
			}
			
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			Utils.pressEnter();
			Utils.wait(3);
			Utils.pressEscapeKey(3);
			Utils.wait(3);
			Log.pass("Successfully completed other actions like send email, download pdf, excel and print search result etc.");
		}

		catch (Exception e) {
			Log.fail("Unable to complete other actions like send email, download pdf, excel and print search result etc error..");
			Utils.logFailImage(TCName + "  Scenario count -" + ScenarioCount + " - sendEmailDownloadExcelnPrintFunc-error");
			runResult = false;
			throw e;

		}

		return runResult;
	}

}
