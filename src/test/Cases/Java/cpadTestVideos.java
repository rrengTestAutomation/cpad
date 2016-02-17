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
