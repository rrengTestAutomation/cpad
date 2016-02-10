package test.Cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
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
	 * Test all of the possible given URL combinations are having the "group" tags of "program" record containing "Adult"
	 * <p>Date Created: 2016-02-10</p>
	 * <p>Date Modified: 2016-02-10</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: video-06</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test(enabled = true, invocationCount = 1)
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
	    boolean result = true;
		for (int i = 0; i < URL.length; i++) {
		try {
			driver = function.getServerName(driver);
			result = function.assertCpadTags(driver, URL[i], i+1, URL.length, false, record, tag, expected);
			
			// SCREENSHOT-CAPABLE ASSERTION:
			if (i == URL.length - 1) {
				Assert.assertTrue(result, function.getAssertTrue(new RuntimeException().getStackTrace()[0], driver,
		                         "TEST EXECUTION # " + count + " - Out Of Order ''Created On'' Records found!",
		                          result));
				}
			
			} catch (Exception e) { /** e.printStackTrace(); */ result = false; } finally { driver.quit(); }
		}
		
	}

   @BeforeSuite  public static void logOpen() throws IOException { new Functions().logOpen(); }
   @AfterSuite   public static void logClose() throws IOException { new Functions().logClose(); }
   @BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); } 
   @AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }
// @AfterMethod   public static void closeBrowsers() { driver.quit(); }
// @AfterClass   public static void closeBrowsers() { driver.quit(); }

}
