package test.Send;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import test.common.*;
import test.helper.Functions;

@SuppressWarnings("static-access")
public class Mail {
	static Functions function = new Functions();
	
	/** 
	 * Test Start-Up management;
	 * @throws IOException 
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws NumberFormatException 
	 */
	@BeforeSuite /** (groups = {"START",}) */
	public void start() throws IOException, ParseException, InterruptedException, NumberFormatException {
		// ERASING PREVIOUS TEST LOGS AND RECORDS
		logCleaner();

		// PREVIOUS NUMBER OF TESTS MANAGEMENT
		lastToPrev();
		
		// TEST TYPE MANAGEMENT
		String test = testType();
		if(function.fileExist("test.type", false)) { function.fileCleaner("test.type"); }
		function.fileWriter("test.type", test);
		
		// SHOW TEST NUMBER DIFFERENCE MANAGEMENT
		Boolean show = addTestOption();
		if(function.fileExist("add.show", false)) { function.fileCleaner("add.show"); }
		function.fileWriter("add.show", show);
		// if(show) { System.out.println("Will show the difference between quantity of Tests executed during the last and previous runs!\n"); }
		if( function.fileExist("add.show", false) && Boolean.valueOf(function.fileScanner("add.show")) ) {
			     System.out.println("Will show the difference between quantity of Tests executed during the last and previous runs!\n");
		} else { System.out.println("Won't show the difference between quantity of Tests executed during the last and previous runs...\n");                    }

		// TEST DATE AND TIME MANAGEMENT
		String current = function.getCurrentDateTimeHourMinSec();
		System.out.println(current + "\n");		
		StringSelection stringSelection = new StringSelection(current);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
		long currTime    = function.convertCalendarDateTimeHourMinSecToMillisecondsAsLong(current);
		long startTime   = function.convertCalendarDateTimeHourMinSecToMillisecondsAsLong(dateBox());
		// String start  = function.convertCalendarMillisecondsAsLongToDateTimeHourMinSec(startTime);		
		long updateDelay = (startTime - currTime);
		int sec = (int) updateDelay/1000;
		
		// TEST HOST APPLICATION SERVER MANAGEMENT		
		System.out.println("Scheduled to start in: " + function.convertTimeSecondsToHoursMinSeconds(sec));
		System.out.println("Scheduled to start at: " + function.convertCalendarMillisecondsAsLongToDateTimeHourMinSec(currTime + updateDelay));
		
		// E-MAIL PERMEATION MANAGEMENT
		boolean send = emailOptionDouble();
		if(function.fileExist("email.opt", false)) { function.fileCleaner("email.opt"); }
		function.fileWriter("email.opt", send);
		// if(send) { System.out.println("Will send Automated E-Mail notification about Test Results!\n"); }
		if( function.fileExist("email.opt", false) && Boolean.valueOf(function.fileScanner("email.opt")) ) {
			   System.out.println("Will send Automated E-Mail notification about Test Results!\n");
			   
			   // E-MAIL ADDRESSES SELECTION MANAGEMENT
			   boolean all = emailAddresses();
			   if(function.fileExist("email.all", false)) { function.fileCleaner("email.all"); }
			   function.fileWriter("email.all", all);
			   // if(all) { System.out.println("E-Mail will be sent to All assigned Recepients!\n"); }
			   if( function.fileExist("email.all", false) && Boolean.valueOf(function.fileScanner("email.all")) ) {
				   System.out.println("E-Mail will be sent to All assigned Recepients!\n");
			   } else { System.out.println("E-Mail will be sent to Automation Tester Only...\n"); }
			   
		} else { System.out.println("Will not send any E-Mail notification...\n"); }
		
		// TEST DELAY MANAGEMENT
		int testDelay = minBox();
		if ( (testDelay > 0 ) && (currTime + updateDelay + testDelay*60*1000 > System.currentTimeMillis()) ){    // USED TO BE: if (testDelay != 0 ) {
		System.out.println("  Test additional delay is: " + function.convertTimeSecondsToHoursMinSeconds(sec + testDelay*60));
		System.out.println("  Test will be  started at: " + function.convertCalendarMillisecondsAsLongToDateTimeHourMinSec(currTime + updateDelay + testDelay*60*1000));
		System.out.println("\nwait please...\n");
		} else { System.out.println("starting now...\n"); }
		
		// String date = start.substring(0,start.indexOf(" "));
		// String time = start.substring(start.indexOf(" ") + 1, start.length());

		// System.out.println("\n" + date + "\n" + time + "\n");
		// System.out.println(command);
		
		clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
		
		long sleep = (function.convertCalendarDateTimeHourMinSecToMillisecondsAsLong(function.convertCalendarMillisecondsAsLongToDateTimeHourMinSec(currTime + updateDelay + testDelay*60*1000)) -
				      function.convertCalendarDateTimeHourMinSecToMillisecondsAsLong(function.getCurrentDateTimeHourMinSec()));
				
		if (testDelay > 0 ) { Thread.sleep(sleep); }   // USED TO BE: if (testDelay != 0 ) { Thread.sleep(sleep); }
		
		System.out.println(function.getCurrentDateTimeHourMinSec());
		System.out.println("Starting...\n");
		
		// CREATE NEW TEST LOG RECORD
		logOpen();
		}
	
