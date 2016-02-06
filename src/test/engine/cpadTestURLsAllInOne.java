package test.engine;

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

public class cpadTestURLsAllInOne{
	static WebDriver driver;
	Functions function = new Functions();
	int count = 0;
	
	@SuppressWarnings("static-access")
	@Test(enabled = true, invocationCount = 1)
	public void testOrder() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    function.fileWriterPrinter("\n" + " TEST EXECUTION #" + count + ":");
	    boolean result = true;
		for (int i = 0; i < Locators.URL.length; i++) {

		try {
			driver = function.getServerName(driver);
			result = function.xmlAnlyzer(driver, Locators.URL[i], i+1, false);
			
			} catch (Exception e) { /** e.printStackTrace(); */ result = false; } finally { driver.quit(); }
		}
		
		Assert.assertTrue(result, function.getAssertTrue(new RuntimeException().getStackTrace()[0], driver,
		                 "TEST EXECUTION #" + count + "  - Out Of Order ''Created On'' Records found!",
		                  result));
		}

   @BeforeSuite  public static void logOpen() throws IOException { new Functions().logOpen(); }
   @AfterSuite   public static void logClose() throws IOException { new Functions().logClose(); }
   @BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); } 
   @AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }
// @AfterMethod   public static void closeBrowsers() { driver.quit(); }
// @AfterClass   public static void closeBrowsers() { driver.quit(); }

}
