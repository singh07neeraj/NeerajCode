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

public class BAJ_JOL_SetGetTCDetailsByModule {

	// private static final String DBResultArray = null;
	String[] DBResultArray1 = null;

	public BAJ_JOL_SetGetTCDetails BAJ_JOL_SetGetTCDetailsByModule(int TC_ID, String Channel) {

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

			if (Channel != null) {
				if (Channel.equalsIgnoreCase("AlJazira Online") || Channel.equalsIgnoreCase("JOL")) {
					ChannelSQL = "JOL_MasterTable";
				} else if (Channel.equalsIgnoreCase("AlJazira Smart") || Channel.equalsIgnoreCase("Smart")) {
					ChannelSQL = "Smart_MasterTable";
				} else if (Channel.equalsIgnoreCase("AlJazira Corporate") || Channel.equalsIgnoreCase("eCorp")) {
					ChannelSQL = "eCorp_MasterTable";
				}
			}

			// Create and execute an SQL statement that returns some data.
			String SQL = "select * from " + ChannelSQL + " where ID = '" + TC_ID + "';";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			// System.out.println(result);
			while (rs.next()) {

				TCDetails.setID(rs.getString("ID"));
				TCDetails.setTS(rs.getString("TS_DES"));
				TCDetails.setBrowser(rs.getString("Module_Name"));
				TCDetails.setSegment(rs.getString("Class_Path"));
				TCDetails.setIncludeInExecution(rs.getString("IncludeInExecution"));

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