	/**
	 * Creates a new Test Log record as a text file named "run.log"
	 * create file example:
	 * File f = new File(<full path string>); f.createNewFile();
	 * @throws IOException
	 */
	public void logOpen() throws IOException {
		// Initialization:
		function.fileCleaner("failed.log");
		function.fileCleaner("failed.num");
		function.fileCleaner("finish.time");
		function.fileCleaner("ini.time");
		function.fileCleaner("run.log");
		function.fileCleaner("print.log");
		function.fileCleaner("start.time");
		function.fileCleaner("stack.trace");
		function.fileCleaner("test.num");
		function.fileCleaner("wait.log");
		function.fileCleaner("xml.path");
		function.fileCleaner("source.html");
		String time = function.getCurrentDateTimeFull(); // System.out.print(" TEST START: "
												// + time + "\n");
		function.fileWriter("ini.time", function.convertLongToString(System.currentTimeMillis()));
		// Initial Log record:
		function.fileWriter("run.log", " TEST START: " + time);
		function.fileWriter("run.log", "");
	}
	
	/**
	 * Closes the Test Log record text file named "run.log"
	 * @throws IOException
	 * @throws Exception 
     */
	public void logClose() throws IOException {
		long finish = System.currentTimeMillis();
		String time = function.getCurrentDateTimeFull();
		
	 // Scanning Failure Counter record:
		int failed = 0;
		if (function.fileExist("failed.num", false)) { failed = Integer.valueOf(function.fileScanner("failed.num")); }
		
	 // Scanning Test Counter record:
		int n = 1;
		if (function.fileExist("test.num", false)) { 
			if (! function.fileScanner("test.num").equals(null)) { n = Integer.valueOf(function.fileScanner("test.num")); }
			}
		String startingTime = function.fileScanner("ini.time");
		long start = function.convertStringToLong(startingTime);
				
	 // Scanning Initialization record:
		if (n > 1) {
		    function.fileWriterPrinter("TOTAL TESTS: " + Integer.valueOf(function.fileScanner("test.num")));
			function.fileWriterPrinter("     FAILED: " + failed);
			function.fileWriterPrinter("TEST  START: " + function.convertCalendarMillisecondsAsLongToDateTimeHourMinSec(start));
			function.fileWriterPrinter("TEST FINISH: " + time);
			function.fileWriterPrinter("TOTAL  TIME: " + function.convertTimeMillisecondsAsLongToDuration(finish - start));
			function.fileWriterPrinter();
		}
		
	 // Final Log record:
	    if (function.fileExist("run.log", false)) {
	    	
	    	if (n > 1) {
	    	function.fileWriter("run.log", "");		    	
            function.fileWriter("run.log", "TOTAL TESTS: " + Integer.valueOf(function.fileScanner("test.num")));
	    	}
                        
            if (n == 1) { function.fileWriter("run.log", ""); }
            if (n >= 1) { function.fileWriter("run.log", "     FAILED: " + failed); }
	    		    	
	        if (n > 1) {	
		    function.fileWriter("run.log", "TEST  START: " + function.convertCalendarMillisecondsAsLongToDateTimeHourMinSec(start));
		    function.fileWriter("run.log", "TEST FINISH: " + time);
		    function.fileWriter("run.log", "TOTAL  TIME: " + function.convertTimeMillisecondsAsLongToDuration(finish - start));
		    function.fileWriter("run.log", "");
		    }
	    }

	 // Final Log email:
	    if (function.fileExist("email.cont", false)) { function.fileCleaner("email.cont"); }
	    	function.fileWriter("email.cont", "         FAILED: " + failed);
    	    function.fileWriter("email.cont", "    TEST  START: " + function.convertCalendarMillisecondsAsLongToDateTimeHourMinSec(start));
    	    function.fileWriter("email.cont", "    TEST FINISH: " + time);
    	    function.fileWriter("email.cont", "    TOTAL  TIME: " + function.convertTimeMillisecondsAsLongToDuration(finish - start));
    	    function.fileWriter("email.cont", "");
        
    		// Clean-up unnecessary file(s)  		
    		function.fileCleaner("finish.time");
    		function.fileCleaner("start.time");
    		function.fileCleaner("stack.trace");
    		function.fileCleaner("xml.path");
		
	 // Store last test number
		function.fileCopy("test.num", "last.num");
	}
 
