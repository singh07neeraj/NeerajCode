package javaMain.common_Functions;

import static Utilities.ReadData.getObj;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;

public class OpenJOLMenues extends TestBase {

	public static void openTransfersMenu(String menuName) throws Exception {

		Utils.pressEscapeKey(1);
		Utils.enterOTPAndProceed();
		Utils.pressEscapeKey(1);

		Utils.scrollUpVertically();
		Utils.mouseHover(By.xpath(getObj("Propval1", "Transfers", "Menues")));

		if (menuName.contains("TransfersHistory")) {
			Utils.click(By.xpath(getObj("Propval1", "TransfersLnk", "JOL_TRANSFERS_HISTORY")), "Click on Transfer Link");
			Utils.click(By.xpath(getObj("Propval1", "History", "JOL_TRANSFERS_HISTORY")), "Click on History ");
		}
		if (menuName.contains("WithinBaj_Transfers")) {

			Utils.click(By.xpath(getObj("Propval1", "WithInBajLnk_Menu_N", "WithinBaj_Transfers")), "Click on Transfer Within BAJ ");
		}
		if (menuName.contains("Local")) {

			Utils.click(By.xpath(getObj("Propval1", "TransfersLocal", "Menues")), "Local Transfers");
		}
		if (menuName.contains("Add New Beneficiary")) {

			Utils.click(By.xpath(getObj("Propval1", "Add_New_Beneficiary_Menu_N", "Add_New_Beneficiary")), "Add New Beneficiary");
		}
		if (menuName.contains("BeneficiaryManagement")) {

			Utils.click(By.xpath(getObj("Propval1", "BeneficiaryManagementTop", "BENEFICIARY_MANAGEMENT")), " Beneficiaries Management link");
		}
		if (menuName.contains("Standing Order Management")) {

			Utils.click(By.xpath(getObj("Propval1", "ordermanagement", "STANDING_ORDERS_MANAGEMENT")), "Standing Order Management");
		}

		if (menuName.contains("International")) {

			Utils.click(By.xpath(getObj("Propval1", "TransfersLnk", "JOL_INTLTransfer")), "Clicked on Transfer Link");
			Utils.click(By.xpath(getObj("Propval1", "ITransfersLnk", "JOL_INTLTransfer")), "Clicked on INternational Transfer link");
			Log.pass("Successfully opened menu : " + menuName);
		}
		if (menuName.contains("CharityDonations")) {

			Utils.click(By.xpath(getObj("Propval1", "charity", "JOL_charity")), "Charity Donations ");
			Log.pass("Successfully opened menu : " + menuName);

		}

		if (menuName.contains("StandingOrders")) {

			// click on Transfer Link
			Utils.mouseHover(By.xpath(getObj("Propval1", "TransfersLnk", "JOL_INTLTransfer")));
			Utils.wait(2);
			Utils.click(By.xpath(getObj("Propval1", "ordermanagement", "STANDING_ORDERS_MANAGEMENT")), "Order Management ");
			Utils.click(By.xpath(getObj("Propval1", "standardorder", "STANDING_ORDERS_MANAGEMENT")), "STANDING ORDERS MANAGEMENT");
			Utils.logPassImage("Charity Donations");

		}
	}

