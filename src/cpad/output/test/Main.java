package cpad.output.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
//import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//@Test(enabled = true /** , invocationCount = 100 */)
public class Main {
	
	public static void main(String[] args) throws IOException {
        // count++; System.out.print("\n" + count + ") "); =   	
	    logOpen();
	    startTime();
	    printXmlPath(new RuntimeException().getStackTrace()[0]);
  	
	   	try { 		
	   		// ENTRY
	   		WebDriver driver = new FirefoxDriver();
	   		String url = "http://tomcat-dev:8080/CPAD/videos/?sort_by=created_on&sort_order=desc&size=80&program_asset_id=2790";
	   		String path = testOutputFileDir;
	   		String name = "source";
	   		String extention = "xml";
	   		String fileName = name + "." + extention;
	   		String tag = "video";
	   		
	   		sourcePagePrint(driver, url, path, fileName);
	   		
	   		fileWriterPrinter(); 		
	   		fileWriterPrinter(path + "\n");
	   		
	   		File stocks = new File(path + fileName);
	   		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	   		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	   		Document doc = dBuilder.parse(stocks);
	   		doc.getDocumentElement().normalize();

	   		fileWriterPrinter(path + fileName);
	   		fileWriterPrinter(doc.getDocumentElement().getNodeName() + ":");
	   		NodeList nodes = doc.getElementsByTagName(tag);
	   		fileWriterPrinter();
	   		fileWriterPrinter("==========================");
	   		
	   		long[] fingerprintArray     = new long[nodes.getLength()];
			    String[] valueArray  = new String[nodes.getLength()];
	   		 
	   		for (int i = 0; i < nodes.getLength(); i++) {
	   		Node node = nodes.item(i);
	   		 
	   		if (node.getNodeType() == Node.ELEMENT_NODE) {
	   		Element element = (Element) node;
	   		
//	   	    fileWriterPrinter("    Record ID: " + getValue("record_id", element));
//	   	    fileWriterPrinter("Episode Title: " + getValue("episode_title", element));    		
//	 		fileWriterPrinter("   Created On: " + getValue("created_on", element));
	   		
	   		valueArray[i] = getValue("created_on", element);
	   		
	   		String created = valueArray[i];
	   		String date = created.substring(0, created.indexOf("T"));
	   		String HH = created.substring(created.indexOf("T")+1,created.indexOf("T")+3);
	   		String MM = created.substring(created.indexOf(":")+1,created.indexOf(":")+3);
	   		String SS = created.substring(created.indexOf(":")+4,created.indexOf(":")+6);
	   		String math = created.substring(created.lastIndexOf(":")-3,created.lastIndexOf(":")-2);
	   		String hh = created.substring(created.lastIndexOf(":")-2,created.lastIndexOf(":"));
	   		String mm = created.substring(created.lastIndexOf(":")+1,created.lastIndexOf(":")+3);
	   		
//	      fileWriterPrinter("   Created On: " + date + " " + HH + ":" + MM + ":" + SS + math + hh + ":" + mm + "\n" );
	   		
	   		int hours, min, sec;
	   		
	   		if (math.equals("-")) { hours = Integer.valueOf(HH) - Integer.valueOf(hh); }
	   		                 else { hours = Integer.valueOf(HH) + Integer.valueOf(hh); }		
	   		if (math.equals("-")) {   min = Integer.valueOf(MM) - Integer.valueOf(mm); }
	   		                 else {   min = Integer.valueOf(MM) + Integer.valueOf(mm); }
	   		sec = Integer.valueOf(SS);

	   		fingerprintArray[i] = convertCalendarIntDateTimeListToMillisecondsAsLong(date, hours, min, sec);  		
//	   	    fileWriterPrinter("   Created On: " + convertCalendarMillisecondsAsLongToDateTimeHourMinSec(fingerprintArray[i]));
	   		
	   		}
	   		}
	   		
	   		for (int i = 0; i < nodes.getLength(); i++) {
	   			fileWriterPrinter(" Record ID: " + (i + 1));
	   			fileWriterPrinter("Created On: " + valueArray[i]);
	   			if (i < (nodes.getLength() - 1)) {
//	   		    Assert.assertTrue(fingerprintArray[i] >= fingerprintArray[i + 1],
//	                                 UtilitiesTestHelper.getAssertTrue(new RuntimeException().getStackTrace()[0], driver, "Out of order!",
//	                                 fingerprintArray[i] >= fingerprintArray[i + 1]));
	   			if (fingerprintArray[i] >= fingerprintArray[i + 1]) { fileWriterPrinter("    Result: OK\n"); }
	   			Assert.assertTrue(fingerprintArray[i] >= fingerprintArray[i + 1], "    Result: FAILED\n");
	   			}
	   		}
	   		
	   		fileWriterPrinter("==========================");
	   		fileWriterPrinter();
	   		} catch (Exception exception) { exception.printStackTrace(); }
	   	finally {
		         endTime();
		         logClose();
	   	         }
	   }
	
/** ########### Common Locators ############### */
	
	public static String outputFileDir     = System.getProperty("user.dir") + File.separator + "output" + File.separator;
	public static String testOutputFileDir = System.getProperty("user.dir") + File.separator + "test-output" + File.separator;
	
/** ########### Common Functions ############### */	
	 