		/** 
		 * Cleans all the Log records left from previous test executions
		 * @throws NumberFormatException 
		 * @throws IOException 
		 */
		public void logCleaner() throws NumberFormatException, IOException{
		 // PRE-CLEANING:
			function.fileCleaner("email.cont" );
			function.fileCleaner("email.subj" );
			
			function.fileCleaner("failed.log" );		
			function.fileCleaner("finish.time");
			function.fileCleaner("ini.time"   );
			function.fileCleaner("print.log"  );
			function.fileCleaner("run.log"    );
			function.fileCleaner("source.html");
			function.fileCleaner("stack.trace");
			function.fileCleaner("start.time" );
			function.fileCleaner("wait.log"   );
			function.fileCleaner("xml.path"   );
			
		    function.fileCleaner("test.num"   );
			function.fileCleaner("failed.num" );
			}
	
		/** 
		 * Test Report management;
		 * @throws IOException 
		 * @throws NumberFormatException 
		 * @throws MessagingException 
		 * @throws AddressException 
		 */
		@AfterSuite /** (groups = {"FINISH",}) */
		public void finish() throws NumberFormatException, IOException, AddressException, MessagingException {
			// CLOSE TEST LOG RECORD
			logClose();
			
			// E-MAIL SUBJECT 
			if (function.fileExist("email.subj", false)) { function.fileCleaner("email.subj"); }
			String result = "ALL PASSED!";
			if ( Integer.valueOf(lastTestNum()) == 1 ) { result = "PASSED!"; }
			if (function.fileExist("failed.log", false)) { 
				if (function.fileExist("failed.num", false)) { 
					result = "FAILED: " + function.fileScanner("failed.num");
					if ( Integer.valueOf(lastTestNum()) == Integer.valueOf(function.fileScanner("failed.num")) ) { result = "ALL FAILED..."; }
					if ( Integer.valueOf(lastTestNum()) == 1 ) { result = "FAILED..."; }
				}
				}	
			String subject = "CPAD ---> Automated " + function.fileScanner("test.type") + 
					         " Result ---> Total tests run: " + lastTestNum() + 
					         " ---> " + result + "  [ " + function.getCurrentDateYearMonthDay() + "   " + function.getCurrentTimeHourMin() + " ]";
			function.fileWriter("email.subj", subject);
			
		    // E-MAIL CONTENT
		    if (function.fileExist("email.cont", false)) {
			    String email = function.fileScanner("email.cont");
			    function.fileCleaner("email.cont");
			
			/* E-MAIL CONTENT HEADER *//**
			for (int i = 0; i < EmailLocators.header.length; i++) { function.fileWriter("email.cont", "* " + EmailLocators.header[i]); }
			for (int i = 0; i < 2; i++) { function.fileWriter("email.cont", ""); }     */
			
			// E-MAIL CONTENT BODY
			function.fileWriter("email.cont", "Hi,");
			function.fileWriter("email.cont", "");
			function.fileWriter("email.cont", "FYI:"); 
			function.fileWriter("email.cont", "CPAD - AUTOMATED " + function.fileScanner("test.type").toUpperCase() + " RESULT");
			function.fileWriter("email.cont", "");
			function.fileWriter("email.cont", "     APP SERVER: " + function.fileScanner("server.info"));
			function.fileWriter("email.cont", "     GiT BRANCH: develop");
			function.fileWriter("email.cont", "");

			// E-MAIL CONTENT TOTAL TESTS NUMBER
			function.fileWriter("email.cont", "    TOTAL TESTS: " + lastTestNum());
		    
		    // E-MAIL CONTENT RESULTS
		    function.fileWriter("email.cont", email);
		    
		    // E-MAIL CONTENT NEW TESTS ADDED NUMBER, IF ANY
		    if ( (Integer.valueOf(function.fileScanner("last.num")) > 1) && (Integer.valueOf(function.fileScanner("prev.num")) > 0) ) {
		    if ( function.isInteger(addTestNum()) && Boolean.valueOf(function.fileScanner("add.show")) ) {
		    	if ( Integer.valueOf(addTestNum()) > 0 ) {
		    		function.fileWriterPrinter(" TOTAL PREVIOUS: " + prevTestNum());
		    		function.fileWriterPrinter("NEW TESTS ADDED: " + addTestNum());
		    		
		    		function.fileWriter("run.log", " TOTAL PREVIOUS: " + prevTestNum());
		    		function.fileWriter("run.log", "NEW TESTS ADDED: " + addTestNum());
		    		
		    		if (function.fileExist("email.cont", false)) {
		    			function.fileWriter("email.cont", " TOTAL PREVIOUS: " + prevTestNum());
		    			function.fileWriter("email.cont", "NEW TESTS ADDED: " + addTestNum());
		    		    function.fileWriter("email.cont", "");
		    			}
		    		}
		    	}
		    }
		    
		    // E-MAIL CONTENT FINAL RESULT STATEMENT
		    function.fileWriter("email.cont", "   FINAL RESULT: " + result);
		    
		    // E-MAIL CONTENT ATTACHMENT INFO
		    function.fileWriter("email.cont", "");
		    function.fileWriter("email.cont", "       ATTACHED: reference log(s)");

		    // E-MAIL CONTENT FAILURE INFO, IF ANY
		    if (function.fileExist("failed.log", false)) {
		    	for (int i = 0; i < 3; i++) { function.fileWriter("email.cont", ""); }
				function.fileWriter("email.cont", "    LIST OF FAILED TESTS:");
	    	    function.fileWriter("email.cont", "");
				String failed = function.fileScanner("failed.log");
				function.fileWriter("email.cont", failed);
				}
		    
		    /* E-MAIL CONTENT FOOTER, OTHER INFO, ETC. (OPTIONAL) *//**
		    function.fileWriter("email.cont", "");     */	    
		    for (int i = 0; i < 8; i++) { function.fileWriter("email.cont", ""); }
		    for (int i = 0; i < Email.footer.length; i++) { function.fileWriter("email.cont", "* " + Email.footer[i]); }
		    }
				
		// E-MAIL SENDING
		if( function.fileExist("email.opt", false) && Boolean.valueOf(function.fileScanner("email.opt")) ) {
		sendEmail(
				Email.autoTesterUsername,
				Email.autoTesterPassword,
				Email.gmailHost,
				Email.gmailPort,
				Email.gmailStarttls,
				Email.gmailAuth,
				Email.gmailDebug,
				Email.gmailSocketFactoryClass,
				Email.gmailFallback,
				Email.to(),
				Email.cc(),
				Email.bcc(),
				subject,
				function.fileScanner("email.cont"),
				Email.attachmentFullPaths(),
				Email.attachmentFileNames()
		        );
		}
		 
	    // Clean-up unnecessary file(s)
		   function.fileCleaner("ini.time"   );
	       function.fileCleaner("failed.num" );
		   function.fileCleaner("test.num"   );
		   function.fileCleaner("add.num"    );
		   function.fileCleaner("prev.num"   );
		   function.fileCleaner("server.info");
		   function.fileCleaner("email.opt"  );
		   function.fileCleaner("email.all"  );
		   function.fileCleaner("email.cont" );
		   function.fileCleaner("email.subj" );
		   function.fileCleaner("test.type"  );
		   function.fileCleaner("add.show"   );
		}
		
