package test.Cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;

//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import test.common.Locators;
import test.helper.Functions;

public class cpadTestPrograms{
	static WebDriver driver;
	Functions function = new Functions();
	int count = 0;
	
	/**
	 * Test all of the possible given URL combinations are having the "group" tags of "program" record equals "Adult" [1]
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
	public void testGroupTagIsAdult() throws IOException {
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
		try {
			driver = function.getServerName(driver);
			function.assertCpadTagsEqualToExpected(driver, new RuntimeException().getStackTrace()[0],
					                               URL[i], i+1, URL.length, false, record, tag, expected);
//			// SCREENSHOT-DISABLED ASSERTION:
//			if (i == URL.length - 1) {
//				Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), "TEST EXECUTION # " + count + " - Unexpected Records found!");
//				}
			
			} catch (Exception e) { /** e.printStackTrace(); */ } finally { closeBrowsers(); }
		}
		
		// SCREENSHOT-CAPABLE ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), function.getAssertTrue(new RuntimeException().getStackTrace()[0], driver,
                         "TEST EXECUTION # " + count + " - Unexpected Records found!",
                          Boolean.valueOf(function.fileScanner("cpad.log"))));
	}

	/**
	 * Test all of the possible given URL combinations are having the "single_program" tags of "program" record equals "1" [2]
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
	public void testSingleProgramTagIsOne() throws IOException {
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
		try {
			driver = function.getServerName(driver);
			function.assertCpadTagsEqualToExpected(driver, new RuntimeException().getStackTrace()[0],
					                               URL[i], i+1, URL.length, false, record, tag, expected);
//			// SCREENSHOT-DISABLED ASSERTION:
//			if (i == URL.length - 1) {
//				Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), "TEST EXECUTION # " + count + " - Unexpected Records found!");
//				}
			
			} catch (Exception e) { /** e.printStackTrace(); */ } finally { closeBrowsers(); }
		}
		
		// SCREENSHOT-CAPABLE ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), function.getAssertTrue(new RuntimeException().getStackTrace()[0], driver,
                         "TEST EXECUTION # " + count + " - Unexpected Records found!",
                          Boolean.valueOf(function.fileScanner("cpad.log"))));
	}
	
	/**
	 * Test all of the possible given URL combinations having 7 or less "program" records returned [3]
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
		try {
			driver = function.getServerName(driver);
			function.assertCpadTagsMaxNumber(driver, new RuntimeException().getStackTrace()[0],
					                         URL[i], i+1, URL.length, false, record, max);

//			// SCREENSHOT-DISABLED ASSERTION:
//			if (i == URL.length - 1) {
//				Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), "TEST EXECUTION # " + count + " - Unexpected Records found!");
//				}
			
			} catch (Exception e) { /** e.printStackTrace(); */ } finally { closeBrowsers(); }
		}
		
		// SCREENSHOT-CAPABLE ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), function.getAssertTrue(new RuntimeException().getStackTrace()[0], driver,
                         "TEST EXECUTION # " + count + " - Unexpected Records found!",
                          Boolean.valueOf(function.fileScanner("cpad.log"))));
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
	public void testCreateOnOrderIsAscending() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/programs/?sort_order=ASC&sort_by=CREATED_ON";
		String a = "group=Adult";
		String b = "single_program=0";
		String c = "size=70";
		String[] URL = Locators.url(root, Locators.combination(a, b, c));
	    
   //// UNIT TEST
     // String[] URL = { "http://tomcat-dev:8080/CPAD/programs/?sort_order=ASC&sort_by=CREATED_ON&group=Adult&size=70",
     //                  "http://tomcat-dev:8080/CPAD/programs/?sort_order=ASC&sort_by=CREATED_ON&single_pr"
     //                };

   		String record = "program";
   		String tag = "created_on";
   		
	    function.fileWriterPrinter("\n" + " TEST EXECUTION #" + count + ":");
	        
		for (int i = 0; i < URL.length; i++) {
		try {
			driver = function.getServerName(driver);
			function.assertCpadTagsDateAsc(driver, new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);
			
//			// SCREENSHOT-DISABLED ASSERTION:
//			if (i == URL.length - 1) {
//				Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), "TEST EXECUTION # " + count + " - Unexpected Results found!");
//				}			
			} catch (Exception e) { /** e.printStackTrace(); */ } finally { closeBrowsers(); }
		}
		
		// SCREENSHOT-CAPABLE ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), function.getAssertTrue(new RuntimeException().getStackTrace()[0], driver,
                         "TEST EXECUTION # " + count + " - Unexpected Results found!",
                          Boolean.valueOf(function.fileScanner("cpad.log"))));
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
	public void testCreateOnOrderIsDescending() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    
		String root = "http://tomcat-dev:8080/CPAD/programs/?sort_order=DESC&sort_by=CREATED_ON";
		String a = "group=Kids";
		String b = "single_program=0";
		String c = "size=70";
		String[] URL = Locators.url(root, Locators.combination(a, b, c));
	    
   //// UNIT TEST
     // String[] URL = { "http://tomcat-dev:8080/CPAD/programs/?sort_order=ASC&sort_by=CREATED_ON&group=Adult&size=70",
     //                  "http://tomcat-dev:8080/CPAD/programs/?sort_order=ASC&sort_by=CREATED_ON&single_pr"
     //                };

   		String record = "program";
   		String tag = "created_on";
   		
	    function.fileWriterPrinter("\n" + " TEST EXECUTION #" + count + ":");
	        
		for (int i = 0; i < URL.length; i++) {
		try {
			driver = function.getServerName(driver);
			function.assertCpadTagsDateAsc(driver, new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);
			
//			// SCREENSHOT-DISABLED ASSERTION:
//			if (i == URL.length - 1) {
//				Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), "TEST EXECUTION # " + count + " - Unexpected Results found!");
//				}			
			} catch (Exception e) { /** e.printStackTrace(); */ } finally { closeBrowsers(); }
		}
		
		// SCREENSHOT-CAPABLE ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), function.getAssertTrue(new RuntimeException().getStackTrace()[0], driver,
                         "TEST EXECUTION # " + count + " - Unexpected Results found!",
                          Boolean.valueOf(function.fileScanner("cpad.log"))));
	}
	
   @BeforeSuite  public static void logOpen() throws IOException { new Functions().logOpen(); }
   @AfterSuite   public static void logClose() throws IOException { new Functions().logClose(); }
   @BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); } 
   @AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }
   @AfterMethod  public static void closeBrowsers() { driver.quit(); }
// @AfterClass   public static void closeBrowsers() { driver.quit(); }

}
