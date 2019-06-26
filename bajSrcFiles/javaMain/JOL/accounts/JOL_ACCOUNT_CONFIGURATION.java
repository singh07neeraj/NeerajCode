package javaMain.JOL.accounts;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_ACCOUNT_CONFIGURATION extends TestBase {

	public static boolean AccountConfiguration(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception{

		List<WebElement> Checkboxes=null;
		String Save;
		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				Save = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Save"));

			}

			else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				Save = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Save"));

			}


			// click on Account Top
			Utils.click(By.xpath(getObj("Propval1", "Accounts", "JOL_ACCOUNT_CONFIGURATION")),"Accounts link");

			// Click on Accounts Configuration
			Utils.click(By.xpath(getObj("Propval1", "AccountsConfiguration_lnk", "JOL_ACCOUNT_CONFIGURATION")),"Accounts Configuration link");
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			
			

			if (Integer.parseInt(Save) == 1) {
				// Click on Proceed Button
				// check boxes
				Utils.wait(5);
				Checkboxes = driver.findElements(By.xpath(getObj("Propval1", "Total_Checkedboxes", "JOL_ACCOUNT_CONFIGURATION")));
				int numberOfBoxesBeforeUpdate = Checkboxes.size();
				System.out.println(numberOfBoxesBeforeUpdate);

				Utils.click(By.xpath(getObj("Propval1", "CheckBox_ToUpdate", "JOL_ACCOUNT_CONFIGURATION")),"Check box to update");

				Checkboxes = driver.findElements(By.xpath(getObj("Propval1", "Total_Checkedboxes", "JOL_ACCOUNT_CONFIGURATION")));
				int numberOfBoxesAfterUpdate = Checkboxes.size();
				System.out.println(numberOfBoxesAfterUpdate);

				if (numberOfBoxesBeforeUpdate==numberOfBoxesAfterUpdate)
				{
					
					Log.fail("Accounts Configurations has not been updated");
					
				} 
				else 
				{
					
					Log.pass("Accounts Configurations has been updated");
					
				}
				Utils.click(By.xpath(getObj("Propval1", "CheckBox_ToUpdate", "JOL_ACCOUNT_CONFIGURATION")),"Check box to update");
				Utils.click(By.xpath(getObj("Propval1", "Save", "JOL_ACCOUNT_CONFIGURATION")),"Save Button.");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "AccountsConfigSaved_alert", "JOL_ACCOUNT_CONFIGURATION")), "Accounts Configuration Saved alert"));
					Log.pass("Accounts configurations have been saved alert displayed. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "AccountsConfigSaved_alert", "JOL_ACCOUNT_CONFIGURATION"))));
					Utils.click(By.xpath(getObj("Propval1", "SaveAccept", "JOL_ACCOUNT_CONFIGURATION")),"Accept Button");

					Utils.logPassImage("Accounts configurations have been saved alert displayed-pass");


				} catch (AssertionError | Exception e) {

					Log.fail("Accounts configurations have not been saved...should fail");
					Utils.logFailImage("Accounts configurations have not been saved-fail");

					throw e;

				}
				
				
			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "JOL_ACCOUNT_CONFIGURATION")),"Cancel");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomeGraphic", "OrderCheckBook")), "Customer position page"));

					Log.pass("Customer position page displayed...transaction cancelled successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "HomeGraphic", "OrderCheckBook"))));

					Utils.logPassImage("Customer position page displayed-pass");


				} catch (AssertionError | Exception e) {

					Log.fail("Customer position page not displayed...transaction not cancelled");
					Utils.logFailImage("Customer position page not displayed-fail");

					throw e;

				}
			}

		}
		catch (AssertionError | Exception e)  {
			runResult = false;
			e.printStackTrace();
			throw e;
		}
		return runResult;
	}
}
