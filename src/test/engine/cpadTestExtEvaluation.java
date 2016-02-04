package test.engine;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import test.common.Locators;
import test.helper.Functions;

public class cpadTestExtEvaluation {
	static WebDriver driver;
	Functions function = new Functions();
	int count = 0;
	
	@SuppressWarnings("static-access")
	@Test(enabled = true, invocationCount = 135)
	public void testOrder() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
	 // COUNTER
	    count++;
	    function.fileWriterPrinter("\n" + " TEST EXECUTION #" + count + ":");
	    boolean result = true;
		for (int i = 0; i < Locators.URL.length; i++) {

		try { 
			driver = new FirefoxDriver();
			result = function.xmlAnlyzer(driver, Locators.URL[i], i+1, false);
			if(!result) {
				function.fileWriterPrinter("    Result: URL FAILED!");
				function.fileWriterPrinter("    Reason: CONTAINS RECORDS WHICH ARE OLDER THEN THEIR PREVIOUS ONCE, WHICH IS OPPOSITE THEN REQUIRED AS PER GIVEN ACCEPTANCE CRITERIA...");
			}
			} catch (Exception e) { /** e.printStackTrace(); */ result = false; }
//		finally { driver.quit(); }
		
		}	
		
		Assert.assertTrue(result, "    Result: FAILED!\n    Reason: CURRENT RECORD IS OLDER THEN THE PREVIOUS ONE (SHOWN BELOW), WHICH IS OPPOSITE THEN REQUIRED AS PER GIVEN ACCEPTANCE CRITERIA...");		
	}

	   @BeforeSuite  public static void logOpen() throws IOException { new Functions().logOpen(); }
	   @AfterSuite   public static void logClose() throws IOException { new Functions().logClose(); }
	   @BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); } 
	   @AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }
//	   @AfterClass   public static void closeBrowsers() { driver.quit(); }
}
