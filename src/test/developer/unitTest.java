package test.developer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import test.helper.Functions;

public class unitTest {
	static WebDriver driver;
	
	@Test
	public void testAnnualHeader() throws IOException, InterruptedException, IllegalArgumentException, MalformedURLException{

		try{
		Functions function = new Functions(); function.printXmlPath(new RuntimeException().getStackTrace()[0]);
		driver = function.getServerName(driver);
		
		function.getUrlWaitUntil(driver, 15, "https://google.ca");
		List<WebElement> list = driver.findElements(By.id("google"));

		Assert.assertTrue(list.size() > 0, Functions.getAssertTrue(new RuntimeException().getStackTrace()[0], driver, "Text not found!", list.size() > 0));
		unitTest.closeBrowsers();
		}
		catch (Exception exception) {
			Functions.getExceptionDescriptive(exception, new Exception().getStackTrace()[0], driver);
	    }
	    finally{
	    	unitTest.closeBrowsers();
	    }
	}

//	@BeforeSuite  public static void logOpen() throws IOException { new Functions().logOpen(); }
//	@AfterSuite   public static void logClose() throws IOException { new Functions().logClose(); }
	@BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); } 
	@AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }
    @AfterClass   public static void closeBrowsers() { driver.quit(); }
}
