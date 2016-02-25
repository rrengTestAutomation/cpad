package test.helper;

/** ORIGINAL IMPORT */
// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileWriter;
// import java.io.InputStreamReader;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.net.HttpURLConnection;
// import java.net.MalformedURLException;
// import java.net.URL;
// import java.net.URLConnection;
// import java.text.DateFormat;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.concurrent.TimeUnit;
// import java.util.Date;
// import java.util.Scanner;
// import java.util.zip.GZIPInputStream;
// import java.util.zip.Inflater;
// import java.util.zip.InflaterInputStream;
// import org.apache.commons.io.FileUtils;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.OutputType;
// import org.openqa.selenium.TakesScreenshot;
// import org.openqa.selenium.WebDriver;
// import org.testng.Assert;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/** HELPER IMPORT */
//import java.awt.AWTException;
//import java.awt.Component;
//import java.awt.datatransfer.Clipboard;
//import java.awt.datatransfer.StringSelection;
//import java.awt.Toolkit;
//import java.text.DateFormatSymbols;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Iterator;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Properties;
//import java.util.Random;
//import java.util.Set;
//import java.util.TimeZone;
//import javax.activation.DataHandler;
//import javax.activation.DataSource;
//import javax.activation.FileDataSource;
//import javax.mail.BodyPart;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
//import javax.swing.JCheckBox;
//import javax.swing.JOptionPane;
//import javax.swing.UIManager;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.internal.Coordinates;
//import org.openqa.selenium.internal.Locatable;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.support.pagefactory.ByAll;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

/** LOCATORS */
import test.common.Locators;

public class Functions {
	WebDriver driverHelper;

	public WebDriver getServerName(WebDriver driver)
			throws IllegalArgumentException, MalformedURLException {
		try {
			String remoteOrLocal = System.getProperty("Server");
			String browser = System.getProperty("Browser");
			if (remoteOrLocal.equalsIgnoreCase("local")
					&& browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (remoteOrLocal.equalsIgnoreCase("remote")
					&& browser.equalsIgnoreCase("firefox")) {
				driver = new RemoteWebDriver(new URL(
						"http://127.0.0.1:4444/wd/hub"),
						DesiredCapabilities.firefox());
			} else if (remoteOrLocal.equalsIgnoreCase("local")
					&& browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						Locators.driverFileDir + "chromedriver.exe");
				driver = new ChromeDriver();
			} else if (remoteOrLocal.equalsIgnoreCase("remote")
					&& browser.equalsIgnoreCase("chrome")) {
				driver = new RemoteWebDriver(new URL(
						"http://127.0.0.1:4444/wd/hub"),
						DesiredCapabilities.chrome());
			} else
				throw new IllegalArgumentException("input type not supported! ");
			return driver;
		} catch (WebDriverException e) {
			String browser = System.getProperty("Browser");
			if (browser.equalsIgnoreCase("firefox")) {
				driver = new RemoteWebDriver(new URL(
						"http://127.0.0.1:4444/wd/hub"),
						DesiredCapabilities.firefox());
			} else if (browser.equalsIgnoreCase("chrome")) {
				driver = new RemoteWebDriver(new URL(
						"http://127.0.0.1:4444/wd/hub"),
						DesiredCapabilities.chrome());
			}
			return driver;
		}
	}

	/**
	 * Print XML path
	 * 
	 * @throws IOException
	 */
	public void printXmlPath(StackTraceElement l) throws IOException {
		String packageNameOnly = l.getClassName().substring(0,
				l.getClassName().lastIndexOf("."));
		String classNameOnly = l.getClassName().substring(
				1 + l.getClassName().lastIndexOf("."),
				l.getClassName().length());
		String xml = "<class name=\"" + packageNameOnly + "." + classNameOnly
				+ "\"><methods><include name=\"" + l.getMethodName()
				+ "\"/></methods></class>";
		fileWriterPrinter("   XML Path: " + xml);
		// Renew XML record:
		fileCleaner("xml.path");
		fileWriter("xml.path", xml);
		// Renew Stack Trace Element record:
		fileCleaner("stack.trace");
		fileWriter("stack.trace", l);
		// Append a New Log record:
		if (fileExist("run.log")) {
			fileWriter("run.log", "   XML Path: " + xml);
		}
	}

	/*
	 * @throws IOException 
	 * @throws NumberFormatException
	 */
	public static Boolean fileExist(String fileName)
			throws NumberFormatException, IOException {
		File f = new File(Locators.testOutputFileDir + fileName);
		if (!(f.exists() && f.isFile())) {
			fileWriterPrinter(f + " is missing...");
		}
		return (f.exists() && f.isFile());
	}
	
	/*
	 * @throws IOException 
	 * @throws NumberFormatException
	 */
	public static Boolean fileExist(String path, String fileName)
			throws NumberFormatException, IOException {
		File f = new File(path + fileName);
		if (!(f.exists() && f.isFile())) {
			fileWriterPrinter(f + " is missing...");
		}
		return (f.exists() && f.isFile());
	}

	/*
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static Boolean fileExist(String fileName, Boolean silentMode)
			throws NumberFormatException, IOException {
		File f = new File(Locators.testOutputFileDir + fileName);
		if (!(f.exists() && f.isFile())) {
			if (silentMode) {
				fileWriterPrinter(f + " is missing...");
			}
		}
		return (f.exists() && f.isFile());
	}

	/**
	 * @throws IOException
	 * @throws NumberFormatException
	 */

	public static Boolean fileExist(String path, String fileName,
			Boolean silentMode) throws NumberFormatException, IOException {
		File f = new File(path + fileName);
		if (!(f.exists() && f.isFile())) {
			if (silentMode) {
				fileWriterPrinter(f + " is missing...");
			}
		}
		return (f.exists() && f.isFile());
	}

