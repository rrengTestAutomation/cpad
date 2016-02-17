package test.developer;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
// import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
// import org.testng.annotations.Test;


import test.common.Locators;
import test.helper.Functions;

public class cpadTestMultiURL{
	
	static WebDriver driver;	
	Functions function = new Functions();
	int combination = 0;
	int count = 0;
	
	String root = "http://tomcat-dev:8080/CPAD/videos/?sort_by=created_on&sort_order=desc";
	String a = "program_asset_id=2790";
	String b = "group=Adult";
	String c = "size=80";	
	String[] URL = Locators.url(root, Locators.combination(a, b, c));
    String record = "video";
    String tag = "created_on";
	
	@SuppressWarnings("static-access")
//	@Test(enabled = false, invocationCount = 2025)
	public void testOrder() throws IOException {
		
	 // COUNTER
		if(combination == URL.length){ combination = 0; }
	    combination++;	    
	    count++;
	    
	 try{   
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);		
	 // WebDriver driver = new FirefoxDriver();
		driver = function.getServerName(driver);
		
		boolean result = function.assertCpadTagsDateDesc(driver, new RuntimeException().getStackTrace()[0], URL[combination-1], combination, URL.length, false, record, tag);
		
		Assert.assertTrue(result, function.getAssertTrue(new RuntimeException().getStackTrace()[0], driver,
				         "TEST # " + count + ", URL # " + combination + 
				         " OF " + URL.length + " - Out Of Order ''Created On'' Records found!",
				          result));
		
	}
	catch (Exception exception) { /** Functions.getExceptionDescriptive(exception, new Exception().getStackTrace()[0], driver); */ }
    finally{ cpadTestMultiURL.closeBrowsers(); }	
	}

	@BeforeSuite  public static void logOpen() throws IOException { new Functions().logOpen(); }
	@AfterSuite   public static void logClose() throws IOException { new Functions().logClose(); }
	@BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); } 
	@AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }
	@AfterMethod  public static void closeBrowsers() { driver.quit(); }
//  @AfterClass   public static void closeBrowsers() { driver.quit(); }

}
