package Utilities;

public class jsondata {

	public static void main(String[] args) {

		String Data = ReadData.getJsonData("JOL Transfers - Add New Benificiary", 4, "DataSet");

		System.out.println(Data);
	}

}