		/** Test Number dialoge */
		public int testNum(){
			 ImageIcon icon = new ImageIcon(Locator.testIconFileDir + "tests.number.1-9.png");
			 String Default = "0";
			 String number = null;
			 boolean isTrue = false;
			 while(isTrue == false) {
				 number = (String) JOptionPane.showInputDialog(
						 null, 
						 "Enter desired Number of Test \n(integer positive value)\n\nor click \"CANCEL\" for " + Default + "\n ",
						 "Test Number",
					     1,
					     icon, null, 1
						 );	
				 
//				 final icon = new ImageIcon("home/user/Pictures/default.jpg"));
//				 showMessageDialog(dialog, "Blah blah blah", "About", JOptionPane.INFORMATION_MESSAGE, icon);
				 
				 if(number == null){ number = Default; }
				 isTrue = function.isInteger(number);
				 if (isTrue == true) { isTrue = (Integer.valueOf(number) >= 0); }
				 }
			 return Integer.valueOf(number);
			 }
			
		 /** Test Type dialoge 
		 * @throws IOException 
		 * @throws NumberFormatException
		 */
		public String testType() throws NumberFormatException, IOException {		  
			  Component frame = null;
		      Icon icon = UIManager.getIcon("OptionPane.questionIcon");
			  icon = new ImageIcon(Locator.testIconFileDir + "question.round.png");
			      Object[] possibilities = { "As Previous",
	                                         "Regression Test", 
	                                         "Test Failures Re-Run",
	                                         "Test Execution",
	                                         "New Test Execution"
	                                        };
			      String number = "";
			      if(!function.fileExist("prev.num", false)){
			    	  //function.fileWriter("prev.num", 0);
			    	  function.fileWriter("prev.num", testNum());
			    	  }
			      if(function.fileExist("prev.num", false)){
			    	  int num = Integer.valueOf(function.fileScanner("prev.num"));
			    	  if (num == 0) {number = "( number of tests executed during last run is missing... )";}
			    	  if (num == 1) {number = "( " + function.fileScanner("prev.num") + " test executed during last run )";}
			    	  if (num > 1)  {number = "( " + function.fileScanner("prev.num") + " tests executed during last run )";}
			    	  }
			      String s = null;		      
			      while((s == null) || (s.length() == 0)){
			      s = (String)JOptionPane.showInputDialog(frame,"Select Test Type:\n" + number,"Test Type Selection List",JOptionPane.PLAIN_MESSAGE,icon,possibilities,"");
		          if(s.equals("As Previous")){	        	  
		        	  if(function.fileExist("prev.num", false)){
		        		  if( Integer.valueOf(function.fileScanner("prev.num"))  > 100) { s = "Regression Test";      }
		        		  if( Integer.valueOf(function.fileScanner("prev.num")) <= 100) { s = "Test Failures Re-Run"; }
		        		  }
		        	  }	          
			      }	
			      System.out.println("You selected to run " + s.toUpperCase() + "\n");
			      return s;
			}
		
