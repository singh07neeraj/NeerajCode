package Utilities;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javaMain.common_Functions.AppData;

public class ReadData extends TestBase {

	// static HashMap<String, String> PropTV = new HashMap<String, String>();
	static Map<String, String> PropTV = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
	static File fXmlFile = null;
	static Element eElement;
	// String pathLocal = null;
	static String PropTypeVal = null;
	static String ObjName = null;
	static String parentAttrName = null;

	/***
	 * @description This method will be used to read data from SQL master table and
	 *              return as String.TS name in DB table should be unique. This will
	 *              be used to decide whether a TS is configured to be run or NOT.
	 * @param Name       of the TS script. Should be same as present in DB table.
	 * @param ColumnName Name of the column from which you want to read data.
	 * @return returns DB cell data based on the script name and column name.
	 * @author baj80000892/Alok Rai & Rajshekhar
	 */
	public static String ReadDataSQLMaster(String Script_name, String ColumnName) {

		String AUT_DBIPPort = "10.242.25.108:1433";
		String AUT_DBName = "UAT1";

		String connectionUrl = "jdbc:sqlserver://" + AUT_DBIPPort + ";databaseName=" + AUT_DBName + ";integratedSecurity=true;";
		HashMap<String, String> ColumnData = new HashMap<String, String>();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionUrl);

			// Connection con=DriverManager.getConnection(
			// "jdbc:10.242.25.108:1433/UAT1","","");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// ResultSet r = stmt.executeQuery("select * from MasterTable where TS =" + "'"
			// + Script_name + "'");

			ResultSet r = stmt.executeQuery("select * from [UAT1].[dbo]." + AppData.getMasterTableName() + " " + "where Script_name =" + "'" + Script_name + "'");
			while (r.next()) {
				// ColumnData.put("Senario description",(String)
				// json.get("Senario description"));
				ColumnData.put("TS", r.getString("TS"));
				ColumnData.put("IncludeInExecution", r.getString("IncludeInExecution"));
				ColumnData.put("TaskName", r.getString("TaskName"));
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(ColumnData.get(ColumnName));
		return ColumnData.get(ColumnName);

	}

	/***
	 * description This method will be used to read data from Object xml files based
	 * on the parent and child attribute names in the xml. Basically used to read
	 * xpath for the page objects.
	 * 
	 * @param PropTypeVal, ObjName & parentAttrName
	 * @return value of the attribute name. or null if some error occurs.
	 * @author baj80000892/Alok Rai
	 */
	public static String getObj(String... values) {
		String finalVal = null;
		// PropTV = new HashMap<String, String>();

		PropTV = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);

		fXmlFile = null;
		Element eElement;
		// String pathLocal = null;
		PropTypeVal = values[0].toString();
		ObjName = values[1];
		parentAttrName = values[2];

		try {

			fXmlFile = new File(AppData.objXmlPath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();
			Element ele = doc.getDocumentElement();
			NodeList parentList = ele.getElementsByTagName("Page");
			for (int i = 0; i < parentList.getLength(); i++) {
				Node parentNode = parentList.item(i);
				if (parentNode.getAttributes() != null && parentNode.getAttributes().getNamedItem("Pgname") != null && parentNode.getAttributes().getNamedItem("Pgname").getNodeValue().equalsIgnoreCase(parentAttrName)) {
					NodeList nList = parentNode.getChildNodes();
					doc.getDocumentElement().normalize();

					for (int temp = 0; temp < nList.getLength(); temp++) {

						Node nNode = nList.item(temp);

						if (nNode.getNodeType() == Node.ELEMENT_NODE) {

							eElement = (Element) nNode;
							if (eElement.getAttribute("objname").equalsIgnoreCase(ObjName)) {

								String Propname1 = eElement.getAttribute("Propname1").toString().trim();
								String Propval1 = eElement.getAttribute("Propval1").toString().trim();
								String Propname2 = eElement.getAttribute("Propname2").toString().trim();
								String Propval2 = eElement.getAttribute("Propval2").toString().trim();

								PropTV.put("Propname1", Propname1);
								PropTV.put("Propval1", Propval1);
								PropTV.put("Propname2", Propname2);
								PropTV.put("Propval2", Propval2);

							}

						}
					}

				}
			}

		} catch (Exception e) {

			System.out.println("Unable to get object property for " + ObjName + "error");
			e.printStackTrace();
		}

		if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {

			try {

				finalVal = PropTV.get("Propval2"); // Try returning propVal2 is language is Arabic.
				if (finalVal.length() < 2) {
					finalVal = PropTV.get(PropTypeVal); // Give propVal1 if propVal2 is not there so that TC can run using 1st x path.
														// i.e common x paths which r same for both lang.
				}

			} catch (Exception e) {
				finalVal = PropTV.get(PropTypeVal);// Return propVal1 if any exception occurs above.
			}

		}

		else {

			finalVal = PropTV.get(PropTypeVal); // PropVal1 always i.e for Elnglish language
		}
		return finalVal;

	}