    /** Print XML path 
     * @throws IOException
     */
	public static void printXmlPath(StackTraceElement l) throws IOException {
	       String packageNameOnly = l.getClassName().substring(0, l.getClassName().lastIndexOf("."));
	       String classNameOnly = l.getClassName().substring(1 + l.getClassName().lastIndexOf("."), l.getClassName().length());
	       String xml = "<class name=\"" + packageNameOnly + "." + classNameOnly + "\"><methods><include name=\"" + l.getMethodName() + "\"/></methods></class>";
		   fileWriterPrinter("   XML Path: " + xml);
		// Renew XML record:
		   fileCleaner("xml.path");
		   fileWriter( "xml.path", xml);
		// Renew Stack Trace Element record:
		   fileCleaner("stack.trace");
		   fileWriter( "stack.trace", l);
		// Append a New Log record:
		   if (fileExist("run.log")) { fileWriter("run.log", "   XML Path: " + xml); }      
	}
	
	/**
	 * @throws IOException
	 */
	public static void sourcePagePrint(WebDriver driver, String url, String path, String fileName) throws IOException {
		try {			
			fileCleaner(path, fileName);
			
			while(! driver.getCurrentUrl().equals(url)) {			
			driver.get(url);
			Thread.sleep(5000);
			}
			
            fileWriterPrinter();
			getUrlSourcePagePrint(driver.getCurrentUrl(), path, fileName);			
			fileWriterPrinter();
			
			driver.quit();	
		} catch (Exception exception) { getExceptionDescriptive(exception, new Exception().getStackTrace()[0], driver); }
		finally { driver.quit(); }
	}
	
	 private static String getValue(String tag, Element element) {
	    NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
	    Node node = (Node) nodes.item(0);
	    return node.getNodeValue();
   }

		/**
		 * @throws IOException
		 * @throws NumberFormatException
		 */
		public static void fileCleaner(String path, String fileName) throws NumberFormatException, IOException {
			if (fileExist(path, fileName, false))
			 { (new File(path + fileName)).delete(); }
		}
		
		/* @throws IOException
		 * @throws NumberFormatException */ 
		public static Boolean fileExist(String fileName) throws NumberFormatException, IOException {
			File f = new File(testOutputFileDir + fileName);
			if (! (f.exists() && f.isFile()) ) { fileWriterPrinter(f + " is missing..."); }
			return (f.exists() && f.isFile());
		}
		
		/* @throws IOException
		 * @throws NumberFormatException */ 
		public static Boolean fileExist(String fileName, Boolean silentMode) throws NumberFormatException, IOException {
			File f = new File(testOutputFileDir + fileName);
			if (! (f.exists() && f.isFile()) ) { if (silentMode) { fileWriterPrinter(f + " is missing..."); } }
			return (f.exists() && f.isFile());
		}
		
		/**
		 * @throws IOException
		 * @throws NumberFormatException
		 */ 

		public static Boolean fileExist(String path, String fileName, Boolean silentMode) throws NumberFormatException, IOException {
			File f = new File(path + fileName);
			if (! (f.exists() && f.isFile()) ) { if (silentMode) { fileWriterPrinter(f + " is missing..."); } }
			return (f.exists() && f.isFile());
		}
		
		/** Convert Date to long Milliseconds */
		public static long convertCalendarDateToMillisecondsAsLong(String stringDate) throws ParseException {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = formatter.parse(stringDate);
			long mills = date.getTime();
			return mills;
		}
		
		/** Convert Date and Time list year, month, day, hours, minutes, seconds to long Milliseconds */
		public static long convertCalendarIntDateTimeListToMillisecondsAsLong(
				String date, int hours, int min, int sec)
				throws ParseException {

			return convertCalendarDateToMillisecondsAsLong(date) + ((hours * 3600) + (min * 60) + sec) * 1000;
		}
		
		/** Writes a String line into File */
	    public static void fileWriter(String fileName, Object printLine) throws NumberFormatException, IOException {
	     // Create File:
			File f = new File(testOutputFileDir + fileName);				                                                                      
		 // Write or add a String line into File:	
		    FileWriter fw = new FileWriter(f,true);
		    PrintWriter pw = new PrintWriter(fw);
		    pw.println(printLine);
		    pw.close();
		}
	    
		/** Writes an empty line into "print.log" File, as well as through System Out Print Line */
	    public static void fileWriterPrinter() throws NumberFormatException, IOException {
	     // Create File:
			File f = new File(testOutputFileDir + "print.log");				                                                                      
		 // Write or add a String line into File:	
		    FileWriter fw = new FileWriter(f,true);
		    PrintWriter pw = new PrintWriter(fw);
		    pw.println();
		    pw.close();
		 // System Out Print Line:
		    // if (printLine instanceof String) {}
		    // if (printLine instanceof Integer) {}
		    // if (printLine instanceof Long) {}
		    // if (printLine instanceof Boolean) {}
		    // if (printLine instanceof Double) {}
		    System.out.print("\n");		    
		}
	    
		/** Writes an Object line into "print.log" File, as well as through System Out Print Line */
	    public static void fileWriterPrinter(Object printLine) throws NumberFormatException, IOException {
	     // Create File:
			File f = new File(testOutputFileDir + "print.log");				                                                                      
		 // Write or add a String line into File:	
		    FileWriter fw = new FileWriter(f,true);
		    PrintWriter pw = new PrintWriter(fw);
		    pw.println(printLine);
		    pw.close();
		 // System Out Print Line:
		    // if (printLine instanceof String) {}
		    // if (printLine instanceof Integer) {}
		    // if (printLine instanceof Long) {}
		    // if (printLine instanceof Boolean) {}
		    // if (printLine instanceof Double) {}
		    System.out.print(printLine + "\n");		    
		}
	    
