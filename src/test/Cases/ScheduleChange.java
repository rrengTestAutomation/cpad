package test.Cases;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.common.Locator;
import test.helper.Functions;

public class ScheduleChange {
	Functions function = new Functions();

	/**
	 * Test all of the possible given URL combinations are having the "change_log_id" tags of "schedule_change_log" record greater than given minimum [1]
	 * <p>Date Created: 2016-02-26</p>
	 * <p>Date Modified: 2016-02-26</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: schedulechanges-01</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testChangeLogIdTagIsBeyondMinimum() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = "http://v-cpad-p01.tvo.org:8080/CPAD/scheduleChange/?change_log_id_gt=211";
		String a = "access_type=Delete";		
		String b = "access_time_gt=" + function.timestampPlusYears(-7);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 years before today
		String c = "access_time_lte=" + function.timestampPlusYears(7);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 years after today		
		String d = "size=50";
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
   		String record = "schedule_change_log";
   		String tag = "change_log_id";
   		String expected = "211";
   		String condition = "greater";

		for (int i = 0; i < URL.length; i++) {
		String B = "access_time_gt=" + function.timestampPlusYears(-7);
		String C = "access_time_lte=" + function.timestampPlusYears(7);
		URL[i] = (URL[i].replace(b, B)).replace(c, C);
	    try { function.assertCpadTagsCompareToExpected(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, expected, condition, false); }
		catch (Exception exception) { /** exception.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
		}

	/**
	 * Test all of the possible given URL combinations are having the "access_type" tags of "schedule_change_log" record is equal to "Create" [2]
	 * <p>Date Created: 2016-02-26</p>
	 * <p>Date Modified: 2016-02-26</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: schedulechanges-02</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testAccessTypeTagIsCreate() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = "http://v-cpad-p01.tvo.org:8080/CPAD/scheduleChange/?access_type=Create";	
		String a = "change_log_id_gt=211";		
		String b = "access_time_gt=" + function.timestampPlusYears(-7);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 years before today
		String c = "access_time_lte=" + function.timestampPlusYears(7);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 years after today		
		String d = "size=50";
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
   		String record = "schedule_change_log";
   		String tag = "access_type";
   		String expected = "Create";
   		String condition = "equal";

		for (int i = 0; i < URL.length; i++) {
		String B = "access_time_gt=" + function.timestampPlusYears(-7);
		String C = "access_time_lte=" + function.timestampPlusYears(7);
		URL[i] = (URL[i].replace(b, B)).replace(c, C);
		try { function.assertCpadTagsCompareToExpected(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, expected, condition, false); }
		catch (Exception exception) { /** exception.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
		}

	/**
	 * Test all of the possible given URL combinations having maximum or less "schedule_change_log" records returned [3]
	 * <p>Date Created: 2016-02-26</p>
	 * <p>Date Modified: 2016-02-26</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: schedulechanges-03</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScheduleChangeLogRecordsMaxNumber() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = "http://v-cpad-p01.tvo.org:8080/CPAD/scheduleChange/?size=13";
		String a = "change_log_id_gt=211";
		String b = "access_time_gt=" + function.timestampPlusYears(-7);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 years before today
		String c = "access_time_lte=" + function.timestampPlusYears(7);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 years after today	
		String d = "access_type=Create";
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
   		String record = "schedule_change_log";
   		int max = 13;

		for (int i = 0; i < URL.length; i++) {
		String B = "access_time_gt=" + function.timestampPlusYears(-7);
		String C = "access_time_lte=" + function.timestampPlusYears(7);
		URL[i] = (URL[i].replace(b, B)).replace(c, C);
		try { function.assertCpadTagsMaxNumber(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, max); }
		catch (Exception exception) { /** exception.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}

	/**
	 * Test all of the possible given URL combinations having the "access_time" tags of all the "schedule_change_log" records returning dates greater than timestamp filter [4]
	 * <p>Date Created: 2016-02-26</p>
	 * <p>Date Modified: 2016-02-26</p>
	 * <p>Original Version: V3</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: schedulechanges-04</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testAccessTimeTagIsFilteredAsAfter() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = "http://v-cpad-p01.tvo.org:8080/CPAD/scheduleChange/?access_time_gt=" + function.timestampPlusDays(-3);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS that is 3 days before today
		String a = "change_log_id_gt=211";
		String b = "access_time_lte=" + function.timestampPlusYears(7);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 years after today
		String c = "access_type=Delete";
		String d = "size=50";				
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
   		String record = "schedule_change_log";
   		String tag = "access_time";
   		String condition = "after";
	        
		for (int i = 0; i < URL.length; i++) {
		String ROOT = "http://v-cpad-p01.tvo.org:8080/CPAD/scheduleChange/?access_time_gt=" + function.timestampPlusDays(-3);
		String B = "access_time_lte=" + function.timestampPlusYears(7);
		URL[i] = (URL[i].replace(root, ROOT)).replace(b, B);
		try { function.assertCpadTagsDateFilter(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, condition); }
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
	 * Test all of the possible given URL combinations having the "access_time" tags of all the "schedule_change_log" records returning dates less than or equal to timestamp filter [5]
	 * <p>Date Created: 2016-02-26</p>
	 * <p>Date Modified: 2016-02-26</p>
	 * <p>Original Version: V3</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: schedulechanges-05</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testAccessTimeTagIsFilteredAsNotAfter() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = "http://v-cpad-p01.tvo.org:8080/CPAD/scheduleChange/?access_time_lte=" + function.timestampPlusDays(3);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS that is 3 days after today
		String a = "change_log_id_gt=211";
		String b = "access_time_gt=" + function.timestampPlusYears(-7);   // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 years before today
		String c = "access_type=Delete";
		String d = "size=50";				
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
   		String record = "schedule_change_log";
   		String tag = "access_time";
   		String condition = "not after";
	        
		for (int i = 0; i < URL.length; i++) {
		String ROOT = "http://v-cpad-p01.tvo.org:8080/CPAD/scheduleChange/?access_time_lte=" + function.timestampPlusDays(3);
		String B = "access_time_gt=" + function.timestampPlusYears(-7);
		URL[i] = (URL[i].replace(root, ROOT)).replace(b, B);
		try { function.assertCpadTagsDateFilter(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, condition); }
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
	 * Test all of the possible given URL combinations having sorting for asset changes by its "change_log_id" tags of "schedule_change_log" records are in ascending order [6]
	 * <p>Date Created: 2016-02-26</p>
	 * <p>Date Modified: 2016-02-26</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: schedulechanges-06</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testChangeLogIdTagOrderIsAscending() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = "http://v-cpad-p01.tvo.org:8080/CPAD/scheduleChange/";
		String a = "change_log_id_gt=211";		
		String b = "access_time_gt=" + function.timestampPlusYears(-7);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 years before today
		String c = "access_time_lte=" + function.timestampPlusYears(7);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 7 years after today
		String d = "access_type=Create";
		String e = "size=60";

		String[] URL = Locator.url(root, Locator.combination(a, b, c, d, e));
   		String record = "schedule_change_log";
   		String tag = "change_log_id";
	        
		for (int i = 0; i < URL.length; i++) {
		String B = "access_time_gt=" + function.timestampPlusYears(-7);
		String C = "access_time_lte=" + function.timestampPlusYears(7);
		URL[i] = (URL[i].replace(b, B)).replace(c, C);
		try { function.assertCpadTagsAsc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag); }
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