	// Not in use.
	public static String getObjArabic() {

		try {

			ObjName = ObjName.concat(".Arabic");
			fXmlFile = new File(AppData.objXmlPath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();
			Element ele = doc.getDocumentElement();
			NodeList parentList = ele.getElementsByTagName("Page");
			for (int i = 0; i < parentList.getLength(); i++) {
				Node parentNode = parentList.item(i);
				if (parentNode.getAttributes() != null && parentNode.getAttributes().getNamedItem("Pgname") != null && parentNode.getAttributes().getNamedItem("Pgname").getNodeValue().equalsIgnoreCase(parentAttrName)) {
					NodeList nList = parentNode.getChildNodes();
					doc.getDocumentElement().normalize();

					for (int temp = 0; temp < nList.getLength(); temp++) {

						Node nNode = nList.item(temp);

						if (nNode.getNodeType() == Node.ELEMENT_NODE) {

							eElement = (Element) nNode;
							if (eElement.getAttribute("objname").equalsIgnoreCase(ObjName)) {

								String Propname1 = eElement.getAttribute("Propname1").toString().trim();
								String Propval1 = eElement.getAttribute("Propval1").toString().trim();
								String Propname2 = eElement.getAttribute("Propname2").toString().trim();
								String Propval2 = eElement.getAttribute("Propval2").toString().trim();

								PropTV.put("Propname1", Propname1);
								PropTV.put("Propval1", Propval1);
								PropTV.put("Propname2", Propname2);
								PropTV.put("Propval2", Propval2);

							}

						}
					}

				}
			}

		} catch (Exception e) {

			// Log.error("Unable to get object property for " + ObjName + "error");
			e.printStackTrace();
		}

		return PropTV.get(PropTypeVal);
	}

	/***
	 * @description this method will be used to read config xml files which will be
	 *              consumed by the framework. Values like OTP, Browser name, login
	 *              credentials etc will be stored in this xml.
	 * @param parentAttrName- Name of the attribute for which you need the value.
	 * @return Value of the attribute name.
	 */
	public static String readConfigXml(String parentAttrName) {
		String Configdata = null;
		try {

			/*
			 * String path = System.getProperty("user.dir"); path = path +
			 * "\\" + "ReadObjProp_XML" + "\\" + "Configuration.xml";
			 */

			File fXmlFile = new File(g_appConfigXmlPath);
			if (g_appConfigXmlPath == null) {
				Log.fatal("Unable to read app config file.. path is null or not valid.. Check in test base method name- readConfigXml");
				return null;
			}
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("PublicVariable");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					if (eElement.getAttribute("name").equalsIgnoreCase(parentAttrName))

					{
						Configdata = eElement.getElementsByTagName("name").item(0).getTextContent();
						break;
					}
				}
			}
		} catch (Exception e) {

			Log.fatal("Unable to read app config file.. error.." + ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
		}

		return Configdata;
	}