		 /** Date and Time entry dialogue */
		 public String dateBox(){
			 ImageIcon icon = new ImageIcon(Locator.testIconFileDir + "shedule.date.time.png");
			 String str = null;
			 boolean isDate = false;
			 while(isDate == false) {
				 
				 str = (String) JOptionPane.showInputDialog(
						 null, 
						 "Enter Date & Time \n(like \"" + function.getCurrentDateTimeHourMinSec() + "\")\n\nor paste,\nor click \"CANCEL\" for default current date and time\n ",
						 "Date & Time",
						 1,
						 icon, null, function.getCurrentDateTimeHourMinSec()
						 );
				 
				 if(str != null){
					 //JOptionPane.showMessageDialog(null, "You entered: " + str, "Date & Time", 1);
					 //System.out.println("\nYou entered: " + str + "\n");
					 }
				 else {
					 str = function.getCurrentDateTimeHourMinSec();
					 //JOptionPane.showMessageDialog(null, "You pressed cancel button...", "Date & Time", 1);
					 //System.out.println("\nYou pressed cancel button...\n");
					 }
				 String datePattern = "\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}";
				 isDate = str.matches(datePattern);
				 //System.out.println("Is the entry of \"" + str + "\" matching with this date Pattern: \"" + datePattern + "\"?\nAnswer: " + isDate + "\n");
				 }     
			 return str;				 
			 }
		 
//		 /**
//		  * 'dev' Server number entry dialogue 
//		  * @throws IOException 
//		  * @throws NumberFormatException
//		  */
//		 public int devBox() throws NumberFormatException, IOException{
//			 ImageIcon icon = new ImageIcon(Locator.testIconFileDir + "web.server.pc.png");
//			 String Default = "24";
//				StringSelection stringSelection = new StringSelection(Default);
//				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
//				clpbrd.setContents(stringSelection, null);
//			 String dev = null;
//			 boolean isCorrect = false;
//			 while(isCorrect == false) {
//				 dev = (String) JOptionPane.showInputDialog(
//						 null, 
//						 "Enter \"dev\" Server number \n(\"24\" or \"25\")\n\nor paste,\nor click \"CANCEL\" for \"dev24\" as a default\n ",
//						 "\"dev\" Server",
//						 1,
//						 icon, null, Default
//						 );
//				 if(dev != null){
//				       //JOptionPane.showMessageDialog(null, "You entered: " + dev, "\"dev\" Server", 1);
//				       //System.out.println("\nYou entered: " + dev + "\n");
//					 }
//				 else {
//					   dev = "24";
//				       //JOptionPane.showMessageDialog(null, "You pressed cancel button...", "\"dev\" Server", 1);
//				       //System.out.println("\nYou pressed cancel button...\n");
//					 }
//				 String datePattern = "\\d{2}";
//				 isCorrect = ( dev.matches(datePattern) && ( dev.equals("24") || dev.equals("25") ) );
//				 //System.out.println("Is the entry of \"" + dev + "\" satisfying the acceptance criteria? \nAnswer: " + isCorrect + "\n");
//				 } 
//			 if(function.fileExist("server.info", false)) { function.fileCleaner("server.info"); }
//			 function.fileWriter("server.info", "dev" + dev + ".tvo.org");
//			 return Integer.valueOf(dev);
//			 }
		 
