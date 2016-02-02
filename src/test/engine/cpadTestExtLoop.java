package test.engine;

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

public class cpadTestExtLoop {
	
	Functions function = new Functions();
	int combination = 0;
	
	@Test(enabled = true, invocationCount = 15)
	public void testOrder() throws IOException {
		
	 // COUNTER
	    combination++;
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		
//	    System.out.print("\n" + " TEST EXECUTION #" + combination);		
//		for (int i = 0; i < Locators.URL.length; i++) {
		
		WebDriver driver = new FirefoxDriver();
		function.xmlAnlyzer(driver, Locators.URL[combination-1], combination, true);
		
//		driver.quit();
//		}

	}

	   @BeforeSuite  public static void logOpen() throws IOException { new Functions().logOpen(); }
	   @AfterSuite   public static void logClose() throws IOException { new Functions().logClose(); }
	   @BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); } 
	   @AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }
	// @AfterClass   public static void closeBrowsers() { driver.quit(); }

}