	/***
	 * @Description This method can be used to open Accounts menu and sub menues
	 *              using the menu name using mouse hover
	 * @param menuName- SImply pass the menu name as per the Obj.xml file's objname.
	 */
	public static void openAccountMenu(String menuName) {

		try {

			Utils.mouseHover(By.xpath(getObj("Propval1", "Accounts", "Menues", g_objFilePath)));

			if (menuName.contains("AccountsSummary")) {

				Utils.click(By.xpath(getObj("Propval1", "AccountsSummary", "Menues", g_objFilePath)), "AccountsSummary");
			}

			if (menuName.contains("AccountsDetails")) {

				Utils.click(By.xpath(getObj("Propval1", "AccountsDetails", "Menues", g_objFilePath)), "AccountsDetails");
			}

			if (menuName.contains("AccountsTransactions")) {

				Utils.click(By.xpath(getObj("Propval1", "AccountsTransactions", "Menues", g_objFilePath)), "AccountsTransactions");
			}

			if (menuName.contains("RequestStatementByEMail")) {

				Utils.click(By.xpath(getObj("Propval1", "RequestStatementByEMail", "Menues", g_objFilePath)), "RequestStatementByEMail");
			}

			if (menuName.contains("OpenAdditionalAccount")) {

				Utils.click(By.xpath(getObj("Propval1", "OpenAdditionalAccount", "Menues", g_objFilePath)), "OpenAdditionalAccount");
			}

			if (menuName.contains("AccountsConfiguration")) {

				Utils.click(By.xpath(getObj("Propval1", "AccountsConfiguration", "Menues", g_objFilePath)), "AccountsConfiguration");
			}

			if (menuName.contains("OpenHouseholdAccount")) {

				Utils.click(By.xpath(getObj("Propval1", "OpenHouseholdAccount", "Menues", g_objFilePath)), "OpenHouseholdAccount");
			}

			if (menuName.contains("OrderCheckBook")) {

				Utils.click(By.xpath(getObj("Propval1", "OrderCheckBook", "Menues", g_objFilePath)), "OrderCheckBook");
			}

			if (menuName.contains("LostOrStolenCheque")) {

				Utils.click(By.xpath(getObj("Propval1", "LostOrStolenCheque", "Menues", g_objFilePath)), "LostOrStolenCheque");
			}

			Log.info("Successfully opened menu : " + menuName);
		}

		catch (Exception e) {

			Log.error("Uable to open menue : " + menuName + e.getMessage());

		}
	}

	public static void openSelfServicesMenu(String menuName) {

		try {
			Utils.enterOTPAndProceed();
			Utils.scrollUpVertically();
			Utils.mouseHover(By.xpath(getObj("Propval1", "SelfServices", "Menues")));

			if (menuName.contains("SimahRegistration")) {

				Utils.click(By.xpath(getObj("Propval1", "SimahRegistration", "Menues")), "SimahRegistration");
			}

			if (menuName.contains("ExpenseCategorization")) {

				Utils.click(By.xpath(getObj("Propval1", "ExpenseCategorization", "Menues")), "ExpenseCategorization");
			}

			if (menuName.contains("AccountsTransactions")) {

				Utils.click(By.xpath(getObj("Propval1", "AccountsTransactions", "Menues")), "AccountsTransactions");
			}

			if (menuName.contains("ExpenseView")) {

				Utils.click(By.xpath(getObj("Propval1", "ExpenseView", "Menues")), "ExpenseView");
			}

			if (menuName.contains("ViewLimits")) {

				Utils.click(By.xpath(getObj("Propval1", "ViewLimits", "Menues")), "ViewLimits");
			}

			if (menuName.contains("CustomerProfile")) {

				Utils.click(By.xpath(getObj("Propval1", "CustomerProfile", "Menues")), "CustomerProfile");
			}

			if (menuName.contains("ChangeUserName")) {

				Utils.click(By.xpath(getObj("Propval1", "ChangeUserName", "Menues")), "ChangeUserName");
			}

			if (menuName.contains("ChangePassword")) {

				Utils.click(By.xpath(getObj("Propval1", "ChangePassword", "Menues")), "ChangePassword");
			}

			if (menuName.contains("Changeemail")) {

				Utils.click(By.xpath(getObj("Propval1", "Changeemail", "Menues")), "Changeemail");
			}

			if (menuName.contains("Contactus")) {

				Utils.click(By.xpath(getObj("Propval1", "Contactus", "Menues")), "Contactus");
			}

			if (menuName.contains("MessageBox")) {

				Utils.click(By.xpath(getObj("Propval1", "MessageBox", "Menues")), "MessageBox");
			}

			if (menuName.contains("AuditLogs")) {

				Utils.click(By.xpath(getObj("Propval1", "AuditLogs", "Menues")), "AuditLogs");
			}

			if (menuName.contains("UpdateNationalAddress")) {

				Utils.click(By.xpath(getObj("Propval1", "UpdateNationalAddress", "Menues")), "UpdateNationalAddress");
			}

			if (menuName.contains("UpdateIDExpiryDate")) {

				Utils.click(By.xpath(getObj("Propval1", "UpdateIDExpiryDate", "Menues")), "UpdateIDExpiryDate");
			}
			if (menuName.contains("FXRates")) {

				Utils.click(By.xpath(getObj("Propval1", "FXRates", "Menues")), "FXRates");
			}

			if (menuName.contains("CurrencyConverter")) {

				Utils.click(By.xpath(getObj("Propval1", "CurrencyConverter", "Menues")), "CurrencyConverter");
			}

			Log.info("Successfully opened menu : " + menuName);
		}

		catch (Exception e) {

			Log.error("Uable to open menu : " + menuName + ExceptionUtils.getStackTrace(e).trim());

		}
	}