		/** Writes an Object line into File, as well as through System Out Print Line */
	    public static void fileWriterPrinter(String fileName, Object printLine) throws NumberFormatException, IOException {
	     // Create File:
			File f = new File(testOutputFileDir + fileName);				                                                                      
		 // Write or add a String line into File:	
		    FileWriter fw = new FileWriter(f,true);
		    PrintWriter pw = new PrintWriter(fw);
		    pw.println(printLine);
		    pw.close();
		 // System Out Print Line:
		    fileWriterPrinter(printLine);
		} 
	    
		/** Writes an Object line into File, as well as through System Out Print Line */
	    public static void fileWriterPrinter(String path, String fileName, Object printLine) throws NumberFormatException, IOException {
	     // Create File:
			File f = new File(path + fileName);		                                                                      
		 // Write or add a String line into File:	
		    FileWriter fw = new FileWriter(f,true);
		    PrintWriter pw = new PrintWriter(fw);
		    pw.println(printLine);
		    pw.close();
		 // System Out Print Line:
		    fileWriterPrinter(printLine);
		} 
	    	
		/**
		 */
		@SuppressWarnings("static-access")
		public static void getUrlSourcePagePrint(String url, String path, String fileName) throws IOException {
		        URL URL = new URL(url);				        			        
		        HttpURLConnection uc = (HttpURLConnection) URL.openConnection(); // Cast shouldn't fail
		        uc.setFollowRedirects(true);
		        
		     // allow both GZip and Deflate (ZLib) encodings
		        uc.setRequestProperty("Accept-Encoding", "gzip, deflate");
		        String encoding = uc.getContentEncoding();
		        
		     // the encoding type
		        BufferedReader in = null;
		        if (encoding != null && encoding.equalsIgnoreCase("gzip")) {
		            in = new BufferedReader(new InputStreamReader(new GZIPInputStream(uc.getInputStream())));
		        } else if (encoding != null && encoding.equalsIgnoreCase("deflate")) {
		            in = new BufferedReader(new InputStreamReader(new InflaterInputStream(uc.getInputStream(), new Inflater(true))));
		        } else { in = new BufferedReader(new InputStreamReader(uc.getInputStream())); }
		        
		        String inputLine;
		        StringBuilder sb = new StringBuilder();
		        while ((inputLine = in.readLine()) != null)
		        sb.append(inputLine);
		        in.close();
		        
	            fileCleaner(fileName);
	            fileWriterPrinter(path, fileName, sb.toString());
		}
		 
		  /**Gets the first (main) line of any thrown Exception Message
		   * Regardless it is single or multi-line Prompt
		   * @param e
		   */
		   public static void getExceptionDescriptive(Exception e, StackTraceElement l, WebDriver driver) throws IOException {
			 String message1 = null;					
			 try{
				 message1 = e.getCause().toString();
			 } 
			 catch (NullPointerException e1) {
			 message1 = ".getCause() by NullPointerException:";
			 }
			 finally {					
			 String message2 = e.getMessage();
			 String [] multiline1 = message1.replaceAll("\\r", "").split("\\n");
			 String [] multiline2 = message2.replaceAll("\\r", "").split("\\n");
			 String firstLine = multiline1[0];
			 String secondLine = multiline2[0];
			 String errorCause = firstLine.substring(0,firstLine.indexOf(":"));
			 String exceptionThrown = errorCause.substring(1 + errorCause.lastIndexOf("."), errorCause.length());
			 String packageNameOnly = l.getClassName().substring(0, l.getClassName().lastIndexOf("."));
			 String classNameOnly = l.getClassName().substring(1 + l.getClassName().lastIndexOf("."), l.getClassName().length());
			 String location = packageNameOnly + File.separator + classNameOnly + File.separator + l.getMethodName() + ", line # " + l.getLineNumber();
		     String xml = "<class name=\"" + packageNameOnly + "." + classNameOnly + "\"><methods><include name=\"" + l.getMethodName() + "\"/></methods></class>";
			 String description = exceptionThrown;
		     String detected = getCurrentDateTimeFull();
		     String runtime  = testRunTime("start.time", System.currentTimeMillis());
		     String subtotal = testRunTime("ini.time",   System.currentTimeMillis());
			 fileWriterPrinter("\nError Cause: ---> " + errorCause + "\nDescription: ---> " + secondLine + "\n   Location: ---> " + location);
			 getScreenShot(l, description, driver);
		  // Creating New or Updating existing Failed Counter record:  
			 counter("failed.num");
		  // Append a New Log record:
		     if (fileExist("run.log")) {
			     fileWriter("run.log", "Error Cause: ---> " + errorCause);
			     fileWriter("run.log", "Description: ---> " + secondLine);
			     fileWriter("run.log", "   Location: ---> " + location);
	 		  // fileWriter("run.log", "   Detected: ---> " + detected);
	 		  // fileWriter("run.log", "    Runtime: ---> " + runtime);
	 		  // fileWriter("run.log", "   Subtotal: ---> " + subtotal);	    	        
		     }
		  // Append an Error record:
			   fileWriter("failed.log", "    Failure: #" + fileScanner("failed.num"));
			   fileWriter("failed.log", "       Test: #" + fileScanner("test.num"));
			   fileWriter("failed.log", "      Start: "  + convertCalendarMillisecondsAsStringToDateTimeHourMinSec(fileScanner("start.time")));
	         fileWriter("failed.log", "   XML Path: "  + xml);
			   fileWriter("failed.log", "Error Cause: ---> " + errorCause);
			   fileWriter("failed.log", "Description: ---> " + secondLine);
			   fileWriter("failed.log", "   Location: ---> " + location);
			   fileWriter("failed.log", "   Detected: " + detected);
		   	   fileWriter("failed.log", "    Runtime: " + runtime);
		   	   fileWriter("failed.log", "   Subtotal: " + subtotal);
		   	   fileWriter("failed.log", "");
		  // Append Descriptive record:
			 Assert.assertFalse(true, "\n  Error Cause: ---> " + errorCause
					                + "\n  Description: ---> " + secondLine
					                + "\n     Location: ---> " + location
									+ "\n     Detected: ---> " + detected
									+ "\n      Runtime: ---> " + runtime
									+ "\n     Subtotal: ---> " + subtotal
					                + "\n"
							        + xml
							        + "\n"
				                	+ "\nStack Traces:");
			 }		
		   }
		