		 /** Test Delay entry dialogue */
		 public int minBox(){		 
		  // Icon questionIcon = UIManager.getIcon("OptionPane.questionIcon");
			 Icon icon = new ImageIcon(Locator.testIconFileDir + "timer.watch.when.png");
			 String min = null;
			 
//			 String message = "When do you want to run your test?";	
//			 boolean now = false;
//			 JCheckBox checkboxYes = new JCheckBox("Start immediatelly !");
//			 Object[] params = { message, checkboxYes };
//			 JOptionPane.showConfirmDialog( null, params, null, JOptionPane.CLOSED_OPTION, 0, questionIcon );		 
//			 now = checkboxYes.isSelected();

			 String message = "Do you want to run your test right now?";		 
			 Object[] params = {message};
		  // int n = JOptionPane.showConfirmDialog(null, params, "Notification Option", JOptionPane.INFORMATION_MESSAGE, 0, icon);
			 String[] buttons = { "Now !", "Later", "Cancel" };
			 int n = JOptionPane.showOptionDialog(null, params, "Notification Option", JOptionPane.INFORMATION_MESSAGE, 0, icon, buttons, buttons[1]);
			 boolean now = (n == 0);
			 
			 if (now) { min = "-1"; }
			 else {
				    String Default = "45";
					StringSelection stringSelection = new StringSelection(Default);
					Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
					clpbrd.setContents(stringSelection, null);
					
				    boolean isTrue = false;
			        while(isTrue == false) {
			        icon = new ImageIcon(Locator.testIconFileDir + "timer.min.png");
				    min = (String) JOptionPane.showInputDialog(
						  null, 
						  "Enter Test Delay, minutes \n(integer positive value only)\n\nor paste,\nor click \"CANCEL\" for " + Default + " min as a default delay\n ",
						  "Test Delay",
						  1,
						  icon, null, Default
						  );
				    if (min == null) { min = Default; }
				    isTrue = function.isInteger(min);
				    if (isTrue == true) { isTrue = (Integer.valueOf(min) >= 0); }
				    }
			        }
			 return Integer.valueOf(min);
			 }
		 
		 /** Test E-mail Notification Option dialogue with "Yes" checkbox */
		 public boolean emailOption(){
			 Icon icon = new ImageIcon(Locator.testIconFileDir + "envelope.open.letter.png");
			 JCheckBox checkbox = new JCheckBox("Yes!");
			 String message = "Do you want to send automated E-Mail notification about Test Results?";
			 Object[] params = { message, checkbox };
			 JOptionPane.showConfirmDialog(null, params, "E-Mail Notification Option", JOptionPane.CLOSED_OPTION, 0, icon);
			 boolean send = checkbox.isSelected();
			 return send;
		 }
		 
		 /** Test E-mail Notification Option dialogue with "Yes" and "No" smart-checkbox */
		 public boolean emailOptionDouble(){
			 Icon icon = new ImageIcon(Locator.testIconFileDir + "envelope.open.email.png");
		     JCheckBox checkboxYes = new JCheckBox("Yes !");
		     JCheckBox checkboxNo = new JCheckBox("No !");
		     checkboxNo.setSelected(true);
		     String message = "Do you want to send automated E-Mail notification about Test Results?";
		     Object[] params = { message, checkboxYes, checkboxNo };
		     boolean send = false;
		     boolean dont = false;   
		     while(send == dont) {
		        JOptionPane.showConfirmDialog(null, params, "E-Mail Notification Option", JOptionPane.CLOSED_OPTION, 0, icon);
		        send = checkboxYes.isSelected();
		        dont = checkboxNo.isSelected();
		      }
			 return send; 
		 }
		 
		 /** Test E-mail Addresses Option dialogue with "All" and "Tester" smart-checkbox */
		 public boolean emailAddresses(){
			 Icon icon = new ImageIcon(Locator.testIconFileDir + "envelope.front.address.png");
		     JCheckBox checkboxAll = new JCheckBox("Send E-Mail to All !");
		     JCheckBox checkboxTester = new JCheckBox("Send E-Mail to Tester Only !");
		     checkboxTester.setSelected(true);
		     String message = "Who do you want to send the automated E-Mail notification about Test Results?";
		     Object[] params = { message, checkboxAll, checkboxTester };
		     boolean all = false;
		     boolean tester = false;   
		     while(all == tester) {
		        JOptionPane.showConfirmDialog(null, params, "E-Mail Addresses Option", JOptionPane.CLOSED_OPTION, 0, icon);
		        all = checkboxAll.isSelected();
		        tester = checkboxTester.isSelected();
		      }
			 return all; 
		 }
		 
