package javaMain.common_Functions;

import static Utilities.ReadData.getObj;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;

public class OpenMenuesSmart_Raja extends TestBase {

	public static void openTransfersMenu(String menuName) throws Exception {
		try {
			
		
		Utils.click(By.xpath(getObj("Propval1", "Transfers_lnk", "Menus_Smart")),"Transfers link");

		if (menuName.contains("Local")) {

			Utils.click(By.xpath(getObj("Propval1", "LocalTransfer_lnk", "Menus_Smart")),"Local Transfers link");
		}
		if (menuName.contains("Between")) {

			Utils.click(By.xpath(getObj("Propval1", "BetweenMyAccounts_lnk", "Menus_Smart")),"BetweenMyAccounts link");
		}
		if (menuName.contains("Within")) {

			Utils.click(By.xpath(getObj("Propval1", "WithinBankAlJazira_lnk", "Menus_Smart")),"Within Bank AlJazira link");
		}
		if (menuName.contains("International")) {

			Utils.click(By.xpath(getObj("Propval1", "InternationalTransfer_lnk", "Menus_Smart")),"International Transfer link");
		}
		if (menuName.contains("Charity")) {

			Utils.click(By.xpath(getObj("Propval1", "CharityDonations_lnk", "Menus_Smart")),"Charity Donations link");
		}
		if (menuName.contains("Transfers")) {

			Utils.click(By.xpath(getObj("Propval1", "TransfersManagement_lnk", "Menus_Smart")),"Transfers Management link");
		}
		if (menuName.contains("Household")) {

			Utils.click(By.xpath(getObj("Propval1", "Household_lnk", "Menus_Smart")),"Household Worker Salaries link");
		}
		if (menuName.contains("History")) {

			Utils.click(By.xpath(getObj("Propval1", "TransfersHistory_lnk", "Menus_Smart")),"Transfers History link");
		}
				
		if (menuName.contains("AddNewBeneficiary")) {

			Utils.click(By.xpath(getObj("Propval1", "AddNewBeneficiary_lnk", "Menus_Smart")),"Add New Beneficiary link");
		}
		if (menuName.contains("BeneficiaryManagement")) {
			
			Utils.click(By.xpath(getObj("Propval1", "BeneficiaryManagement_lnk", "Menus_Smart")),"Beneficiary Management link");
		}
		Log.pass("Successfully opened menu : " + menuName);
		} catch (Exception e) {
			Log.fail("Uable to open menue : " + menuName + e.getMessage());
		}
	}

	/***
	 * @Description This method can be used to open Accounts menu and sub menues
	 *              using the menu name using mouse hover
	 * @param menuName- SImply pass the menu name as per the Obj.xml file's objname.
	 */
	public static void openAccountMenu(String menuName) {

		try {

			Utils.click_Smart(By.xpath(getObj("Propval1", "Accounts_lnk", "Menus_Smart")),"Accounts link");
			Utils.wait(3);
			if (menuName.contains("AccountsSummary")) {

				Utils.click_Smart(By.xpath(getObj("Propval1", "AccountsSummary_lnk", "Menus_Smart")),"AccountsSummary link");
			}
			
			if (menuName.contains("RequestStatementByMail")) {

				Utils.click_Smart(By.xpath(getObj("Propval1", "ReqStmtByMail_lnk", "Menus_Smart")),"RequestStatementByEMail link");
			}

			if (menuName.contains("LostOrStolenCheque")) {

				Utils.click_Smart(By.xpath(getObj("Propval1", "ReportLostStolen_lnk", "Menus_Smart")),"LostOrStolenCheque link");
			}
			if (menuName.contains("OrderCheckBook")) {

				Utils.click_Smart(By.xpath(getObj("Propval1", "OrderChkBook_lnk", "Menus_Smart")),"OrderCheckBook link");
			}

			if (menuName.contains("AccountsConfiguration")) {

				Utils.click_Smart(By.xpath(getObj("Propval1", "AcctsConfig_lnk", "Menus_Smart")),"AccountsConfiguration link");
			}
		
			
			Log.pass("Successfully opened menu : " + menuName);
		}

		catch (Exception e) {

			Log.fail("Uable to open menue : " + menuName + e.getMessage());

		}
	}

