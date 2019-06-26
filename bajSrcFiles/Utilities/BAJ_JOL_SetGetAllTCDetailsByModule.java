package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BAJ_JOL_SetGetAllTCDetailsByModule {

	public BAJ_JOL_SetGetAllTSDetails BAJ_JOL_SetGetAllTCDetailsByModule(int Counter, String Module_Name) {
		// TODO Auto-generated method stub

		BAJ_JOL_SetGetAllTSDetails TCDetails = new BAJ_JOL_SetGetAllTSDetails();
		String AUT_DBIPPort = "10.242.25.108:1433";
		String AUT_DBName = "UAT1";
		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://" + AUT_DBIPPort + ";databaseName=" + AUT_DBName + ";integratedSecurity=true;";
		// jdbc:sqlserver://10.242.25.108:1433;databaseName=UAT1;integratedSecurity=true;
		String ChannelSQL = null;
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// List<String> DBResultArray = new ArrayList();
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			String Table_Name = GUI_Page1.getjComboBoxChannel();
			if (Table_Name != null) {
				if (Table_Name.equalsIgnoreCase("AlJazira Online")) {
					ChannelSQL = "[UAT1].[dbo].[JOL_Test_Scenarios]";
				} else if (Table_Name.equalsIgnoreCase("AlJazira Smart")) {
					ChannelSQL = "[UAT1].[dbo].[Smart_Test_Scenarios]";
				} else if (Table_Name.equalsIgnoreCase("AlJazira Corporate")) {
					ChannelSQL = "[UAT1].[dbo].[eCorp_Test_Scenarios]";
				}

			} else {
				System.out.println("Please select a valid channel name");

			}

			String StringCounter = Integer.toString(Counter);
			// Create and execute an SQL statement that returns some data.
			String SQL = "SELECT * FROM " + ChannelSQL + " where Seq = '" + Counter + "' and Module = '" + Module_Name + "' ";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			// System.out.println(result);
			while (rs.next()) {

				BAJ_JOL_SetGetAllTSDetails.setID(rs.getString("ID"));
				BAJ_JOL_SetGetAllTSDetails.setScriptName(rs.getString("Script_name"));
				BAJ_JOL_SetGetAllTSDetails.setDataSet(rs.getString("DataSet"));
				BAJ_JOL_SetGetAllTSDetails.setScenarioDescription(rs.getString("ScenarioDescription"));
				BAJ_JOL_SetGetAllTSDetails.setDataPrerequisitesDescription(rs.getString("DataPrerequisitesDescription"));
				BAJ_JOL_SetGetAllTSDetails.setPositiveNegative(rs.getString("PositiveNegative"));
				BAJ_JOL_SetGetAllTSDetails.setTestCaseType(rs.getString("TestCaseType"));
				BAJ_JOL_SetGetAllTSDetails.setIncludeInExecution(rs.getString("IncludeInExecution"));
				BAJ_JOL_SetGetAllTSDetails.setPrioity(rs.getString("Prioity"));
				BAJ_JOL_SetGetAllTSDetails.setLanguage(rs.getString("Language"));
				BAJ_JOL_SetGetAllTSDetails.setSeq(rs.getString("Seq"));
				BAJ_JOL_SetGetAllTSDetails.setModule(rs.getString("Module"));
				BAJ_JOL_SetGetAllTSDetails.setClassPath(rs.getString("ClassPath"));

				// 24

			}
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return TCDetails;

	}
}