		   public static String getAssertTrue(StackTraceElement l, WebDriver driver, String description, Boolean b) throws IOException {
		       String packageNameOnly = l.getClassName().substring(0, l.getClassName().lastIndexOf("."));
		       String classNameOnly = l.getClassName().substring(1 + l.getClassName().lastIndexOf("."), l.getClassName().length());
		       String location = packageNameOnly + File.separator + classNameOnly + File.separator + l.getMethodName() + ", line # " + l.getLineNumber();
		       String xml = "<class name=\"" + packageNameOnly + "." + classNameOnly + "\"><methods><include name=\"" + l.getMethodName() + "\"/></methods></class>";
		       String detected = getCurrentDateTimeFull();
			   String runtime  = testRunTime("start.time", System.currentTimeMillis());
			   String subtotal = testRunTime("ini.time",   System.currentTimeMillis());
		   if (b == false) {
		      fileWriterPrinter("\nError Cause: ---> " + description + "\n   Location: ---> " + location + "\n   Expected: ---> " + "true" + "\n     Actual: ---> " + b + "\n");
		  	  getScreenShot(l, description, driver);
			  // Creating New or Updating existing Failed Counter record:  
				 counter("failed.num");
			  // Append a New Log record:
			     if (fileExist("run.log")) {
				     fileWriter("run.log", "Error Cause: ---> " + description);
				     fileWriter("run.log", "   Location: ---> " + location);
				     fileWriter("run.log", "   Expected: ---> " + "true");
				     fileWriter("run.log", "     Actual: ---> " + b);
			      // fileWriter("run.log", "   Detected: ---> " + detected);
		   		  // fileWriter("run.log", "    Runtime: ---> " + runtime);
		   		  // fileWriter("run.log", "   Subtotal: ---> " + subtotal);
				 }
			  // Append an Error record:
			       fileWriter("failed.log", "    Failure: #" + fileScanner("failed.num"));
			       fileWriter("failed.log", "       Test: #" + fileScanner("test.num"));
			       fileWriter("failed.log", "      Start: "  + convertCalendarMillisecondsAsStringToDateTimeHourMinSec(fileScanner("start.time")));
	            fileWriter("failed.log", "   XML Path: "  + xml);
				   fileWriter("failed.log", "Error Cause: ---> " + description);
				   fileWriter("failed.log", "   Location: ---> " + location);
				   fileWriter("failed.log", "   Expected: ---> " + "true");
				   fileWriter("failed.log", "     Actual: ---> " + b);
				   fileWriter("failed.log", "   Detected: " + detected);
		   		   fileWriter("failed.log", "    Runtime: " + runtime);
		   		   fileWriter("failed.log", "   Subtotal: " + subtotal);
		   		   fileWriter("failed.log", "");
		      } else {
			  fileWriterPrinter("\nExpected: " + true + "\n  Actual: " + b + "\n  Result: OK\n");
			  }
		   // Descriptive record output:
		      return "\nError Cause: ---> " + description
				   + "\n   Location: ---> " + location
				   + "\n   Expected: ---> " + "true"
				   + "\n     Actual: ---> " + b
				   + "\n   Detected: ---> " + detected
				   + "\n    Runtime: ---> " + runtime
				   + "\n   Subtotal: ---> " + subtotal
				   + "\n"
			       + xml
			       + "\n"
				+ "\nStack Traces:";
		      }