	/***
	 * @Description This method can be used to open Fawri menu and sub menues
	 *              using the menu name using mouse hover
	 * @param menuName- SImply pass the menu name as per the Obj.xml file's objname.
	 */
	public static void openFawriMenu(String menuName) {

		try {

			Utils.click_Smart(By.xpath(getObj("Propval1", "Fawri_lnk", "Menus_Smart")),"Fawri link");
			Utils.wait(3);
			if (menuName.contains("MoneyTransfer")) {

				Utils.click_Smart(By.xpath(getObj("Propval1", "MoneyTransfer_lnk", "Menus_Smart")),"MoneyTransfer link");
			}
			
			if (menuName.contains("TransfersHistory")) {

				Utils.click_Smart(By.xpath(getObj("Propval1", "TransfersHis_lnk", "Menus_Smart")),"TransfersHistory link");
			}

			if (menuName.contains("ProfileRegistration")) {

				Utils.click_Smart(By.xpath(getObj("Propval1", "ProfileReg_lnk", "Menus_Smart")),"ProfileRegistration link");
			}
			if (menuName.contains("AddNewFawriBeneficiary")) {

				Utils.click_Smart(By.xpath(getObj("Propval1", "AddNewFawriBen_lnk", "Menus_Smart")),"AddNewFawriBeneficiary link");
			}

			if (menuName.contains("FawriBeneficiaryMgmt")) {

				Utils.click_Smart(By.xpath(getObj("Propval1", "FawriBenMgmt_lnk", "Menus_Smart")),"FawriBeneficiary link");
			}
			if (menuName.contains("ComplaintManagement")) {

				Utils.click_Smart(By.xpath(getObj("Propval1", "ComplaintMgmt_lnk", "Menus_Smart")),"ComplaintManagement link");
			}
		
			
			Log.pass("Successfully opened menu : " + menuName);
		}

		catch (Exception e) {

			Log.fail("Uable to open menue : " + menuName + e.getMessage());

		}
	}

	public static void openSelfServicesMenu(String menuName) {

		try {

			Utils.click(By.xpath(getObj("Propval1", "SelfService_lnk", "Menus_Smart")),"SelfService link");

			if (menuName.contains("SimahRegistration")) {

				Utils.click(By.xpath(getObj("Propval1", "SimahRegistration", "Menus_Smart")),"SimahRegistration");
			}

			

			Log.info("Successfully opened menu : " + menuName);
		}

		catch (Exception e) {

			Log.error("Uable to open menue : " + menuName + e.getMessage());

		}
	}

	public static void openCardsMenu(String menuName) throws Exception {

		try {

			Utils.mouseHover(By.xpath(getObj("Propval1", "Cards", "Menus_Smart")));
			if (menuName.contains("CDetails")) {

				Utils.click(By.xpath(getObj("Propval1", "CDetails", "Menus_Smart")),"CDetails");
			}

			if (menuName.contains("CTransaction")) {

				Utils.click(By.xpath(getObj("Propval1", "CTransaction", "Menus_Smart")),"CTransaction");
			}

			if (menuName.contains("CPendingTransactions")) {

				Utils.click(By.xpath(getObj("Propval1", "CPendingTransactions", "Menus_Smart")),"CPendingTransactions");
			}

			if (menuName.contains("CCardPayments")) {

				Utils.click(By.xpath(getObj("Propval1", "CCardPayments", "Menus_Smart")),"CCardPayments");
			}

			if (menuName.contains("CCashTransfer")) {

				Utils.click(By.xpath(getObj("Propval1", "CCashTransfer", "Menus_Smart")),"CCashTransfer");
			}

			if (menuName.contains("Cestatment")) {

				Utils.click(By.xpath(getObj("Propval1", "Cestatment", "Menus_Smart")),"Cestatment");
			}

			if (menuName.contains("CStopnReplaceCard")) {

				Utils.click(By.xpath(getObj("Propval1", "CStopnReplaceCard", "Menus_Smart")),"CStopnReplaceCard");
			}

			if (menuName.contains("CCardPaymentHistory")) {

				Utils.click(By.xpath(getObj("Propval1", "CCardPaymentHistory", "Menus_Smart")),"CCardPaymentHistory");
			}

			if (menuName.contains("CDisputePayment")) {

				Utils.click(By.xpath(getObj("Propval1", "CDisputePayment", "Menus_Smart")),"CDisputePayment");
			}

			if (menuName.contains("CApplyCreditCard")) {

				Utils.click(By.xpath(getObj("Propval1", "CApplyCreditCard", "Menus_Smart")),"CApplyCreditCard");
			}

			if (menuName.contains("CTempLimit")) {

				Utils.click(By.xpath(getObj("Propval1", "CTempLimit", "Menus_Smart")),"CTempLimit");
			}

			if (menuName.contains("CBeneficiaryManagement")) {

				Utils.click(By.xpath(getObj("Propval1", "CBeneficiaryManagement", "CBeneficiaryManagement")),"CBeneficiaryManagement");
			}

			if (menuName.contains("CActivateCreditCard")) {

				Utils.click(By.xpath(getObj("Propval1", "CActivateCreditCard", "Menus_Smart")),"CActivateCreditCard");
			}

			if (menuName.contains("CAddNewBeneficiary")) {

				Utils.click(By.xpath(getObj("Propval1", "CAddNewBeneficiary", "Menus_Smart")),"CAddNewBeneficiary");
			}
			if (menuName.contains("CUpdateOnlineTransactionsStatus")) {

				Utils.click(By.xpath(getObj("Propval1", "CUpdateOnlineTransactionsStatus", "Menus_Smart")),"CUpdateOnlineTransactionsStatus");
			}

			if (menuName.contains("CMokafaatyPointsRedemption")) {

				Utils.click(By.xpath(getObj("Propval1", "CMokafaatyPointsRedemption", "Menus_Smart")),"CMokafaatyPointsRedemption");
			}

			if (menuName.contains("CChangeSupplementaryCardLimit")) {

				Utils.click(By.xpath(getObj("Propval1", "CChangeSupplementaryCardLimit", "Menus_Smart")),"CChangeSupplementaryCardLimit");
			}

			if (menuName.contains("CResetCardPIN")) {

				Utils.click(By.xpath(getObj("Propval1", "CResetCardPIN", "Menus_Smart")),"CResetCardPIN");
			}

			if (menuName.contains("CreditCardPermanentLimitIncrease")) {

				Utils.click(By.xpath(getObj("Propval1", "CreditCardPermanentLimitIncrease", "Menus_Smart")),"CreditCardPermanentLimitIncrease");
			}

			if (menuName.contains("CRequestaSupplementaryCard")) {

				Utils.click(By.xpath(getObj("Propval1", "CRequestaSupplementaryCard", "Menus_Smart")),"CRequestaSupplementaryCard");
			}

			if (menuName.contains("RequestaSupplementaryCard")) {

				Utils.click(By.xpath(getObj("Propval1", "RequestaSupplementaryCard", "Menus_Smart")),"RequestaSupplementaryCard");
			}

			if (menuName.contains("DebitDetails")) {

				Utils.click(By.xpath(getObj("Propval1", "DebitDetails", "Menus_Smart")),"DebitDetails");
			}

			if (menuName.contains("DebitTransaction")) {

				Utils.click(By.xpath(getObj("Propval1", "DebitTransaction", "Menus_Smart")),"DebitTransaction");
			}

			if (menuName.contains("DebitCardStop")) {

				Utils.click(By.xpath(getObj("Propval1", "DebitCardStop", "Menus_Smart")),"DebitCardStop");
			}

			if (menuName.contains("DebitLinkTOOtherAccount")) {

				Utils.click(By.xpath(getObj("Propval1", "DebitLinkTOOtherAccount", "Menus_Smart")),"DebitLinkTOOtherAccount");
			}

			if (menuName.contains("DebitPOSLimit")) {

				Utils.click(By.xpath(getObj("Propval1", "DebitPOSLimit", "Menus_Smart")),"DebitPOSLimit");
			}

			if (menuName.contains("DebitReplace")) {

				Utils.click(By.xpath(getObj("Propval1", "DebitReplace", "Menus_Smart")),"DebitReplace");
			}

			Log.info("Successfully opened menu : " + menuName);
		}

		catch (Exception e) {

			Log.error("Uable to open menu : " + menuName + ExceptionUtils.getStackTrace(e));
			gException = e;
			throw gException;
		}
	}

