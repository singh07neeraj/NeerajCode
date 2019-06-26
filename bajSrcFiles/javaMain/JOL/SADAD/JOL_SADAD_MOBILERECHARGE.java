package javaMain.JOL.SADAD;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;

public class JOL_SADAD_MOBILERECHARGE extends TestBase{

	
	public static Boolean JOL_SADAD_MOBILERECHARGE_Func(String TCName, int ScenarioCount, Object[] tCsDataset)
			throws Exception{
			 String BeneficiaryType,BillerType,Nickname,SubscriptionID,AMOUNT,AccountNumber,Exec_Proceed_btn,BillerType_NewMobile,Nickname_NewMobile,SubscriptionID_NewMobile,Confirmation_btn;
			
		
		try {

			// if (isMasterClassRun) {
			if (true) {

				Log.pass("Data set for this scenario is " + System.lineSeparator()
						+ ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				
				BeneficiaryType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryType"));
				BillerType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BillerType"));
				Nickname = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Nickname"));
				SubscriptionID = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "SubscriptionID"));
				AMOUNT = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AMOUNT"));
				AccountNumber= Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				Exec_Proceed_btn=Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Exec_Proceed_btn"));
				Confirmation_btn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirmation_btn"));
				BillerType_NewMobile = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BillerType_NewMobile"));
				Nickname_NewMobile = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Nickname_NewMobile"));
				SubscriptionID_NewMobile = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "SubscriptionID_NewMobile"));
				
				
				
								
				} else {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

				
				BeneficiaryType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryType"));
				BillerType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BillerType"));
				Nickname = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Nickname"));
				SubscriptionID = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("SubscriptionID"));
				AMOUNT = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AMOUNT"));
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				Confirmation_btn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirmation_btn"));
				Exec_Proceed_btn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Exec_Proceed_btn"));
				BillerType_NewMobile = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BillerType_NewMobile"));
				Nickname_NewMobile = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Nickname_NewMobile"));
				SubscriptionID_NewMobile = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("SubscriptionID_NewMobile"));
				
				
			
				
			}

			Utils.scrollUpVertically();
			
			Utils.click(By.xpath(getObj("Propval1", "SADADServicesLnk", "SADAD_MobileRecharge")), "Sadad Link");
			
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));

			Utils.click(By.xpath(getObj("Propval1", "SADAD_MobileRechargeLnk", "SADAD_MobileRecharge")), "Sadad Mobile Recharge Link");
			
			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SADAD_MobileRecharge_title", "SADAD_MobileRecharge")), "Mobile Recharge"));
				Log.pass(" Mobile Recharge home page has displayed as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "SADAD_MobileRecharge_title", "SADAD_MobileRecharge"))));
				Utils.logPassImage(" Mobile Recharge home page");
				//return true;

			} catch (AssertionError | Exception e) {

				Log.fail(" Mobile Recharge home page has not displayed. Should have failed.");
				Utils.logFailImage(" Mobile Recharge home page-fail");
				throw e;

			}
		
			
			Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "Beneficiary_DD", "SADAD_MobileRecharge")),
					BeneficiaryType,"Beneficiary dropdown");
			
			Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "Biller_DD", "SADAD_MobileRecharge")),
					BillerType,"BillerType dropdown");
			
			Utils.sendKeys(By.xpath(getObj("Propval1", "Nickname_txt", "SADAD_MobileRecharge")),Nickname,"Nickname text box");
			
			Utils.sendKeys(By.xpath(getObj("Propval1", "SubscriptionID_txt", "SADAD_MobileRecharge")),
					SubscriptionID,"SubscriptionID text box");
			
			Utils.sendKeys(By.xpath(getObj("Propval1", "Amount_txt", "SADAD_MobileRecharge")),
					AMOUNT,"Amount text box");
			Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "AccountNo_DD", "SADAD_MobileRecharge")),
					AccountNumber,"AccountNumber drop down");
			
			if (Integer.parseInt(Exec_Proceed_btn) == 1)
				
			{
				Utils.click(By.xpath(getObj("Propval1", "Proceed_btn", "SADAD_MobileRecharge")), "Proceed button");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			}
			else if (Integer.parseInt(Exec_Proceed_btn) == 2) {
				
				
				Utils.click(By.xpath(getObj("Propval1", "AddAnotherTrans_btn", "SADAD_MobileRecharge")), "AddAnotherTransaction Button on Execution page");

				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "Beneficiary_DD", "SADAD_MobileRecharge")),BeneficiaryType,"Beneficiary dropdown");
				
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "Biller_DD", "SADAD_MobileRecharge")),
						BillerType,"BillerType dropdown");
				Utils.sendKeys(By.xpath(getObj("Propval1", "Nickname_txt", "SADAD_MobileRecharge")),
						Nickname,"Nickname text box");
				
				Utils.sendKeys(By.xpath(getObj("Propval1", "SubscriptionID_txt", "SADAD_MobileRecharge")),
						SubscriptionID,"SubscriptionID text box");
				
				Utils.sendKeys(By.xpath(getObj("Propval1", "Amount_txt", "SADAD_MobileRecharge")),
						AMOUNT,"Amount text box");
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "AccountNo_DD", "SADAD_MobileRecharge")),
						AccountNumber,"AccountNumber drop down");
				Utils.click(By.xpath(getObj("Propval1", "Proceed_btn", "SADAD_MobileRecharge")), "Proceed button");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				
				
			}
			else if (Integer.parseInt(Exec_Proceed_btn) == 3) {
				Utils.click(By.xpath(getObj("Propval1", "AddANewMobile_btn", "SADAD_MobileRecharge")), "AddANewMobile button");
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "BillerNewMobile_DD", "SADAD_MobileRecharge")),
						BillerType_NewMobile,"BillerType dropdown");
				
				Utils.sendKeys(By.xpath(getObj("Propval1", "NicknameNewmobile_txt", "SADAD_MobileRecharge")),
						Nickname_NewMobile,"Nickname text box");
				
				Utils.sendKeys(By.xpath(getObj("Propval1", "SubscriptionIDNewMobile_txt", "SADAD_MobileRecharge")),
						SubscriptionID_NewMobile,"SubscriptionID text box");
				Utils.click(By.xpath(getObj("Propval1", "Proceed_btn", "SADAD_MobileRecharge")), "Proceed button");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				Utils.click(By.xpath(getObj("Propval1", "Confirmation_Confirm_btn", "SADAD_MobileRecharge")), "Confirm Button on Confirmation page");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				Utils.enterOTPAndProceed();
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
					
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Home_btn_FinalPage", "SADAD_MobileRecharge")), "Home button FinalPage"));
					Log.pass("Mobile recharge results page is appearing as expected");
					Utils.logPassImage("Results page-Pass");
					//return true;

				} catch (AssertionError | Exception e) {

					Log.fail("Mobile recharge results page is not appearing");
					Utils.logFailImage("Results page-fail");
					throw e;

				}
				
			}
			else if (Integer.parseInt(Exec_Proceed_btn) == 4) {
				Utils.click(By.xpath(getObj("Propval1", "ManageMobile_btn", "SADAD_MobileRecharge")), "ManageMobile button");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				
				
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SADAD_ManageMobiles_title", "SADAD_MobileRecharge")), "Manage Mobiles page"));
					Log.pass("Manage Mobiles page is appearing as expected");
					Utils.logPassImage("Mobiles page-Pass");
					//return true;

				} catch (AssertionError | Exception e) {

					Log.fail("Manage Mobiles page is not appearing ");
					Utils.logFailImage("Mobiles page-fail");
					throw e;

				}
				return runResult;
			}
			else
			{
				Utils.click(By.xpath(getObj("Propval1", "Confirmation_Cancel_btn", "SADAD_MobileRecharge")), "cancel Button on Confirmation page");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				return runResult;
			}
			
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			if (Integer.parseInt(Confirmation_btn) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "Confirmation_Confirm_btn", "SADAD_MobileRecharge")), "Confirm Button on Confirmation page");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			}
			else if (Integer.parseInt(Confirmation_btn) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "Confirmation_Modify_btn", "SADAD_MobileRecharge")), "modify Button on Confirmation page");
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "Beneficiary_DD", "SADAD_MobileRecharge")),BeneficiaryType,"Beneficiary dropdown");
				
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "Biller_DD", "SADAD_MobileRecharge")),
						BillerType,"BillerType dropdown");
				Utils.sendKeys(By.xpath(getObj("Propval1", "Nickname_txt", "SADAD_MobileRecharge")),
						Nickname,"Nickname text box");
				
				Utils.sendKeys(By.xpath(getObj("Propval1", "SubscriptionID_txt", "SADAD_MobileRecharge")),
						SubscriptionID,"SubscriptionID text box");
				
				Utils.sendKeys(By.xpath(getObj("Propval1", "Amount_txt", "SADAD_MobileRecharge")),
						AMOUNT,"Amount text box");
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "AccountNo_DD", "SADAD_MobileRecharge")),
						AccountNumber,"AccountNumber drop down");
				Utils.click(By.xpath(getObj("Propval1", "Proceed_btn", "SADAD_MobileRecharge")), "Proceed button");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				Utils.click(By.xpath(getObj("Propval1", "Confirmation_Confirm_btn", "SADAD_MobileRecharge")), "Confirm Button on Confirmation page");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			}
			
						
			try {
				Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Mobilerecharge_Error", "SADAD_MobileRecharge")), "Error message on FinalPage"));
				Log.pass("Your Mobile Recharge request has been completed successfully");
				Utils.logPassImage("Mobiles Recharge final page-pass");
				

			} catch (AssertionError | Exception e) {

				Log.fail(" Your Mobile Recharge request has failed . Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "Mobilerecharge_Error", "SADAD_MobileRecharge"))));
				Utils.logFailImage("Mobiles Recharge final page-fail");
				
				throw e;

			}
			
						
			if (Integer.parseInt(Exec_Proceed_btn) == 2) {
				addFavSendEmailDownloadPdfNprintFunc1();		
			}
			else
			{
			addFavSendEmailDownloadPdfNprintFunc();	
			}
			
		}

		catch (Exception e) {
			runResult = false;
			throw e;
		}
	
		return runResult;
	}

	
	
	public static boolean addFavSendEmailDownloadPdfNprintFunc() throws Exception {
		try {
			Utils.wait(3);
			//to click Export PDF link
			Utils.click(By.xpath(getObj("Propval1", "ExportPDF", "SADAD_MobileRecharge")), "Export PDF link");
			Utils.wait(3);
			//to click Print link
			Utils.click(By.xpath(getObj("Propval1", "Print", "SADAD_MobileRecharge")), "Print link");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.wait(3);
			//to click Send By Email link
			Utils.click(By.xpath(getObj("Propval1", "SendByEmail", "SADAD_MobileRecharge")), "Send By Email link");
			Utils.wait(3);
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "SADAD_MobileRecharge")), ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "SADAD_MobileRecharge")), ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "SADAD_MobileRecharge")), ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "SADAD_MobileRecharge")), ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "SADAD_MobileRecharge")), ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn", "SADAD_MobileRecharge")), "Send by Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			Utils.pressEnter();
			Utils.wait(3);
			Utils.pressEscapeKey(3);
			//driver.findElement(By.id("lelo")).click();
			// add success assertion
			}

		catch (Exception e) {
			
			Log.fail("addFavSendEmailDownloadPdfNprintFunc has failed..error "+ Utils.getText(By.xpath(getObj("Propval1", "ErrorMsg_SendByEmail", "Additional_Options"))));
			runResult = false;
			throw e;
		}


	return runResult;
}


	public static boolean addFavSendEmailDownloadPdfNprintFunc1() throws Exception {
		try {
			Utils.wait(3);
			//to click Export PDF link
			Utils.click(By.xpath(getObj("Propval1", "ExportPDF", "SADAD_MobileRecharge")), "Export PDF link");
			Utils.wait(3);
			//to click Print link
			Utils.click(By.xpath(getObj("Propval1", "Print", "SADAD_MobileRecharge")), "Print link");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.wait(3);
			//to click Send By Email link
			Utils.click(By.xpath(getObj("Propval1", "SendByEmail", "SADAD_MobileRecharge")), "Send By Email link");
			Utils.wait(3);
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo1", "SADAD_MobileRecharge")), ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC1", "SADAD_MobileRecharge")), ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail1", "SADAD_MobileRecharge")), ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject1", "SADAD_MobileRecharge")), ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox1", "SADAD_MobileRecharge")), ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn1", "SADAD_MobileRecharge")), "Send by Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			Utils.pressEnter();
			Utils.wait(3);
			Utils.pressEscapeKey(3);
			//driver.findElement(By.id("lelo")).click();
			// add success assertion
			}

		catch (Exception e) {
			
			Log.fail("addFavSendEmailDownloadPdfNprintFunc has failed..error "+ Utils.getText(By.xpath(getObj("Propval1", "ErrorMsg_SendByEmail", "Additional_Options"))));
			runResult = false;
			throw e;
		}


	return runResult;
}

}