		   public static String getAssertEquals(StackTraceElement l, WebDriver driver, String description, Object actual, Object expected) throws IOException {
			   String packageNameOnly = l.getClassName().substring(0, l.getClassName().lastIndexOf("."));
			   String classNameOnly = l.getClassName().substring(1 + l.getClassName().lastIndexOf("."), l.getClassName().length());
			   String location = packageNameOnly + File.separator + classNameOnly + File.separator + l.getMethodName() + ", line # " + l.getLineNumber();
			   String xml = "<class name=\"" + packageNameOnly + "." + classNameOnly + "\"><methods><include name=\"" + l.getMethodName() + "\"/></methods></class>";
		       String detected = getCurrentDateTimeFull();
			   String runtime  = testRunTime("start.time", System.currentTimeMillis());
			   String subtotal = testRunTime("ini.time",   System.currentTimeMillis());
		   if (actual.equals(expected) == false) {
		      fileWriterPrinter("\nError Cause: ---> " + description + "\n   Location: ---> " + location + "\n   Expected: ---> " + expected + "\n     Actual: ---> " + actual + "\n");
		  	  getScreenShot(l, description, driver);
			  // Creating New or Updating existing Failed Counter record:  
				 counter("failed.num");
			  // Append a New Log record:
			     if (fileExist("run.log")) {
				     fileWriter("run.log", "Error Cause: ---> " + description);
				     fileWriter("run.log", "   Location: ---> " + location);
				     fileWriter("run.log", "   Expected: ---> " + expected);
				     fileWriter("run.log", "     Actual: ---> " + actual);
			      // fileWriter("run.log", "   Detected: ---> " + detected);
			      // fileWriter("run.log", "    Runtime: ---> " + runtime);
			      // fileWriter("run.log", "   Subtotal: ---> " + subtotal);
				 }
			  // Append an Error record:
			       fileWriter("failed.log", "    Failure: #" + fileScanner("failed.num"));
			       fileWriter("failed.log", "       Test: #" + fileScanner("test.num"));
			       fileWriter("failed.log", "      Start: "  + convertCalendarMillisecondsAsStringToDateTimeHourMinSec(fileScanner("start.time")));
	            fileWriter("failed.log", "   XML Path: "  + xml);
				   fileWriter("failed.log", "Error Cause: ---> " + description);
				   fileWriter("failed.log", "   Location: ---> " + location);
				   fileWriter("failed.log", "   Expected: ---> " + expected);
				   fileWriter("failed.log", "     Actual: ---> " + actual);
				   fileWriter("failed.log", "   Detected: " + detected);
		   		   fileWriter("failed.log", "    Runtime: " + runtime);
		   		   fileWriter("failed.log", "   Subtotal: " + subtotal);
		   		   fileWriter("failed.log", "");	    	        
		      } else {
		      fileWriterPrinter("\nExpected: " + expected + "\n  Actual: " + actual + "\n  Result: OK\n");
		      }
		   // Descriptive record output:
		      return "\nError Cause: ---> " + description
		    	   + "\n   Location: ---> " + location
				   + "\n   Expected: ---> " + expected
				   + "\n     Actual: ---> " + actual
				   + "\n   Detected: ---> " + detected
				   + "\n    Runtime: ---> " + runtime
				   + "\n   Subtotal: ---> " + subtotal
				   + "\n"
				   + xml
				   + "\n"
		    	   + "\nStack Traces:";
		      }
		   
		   public static String getAssertFalse(StackTraceElement l, WebDriver driver, String description, Boolean b) throws IOException {
		       String packageNameOnly = l.getClassName().substring(0, l.getClassName().lastIndexOf("."));
		       String classNameOnly = l.getClassName().substring(1 + l.getClassName().lastIndexOf("."), l.getClassName().length());
		       String location = packageNameOnly + File.separator + classNameOnly + File.separator + l.getMethodName() + ", line # " + l.getLineNumber();
		       String xml = "<class name=\"" + packageNameOnly + "." + classNameOnly + "\"><methods><include name=\"" + l.getMethodName() + "\"/></methods></class>";
		       String detected = getCurrentDateTimeFull();
			   String runtime  = testRunTime("start.time", System.currentTimeMillis());
			   String subtotal = testRunTime("ini.time",   System.currentTimeMillis());
		   if (b == true) {			  
		      fileWriterPrinter("\nError Cause: ---> " + description + "\n   Location: ---> " + location + "\n   Expected: ---> " + "false" + "\n     Actual: ---> " + b + "\n");
		  	  getScreenShot(l, description, driver);
			  // Creating New or Updating existing Failed Counter record:  
				 counter("failed.num");
			  // Append a New Log record:
			     if (fileExist("run.log")) {
				     fileWriter("run.log", "Error Cause: ---> " + description);
				     fileWriter("run.log", "   Location: ---> " + location);
				     fileWriter("run.log", "   Expected: ---> " + "false");
				     fileWriter("run.log", "     Actual: ---> " + b);
		          // fileWriter("run.log", "   Detected: ---> " + detected);
		          // fileWriter("run.log", "    Runtime: ---> " + runtime);
		          // fileWriter("run.log", "   Subtotal: ---> " + subtotal);
		         }
			  // Append an Error record:
			       fileWriter("failed.log", "    Failure: #" + fileScanner("failed.num"));
			       fileWriter("failed.log", "       Test: #" + fileScanner("test.num"));
			       fileWriter("failed.log", "      Start: "  + convertCalendarMillisecondsAsStringToDateTimeHourMinSec(fileScanner("start.time")));
	            fileWriter("failed.log", "   XML Path: "  + xml);
				   fileWriter("failed.log", "Error Cause: ---> " + description);
				   fileWriter("failed.log", "   Location: ---> " + location);
				   fileWriter("failed.log", "   Expected: ---> " + "false");
				   fileWriter("failed.log", "     Actual: ---> " + b);
				   fileWriter("failed.log", "   Detected: " + detected);
		   		   fileWriter("failed.log", "    Runtime: " + runtime);
		   		   fileWriter("failed.log", "   Subtotal: " + subtotal);
		   		   fileWriter("failed.log", "");	    	        
		      } else {
			  fileWriterPrinter("\nExpected: " + false + "\n  Actual: " + b + "\n  Result: OK\n");
			  }
		   // Descriptive record output:
		      return "\nError Cause: ---> " + description
			       + "\n   Location: ---> " + location
				   + "\n   Expected: ---> " + "false"
				   + "\n     Actual: ---> " + b
				   + "\n   Detected: ---> " + detected
				   + "\n    Runtime: ---> " + runtime
				   + "\n   Subtotal: ---> " + subtotal
				   + "\n"
				   + xml
				   + "\n"
		    	   + "\nStack Traces:";
		      }
		   
