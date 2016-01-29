package test.engine;

   import java.io.File;
import java.io.IOException;

   import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;




   import org.testng.Assert;
// import org.testng.annotations.AfterClass;
   import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;

import test.common.Locators;
import test.helper.Functions;

@SuppressWarnings("static-access")
public class XmlAnlyzer {
    //WebDriver driver = new FirefoxDriver();
	static WebDriver driver;
	Functions function = new Functions();
	
	/**
	 * @throws IOException
	 */
    @Test(enabled = true, invocationCount = 1)
	public void testCpadOutputIsCorrect() throws IOException {

   	function.printXmlPath(new RuntimeException().getStackTrace()[0]);
//     count++; System.out.print("\n" + count + ") "); =   	
   	try { 		
   		// ENTRY
   		//driver = new FirefoxDriver();
   		String url = "http://tomcat-dev:8080/CPAD/videos/?sort_by=created_on&sort_order=desc&size=80&program_asset_id=2790";
   		String path = Locators.testOutputFileDir;
   		String name = "source";
   		String extention = "xml";
   		String fileName = name + "." + extention;
   		String tag = "video";
   		
   		function.sourcePagePrint(driver, url, path, fileName);
   		
   		function.fileWriterPrinter(); 		
   		function.fileWriterPrinter(path + "\n");
   		
   		File stocks = new File(path + fileName);
   		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
   		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
   		Document doc = dBuilder.parse(stocks);
   		doc.getDocumentElement().normalize();

   		function.fileWriterPrinter(path + fileName);
   		function.fileWriterPrinter(doc.getDocumentElement().getNodeName() + ":");
   		NodeList nodes = doc.getElementsByTagName(tag);
   		function.fileWriterPrinter();
   		function.fileWriterPrinter("==========================");
   		
   		long[] fingerprintArray     = new long[nodes.getLength()];
		    String[] valueArray  = new String[nodes.getLength()];
   		 
   		for (int i = 0; i < nodes.getLength(); i++) {
   		Node node = nodes.item(i);
   		 
   		if (node.getNodeType() == Node.ELEMENT_NODE) {
   		Element element = (Element) node;
   		
//   	function.fileWriterPrinter("    Record ID: " + getValue("record_id", element));
//   	function.fileWriterPrinter("Episode Title: " + getValue("episode_title", element));    		
// 		function.fileWriterPrinter("   Created On: " + getValue("created_on", element));
   		
   		valueArray[i] = function.getValue("created_on", element);
   		
   		String created = valueArray[i];
   		String date = created.substring(0, created.indexOf("T"));
   		String HH = created.substring(created.indexOf("T")+1,created.indexOf("T")+3);
   		String MM = created.substring(created.indexOf(":")+1,created.indexOf(":")+3);
   		String SS = created.substring(created.indexOf(":")+4,created.indexOf(":")+6);
   		String math = created.substring(created.lastIndexOf(":")-3,created.lastIndexOf(":")-2);
   		String hh = created.substring(created.lastIndexOf(":")-2,created.lastIndexOf(":"));
   		String mm = created.substring(created.lastIndexOf(":")+1,created.lastIndexOf(":")+3);
   		
//      function.fileWriterPrinter("   Created On: " + date + " " + HH + ":" + MM + ":" + SS + math + hh + ":" + mm + "\n" );
   		
   		int hours, min, sec;
   		
   		if (math.equals("-")) { hours = Integer.valueOf(HH) - Integer.valueOf(hh); }
   		                 else { hours = Integer.valueOf(HH) + Integer.valueOf(hh); }		
   		if (math.equals("-")) {   min = Integer.valueOf(MM) - Integer.valueOf(mm); }
   		                 else {   min = Integer.valueOf(MM) + Integer.valueOf(mm); }
   		sec = Integer.valueOf(SS);

   		fingerprintArray[i] = function.convertCalendarIntDateTimeListToMillisecondsAsLong(date, hours, min, sec);  		
   	 // function.fileWriterPrinter("   Created On: " + function.convertCalendarMillisecondsAsLongToDateTimeHourMinSec(fingerprintArray[i]));
   		
   		}
   		}
   		
   		for (int i = 0; i < nodes.getLength(); i++) {
   			function.fileWriterPrinter(" Record ID: " + (i + 1));
   			function.fileWriterPrinter("Created On: " + valueArray[i]);
   			if (i < (nodes.getLength() - 1)) {
//   		    Assert.assertTrue(fingerprintArray[i] >= fingerprintArray[i + 1],
//                                 UtilitiesTestHelper.getAssertTrue(new RuntimeException().getStackTrace()[0], driver, "Out of order!",
//                                 fingerprintArray[i] >= fingerprintArray[i + 1]));
   			if (fingerprintArray[i] >= fingerprintArray[i + 1]) { function.fileWriterPrinter("    Result: OK\n"); }
   			Assert.assertTrue(fingerprintArray[i] >= fingerprintArray[i + 1], "    Result: FAILED\n");
   			}
   		}
   		
   		function.fileWriterPrinter("==========================");
   		function.fileWriterPrinter();
   		} catch (Exception exception) { exception.printStackTrace(); }
   }
   
@BeforeSuite  public static void logOpen() throws IOException { new Functions().logOpen(); }
   @AfterSuite   public static void logClose() throws IOException { new Functions().logClose(); }
   @BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); } 
   @AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }
// @AfterClass   public static void closeBrowsers() { driver.quit(); }
}
