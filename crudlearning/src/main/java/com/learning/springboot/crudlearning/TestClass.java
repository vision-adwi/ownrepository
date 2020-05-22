package com.learning.springboot.crudlearning;

public class TestClass {

	public static void main(String[] args) 
	{
		String[] testData = {"112233445566",
				"112233445566_4778",
				"45678b_KOHLS-RETAIL_24_11_4778",
				"11234_KOHLS-RETAIL_24_11_4778",
				"11234_KOHLS-RETAIL_24_",
				"GRAVID_1566543931537_25_KOHLS-RETAIL_278_26",
				"1566489923005_6086_KOHLS-RETAIL_380_05",
				"1566489922659_24689b_KOHLS-RETAIL_380_05",
				"GRAVID_1566544998246_82_KOHLS-RETAIL__"};
		
		for(String test:testData)
		{
			validate(test);
		}
	}
	private static void validate(String str)
	{
		boolean eligible = false;
		if(str.contains("KOHLS-RETAIL"))
		{
			String[] subString = str.split("KOHLS-RETAIL_");
			
			if(subString.length > 1)
			{
				String[] tokens = subString[1].split("_");
				eligible = (tokens.length == 2) ? true : false;
			}
		}
		System.out.println(str + " : " + eligible);
	}

}