	public static int RowCount(String Script_name) {

		String AUT_DBIPPort = "10.242.25.108:1433";
		String AUT_DBName = "UAT1";

		String connectionUrl = "jdbc:sqlserver://" + AUT_DBIPPort + ";databaseName=" + AUT_DBName + ";integratedSecurity=true;";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// ResultSet r = stmt.executeQuery("select * from TransferTSTable where
			// Script_name =" + "'" + Script_name + "'" + "");
			// ResultSet r = stmt.executeQuery("select * from
			// [UAT1].[dbo]."+AppData.getTStableName()+" "+"where Script_name =" + "'" +
			// Script_name + "'");

			ResultSet r = stmt.executeQuery("select * from [UAT1].[dbo]." + AppData.getTStableName() + " " + "where Script_name =" + "'" + Script_name + "'");

			if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {

				r = stmt.executeQuery("select * from [UAT1].[dbo]." + AppData.getTStableName() + " " + "where Script_name =" + "'" + Script_name + "'" + " and language='Arabic' ");
			//	Log.info("select * from [UAT1].[dbo]." + AppData.getTStableName() + " " + "where Script_name =" + "'" + Script_name + "'" + " and language='Arabic'");

			} else {
				r = stmt.executeQuery("select * from [UAT1].[dbo]." + AppData.getTStableName() + " " + "where Script_name =" + "'" + Script_name + "'" + " and language='EN' ");
			}

			r.last();
			Totalcount = r.getRow();

			return Totalcount;

		} catch (Exception e) {
			Log.fatal("Unable to get row count from DB.. error.." + ExceptionUtils.getStackTrace(e));
			return Totalcount;

		}
	}

	/***
	 * @description this method will be used to read data from SQL. This will be
	 *              used to basically read JSON data from the column name "Data Set"
	 *              in DB tables.The same JSON will be put in a map as key value
	 *              pairs and will be returned as String object based on the key
	 *              given.The test cases will call this method to get data in order
	 *              to complete their execution.
	 * @param Script_name - Name of the Test Case script.
	 * @param             ScenarioCount- Current Scenario count
	 * @param             ColumnName- Column name from which you need data. Mostly
	 *                    from "Data Set " column
	 * @return data value as String.
	 */
	public static String ReadDataSQL(String Script_name, int ScenarioCount, String ColumnName) {

		String AUT_DBIPPort = "10.242.25.108:1433";
		String AUT_DBName = "UAT1";
		String connectionUrl = "jdbc:sqlserver://" + AUT_DBIPPort + ";databaseName=" + AUT_DBName + ";integratedSecurity=true;";
		HashMap<String, String> ColumnData = new HashMap<String, String>();
		ResultSet r = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {

				r = stmt.executeQuery("select * from [UAT1].[dbo]." + AppData.getTStableName() + " " + "where Script_name =" + "'" + Script_name + "'" + " and language='Arabic' " + " order by ID");

			} else {
				r = stmt.executeQuery("select * from [UAT1].[dbo]." + AppData.getTStableName() + " " + "where Script_name =" + "'" + Script_name + "'" + " and language='EN' " + " order by ID");
			}

			r.last();
			// int count = r.getRow();
			// logger.info("Count :" + count); // enable when you need to see data in
			// console for debugging.
			r.beforeFirst();

			DatatableRow = ScenarioCount; // Integer.parseInt(ScenarioCount);
			r.absolute(DatatableRow);

			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(r.getString(3));

			ColumnData.put("SearchType", (String) json.get("SearchType"));
			ColumnData.put("period", (String) json.get("period"));
			ColumnData.put("Speriod", (String) json.get("Speriod"));
			ColumnData.put("Seq", (String) json.get("Seq"));
			ColumnData.put("Menu", (String) json.get("Menu"));
			ColumnData.put("D_ACCT", (String) json.get("D_ACCT"));
			ColumnData.put("C_ACCT", (String) json.get("C_ACCT"));
			ColumnData.put("AMOUNT", (String) json.get("AMOUNT"));
			ColumnData.put("EXEC", (String) json.get("EXEC"));
			ColumnData.put("Procced", (String) json.get("Procced"));
			ColumnData.put("Proceed", (String) json.get("Proceed"));
			ColumnData.put("Confirm", (String) json.get("Confirm"));
			ColumnData.put("Next", (String) json.get("Next"));
			ColumnData.put("AddNewBeneficiary", (String) json.get("AddNewBeneficiary"));
			ColumnData.put("EndDate", (String) json.get("EndDate"));
			ColumnData.put("StartDate", (String) json.get("StartDate"));
			ColumnData.put("FutureDate", (String) json.get("FutureDate"));
			ColumnData.put("NextDate", (String) json.get("NextDate"));
			ColumnData.put("other", (String) json.get("other"));
			ColumnData.put("AccountCofig", (String) json.get("AccountCofig"));
			ColumnData.put("PosNeg", (String) json.get("PosNeg"));
			ColumnData.put("FromAccount", (String) json.get("FromAccount"));
			ColumnData.put("ToAccount", (String) json.get("ToAccount"));
			ColumnData.put("Frequency", (String) json.get("Frqncy"));
			ColumnData.put("Frqncy", (String) json.get("Frqncy"));
			ColumnData.put("checkNo", (String) json.get("checkNo"));
			ColumnData.put("CancelYes", (String) json.get("CancelYes"));
			ColumnData.put("Save", (String) json.get("Save"));
			ColumnData.put("NewTrans", (String) json.get("NewTrans"));
			ColumnData.put("AMOUNT_Modify", (String) json.get("AMOUNT_Modify"));
			ColumnData.put("BeneficiaryType", (String) json.get("BeneficiaryType"));
			ColumnData.put("SMARTEnabled", (String) json.get("SMARTEnabled"));
			ColumnData.put("ATMEnabled", (String) json.get("ATMEnabled"));
			ColumnData.put("IVREnabled", (String) json.get("IVREnabled"));
			ColumnData.put("OTPProceed", (String) json.get("OTPProceed"));
			ColumnData.put("Nickname", (String) json.get("Nickname"));
			ColumnData.put("AccountNumber", (String) json.get("AccountNumber"));
			ColumnData.put("BeneficiaryActivationMode", (String) json.get("BeneficiaryActivationMode"));
			ColumnData.put("AddAnotherTransaction", (String) json.get("AddAnotherTransaction"));
			ColumnData.put("BeneficiaryActivationModeModified", (String) json.get("BeneficiaryActivationModeModified"));
			ColumnData.put("OTPCancelConfirm", (String) json.get("OTPCancelConfirm"));
			ColumnData.put("CancelConfirm", (String) json.get("CancelConfirm"));
			ColumnData.put("Fullname", (String) json.get("Fullname"));
			ColumnData.put("IBANNumber", (String) json.get("IBANNumber"));
			ColumnData.put("SwiftCode", (String) json.get("SwiftCode"));
			ColumnData.put("BankAddress", (String) json.get("BankAddress"));
			ColumnData.put("BankCityBranch", (String) json.get("BankCityBranch"));
			ColumnData.put("Currency", (String) json.get("Currency"));
			ColumnData.put("Nickname_Modified", (String) json.get("Nickname_Modified"));
			ColumnData.put("ScenarioDescription", r.getString("ScenarioDescription"));
			ColumnData.put("PositiveNegative", r.getString("PositiveNegative"));
			ColumnData.put("TestCaseType", r.getString("TestCaseType"));
			ColumnData.put("IncludeInExecution", r.getString("IncludeInExecution"));
			ColumnData.put("Language", r.getString("Language"));
			// ranjan
			ColumnData.put("editBeneficiary", (String) json.get("editBeneficiary"));
			ColumnData.put("AdditionalActions", (String) json.get("AdditionalActions"));
			ColumnData.put("BenificiaryCategory", (String) json.get("BenificiaryCategory"));
			ColumnData.put("Initiator", (String) json.get("Initiator"));
			ColumnData.put("TCButton", (String) json.get("TCButton"));
			ColumnData.put("CheckBox", (String) json.get("CheckBox"));
			ColumnData.put("cancelEdit", (String) json.get("cancelEdit"));
			ColumnData.put("Seq", (String) json.get("Seq"));
			ColumnData.put("Menu", (String) json.get("Menu"));
			ColumnData.put("D_ACCT", (String) json.get("D_ACCT"));
			ColumnData.put("C_ACCT", (String) json.get("C_ACCT"));
			ColumnData.put("AMOUNT", (String) json.get("AMOUNT"));
			ColumnData.put("EXEC", (String) json.get("EXEC"));
			ColumnData.put("Procced", (String) json.get("Procced"));
			ColumnData.put("Confirm", (String) json.get("Confirm"));
			ColumnData.put("Next", (String) json.get("Next"));
			ColumnData.put("NextDate", (String) json.get("NextDate"));
			ColumnData.put("FutureDate", (String) json.get("FutureDate"));
			ColumnData.put("Other", (String) json.get("Other"));
			ColumnData.put("PosNeg", (String) json.get("PosNeg"));
			ColumnData.put("validateTxfrFunds", (String) json.get("validateTxfrFunds"));
			ColumnData.put("saveAsFav", (String) json.get("saveAsFav"));
			ColumnData.put("tagName", (String) json.get("tagName"));
			ColumnData.put("remarks", (String) json.get("remarks"));
			ColumnData.put("Category", (String) json.get("Category"));
			ColumnData.put("Purpose", (String) json.get("Purpose"));
			ColumnData.put("PaymentDetails", (String) json.get("PaymentDetails"));
			ColumnData.put("Amount", (String) json.get("Amount"));
			ColumnData.put("ViewDetails", (String) json.get("ViewDetails"));
			

			ColumnData.put("FromAccount", (String) json.get("FromAccount"));
			ColumnData.put("ToAccount", (String) json.get("ToAccount"));
			ColumnData.put("Frequency", (String) json.get("Frqncy"));
			ColumnData.put("CancelYes", (String) json.get("CancelYes"));
			ColumnData.put("Save", (String) json.get("Save"));
			ColumnData.put("NewTrans", (String) json.get("NewTrans"));
			ColumnData.put("AMOUNT_Modify", (String) json.get("AMOUNT_Modify"));
			ColumnData.put("BeneficiaryType", (String) json.get("BeneficiaryType"));
			ColumnData.put("SMARTEnabled", (String) json.get("SMARTEnabled"));
			ColumnData.put("ATMEnabled", (String) json.get("ATMEnabled"));
			ColumnData.put("IVREnabled", (String) json.get("IVREnabled"));
			ColumnData.put("OTPProceed", (String) json.get("OTPProceed"));
			ColumnData.put("Nickname", (String) json.get("Nickname"));
			ColumnData.put("AccountNumber", (String) json.get("AccountNumber"));
			ColumnData.put("BeneficiaryActivationMode", (String) json.get("BeneficiaryActivationMode"));
			ColumnData.put("AddAnotherTransaction", (String) json.get("AddAnotherTransaction"));
			ColumnData.put("BeneficiaryActivationModeModified", (String) json.get("BeneficiaryActivationModeModified"));
			ColumnData.put("OTPCancelConfirm", (String) json.get("OTPCancelConfirm"));
			ColumnData.put("Fullname", (String) json.get("Fullname"));
			ColumnData.put("IBANNumber", (String) json.get("IBANNumber"));
			ColumnData.put("SwiftCode", (String) json.get("SwiftCode"));
			ColumnData.put("BankAddress", (String) json.get("BankAddress"));
			ColumnData.put("BankCityBranch", (String) json.get("BankCityBranch"));
			ColumnData.put("Currency", (String) json.get("Currency"));
			ColumnData.put("Nickname_Modified", (String) json.get("Nickname_Modified"));
			ColumnData.put("Branch", (String) json.get("Branch"));
			ColumnData.put("AccountNumberModified", (String) json.get("AccountNumberModified"));
			ColumnData.put("CurrencyFrom", (String) json.get("CurrencyFrom"));
			ColumnData.put("CurrencyTo", (String) json.get("CurrencyTo"));
			// 19 mAR
			ColumnData.put("TransferVia", (String) json.get("TransferVia"));
			ColumnData.put("BeneficiaryCountry", (String) json.get("BeneficiaryCountry"));
			ColumnData.put("DeliveryOption", (String) json.get("DeliveryOption"));
			ColumnData.put("NationalityCode", (String) json.get("NationalityCode"));
			ColumnData.put("BeneficiaryBankAgent", (String) json.get("BeneficiaryBankAgent"));
			ColumnData.put("BeneficiaryBank", (String) json.get("BeneficiaryBank"));
			ColumnData.put("TransferViaBank", (String) json.get("TransferViaBank"));
			ColumnData.put("BeneficiaryRelationship", (String) json.get("BeneficiaryRelationship"));
			ColumnData.put("AgentCity", (String) json.get("AgentCity"));
			ColumnData.put("AgentLocation", (String) json.get("AgentLocation"));
			ColumnData.put("NickName", (String) json.get("NickName"));

			// Alok.................
			ColumnData.put("IDType", (String) json.get("IDType"));
			ColumnData.put("DOBTYpe", (String) json.get("DOBTYpe"));
			ColumnData.put("NextExePg1", (String) json.get("NextExePg1"));
			ColumnData.put("ExcePersonalPage2Next", (String) json.get("ExcePersonalPage2Next"));
			ColumnData.put("IDDateType", (String) json.get("IDDateType"));
			ColumnData.put("ExcidPage3Next", (String) json.get("ExcidPage3Next"));
			ColumnData.put("ExePage4NextBtn", (String) json.get("ExePage4NextBtn"));
			ColumnData.put("Gender", (String) json.get("Gender"));
			ColumnData.put("AddAnotherTxn", (String) json.get("AddAnotherTxn"));
			ColumnData.put("DeleteAnotherTxn", (String) json.get("DeleteAnotherTxn"));
			ColumnData.put("ExcelPdfPrintActions", (String) json.get("ExcelPdfPrintActions"));
			ColumnData.put("TestType", (String) json.get("TestType"));
			ColumnData.put("verifySubscribeBtn", (String) json.get("verifySubscribeBtn"));
			ColumnData.put("PortfolioType", (String) json.get("PortfolioType"));
			ColumnData.put("PortfolioNum", (String) json.get("PortfolioNum"));
			ColumnData.put("OrdersType", (String) json.get("OrdersType"));
			ColumnData.put("SymbolType", (String) json.get("SymbolType"));
			ColumnData.put("dateFrom", (String) json.get("dateFrom"));
			ColumnData.put("dateTo", (String) json.get("dateTo"));
			ColumnData.put("BuySell", (String) json.get("BuySell"));
			ColumnData.put("validateSubsAndRedemptionHistoryLink", (String) json.get("validateSubsAndRedemptionHistoryLink"));
			ColumnData.put("Transaction", (String) json.get("Transaction"));
			ColumnData.put("txnViewBtn", (String) json.get("txnViewBtn"));

			ColumnData.put("Approve", (String) json.get("Approve"));
			ColumnData.put("Cancel", (String) json.get("Cancel"));
			ColumnData.put("Home", (String) json.get("Home"));
			ColumnData.put("RejectCancel", (String) json.get("RejectCancel"));
			ColumnData.put("AdditionalActions", (String) json.get("AdditionalActions"));

			ColumnData.put("BeneficiaryCategory", (String) json.get("BeneficiaryCategory"));

			ColumnData.put("IDType", (String) json.get("IDType"));
			ColumnData.put("FatherName", (String) json.get("FatherName"));
			ColumnData.put("Nationality", (String) json.get("Nationality"));
			ColumnData.put("PhNum", (String) json.get("PhNum"));
			ColumnData.put("MobNum", (String) json.get("MobNum"));
			ColumnData.put("Email", (String) json.get("Email"));
			ColumnData.put("POBox", (String) json.get("POBox"));
			ColumnData.put("City", (String) json.get("City"));
			ColumnData.put("ZIpCode", (String) json.get("ZIpCode"));
			ColumnData.put("Street", (String) json.get("Street"));
			ColumnData.put("MajorLandmark", (String) json.get("MajorLandmark"));
			ColumnData.put("MailType", (String) json.get("MailType"));
			ColumnData.put("MaritalStatus", (String) json.get("MaritalStatus"));
			ColumnData.put("NoOfDependents", (String) json.get("NoOfDependents"));
			ColumnData.put("ResType", (String) json.get("ResType"));
			ColumnData.put("EduLevel", (String) json.get("EduLevel"));

			ColumnData.put("ScenarioDescription", r.getString("ScenarioDescription"));
			ColumnData.put("PositiveNegative", r.getString("PositiveNegative"));
			ColumnData.put("TestCaseType", r.getString("TestCaseType"));
			ColumnData.put("IncludeInExecution", r.getString("IncludeInExecution"));
			ColumnData.put("Language", r.getString("Language"));
			ColumnData.put("Type", (String) json.get("Type"));
			ColumnData.put("deleteBeneficiary", (String) json.get("deleteBeneficiary"));
			ColumnData.put("sendEmail", (String) json.get("sendEmail"));
			ColumnData.put("ProceedEmail", (String) json.get("ProceedEmail"));
			ColumnData.put("TransferType", (String) json.get("TransferType"));
			ColumnData.put("TxfrAmountType", (String) json.get("TxfrAmountType"));
			ColumnData.put("NewTxn", (String) json.get("NewTxn"));
			ColumnData.put("AmountLessThan100USD", (String) json.get("AmountLessThan100USD"));
			ColumnData.put("NegativeAmount", (String) json.get("NegativeAmount"));
			ColumnData.put("AfterTxfrAdditionalOptions", (String) json.get("AfterTxfrAdditionalOptions"));
			ColumnData.put("ZeroBalAcc", (String) json.get("ZeroBalAcc"));
			ColumnData.put("isTermsNconditionsChecked", (String) json.get("isTermsNconditionsChecked"));
			ColumnData.put("AuthConfirm", (String) json.get("AuthConfirm"));
			ColumnData.put("validateAddBeneficiaryPage", (String) json.get("validateAddBeneficiaryPage"));
			ColumnData.put("showDetails", (String) json.get("showDetails"));
			ColumnData.put("deleteDetails", (String) json.get("deleteDetails"));
			ColumnData.put("skipNextTransfer", (String) json.get("skipNextTransfer"));
			ColumnData.put("edit", (String) json.get("edit"));
			ColumnData.put("confirmSkip", (String) json.get("confirmSkip"));
			// neeraj

			ColumnData.put("CreditType", (String) json.get("CreditType"));
			ColumnData.put("CreditCard", (String) json.get("CreditCard"));
			ColumnData.put("DebitCard", (String) json.get("DebitCard"));
			ColumnData.put("Status", (String) json.get("Status"));
			ColumnData.put("email", (String) json.get("email"));
			ColumnData.put("Account", (String) json.get("Account"));
			ColumnData.put("AdvanceSearch", (String) json.get("AdvanceSearch"));
			ColumnData.put("Paytype", (String) json.get("Paytype"));
			ColumnData.put("Frequency", (String) json.get("Frequency"));
			ColumnData.put("Addanothertransaction", (String) json.get("Addanothertransaction"));
			ColumnData.put("delivery", (String) json.get("delivery"));
			ColumnData.put("Limit", (String) json.get("Limit"));
			ColumnData.put("NickNameCancel", (String) json.get("NickNameCancel"));
			ColumnData.put("NickNameSave", (String) json.get("NickNameSave"));
			ColumnData.put("details", (String) json.get("details"));
			ColumnData.put("nextstep", (String) json.get("nextstep"));
			ColumnData.put("termConditions", (String) json.get("termConditions"));
			ColumnData.put("selectTnCfrompopup", (String) json.get("selectTnCfrompopup"));
			ColumnData.put("details", (String) json.get("details"));
			ColumnData.put("other", (String) json.get("other"));
			ColumnData.put("modifyemail", (String) json.get("modifyemail"));
			ColumnData.put("Modify", (String) json.get("Modify"));

			ColumnData.put("Range", (String) json.get("Range"));
			ColumnData.put("checkNo2", (String) json.get("checkNo2"));
			ColumnData.put("Reason", (String) json.get("Reason"));
			ColumnData.put("Username", (String) json.get("Username"));
			ColumnData.put("Password", (String) json.get("Password"));
			ColumnData.put("Company", (String) json.get("Company"));
			ColumnData.put("Subscribe", (String) json.get("Subscribe"));
			ColumnData.put("isNegative", (String) json.get("isNegative"));
			ColumnData.put("City", (String) json.get("City"));
			ColumnData.put("State", (String) json.get("State"));
			ColumnData.put("Street", (String) json.get("Street"));

			// neeraj coda ends

			// raja lelo

			ColumnData.put("showDetails", (String) json.get("showDetails"));
			ColumnData.put("otherActions", (String) json.get("otherActions"));
			ColumnData.put("SendSMS", (String) json.get("SendSMS"));
			ColumnData.put("SendEMail", (String) json.get("SendEMail"));
			ColumnData.put("AddressType", (String) json.get("AddressType"));
			ColumnData.put("DOBType", (String) json.get("DOBType"));
			ColumnData.put("NickNameCancelSave", (String) json.get("NickNameCancelSave"));
			ColumnData.put("Page1BtnOptions", (String) json.get("Page1BtnOptions"));
			ColumnData.put("Page2BtnOptions", (String) json.get("Page2BtnOptions"));
			ColumnData.put("IDDateType", (String) json.get("IDDateType"));
			ColumnData.put("Page3BtnOptions", (String) json.get("Page3BtnOptions"));
			ColumnData.put("Page4BtnOptions", (String) json.get("Page4BtnOptions"));

			ColumnData.put("OldPassword", (String) json.get("OldPassword"));
			ColumnData.put("NewPassword", (String) json.get("NewPassword"));
			ColumnData.put("ConfirmNewPassword", (String) json.get("ConfirmNewPassword"));
			ColumnData.put("AmountFrom", (String) json.get("AmountFrom"));
			ColumnData.put("AmountTo", (String) json.get("AmountTo"));
			ColumnData.put("StartDate", (String) json.get("StartDate"));
			ColumnData.put("Enddate", (String) json.get("Enddate"));
			ColumnData.put("ComplaintType", (String) json.get("ComplaintType"));
			ColumnData.put("MobileNumber", (String) json.get("MobileNumber"));
			ColumnData.put("ComplaintDesc", (String) json.get("ComplaintDesc"));
			ColumnData.put("Exec_Proceed", (String) json.get("Exec_Proceed"));
			ColumnData.put("Confirmation_btn", (String) json.get("Confirmation_btn"));
			ColumnData.put("NewComplaint", (String) json.get("NewComplaint"));
			ColumnData.put("ComplaintHistory", (String) json.get("ComplaintHistory"));
			ColumnData.put("AdditionalOptions", (String) json.get("AdditionalOptions"));
			ColumnData.put("BillerType", (String) json.get("BillerType"));
			ColumnData.put("SubscriptionID", (String) json.get("SubscriptionID"));
			ColumnData.put("Exec_Proceed_btn", (String) json.get("Exec_Proceed_btn"));
			ColumnData.put("BillerType_NewMobile", (String) json.get("BillerType_NewMobile"));
			ColumnData.put("Nickname_NewMobile", (String) json.get("Nickname_NewMobile"));
			ColumnData.put("SubscriptionID_NewMobile", (String) json.get("SubscriptionID_NewMobile"));
			ColumnData.put("General", (String) json.get("General"));
			ColumnData.put("BankOnBoarding", (String) json.get("BankOnBoarding"));
			ColumnData.put("MerchantOnBoarding", (String) json.get("MerchantOnBoarding"));
			ColumnData.put("showDetails", (String) json.get("showDetails"));
			ColumnData.put("otherActions", (String) json.get("otherActions"));
			ColumnData.put("SendSMS", (String) json.get("SendSMS"));
			ColumnData.put("SendEMail", (String) json.get("SendEMail"));
			ColumnData.put("AddressType", (String) json.get("AddressType"));
			ColumnData.put("DOBType", (String) json.get("DOBType"));
			ColumnData.put("NickNameCancelSave", (String) json.get("NickNameCancelSave"));
			ColumnData.put("Page1BtnOptions", (String) json.get("Page1BtnOptions"));
			ColumnData.put("Page2BtnOptions", (String) json.get("Page2BtnOptions"));
			ColumnData.put("IDDateType", (String) json.get("IDDateType"));
			ColumnData.put("Page3BtnOptions", (String) json.get("Page3BtnOptions"));
			ColumnData.put("Page4BtnOptions", (String) json.get("Page4BtnOptions"));

			ColumnData.put("OldPassword", (String) json.get("OldPassword"));
			ColumnData.put("NewPassword", (String) json.get("NewPassword"));
			ColumnData.put("ConfirmNewPassword", (String) json.get("ConfirmNewPassword"));
			ColumnData.put("AmountFrom", (String) json.get("AmountFrom"));
			ColumnData.put("AmountTo", (String) json.get("AmountTo"));
			ColumnData.put("StartDate", (String) json.get("StartDate"));
			ColumnData.put("Enddate", (String) json.get("Enddate"));
			ColumnData.put("ComplaintType", (String) json.get("ComplaintType"));
			ColumnData.put("MobileNumber", (String) json.get("MobileNumber"));
			ColumnData.put("ComplaintDesc", (String) json.get("ComplaintDesc"));
			ColumnData.put("Exec_Proceed", (String) json.get("Exec_Proceed"));
			ColumnData.put("Confirmation_btn", (String) json.get("Confirmation_btn"));
			ColumnData.put("NewComplaint", (String) json.get("NewComplaint"));
			ColumnData.put("ComplaintHistory", (String) json.get("ComplaintHistory"));
			ColumnData.put("AdditionalOptions", (String) json.get("AdditionalOptions"));
			ColumnData.put("BillerType", (String) json.get("BillerType"));
			ColumnData.put("SubscriptionID", (String) json.get("SubscriptionID"));
			ColumnData.put("Exec_Proceed_btn", (String) json.get("Exec_Proceed_btn"));
			ColumnData.put("BillerType_NewMobile", (String) json.get("BillerType_NewMobile"));
			ColumnData.put("Nickname_NewMobile", (String) json.get("Nickname_NewMobile"));
			ColumnData.put("SubscriptionID_NewMobile", (String) json.get("SubscriptionID_NewMobile"));
			ColumnData.put("General", (String) json.get("General"));
			ColumnData.put("BankOnBoarding", (String) json.get("BankOnBoarding"));
			ColumnData.put("MerchantOnBoarding", (String) json.get("MerchantOnBoarding"));

			ColumnData.put("Transactions", (String) json.get("Transactions"));
			ColumnData.put("TransactionsRow", (String) json.get("TransactionsRow"));
			ColumnData.put("Remarks", (String) json.get("Remarks"));
			ColumnData.put("Tag", (String) json.get("Tag"));
			ColumnData.put("FirstChequeNo", (String) json.get("FirstChequeNo"));
			ColumnData.put("LastChequeNo", (String) json.get("LastChequeNo"));
			ColumnData.put("AccountInfoUpdate", (String) json.get("AccountInfoUpdate"));
			ColumnData.put("StartDate_Date_Previous", (String) json.get("StartDate_Date_Previous"));
			ColumnData.put("StartDate_Month_Previous", (String) json.get("StartDate_Month_Previous"));
			ColumnData.put("StartDate_Year_Previous", (String) json.get("StartDate_Year_Previous"));

			ColumnData.put("StartDate_Date_Future", (String) json.get("StartDate_Date_Future"));
			ColumnData.put("StartDate_Month_Future", (String) json.get("StartDate_Month_Future"));
			ColumnData.put("StartDate_Year_Future", (String) json.get("StartDate_Year_Future"));

			ColumnData.put("FirstName", (String) json.get("FirstName"));
			ColumnData.put("MiddleName", (String) json.get("MiddleName"));
			ColumnData.put("LastName", (String) json.get("LastName"));

			ColumnData.put("Address1", (String) json.get("Address1"));
			ColumnData.put("Address2", (String) json.get("Address2"));

			ColumnData.put("Mobile", (String) json.get("Mobile"));
			ColumnData.put("Phone", (String) json.get("Phone"));
			ColumnData.put("BeneficiaryIDNumber", (String) json.get("BeneficiaryIDNumber"));
			ColumnData.put("BeneficiaryRemarks", (String) json.get("BeneficiaryRemarks"));

			ColumnData.put("AccountType", (String) json.get("AccountType"));
			ColumnData.put("BranchCode", (String) json.get("BranchCode"));

			ColumnData.put("Category", (String) json.get("Category"));
			ColumnData.put("Purpose", (String) json.get("Purpose"));
			ColumnData.put("PaymentDetails", (String) json.get("PaymentDetails"));
			
			ColumnData.put("NoOfShares", (String) json.get("NoOfShares"));
			ColumnData.put("IPOType", (String) json.get("IPOType"));
			ColumnData.put("SubscribersType", (String) json.get("SubscribersType"));
			ColumnData.put("Purpose_Modify", (String) json.get("Purpose_Modify"));
			ColumnData.put("Provider", (String) json.get("Provider"));
			ColumnData.put("Service", (String) json.get("Service"));
			ColumnData.put("CurrentOwnerID", (String) json.get("CurrentOwnerID"));
			ColumnData.put("VehicleSeqNumber", (String) json.get("VehicleSeqNumber"));
			ColumnData.put("LanguageType", (String) json.get("LanguageType"));
			
			// eCorp Neeraj IDs
			ColumnData.put("CivilianId", (String) json.get("CivilianId"));
			ColumnData.put("GroupDivision", (String) json.get("GroupDivision"));
			ColumnData.put("DirectReportId", (String) json.get("DirectReportId"));
			ColumnData.put("DirectReportName", (String) json.get("DirectReportName"));
			ColumnData.put("phoneAndExt", (String) json.get("phoneAndExt"));
			ColumnData.put("Record", (String) json.get("Record"));
			ColumnData.put("File", (String) json.get("File"));
			ColumnData.put("MOLID", (String) json.get("MOLID"));
			ColumnData.put("TransactionID", (String) json.get("TransactionID"));
			ColumnData.put("MerchantReferenceNumber", (String) json.get("MerchantReferenceNumber"));
			ColumnData.put("TransactionType", (String) json.get("TransactionType"));
			ColumnData.put("BankReferenceNumber", (String) json.get("BankReferenceNumber"));
			ColumnData.put("RequestType", (String) json.get("RequestType"));
			ColumnData.put("TicketId", (String) json.get("TicketId"));

		}

		catch (Exception e) {

			Log.fatal("Unable to read data from database..error .." + ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			return "0";
		}
		if (ColumnData.get(ColumnName) == null) {

			return "0";

		}
		return ColumnData.get(ColumnName);

	}

	public static String getJsonData(String Script_name, int ScenarioCount, String ColumnName) {

		String AUT_DBIPPort = "10.242.25.108:1433";
		String AUT_DBName = "UAT1";
		String result = null;
		ResultSet r = null;
		String connectionUrl = "jdbc:sqlserver://" + AUT_DBIPPort + ";databaseName=" + AUT_DBName + ";integratedSecurity=true;";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {

				r =  stmt.executeQuery("select " + ColumnName + " from [UAT1].[dbo]." + AppData.getTStableName() + " where Script_name =" + "'" + Script_name + "'" +" and language='Arabic' "+ " order by ID");

			} else {
				r =  stmt.executeQuery("select " + ColumnName + " from [UAT1].[dbo]." + AppData.getTStableName() + " where Script_name =" + "'" + Script_name + "'" + " order by ID");
			}

			
			
			for (int i = 0; i < ScenarioCount; i++) {

				r.next();

			}

			result = r.getString(1);

		}

		catch (Exception e) {

			Log.fatal("Unable to read data Set  from database..error .." + ExceptionUtils.getStackTrace(e));
		}
		return result;

	}
}
