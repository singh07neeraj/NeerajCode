/**
 * Library name: BAJ_JOL_SetGetTCDetails
 * description: Set Get TC Details.
 * Creation Date:02-March-2017
 * Last update date:
 * created by: Quality Assurance team.
 */

package Utilities;

public class BAJ_JOL_SetGetTCDetails {

				
		private static String ID;
		private static String TS;
		private static String Browser;
		private static String Segment;
		private static String IncludeInExecution;
		private static String TaskName;

		
		public static String getIncludeInExecution() {
			return IncludeInExecution;
		}
		public void setIncludeInExecution(String IncludeInExecution) {
			BAJ_JOL_SetGetTCDetails.IncludeInExecution = IncludeInExecution;
		}
		
		
		
		public static String getTaskName() {
			return TaskName;
		}
		public void setTaskName(String Channel) {
			BAJ_JOL_SetGetTCDetails.TaskName = TaskName;
		}
		
		
		
		
		
		public static String getID() {
			return ID;
		}
		public void setID(String ID) {
			BAJ_JOL_SetGetTCDetails.ID = ID;
		}
		
		
		
		
		
		public static String getTS() {
			return TS;
		}
		public void setTS(String TS) {
			BAJ_JOL_SetGetTCDetails.TS = TS;
		}
		
		
		
		
		public static String getBrowser() {
			return Browser;
		}
		public void setBrowser(String Browser) {
			BAJ_JOL_SetGetTCDetails.Browser = Browser;
		}
		
		public static String getSegment() {
			return Segment;
		}
		public void setSegment(String Segment) {
			BAJ_JOL_SetGetTCDetails.Segment = Segment;
		}
		
		
		
		
	}