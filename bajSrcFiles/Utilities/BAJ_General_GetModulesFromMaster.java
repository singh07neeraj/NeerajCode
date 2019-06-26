package Utilities;

/**
 * Library name: BAJ_General_GetTCDetails
 * description: get the TC details from the DB like Country , Flag.... by ID.
 * Creation Date:02-March-2017
 * Last update date:
 * created by: Quality Assurance team.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BAJ_General_GetModulesFromMaster {

	// private static final String DBResultArray = null;

	// String[] DBResultArray1 = new String[];

	public List<String> BAJ_General_GetModulesFromMaster(String CurrentGUI) {
		List<String> list = new ArrayList<>();

		BAJ_JOL_SetGetTCDetails TCDetails = new BAJ_JOL_SetGetTCDetails();
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

			String Channel = GUI_Page1.getjComboBoxChannel();
			if (Channel != null) {
				if (Channel.equalsIgnoreCase("AlJazira Online")) {
					ChannelSQL = "[UAT1].[dbo].[JOL_Test_Scenarios]";
				} else if (Channel.equalsIgnoreCase("AlJazira Smart")) {
					ChannelSQL = "[UAT1].[dbo].[Smart_Test_Scenarios]";
				} else if (Channel.equalsIgnoreCase("AlJazira Corporate")) {
					ChannelSQL = "[UAT1].[dbo].[eCorp_Test_Scenarios]";
				}

			} else {
				System.out.println("Please select a valid channel name");

			}

			// ChannelSQL = "[UAT1].[dbo].[TransferTSTable]";

			// Create and execute an SQL statement that returns some data.
			String SQL = "SELECT DISTINCT Module FROM " + ChannelSQL + ";";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			// System.out.println(result);

			// String[] array = new String[];

			if (CurrentGUI.equalsIgnoreCase("GUI_Page2")) {

				list.add("All");
			}

			while (rs.next()) {
				list.add(rs.getString("Module"));
				// int i = 0;
				// array[i] = rs.getString("Module_Name");
				// i++;
			}

			// TCDetails.setID(rs.getString("Module_Name"));

			// 24

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
		return list;

	}
}