			  /**
			   * Takes screenshot when step fails. Works only with Selenium2Driver.
			   * Screenshot is saved at:  [workspace]/[project]/
			   * Screenshot file name is: [class].[method],[description] (date, time).png
			   */
			   public static void getScreenShot(String description, WebDriver driver) throws IOException {
			   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH.mm.ss");
			   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			   String outputFile = outputFileDir + description + " (" + dateFormat.format(new Date()) + ").png";
			   fileWriterPrinter(outputFile);
			   FileUtils.copyFile(scrFile, new File(outputFile));
			  }
			   
			  /** 
			   * Takes screenshot when step fails. Works only with Selenium2Driver.
			   * Screenshot is saved at:  [workspace]/[project]/
			   * Screenshot file name is: [class].[method],[description] (date, time).png
			   */
			   public static void getScreenShot(String description, WebDriver driver, long milliseconds) throws IOException {
			   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH.mm.ss");
			   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			   String outputFile = outputFileDir + description + " (" + dateFormat.format(milliseconds) + ").png";
			   fileWriterPrinter(outputFile);
			   FileUtils.copyFile(scrFile, new File(outputFile));
			  } 
			   
			  /**
			   * Takes screenshot when step fails. Works only with Selenium2Driver.
			   * Screenshot is saved at:  [workspace]/[project]/[package]/[class]/
			   * Screenshot file name is: [class].[method],[description],[line #](date, time).png
			   */
			   public static void getScreenShot(StackTraceElement l, String description, WebDriver driver) throws IOException {
			   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH.mm.ss");
			   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			   String packageNameOnly = l.getClassName().substring(0, l.getClassName().lastIndexOf("."));
			   String classNameOnly = l.getClassName().substring(1 + l.getClassName().lastIndexOf("."), l.getClassName().length());
			   String screenshotName = classNameOnly + "." + l.getMethodName() + ", " + description +", line # " + l.getLineNumber();
			   String outputFile = outputFileDir + packageNameOnly + File.separator + classNameOnly + File.separator + screenshotName + " (" + dateFormat.format(new Date()) + ").png";
			   fileWriterPrinter(outputFile);
			   FileUtils.copyFile(scrFile, new File(outputFile));
			   }
			   
			   /**
				* Takes screenshot when step fails. Works only with Selenium2Driver.
			    * Screenshot is saved at:  [workspace]/[project]/[package]/[class]/
				* Screenshot file name is: [class].[method],[description],[line #](date, time).png
				*/
				public void getScreenShot(StackTraceElement l, Exception e, WebDriver driver) throws IOException {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH.mm.ss");
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String message1 = null;					
				try{
					 message1 = e.getCause().toString();
				} 
				catch (NullPointerException e1) {
				message1 = ".getCause() by NullPointerException:";
				}
				finally {
				String [] multiline1 = message1.replaceAll("\\r", "").split("\\n");
				String firstLine = multiline1[0];
				String errorCause = firstLine.substring(0,firstLine.indexOf(":"));
				String exceptionThrown = errorCause.substring(1 + errorCause.lastIndexOf("."), errorCause.length());
				 
				String packageNameOnly = l.getClassName().substring(0, l.getClassName().lastIndexOf("."));
				String classNameOnly = l.getClassName().substring(1 + l.getClassName().lastIndexOf("."), l.getClassName().length());
				String description = exceptionThrown;
				String screenshotName = classNameOnly + "." + l.getMethodName() + ", " + description +", line # " + l.getLineNumber();

				String outputFile = outputFileDir + packageNameOnly + File.separator + classNameOnly + File.separator + screenshotName + " (" + dateFormat.format(new Date()) + ").png";
				fileWriterPrinter(outputFile);
				FileUtils.copyFile(scrFile, new File(outputFile));
				}
				}
				
				   /**
					* Takes screenshot when step fails. Works only with Selenium2Driver.
				    * Screenshot is saved at:  [workspace]/[project]/[package]/[class]/
					* Screenshot file name is: [class].[method],[description],[line #](date, time).png
					*/
					public void getScreenShot(StackTraceElement l, Exception e, String description, WebDriver driver) throws IOException {
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH.mm.ss");
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					String message1 = null;					
					try{
						 message1 = e.getCause().toString();
					} 
					catch (NullPointerException e1) {
					message1 = ".getCause() by NullPointerException:";
					}
					finally {
					String [] multiline1 = message1.replaceAll("\\r", "").split("\\n");
					String firstLine = multiline1[0];
					String errorCause = firstLine.substring(0,firstLine.indexOf(":"));
					String exceptionThrown = errorCause.substring(1 + errorCause.lastIndexOf("."), errorCause.length());
					 
					String packageNameOnly = l.getClassName().substring(0, l.getClassName().lastIndexOf("."));
					String classNameOnly = l.getClassName().substring(1 + l.getClassName().lastIndexOf("."), l.getClassName().length());
					String exception = exceptionThrown;
					String screenshotName = classNameOnly + "." + l.getMethodName() + ", " + exception + ", " + description + ", line # " + l.getLineNumber();

					String outputFile = outputFileDir + packageNameOnly + File.separator + classNameOnly + File.separator + screenshotName + " (" + dateFormat.format(new Date()) + ").png";
					fileWriterPrinter(outputFile);
					FileUtils.copyFile(scrFile, new File(outputFile));
					}
					}