	public static void openAljaziraCapitalMenu(String menuName) throws Exception {


		try {

			Utils.click_Smart(By.xpath(getObj("Propval1", "AlJaziraCapital_lnk", "Menus_Smart")),"AlJazira Capital link");
			Utils.wait(3);
			if (menuName.contains("IPOSubscription")) {

				Utils.click_Smart(By.xpath(getObj("Propval1", "IPOSubscription_lnk", "Menus_Smart")),"IPO Subscription link");
			}
			
			if (menuName.contains("InquiryIPOSubscription")) {

				Utils.click_Smart(By.xpath(getObj("Propval1", "Inq_IPOSubscription_lnk", "Menus_Smart")),"Inquiry IPOSubscription link");
			}
			
			Log.pass("Successfully opened menu : " + menuName);
		}

		catch (Exception e) {

			Log.fail("Uable to open menue : " + menuName + e.getMessage());

		}
	
	}

	public static void GovernmentServiceMenu(String menuName) {

		try {
			Utils.scrollDownVertically();
			Utils.mouseHover(By.xpath(getObj("Propval1", "GovtServices", "Menus_Smart")));

			if (menuName.contains("Payment")) {

				Utils.click(By.xpath(getObj("Propval1", "Payment", "Menus_Smart")),"Payment");
			}

			if (menuName.contains("Refund")) {

				Utils.click(By.xpath(getObj("Propval1", "Refund", "Menus_Smart")),"Refund");
			}

			if (menuName.contains("AbsherActivation")) {

				Utils.click(By.xpath(getObj("Propval1", "AbsherActivation", "Menus_Smart")),"AbsherActivation");
			}

			if (menuName.contains("AddNewBeneficiary")) {

				Utils.click(By.xpath(getObj("Propval1", "AddNewBeneficiary", "Menus_Smart")),"AddNewBeneficiary");
			}

			if (menuName.contains("BeneficiaryManagement")) {

				Utils.click(By.xpath(getObj("Propval1", "BeneficiaryManagement", "Menus_Smart")),"BeneficiaryManagement");
			}

			if (menuName.contains("PaymentsRefundsHistory")) {

				Utils.click(By.xpath(getObj("Propval1", "PaymentsRefundsHistory", "Menus_Smart")),"PaymentsRefundsHistory");
			}

			Log.info("Successfully opened menu : " + menuName);
		}

		catch (Exception e) {

			Log.error("Uable to open menue : " + menuName + e.getMessage());

		}

	}
}

