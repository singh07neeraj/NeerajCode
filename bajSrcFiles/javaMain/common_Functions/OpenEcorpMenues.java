package javaMain.common_Functions;

import static Utilities.ReadData.getObj;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;

public class OpenEcorpMenues extends TestBase {
	static boolean isPageOpened = false;

	public static void openTransfersMenu(String menuName) throws Exception {

		Utils.scrollUpVertically();
		Utils.enterOTPAndProceed();
		Utils.mouseHover(By.xpath(getObj("Propval1", "Transfers", "Menues")));

		if (menuName.contains("Local")) {

			Utils.click(By.xpath(getObj("Propval1", "TransfersLocal", "Menues")), "Local Transfers");
		}
		if (menuName.contains("AddNewBeneficiary")) {

			Utils.click(By.xpath(getObj("Propval1", "Add_New_Beneficiary", "Menues")), "Add New Beneficiary");
		}
		if (menuName.contains("BeneficiaryManagement")) {

			Utils.click(By.xpath(getObj("Propval1", "Add_New_Beneficiary_Menu_N", "Add_New_Beneficiary")), "Beneficiary Management");
		}
		if (menuName.contains("Standing Order Management")) {

			Utils.click(By.xpath(getObj("Propval1", "ordermanagement", "STANDING_ORDERS_MANAGEMENT")), "Standing Order Management");
		}

		if (menuName.contains("International")) {

			Utils.click(By.xpath(getObj("Propval1", "ITransfersLnk", "JOL_INTLTransfer")), "Clicked on International Transfer link");

		}
		if (menuName.contains("CharityDonations")) {

			Utils.click(By.xpath(getObj("Propval1", "charity", "JOL_charity")), "Charity Donations ");

		}

		if (menuName.contains("StandingOrders")) {

			Utils.click(By.xpath(getObj("Propval1", "StandingOrders", "Menues")), "Transfers Management");
			Utils.logPassImage("Standing Orders");

		}
		if (menuName.contains("WithinBankAlJazira")) {

			// click on Transfer Link
			Utils.click(By.xpath(getObj("Propval1", "WithinBankAlJazira", "Menues")), "Within Bank AlJazira");
			Utils.wait(2);
			Utils.logPassImage("Charity Donations");

		}

		if (menuName.contains("BetweenMyAccounts")) {

			Utils.click(By.xpath(getObj("Propval1", "BetweenMyAccounts", "Menues")), "Between My Accounts");
		}
		Log.pass("Successfully opened menu : " + menuName);

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

	public static void openAljaziraCapitalMenu(String menuName) throws Exception {

		try {

			Utils.scrollUpVertically();
			// *[contains(@class,'i i-nav_brokerage')]
			Utils.mouseHover(By.xpath(getObj("Propval1", "aljaziraCapTab", "Menues")));

			if (menuName.contains("MutualFunds")) {

				Utils.click(By.xpath(getObj("Propval1", "MutualFundsLanding", "Menues")), "Mutual Funds");
			}

			if (menuName.contains("Subscription History")) {

				Utils.click(By.xpath(getObj("Propval1", "subscriptionHistory", "Menues")), "Subscription History");
			}

			if (menuName.contains("RedemptionHistory")) {

				Utils.click(By.xpath(getObj("Propval1", "redemptionHistory", "Menues")), "Redemption History");
			}

			if (menuName.contains("PortfolioValuation")) {

				Utils.click(By.xpath(getObj("Propval1", "portfolioValuation", "Menues")), "Portfolio Valuation");
			}

			if (menuName.contains("OrdersInquiry")) {

				Utils.click(By.xpath(getObj("Propval1", "ordersInquiry", "Menues")), "Orders Inquiry");

				if (Utils.getSizeNoException(By.xpath(getObj("Propval1", "ordersInquiryLandingPage", "Menues"))) > 0) {
					isPageOpened = true;
				}
			}

			if (menuName.contains("Market Information")) {

				Utils.click(By.xpath(getObj("Propval1", "marketInformation", "Menues")), "Market Information");

				if (Utils.getSizeNoException(By.xpath(getObj("Propval1", "marketInfoLandingPage", "Menues"))) > 0) {
					isPageOpened = true;
				}
			}

			if (menuName.contains("MutualFundsRate")) {

				Utils.click(By.xpath(getObj("Propval1", "mutualFundsRate", "Menues")), "Market Information");

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

	public static void PendingActionsMenu(String menuName) {

		try {

			Utils.click(By.xpath(getObj("Propval1", "pendingActionsTab", "Menues")), "Pending Actions");

			if (menuName.contains("PendingActions")) {

				Utils.click(By.xpath(getObj("Propval1", "pendingActionsLink", "Menues")), "Pending Actions Link");
			}

			if (menuName.contains("FailedRequests")) {

				Utils.click(By.xpath(getObj("Propval1", "FailedRequests", "Menues")), "Failed Requests Link");
				
				
			}
			if (menuName.contains("AuditPendingActions")) {

				Utils.click(By.xpath(getObj("Propval1", "Accounting", "Menues")), "Accounting Link");
				Utils.wait(3);
				Utils.click(By.xpath(getObj("Propval1", "AuditPendingActions", "Menues")), "Audit Pending Actions Link");
			}
			Log.info("Successfully opened menu : " + menuName);

		} catch (Exception e) {

			Log.fail("Uable to open menue : " + menuName + "  error :..." + ExceptionUtils.getStackTrace(e));

		}

	}
}