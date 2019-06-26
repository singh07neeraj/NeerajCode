package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BAJ_General_GetAllTSsCount {

	// private static final String DBResultArray = null;
	String[] DBResultArray1 = null;

	public int BAJ_General_GetAllTSsCount(String Module) {
		BAJ_General_SetGetTCsCount TCDetails = new BAJ_General_SetGetTCsCount();

		String ChannelSQL = null;

		String AUT_DBIPPort = "10.242.25.108:1433";
		String AUT_DBName = "UAT1";
		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://" + AUT_DBIPPort + ";databaseName=" + AUT_DBName + ";integratedSecurity=true;";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		TCDetails = null;
		int ColumnCount = 0;

		try {
			// List<String> DBResultArray = new ArrayList();
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			String Channel = GUI_Page1.getjComboBoxChannel();

			if (Channel != null) {

				if (Channel.equalsIgnoreCase("AlJazira Online") || Channel.equalsIgnoreCase("JOL")) {
					ChannelSQL = "[UAT1].[dbo].[JOL_Test_Scenarios]";
				} else if (Channel.equalsIgnoreCase("AlJazira Smart") || Channel.equalsIgnoreCase("Smart")) {
					ChannelSQL = "[UAT1].[dbo].[Smart_Test_Scenarios]";
				} else if (Channel.equalsIgnoreCase("AlJazira Corporate") || Channel.equalsIgnoreCase("eCorp")) {
					ChannelSQL = "[UAT1].[dbo].[eCorp_Test_Scenarios]";
				}

			} else {
				System.out.println("Please select a valid channel name");

			}
			// Create and execute an SQL statement that returns some data.
			if (Module.equalsIgnoreCase("ALL")) {

				Module = "";
			} else if (!Module.equalsIgnoreCase("ALL")) {
				Module = " where Module = '" + Module + "'";

			}

			String SQL = "SELECT * FROM " + ChannelSQL + " " + Module + " ;";

			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {

				int size = rs.getRow();
				ColumnCount = size;

			}

		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			TCDetails = null;
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

		return ColumnCount;

	}

}
