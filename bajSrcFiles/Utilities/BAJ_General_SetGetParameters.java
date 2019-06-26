package Utilities;

import org.testng.annotations.DataProvider;

public class BAJ_General_SetGetParameters {
	@DataProvider(name = "DataSet")
	 
	  public static Object[][] DataSet() {
	 
	        return new Object[][] { { "testuser_1", "Test@123" }};
	 
	  }
}