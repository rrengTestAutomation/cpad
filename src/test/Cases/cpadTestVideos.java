package test.Cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import test.common.Locators;
import test.helper.Functions;

public class cpadTestVideos{
	static WebDriver driver;
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
	    boolean result = true;
		for (int i = 0; i < URL.length; i++) {

		try {
			driver = function.getServerName(driver);
			result = function.assertCpadTagsDateDesc(driver, URL[i], i+1, URL.length, false, record, tag);
			
			// SCREENSHOT-CAPABLE ASSERTION:
			if (i == URL.length - 1) {
				Assert.assertTrue(result, function.getAssertTrue(new RuntimeException().getStackTrace()[0], driver,
		                         "TEST EXECUTION # " + count + " - Out Of Order ''Created On'' Records found!",
		                          result));
				}
			
			} catch (Exception e) { /** e.printStackTrace(); */ result = false; } finally { closeBrowsers(); }
		}
		
	}

   @BeforeSuite  public static void logOpen() throws IOException { new Functions().logOpen(); }
   @AfterSuite   public static void logClose() throws IOException { new Functions().logClose(); }
   @BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); } 
   @AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }
// @AfterMethod  public static void closeBrowsers() { driver.quit(); }
   @AfterClass   public static void closeBrowsers() { driver.quit(); }

}