					/* @throws IOException
					 * @throws NumberFormatException */
					public static String fileScanner(String fileName) throws NumberFormatException, IOException {				
						String n = null;
						if (fileExist(fileName, false)) {
						   File f = new File(testOutputFileDir + fileName);
						   Scanner scanner = new Scanner(f);
						   n = scanner.useDelimiter("\\Z").next();
						   scanner.close();
					    }
						return n;				
					}
					
					/* @throws IOException
					 * @throws NumberFormatException */
					public static void fileCleaner(String fileName) throws NumberFormatException, IOException {
						if (fileExist(fileName, false))
						 { (new File(testOutputFileDir + fileName)).delete(); }
					}				
					
		   /** Counter: Will renew counting starting with "1" if the Counter File is currently missing; Returns new iteration value; 
			 * @throws IOException
			 */
		    public static int counter(String counterFileName) throws NumberFormatException, IOException {
				// if Counter File does not exist - create new it with counter "1";
		        //                      otherwise - update existing by increasing the counter by "1";
				int n = 1;
				File f = new File(testOutputFileDir + counterFileName);
				if (f.exists() && f.isFile()) { n = Integer.valueOf(fileScanner(counterFileName)) + 1; }
				FileUtils.writeStringToFile(f, String.valueOf(n));
				return n;
		    }
		   
			/** Returns Current Date and Time */
			public static String getCurrentDateTimeFull() {
				// DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				// need to change after the date format is decided
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				return dateFormat.format(date);
			} 
			
			/** Outputs Test Run Time as HH:MM:SS, finish input required */
			public static String testRunTime(String startFileName, long finishTimeMilliseconds) throws IOException {
			   long finish = finishTimeMilliseconds;
			   String startingTime = fileScanner(startFileName);
			   long start = convertStringToLong(startingTime);
			   return convertTimeMillisecondsAsLongToDuration(finish - start);
			}
			
			/* @throws IOException
			 * @throws NumberFormatException */
			public static long convertStringToLong(String value) throws NumberFormatException, IOException {
				try {
					return Long.parseLong(value);
				} catch (NumberFormatException exception) {
					fileWriterPrinter("\"NullPointerException\" thrown:\nString '" + value
							+ "' is not convertable to Long...");
					return 0;
				}
			}
			
			/* @throws IOException
			 * @throws NumberFormatException */
			public static String convertLongToString(long value) throws NumberFormatException, IOException {
				try {
					return String.valueOf(value);
				} catch (NumberFormatException exception) {
					fileWriterPrinter("\"NullPointerException\" thrown:\nString '" + value
							+ "' is not convertable to Long...");
					return null;
				}
			}
			
			/* @throws IOException
			 * @throws NumberFormatException */
			public static String convertCalendarMillisecondsAsStringToDateTimeHourMinSec(String s) throws NumberFormatException, IOException {
				try {
					long l = Long.parseLong(s);
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = new Date(l);
					String d = format.format(date);
					return d;
				} catch (NumberFormatException exception) {
					fileWriterPrinter("\"NumberFormatException\" thrown "
							+ exception.getMessage());
					return ("\"NumberFormatException\" thrown " + exception
							.getMessage());
				}
			}
			
			/** Convert long Milliseconds to Date and Time (Hour:Min:Sec) */
			public static String convertCalendarMillisecondsAsLongToDateTimeHourMinSec(long fingerprint) {
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date(fingerprint);
				return format.format(date);
			}
			
			/** Convert long Milliseconds to Duration "Hours:Min:Sec" auto-format */
			public static String convertTimeMillisecondsAsLongToDuration(long milliseconds) {
				String hours = String.format("%02d", TimeUnit.MILLISECONDS.toHours(milliseconds));
				String minutes = String.format("%02d",
					   TimeUnit.MILLISECONDS.toMinutes(milliseconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliseconds)));
			    String seconds = String.format("%02d",
			           TimeUnit.MILLISECONDS.toSeconds(milliseconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliseconds)));
			    String duration = Integer.valueOf(hours) + ":" + minutes + ":" + seconds;
			    return duration;       
			}
			
//			/** Convert Date to long Milliseconds */
//			public long convertCalendarDateToMillisecondsAsLong(String stringDate) throws ParseException {
//				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//				Date date = formatter.parse(stringDate);
//				long mills = date.getTime();
//				return mills;
//			}
			