	/** Convert Date to long Milliseconds */
	public static long convertCalendarDateToMillisecondsAsLong(String stringDate)
			throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(stringDate);
		long mills = date.getTime();
		return mills;
	}

	/**
	 * Convert Date and Time list year, month, day, hours, minutes, seconds to
	 * long Milliseconds
	 */
	public static long convertCalendarIntDateTimeListToMillisecondsAsLong(
			String date, int hours, int min, int sec) throws ParseException {

		return convertCalendarDateToMillisecondsAsLong(date)
				+ ((hours * 3600) + (min * 60) + sec) * 1000;
	}

	/** Writes a String line into File */
	public static void fileWriter(String fileName, Object printLine)
			throws NumberFormatException, IOException {
		// Create File:
		File f = new File(Locators.testOutputFileDir + fileName);
		// Write or add a String line into File:
		FileWriter fw = new FileWriter(f, true);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(printLine);
		pw.close();
	}

	/** Writes an Object line into File */
	public static void fileWriter(String path, String fileName, Object printLine)
			throws NumberFormatException, IOException {
		// Create File:
		File f = new File(path + fileName);
		// Write or add a String line into File:
		FileWriter fw = new FileWriter(f, true);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(printLine);
		pw.close();
	}

	/**
	 * Writes an empty line into "print.log" File, as well as through System Out
	 * Print Line
	 */
	public static void fileWriterPrinter() throws NumberFormatException,
			IOException {
		// Create File:
		File f = new File(Locators.testOutputFileDir + "print.log");
		// Write or add a String line into File:
		FileWriter fw = new FileWriter(f, true);
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

	/**
	 * Writes an Object line into "print.log" File, as well as through System
	 * Out Print Line
	 */
	public static void fileWriterPrinter(Object printLine)
			throws NumberFormatException, IOException {
		// Create File:
		File f = new File(Locators.testOutputFileDir + "print.log");
		// Write or add a String line into File:
		FileWriter fw = new FileWriter(f, true);
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

	/**
	 * Writes an Object line into File, as well as through System Out Print Line
	 */
	public static void fileWriterPrinter(String fileName, Object printLine)
			throws NumberFormatException, IOException {
		// Create File:
		File f = new File(Locators.testOutputFileDir + fileName);
		// Write or add a String line into File:
		FileWriter fw = new FileWriter(f, true);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(printLine);
		pw.close();
		// System Out Print Line:
		fileWriterPrinter(printLine);
	}

	/**
	 * Writes an Object line into File, as well as through System Out Print Line
	 */
	public static void fileWriterPrinter(String path, String fileName,
			Object printLine) throws NumberFormatException, IOException {
		// Create File:
		File f = new File(path + fileName);
		// Write or add a String line into File:
		FileWriter fw = new FileWriter(f, true);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(printLine);
		pw.close();
		// System Out Print Line:
		fileWriterPrinter(printLine);
	}

	/**
	 * Writes an Object line into File, as well as through System Out Print Line
	 * by Choise (YES or NO)
	 */
	public static void fileWriterPrinter(String path, String fileName,
			Object printLine, Boolean ifPrint) throws NumberFormatException,
			IOException {
		// Create File:
		File f = new File(path + fileName);
		// Write or add a String line into File:
		FileWriter fw = new FileWriter(f, true);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(printLine);
		pw.close();
		// System Out Print Line:
		if (ifPrint) {
			fileWriterPrinter(printLine);
		}
	}

	/** Returns a String of n spaces long */
	public String padSpace(int n) {
		if (n < 0) {
			n = 0;
		}
		String s = "";
		for (int i = 0; i < n; i++) {
			s = s + " ";
		}
		return s;
	}

	/** Gets a String and returs it with added n leading spaces (to left) */
	public String padLeft(String s, int n) {
		if (n < 0) {
			n = 0;
		}
		if (s.equals(null)) {
			s = "";
		}
		for (int i = 0; i < n; i++) {
			s = " " + s;
		}
		return s;
	}

	/** Gets a String and returs it with added n spaces to right */
	public String padRight(String s, int n) {
		if (n < 0) {
			n = 0;
		}
		if (s.equals(null)) {
			s = "";
		}
		for (int i = 0; i < n; i++) {
			s = s + " ";
		}
		return s;
	}

	/**
	 * Detects if the entered Object is numeric, and if yes: ---> returns String
	 * value of #.### Format; ---> adds leading Spaces to match in-row of
	 * "###.###";
	 */
	public String padNum(Object o) {
		double d = 0;
		if (o instanceof Double) {
			d = Double.parseDouble((String) o.toString());
		}
		if (o instanceof String) {
			try {
				d = Double.parseDouble((String) o);
			} catch (NumberFormatException nfe) {
			}
		}
		if (o instanceof Integer) {
			d = Double.parseDouble((String) o.toString());
		}
		if (o instanceof Float) {
			d = new Double(o.toString());
		}
		String pad = "";
		if (d < 100) {
			pad = " ";
		}
		if (d < 10) {
			pad = "  ";
		}
		String s = pad + (new DecimalFormat("0.000").format(d)).toString();
		return s;
	}

	// ################# WAIT UNTIL URL CHANGE START #################
	public void waitUntilUrl(WebDriver driver, String previousURL)
			throws NumberFormatException, IOException {
		long start = System.currentTimeMillis();
		final String oldURL = previousURL.toLowerCase();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (driver.getCurrentUrl() != oldURL);
			}
		};
		wait.until(e);
		fileWriterPrinter("Waiting time for New URL:"
				+ padSpace(58 - "Waiting time for New URL:".length())
				+ waitTimeConroller(start, 30, driver.getCurrentUrl()) + " sec");
	}

	public void waitUntilUrl(WebDriver driver, int seconds, String previousURL)
			throws NumberFormatException, IOException {
		long start = System.currentTimeMillis();
		final String oldURL = previousURL.toLowerCase();
		fileWriterPrinter("\nOld URL: " + oldURL);
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (driver.getCurrentUrl() != oldURL);
			}
		};
		wait.until(e);
		fileWriterPrinter("New URL: " + driver.getCurrentUrl());
		fileWriterPrinter("Waiting time for New URL:"
				+ padSpace(58 - "Waiting time for New URL:".length())
				+ waitTimeConroller(start, seconds, driver.getCurrentUrl())
				+ " sec");
	}

	public void waitUntilUrl(WebDriver driver, int seconds, String previousURL,
			Boolean ifPrompt) throws NumberFormatException, IOException {
		long start = System.currentTimeMillis();
		final String oldURL = previousURL.toLowerCase();
		if (ifPrompt) {
			fileWriterPrinter("\nOld URL: " + oldURL);
		}
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (driver.getCurrentUrl() != oldURL);
			}
		};
		wait.until(e);
		if (ifPrompt) {
			fileWriterPrinter("New URL: " + driver.getCurrentUrl());
			fileWriterPrinter("Waiting time for New URL:"
					+ padSpace(58 - "Waiting time for New URL:".length())
					+ waitTimeConroller(start, seconds, driver.getCurrentUrl())
					+ " sec");
		}
	}

	// ################# WAIT UNTIL URL CHANGE END #################

	// ################# WAIT TIME CALCULATOR ################
	/**
	 * Calculates waiting time from "START" till now; Returnd difference as
	 * Double Milliseconds;
	 */
	public Double waitTimeCalculatior(long start) {
		double difference = (System.currentTimeMillis() - start);
		return difference;
	}

	/**
	 * Calculates waiting time from "START" till now; Returnd difference as
	 * Double Seconds;
	 * 
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public String waitTimeConroller(long start) throws NumberFormatException,
			IOException {
		double sec = waitTimeCalculatior(start) / 1000;
		long testStart = convertStringToLong(fileScanner("start.time"));
		int limit = 0;

		if ((sec >= 15) && (sec < 30)) {
			limit = 15;
		}
		if ((sec >= 30) && (sec < 60)) {
			limit = 30;
		}
		if (sec >= 60) {
			limit = 60;
		}

		if (sec >= 15) {
			fileWriterPrinter("Waiting time exceeded limit of "
					+ new DecimalFormat("0.000").format(limit) + " seconds!");
			fileWriter("wait.log", "       Test: #" + fileScanner("test.num"));
			fileWriter(
					"wait.log",
					"    Started: "
							+ convertCalendarMillisecondsAsLongToDateTimeHourMinSec(testStart));
			fileWriter(
					"wait.log",
					"      Event: "
							+ convertCalendarMillisecondsAsLongToDateTimeHourMinSec(start));
			fileWriter("wait.log", "   XML Path: " + fileScanner("xml.path"));
			fileWriter("wait.log", "             Waiting time is " + sec
					+ " sec, which exceeds limit of "
					+ new DecimalFormat("0.000").format(limit) + " seconds!");
			fileWriterPrinter("wait.log", "");
		}
		return padNum(sec);
	}

	/**
	 * Calculates waiting time from "START" till now; Returnd difference as
	 * Double Seconds;
	 * 
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public String waitTimeConroller(long start, String elementName)
			throws NumberFormatException, IOException {
		double sec = waitTimeCalculatior(start) / 1000;
		long testStart = convertStringToLong(fileScanner("start.time"));
		int limit = 0;

		if ((sec >= 15) && (sec < 30)) {
			limit = 15;
		}
		if ((sec >= 30) && (sec < 60)) {
			limit = 30;
		}
		if (sec >= 60) {
			limit = 60;
		}

		if (sec >= 15) {
			fileWriterPrinter("Waiting time exceeded limit of "
					+ new DecimalFormat("0.000").format(limit) + " seconds!");
			fileWriter("wait.log", "       Test: #" + fileScanner("test.num"));
			fileWriter(
					"wait.log",
					"    Started: "
							+ convertCalendarMillisecondsAsLongToDateTimeHourMinSec(testStart));
			fileWriter(
					"wait.log",
					"      Event: "
							+ convertCalendarMillisecondsAsLongToDateTimeHourMinSec(start));
			fileWriter("wait.log", "   XML Path: " + fileScanner("xml.path"));
			fileWriter("wait.log", "             Waiting " + sec + " sec for "
					+ elementName + ", which exceeds limit of "
					+ new DecimalFormat("0.000").format(limit) + " seconds!");
			fileWriterPrinter("wait.log", "");
		}
		return padNum(sec);
	}

	/**
	 * Calculates waiting time from "START" till now; Returnd difference as
	 * Double Seconds;
	 * 
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public String waitTimeConroller(long start, int limit, String elementName)
			throws NumberFormatException, IOException {
		double sec = waitTimeCalculatior(start) / 1000;
		long testStart = convertStringToLong(fileScanner("start.time"));

		if ((sec >= limit) && (sec >= 15)) {
			fileWriterPrinter("Waiting time exceeded limit of "
					+ new DecimalFormat("0.000").format(limit) + " seconds!");
			fileWriter("wait.log", "       Test: #" + fileScanner("test.num"));
			fileWriter(
					"wait.log",
					"    Started: "
							+ convertCalendarMillisecondsAsLongToDateTimeHourMinSec(testStart));
			fileWriter(
					"wait.log",
					"      Event: "
							+ convertCalendarMillisecondsAsLongToDateTimeHourMinSec(start));
			fileWriter("wait.log", "   XML Path: " + fileScanner("xml.path"));
			fileWriter("wait.log", "             Waiting " + sec + " sec for "
					+ elementName + ", which exceeds limit of "
					+ new DecimalFormat("0.000").format(limit) + " seconds!");
			fileWriterPrinter("wait.log", "");
		}
		return padNum(sec);
	}

	// ################# TIME CALCULATOR END ##########################

	// ################# GET URL WAIT UNTIL CHANGE START ################
	public void getUrlWaitUntil(WebDriver driver, int seconds, String newURL)
			throws NumberFormatException, IOException {
		final String previousURL = driver.getCurrentUrl();
		final String URL = newURL.toLowerCase();

		// First (initial) connection:
		int i = 1;
		int s = 1;
		// driver.get(URL);
		// waitUntilUrl(driver, seconds, previousURL);
		long start = System.currentTimeMillis();

		// "Try Again" connection manager, if required (up to 10 times):
		String xpathTryAgainButton = "//*[contains(@id,'error')][@id='errorTryAgain'][text()='Try Again']";
		// List<WebElement> list; int s = list.size(); int s =
		// driver.findElements(By.xpath(xpathTryAgainButton)).size();
		while ((s > 0) && (i <= 10)) {
			driver.get(URL);
			waitUntilUrl(driver, seconds, previousURL);
			s = driver.findElements(By.xpath(xpathTryAgainButton)).size();
			if (s > 0) {
				i = i + 1;
			}
		}
		if (i > 1) {
			fileWriterPrinter("Try Again   attempts: " + i);
			fileWriterPrinter("Try Again time spent: "
					+ waitTimeConroller(start, seconds, newURL) + " sec\n");
		}
	}

	public void getUrlWaitUntil(WebDriver driver, int seconds, String newURL,
			Boolean ifPrompt) throws NumberFormatException, IOException {
		final String previousURL = driver.getCurrentUrl();
		final String URL = newURL.toLowerCase();

		// First (initial) connection:
		int i = 1;
		int s = 1;
		// driver.get(URL);
		// waitUntilUrl(driver, seconds, previousURL);
		long start = System.currentTimeMillis();

		// "Try Again" connection manager, if required (up to 10 times):
		String xpathTryAgainButton = "//*[contains(@id,'error')][@id='errorTryAgain'][text()='Try Again']";
		// List<WebElement> list; int s = list.size(); int s =
		// driver.findElements(By.xpath(xpathTryAgainButton)).size();
		while ((s > 0) && (i <= 10)) {
			driver.get(URL);
			waitUntilUrl(driver, seconds, previousURL, ifPrompt);
			s = driver.findElements(By.xpath(xpathTryAgainButton)).size();
			if (s > 0) {
				i = i + 1;
			}
		}
		if (i > 1) {
			fileWriterPrinter("Try Again   attempts: " + i);
			fileWriterPrinter("Try Again time spent: "
					+ waitTimeConroller(start, seconds, newURL) + " sec\n");
		}
	}

	// ################# GET URL WAIT UNTIL CHANGE END #################

	public String getUrlSourcePage(String url) throws IOException {
		URL URL = new URL(url);
		URLConnection uc = URL.openConnection();

		// allow GZip encodings
		// the encoding type
		BufferedReader in = null;
		if (uc.getHeaderField("Content-Encoding") != null
				&& uc.getHeaderField("Content-Encoding").equals("gzip")) {
			in = new BufferedReader(new InputStreamReader(new GZIPInputStream(
					uc.getInputStream())));
		} else {
			in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		}

		String inputLine;
		StringBuilder sb = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			sb.append(inputLine);
		in.close();

		return sb.toString();
	}

	@SuppressWarnings("static-access")
	public String getUrlSourcePagePrint(String url) throws IOException {
		URL URL = new URL(url);
		HttpURLConnection uc = (HttpURLConnection) URL.openConnection(); // Cast
																			// shouldn't
																			// fail
		uc.setFollowRedirects(true);

		// allow both GZip and Deflate (ZLib) encodings
		uc.setRequestProperty("Accept-Encoding", "gzip, deflate");
		String encoding = uc.getContentEncoding();

		// the encoding type
		BufferedReader in = null;
		if (encoding != null && encoding.equalsIgnoreCase("gzip")) {
			in = new BufferedReader(new InputStreamReader(new GZIPInputStream(
					uc.getInputStream())));
		} else if (encoding != null && encoding.equalsIgnoreCase("deflate")) {
			in = new BufferedReader(new InputStreamReader(
					new InflaterInputStream(uc.getInputStream(), new Inflater(
							true))));
		} else {
			in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		}

		String inputLine;
		StringBuilder sb = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			sb.append(inputLine);
		in.close();

		fileCleaner("source.html");
		fileWriterPrinter("source.html", sb.toString());

		return sb.toString();
	}

	@SuppressWarnings("static-access")
	public String getUrlSourcePagePrint(String url, String filename)
			throws IOException {
		URL URL = new URL(url);
		HttpURLConnection uc = (HttpURLConnection) URL.openConnection(); // Cast
																			// shouldn't
																			// fail
		uc.setFollowRedirects(true);

		// allow both GZip and Deflate (ZLib) encodings
		uc.setRequestProperty("Accept-Encoding", "gzip, deflate");
		String encoding = uc.getContentEncoding();

		// the encoding type
		BufferedReader in = null;
		if (encoding != null && encoding.equalsIgnoreCase("gzip")) {
			in = new BufferedReader(new InputStreamReader(new GZIPInputStream(
					uc.getInputStream())));
		} else if (encoding != null && encoding.equalsIgnoreCase("deflate")) {
			in = new BufferedReader(new InputStreamReader(
					new InflaterInputStream(uc.getInputStream(), new Inflater(
							true))));
		} else {
			in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		}

		String inputLine;
		StringBuilder sb = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			sb.append(inputLine);
		in.close();

		fileCleaner(filename);
		fileWriterPrinter(filename, sb.toString());

		return sb.toString();
	}

	@SuppressWarnings("static-access")
	public String getUrlSourcePagePrint(String url, String path, String fileName)
			throws IOException {
		URL URL = new URL(url);
		HttpURLConnection uc = (HttpURLConnection) URL.openConnection(); // Cast
																			// shouldn't
																			// fail
		uc.setFollowRedirects(true);

		// allow both GZip and Deflate (ZLib) encodings
		uc.setRequestProperty("Accept-Encoding", "gzip, deflate");
		String encoding = uc.getContentEncoding();

		// the encoding type
		BufferedReader in = null;
		if (encoding != null && encoding.equalsIgnoreCase("gzip")) {
			in = new BufferedReader(new InputStreamReader(new GZIPInputStream(
					uc.getInputStream())));
		} else if (encoding != null && encoding.equalsIgnoreCase("deflate")) {
			in = new BufferedReader(new InputStreamReader(
					new InflaterInputStream(uc.getInputStream(), new Inflater(
							true))));
		} else {
			in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		}

		String inputLine;
		StringBuilder sb = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			sb.append(inputLine);
		in.close();

		fileCleaner(fileName);
		// fileWriterPrinter(path, fileName, sb.toString());
		fileWriterPrinter(path, fileName, sb.toString(), false);
		return sb.toString();
	}

	@SuppressWarnings("static-access")
	public String getUrlSourcePagePrint(String url, String path,
			String fileName, String extention) throws IOException {
		URL URL = new URL(url);
		HttpURLConnection uc = (HttpURLConnection) URL.openConnection(); // Cast
																			// shouldn't
																			// fail
		uc.setFollowRedirects(true);

		// allow both GZip and Deflate (ZLib) encodings
		uc.setRequestProperty("Accept-Encoding", "gzip, deflate");
		String encoding = uc.getContentEncoding();

		// the encoding type
		BufferedReader in = null;
		if (encoding != null && encoding.equalsIgnoreCase("gzip")) {
			in = new BufferedReader(new InputStreamReader(new GZIPInputStream(
					uc.getInputStream())));
		} else if (encoding != null && encoding.equalsIgnoreCase("deflate")) {
			in = new BufferedReader(new InputStreamReader(
					new InflaterInputStream(uc.getInputStream(), new Inflater(
							true))));
		} else {
			in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		}

		String inputLine;
		StringBuilder sb = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			sb.append(inputLine);
		in.close();

		fileCleaner(fileName);
		fileWriterPrinter(path, (fileName + "." + extention), sb.toString());

		return sb.toString();
	}
	
	/**
	 * Gets the URL Sourse Code and saves as a file
	 * Won't use WebDriver driver
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public String getUrlPageSourceSave(String sourseURL) throws NumberFormatException, IOException {
		
	    URL url;
	    URLConnection connection;
	    BufferedReader reader;
	    String line;
	    StringBuilder sbResponse;
	    String sResponse = null;

	    try {
	        url = new URL(sourseURL);
	        connection = url.openConnection();
	        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        sbResponse = new StringBuilder();

	        while((line = reader.readLine()) != null)  { sbResponse.append(line); }
	        sResponse = sbResponse.toString();
	        return sResponse;
	        }
	    catch(Exception e) {
	    	/** e.printStackTrace(); */ 
	    	String error = null;
	    	try { error = e.toString().substring(e.toString().indexOf(": ") + 2, e.toString().indexOf(" for URL")); } catch (Exception exception) { }
	    	fileCleaner("error.log");
	    	if(error.length() > 0) { fileWriter("error.log", error + ", " + sourseURL); }
	    	else { fileWriter("error.log", sourseURL); }
	    	return null;
	    	}
	}
	
	/**
	 * Gets the URL Sourse Code and saves as a file
	 * Won't use WebDriver driver
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public String getUrlPageSourceSave(String sourseURL, String fileName) throws NumberFormatException, IOException {
		
		fileCleaner(fileName);
	    URL url;
	    URLConnection connection;
	    BufferedReader reader;
	    String line;
	    StringBuilder sbResponse;
	    String sResponse = null;

	    try {
	        url = new URL(sourseURL);
	        connection = url.openConnection();
	        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        sbResponse = new StringBuilder();

	        while((line = reader.readLine()) != null)
	        {
	        	sbResponse.append(line);
	        	fileWriter(fileName, line);      	
	        }
	        sResponse = sbResponse.toString();
	        return sResponse;
	        }
	    catch(Exception e) {
	    	/** e.printStackTrace(); */ 
	    	String error = null;
	    	try { error = e.toString().substring(e.toString().indexOf(": ") + 2, e.toString().indexOf(" for URL")); } catch (Exception exception) { }
	    	fileCleaner("error.log");
	    	if(error.length() > 0) { fileWriter("error.log", error + ", " + sourseURL); }
	    	else { fileWriter("error.log", sourseURL); }
	    	return null;
	    	}
	}
	
	/**
	 * Gets the URL Sourse Code and saves as a file
	 * Won't use WebDriver driver
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public String getUrlPageSourceSave(String sourseURL, String path, String fileName) throws NumberFormatException, IOException {
		
		fileCleaner(path, fileName);
	    URL url;
	    URLConnection connection;
	    BufferedReader reader;
	    String line;
	    StringBuilder sbResponse;
	    String sResponse = null;

	    try {
	        url = new URL(sourseURL);
	        connection = url.openConnection();
	        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        sbResponse = new StringBuilder();

	        while((line = reader.readLine()) != null)
	        {
	        	sbResponse.append(line);
	        	fileWriter(path, fileName, line);
	        }
	        sResponse = sbResponse.toString();
	        return sResponse;
	        }
	    catch(Exception e) {
	    	/** e.printStackTrace(); */ 
	    	String error = null;
	    	try { 
	    		if (e.toString().contains(":") && e.toString().contains("for URL")){
	    		error = e.toString().substring(e.toString().indexOf(": ") + 2, e.toString().indexOf(" for URL"));
	    		}
	    		} catch (Exception exception) { }
	    	fileCleaner("error.log");
	    	if(error.length() > 0) { fileWriter("error.log", error + ", " + sourseURL); }
	    	else { fileWriter("error.log", sourseURL); }
	    	return null;
	    	}
	}

	/**
	 * Gets the URL Sourse Code, saves as a file, and prints it out
	 * Won't use WebDriver driver
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public String getUrlPageSourcePrint(String sourseURL, String fileName) throws NumberFormatException, IOException {
		
		fileCleaner(fileName);
	    URL url;
	    URLConnection connection;
	    BufferedReader reader;
	    String line;
	    StringBuilder sbResponse;
	    String sResponse = null;

	    try {
	        url = new URL(sourseURL);
	        connection = url.openConnection();
	        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        sbResponse = new StringBuilder();

	        while((line = reader.readLine()) != null)
	        {
	        	sbResponse.append(line);
	        	fileWriterPrinter(fileName, line);      	
	        }
	        sResponse = sbResponse.toString();
	        return sResponse;
	        }
	    catch(Exception e) {
	    	/** e.printStackTrace(); */ 
	    	String error = null;
	    	try { error = e.toString().substring(e.toString().indexOf(": ") + 2, e.toString().indexOf(" for URL")); } catch (Exception exception) { }
	    	fileCleaner("error.log");
	    	if(error.length() > 0) { fileWriter("error.log", error + ", " + sourseURL); }
	    	else { fileWriter("error.log", sourseURL); }
	    	return null;
	    	}
	}
	
	/**
	 * Gets the URL Sourse Code, saves as a file, and prints it out
	 * Won't use WebDriver driver
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public String getUrlPageSourcePrint(String sourseURL, String path, String fileName) throws NumberFormatException, IOException {
		
		fileCleaner(path, fileName);
	    URL url;
	    URLConnection connection;
	    BufferedReader reader;
	    String line;
	    StringBuilder sbResponse;
	    String sResponse = null;

	    try {
	        url = new URL(sourseURL);
	        connection = url.openConnection();
	        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        sbResponse = new StringBuilder();

	        while((line = reader.readLine()) != null)
	        {
	        	sbResponse.append(line);
	        	fileWriterPrinter(path, fileName, line);
	        }
	        sResponse = sbResponse.toString();
	        return sResponse;
	        }
	    catch(Exception e) {
	    	/** e.printStackTrace(); */ 
	    	String error = null;
	    	try { error = e.toString().substring(e.toString().indexOf(": ") + 2, e.toString().indexOf(" for URL")); } catch (Exception exception) { }
	    	fileCleaner("error.log");
	    	if(error.length() > 0) { fileWriter("error.log", error + ", " + sourseURL); }
	    	else { fileWriter("error.log", sourseURL); }
	    	return null;
	    	}
	}
	
	/**
	 * Gets the first (main) line of any thrown Exception Message Regardless is this a single or multi-line Prompt
	 * Uses user defined WebDriver driver over user-opened URL
	 * 
	 * @param e
	 */
	public static void getExceptionDescriptive(Exception e, StackTraceElement l, WebDriver driver) throws IOException {
		String message1 = null;
		try {
			message1 = e.getCause().toString();
		} catch (NullPointerException e1) {
			message1 = ".getCause() by NullPointerException:";
		} finally {
			String message2 = e.getMessage();
			String[] multiline1 = message1.replaceAll("\\r", "").split("\\n");
			String[] multiline2 = message2.replaceAll("\\r", "").split("\\n");
			String firstLine = multiline1[0];
			String secondLine = multiline2[0];
			String errorCause = firstLine.substring(0, firstLine.indexOf(":"));
			String exceptionThrown = errorCause.substring(
					1 + errorCause.lastIndexOf("."), errorCause.length());
			String packageNameOnly = l.getClassName().substring(0,
					l.getClassName().lastIndexOf("."));
			String classNameOnly = l.getClassName().substring(
					1 + l.getClassName().lastIndexOf("."),
					l.getClassName().length());
			String location = packageNameOnly + File.separator + classNameOnly
					+ File.separator + l.getMethodName() + ", line # "
					+ l.getLineNumber();
			String xml = "<class name=\"" + packageNameOnly + "."
					+ classNameOnly + "\"><methods><include name=\""
					+ l.getMethodName() + "\"/></methods></class>";
			String description = exceptionThrown;
			String detected = getCurrentDateTimeFull();
			String runtime = testRunTime("start.time",
					System.currentTimeMillis());
			String subtotal = testRunTime("ini.time",
					System.currentTimeMillis());
			fileWriterPrinter("\nError Cause: ---> " + errorCause
					+ "\nDescription: ---> " + secondLine
					+ "\n   Location: ---> " + location);
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
			fileWriter("failed.log", "    Failure: #"
					+ fileScanner("failed.num"));
			fileWriter("failed.log", "       Test: #" + fileScanner("test.num"));
			fileWriter(
					"failed.log",
					"      Start: "
							+ convertCalendarMillisecondsAsStringToDateTimeHourMinSec(fileScanner("start.time")));
			fileWriter("failed.log", "   XML Path: " + xml);
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
					+ "\n     Subtotal: ---> " + subtotal + "\n" + xml + "\n"
					+ "\nStack Traces:");
		}
	}
	
	/**
	 * Gets the first (main) line of any thrown Exception Message Regardless is this a single or multi-line Prompt
	 * Uses independent WebDriver driver;
	 * Opens user defined URL
	 * @param e
	 * @throws InterruptedException 
	 */
	public void getExceptionDescriptive(Exception e, StackTraceElement l, String url) throws IOException, InterruptedException {
		WebDriver driver = null;
		driver = getServerName(driver);
		getUrlWaitUntil(driver, 30, url);
		String message1 = null;
		try {
			message1 = e.getCause().toString();
		} catch (NullPointerException e1) {
			message1 = ".getCause() by NullPointerException:";
		} finally {
			String message2 = e.getMessage();
			String[] multiline1 = message1.replaceAll("\\r", "").split("\\n");
			String[] multiline2 = message2.replaceAll("\\r", "").split("\\n");
			String firstLine = multiline1[0];
			String secondLine = multiline2[0];
			String errorCause = firstLine.substring(0, firstLine.indexOf(":"));
			String exceptionThrown = errorCause.substring(
					1 + errorCause.lastIndexOf("."), errorCause.length());
			String packageNameOnly = l.getClassName().substring(0,
					l.getClassName().lastIndexOf("."));
			String classNameOnly = l.getClassName().substring(
					1 + l.getClassName().lastIndexOf("."),
					l.getClassName().length());
			String location = packageNameOnly + File.separator + classNameOnly
					+ File.separator + l.getMethodName() + ", line # "
					+ l.getLineNumber();
			String xml = "<class name=\"" + packageNameOnly + "."
					+ classNameOnly + "\"><methods><include name=\""
					+ l.getMethodName() + "\"/></methods></class>";
			String description = exceptionThrown;
			String detected = getCurrentDateTimeFull();
			String runtime = testRunTime("start.time",
					System.currentTimeMillis());
			String subtotal = testRunTime("ini.time",
					System.currentTimeMillis());
			fileWriterPrinter("\nError Cause: ---> " + errorCause
					+ "\nDescription: ---> " + secondLine
					+ "\n   Location: ---> " + location);
			getScreenShot(l, description, driver);
			driver.close();
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
			fileWriter("failed.log", "    Failure: #"
					+ fileScanner("failed.num"));
			fileWriter("failed.log", "       Test: #" + fileScanner("test.num"));
			fileWriter(
					"failed.log",
					"      Start: "
							+ convertCalendarMillisecondsAsStringToDateTimeHourMinSec(fileScanner("start.time")));
			fileWriter("failed.log", "   XML Path: " + xml);
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
					+ "\n     Subtotal: ---> " + subtotal + "\n" + xml + "\n"
					+ "\nStack Traces:");
		}
	}
	
	/**
	 * Gets the first (main) line of any thrown Exception Message Regardless is this a single or multi-line Prompt
	 * Won't use WebDriver driver;
	 * Opens user defined URL
	 * @param e
	 * @throws InterruptedException 
	 */
	public void getExceptionDescriptive(Exception e, StackTraceElement l) throws IOException, InterruptedException {
		String message1 = null;
		try {
			message1 = e.getCause().toString();
		} catch (NullPointerException e1) {
			message1 = ".getCause() by NullPointerException:";
		} finally {
			String message2 = e.getMessage();
			String[] multiline1 = message1.replaceAll("\\r", "").split("\\n");
			String[] multiline2 = message2.replaceAll("\\r", "").split("\\n");
			String firstLine = multiline1[0];
			String secondLine = multiline2[0];
			String errorCause = firstLine.substring(0, firstLine.indexOf(":"));
			// String exceptionThrown = errorCause.substring( 1 + errorCause.lastIndexOf("."), errorCause.length());
			String packageNameOnly = l.getClassName().substring(0,
					l.getClassName().lastIndexOf("."));
			String classNameOnly = l.getClassName().substring(
					1 + l.getClassName().lastIndexOf("."),
					l.getClassName().length());
			String location = packageNameOnly + File.separator + classNameOnly
					+ File.separator + l.getMethodName() + ", line # "
					+ l.getLineNumber();
			String xml = "<class name=\"" + packageNameOnly + "."
					+ classNameOnly + "\"><methods><include name=\""
					+ l.getMethodName() + "\"/></methods></class>";
			// String description = exceptionThrown;
			String detected = getCurrentDateTimeFull();
			String runtime = testRunTime("start.time",
					System.currentTimeMillis());
			String subtotal = testRunTime("ini.time",
					System.currentTimeMillis());
			fileWriterPrinter("\nError Cause: ---> " + errorCause
					+ "\nDescription: ---> " + secondLine
					+ "\n   Location: ---> " + location);
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
			fileWriter("failed.log", "    Failure: #"
					+ fileScanner("failed.num"));
			fileWriter("failed.log", "       Test: #" + fileScanner("test.num"));
			fileWriter(
					"failed.log",
					"      Start: "
							+ convertCalendarMillisecondsAsStringToDateTimeHourMinSec(fileScanner("start.time")));
			fileWriter("failed.log", "   XML Path: " + xml);
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
					+ "\n     Subtotal: ---> " + subtotal + "\n" + xml + "\n"
					+ "\nStack Traces:");
		}
	}
	
	/**
	 * "AssertTrue" with Screen-Shot and descriptive Error Message
	 * Screenshot-Disabled
	 * @param e
	 */
	public String getAssertTrue(StackTraceElement l, String description, Boolean b) throws IOException {

		String packageNameOnly = l.getClassName().substring(0,
				l.getClassName().lastIndexOf("."));
		String classNameOnly = l.getClassName().substring(
				1 + l.getClassName().lastIndexOf("."),
				l.getClassName().length());
		String location = packageNameOnly + File.separator + classNameOnly
				+ File.separator + l.getMethodName() + ", line # "
				+ l.getLineNumber();
		String xml = "<class name=\"" + packageNameOnly + "." + classNameOnly
				+ "\"><methods><include name=\"" + l.getMethodName()
				+ "\"/></methods></class>";
		String detected = getCurrentDateTimeFull();
		String runtime = testRunTime("start.time", System.currentTimeMillis());
		String subtotal = testRunTime("ini.time", System.currentTimeMillis());
		if (b == false) {
			fileWriterPrinter("\nError Cause: ---> " + description
					+ "\n   Location: ---> " + location
					+ "\n   Expected: ---> " + "true" + "\n     Actual: ---> "
					+ b + "\n");

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
			fileWriter("failed.log", "    Failure: #"
					+ fileScanner("failed.num"));
			fileWriter("failed.log", "       Test: #" + fileScanner("test.num"));
			fileWriter(
					"failed.log",
					"      Start: "
							+ convertCalendarMillisecondsAsStringToDateTimeHourMinSec(fileScanner("start.time")));
			fileWriter("failed.log", "   XML Path: " + xml);
			fileWriter("failed.log", "Error Cause: ---> " + description);
			fileWriter("failed.log", "   Location: ---> " + location);
			fileWriter("failed.log", "   Expected: ---> " + "true");
			fileWriter("failed.log", "     Actual: ---> " + b);
			fileWriter("failed.log", "   Detected: " + detected);
			fileWriter("failed.log", "    Runtime: " + runtime);
			fileWriter("failed.log", "   Subtotal: " + subtotal);
			fileWriter("failed.log", "");
		} else {
			fileWriterPrinter("\nExpected: " + true + "\n  Actual: " + b
					+ "\n  Result: OK\n");
		}
		// Descriptive record output:
		return "\nError Cause: ---> " + description + "\n   Location: ---> "
				+ location + "\n   Expected: ---> " + "true"
				+ "\n     Actual: ---> " + b + "\n   Detected: ---> "
				+ detected + "\n    Runtime: ---> " + runtime
				+ "\n   Subtotal: ---> " + subtotal + "\n" + xml + "\n"
				+ "\nStack Traces:";
	}
	
	/**
	 * "AssertTrue" with Screen-Shot and descriptive Error Message
	 * Screenshot-Disabled
	 * @param e
	 */
	public String getAssertTrue(StackTraceElement l, String description, Boolean b, String url) throws IOException {

		String packageNameOnly = l.getClassName().substring(0,
				l.getClassName().lastIndexOf("."));
		String classNameOnly = l.getClassName().substring(
				1 + l.getClassName().lastIndexOf("."),
				l.getClassName().length());
		String location = packageNameOnly + File.separator + classNameOnly
				+ File.separator + l.getMethodName() + ", line # "
				+ l.getLineNumber();
		String xml = "<class name=\"" + packageNameOnly + "." + classNameOnly
				+ "\"><methods><include name=\"" + l.getMethodName()
				+ "\"/></methods></class>";
		String detected = getCurrentDateTimeFull();
		String runtime = testRunTime("start.time", System.currentTimeMillis());
		String subtotal = testRunTime("ini.time", System.currentTimeMillis());
		if (b == false) {
			fileWriterPrinter("\nError Cause: ---> " + description
					+ "\n        URL: ---> " + url
					+ "\n   Location: ---> " + location
					+ "\n   Expected: ---> " + "true" + "\n     Actual: ---> "
					+ b + "\n");

			// Creating New or Updating existing Failed Counter record:
			counter("failed.num");
			// Append a New Log record:
			if (fileExist("run.log")) {
				fileWriter("run.log", "    Failure: #" + fileScanner("failed.num"));
				fileWriter("run.log", "Error Cause: ---> " + description);
				fileWriter("run.log", "        URL: ---> " + url);
				fileWriter("run.log", "   Location: ---> " + location);
				fileWriter("run.log", "   Expected: ---> " + "true");
				fileWriter("run.log", "     Actual: ---> " + b);
				fileWriter("run.log", "");
				// fileWriter("run.log", "   Detected: ---> " + detected);
				// fileWriter("run.log", "    Runtime: ---> " + runtime);
				// fileWriter("run.log", "   Subtotal: ---> " + subtotal);
			}
			// Append an Error record:
			fileWriter("failed.log", "    Failure: #" + fileScanner("failed.num"));
			fileWriter("failed.log", "       Test: #" + fileScanner("test.num"));
			fileWriter("failed.log", "      Start: " + convertCalendarMillisecondsAsStringToDateTimeHourMinSec(fileScanner("start.time")));
			fileWriter("failed.log", "   XML Path: " + xml);
			fileWriter("failed.log", "Error Cause: ---> " + description);
			fileWriter("failed.log", "        URL: ---> " + url);
			fileWriter("failed.log", "   Location: ---> " + location);
			fileWriter("failed.log", "   Expected: ---> " + "true");
			fileWriter("failed.log", "     Actual: ---> " + b);
            if(fileExist("record.log")) { fileWriter("failed.log", fileScanner("record.log")); fileCleaner("record.log");}
			fileWriter("failed.log", "   Detected: " + detected);
			fileWriter("failed.log", "    Runtime: " + runtime);
			fileWriter("failed.log", "   Subtotal: " + subtotal);
			fileWriter("failed.log", "\n\n");	
		} else {
			fileWriterPrinter("\nExpected: " + true + "\n  Actual: " + b
					+ "\n  Result: OK\n");
		}
		// Descriptive record output:
		return "\nError Cause: ---> " + description +
			   "\n        URL: ---> " + url +
			   "\n   Location: ---> " + location +
			   "\n   Expected: ---> " + "true" +
			   "\n     Actual: ---> " + b +
			   "\n   Detected: ---> " + detected +
			   "\n    Runtime: ---> " + runtime +
			   "\n   Subtotal: ---> " + subtotal +
			   "\n" + xml + "\n"+
			   "\nStack Traces:";
	}
	
	/**
	 * "AssertTrue" with Screen-Shot and descriptive Error Message
	 * Uses independent WebDriver driver by opening user defined URL
	 * @param e
	 * @throws InterruptedException 
	 */
	public String getAssertTrue(StackTraceElement l, String url, String description, Boolean b) throws IOException, InterruptedException {

		String packageNameOnly = l.getClassName().substring(0,
				l.getClassName().lastIndexOf("."));
		String classNameOnly = l.getClassName().substring(
				1 + l.getClassName().lastIndexOf("."),
				l.getClassName().length());
		String location = packageNameOnly + File.separator + classNameOnly
				+ File.separator + l.getMethodName() + ", line # "
				+ l.getLineNumber();
		String xml = "<class name=\"" + packageNameOnly + "." + classNameOnly
				+ "\"><methods><include name=\"" + l.getMethodName()
				+ "\"/></methods></class>";
		String detected = getCurrentDateTimeFull();
		String runtime = testRunTime("start.time", System.currentTimeMillis());
		String subtotal = testRunTime("ini.time", System.currentTimeMillis());
		if (b == false) {
			fileWriterPrinter("\nError Cause: ---> " + description
					+ "\n   Location: ---> " + location
					+ "\n   Expected: ---> " + "true" + "\n     Actual: ---> "
					+ b + "\n");
			
			if(!b){
				WebDriver driver = null;
				driver = getServerName(driver);
				getUrlWaitUntil(driver, 30, url);
				getScreenShot(l, description, driver);
				driver.close();
				}

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
			fileWriter("failed.log", "    Failure: #"
					+ fileScanner("failed.num"));
			fileWriter("failed.log", "       Test: #" + fileScanner("test.num"));
			fileWriter(
					"failed.log",
					"      Start: "
							+ convertCalendarMillisecondsAsStringToDateTimeHourMinSec(fileScanner("start.time")));
			fileWriter("failed.log", "   XML Path: " + xml);
			fileWriter("failed.log", "Error Cause: ---> " + description);
			fileWriter("failed.log", "   Location: ---> " + location);
			fileWriter("failed.log", "   Expected: ---> " + "true");
			fileWriter("failed.log", "     Actual: ---> " + b);
			fileWriter("failed.log", "   Detected: " + detected);
			fileWriter("failed.log", "    Runtime: " + runtime);
			fileWriter("failed.log", "   Subtotal: " + subtotal);
			fileWriter("failed.log", "");
		} else {
			fileWriterPrinter("\nExpected: " + true + "\n  Actual: " + b
					+ "\n  Result: OK\n");
		}
		// Descriptive record output:
		return "\nError Cause: ---> " + description + "\n   Location: ---> "
				+ location + "\n   Expected: ---> " + "true"
				+ "\n     Actual: ---> " + b + "\n   Detected: ---> "
				+ detected + "\n    Runtime: ---> " + runtime
				+ "\n   Subtotal: ---> " + subtotal + "\n" + xml + "\n"
				+ "\nStack Traces:";
	}
	
	/**
	 * "AssertTrue" with Screen-Shot and descriptive Error Message
	 * Uses independent WebDriver driver;
	 * Opens user defined URL
	 * @param e
	 */
	public static String getAssertTrue(StackTraceElement l, WebDriver driver, String description, Boolean b) throws IOException {
		String packageNameOnly = l.getClassName().substring(0,
				l.getClassName().lastIndexOf("."));
		String classNameOnly = l.getClassName().substring(
				1 + l.getClassName().lastIndexOf("."),
				l.getClassName().length());
		String location = packageNameOnly + File.separator + classNameOnly
				+ File.separator + l.getMethodName() + ", line # "
				+ l.getLineNumber();
		String xml = "<class name=\"" + packageNameOnly + "." + classNameOnly
				+ "\"><methods><include name=\"" + l.getMethodName()
				+ "\"/></methods></class>";
		String detected = getCurrentDateTimeFull();
		String runtime = testRunTime("start.time", System.currentTimeMillis());
		String subtotal = testRunTime("ini.time", System.currentTimeMillis());
		if (b == false) {
			fileWriterPrinter("\nError Cause: ---> " + description
					+ "\n   Location: ---> " + location
					+ "\n   Expected: ---> " + "true" + "\n     Actual: ---> "
					+ b + "\n");
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
			fileWriter("failed.log", "    Failure: #"
					+ fileScanner("failed.num"));
			fileWriter("failed.log", "       Test: #" + fileScanner("test.num"));
			fileWriter(
					"failed.log",
					"      Start: "
							+ convertCalendarMillisecondsAsStringToDateTimeHourMinSec(fileScanner("start.time")));
			fileWriter("failed.log", "   XML Path: " + xml);
			fileWriter("failed.log", "Error Cause: ---> " + description);
			fileWriter("failed.log", "   Location: ---> " + location);
			fileWriter("failed.log", "   Expected: ---> " + "true");
			fileWriter("failed.log", "     Actual: ---> " + b);
			fileWriter("failed.log", "   Detected: " + detected);
			fileWriter("failed.log", "    Runtime: " + runtime);
			fileWriter("failed.log", "   Subtotal: " + subtotal);
			fileWriter("failed.log", "");
		} else {
			fileWriterPrinter("\nExpected: " + true + "\n  Actual: " + b
					+ "\n  Result: OK\n");
		}
		// Descriptive record output:
		return "\nError Cause: ---> " + description + "\n   Location: ---> "
				+ location + "\n   Expected: ---> " + "true"
				+ "\n     Actual: ---> " + b + "\n   Detected: ---> "
				+ detected + "\n    Runtime: ---> " + runtime
				+ "\n   Subtotal: ---> " + subtotal + "\n" + xml + "\n"
				+ "\nStack Traces:";
	}

	public static String getAssertEquals(StackTraceElement l, WebDriver driver,
			String description, Object actual, Object expected)
			throws IOException {
		String packageNameOnly = l.getClassName().substring(0,
				l.getClassName().lastIndexOf("."));
		String classNameOnly = l.getClassName().substring(
				1 + l.getClassName().lastIndexOf("."),
				l.getClassName().length());
		String location = packageNameOnly + File.separator + classNameOnly
				+ File.separator + l.getMethodName() + ", line # "
				+ l.getLineNumber();
		String xml = "<class name=\"" + packageNameOnly + "." + classNameOnly
				+ "\"><methods><include name=\"" + l.getMethodName()
				+ "\"/></methods></class>";
		String detected = getCurrentDateTimeFull();
		String runtime = testRunTime("start.time", System.currentTimeMillis());
		String subtotal = testRunTime("ini.time", System.currentTimeMillis());
		if (actual.equals(expected) == false) {
			fileWriterPrinter("\nError Cause: ---> " + description
					+ "\n   Location: ---> " + location
					+ "\n   Expected: ---> " + expected
					+ "\n     Actual: ---> " + actual + "\n");
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
			fileWriter("failed.log", "    Failure: #"
					+ fileScanner("failed.num"));
			fileWriter("failed.log", "       Test: #" + fileScanner("test.num"));
			fileWriter(
					"failed.log",
					"      Start: "
							+ convertCalendarMillisecondsAsStringToDateTimeHourMinSec(fileScanner("start.time")));
			fileWriter("failed.log", "   XML Path: " + xml);
			fileWriter("failed.log", "Error Cause: ---> " + description);
			fileWriter("failed.log", "   Location: ---> " + location);
			fileWriter("failed.log", "   Expected: ---> " + expected);
			fileWriter("failed.log", "     Actual: ---> " + actual);
			fileWriter("failed.log", "   Detected: " + detected);
			fileWriter("failed.log", "    Runtime: " + runtime);
			fileWriter("failed.log", "   Subtotal: " + subtotal);
			fileWriter("failed.log", "");
		} else {
			fileWriterPrinter("\nExpected: " + expected + "\n  Actual: "
					+ actual + "\n  Result: OK\n");
		}
		// Descriptive record output:
		return "\nError Cause: ---> " + description + "\n   Location: ---> "
				+ location + "\n   Expected: ---> " + expected
				+ "\n     Actual: ---> " + actual + "\n   Detected: ---> "
				+ detected + "\n    Runtime: ---> " + runtime
				+ "\n   Subtotal: ---> " + subtotal + "\n" + xml + "\n"
				+ "\nStack Traces:";
	}

	public static String getAssertFalse(StackTraceElement l, WebDriver driver,
			String description, Boolean b) throws IOException {
		String packageNameOnly = l.getClassName().substring(0,
				l.getClassName().lastIndexOf("."));
		String classNameOnly = l.getClassName().substring(
				1 + l.getClassName().lastIndexOf("."),
				l.getClassName().length());
		String location = packageNameOnly + File.separator + classNameOnly
				+ File.separator + l.getMethodName() + ", line # "
				+ l.getLineNumber();
		String xml = "<class name=\"" + packageNameOnly + "." + classNameOnly
				+ "\"><methods><include name=\"" + l.getMethodName()
				+ "\"/></methods></class>";
		String detected = getCurrentDateTimeFull();
		String runtime = testRunTime("start.time", System.currentTimeMillis());
		String subtotal = testRunTime("ini.time", System.currentTimeMillis());
		if (b == true) {
			fileWriterPrinter("\nError Cause: ---> " + description
					+ "\n   Location: ---> " + location
					+ "\n   Expected: ---> " + "false" + "\n     Actual: ---> "
					+ b + "\n");
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
			fileWriter("failed.log", "    Failure: #"
					+ fileScanner("failed.num"));
			fileWriter("failed.log", "       Test: #" + fileScanner("test.num"));
			fileWriter(
					"failed.log",
					"      Start: "
							+ convertCalendarMillisecondsAsStringToDateTimeHourMinSec(fileScanner("start.time")));
			fileWriter("failed.log", "   XML Path: " + xml);
			fileWriter("failed.log", "Error Cause: ---> " + description);
			fileWriter("failed.log", "   Location: ---> " + location);
			fileWriter("failed.log", "   Expected: ---> " + "false");
			fileWriter("failed.log", "     Actual: ---> " + b);
			fileWriter("failed.log", "   Detected: " + detected);
			fileWriter("failed.log", "    Runtime: " + runtime);
			fileWriter("failed.log", "   Subtotal: " + subtotal);
			fileWriter("failed.log", "");
		} else {
			fileWriterPrinter("\nExpected: " + false + "\n  Actual: " + b
					+ "\n  Result: OK\n");
		}
		// Descriptive record output:
		return "\nError Cause: ---> " + description + "\n   Location: ---> "
				+ location + "\n   Expected: ---> " + "false"
				+ "\n     Actual: ---> " + b + "\n   Detected: ---> "
				+ detected + "\n    Runtime: ---> " + runtime
				+ "\n   Subtotal: ---> " + subtotal + "\n" + xml + "\n"
				+ "\nStack Traces:";
	}

	/**
	 * Takes screenshot when step fails. Works only with Selenium2Driver.
	 * Screenshot is saved at: [workspace]/[project]/ Screenshot file name is:
	 * [class].[method],[description] (date, time).png
	 */
	public static void getScreenShot(String description, WebDriver driver)
			throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH.mm.ss");
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		String outputFile = Locators.outputFileDir + description + " ("
				+ dateFormat.format(new Date()) + ").png";
		fileWriterPrinter(outputFile);
		FileUtils.copyFile(scrFile, new File(outputFile));
	}

	/**
	 * Takes screenshot when step fails. Works only with Selenium2Driver.
	 * Screenshot is saved at: [workspace]/[project]/ Screenshot file name is:
	 * [class].[method],[description] (date, time).png
	 */
	public static void getScreenShot(String description, WebDriver driver,
			long milliseconds) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH.mm.ss");
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		String outputFile = Locators.outputFileDir + description + " ("
				+ dateFormat.format(milliseconds) + ").png";
		fileWriterPrinter(outputFile);
		FileUtils.copyFile(scrFile, new File(outputFile));
	}

	/**
	 * Takes screenshot when step fails. Works only with Selenium2Driver.
	 * Screenshot is saved at: [workspace]/[project]/[package]/[class]/
	 * Screenshot file name is: [class].[method],[description],[line #](date,
	 * time).png
	 */
	public static void getScreenShot(StackTraceElement l, String description,
			WebDriver driver) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH.mm.ss");
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		String packageNameOnly = l.getClassName().substring(0,
				l.getClassName().lastIndexOf("."));
		String classNameOnly = l.getClassName().substring(
				1 + l.getClassName().lastIndexOf("."),
				l.getClassName().length());
		String screenshotName = classNameOnly + "." + l.getMethodName() + ", "
				+ description + ", line # " + l.getLineNumber();
		String outputFile = Locators.outputFileDir + packageNameOnly
				+ File.separator + classNameOnly + File.separator
				+ screenshotName + " (" + dateFormat.format(new Date())
				+ ").png";
		fileWriterPrinter(outputFile);
		FileUtils.copyFile(scrFile, new File(outputFile));
	}

	/**
	 * Takes screenshot when step fails. Works only with Selenium2Driver.
	 * Screenshot is saved at: [workspace]/[project]/[package]/[class]/
	 * Screenshot file name is: [class].[method],[description],[line #](date,
	 * time).png
	 */
	public void getScreenShot(StackTraceElement l, Exception e, WebDriver driver)
			throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH.mm.ss");
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		String message1 = null;
		try {
			message1 = e.getCause().toString();
		} catch (NullPointerException e1) {
			message1 = ".getCause() by NullPointerException:";
		} finally {
			String[] multiline1 = message1.replaceAll("\\r", "").split("\\n");
			String firstLine = multiline1[0];
			String errorCause = firstLine.substring(0, firstLine.indexOf(":"));
			String exceptionThrown = errorCause.substring(
					1 + errorCause.lastIndexOf("."), errorCause.length());

			String packageNameOnly = l.getClassName().substring(0,
					l.getClassName().lastIndexOf("."));
			String classNameOnly = l.getClassName().substring(
					1 + l.getClassName().lastIndexOf("."),
					l.getClassName().length());
			String description = exceptionThrown;
			String screenshotName = classNameOnly + "." + l.getMethodName()
					+ ", " + description + ", line # " + l.getLineNumber();

			String outputFile = Locators.outputFileDir + packageNameOnly
					+ File.separator + classNameOnly + File.separator
					+ screenshotName + " (" + dateFormat.format(new Date())
					+ ").png";
			fileWriterPrinter(outputFile);
			FileUtils.copyFile(scrFile, new File(outputFile));
		}
	}

	/**
	 * Takes screenshot when step fails. Works only with Selenium2Driver.
	 * Screenshot is saved at: [workspace]/[project]/[package]/[class]/
	 * Screenshot file name is: [class].[method],[description],[line #](date,
	 * time).png
	 */
	public void getScreenShot(StackTraceElement l, Exception e,
			String description, WebDriver driver) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH.mm.ss");
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		String message1 = null;
		try {
			message1 = e.getCause().toString();
		} catch (NullPointerException e1) {
			message1 = ".getCause() by NullPointerException:";
		} finally {
			String[] multiline1 = message1.replaceAll("\\r", "").split("\\n");
			String firstLine = multiline1[0];
			String errorCause = firstLine.substring(0, firstLine.indexOf(":"));
			String exceptionThrown = errorCause.substring(
					1 + errorCause.lastIndexOf("."), errorCause.length());

			String packageNameOnly = l.getClassName().substring(0,
					l.getClassName().lastIndexOf("."));
			String classNameOnly = l.getClassName().substring(
					1 + l.getClassName().lastIndexOf("."),
					l.getClassName().length());
			String exception = exceptionThrown;
			String screenshotName = classNameOnly + "." + l.getMethodName()
					+ ", " + exception + ", " + description + ", line # "
					+ l.getLineNumber();

			String outputFile = Locators.outputFileDir + packageNameOnly
					+ File.separator + classNameOnly + File.separator
					+ screenshotName + " (" + dateFormat.format(new Date())
					+ ").png";
			fileWriterPrinter(outputFile);
			FileUtils.copyFile(scrFile, new File(outputFile));
		}
	}

	/*
	 * @throws IOException
	 * 
	 * @throws NumberFormatException
	 */
	public static String fileScanner(String fileName)
			throws NumberFormatException, IOException {
		String n = null;
		if (fileExist(fileName, false)) {
			File f = new File(Locators.testOutputFileDir + fileName);
			Scanner scanner = new Scanner(f);
			n = scanner.useDelimiter("\\Z").next();
			scanner.close();
		}
		return n;
	}

	/*
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public void fileCleaner(String fileName) throws NumberFormatException, IOException {
		if (fileExist(fileName, false)) {
			(new File(Locators.testOutputFileDir + fileName)).delete();
		}
	}
	
	/*
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public void fileCleaner(String path, String fileName) throws NumberFormatException, IOException {
		if (fileExist(path, fileName, false)) {
			(new File(path + fileName)).delete();
		}
	}

	/**
	 * Counter: Will renew counting starting with "1" if the Counter File is
	 * currently missing; Returns new iteration value;
	 * 
	 * @throws IOException
	 */
	public static int counter(String counterFileName)
			throws NumberFormatException, IOException {
		// if Counter File does not exist - create new it with counter "1";
		// otherwise - update existing by increasing the counter by "1";
		int n = 1;
		File f = new File(Locators.testOutputFileDir + counterFileName);
		if (f.exists() && f.isFile()) {
			n = Integer.valueOf(fileScanner(counterFileName)) + 1;
		}
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
	public static String testRunTime(String startFileName,
			long finishTimeMilliseconds) throws IOException {
		long finish = finishTimeMilliseconds;
		String startingTime = fileScanner(startFileName);
		long start = convertStringToLong(startingTime);
		return convertTimeMillisecondsAsLongToDuration(finish - start);
	}

	/*
	 * @throws IOException
	 * 
	 * @throws NumberFormatException
	 */
	public static long convertStringToLong(String value)
			throws NumberFormatException, IOException {
		try {
			return Long.parseLong(value);
		} catch (NumberFormatException exception) {
			fileWriterPrinter("\"NullPointerException\" thrown:\nString '"
					+ value + "' is not convertable to Long...");
			return 0;
		}
	}

	/*
	 * @throws IOException
	 * 
	 * @throws NumberFormatException
	 */
	public String convertLongToString(long value) throws NumberFormatException,
			IOException {
		try {
			return String.valueOf(value);
		} catch (NumberFormatException exception) {
			fileWriterPrinter("\"NullPointerException\" thrown:\nString '"
					+ value + "' is not convertable to Long...");
			return null;
		}
	}

	/*
	 * @throws IOException
	 * 
	 * @throws NumberFormatException
	 */
	public static String convertCalendarMillisecondsAsStringToDateTimeHourMinSec(
			String s) throws NumberFormatException, IOException {
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
	public String convertCalendarMillisecondsAsLongToDateTimeHourMinSec(
			long fingerprint) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(fingerprint);
		return format.format(date);
	}

	/** Convert long Milliseconds to Duration "Hours:Min:Sec" auto-format */
	public static String convertTimeMillisecondsAsLongToDuration(long milliseconds) {
		String hours = String.format("%02d",
				TimeUnit.MILLISECONDS.toHours(milliseconds));
		
		String minutes = String.format(
				"%02d",
				TimeUnit.MILLISECONDS.toMinutes(milliseconds)
			  - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliseconds)));
		
		String seconds = String.format(
				"%02d",
				TimeUnit.MILLISECONDS.toSeconds(milliseconds)
			  - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliseconds)));
		
		String duration = Integer.valueOf(hours) + ":" + minutes + ":" + seconds;
		return duration;
	}

	// /** Convert Date to long Milliseconds */
	// public long convertCalendarDateToMillisecondsAsLong(String stringDate)
	// throws ParseException {
	// DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	// Date date = formatter.parse(stringDate);
	// long mills = date.getTime();
	// return mills;
	// }

	// /** Convert Date and Time list year, month, day, hours, minutes, seconds
	// to long Milliseconds */
	// public long convertCalendarIntDateTimeListToMillisecondsAsLong(
	// String date, int hours, int min, int sec)
	// throws ParseException {
	// return convertCalendarDateToMillisecondsAsLong(date) + ((hours * 3600) +
	// (min * 60) + sec) * 1000;
	// }
	
	/** Convert long Milliseconds to Timestamp */
	public String convertCalendarMillisecondsAsLongToTimestamp(long fingerprint) {	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(fingerprint);
		String Date = dateFormat.format(date);
		
		dateFormat = new SimpleDateFormat("HH:mm:ss");
		date = new Date(fingerprint);
		
		return Date + "T" + dateFormat.format(date);
	}

	/** Date Calculator per days step: adding or reducing number of days */
	public long todayAddDaysToCurrentTimeMilliseconds(int addDays) {
		long mills = System.currentTimeMillis() + addDays * 24 * 3600 * 1000; // add "days";
		return mills;
	}

	/** Date Calculator per yearss step: adding or reducing number of years 
	 * @throws ParseException */
	public long todayAddYearsToCurrentTimeMilliseconds(int addYears) throws ParseException {
	    Calendar date = Calendar.getInstance();
	    date.setTime(new Date());
	    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    date.add(Calendar.YEAR, addYears);
	    String newDate = formatter.format(date.getTime());
	    Date newdate = formatter.parse(newDate);
	    long mills = newdate.getTime();
		return mills;
	}
	
	/** Convert Date and Time (Hour:Min:Sec) to long Milliseconds */
	public long convertCalendarDateTimeHourMinSecToMillisecondsAsLong(String stringDate) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = formatter.parse(stringDate);
		long mills = date.getTime();
		return mills;
	}
	
	/**
	 * Creates a new Test Log record as a text file named "run.log" create file
	 * example: File f = new File(<full path string>); f.createNewFile();
	 * 
	 * @throws IOException
	 */
	// @BeforeSuite
	public void logOpen() throws IOException {
		// Initialization:
		fileCleaner("failed.log");
		fileCleaner("failed.num");
		fileCleaner("finish.time");
		fileCleaner("ini.time");
		fileCleaner("run.log");
		fileCleaner("print.log");
		fileCleaner("start.time");
		fileCleaner("stack.trace");
		fileCleaner("test.num");
		fileCleaner("wait.log");
		fileCleaner("xml.path");
		fileCleaner("source.html");
		String time = getCurrentDateTimeFull(); // System.out.print(" TEST START: "
												// + time + "\n");
		fileWriter("ini.time", convertLongToString(System.currentTimeMillis()));
		// Initial Log record:
		fileWriter("run.log", " TEST START: " + time);
		fileWriter("run.log", "");
	}

	/**
	 * Closes the Test Log record text file named "run.log"
	 * 
	 * @throws IOException
	 * @throws Exception
	 */
	// @AfterSuite
	public void logClose() throws IOException {
		long finish = System.currentTimeMillis();
		String time = getCurrentDateTimeFull();
		// Scanning Failure Counter record:
		int failed = 0;
		if (fileExist("failed.num", false)) {
			failed = Integer.valueOf(fileScanner("failed.num"));
		}
		// Scanning Test Counter record:
		int n = 1;
		if (fileExist("test.num", false)) {
			if (!fileScanner("test.num").equals(null)) {
				n = Integer.valueOf(fileScanner("test.num"));
			}
		}
		if (n > 1) {
			// Scanning Initialization record:
			String startingTime = fileScanner("ini.time");
			long start = convertStringToLong(startingTime);
			fileWriterPrinter("TOTAL TESTS: "
					+ Integer.valueOf(fileScanner("test.num")));
			fileWriterPrinter("     FAILED: " + failed);
			fileWriterPrinter("TEST  START: "
					+ convertCalendarMillisecondsAsLongToDateTimeHourMinSec(start));
			fileWriterPrinter("TEST FINISH: " + time);
			fileWriterPrinter("TOTAL  TIME: "
					+ convertTimeMillisecondsAsLongToDuration(finish - start));
			fileWriterPrinter();
			// Final Log record:
			if (fileExist("run.log")) {
				fileWriter("run.log", "");
				fileWriter(
						"run.log",
						"TOTAL TESTS: "
								+ Integer.valueOf(fileScanner("test.num")));
				fileWriter("run.log", "     FAILED: " + failed);
				fileWriter(
						"run.log",
						"TEST  START: "
								+ convertCalendarMillisecondsAsLongToDateTimeHourMinSec(start));
				fileWriter("run.log", "TEST FINISH: " + time);
				fileWriter("run.log", "TOTAL  TIME: "
						+ convertTimeMillisecondsAsLongToDuration(finish
								- start));
				fileWriter("run.log", "");
			}
		}
		// Clean-up unnecessary file(s)
		fileCleaner("failed.num");
		fileCleaner("finish.time");
		fileCleaner("ini.time");
		fileCleaner("start.time");
		fileCleaner("stack.trace");
		fileCleaner("test.num");
		fileCleaner("xml.path");
	}

	/**
	 * @throws IOException
	 */
	public void startTime() throws IOException {
		String date = getCurrentDateTimeFull();
		fileCleaner("start.time");
		
		// CPAD cleaning:
		fileCleaner("cpad.log");
		fileCleaner("match.log");
		fileCleaner("max.log");
		fileCleaner("order.log");
		fileCleaner("xml.log");
		fileCleaner("error.log");
		
		fileWriter("start.time",
				convertLongToString(System.currentTimeMillis()));
		// Creating New or Updating existing Test Counter record:
		int n = counter("test.num");
		// Print-out information:
		fileWriterPrinter("\n       Test: #" + n);
		fileWriterPrinter("      Start: " + date);
		// Append a Start Log record:
		if (fileExist("run.log")) {
			fileWriter("run.log", "");
			fileWriter("run.log", "       Test: #" + n);
			fileWriter("run.log", "      Start: " + date);
		}
	}

	/** Prints Test End and Sub-Total Time */
	public void endTime() throws IOException {
		long finish = System.currentTimeMillis();
		fileCleaner("finish.time");

		// CPAD cleaning:
		fileCleaner("cpad.log");
		fileCleaner("match.log");
		fileCleaner("max.log");
		fileCleaner("order.log");
		fileCleaner("xml.log");
		fileCleaner("error.log");
		
		fileWriter("finish.time", convertLongToString(finish));
		// Scanning Test Counter record:
		int n = 1;
		if (fileExist("test.num", false)) {
			if (!fileScanner("test.num").equals(null)) {
				n = Integer.valueOf(fileScanner("test.num"));
			}
		}
		fileWriterPrinter("     Finish: " + getCurrentDateTimeFull());
		fileWriterPrinter("   Duration: " + testRunTime("start.time", finish));
		if (n > 1) {
			fileWriterPrinter("   Subtotal: " + testRunTime("ini.time", finish)
					+ "\n");
		} else {
			fileWriterPrinter();
		}
		// Append an End Log record:
		if (fileExist("run.log")) {
			fileWriter("run.log", "     Finish: " + getCurrentDateTimeFull());
			fileWriter("run.log",
					"   Duration: " + testRunTime("start.time", finish));
			if (n > 1) {
				fileWriter("run.log",
						"   Subtotal: " + testRunTime("ini.time", finish));
			}
		}
	}
	
	/**
	 * Print the Source Page
	 * Won't use Selenium WebDriver
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void sourcePagePrint(String url) throws IOException, InterruptedException {
		try {
			getUrlPageSourceSave(url);
		} catch (Exception exception) {
			getExceptionDescriptive(exception, new Exception().getStackTrace()[0]);
		}
	}
	
	/**
	 * Print the Source Page
	 * Won't use Selenium WebDriver
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void sourcePagePrint(String url, String fileName) throws IOException, InterruptedException {
		try {
			fileCleaner(fileName);
			fileWriterPrinter();
			getUrlPageSourceSave(url, fileName);
			fileWriterPrinter();
			// Thread.sleep(2000);
		} catch (Exception exception) {
			getExceptionDescriptive(exception, new Exception().getStackTrace()[0]);
		}
	}
	
	/**
	 * Print the Source Page
	 * Won't use Selenium WebDriver
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void sourcePagePrint(String url, String path, String fileName) throws IOException, InterruptedException {
		try {
			fileCleaner(path, fileName);
			fileWriterPrinter();
			getUrlPageSourceSave(url, path, fileName);
			fileWriterPrinter();
		} catch (Exception exception) {
			getExceptionDescriptive(exception, new Exception().getStackTrace()[0]);
		}
	}
	
	/**
	 * Print the Source Page
	 * Uses Selenium WebDriver
	 * @throws IOException
	 */
	public void sourcePagePrint(WebDriver driver, String url, String fileName) throws IOException {
		try {
			// Functions function = new Functions();
			fileCleaner(fileName);

			while (!driver.getCurrentUrl().equals(url)) {
				driver.get(url);
				Thread.sleep(5000);
			}

			fileWriterPrinter();
			// function.
			getUrlSourcePagePrint(driver.getCurrentUrl(), fileName);
			fileWriterPrinter();

			Thread.sleep(2000);
			// driver.quit();
		} catch (Exception exception) {
			getExceptionDescriptive(exception, new Exception().getStackTrace()[0], driver);
		}
		// finally { driver.quit(); }
	}

	/**
	 * Print the Source Page
	 * Uses Selenium WebDriver
	 * @throws IOException
	 */
	public void sourcePagePrint(WebDriver driver, String url, String path, String fileName) throws IOException {
		try {
			// Functions function = new Functions();
			fileCleaner(path, fileName);

			while (!driver.getCurrentUrl().equals(url)) {
				driver.get(url);
				Thread.sleep(5000);
			}

			fileWriterPrinter();
			// function.
			getUrlSourcePagePrint(driver.getCurrentUrl(), path, fileName);
			fileWriterPrinter();

			Thread.sleep(2000);
			// driver.quit();
		} catch (Exception exception) {
			getExceptionDescriptive(exception, new Exception().getStackTrace()[0], driver);
		}
		// finally { driver.quit(); }
	}

	public String getValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0)
				.getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}

	/**
	 * Compare two long values
	 * 
	 * @throws IOException
	 */
	public boolean compareLong(long firstLong, long secondLong)
			throws IOException {
		try {
			return (firstLong >= secondLong);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Convert CPAD Date and Time Stamp to long Milliseconds
	 * 
	 * @throws ParseException
	 */
	@SuppressWarnings("unused")
	public static long convertCpadDateStampToMillisecondsAsLong(String cpadDateStamp)
	throws ParseException {
		String date = cpadDateStamp.substring(0, cpadDateStamp.indexOf("T"));
		String HH = cpadDateStamp.substring(cpadDateStamp.indexOf("T") + 1, cpadDateStamp.indexOf("T") + 3);
		String MM = cpadDateStamp.substring(cpadDateStamp.indexOf(":") + 1, cpadDateStamp.indexOf(":") + 3);
		String SS = cpadDateStamp.substring(cpadDateStamp.indexOf(":") + 4, cpadDateStamp.indexOf(":") + 6);

        int hours, min, sec;
        String math = null, hh = null, mm = null;

        if(cpadDateStamp.length() == 25){
	        	math = cpadDateStamp.substring(cpadDateStamp.lastIndexOf(":") - 3, cpadDateStamp.lastIndexOf(":") - 2);
	        	hh = cpadDateStamp.substring(cpadDateStamp.lastIndexOf(":") - 2, cpadDateStamp.lastIndexOf(":"));
		        mm = cpadDateStamp.substring(cpadDateStamp.lastIndexOf(":") + 1, cpadDateStamp.lastIndexOf(":") + 3);
        } 

        if(cpadDateStamp.length() == 19) { math = "+"; hh = "00"; mm = "00"; }

		String dateUnitTest = "Date: " + date + " " + HH + ":" + MM + ":" + SS + math + hh + ":" + mm;

		if (math.equals("-")) { hours = Integer.valueOf(HH) - Integer.valueOf(hh); }
		else                  { hours = Integer.valueOf(HH) + Integer.valueOf(hh); }
		
		if (math.equals("-")) { min = Integer.valueOf(MM) - Integer.valueOf(mm); }
		else                  { min = Integer.valueOf(MM) + Integer.valueOf(mm); }
		
		sec = Integer.valueOf(SS);
		return convertCalendarIntDateTimeListToMillisecondsAsLong(date, hours, min, sec);
	}

	/**
	 * xml File validity check
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public Boolean xmlValidityChecker(StackTraceElement trace, String fileName, int number, int total)
	throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		factory.setNamespaceAware(true);

		DocumentBuilder builder = factory.newDocumentBuilder();

		builder.setErrorHandler(new SimpleErrorHandler());
		boolean result;
		
		// PARSE method:
		// (1) validates XML;
		// (2) will throw an exception if miss-formatted;
		try {
			builder.parse(new InputSource(Locators.testOutputFileDir + fileName));		
			result = true;
			} catch (Exception e) {
			fileCleaner("xml.log");
			fileWriter("xml.log", "false");
			result = false;
		}
		getAssertTrue(trace, "XML is invalid! (URL " + number + " OF " + total + ") - " + fileScanner("error.log"), result);
		if(!result){ fileWriterPrinter("=========================="); fileWriterPrinter(); }
		return result;
	}
	
//	try {
//		builder.parse(new InputSource(path + fileName));
//		result = true;
//	} catch (Exception e) {
//		fileCleaner("xml.log");
//		fileWriter("xml.log", "false");
//		result = false;
//	}
//	getAssertTrue(trace, "XML is invalid! (URL " + number + " OF " + total + ") - " + fileScanner("error.log"), result);
//	if(!result){ fileWriterPrinter("=========================="); fileWriterPrinter(); }
//	return result;
//}
	
	/**
	 * xml String validity check
	 * Won't use Selenium WebDriver
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws InterruptedException 
	 */
	public Boolean xmlValidityChecker(String xml,
		   StackTraceElement trace, int number, int total)
	throws SAXException, IOException, ParserConfigurationException, InterruptedException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		factory.setNamespaceAware(true);

		DocumentBuilder builder = factory.newDocumentBuilder();

		builder.setErrorHandler(new SimpleErrorHandler());
		boolean result;
		// PARSE method:
		// (1) validates XML;
		// (2) will throw an exception if miss-formatted;
		try {
			builder.parse(new InputSource(new StringReader(xml)));
			result = true;
		} catch (Exception e) {
			fileCleaner("xml.log");
			fileWriter("xml.log", "false");
			result = false;
		}
		getAssertTrue(trace, "XML is invalid! (URL " + number + " OF " + total + ") - " + fileScanner("error.log"), result);
		if(!result){ fileWriterPrinter("=========================="); fileWriterPrinter(); }
		return result;
	}
	
	/**
	 * xml File validity check
	 * Won't use Selenium WebDriver
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws InterruptedException 
	 */
	public Boolean xmlValidityChecker(String path, String fileName,
			StackTraceElement trace, int number, int total)
			throws SAXException, IOException, ParserConfigurationException, InterruptedException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		factory.setNamespaceAware(true);

		DocumentBuilder builder = factory.newDocumentBuilder();

		builder.setErrorHandler(new SimpleErrorHandler());
		boolean result;
		// PARSE method:
		// (1) validates XML;
		// (2) will throw an exception if miss-formatted;
		try {
			builder.parse(new InputSource(path + fileName));
			result = true;
		} catch (Exception e) {
			fileCleaner("xml.log");
			fileWriter("xml.log", "false");
			result = false;
		}
		getAssertTrue(trace, "XML is invalid! (URL " + number + " OF " + total + ") - " + fileScanner("error.log"), result);
		if(!result){ fileWriterPrinter("=========================="); fileWriterPrinter(); }
		return result;
	}
	
	/**
	 * xml File validity check
	 * Uses Selenium WebDriver on Assertion
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws InterruptedException 
	 */
	public Boolean xmlValidityChecker(String path, String fileName,
			StackTraceElement trace, String url, int number, int total)
			throws SAXException, IOException, ParserConfigurationException, InterruptedException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		factory.setNamespaceAware(true);

		DocumentBuilder builder = factory.newDocumentBuilder();

		builder.setErrorHandler(new SimpleErrorHandler());
		boolean result;
		// PARSE method:
		// (1) validates XML;
		// (2) will throw an exception if miss-formatted;
		try {
			builder.parse(new InputSource(path + fileName));
			result = true;
		} catch (Exception e) {
			fileCleaner("xml.log");
			fileWriter("xml.log", "false");
			result = false;
		}
		getAssertTrue(trace, url, "XML is invalid! (URL " + number + " OF " + total + ") - " + fileScanner("error.log"), result);
		if(!result){ fileWriterPrinter("=========================="); fileWriterPrinter(); }
		return result;
	}

	/**
	 * xml File validity check
	 * Uses Selenium WebDriver
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public Boolean xmlValidityChecker(String path, String fileName,
			StackTraceElement trace, WebDriver driver, int number, int total)
			throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		factory.setNamespaceAware(true);

		DocumentBuilder builder = factory.newDocumentBuilder();

		builder.setErrorHandler(new SimpleErrorHandler());
		boolean result;
		// PARSE method:
		// (1) validates XML;
		// (2) will throw an exception if miss-formatted;
		try {
			builder.parse(new InputSource(path + fileName));
			result = true;
		} catch (Exception e) {
			fileCleaner("xml.log");
			fileWriter("xml.log", "false");
			result = false;
		}
		getAssertTrue(trace, driver, "XML is invalid! (URL " + number + " OF " + total + ") - " + fileScanner("error.log"), result);
		if(!result){ fileWriterPrinter("=========================="); fileWriterPrinter(); }
		return result;
	}

	public class SimpleErrorHandler implements ErrorHandler {
		public void warning(SAXParseException e) throws SAXException {
			try {
				fileWriterPrinter(e.getMessage());
			} catch (Exception exception) {
			}
		}

		public void error(SAXParseException e) throws SAXException {
			try {
				fileWriterPrinter(e.getMessage());
			} catch (Exception exception) {
			}
		}

		public void fatalError(SAXParseException e) throws SAXException {
			try {
				fileWriterPrinter(e.getMessage());
			} catch (Exception exception) {
			}
		}
	}
	
	/**
	 * xml String value reader
	 * 
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public String[] xmlValueArray(String xml, String record,
			String tag) throws ParserConfigurationException, SAXException,
			IOException {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader(xml)));
		doc.getDocumentElement().normalize();
		fileWriterPrinter(doc.getDocumentElement().getNodeName() + ":" + "\n");
		NodeList nodes = doc.getElementsByTagName(record);
		String[] valueArray = new String[nodes.getLength()];
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				// fileWriterPrinter(record + " " + tag + ": " + getValue(tag,
				// element));
				valueArray[i] = getValue(tag, element);
			}
		}
		return valueArray;
	}

	/**
	 * xml File value reader
	 * 
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public String[] xmlValueArray(String path, String fileName, String record,
			String tag) throws ParserConfigurationException, SAXException,
			IOException {
		File stocks = new File(path + fileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(stocks);
		doc.getDocumentElement().normalize();
		fileWriterPrinter(doc.getDocumentElement().getNodeName() + ":" + "\n");
		NodeList nodes = doc.getElementsByTagName(record);
		String[] valueArray = new String[nodes.getLength()];
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				// fileWriterPrinter(record + " " + tag + ": " + getValue(tag,
				// element));
				valueArray[i] = getValue(tag, element);
			}
		}
		return valueArray;
	}
	
	/**
	 * xml String record length
	 * 
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public int xmlRecordLength(String xml, String record)
	throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader(xml)));
		doc.getDocumentElement().normalize();
		NodeList nodes = doc.getElementsByTagName(record);
		return nodes.getLength();
	}

	/**
	 * xml File record length
	 * 
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public int xmlRecordLength(String path, String fileName, String record)
	throws ParserConfigurationException, SAXException, IOException {
		File stocks = new File(path + fileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(stocks);
		doc.getDocumentElement().normalize();
		NodeList nodes = doc.getElementsByTagName(record);
		return nodes.getLength();
	}
	
	/**
	 * Timestamp plus Days from NOW
	 */ 
	public String timestampPlusDays(int days){
	return convertCalendarMillisecondsAsLongToTimestamp(todayAddDaysToCurrentTimeMilliseconds(days));
	}
	
	/**
	 * Timestamp plus Years from NOW
	 * @throws ParseException 
	 */ 
	public String timestampPlusYears(int years) throws ParseException{
	return convertCalendarMillisecondsAsLongToTimestamp(todayAddYearsToCurrentTimeMilliseconds(years));
	}
	
	public String cpadAscOrderError        = "NEXT RECORD, SHOWN BELOW - IS LESS THEN THE CURRENT ONE...";

	public String cpadDescOrderError       = "NEXT RECORD, SHOWN BELOW - IS GREATER THEN THE CURRENT ONE...";
	
	public String cpadAscDateOrderError    = "NEXT RECORD, SHOWN BELOW - IS OLDER THEN THE CURRENT ONE...";

	public String cpadDescDateOrderError   = "NEXT RECORD, SHOWN BELOW - IS NEWER THEN THE PREVIOUS ONE...";
	
	public String cpadMatchError           = "CURRENT RECORD IS NOT AS EXPECTED...";
	
	public String cpadGreaterError         = "CURRENT RECORD IS LESS THEN EXPECTED MINIMUM...";
	
	public String cpadLessOrEqualError     = "CURRENT RECORD IS BEYOND OF EXPECTED MAXIMUM...";
	
	public String cpadFilterNotBeforeError = "CURRENT RECORD IS OLDER THEN EXPECTED AS PER FILTER...";
	
	public String cpadFilterAfterError     = "CURRENT RECORD IS NOT NEWER THEN EXPECTED AS PER FILTER...";
	
	public String cpadFilterNotAfterError  = "CURRENT RECORD IS NEWER THEN EXPECTED AS PER FILTER...";
	
	public String cpadBetweenError         = "CURRENT RECORD IS NOT BETWEEN FROM AND TO...";
	
	/**
	 * Assert CPAD record tags are in ascending order
	 * Won't use Selenium WebDriver
	 * @throws IOException
	 */
	public boolean assertCpadTagsAsc(
		           StackTraceElement trace, String url, int combination, int total,
			       Boolean ifAssert, String record, String tag) 
	throws IOException {
		try {
			fileWriterPrinter("\n" + "URL COMBINATION # " + combination + " OF " + total + ":");
			fileWriterPrinter(url);
			fileWriterPrinter("\n" + "Record Name: " + record);
			fileWriterPrinter("   Tag Name: " + tag);

			String xml = getUrlPageSourceSave(url);

			fileWriterPrinter();
			fileWriterPrinter("==========================");

			if (!fileExist("cpad.log", false)) { fileWriter("cpad.log", "true"); }
			if (!fileExist("order.log", false )) { fileWriter("order.log", "true"); }
			
			if (!fileExist("xml.log",  false)) { fileWriter("xml.log",  "true"); }			
			xmlValidityChecker(xml, trace, combination, total);

			String[] valueArray = xmlValueArray(xml, record, tag);

			for (int i = 0; i < valueArray.length; i++) {
				fileWriterPrinter("Record ID: " + (i + 1));
				fileWriterPrinter("Tag Value: " + valueArray[i]);

				if (i < (valueArray.length - 1)) {
					boolean assertORDER = ( Integer.valueOf(valueArray[i + 1]) >= Integer.valueOf(valueArray[i]) );

					if (assertORDER) {
						fileWriterPrinter("   Result: OK\n");
					} else {
						fileWriterPrinter("  Result: FAILED!");
						fileWriterPrinter("  Reason: " + cpadAscOrderError);
						fileCleaner("order.log");
						fileWriter("order.log", "false");

						if (ifAssert) {
							fileWriterPrinter();
							fileWriterPrinter("Record ID: " + (i + 2));
							fileWriterPrinter("    Value: " + valueArray[i + 1]);
						}

						fileWriterPrinter();
					}

					if (ifAssert) { Assert.assertTrue(assertORDER, "  Result: FAILED\n"); }
				}
			}

			fileWriterPrinter("==========================");
			fileWriterPrinter();

			getAssertTrue(trace, "Out of order! (URL " + combination + " OF " + total + ")", Boolean.valueOf(fileScanner("order.log")), url);
			
			boolean result = Boolean.valueOf(fileScanner("order.log")) && Boolean.valueOf(fileScanner("xml.log"));
			
			if ((fileExist("cpad.log", false)) && (!result)) { fileCleaner("cpad.log"); fileWriter("cpad.log", result); }
			
			fileCleaner("order.log");
			fileCleaner("xml.log");
			return result;

		} catch (Exception exception) { /** exception.printStackTrace(); */ fileCleaner("cpad.log"); fileWriter("cpad.log", false); return false; }
	}
	
	/**
	 * Assert CPAD record tags as dates are in ascending order
	 * Won't use Selenium WebDriver
	 * @throws IOException
	 */
	public boolean assertCpadTagsDateAsc(
		           StackTraceElement trace, String url, int combination, int total,
			       Boolean ifAssert, String record, String tag) 
	throws IOException {
		try {
			fileWriterPrinter("\n" + "URL COMBINATION # " + combination + " OF " + total + ":");
			fileWriterPrinter(url);
			fileWriterPrinter("\n" + "Record Name: " + record);
			fileWriterPrinter("   Tag Name: " + tag);

			String xml = getUrlPageSourceSave(url);

			fileWriterPrinter();
			fileWriterPrinter("==========================");

			if (!fileExist("cpad.log", false)) { fileWriter("cpad.log", "true"); }
			if (!fileExist("order.log", false )) { fileWriter("order.log", "true"); }
			
			if (!fileExist("xml.log",  false)) { fileWriter("xml.log",  "true"); }			
			xmlValidityChecker(xml, trace, combination, total);

			String[] valueArray = xmlValueArray(xml, record, tag);
			long[] fingerprintArray = new long[valueArray.length];

			for (int i = 0; i < valueArray.length; i++) { fingerprintArray[i] = convertCpadDateStampToMillisecondsAsLong(valueArray[i]); }

			for (int i = 0; i < valueArray.length; i++) {
				fileWriterPrinter("Record ID: " + (i + 1));
				fileWriterPrinter("Tag Value: " + valueArray[i]);

				if (i < (valueArray.length - 1)) {
					boolean assertORDER = compareLong(fingerprintArray[i + 1],
							fingerprintArray[i]);

					if (assertORDER) {
						fileWriterPrinter("   Result: OK\n");
					} else {
						fileWriterPrinter("   Result: FAILED!");
						fileWriterPrinter("   Reason: " + cpadAscDateOrderError);
						fileCleaner("order.log");
						fileWriter("order.log", "false");

						if (ifAssert) {
							fileWriterPrinter();
							fileWriterPrinter(" Record ID: " + (i + 2));
							fileWriterPrinter("Created On: " + valueArray[i + 1]);
						}

						fileWriterPrinter();
					}

					if (ifAssert) { Assert.assertTrue(assertORDER, "   Result: FAILED\n"); }
				}
			}

			fileWriterPrinter("==========================");
			fileWriterPrinter();

			getAssertTrue(trace, "Out of order! (URL " + combination + " OF " + total + ")", Boolean.valueOf(fileScanner("order.log")), url);

			boolean result = Boolean.valueOf(fileScanner("order.log")) && Boolean.valueOf(fileScanner("xml.log"));
			
			if ((fileExist("cpad.log", false)) && (!result)) { fileCleaner("cpad.log"); fileWriter("cpad.log", result); }
			
			fileCleaner("order.log");
			fileCleaner("xml.log");
			return result;

		} catch (Exception exception) { /** exception.printStackTrace(); */ fileCleaner("cpad.log"); fileWriter("cpad.log", false); return false; }
	}
	
	/**
	 * Assert CPAD record tags are in descending order
	 * Won't use Selenium WebDriver
	 * @throws IOException
	 */
	public boolean assertCpadTagsDesc(
		           StackTraceElement trace, String url, int combination, int total,
			       Boolean ifAssert, String record, String tag) 
	throws IOException {
		try {
			fileWriterPrinter("\n" + "URL COMBINATION # " + combination + " OF " + total + ":");
			fileWriterPrinter(url);
			fileWriterPrinter("\n" + "Record Name: " + record);
			fileWriterPrinter("   Tag Name: " + tag);

			String xml = getUrlPageSourceSave(url);

			fileWriterPrinter();
			fileWriterPrinter("==========================");

			if (!fileExist("cpad.log", false)) { fileWriter("cpad.log", "true"); }
			if (!fileExist("order.log", false )) { fileWriter("order.log", "true"); }
			
			if (!fileExist("xml.log",  false)) { fileWriter("xml.log",  "true"); }			
			xmlValidityChecker(xml, trace, combination, total);

			String[] valueArray = xmlValueArray(xml, record, tag);

			for (int i = 0; i < valueArray.length; i++) {
				fileWriterPrinter("Record ID: " + (i + 1));
				fileWriterPrinter("Tag Value: " + valueArray[i]);

				if (i < (valueArray.length - 1)) {
					boolean assertORDER = ( Integer.valueOf(valueArray[i + 1]) <= Integer.valueOf(valueArray[i]) );

					if (assertORDER) {
						fileWriterPrinter("   Result: OK\n");
					} else {
						fileWriterPrinter("  Result: FAILED!");
						fileWriterPrinter("  Reason: " + cpadDescOrderError);
						fileCleaner("order.log");
						fileWriter("order.log", "false");

						if (ifAssert) {
							fileWriterPrinter();
							fileWriterPrinter("Record ID: " + (i + 2));
							fileWriterPrinter("    Value: " + valueArray[i + 1]);
						}

						fileWriterPrinter();
					}

					if (ifAssert) { Assert.assertTrue(assertORDER, "  Result: FAILED\n"); }
				}
			}

			fileWriterPrinter("==========================");
			fileWriterPrinter();

			getAssertTrue(trace, "Out of order! (URL " + combination + " OF " + total + ")", Boolean.valueOf(fileScanner("order.log")), url);

			boolean result = Boolean.valueOf(fileScanner("order.log")) && Boolean.valueOf(fileScanner("xml.log"));
			
			if ((fileExist("cpad.log", false)) && (!result)) { fileCleaner("cpad.log"); fileWriter("cpad.log", result); }
			
			fileCleaner("order.log");
			fileCleaner("xml.log");
			return result;

		} catch (Exception exception) { /** exception.printStackTrace(); */ fileCleaner("cpad.log"); fileWriter("cpad.log", false); return false; }
	}
	
	/**
	 * Assert CPAD record tags as dates are in descending order
	 * Won't use Selenium WebDriver
	 * @throws IOException
	 */
	public boolean assertCpadTagsDateDesc(
	           StackTraceElement trace, String url, int combination, int total,
		       Boolean ifAssert, String record, String tag) 
    throws IOException {
		try {
			fileWriterPrinter("\n" + "URL COMBINATION # " + combination + " OF " + total + ":");
			fileWriterPrinter(url);
			fileWriterPrinter("\n" + "Record Name: " + record);
			fileWriterPrinter("   Tag Name: " + tag);

			String xml = getUrlPageSourceSave(url);
			
			fileWriterPrinter();
			fileWriterPrinter("==========================");

			if (!fileExist("cpad.log", false)) { fileWriter("cpad.log", "true"); }
			if (!fileExist("order.log", false )) { fileWriter("order.log", "true"); }
			
			if (!fileExist("xml.log",  false)) { fileWriter("xml.log",  "true"); }			
			xmlValidityChecker(xml, trace, combination, total);
			
			String error = "Out of order!"; String reason = cpadDescDateOrderError;
			String[] valueArray = xmlValueArray(xml, record, tag);			
			long[] fingerprintArray = new long[valueArray.length];

			for (int i = 0; i < valueArray.length; i++) { fingerprintArray[i] = convertCpadDateStampToMillisecondsAsLong(valueArray[i]); }

			for (int i = 0; i < valueArray.length; i++) {
				fileWriterPrinter("Record ID: " + (i + 1));
				fileWriterPrinter("Tag Value: " + valueArray[i]);

				if (i < (valueArray.length - 1)) {
					boolean assertORDER = compareLong(fingerprintArray[i],
							fingerprintArray[i + 1]);

					if (assertORDER) {
						fileWriterPrinter("   Result: OK\n");
					} else {
						fileWriterPrinter("   Result: FAILED!");
						fileWriterPrinter("   Reason: " + reason);
						fileCleaner("order.log");
						fileWriter("order.log", "false");

						if (ifAssert) {
							fileWriterPrinter();
							fileWriterPrinter(" Record ID: " + (i + 2));
							fileWriterPrinter("Created On: " + valueArray[i + 1]);
						}

						fileWriterPrinter();
						
						fileWriter("record.log", "");					
						fileWriter("record.log", "Record ID: " + (i + 1));
						fileWriter("record.log", "Tag Value: " + valueArray[i]);
						fileWriter("record.log", "   Result: FAILED!");
						fileWriter("record.log", "   Reason: " + reason);
						fileWriter("record.log", "");
					}

					if (ifAssert) { Assert.assertTrue(assertORDER, "   Result: FAILED\n"); }
				}
			}

			fileWriterPrinter("==========================");
			fileWriterPrinter();

			getAssertTrue(trace, error + " (URL " + combination + " OF " + total + ")", Boolean.valueOf(fileScanner("order.log")), url);
			
			boolean result = Boolean.valueOf(fileScanner("order.log")) && Boolean.valueOf(fileScanner("xml.log"));
			
			if ((fileExist("cpad.log", false)) && (!result)) { fileCleaner("cpad.log"); fileWriter("cpad.log", result); }
			
			fileCleaner("order.log");
			fileCleaner("xml.log");
			return result;

		} catch (Exception exception) { /** exception.printStackTrace(); */ fileCleaner("cpad.log"); fileWriter("cpad.log", false); return false; }
	}
	
	/**
	 * Assert CPAD record tags by compare with the expected
	 * Won't use Selenium WebDriver
	 * @throws IOException
	 */
	public boolean assertCpadTagsCompareToExpected(
		           StackTraceElement trace, String url, int combination, int total,
			       Boolean ifAssert, String record, String tag, String expected, String condition) 
	throws IOException {	
		try {
			fileWriterPrinter("\n" + "URL COMBINATION # " + combination + " OF " + total + ":");
			fileWriterPrinter(url);
			fileWriterPrinter("\n" + "Record Name: " + record);
			fileWriterPrinter("   Tag Name: " + tag);

			String xml = getUrlPageSourceSave(url);

			fileWriterPrinter();
			fileWriterPrinter("==========================");
			
			if (!fileExist("cpad.log", false)) { fileWriter("cpad.log", "true"); }
			if (!fileExist("compare.log", false)) { fileWriter("compare.log", "true"); }
			
			if (!fileExist("xml.log",  false)) { fileWriter("xml.log",  "true"); }			
			xmlValidityChecker(xml, trace, combination, total);
		    
			String error = ""; String reason = "";
			String[] valueArray = xmlValueArray(xml, record, tag);
			if (valueArray.length == 0) {fileCleaner("compare.log"); fileWriter("compare.log", "false"); error = "No records found!"; }
			
			for (int i = 0; i < valueArray.length; i++) {
				fileWriterPrinter("Record ID: " + (i + 1));
				fileWriterPrinter("Tag Value: " + valueArray[i]);

					boolean assertion = true;
					if (condition.equals("equal"))         { assertion = (valueArray[i].equals(expected));
					                                         error = "Not the same!";
					                                         reason = cpadMatchError; }
					
					if (condition.equals("greater"))       { assertion = (Integer.valueOf(valueArray[i]) > Integer.valueOf(expected));
					                                         error = "Less then expected minimum!";
					                                         reason = cpadGreaterError; }
					
					if (condition.equals("less or equal")) { assertion = (Integer.valueOf(valueArray[i]) <= Integer.valueOf(expected));
                                                             error = "Beyond expected maximum!";
                                                             reason = cpadLessOrEqualError; }
						
					if (assertion) {
						fileWriterPrinter("   Result: OK\n");
					} else {
						fileWriterPrinter("   Result: FAILED!");
						fileWriterPrinter("   Reason: " + reason);
						fileCleaner("compare.log");
						fileWriter("compare.log", "false");
						fileWriterPrinter();
					}

					if (ifAssert) {
						Assert.assertTrue(assertion, "   Result: FAILED\n");
					}
			}

			fileWriterPrinter("==========================");
			fileWriterPrinter();

			getAssertTrue(trace, error + " (URL " + combination + " OF " + total + ")", Boolean.valueOf(fileScanner("compare.log")), url);
			
			boolean result = Boolean.valueOf(fileScanner("compare.log")) && Boolean.valueOf(fileScanner("xml.log"));
			
			if ((fileExist("cpad.log", false)) && (!result)) { fileCleaner("cpad.log"); fileWriter("cpad.log", result); }
			
			fileCleaner("compare.log");
			fileCleaner("xml.log");
			return result;

		} catch (Exception exception) { /** exception.printStackTrace(); */ fileCleaner("cpad.log"); fileWriter("cpad.log", false); return false; }
	}
	
	/**
	 * Assert number of CPAD record tags is less then maximum
	 * Won't use Selenium WebDriver
	 * @throws IOException
	 */
	public boolean assertCpadTagsMaxNumber(
			StackTraceElement trace, String url, int combination, int total,
			Boolean ifAssert, String record, int max)
	throws IOException {
		try {
			fileWriterPrinter("\n" + "URL COMBINATION # " + combination + " OF " + total + ":");
			fileWriterPrinter(url);
			fileWriterPrinter("\n" + "Record Name: " + record);

			String xml = getUrlPageSourceSave(url);

			fileWriterPrinter("==========================");

			if (!fileExist("cpad.log", false)) { fileWriter("cpad.log", "true"); }
			if (!fileExist("max.log", false)) { fileWriter("max.log", "true"); }		
			
			if (!fileExist("xml.log",  false)) { fileWriter("xml.log",  "true"); }			
			xmlValidityChecker(xml, trace, combination, total);
			
			fileWriterPrinter("Records Number: " + xmlRecordLength(xml, record));
			boolean assertion = (xmlRecordLength(xml, record) <= max);

			if (assertion) { fileWriterPrinter("        Result: OK");
			        } else {
				             fileWriterPrinter("        Result: FAILED!");
				             fileWriterPrinter("        Reason: MORE THEN " + max + " <" + record + "> RECORDS FOUND...");
				             fileCleaner("max.log");
				             fileWriter( "max.log", "false");
				             }

			if (ifAssert) { Assert.assertTrue(assertion, "        Result: FAILED"); }

			fileWriterPrinter("==========================");
			fileWriterPrinter();
			
			getAssertTrue(trace, "Out of maximum! (URL " + combination + " OF " + total + ")", Boolean.valueOf(fileScanner("max.log")), url);

			boolean result = Boolean.valueOf(fileScanner("max.log")) && Boolean.valueOf(fileScanner("xml.log"));
			
			if ((fileExist("cpad.log", false)) && (!result)) { fileCleaner("cpad.log"); fileWriter("cpad.log", result); }
			
			fileCleaner("max.log");
			fileCleaner("xml.log");
			return result;

		} catch (Exception exception) { /** exception.printStackTrace(); */ fileCleaner("cpad.log"); fileWriter("cpad.log", false); return false; }
	}

	/**
	 * Assert CPAD record tags as dates filtered correctly
	 * Won't use Selenium WebDriver
	 * @throws IOException
	 */
	public boolean assertCpadTagsDateFilter(
		           StackTraceElement trace, String url, int combination, int total,
			       Boolean ifAssert, String record, String tag, String condition) 
	throws IOException {
		try {
			fileWriterPrinter("\n" + "URL COMBINATION # " + combination + " OF " + total + ":");
			fileWriterPrinter(url);
			fileWriterPrinter("\n" + "Record Name: " + record);
			fileWriterPrinter("   Tag Name: " + tag);

			String filter = url.substring(url.indexOf("=") + 1, url.indexOf("=") + 20);
			long Filter = convertCpadDateStampToMillisecondsAsLong(filter);

			String xml = getUrlPageSourceSave(url);;

			fileWriterPrinter();
			fileWriterPrinter("==========================");

			if (!fileExist("cpad.log", false)) { fileWriter("cpad.log", "true"); }
			if (!fileExist("filter.log", false )) { fileWriter("filter.log", "true"); }
			
			if (!fileExist("xml.log",  false)) { fileWriter("xml.log",  "true"); }			
			xmlValidityChecker(xml, trace, combination, total);
			
			String error = ""; String reason = "";
			String[] valueArray = xmlValueArray(xml, record, tag);
			long[] fingerprintArray = new long[valueArray.length];

			for (int i = 0; i < valueArray.length; i++) { fingerprintArray[i] = convertCpadDateStampToMillisecondsAsLong(valueArray[i]); }

			for (int i = 0; i < valueArray.length; i++) {
				fileWriterPrinter("Record ID: " + (i + 1));
				fileWriterPrinter("Tag Value: " + valueArray[i]);
				
				boolean assertFILTER = true;
				if (condition.equals("not before")) { assertFILTER = (fingerprintArray[i] >= Filter); error = "Before expected timestamp!";    reason = cpadFilterNotBeforeError; }
				if (condition.equals("after"))      { assertFILTER = (fingerprintArray[i] >  Filter); error = "Not after expected timestamp!"; reason = cpadFilterAfterError; }
				if (condition.equals("not after"))  { assertFILTER = (fingerprintArray[i] <= Filter); error = "After expected timestamp!";     reason = cpadFilterNotAfterError; }
						
				if (assertFILTER) {
					fileWriterPrinter("   Result: OK\n");
				} else {
						fileWriterPrinter("   Result: FAILED!");
						fileWriterPrinter("   Reason: " + reason);
						fileCleaner("filter.log");
						fileWriter("filter.log", "false");

						if (ifAssert) {
							fileWriterPrinter();
							fileWriterPrinter(" Record ID: " + (i + 2));
							fileWriterPrinter("Created On: " + valueArray[i + 1]);
						}

						fileWriterPrinter();
						
						fileWriter("record.log", "");					
						fileWriter("record.log", "Record ID: " + (i + 1));
						fileWriter("record.log", "Tag Value: " + valueArray[i]);
						fileWriter("record.log", " Expected: " + filter);
						fileWriter("record.log", "   Result: FAILED!");
						fileWriter("record.log", "   Reason: " + reason);
						fileWriter("record.log", "");
					}

					if (ifAssert) { Assert.assertTrue(assertFILTER, "   Result: FAILED\n"); }
			}

			fileWriterPrinter("==========================");
			fileWriterPrinter();

			getAssertTrue(trace, error + " (URL " + combination + " OF " + total + ")", Boolean.valueOf(fileScanner("filter.log")), url);

			boolean result = Boolean.valueOf(fileScanner("filter.log")) && Boolean.valueOf(fileScanner("xml.log"));
			
			if ((fileExist("cpad.log", false)) && (!result)) { fileCleaner("cpad.log"); fileWriter("cpad.log", result); }
			
			fileCleaner("filter.log");
			fileCleaner("xml.log");
			return result;

		} catch (Exception exception) { /** exception.printStackTrace(); */ fileCleaner("cpad.log"); fileWriter("cpad.log", false); return false; }
	}

	/**
	 * Assert CPAD record tags as dates are between the times from and to
	 * Won't use Selenium WebDriver
	 * @throws IOException
	 */
	public boolean assertCpadTagsDateBetween(
		           StackTraceElement trace, String url, int combination, int total,
			       Boolean ifAssert, String record, String tag) 
	throws IOException {
		try {
			fileWriterPrinter("\n" + "URL COMBINATION # " + combination + " OF " + total + ":");
			fileWriterPrinter(url);
			fileWriterPrinter("\n" + "Record Name: " + record);
			fileWriterPrinter("   Tag Name: " + tag);
			
			String time = url.substring(url.indexOf("from=") + 5, url.indexOf("&to="));
			  long from = convertCpadDateStampToMillisecondsAsLong(time);
			       time =  url.substring(url.indexOf("&to=") + 4, url.lastIndexOf(":") + 3);
			  long to   = convertCpadDateStampToMillisecondsAsLong(time);
			  
			String xml = getUrlPageSourceSave(url);

			fileWriterPrinter();
			fileWriterPrinter("==========================");

			if (!fileExist("cpad.log", false)) { fileWriter("cpad.log", "true"); }
			if (!fileExist("between.log", false )) { fileWriter("between.log", "true"); }
			
			if (!fileExist("xml.log",  false)) { fileWriter("xml.log",  "true"); }			
			xmlValidityChecker(xml, trace, combination, total);

			String[] valueArray = xmlValueArray(xml, record, tag);
			long[] fingerprintArray = new long[valueArray.length];

			for (int i = 0; i < valueArray.length; i++) { fingerprintArray[i] = convertCpadDateStampToMillisecondsAsLong(valueArray[i]); }

			for (int i = 0; i < valueArray.length; i++) {
				fileWriterPrinter("Record ID: " + (i + 1));
				fileWriterPrinter("Tag Value: " + valueArray[i]);

					boolean assertBETWEEN = ((fingerprintArray[i] >= from) && (fingerprintArray[i] <= to));

					if (assertBETWEEN) {
						fileWriterPrinter("   Result: OK\n");
					} else {
						fileWriterPrinter("   Result: FAILED!");
						fileWriterPrinter("   Reason: " + cpadBetweenError);
						fileCleaner("between.log");
						fileWriter("between.log", "false");

						if (ifAssert) {
							fileWriterPrinter();
							fileWriterPrinter(" Record ID: " + (i + 2));
							fileWriterPrinter("Created On: " + valueArray[i + 1]);
						}

						fileWriterPrinter();
					}

					if (ifAssert) { Assert.assertTrue(assertBETWEEN, "   Result: FAILED\n"); }
			}

			fileWriterPrinter("==========================");
			fileWriterPrinter();

			getAssertTrue(trace, "Not between expected timestamps! (URL " + combination + " OF " + total + ")", Boolean.valueOf(fileScanner("between.log")), url);

			boolean result = Boolean.valueOf(fileScanner("between.log")) && Boolean.valueOf(fileScanner("xml.log"));
			
			if ((fileExist("cpad.log", false)) && (!result)) { fileCleaner("cpad.log"); fileWriter("cpad.log", result); }
			
			fileCleaner("between.log");
			fileCleaner("xml.log");
			return result;

		} catch (Exception exception) { /** exception.printStackTrace(); */ fileCleaner("cpad.log"); fileWriter("cpad.log", false); return false; }
	}

}