		 /** Reads the previous (last) Test total test number, records it as a previous, and erases the last total 
		  * @throws IOException 
		  * @throws NumberFormatException 
		  */
		 public void lastToPrev() throws NumberFormatException, IOException{
			 if (function.fileExist("test.num", false)) {
				 function.fileCopy("test.num", "last.num");
				 function.fileCleaner("test.num");
				 }
			 if (function.fileExist("prev.num", false)) { function.fileCleaner("prev.num"); }
		     if (function.fileExist("last.num", false)) {
		    	 function.fileCopy("last.num", "prev.num");
		        function.fileCleaner("last.num");
		     }
		 }
		 
		 /** Reads the previous Test total test number
		  * @throws IOException 
		  * @throws NumberFormatException 
		  */
		 public String prevTestNum() throws NumberFormatException, IOException{
			 String prev = "N/A";
			 if (function.fileExist("prev.num", false)) { prev = function.fileScanner("prev.num"); }
			 return prev; 
		 }
		 
		 /** Reads the last (just finished) Test final test number
		  * @throws IOException 
		  * @throws NumberFormatException
		  */
		 public String lastTestNum() throws NumberFormatException, IOException{
			 String last = "N/A";
		     if (function.fileExist("last.num", false)) { last = function.fileScanner("last.num"); }
			 return last; 
		 }
		 
		 /** Calculates the number of tests difference between last (just finished) and previous Tests   
		  * @throws IOException 
		  * @throws NumberFormatException
		  */
		 public String addTestNum() throws NumberFormatException, IOException{
			 String added = "N/A";
			 if (function.fileExist("add.num", false)) { function.fileCleaner("add.num"); }
			 if ( function.fileExist("prev.num", false) && function.fileExist("last.num", false) ) {
				 String last = function.fileScanner("last.num");
				 String prev  = function.fileScanner("prev.num");
				 if ( function.isInteger(last) && function.isInteger(prev) ) {
					 added = String.valueOf((Integer.valueOf(last) - Integer.valueOf(prev)));
					 function.fileWriter("add.num", added);
					 }
		     }
			 return added; 
		 }
		 
		 /** Test E-mail Notification Option dialogue with "Yes" checkbox */
		 public boolean addTestOption(){
		  // Icon icon = UIManager.getIcon("OptionPane.questionIcon");
			 Icon icon = new ImageIcon(Locator.testIconFileDir + "question.round.png");
			 JCheckBox checkbox = new JCheckBox("Yes!");
			 String message = "Do you want to show the number of difference between last and previous Tests?";
			 Object[] params = { message, checkbox };
			 JOptionPane.showConfirmDialog(null, params, "Show Tests Number change Option", JOptionPane.CLOSED_OPTION, 0, icon);
			 boolean show = checkbox.isSelected();
			 return show;
		 }
		 