//			/** Convert Date and Time list year, month, day, hours, minutes, seconds to long Milliseconds */
//			public long convertCalendarIntDateTimeListToMillisecondsAsLong(
//					String date, int hours, int min, int sec)
//					throws ParseException {
//				return convertCalendarDateToMillisecondsAsLong(date) + ((hours * 3600) + (min * 60) + sec) * 1000;
//			}
			
			/** 
			 * Creates a new Test Log record as a text file named "run.log"
			 * create file example: File f = new File(<full path string>); f.createNewFile();
			 * @throws IOException
			 */
			public static void logOpen() throws IOException {
			 // Initialization:
				fileCleaner("failed.log" );
				fileCleaner("failed.num" );
				fileCleaner("finish.time");
				fileCleaner("ini.time"   );
				fileCleaner("run.log"    );
				fileCleaner("print.log"  );
				fileCleaner("start.time" );
				fileCleaner("stack.trace");
				fileCleaner("test.num"   );
				fileCleaner("wait.log"   );
				fileCleaner("xml.path"   );
				fileCleaner("source.html");
				String time = getCurrentDateTimeFull();  // System.out.print(" TEST START: " + time + "\n");
				fileWriter("ini.time", convertLongToString(System.currentTimeMillis()));
	         // Initial Log record:
				fileWriter("run.log", " TEST START: " + time);
			    fileWriter("run.log", "");
			}
			
			/**
			 * Closes the Test Log record text file named "run.log"
			 * @throws IOException
			 * @throws Exception 
	         */
			public static void logClose() throws IOException {
				long finish = System.currentTimeMillis();
				String time = getCurrentDateTimeFull();
			 // Scanning Failure Counter record:
				int failed = 0;
				if (fileExist("failed.num", false)) { failed = Integer.valueOf(fileScanner("failed.num")); }
			 // Scanning Test Counter record:
				int n = 1;
				if (fileExist("test.num", false)) { 
					if (! fileScanner("test.num").equals(null)) { n = Integer.valueOf(fileScanner("test.num")); }
					}
				if (n > 1) {    
			 // Scanning Initialization record:
			    String startingTime = fileScanner("ini.time");
				long start = convertStringToLong(startingTime);
				    fileWriterPrinter("TOTAL TESTS: " + Integer.valueOf(fileScanner("test.num")));
					fileWriterPrinter("     FAILED: " + failed);
					fileWriterPrinter("TEST  START: " + convertCalendarMillisecondsAsLongToDateTimeHourMinSec(start));
					fileWriterPrinter("TEST FINISH: " + time);
					fileWriterPrinter("TOTAL  TIME: " + convertTimeMillisecondsAsLongToDuration(finish - start));
					fileWriterPrinter()
	;
			 // Final Log record:
			    if (fileExist("run.log")) {
			    	fileWriter("run.log", "");
			    	fileWriter("run.log", "TOTAL TESTS: " + Integer.valueOf(fileScanner("test.num")));
			    	fileWriter("run.log", "     FAILED: " + failed);
			    	fileWriter("run.log", "TEST  START: " + convertCalendarMillisecondsAsLongToDateTimeHourMinSec(start));
			    	fileWriter("run.log", "TEST FINISH: " + time);
			    	fileWriter("run.log", "TOTAL  TIME: " + convertTimeMillisecondsAsLongToDuration(finish - start));
			    	fileWriter("run.log", "");
				}
				}
	         // Clean-up unnecessary file(s)
				fileCleaner("failed.num" );
				fileCleaner("finish.time");
				fileCleaner("ini.time"   );
				fileCleaner("start.time" );
				fileCleaner("stack.trace");
				fileCleaner("test.num"   );
				fileCleaner("xml.path"   );
			}
			
			/**
			 * @throws IOException
			 */
			public static void startTime() throws IOException {
			   String date = getCurrentDateTimeFull();
			   fileCleaner("start.time");
			   fileWriter("start.time", convertLongToString(System.currentTimeMillis()));
			// Creating New or Updating existing Test Counter record:  
			   int n = counter("test.num");
		    // Print-out information:
		       fileWriterPrinter("\n       Test: #" + n);
			   fileWriterPrinter(  "      Start: "  + date);
			// Append a Start Log record:
			   if (fileExist("run.log")) {
			       fileWriter("run.log", "");
			       fileWriter("run.log", "       Test: #" + n);
			       fileWriter("run.log", "      Start: "  + date);	    	        
		    	}		    
			}
			
			/** Prints Test End and Sub-Total Time */
			public static void endTime() throws IOException {
			   long finish = System.currentTimeMillis();
			   fileCleaner("finish.time");
			   fileWriter("finish.time", convertLongToString(finish));
			// Scanning Test Counter record:
			   int n = 1;
			   if (fileExist("test.num", false)) { 
				   if (! fileScanner("test.num").equals(null)) { n = Integer.valueOf(fileScanner("test.num")); }
			   }
			   fileWriterPrinter("     Finish: " + getCurrentDateTimeFull());
			   fileWriterPrinter("   Duration: " + testRunTime("start.time", finish)); 
			   if (n > 1) { fileWriterPrinter("   Subtotal: " + testRunTime("ini.time", finish) + "\n"); }
			   else { fileWriterPrinter(); }
			// Append an End Log record:
		       if (fileExist("run.log")) {
		    	   fileWriter("run.log", "     Finish: " + getCurrentDateTimeFull());
		    	   fileWriter("run.log", "   Duration: " + testRunTime("start.time", finish));
	    	       if (n > 1) { fileWriter("run.log", "   Subtotal: " + testRunTime("ini.time", finish)); }
		       }
	           }
		
	}


