package test.engine;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.Assert;
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
import org.openqa.selenium.firefox.FirefoxDriver;

import test.common.Locators;
import test.helper.Functions;

@SuppressWarnings("static-access")
public class cpadTester6 {	
	   Functions function = new Functions();
	   int combination = 0;
	
   /**
    * @throws IOException
    */
	@Test(enabled = true, invocationCount = 15)
	public void testOrder() throws IOException {
			
      // COUNTER
	  combination++;
	  function.printXmlPath(new RuntimeException().getStackTrace()[0]);			
	  WebDriver driver = new FirefoxDriver();

	  
      try {
           // ENTRY
           function.fileWriterPrinter("\n" + "URL COMBINATION #" + combination + ":");
           function.fileWriterPrinter(Locators.URL[combination-1]);
           
           String path = Locators.testOutputFileDir;
           String name = "source";
           String extention = "xml";
           String fileName = name + "." + extention;
           String tag = "video";
           
           function.sourcePagePrint(driver, Locators.URL[combination-1], path, fileName);
           
           // function.fileWriterPrinter();       
           // function.fileWriterPrinter(path + "\n");
           
           File stocks = new File(path + fileName);
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           Document doc = dBuilder.parse(stocks);
           doc.getDocumentElement().normalize();

           // function.fileWriterPrinter(path + fileName);
           
           function.fileWriterPrinter(doc.getDocumentElement().getNodeName() + ":");
           NodeList nodes = doc.getElementsByTagName(tag);
           function.fileWriterPrinter();
           function.fileWriterPrinter("==========================");
           
           long[] fingerprintArray     = new long[nodes.getLength()];
           String[] valueArray         = new String[nodes.getLength()];
           
            
           for (int i = 0; i < nodes.getLength(); i++) {
           Node node = nodes.item(i);
            
           if (node.getNodeType() == Node.ELEMENT_NODE) {
           Element element = (Element) node;
           
//         function.fileWriterPrinter("    Record ID: " + getValue("record_id", element));
//         function.fileWriterPrinter("Episode Title: " + getValue("episode_title", element));          
//         function.fileWriterPrinter("   Created On: " + getValue("created_on", element));
           
           valueArray[i] = function.getValue("created_on", element);
           
           String created = valueArray[i];
           String date = created.substring(0, created.indexOf("T"));
           String HH = created.substring(created.indexOf("T")+1,created.indexOf("T")+3);
           String MM = created.substring(created.indexOf(":")+1,created.indexOf(":")+3);
           String SS = created.substring(created.indexOf(":")+4,created.indexOf(":")+6);
           String math = created.substring(created.lastIndexOf(":")-3,created.lastIndexOf(":")-2);
           String hh = created.substring(created.lastIndexOf(":")-2,created.lastIndexOf(":"));
           String mm = created.substring(created.lastIndexOf(":")+1,created.lastIndexOf(":")+3);
           
//      // TEST VALIDATION OUTPUT:
//         String[] dateCheckArray     = new String[nodes.getLength()];
//         dateCheckArray[i] = "Created On: " + date + " " + HH + ":" + MM + ":" + SS + math + hh + ":" + mm;
//         function.fileWriterPrinter(dateCheckArray[i]);
           
           int hours, min, sec;
           
           if (math.equals("-")) { hours = Integer.valueOf(HH) - Integer.valueOf(hh); }
                            else { hours = Integer.valueOf(HH) + Integer.valueOf(hh); }     
           if (math.equals("-")) {   min = Integer.valueOf(MM) - Integer.valueOf(mm); }
                            else {   min = Integer.valueOf(MM) + Integer.valueOf(mm); }
           sec = Integer.valueOf(SS);

           fingerprintArray[i] = function.convertCalendarIntDateTimeListToMillisecondsAsLong(date, hours, min, sec);
           
//      // TEST VALIDATION OUTPUT:
//         function.fileWriterPrinter(dateCheckArray[i]);       
//         function.fileWriterPrinter("   Created On: " + convertCalendarMillisecondsAsLongToDateTimeHourMinSec(fingerprintArray[i]));
//         function.fileWriterPrinter();
           
           }
           }
           
           for (int i = 0; i < nodes.getLength(); i++) {
              function.fileWriterPrinter(" Record ID: " + (i + 1));
              function.fileWriterPrinter("Created On: " + valueArray[i]);
              
//         // TEST VALIDATION OUTPUT:
//            function.fileWriterPrinter(dateCheckArray[i]);      
//            function.fileWriterPrinter("Created On: " + convertCalendarMillisecondsAsLongToDateTimeHourMinSec(fingerprintArray[i]));
//            function.fileWriterPrinter("Created On: " + fingerprintArray[i]);             
                         
              if (i < (nodes.getLength() - 1)) {
              if (fingerprintArray[i] >= fingerprintArray[i + 1]) { function.fileWriterPrinter("    Result: OK\n"); }
              else {
                   function.fileWriterPrinter("    Result: FAILED!");
                   function.fileWriterPrinter("    Reason: CURRENT RECORD IS OLDER THEN THE PREVIOUS ONE (SHOWN BELOW), OPPOSITE THEN AS REQUIRED PER GIVEN ACCEPTANCE CRITERIA...");
                   function.fileWriterPrinter();
                   function.fileWriterPrinter(" Record ID: " + (i + 2));
                   function.fileWriterPrinter("Created On: " + valueArray[i + 1]);
                   
//         // TEST VALIDATION OUTPUT:
//            function.fileWriterPrinter(dateCheckArray[i]);      
//            function.fileWriterPrinter("Created On: " + convertCalendarMillisecondsAsLongToDateTimeHourMinSec(fingerprintArray[i + 1]));
//            function.fileWriterPrinter("Created On: " + fingerprintArray[i + 1]); 
                   
                   function.fileWriterPrinter();
              }
              
// Assert.assertTrue(fingerprintArray[i] >= fingerprintArray[i + 1], "    Result: FAILED\n");
              Assert.assertTrue(fingerprintArray[i] >= fingerprintArray[i + 1],
            		            function.getAssertTrue(new RuntimeException().getStackTrace()[0], driver, 
            		            "    Result: FAILED\n",
            		            fingerprintArray[i] >= fingerprintArray[i + 1]));
          	
              }
           }
           
           function.fileWriterPrinter("==========================");
           function.fileWriterPrinter();
           } catch (Exception exception) { exception.printStackTrace(); } finally { driver.quit(); }

   }
   
@BeforeSuite  public static void logOpen() throws IOException { new Functions().logOpen(); }
   @AfterSuite   public static void logClose() throws IOException { new Functions().logClose(); }
   @BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); } 
   @AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }
// @AfterClass   public static void closeBrowsers() { driver.quit(); }
}
