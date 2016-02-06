package test.engine;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
// import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import test.common.Locators;
import test.helper.Functions;

public class cpadTestURLS{
	
	static WebDriver driver;	
	Functions function = new Functions();
	int combination = 0;
	
	@SuppressWarnings("static-access")
	@Test(enabled = true, invocationCount = 15)
	public void testOrder() throws IOException {
		
	 // COUNTER
	    combination++;
	 try{   
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);		
	 // WebDriver driver = new FirefoxDriver();
		driver = function.getServerName(driver);
		boolean result = function.xmlAnlyzer(driver, Locators.URL[combination-1], combination, false);
		
		Assert.assertTrue(result, function.getAssertTrue(new RuntimeException().getStackTrace()[0], driver,
				         "URL #" + combination + " - Out Of Order ''Created On'' Records found!",
				          result));
		
	}
	catch (Exception exception) { /** Functions.getExceptionDescriptive(exception, new Exception().getStackTrace()[0], driver); */ }
    finally{ cpadTestURLS.closeBrowsers(); }	
	}

	@BeforeSuite  public static void logOpen() throws IOException { new Functions().logOpen(); }
	@AfterSuite   public static void logClose() throws IOException { new Functions().logClose(); }
	@BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); } 
	@AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }
	@AfterMethod   public static void closeBrowsers() { driver.quit(); }
//  @AfterClass   public static void closeBrowsers() { driver.quit(); }

}
