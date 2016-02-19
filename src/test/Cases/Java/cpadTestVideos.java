package test.Cases.Java;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import test.common.Locators;
import test.helper.Functions;


public class cpadTestVideos{
	Functions function = new Functions();
	int count = 0;
	
	/**
	 * Test all of the possible given URL combinations are having the "group" tags of "video" record are correct [1]
	 * <p>Date Created: 2016-02-19</p>
	 * <p>Date Modified: 2016-02-19</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-01</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testGroupTagIsCorrect() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/videos/?group=Adult";
		String a = "program_asset_id=3106";
		String b = "size=60";
		String c = "sort_order=desc";
		String d = "sort_by=created_on";
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d));
   		String record = "video";
   		String tag = "group";
   		String expected = "Adult";
		
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
	
	/** 
	 * Test all of the possible given URL combinations are having the "program_asset_id" tags of "video" record are correct [2]
	 * <p>Date Created: 2016-02-19</p>
	 * <p>Date Modified: 2016-02-19</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: video-02</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testProgramAssetIdTagIsCorrect() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/videos/?program_asset_id=2790";		
		String a = "group=Adult";
		String b = "size=40";
		String c = "sort_order=desc";
		String d = "sort_by=born_date";		
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d));
   		String record = "video";
   		String tag = "program_asset_id";
   		String expected = "2790";
		
	    function.fileWriterPrinter("\n" + " TEST EXECUTION #" + count + ":");

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsEqualToExpected(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, expected); }
		catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				       // function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST EXECUTION # " + count + " - Unexpected Results found!" //,
		        	   // Boolean.valueOf(function.fileScanner("cpad.log")))
		        		 );
	}
	
	/*
	3. Testing the size filter for videos:
	Using the all of the possible combinations of the following query parameters with the endpoint url  
	http://tomcat-dev:8080/CPAD/videos/?size=5
	, 5 or less  
	<video> records should be returned.

			String a = "group=Adult";
			String a = "program_asset_id=2790";
			String a = "sort_order=asc";
			String a = "sort_by=born_date";
	*/
	/**
	 * Test all of the possible given URL combinations having maximum or less "video" records returned [3]
	 * <p>Date Created: 2016-02-19</p>
	 * <p>Date Modified: 2016-02-19</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-03</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testVideoRecordsMaxNumber() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/videos/?size=5";
		String a = "group=Adult";
		String b = "program_asset_id=2790";
		String c = "sort_order=asc";
		String d = "sort_by=born_date";
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d));
   		String record = "video";
   		int max = 5;
		
	    function.fileWriterPrinter("\n" + " TEST EXECUTION #" + count + ":");

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsMaxNumber(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, max); }
		catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				       // function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST EXECUTION # " + count + " - Unexpected Results found!" //,
		        	   // Boolean.valueOf(function.fileScanner("cpad.log")))
		        		 );
	}

	/**
	 * Test all of the possible given URL combinations having all the "created_on" tags of "video" record in DESC order [6]
	 * <p>Date Created: 2016-02-10</p>
	 * <p>Date Modified: 2016-02-10</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: video-06</p>
	 * @throws IOException
	 */	
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testCreateOnOrderIsDescending() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/videos/?sort_by=created_on&sort_order=desc";
		String a = "program_asset_id=2790";
		String b = "group=Adult";
		String c = "size=80";	
		String[] URL = Locators.url(root, Locators.combination(a, b, c));
   		String record = "video";
   		String tag = "created_on";
   		
	    function.fileWriterPrinter("\n" + " TEST EXECUTION #" + count + ":");

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsDateDesc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag); }
		catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				       // function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST EXECUTION # " + count + " - Unexpected Results found!" //,
		        	   // Boolean.valueOf(function.fileScanner("cpad.log")))
		        		 );
	}

   @BeforeSuite  public static void logOpen() throws IOException { new Functions().logOpen(); }
   @AfterSuite   public static void logClose() throws IOException { new Functions().logClose(); }
   @BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); } 
   @AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }

}