	public static void openCardsMenu(String menuName) throws Exception {

		try {

			Utils.mouseHover(By.xpath(getObj("Propval1", "Cards", "Menues")));

			if (menuName.contains("CDetails")) {

				Utils.click(By.xpath(getObj("Propval1", "CDetails", "Menues")), "CDetails");
			}

			if (menuName.contains("CTransaction")) {

				Utils.click(By.xpath(getObj("Propval1", "CTransaction", "Menues")), "CTransaction");
			}

			if (menuName.contains("CPendingTransactions")) {

				Utils.click(By.xpath(getObj("Propval1", "CPendingTransactions", "Menues")), "CPendingTransactions");
			}

			if (menuName.contains("CCardPayments")) {

				Utils.click(By.xpath(getObj("Propval1", "CCardPayments", "Menues")), "CCardPayments");
			}

			if (menuName.contains("CCashTransfer")) {

				Utils.click(By.xpath(getObj("Propval1", "CCashTransfer", "Menues")), "CCashTransfer");
			}

			if (menuName.contains("Cestatment")) {

				Utils.click(By.xpath(getObj("Propval1", "Cestatment", "Menues")), "Cestatment");
			}

			if (menuName.contains("CStopnReplaceCard")) {

				Utils.click(By.xpath(getObj("Propval1", "CStopnReplaceCard", "Menues")), "CStopnReplaceCard");
			}

			if (menuName.contains("CCardPaymentHistory")) {

				Utils.click(By.xpath(getObj("Propval1", "CCardPaymentHistory", "Menues")), "CCardPaymentHistory");
			}

			if (menuName.contains("CDisputePayment")) {

				Utils.click(By.xpath(getObj("Propval1", "CDisputePayment", "Menues")), "CDisputePayment");
			}

			if (menuName.contains("CApplyCreditCard")) {

				Utils.click(By.xpath(getObj("Propval1", "CApplyCreditCard", "Menues")), "CApplyCreditCard");
			}

			if (menuName.contains("CTempLimit")) {

				Utils.click(By.xpath(getObj("Propval1", "CTempLimit", "Menues")), "CTempLimit");
			}

			if (menuName.contains("CBeneficiaryManagement")) {

				Utils.click(By.xpath(getObj("Propval1", "CBeneficiaryManagement", "CBeneficiaryManagement")), "CBeneficiaryManagement");
			}

			if (menuName.contains("CActivateCreditCard")) {

				Utils.click(By.xpath(getObj("Propval1", "CActivateCreditCard", "Menues")), "CActivateCreditCard");
			}

			if (menuName.contains("CAddNewBeneficiary")) {

				Utils.click(By.xpath(getObj("Propval1", "CAddNewBeneficiary", "Menues")), "CAddNewBeneficiary");
			}
			if (menuName.contains("CUpdateOnlineTransactionsStatus")) {

				Utils.click(By.xpath(getObj("Propval1", "CUpdateOnlineTransactionsStatus", "Menues")), "CUpdateOnlineTransactionsStatus");
			}

			if (menuName.contains("CMokafaatyPointsRedemption")) {

				Utils.click(By.xpath(getObj("Propval1", "CMokafaatyPointsRedemption", "Menues")), "CMokafaatyPointsRedemption");
			}

			if (menuName.contains("CChangeSupplementaryCardLimit")) {

				Utils.click(By.xpath(getObj("Propval1", "CChangeSupplementaryCardLimit", "Menues")), "CChangeSupplementaryCardLimit");
			}

			if (menuName.contains("CResetCardPIN")) {

				Utils.click(By.xpath(getObj("Propval1", "CResetCardPIN", "Menues")), "CResetCardPIN");
			}

			if (menuName.contains("CreditCardPermanentLimitIncrease")) {

				Utils.click(By.xpath(getObj("Propval1", "CreditCardPermanentLimitIncrease", "Menues")), "CreditCardPermanentLimitIncrease");
			}

			if (menuName.contains("CRequestaSupplementaryCard")) {

				Utils.click(By.xpath(getObj("Propval1", "CRequestaSupplementaryCard", "Menues")), "CRequestaSupplementaryCard");
			}

			if (menuName.contains("RequestaSupplementaryCard")) {

				Utils.click(By.xpath(getObj("Propval1", "RequestaSupplementaryCard", "Menues")), "RequestaSupplementaryCard");
			}

			if (menuName.contains("DebitDetails")) {

				Utils.click(By.xpath(getObj("Propval1", "DebitDetails", "Menues")), "DebitDetails");
			}

			if (menuName.contains("DebitTransaction")) {

				Utils.click(By.xpath(getObj("Propval1", "DebitTransaction", "Menues")), "DebitTransaction");
			}

			if (menuName.contains("DebitCardStop")) {

				Utils.click(By.xpath(getObj("Propval1", "DebitCardStop", "Menues")), "DebitCardStop");
			}

			if (menuName.contains("DebitLinkTOOtherAccount")) {

				Utils.click(By.xpath(getObj("Propval1", "DebitLinkTOOtherAccount", "Menues")), "DebitLinkTOOtherAccount");
			}

			if (menuName.contains("DebitPOSLimit")) {

				Utils.click(By.xpath(getObj("Propval1", "DebitPOSLimit", "Menues")), "DebitPOSLimit");
			}

			if (menuName.contains("DebitReplace")) {

				Utils.click(By.xpath(getObj("Propval1", "DebitReplace", "Menues")), "DebitReplace");
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
			// *[contains(@class,'i i-nav_brokerage')]
			Utils.click(By.xpath(getObj("Propval1", "aljaziraCapTab", "Menues")), "aljaziraCap Tab");
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			if (menuName.contains("Mutual Funds")) {

				Utils.click(By.xpath(getObj("Propval1", "MutualFundsLanding", "Menues")), "Mutual Funds");
			}

			if (menuName.contains("Subscription History")) {

				Utils.click(By.xpath(getObj("Propval1", "SubscriptionHistory", "Menues")), "Subscription History");
			}

			if (menuName.contains("RedemptionHistory")) {

				Utils.click(By.xpath(getObj("Propval1", "RedemptionHistory", "Menues")), "Redemption History");
			}

			if (menuName.contains("PortfolioValuation")) {

				Utils.click(By.xpath(getObj("Propval1", "PortfolioValuation", "Menues")), "Portfolio Valuation");
			}

			if (menuName.contains("OrdersInquiry")) {

				Utils.click(By.xpath(getObj("Propval1", "OrdersInquiry", "Menues")), "Orders Inquiry");

				if (Utils.getSizeNoException(By.xpath(getObj("Propval1", "ordersInquiryLandingPage", "Menues"))) > 0) {
					isPageOpened = true;
				}
			}

			if (menuName.contains("Market Information")) {

				Utils.click(By.xpath(getObj("Propval1", "MarketInformation", "Menues")), "Market Information");

				if (Utils.getSizeNoException(By.xpath(getObj("Propval1", "marketInfoLandingPage", "Menues"))) > 0) {
					isPageOpened = true;
				}
			}

			if (menuName.contains("MutualFundRate")) {

				Utils.click(By.xpath(getObj("Propval1", "MutualFundsRate", "Menues")), "Mutual Fund Rate");

				if (Utils.getSizeNoException(By.xpath(getObj("Propval1", "landingPage", "Menues"))) > 0) {
					isPageOpened = true;
				}

			}

			if (menuName.contains("OpenInvestmentAccount")) {

				Utils.click(By.xpath(getObj("Propval1", "OpenInvestmentAccount", "Menues")), "Open Investment Account");

				if (Utils.getSizeNoException(By.xpath(getObj("Propval1", "landingPage", "Menues"))) > 0) {
					isPageOpened = true;
				}

			}
			if (menuName.contains("MutualFundSubscription")) {

				Utils.click(By.xpath(getObj("Propval1", "MutualFundSubscription", "Menues")), "Mutual Fund Subscription");

				if (Utils.getSizeNoException(By.xpath(getObj("Propval1", "landingPage", "Menues"))) > 0) {
					isPageOpened = true;
				}

			}
			if (menuName.contains("IPORI_Inquiry")) {

				Utils.click(By.xpath(getObj("Propval1", "IPOServices_lnk", "Menues")), "IPOServices link");
				Utils.click(By.xpath(getObj("Propval1", "IPORI_Inquiry_lnk", "Menues")), "IPORI Inquiry link");

				if (Utils.getSizeNoException(By.xpath(getObj("Propval1", "landingPage", "Menues"))) > 0) {
					isPageOpened = true;
				}

			}
			if (menuName.contains("NewIPO")) {

				Utils.click(By.xpath(getObj("Propval1", "IPOServices_lnk", "Menues")), "IPOServices link");
				Utils.click(By.xpath(getObj("Propval1", "NewIPO_lnk", "Menues")), "NewIPO link");

				if (Utils.getSizeNoException(By.xpath(getObj("Propval1", "landingPage", "Menues"))) > 0) {
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

	public static void GovernmentServiceMenu(String menuName) {

		try {
			Utils.scrollDownVertically();
			Utils.mouseHover(By.xpath(getObj("Propval1", "GovtServices", "Menues")));

			if (menuName.contains("Payment")) {

				Utils.click(By.xpath(getObj("Propval1", "Payment", "Menues")), "Payment");
			}

			if (menuName.contains("Refund")) {

				Utils.click(By.xpath(getObj("Propval1", "Refund", "Menues")), "Refund");
			}

			if (menuName.contains("AbsherActivation")) {

				Utils.click(By.xpath(getObj("Propval1", "AbsherActivation", "Menues")), "AbsherActivation");
			}

			if (menuName.contains("AddNewBeneficiary")) {

				Utils.click(By.xpath(getObj("Propval1", "AddNewBeneficiary", "Menues")), "AddNewBeneficiary");
			}

			if (menuName.contains("BeneficiaryManagement")) {

				Utils.click(By.xpath(getObj("Propval1", "BeneficiaryManagement", "Menues")), "BeneficiaryManagement");
			}

			if (menuName.contains("PaymentsRefundsHistory")) {

				Utils.click(By.xpath(getObj("Propval1", "PaymentsRefundsHistory", "Menues")), "PaymentsRefundsHistory");
			}

			Log.info("Successfully opened menu : " + menuName);
		}

		catch (Exception e) {

			Log.error("Uable to open menue : " + menuName + e.getMessage());

		}

	}
}
