package test.developer;

import java.io.IOException;

import org.testng.Assert;
// import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
// import org.testng.annotations.Test;




import test.common.Locators;
import test.helper.Functions;

public class cpadMultiURL{
	
	Functions function = new Functions();
	int combination = 0;
	int count = 0;
	
	String root = Locators.cpadServerURL + "videos/?sort_by=created_on&sort_order=desc";
	String a = "program_asset_id=2790";
	String b = "group=Adult";
	String c = "size=80";	
	String[] URL = Locators.url(root, Locators.combination(a, b, c));
    String record = "video";
    String tag = "created_on";

//	@Test(enabled = false, invocationCount = 2025)
	public void testOrder() throws IOException {
		
	 // COUNTER
		if(combination == URL.length){ combination = 0; }
	    combination++;	    
	    count++;
	    
	 try{   
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);		

		
		boolean result = function.assertCpadTagsDateDesc(new RuntimeException().getStackTrace()[0], URL[combination-1], combination, URL.length, false, record, tag);
		
		Assert.assertTrue(result, function.getAssertTrue(new RuntimeException().getStackTrace()[0],
				         "TEST # " + count + ", URL # " + combination + 
				         " OF " + URL.length + " - Out Of Order ''Created On'' Records found!",
				          result));
		
	}
	catch (Exception exception) { /** Functions.getExceptionDescriptive(exception, new Exception().getStackTrace()[0], driver); */ }	
	}

	@BeforeSuite  public static void logOpen() throws IOException { new Functions().logOpen(); }
	@AfterSuite   public static void logClose() throws IOException { new Functions().logClose(); }
	@BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); } 
	@AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }
}
