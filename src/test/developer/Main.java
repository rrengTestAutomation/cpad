package test.developer;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import test.common.Locator;
import test.helper.Functions;

//@Test(enabled = false /** , invocationCount = 100 */)
public class Main {
	static WebDriver driver;
	static Functions function = new Functions();
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
        // count++; System.out.print("\n" + count + ") ");
		
	   	// driver = new FirefoxDriver();
	   	// driver = function.getServerName(driver); 
		System.setProperty("webdriver.chrome.driver", Locator.driverFileDir + "chromedriver.exe");
		driver = new ChromeDriver();
		
		function.logOpen();
		function.startTime();
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
  	
	   	try { 		
	   	 // ENTRY

	   		String url = "http://v-cpad-p01.tvo.org:8080/CPAD/videos/?sort_by=created_on&sort_order=desc&size=80&program_asset_id=2790";
	   		String path = Locator.testOutputFileDir;
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
	   		
	   		long[] fingerprintArray = new   long[nodes.getLength()];
			String[]     valueArray = new String[nodes.getLength()];
	   		 
	   		for (int i = 0; i < nodes.getLength(); i++) {
	   		Node node = nodes.item(i);
	   		 
	   		if (node.getNodeType() == Node.ELEMENT_NODE) {
	   		Element element = (Element) node;
	   		
//	   	    fileWriterPrinter("    Record ID: " + getValue("record_id", element));
//	   	    fileWriterPrinter("Episode Title: " + getValue("episode_title", element));    		
//	 		fileWriterPrinter("   Created On: " + getValue("created_on", element));
	   		
	   		valueArray[i] = function.getValue("created_on", element);
	   		
	   		String created = valueArray[i];
	   		String date = created.substring(0, created.indexOf("T"));
	   		String HH = created.substring(created.indexOf("T")+1,created.indexOf("T")+3);
	   		String MM = created.substring(created.indexOf(":")+1,created.indexOf(":")+3);
	   		String SS = created.substring(created.indexOf(":")+4,created.indexOf(":")+6);
	   		String math = created.substring(created.lastIndexOf(":")-3,created.lastIndexOf(":")-2);
	   		String hh = created.substring(created.lastIndexOf(":")-2,created.lastIndexOf(":"));
	   		String mm = created.substring(created.lastIndexOf(":")+1,created.lastIndexOf(":")+3);
	   		
//	        function.fileWriterPrinter("   Created On: " + date + " " + HH + ":" + MM + ":" + SS + math + hh + ":" + mm + "\n" );
	   		
	   		int hours, min, sec;
	   		
	   		if (math.equals("-")) { hours = Integer.valueOf(HH) - Integer.valueOf(hh); }
	   		                 else { hours = Integer.valueOf(HH) + Integer.valueOf(hh); }		
	   		if (math.equals("-")) {   min = Integer.valueOf(MM) - Integer.valueOf(mm); }
	   		                 else {   min = Integer.valueOf(MM) + Integer.valueOf(mm); }
	   		sec = Integer.valueOf(SS);

	   		fingerprintArray[i] = function.convertCalendarIntDateTimeListToMillisecondsAsLong(date, hours, min, sec);  		
//	   	    fileWriterPrinter("   Created On: " + function.convertCalendarMillisecondsAsLongToDateTimeHourMinSec(fingerprintArray[i]));
	   		
	   		}
	   		}
	   		
	   		for (int i = 0; i < nodes.getLength(); i++) {
	   			function.fileWriterPrinter(" Record ID: " + (i + 1));
	   			function.fileWriterPrinter("Created On: " + valueArray[i]);
	   			if (i < (nodes.getLength() - 1)) {
	   				boolean assertion = function.compareLong(fingerprintArray[i], fingerprintArray[i + 1]);

	   			if (assertion) { function.fileWriterPrinter("    Result: OK\n"); }
	   			else { function.fileWriterPrinter("    Result: FAILED\n"); }
  	   		 // EVERY-RECORD ASSERTION:
	   			Assert.assertTrue(assertion,
                                  function.getAssertTrue(new RuntimeException().getStackTrace()[0], driver,
                                  "Out Of Order ''Created On'' Records found!",
                                  assertion));
	   			}
	   		}   		
	   		function.fileWriterPrinter("==========================");
	   		function.fileWriterPrinter();
	   		} 
	   	catch (Exception exception) { /** Functions.getExceptionDescriptive(exception, new Exception().getStackTrace()[0], driver); */ }
	   	finally { function.endTime(); function.logClose(); }
	   	}
	
	}


