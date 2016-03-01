package test.Cases;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.common.Locator;
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
	    
		String root = "http://tomcat-dev:8080/CPAD/assetChanges/?id_gt=16257024";		
		String a = "access_time_gt=" + function.timestampPlusYears(-5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today
		String b = "access_time_lte=" + function.timestampPlusYears(5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today		
		String c = "access_type=Update";
		String d = "asset_type=Program";
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
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
	    
		String root = "http://tomcat-dev:8080/CPAD/assetChanges/?object_id=2790";	
		String a = "access_time_gt=" + function.timestampPlusYears(-5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today
		String b = "access_time_lte=" + function.timestampPlusYears(5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today		
		String c = "access_type=Update";
		String d = "asset_type=Program";
		String e = "size=20";
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d, e));
   		String record = "change_log";
   		String tag = "object_id";
   		String expected = "2790";
   		String condition = "equal";

		for (int i = 0; i < URL.length; i++) {
		String A = "access_time_gt=" + function.timestampPlusYears(-5);
		String B = "access_time_lte=" + function.timestampPlusYears(5);
		URL[i] = (URL[i].replace(a, A)).replace(b, B);
		try { function.assertCpadTagsCompareToExpected(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, expected, condition, true); }
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
	    
		String root = "http://tomcat-dev:8080/CPAD/assetChanges/?access_type=Create";			
		String a = "access_time_gt=" + function.timestampPlusYears(-5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today
		String b = "access_time_lte=" + function.timestampPlusYears(5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today		
		String c = "asset_type=Video";
		String d = "size=20";
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
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
	    
		String root = "http://tomcat-dev:8080/CPAD/assetChanges/?asset_type=Video";			
		String a = "access_time_gt=" + function.timestampPlusYears(-5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today
		String b = "access_time_lte=" + function.timestampPlusYears(5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today		
		String c = "access_type=Update";
		String d = "size=20";
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
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
	    
		String root = "http://tomcat-dev:8080/CPAD/assetChanges/?size=5";
		String a = "access_time_gt=" + function.timestampPlusYears(-5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today
		String b = "access_time_lte=" + function.timestampPlusYears(5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today	
		String c = "access_type=Update";
		String d = "asset_type=Video";
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
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
	    
		String root = "http://tomcat-dev:8080/CPAD/assetChanges/?access_time_gt=" + function.timestampPlusDays(-3);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS that is 3 days before today
		String a = "access_time_lte=" + function.timestampPlusDays(5);   // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 days after today
		String b = "access_type=Update";
		String c = "asset_type=Video";
		String d = "size=40";				
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
   		String record = "change_log";
   		String tag = "access_time";
   		String condition = "after";
	        
		for (int i = 0; i < URL.length; i++) {
		String ROOT = "http://tomcat-dev:8080/CPAD/assetChanges/?access_time_gt=" + function.timestampPlusDays(-3);
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
	    
		String root = "http://tomcat-dev:8080/CPAD/assetChanges/?access_time_lte=" + function.timestampPlusDays(3);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS that is 3 days after today
		String a = "access_time_gt=" + function.timestampPlusDays(-5);   // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 days before today
		String b = "access_type=Update";
		String c = "asset_type=Video";
		String d = "size=40";				
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
   		String record = "change_log";
   		String tag = "access_time";
   		String condition = "not after";
	        
		for (int i = 0; i < URL.length; i++) {
		String ROOT = "http://tomcat-dev:8080/CPAD/assetChanges/?access_time_lte=" + function.timestampPlusDays(3);
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
	 * <p>Date Modified: 2016-02-24</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: assetchanges-08</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testIdTagOrderIsAscending() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = "http://tomcat-dev:8080/CPAD/assetChanges/";
		String a = "access_type=Update";
		String b = "object_id=014259";		
		String c = "access_time_gt=" + function.timestampPlusYears(-5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today
		String d = "access_time_lte=" + function.timestampPlusYears(5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today
		String e = "asset_type=Video";
		String f = "size=20";
		
		String[] URL = Locator.url(root, Locator.combination(a, b, c, d, e, f));
		
//	 // UNIT TESTS
//		String[] URL = Locator.url(root, Locator.combination(a, b, c, d));
//		String[] URL = { "http://tomcat-dev:8080/CPAD/assetChanges/?access_type=Update&access_time_lte=2021-02-28T03:31:10&access_time_gt=2011-02-28T03:31:10&asset_type=Video&object_id=01425" };
		
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
	
   @BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); } 
   @AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }
}
