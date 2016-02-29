package test.Cases;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.common.Locator;
import test.helper.Functions;

public class Schedules {
	Functions function = new Functions();
	
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
	@Test
	public void testProgramAssetIdTagIsCorrect() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = "http://tomcat-dev:8080/CPAD/schedules/?program_asset_id=2790";
		String a = "group=Adult";
		String b = "size=60";
		String c = "airing_time_gt="  + function.timestampPlusDays(-2);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 2 days before today
		String d = "airing_time_lte=" + function.timestampPlusDays(7);   // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 days after today
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
   		String record = "schedule";
   		String tag = "program_asset_id";
   		String expected = "2790";
   		String condition = "equal";

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsCompareToExpected(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, expected, condition); }
		catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
		}

	/**
	 * Test all of the possible given URL combinations are having the "group" tags of "schedule" record are correct [2]
	 * <p>Date Created: 2016-02-22</p>
	 * <p>Date Modified: 2016-02-22</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: schedules-02</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testGroupTagIsCorrect() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = "http://tomcat-dev:8080/CPAD/schedules/?group=Adult";
		String a = "program_asset_id=2790";
		String b = "size=30";
		String c = "airing_time_gt="  + function.timestampPlusDays(-2);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 2 days before today
		String d = "airing_time_lte=" + function.timestampPlusDays(7);   // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 days after today
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
   		String record = "schedule";
   		String tag = "group";
   		String expected = "Adult";
   		String condition = "equal";

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsCompareToExpected(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, expected, condition); }
		catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
		}

	/**
	 * Test all of the possible given URL combinations having maximum or less "schedule" records returned [3]
	 * <p>Date Created: 2016-02-22</p>
	 * <p>Date Modified: 2016-02-22</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: schedules-03</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScheduleRecordsMaxNumber() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = "http://tomcat-dev:8080/CPAD/schedules/?size=10";
		String a = "group=Adult";
		String b = "program_asset_id=2790";
		String c = "airing_time_gt="  + function.timestampPlusDays(-2);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 2 days before today
		String d = "airing_time_lte=" + function.timestampPlusDays(7);   // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 days after today
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
   		String record = "schedule";
   		int max = 10;

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsMaxNumber(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, max); }
		catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}

	/**
	 * Test all of the possible given URL combinations having the "airing_time" tags of all the "schedule" records returning dates not less than or equal to filter placeholder for schedules [4]
	 * <p>Date Created: 2016-02-22</p>
	 * <p>Date Modified: 2016-02-22</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: schedules-04</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testAiringTimeTagIsFilteredAsAfter() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = "http://tomcat-dev:8080/CPAD/schedules/?airing_time_gt=" + function.timestampPlusDays(-2);  // a datetime stamp in the format YYYY-MM-DDTHH:MM:SS that is 2 days before today 
	    String a = "group=Adult";
		String b = "program_asset_id=2790";
		String c = "size=50";
		String d = "airing_time_lte=" + function.timestampPlusDays(7);   // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 days after today
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
   		String record = "schedule";
   		String tag = "airing_time";
	        
		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsDateFilter(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, "after"); }
		catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );	
	}

	/**
	 * Test all of the possible given URL combinations having the "airing_time" tags of all the "schedule" records returning dates that are not greater than placeholder for schedules [5]
	 * <p>Date Created: 2016-02-23</p>
	 * <p>Date Modified: 2016-02-23</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: schedules-05</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testAiringTimeTagIsFilteredAsNotAfter() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = "http://tomcat-dev:8080/CPAD/schedules/?airing_time_lte=" + function.timestampPlusDays(7);  // a datetime stamp in the format YYYY-MM-DDTHH:MM:SS that is 7 days after today
		String a = "group=Adult";
		String b = "program_asset_id=2790";
		String c = "size=50";
		String d = "airing_time_gt="  + function.timestampPlusDays(-2);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 2 days before today		
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
   		String record = "schedule";
   		String tag = "airing_time";
	        
		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsDateFilter(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, "not after"); }
		catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );	
	}

	/**
	 * Test sorting schedules by its "airing_time" tags of "schedule" records are in descending order [6]
	 * <p>Date Created: 2016-02-23</p>
	 * <p>Date Modified: 2016-02-23</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: schedules-06</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testAiringTimeTagOrderIsDescending() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = "http://tomcat-dev:8080/CPAD/schedules/";
		String a = "group=Adult";
		String b = "program_asset_id=2790";
		String c = "size=60";
		String d = "airing_time_gt="  + function.timestampPlusDays(-2);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 2 days before today
		String e = "airing_time_lte=" + function.timestampPlusDays(7);   // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 days after today
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d, e));
   		String record = "schedule";
   		String tag = "airing_time";
	        
		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsDateDesc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag); }
		catch (Exception exception) { /** exception.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}
	
   @BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); }
   @AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }
}
