package Utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javaMain.common_Functions.AppData;

public class Input {

	public static XSSFWorkbook oWB;
	static XSSFSheet oSheet;
	int Input_pointer = 1;

	static {

		try {
			oWB = new XSSFWorkbook(new FileInputStream(AppData.testDataFilePath));
			oSheet = oWB.getSheet(AppData.testDataSheetName);

		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Unable to read test data ..." + e.getMessage());
		}

	}

	public static String ReadGlobal(String varName) {

		XSSFRow oRow;
		int pointer = 1;
		String varCurrent = "";

		while (varCurrent.compareTo("Local Variables") != 0) {

			try {
				oRow = oSheet.getRow(pointer++);
				varCurrent = oRow.getCell(1).toString().trim();

				if (varCurrent.compareTo(varName.trim()) == 1) {
					String val = oRow.getCell(1).toString();
					return val;
				}

			} catch (NullPointerException npe) {

				Log.error("Unable to read global data ..." + npe.getMessage());
			}
		}
		return "";
	}

	public static String ReadTestData(String testCase, String varName, int... dataSets) {

		XSSFRow oRow;
		int pointer = 1;
		String varCurrent = "";
		String valCurrent = "Default";
		int dataSet;

		try {
			dataSet = dataSets[0];
		} catch (Exception e) {
			dataSet = AppData.getTestDataSet();
		}

		try {
			while (pointer < 900) {

				oRow = oSheet.getRow(pointer++);
				try {
					varCurrent = oRow.getCell(0).toString().trim();
				} catch (Exception e) {
				}
				if (varCurrent.compareTo(testCase.trim()) == 0) {

					while ((oRow = oSheet.getRow(pointer++)) != null) {

						varCurrent = oRow.getCell(1).toString().trim();
						
						if (varCurrent.trim().length() == 0) {
							Log.fail("Variable [ "+varName+" ] not found in input sheet. Returning default value-Random");
						}

						if (varCurrent.compareTo(varName.trim()) == 0) {

							valCurrent = oRow.getCell(dataSet + 1).toString();
							
							if (valCurrent.equalsIgnoreCase("RANDOM")) {

								valCurrent = Utils.generateNumber();

							}
							break;
						}
					}
				}
			}
		}

		catch (Exception e) {

			Log.error("Unable to read test data ..." + ExceptionUtils.getStackTrace(e));
		}
		return valCurrent;
	}
	
	/***
	 * @author baj80000892/Alok Rai
	 * @description the methods below will be used to convert String format json data into map and return the map Object.
	 * @param json
	 * @return Map Object containing Key and values.
	 * @throws JSONException
	 */
	
	 public static Map<String, Object> getUiData(Object json) throws JSONException {

	        if(json instanceof JSONObject)
	            return _jsonToMap_((JSONObject)json) ;

	        else if (json instanceof String)
	        {
	            JSONObject jsonObject = new JSONObject((String)json) ;
	            return _jsonToMap_(jsonObject) ;
	        }
	        return null ;
	    }


	   private static Map<String, Object> _jsonToMap_(JSONObject json) throws JSONException {
	        Map<String, Object> retMap = new HashMap<String, Object>();

	        if(json != JSONObject.NULL) {
	            retMap = toMap(json);
	        }
	        return retMap;
	    }


	    private static Map<String, Object> toMap(JSONObject object) throws JSONException {
	        Map<String, Object> map = new HashMap<String, Object>();

	        Iterator<String> keysItr = object.keys();
	        while(keysItr.hasNext()) {
	            String key = keysItr.next();
	            Object value = object.get(key);

	            if(value instanceof JSONArray) {
	                value = toList((JSONArray) value);
	            }

	            else if(value instanceof JSONObject) {
	                value = toMap((JSONObject) value);
	            }
	            map.put(key, value);
	        }
	        return map;
	    }


	    public static List<Object> toList(JSONArray array) throws JSONException {
	        List<Object> list = new ArrayList<Object>();
	        for(int i = 0; i < array.length(); i++) {
	            Object value = array.get(i);
	            if(value instanceof JSONArray) {
	                value = toList((JSONArray) value);
	            }

	            else if(value instanceof JSONObject) {
	                value = toMap((JSONObject) value);
	            }
	            list.add(value);
	        }
	        return list;
	    }
}
