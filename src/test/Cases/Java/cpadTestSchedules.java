package test.Cases.Java;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import test.common.Locators;
import test.helper.Functions;

public class cpadTestSchedules {
	Functions function = new Functions();
	int count = 0;
	
	/**
	 * Test all of the possible given URL combinations are having the "program_asset_id" tags of "schedule" record are correct [1]
	 * <p>Date Created: 2016-02-22</p>
	 * <p>Date Modified: 2016-02-22</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: schedules-01</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testProgramAssetIdTagIsCorrect() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/schedules/?program_asset_id=2790";
		String a = "group=Adult";
		String b = "size=60";
		String c = "airing_time_gt=" + function.timestampPlusDays(-2);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 2 days before today
		String d = "airing_time_lte=" + function.timestampPlusDays(7);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 days  after today
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d));
   		String record = "schedule";
   		String tag = "program_asset_id";
   		String expected = "2790";
		
	    function.fileWriterPrinter("\n" + " TEST EXECUTION #" + count + ":");

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsEqualToExpected(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, expected); }
		catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				          //function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST EXECUTION # " + count + " - Unexpected Results found!"
		        		 //,Boolean.valueOf(function.fileScanner("cpad.log")))
		        		 );
		}

	/*
	2. Testing the group filter for schedules:
	Using the all of the possible combinations of the following query parameters with the endpoint url  
	http://tomcat-dev:8080/CPAD/schedules/?group=Adult
	, all the  
	<schedule> records returned should ONLY have a  
	<group> tag equal to �Adult�.

			String a = "program_asset_id=2790";
			String b = "size=30";
			String c = "airing_time_gt= (a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 2 days before today)";
			String d = "airing_time_lte=(a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 days after today)
	*/

	/*
	3. Testing the size filter for schedules:
	Using the all of the possible combinations of the following query parameters with the endpoint url  
	http://tomcat-dev:8080/CPAD/schedules/?size=10
	, 10 or less  
	<schedule> records should be returned.

			String a = "group=Adult";
			String b = "program_asset_id=2790";
			String c = "airing_time_gt= (a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 2 days before today)";
			String d = "airing_time_lte=(a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 days after today)
	*/

	/*
	4. Testing the greater than airing time filter for schedules:
	Using the all of the possible combinations of the following query parameters with the endpoint url  
	http://tomcat-dev:8080/CPAD/schedules/?airing_time_gt={placeholder} where {placeholder} is a datetime stamp in the format YYYY-MM-DDTHH:MM:SS that is 2 days before today
	, all the  
	<schedule> records should not contain an  
	<airing_time> date that is less than or equal to {placeholder}.

			String a = "group=Adult";
			String b = "program_asset_id=2790";
			String c = "size=50";
			String d = "airing_time_lte=(a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 days after today)
	*/

	/*
	5. Testing the less than or equal to airing time filter for schedules:
	Using the all of the possible combinations of the following query parameters with the endpoint url  
	http://tomcat-dev:8080/CPAD/schedules/?airing_time_lte={placeholder} where {placeholder} is a datetime stamp in the format YYYY-MM-DDTHH:MM:SS that is 7 days after today
	, all the  
	<schedule> records should not contain an  
	<airing_time> date that is greater than {placeholder}.

			String a = "group=Adult";
			String b = "program_asset_id=2790";
			String c = "size=50";
			String d = "airing_time_gt=(a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 2 days before today)
	*/
	
	
   @BeforeSuite  public static void logOpen() throws IOException { new Functions().logOpen(); }
   @AfterSuite   public static void logClose() throws IOException { new Functions().logClose(); }
   @BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); }
   @AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }

}