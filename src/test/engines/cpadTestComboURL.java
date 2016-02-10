package test.engines;

import org.testng.Assert;
// import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import test.common.Locators;
import test.helper.Functions;

public class cpadTestComboURL{
	static WebDriver driver;
	Functions function = new Functions();
	int count = 0;
	
	@SuppressWarnings("static-access")
//  @Test(enabled = true, invocationCount = 1)
	public void testOrder() throws IOException {
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
			result = function.assertCpadDates(driver, URL[i], i+1, URL.length, false, record, tag);
			
			// SCREENSHOT-CAPABLE ASSERTION:
			if (i == URL.length - 1) {
				Assert.assertTrue(result, function.getAssertTrue(new RuntimeException().getStackTrace()[0], driver,
		                         "TEST EXECUTION # " + count + " - Out Of Order ''Created On'' Records found!",
		                          result));
				}
			
			} catch (Exception e) { /** e.printStackTrace(); */ result = false; } finally { driver.quit(); }
		}
		
		// SCREENSHOT-UNABLED ASSERTION:
//		Assert.assertTrue(result, function.getAssertTrue(new RuntimeException().getStackTrace()[0], driver,
//		                 "TEST EXECUTION #" + count + "  - Out Of Order ''Created On'' Records found!",
//		                  result));
		}

   @BeforeSuite  public static void logOpen() throws IOException { new Functions().logOpen(); }
   @AfterSuite   public static void logClose() throws IOException { new Functions().logClose(); }
   @BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); } 
   @AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }
// @AfterMethod   public static void closeBrowsers() { driver.quit(); }
// @AfterClass   public static void closeBrowsers() { driver.quit(); }

}