		 /** Sends e-mail with single-file attachment */
		 public boolean sendEmail(
					String userName,
					String passWord,
					String host,
					String port,
					String starttls,
					String auth,
					boolean debug,
					String socketFactoryClass,
					String fallback,
					String[] to,
					String[] cc,
					String[] bcc,
					String subject,
					String text,
					String attachmentFullPath,
					String attachmentName
					) throws AddressException, MessagingException{

				    // Object Instantiation of a properties file (sets SMTP server properties)
				    Properties properties = new Properties();
				    properties.put("mail.smtp.user", userName);
				    properties.put("mail.smtp.host", host);
				    if(!"".equals(port)){ properties.put("mail.smtp.port", port); }
				    if(!"".equals(starttls)){
				        properties.put("mail.smtp.starttls.enable",starttls);
				        properties.put("mail.smtp.auth", auth);
				        }
				    if(debug){ properties.put("mail.smtp.debug", "true"); }
				    else     { properties.put("mail.smtp.debug", "false"); }
				    if(!"".equals(port)){ properties.put("mail.smtp.socketFactory.port", port); }
				    if(!"".equals(socketFactoryClass)){ properties.put("mail.smtp.socketFactory.class",socketFactoryClass); }
				    if(!"".equals(fallback)){ properties.put("mail.smtp.socketFactory.fallback", fallback); }

				try{
				    // Creates a new session 
				    Session session = Session.getDefaultInstance(properties, null);
				    session.setDebug(debug);

				    // Creates a new e-mail message part
				    MimeMessage msg = new MimeMessage(session);
				    msg.setSubject(subject);
				    //msg.setSentDate(new Date());


				    // Creates the message part 
				    BodyPart messageBodyPart = new MimeBodyPart();

				    // Fill the message
				    messageBodyPart.setText(text);

				    // Create a multi-part message
				    Multipart multipart = new MimeMultipart();

				    // Sets text message part
				    multipart.addBodyPart(messageBodyPart);

				    /** For attaching a single document */
				    if(!"".equals(attachmentFullPath)){ 
				        // Adding attachment
				        messageBodyPart = new MimeBodyPart();
					    DataSource source = new FileDataSource(attachmentFullPath);
					    messageBodyPart.setDataHandler(new DataHandler(source));
					    //messageBodyPart.setDisposition(Part.ATTACHMENT);
					    messageBodyPart.setFileName(attachmentName);
					    multipart.addBodyPart(messageBodyPart);
					    }
				    
				    // Sets the complete multi-part message as e-mail
				    msg.setContent(multipart);

				    msg.setFrom(new InternetAddress(userName));

				    for(int i=0;i<to.length;i++){ msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i])); }
				    for(int i=0;i<cc.length;i++){ msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i])); }
				    for(int i=0;i<bcc.length;i++){ msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc[i])); }

				    msg.saveChanges();

				    Transport transport = session.getTransport("smtp");
				    transport.connect(host, userName, passWord);
				    transport.sendMessage(msg, msg.getAllRecipients());
				    transport.close();

				    System.out.println("\nE-Mail sent sucessfully!");
				    return true;
				    } catch (Exception mex){ System.out.println("\nE-Mail sending failed...\nException:\n" + mex); return false; }

				}
		 
		 /** Sends e-mail with multi-file attachment */
		 public static boolean sendEmail(
					String userName,
					String passWord,
					String host,
					String port,
					String starttls,
					String auth,
					boolean debug,
					String socketFactoryClass,
					String fallback,
					String[] to,
					String[] cc,
					String[] bcc,
					String subject,
					String text,
					String[] attachmentFullPath,
					String[] attachmentName
					) throws AddressException, MessagingException{

				    // Object Instantiation of a properties file (sets SMTP server properties)
				    Properties properties = new Properties();
				    properties.put("mail.smtp.user", userName);
				    properties.put("mail.smtp.host", host);
				    if(!"".equals(port)){ properties.put("mail.smtp.port", port); }
				    if(!"".equals(starttls)){
				        properties.put("mail.smtp.starttls.enable",starttls);
				        properties.put("mail.smtp.auth", auth);
				        }
				    if(debug){ properties.put("mail.smtp.debug", "true"); }
				    else     { properties.put("mail.smtp.debug", "false"); }
				    if(!"".equals(port)){ properties.put("mail.smtp.socketFactory.port", port); }
				    if(!"".equals(socketFactoryClass)){ properties.put("mail.smtp.socketFactory.class",socketFactoryClass); }
				    if(!"".equals(fallback)){ properties.put("mail.smtp.socketFactory.fallback", fallback); }

				try{
				    // Creates a new session 
				    Session session = Session.getDefaultInstance(properties, null);
				    session.setDebug(debug);

				    // Creates a new e-mail message part
				    MimeMessage msg = new MimeMessage(session);
				    msg.setSubject(subject);
				    //msg.setSentDate(new Date());


				    // Creates the message part 
				    BodyPart messageBodyPart = new MimeBodyPart();

				    // Fill the message
				    messageBodyPart.setText(text);

				    // Create a multi-part message
				    Multipart multipart = new MimeMultipart();

				    // Sets text message part
				    multipart.addBodyPart(messageBodyPart);

				    /** For attaching a multi documents */
				    for (int i = 0; i < attachmentName.length; i++) {
				    	if (!"".equals(attachmentFullPath[i])) {
				    		// Adding individual attachment
				            messageBodyPart = new MimeBodyPart();
					        DataSource source = new FileDataSource(attachmentFullPath[i]);
					        messageBodyPart.setDataHandler(new DataHandler(source));
					        //messageBodyPart.setDisposition(Part.ATTACHMENT);
					        messageBodyPart.setFileName(attachmentName[i]);
					        multipart.addBodyPart(messageBodyPart);
					        }
				    	}
				    
				    // Sets the complete multi-part message as e-mail
				    msg.setContent(multipart);

				    msg.setFrom(new InternetAddress(userName));

				    for(int i=0;i<to.length;i++){ msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i])); }
				    for(int i=0;i<cc.length;i++){ msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i])); }
				    for(int i=0;i<bcc.length;i++){ msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc[i])); }

				    msg.saveChanges();

				    Transport transport = session.getTransport("smtp");
				    transport.connect(host, userName, passWord);
				    transport.sendMessage(msg, msg.getAllRecipients());
				    transport.close();

				    System.out.println("\nE-Mail sent sucessfully!");
				    return true;
				    } catch (Exception mex){ System.out.println("\nE-Mail sending failed...\nException:\n" + mex); return false; }

				}
		 
}
