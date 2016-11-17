package test.Cases;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.common.Locators;
import test.helper.Functions;

public class AssetChange {
	Functions function = new Functions();
	
	/**
	 * Test all of the possible given URL combinations are having the "id" tags of "change_log" record greater than given minimum [1]
	 * <p>Date Created: 2016-02-24</p>
	 * <p>Date Modified: 2016-02-29</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: V4</p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: assetchanges-01</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testIdTagIsBeyondMinimum() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "assetChanges/?id_gt=16257024";		
		String a = "access_time_gt=" + function.timestampPlusYears(-5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today
		String b = "access_time_lte=" + function.timestampPlusYears(5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today		
		String c = "access_type=Update";
		String d = "asset_type=Program";
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d));
   		String record = "change_log";
   		String tag = "id";
   		String expected = "16257024";
   		String condition = "greater";

		for (int i = 0; i < URL.length; i++) {
		String A = "access_time_gt=" + function.timestampPlusYears(-5);
		String B = "access_time_lte=" + function.timestampPlusYears(5);
		URL[i] = (URL[i].replace(a, A)).replace(b, B);
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
	 * Test all of the possible given URL combinations are having the "object_id" tags of "change_log" record is correct [2]
	 * ! NOTE: There may be 0 <change_log> records present for several combinations of parameters, if this is the case then the test should be inconclusive.
	 * <p>Date Created: 2016-02-24</p>
	 * <p>Date Modified: 2016-02-29</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: V4</p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: assetchanges-02</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testObjectIdTagIsCorrect() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "assetChanges/?object_id=2790";	
		String a = "access_time_gt=" + function.timestampPlusYears(-5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today
		String b = "access_time_lte=" + function.timestampPlusYears(5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today		
		String c = "access_type=Update";
		String d = "asset_type=Program";
		String e = "size=20";
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d, e));
   		String record = "change_log";
   		String tag = "object_id";
   		String expected = "2790";
   		String condition = "equal";

		for (int i = 0; i < URL.length; i++) {
		String A = "access_time_gt=" + function.timestampPlusYears(-5);
		String B = "access_time_lte=" + function.timestampPlusYears(5);
		URL[i] = (URL[i].replace(a, A)).replace(b, B);
		try { function.assertCpadTagsCompareToExpected(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, expected, condition, true); }
		catch (Exception exception) { /** exception.printStackTrace(); */ function.fileWriterPrinter("\nERROR!\nURL[" + i + "]: " + URL[i] + "\n"); }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
		}

	/**
	 * Test all of the possible given URL combinations are having the "access_type" tags of "change_log" record is equal to "Create" [3]
	 * <p>Date Created: 2016-02-24</p>
	 * <p>Date Modified: 2016-02-29</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: V4</p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: assetchanges-03</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testAccessTypeTagIsCreate() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "assetChanges/?access_type=Create";			
		String a = "access_time_gt=" + function.timestampPlusYears(-5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today
		String b = "access_time_lte=" + function.timestampPlusYears(5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today		
		String c = "asset_type=Video";
		String d = "size=20";
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d));
   		String record = "change_log";
   		String tag = "access_type";
   		String expected = "Create";
   		String condition = "equal";

		for (int i = 0; i < URL.length; i++) {
		String A = "access_time_gt=" + function.timestampPlusYears(-5);
		String B = "access_time_lte=" + function.timestampPlusYears(5);
		URL[i] = (URL[i].replace(a, A)).replace(b, B);
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
	 * Test all of the possible given URL combinations are having the "asset_type" tags of "change_log" record is equal to "Video" [4]
	 * <p>Date Created: 2016-02-24</p>
	 * <p>Date Modified: 2016-02-29</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: V4</p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: assetchanges-04</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testAssetTypeTagIsVideo() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "assetChanges/?asset_type=Video";			
		String a = "access_time_gt=" + function.timestampPlusYears(-5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today
		String b = "access_time_lte=" + function.timestampPlusYears(5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today		
		String c = "access_type=Update";
		String d = "size=20";
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d));
   		String record = "change_log";
   		String tag = "asset_type";
   		String expected = "Video";
   		String condition = "equal";

		for (int i = 0; i < URL.length; i++) {
		String A = "access_time_gt=" + function.timestampPlusYears(-5);
		String B = "access_time_lte=" + function.timestampPlusYears(5);
		URL[i] = (URL[i].replace(a, A)).replace(b, B);
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
	 * Test all of the possible given URL combinations having maximum or less "change_log" records returned [5]
	 * <p>Date Created: 2016-02-24</p>
	 * <p>Date Modified: 2016-02-29</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: V4</p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: assetchanges-05</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testChangeLogRecordsMaxNumber() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "assetChanges/?size=5";
		String a = "access_time_gt=" + function.timestampPlusYears(-5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today
		String b = "access_time_lte=" + function.timestampPlusYears(5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today	
		String c = "access_type=Update";
		String d = "asset_type=Video";
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d));
   		String record = "change_log";
   		int max = 5;

		for (int i = 0; i < URL.length; i++) {
		String A = "access_time_gt=" + function.timestampPlusYears(-5);
		String B = "access_time_lte=" + function.timestampPlusYears(5);
		URL[i] = (URL[i].replace(a, A)).replace(b, B);
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
	 * Test all of the possible given URL combinations having the "access_time" tags of all the "change_log" records returning dates greater than timestamp filter [6]
	 * <p>Date Created: 2016-02-24</p>
	 * <p>Date Modified: 2016-02-26</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: V3</p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: assetchanges-06</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testAccessTimeTagIsFilteredAsAfter() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "assetChanges/?access_time_gt=" + function.timestampPlusDays(-3);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS that is 3 days before today
		String a = "access_time_lte=" + function.timestampPlusDays(5);   // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 days after today
		String b = "access_type=Update";
		String c = "asset_type=Video";
		String d = "size=40";				
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d));
   		String record = "change_log";
   		String tag = "access_time";
   		String condition = "after";
	        
		for (int i = 0; i < URL.length; i++) {
		String ROOT = Locators.cpadServerURL + "assetChanges/?access_time_gt=" + function.timestampPlusDays(-3);
		String A = "access_time_lte=" + function.timestampPlusDays(5);
		URL[i] = (URL[i].replace(root, ROOT)).replace(a, A);
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
	 * Test all of the possible given URL combinations having the "access_time" tags of all the "change_log" records returning dates less than or equal to timestamp filter [7]
	 * <p>Date Created: 2016-02-24</p>
	 * <p>Date Modified: 2016-02-26</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: V3</p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: assetchanges-07</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testAccessTimeTagIsFilteredAsNotAfter() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "assetChanges/?access_time_lte=" + function.timestampPlusDays(3);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS that is 3 days after today
		String a = "access_time_gt=" + function.timestampPlusDays(-5);   // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 days before today
		String b = "access_type=Update";
		String c = "asset_type=Video";
		String d = "size=40";				
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d));
   		String record = "change_log";
   		String tag = "access_time";
   		String condition = "not after";
	        
		for (int i = 0; i < URL.length; i++) {
		String ROOT = Locators.cpadServerURL + "assetChanges/?access_time_lte=" + function.timestampPlusDays(3);
		String A = "access_time_gt=" + function.timestampPlusDays(-5);
		URL[i] = (URL[i].replace(root, ROOT)).replace(a, A);
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
	 * Test all of the possible given URL combinations having sorting for asset changes by its "id" tags of "change_log" records are in ascending order [8]
	 * <p>Date Created: 2016-02-24</p>
	 * <p>Date Modified: 2016-04-27</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: V3</p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: assetchanges-08</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testIdTagOrderIsAscending() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "assetChanges/";
		String a = "access_type=Update";	
		String b = "access_time_gt=" + function.timestampPlusYears(-5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today
		String c = "access_time_lte=" + function.timestampPlusYears(5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today
		String d = "asset_type=Video";
		String e = "size=20";
		
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d, e));
		
		String record = "change_log";
   		String tag = "id";
	        
		for (int i = 0; i < URL.length; i++) {
		String C = "access_time_gt=" + function.timestampPlusYears(-5);
		String D = "access_time_lte=" + function.timestampPlusYears(5);
		URL[i] = (URL[i].replace(c, C)).replace(d, D);
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

	/**
	 * Test Asset Changelog: Verify that create, update and delete are displayed in chronological order [49]
	 * <p>Date Created: 2016-11-14</p>
	 * <p>Date Modified: 2016-11-14</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>Test Cases: 37431</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	
	@Test(groups = {"TC-37431"}, priority = 49)
	@SuppressWarnings("static-access")
	public void testAccessTimeTagOrderIsAscendingForVideoAssetOnUpdateAndDeleteAccess() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "assetChanges/";
		String a = "asset_type=Video";	
		String b = "access_type=Update";
		String c = "access_type=Delete";
		String d = "group=Kids";
		
		// TEST A + B + D:
		String[] URL = Locators.url(root, Locators.combination(a, b));
		
		String record = "change_log";
		String timestamp = "access_time";
	        
		for (int i = 0; i < URL.length; i++) {
			URL[i] = Locators.url(URL[i], d);
			try { 
				function.assertCpadTagsDateAsc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, timestamp);
			} catch (Exception exception) { /** exception.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
		
		// TEST A + C + D:
		URL = Locators.url(root, Locators.combination(a, c));
	        
		for (int i = 0; i < URL.length; i++) {
			URL[i] = Locators.url(URL[i], d);
			try { 
				function.assertCpadTagsDateAsc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, timestamp);
			} catch (Exception exception) { /** exception.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}
	
	/**
	 * Test Asset Changelog: Verify that create, update and delete are displayed in chronological order [50]
	 * <p>Date Created: 2016-11-14</p>
	 * <p>Date Modified: 2016-11-14</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>Test Cases: 37432</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@Test(groups = {"TC-37432"}, priority = 49)
	@SuppressWarnings("static-access")
	public void testIdTagOrderIsAscendingForVideoAssetOnUpdateAndDeleteAccess() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "assetChanges/";
		String a = "asset_type=Video";	
		String b = "access_type=Update";
		String c = "access_type=Delete";
		String d = "group=Kids";
		
		// TEST A + B + D:
		String[] URL = Locators.url(root, Locators.combination(a, b));
		
		String record = "change_log";
   		String tag = "id";
	        
		for (int i = 0; i < URL.length; i++) {
			URL[i] = Locators.url(URL[i], d);
			try { 
				function.assertCpadTagsAsc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);
			} catch (Exception exception) { /** exception.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
		
		// TEST A + C + D:
		URL = Locators.url(root, Locators.combination(a, c));
	        
		for (int i = 0; i < URL.length; i++) {
			URL[i] = Locators.url(URL[i], d);
			try { 
				function.assertCpadTagsAsc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);
			} catch (Exception exception) { /** exception.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}
	
	/**
	 * Test display only first 50 asset change log records [54]
	 * <p>Date Created: 2016-11-17</p>
	 * <p>Date Modified: 2016-11-17</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>Test Cases: 37497</p>
	 */
	@Test(groups = {"TC-37497"}, priority = 54)
	@SuppressWarnings("static-access")
	public void testDisplayOnlyFirstSizeAssetChanges() throws IOException, ParseException {		
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
				
		String root = Locators.cpadServerURL + "assetChanges/?";
		String a = "start=0";		
		String b = "size=50";
		String c = "group=Kids";
		String[] URL = Locators.url(root, Locators.permulation(a, b, c));
   		String record = "change_log";
   		int number = 50;

		for (int i = 0; i < URL.length; i++) {
			try { function.assertCpadTagsTotalNumber(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, number); }
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
