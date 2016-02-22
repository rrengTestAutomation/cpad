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

public class cpadTestPrograms{
	Functions function = new Functions();
	int count = 0;
	
	/**
	 * Test all of the possible given URL combinations are having the "group" tags of "program" record are correct [1]
	 * <p>Date Created: 2016-02-10</p>
	 * <p>Date Modified: 2016-02-10</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: programs-01</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testGroupTagIsCorrect() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/programs/?group=Adult";
		String a = "single_program=0";
		String b = "size=60";
		String c = "sort_order=DESC";
		String d = "sort_by=CREATED_ON";
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d));
   		String record = "program";
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
	 * Test all of the possible given URL combinations are having the "single_program" tags of "program" record are correct [2]
	 * <p>Date Created: 2016-02-10</p>
	 * <p>Date Modified: 2016-02-10</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: programs-02</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testSingleProgramTagIsCorrect() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/programs/?single_program=1";
		String a = "group=Adult";
		String b = "size=60";
		String c = "sort_order=DESC";
		String d = "sort_by=UPDATED_ON";
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d));
   		String record = "program";
   		String tag = "single_program";
   		String expected = "1";
		
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
	
	/**
	 * Test all of the possible given URL combinations having maximum or less "program" records returned [3]
	 * <p>Date Created: 2016-02-10</p>
	 * <p>Date Modified: 2016-02-10</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: programs-03</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testProgramRecordsMaxNumber() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/programs/?size=7";
		String a = "group=Kids";
		String b = "single_program=0";
		String c = "sort_order=ASC";
		String d = "sort_by=CREATED_ON";
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d));
   		String record = "program";
   		int max = 7;
		
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
	 * Test sorting programs by its created date in ascending order [4]
	 * <p>Date Created: 2016-02-12</p>
	 * <p>Date Modified: 2016-02-12</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: programs-04</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testCreatedOnOrderIsAscending() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/programs/?sort_order=ASC&sort_by=CREATED_ON";
		String a = "group=Adult";
		String b = "single_program=0";
		String c = "size=70";
		String[] URL = Locators.url(root, Locators.combination(a, b, c));	    
   //// UNIT TEST
     // String[] URL = { root + "&" + c, root + "&" + b };

   		String record = "program";
   		String tag = "created_on";
   		
	    function.fileWriterPrinter("\n" + " TEST EXECUTION #" + count + ":");
	        
		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsDateAsc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag); }
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
	 * Test sorting programs by its created date in descending order [5]
	 * <p>Date Created: 2016-02-15</p>
	 * <p>Date Modified: 2016-02-15</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: programs-05</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testCreatedOnOrderIsDescending() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/programs/?sort_order=DESC&sort_by=CREATED_ON";
		String a = "group=Kids";
		String b = "single_program=0";
		String c = "size=70";
		String[] URL = Locators.url(root, Locators.combination(a, b, c));
   		String record = "program";
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
	
	/**
	 * Test sorting programs by its updated date in ascending order [6]
	 * <p>Date Created: 2016-02-15</p>
	 * <p>Date Modified: 2016-02-15</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: programs-06</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testUpdatedOnOrderIsAscending() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/programs/?sort_order=ASC&sort_by=UPDATED_ON";
		String a = "group=Adult";
		String b = "single_program=1";
		String c = "size=70";
		String[] URL = Locators.url(root, Locators.combination(a, b, c));
   		String record = "program";
   		String tag = "updated_on";
   		
	    function.fileWriterPrinter("\n" + " TEST EXECUTION #" + count + ":");
	        
		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsDateAsc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag); }
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
	 * Test sorting programs by its updated date in descending order [7]
	 * <p>Date Created: 2016-02-15</p>
	 * <p>Date Modified: 2016-02-15</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: programs-07</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testUpdatedOnOrderIsDescending() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/programs/?sort_order=DESC&sort_by=UPDATED_ON";
		String a = "group=Adult";
		String b = "single_program=0";
		String c = "size=70";
		String[] URL = Locators.url(root, Locators.combination(a, b, c));
   		String record = "program";
   		String tag = "updated_on";
   		
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
	
	/**
	 * Test all of the possible given URL combinations are having the "title" tags of "program" record are correct [8]
	 * <p>Date Created: 2016-02-16</p>
	 * <p>Date Modified: 2016-02-16</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: programs-08</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testTitleTagIsCorrect() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/programs/?title=Allan Gregg";
		String a = "group=Adult";
		String b = "single_program=0";
		String c = "size=70";
		String d = "sort_order=DESC";
		String e = "sort_by=UPDATED_ON";
		
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d, e));
		
		//// UNIT TEST
		// String[] URL = Locators.url(root, Locators.combination(b, c));
		
   		String record = "program";
   		String tag = "title";
   		String expected = "Allan Gregg";
		
	    function.fileWriterPrinter("\n" + " TEST EXECUTION #" + count + ":");

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsEqualToExpected(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, expected); }
		catch (Exception exception) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				       // function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST EXECUTION # " + count + " - Unexpected Results found!" //,
		        	   // Boolean.valueOf(function.fileScanner("cpad.log")))
		        		 );
	}
	
	/**
	 * Test given URL is having the "program_asset_id" tag of "program" record is correct [9]
	 * <p>Date Created: 2016-02-18</p>
	 * <p>Date Modified: 2016-02-18</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: programs-09</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testProgramAssetIdTagIsCorrect() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/programs/program_asset_id=2790";
		String[] URL = { root };
   		String record = "program";
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
	
	/**
	 * Test given URL is having the "record_id" tag of "program" record is correct [10]
	 * <p>Date Created: 2016-02-18</p>
	 * <p>Date Modified: 2016-02-18</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: programs-10</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testRecordIdTagIsCorrect() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/programs/record_id=1579281";
		String[] URL = { root };
   		String record = "program";
   		String tag = "record_id";
   		String expected = "1579281";
		
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
	
	/**
	 * Test the "updated_on" tag of all the "program" records are returning dates greater than or equal to filter for programs [11]
	 * <p>Date Created: 2016-02-18</p>
	 * <p>Date Modified: 2016-02-18</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: programs-11</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testUpdatedOnTagIsFiltered() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/programs/updated_on_gte=2015-09-01T16:45:44&group=adult";
		String[] URL = { root };
   		String record = "program";
   		String tag = "updated_on";
   		
	    function.fileWriterPrinter("\n" + " TEST EXECUTION #" + count + ":");
	        
		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsDateFilter(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, "not before"); }
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
	 * Test the "updated_on" tag of all the "program" records are returning dates between "from-to" for programs [12]
	 * <p>Date Created: 2016-02-18</p>
	 * <p>Date Modified: 2016-02-18</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: programs-12</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test(invocationCount = 1)
	public void testUpdatedOnTagIsBetween() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/programs/updated_on_from=2015-09-01T16:45:44&to=2015-09-21T23:45:35&group=adult?size=10";
		String[] URL = { root };
   		String record = "program";
   		String tag = "updated_on";

	    function.fileWriterPrinter("\n" + " TEST EXECUTION #" + count + ":");
	        
		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsDateBetween(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag); }
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
