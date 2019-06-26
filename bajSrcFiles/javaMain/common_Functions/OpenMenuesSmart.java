package javaMain.common_Functions;

import static Utilities.ReadData.getObj;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;

public class OpenMenuesSmart extends TestBase {

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

		boolean isPageOpened = false;
		try {

			Utils.scrollUpVertically();

			Utils.mouseHover(By.xpath(getObj("Propval1", "aljaziraCapTab", "Menus_Smart")));

			if (menuName.contains("Subscription History")) {

				Utils.click(By.xpath(getObj("Propval1", "subscriptionHistory", "Menus_Smart")),"Subscription History");
			}

			if (menuName.contains("Redemption History")) {

				Utils.click(By.xpath(getObj("Propval1", "redemptionHistory", "Menus_Smart")),"Redemption History");
			}

			if (menuName.contains("Portfolio Valuation")) {

				Utils.click(By.xpath(getObj("Propval1", "portfolioValuation", "Menus_Smart")),"Portfolio Valuation");
			}

			if (menuName.contains("Orders Inquiry")) {

				Utils.click(By.xpath(getObj("Propval1", "ordersInquiry", "Menus_Smart")),"Orders Inquiry");

				if (Utils.getSize(By.xpath(getObj("Propval1", "ordersInquiryLandingPage", "Menus_Smart"))) > 0) {

					isPageOpened = true;
				}
			}
			if (menuName.contains("Market Information")) {

				Utils.click(By.xpath(getObj("Propval1", "marketInformation", "Menus_Smart")),"Market Information");

				if (Utils.getSize(By.xpath(getObj("Propval1", "marketInfoLandingPage", "Menus_Smart"))) > 0) {

					isPageOpened = true;
				}
			}
			if (isPageOpened) {
				Log.info("Successfully opened menu : " + menuName);
			}
			if (menuName.contains("Market Information")) {

				Utils.click(By.xpath(getObj("Propval1", "marketInformation", "Menus_Smart")),"Market Information");

				if (Utils.getSize(By.xpath(getObj("Propval1", "marketInfoLandingPage", "Menus_Smart"))) > 0) {

					isPageOpened = true;
				}
			}
			if (isPageOpened) {
				Log.info("Successfully opened menu : " + menuName);
			}
			if (menuName.contains("Market Information")) {

				Utils.click(By.xpath(getObj("Propval1", "marketInformation", "Menus_Smart")),"Market Information");

				if (Utils.getSize(By.xpath(getObj("Propval1", "marketInfoLandingPage", "Menus_Smart"))) > 0) {

					isPageOpened = true;
				}
			}
			if (isPageOpened) {
				Log.info("Successfully opened menu : " + menuName);
			}
			if (menuName.contains("Market Information")) {

				Utils.click(By.xpath(getObj("Propval1", "marketInformation", "Menus_Smart")),"Market Information");

				if (Utils.getSize(By.xpath(getObj("Propval1", "marketInfoLandingPage", "Menus_Smart"))) > 0) {

					isPageOpened = true;
				}
			}
			if (isPageOpened) {
				Log.info("Successfully opened menu : " + menuName);
			}

		} catch (Exception e) {

			Log.error("Uable to open menu : " + menuName + ExceptionUtils.getStackTrace(e));
			gException = e;
			throw gException;

		}

	}


	public static void openAljaziraCapitalMenuSmart(String menuName) throws Exception {

		try {

			Utils.scrollUpVertically();

			Utils.click_Smart(By.xpath(getObj("Propval1", "AlJaziraCapital_lnk", "Menus_Smart")),"AlJazira Capital link");
			Utils.wait(3);
			if (menuName.contains("IPOSubscription")) {

				Utils.click(By.xpath(getObj("Propval1", "IPOSubscription_lnk", "Menus_Smart")),"IPO Subscription link");
			}

			if (menuName.contains("InquiryIPO_Subscription")) {

				Utils.click(By.xpath(getObj("Propval1", "Inq_IPOSubscription_lnk", "Menus_Smart")),"Inquiry IPO Subscription link");
			}

			
			Log.info("Successfully opened menu : " + menuName);
		

		} catch (Exception e) {

			Log.error("Uable to open menu : " + menuName + ExceptionUtils.getStackTrace(e));
			gException = e;
			throw gException;

		}

	}

	public static void GovernmentServiceMenu(String menuName) throws Exception{


		try {

			Utils.scrollUpVertically();

			Utils.click_Smart(By.xpath(getObj("Propval1", "GovtPayments_lnk", "Menus_Smart")),"Govt Payments link");
			Utils.wait(3);
			if (menuName.equalsIgnoreCase("GPayment")) {

				Utils.click(By.xpath(getObj("Propval1", "Govt_Payment_lnk", "Menus_Smart")),"Payment link");
			}
			if (menuName.equalsIgnoreCase("Payments_Refund")) {

				Utils.click(By.xpath(getObj("Propval1", "Govt_PaymentToRefund_lnk", "Menus_Smart")),"Payments to refund link");
			}
			if (menuName.equalsIgnoreCase("Active_Absher")) {

				Utils.click(By.xpath(getObj("Propval1", "Govt_ActiveAbsher_lnk", "Menus_Smart")),"Active absher link");
			}
			if (menuName.equalsIgnoreCase("Beneficiary_Mgmt")) {

				Utils.click(By.xpath(getObj("Propval1", "Govt_BeneficiaryMgmt_lnk", "Menus_Smart")),"Beneficiary Mgmt link");
			}
			if (menuName.equalsIgnoreCase("Payment_Refunds_History")) {

				Utils.click(By.xpath(getObj("Propval1", "Govt_PaymentRefundHistory_lnk", "Menus_Smart")),"Payments refund history link");
			}
			

			
			Log.info("Successfully opened menu : " + menuName);
		

		} catch (Exception e) {

			Log.error("Uable to open menu : " + menuName + ExceptionUtils.getStackTrace(e));
			gException = e;
			throw gException;

		}

	
		
	}
}

