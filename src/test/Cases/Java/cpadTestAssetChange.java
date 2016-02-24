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

public class cpadTestAssetChange {
	Functions function = new Functions();
	int count = 0;
	
	/*
	1. Testing the id greater than filter for asset changes:
	Using the all of the possible combinations of the following query parameters with the endpoint url
	http://tomcat-dev:8080/CPAD/assetChanges/?id_gt=16257024
	,
	<change_log> records returned have their
	<id> tags greater than "16257024".
			String a = "object_id=2790";
			String b = "access_time_gt=";(a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today)
			String c = "access_time_lte=";(a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today)
			String d = "access_type=Update";
			String e = "asset_type=Program";
	*/
	/**
	 * Test all of the possible given URL combinations are having the "id" tags of "change_log" record greater than given minimum [1]
	 * <p>Date Created: 2016-02-24</p>
	 * <p>Date Modified: 2016-02-24</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: assetchange-01</p>
	 * @throws IOException
	 * @throws ParseException 
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testIdTagIsCorrect() throws IOException, ParseException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/assetChanges/?id_gt=16257024";
		String a = "object_id=2790";		
		String b = "access_time_gt=" + function.timestampPlusYears(-5);   // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today
		String c = "access_time_lte=" + function.timestampPlusYears(5);  // a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today		
		String d = "access_type=Update";
		String e = "asset_type=Program";
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d, e));
   		String record = "change_log";
   		String tag = "id";
   		int minimum = 16257024;
		
	    function.fileWriterPrinter("\n" + " TEST EXECUTION #" + count + ":");

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsGreaterThenMinimum(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, minimum); }
		catch (Exception exception) { /** exception.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				          //function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST EXECUTION # " + count + " - Unexpected Results found!"
		        		 //,Boolean.valueOf(function.fileScanner("cpad.log")))
		        		 );
		}
			
	/*
	2. Testing the object id filter for asset changes:
	Using the all of the possible combinations of the following query parameters with the endpoint url
	http://tomcat-dev:8080/CPAD/assetChanges/?object_id=119845
	,
	<change_log> records returned have their
	<object_id> tags equal to "119845".
			String a = "access_time_gt=";(a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today)
			String b = "access_time_lte=";(a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today)
			String c = "access_type=Update";
			String d = "asset_type=Program";
			String e = "size=20";
	*/
			
	/*
	3. Testing the access type filter for asset changes:
	Using the all of the possible combinations of the following query parameters with the endpoint url
	http://tomcat-dev:8080/CPAD/assetChanges/?access_type=Create
	,
	<change_log> records returned have their
	<access_type> tags equal to "Create".
			String a = "object_id=014259";
			String b = "access_time_gt=";  (a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today)
			String c = "access_time_lte="; (a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today)
			String d = "asset_type=Video";
			String e = "size=20";
	*/
			
	/*
	4. Testing the asset type filter for asset changes:
	Using the all of the possible combinations of the following query parameters with the endpoint url
	http://tomcat-dev:8080/CPAD/assetChanges/?asset_type=Video
	,
	<change_log> records returned have their
	<asset_type> tags equal to "Video".
			String a = "object_id=632923";
			String b = "access_time_gt=";(a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today)
			String c = "access_time_lte=";(a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today)
			String d = "access_type=Update";
			String e = "size=20";
	*/
			
	/*
	5. Testing the size filter for asset changes:
	Using the all of the possible combinations of the following query parameters with the endpoint url
	http://tomcat-dev:8080/CPAD/assetChanges/?size=5
	,
	the amount of
	<change_log> records returned should be less than or equal to 5.
			String a = "object_id=2335251";
			String b = "access_time_gt=";(a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today)
			String c = "access_time_lte=";(a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today)
			String d = "access_type=Update";
			String e = "asset_type=Video";
	*/
			
	/*
	6. Testing the access time greater than filter for asset changes:
	Using the all of the possible combinations of the following query parameters with the endpoint url
	http://tomcat-dev:8080/CPAD/assetChanges/?access_time_gt={timestamp}
	,
	where {timestamp} is a date timestamp formatted YYYY-MM-DDTHH:MM:SS that is 3 days before today. All returned
	<change_log> records should contain an
	<access_time> greater than {timestamp}.
			String a = "access_time_lte=";(a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 days after today)
			String b = "access_type=Update";
			String c = "asset_type=Video";
			String d = "size=40";
	*/
			
	/*
	7. Testing the access time less than or equal to filter for asset changes:
	Using the all of the possible combinations of the following query parameters with the endpoint url
	http://tomcat-dev:8080/CPAD/assetChanges/?access_time_lte={timestamp}
	,
	where {timestamp} is a date timestamp formatted YYYY-MM-DDTHH:MM:SS that is 3 days after today. All returned
	<change_log> records should contain an
	<access_time> less than or equal to {timestamp}.
			String a = "access_time_gt=";(a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 days before today)
			String b = "access_type=Update";
			String c = "asset_type=Video";
			String d = "size=40";
	*/

	/*
	8. Testing the default sort order for asset changes:
	Using the all of the possible combinations of the following query parameters with the endpoint url
	http://tomcat-dev:8080/CPAD/assetChanges/
	,
	<change_log> records returned have their
	<id> tags sorted in numeric ascending order.
			String a = "access_type=Update";
			String b = "object_id=014259";
			String c = "access_time_gt=";(a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years before today)
			String d = "access_time_lte=";(a date timestamp formatted YYYY-MM-DDTHH:MM:SS. This timestamp must be 5 years after today)
			String e = "asset_type=Video";
			String f = "size=20";
	*/
	
   @BeforeSuite  public static void logOpen() throws IOException { new Functions().logOpen(); }
   @AfterSuite   public static void logClose() throws IOException { new Functions().logClose(); }
   @BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); }
   @AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }

}
