package test.common;

import java.io.File;
import java.io.IOException;
import test.helper.Functions;

@SuppressWarnings("static-access")
public class Email {
	static Functions function = new Functions();
	
	  /**********common credentiald***********/
	  public static String autoTesterEmail    = "rweinbrand.tvo.org@gmail.com";
	  public static String autoTesterPassword = "!123456abcdef!";
	  public static String autoTesterUsername = autoTesterEmail.substring(0, autoTesterEmail.indexOf("@"));
	  
	  /**********common email addresses***********/
	  // TESTERS E-MAIL ADDRESSES
	  public static String testerHomeEmail = "rreng.ca@gmail.com";
	  public static String testerWorkEmail = "rweinbrand@tvo.org";
	  
	  // MANAGERS E-MAIL ADDRESSES  			  
	  public static String managerEmail = "ckatz@tvo.org";			  
	  public static String pmEmail = "dhojjati@tvo.org";
	  public static String baEmail = "msanjevic@tvo.org";
	  
	  // PRODUCTION E-MAIL ADDRESSES
	  public static String[] toAll = { pmEmail, baEmail };
	  public static String[] ccAll = {
		                               testerWorkEmail,
		                               managerEmail,
		                               "pleung@tvo.org",
		                               "aporretta@tvo.org",
		                               "ukhan@tvo.org",
		                               "egoldberg@tvo.org",
		                               "jvijaya@tvo.org"
		                             };
	  public static String[] bccAll = { /** autoTesterEmail,*/ testerHomeEmail };
	  
      // DEBUGGING E-MAIL ADDRESSES
	  public static String[] toTester  = { testerWorkEmail };
	  public static String[] ccTester  = { testerHomeEmail };
	  public static String[] bccTester = { autoTesterEmail };
	  
	  // "TO" E-MAIL ADDRESSES LOGIC
	  public static String[] to() throws NumberFormatException, IOException{
		String[] to = toTester;
		if( function.fileExist("email.all", false) && Boolean.valueOf(function.fileScanner("email.all")) ) { to = toAll; }
	    return to;
	  }
	  
	  // "CC" E-MAIL ADDRESSES LOGIC
	  public static String[] cc() throws NumberFormatException, IOException{
		String[] cc = ccTester;
		if( function.fileExist("email.all", false) && Boolean.valueOf(function.fileScanner("email.all")) ) { cc = ccAll; }
	    return cc;
	  }
	  
	  // "BCC" E-MAIL ADDRESSES LOGIC
	public static String[] bcc() throws NumberFormatException, IOException{
		String[] bcc = bccTester;
		if( function.fileExist("email.all", false) && Boolean.valueOf(function.fileScanner("email.all")) ) { bcc = bccAll; }
	    return bcc;
	  }
	  
	  public static String subject = "This is subject";
	  public static String text = "This is content";
	  
	  /**********common email single attachment***********/
	  public static String attachmentFullPath = Locators.testOutputFileDir + "emailable-report.html";
	  public static String attachmentFileName = attachmentFullPath.substring(
				                                attachmentFullPath.lastIndexOf("\\") + 1,
				                                attachmentFullPath.length()
				                                );
	  
	  /**********common email multi attachments***********/
	  public static String[] attachments = { Locators.testOutputFileDir + "run.log",
		                                     Locators.testOutputFileDir + "failed.log"
		                                    };
	  
	  // ATTACHMENT PATHS VALIDATION
	  public static String[] attachmentFullPaths() {
			int j = 0;
			for (int i = 0; i < Email.attachments.length; i++) {		  
				  File f = new File(Email.attachments[i]);
				  if ((f.exists() && f.isFile()) ) { j++;}
				  }
			  String[] paths = new String [j];
			  int n = 0;	  
			  for (int i = 0; i < Email.attachments.length; i++) {
				  File f = new File(Email.attachments[i]);
				  if ((f.exists() && f.isFile()) ) {
					  paths[n] = Email.attachments[i];
				  n++;
				  }
				  } 
			  return paths;
	  }

	  public static String[] attachmentFileNames() {
		  String[] names = new String [attachmentFullPaths().length];
		  for (int i = 0; i < attachmentFullPaths().length; i++) {
			  names[i] = attachmentFullPaths()[i].substring(
  				         attachmentFullPaths()[i].lastIndexOf("\\") + 1,
  				         attachmentFullPaths()[i].length()
  				         );
			  }
		  return names;
	  }
	  
	  /**********common gmail parameters***********/
	  public static String gmailDomain             = "gmail.com";
	  public static String gmailHost               = "smtp.gmail.com";
	  public static String gmailPort               = "465";
	  public static String gmailStarttls           = "true";
	  public static String gmailAuth               = "true";
	  public static boolean gmailDebug             = true;
	  public static String gmailSocketFactoryClass = "javax.net.ssl.SSLSocketFactory";
	  public static String gmailFallback           = "false";
	  
	  /**********common email content***********/
	  public static String whoSent     = "This e-mail has been sent automatically by \"Selenium WebDriver\" Auto-Testing Tool combined with \"TestNG\" framework";
	  public static String aboutTool   = "For more details and most up-to-date information please visit our website at http://www.seleniumhq.org and http://testng.org";
	  public static String doNotReply  = "Please do not reply to this email, as we are unable to respond from this address";
	  public static String unsubscribe = "Don't want to receive this notification anymore? Send email to \"autotest1@tvo.org\" with subject \"unsubscribe\"";
	  
	  public static String[] header = { whoSent, aboutTool, doNotReply, unsubscribe };
	  public static String[] footer = { whoSent, aboutTool, doNotReply, unsubscribe };
		
}
