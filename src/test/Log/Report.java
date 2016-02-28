package test.Log;

import java.io.IOException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import test.helper.Functions;

@SuppressWarnings("static-access")
public class Report {
	Functions function = new Functions();
	
	/**
	 * Creates a new Test Log record as a text file named "run.log" create file
	 * example: File f = new File(<full path string>); f.createNewFile();
	 * @throws IOException
	 */
	@BeforeSuite
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
	@AfterSuite
	public void logClose() throws IOException {
		long finish = System.currentTimeMillis();
		String time = function.getCurrentDateTimeFull();
		// Scanning Failure Counter record:
		int failed = 0;
		if (function.fileExist("failed.num", false)) {
			failed = Integer.valueOf(function.fileScanner("failed.num"));
		}
		// Scanning Test Counter record:
		int n = 1;
		if (function.fileExist("test.num", false)) {
			if (!function.fileScanner("test.num").equals(null)) {
				n = Integer.valueOf(function.fileScanner("test.num"));
			}
		}
		if (n > 1) {
			// Scanning Initialization record:
			String startingTime = function.fileScanner("ini.time");
			long start = function.convertStringToLong(startingTime);
			function.fileWriterPrinter("TOTAL TESTS: "
					+ Integer.valueOf(function.fileScanner("test.num")));
			function.fileWriterPrinter("     FAILED: " + failed);
			function.fileWriterPrinter("TEST  START: "
					+ function.convertCalendarMillisecondsAsLongToDateTimeHourMinSec(start));
			function.fileWriterPrinter("TEST FINISH: " + time);
			function.fileWriterPrinter("TOTAL  TIME: "
					+ function.convertTimeMillisecondsAsLongToDuration(finish - start));
			function.fileWriterPrinter();
			// Final Log record:
			if (function.fileExist("run.log")) {
				function.fileWriter("run.log", "");
				function.fileWriter(
						"run.log",
						"TOTAL TESTS: "
								+ Integer.valueOf(function.fileScanner("test.num")));
				function.fileWriter("run.log", "     FAILED: " + failed);
				function.fileWriter(
						"run.log",
						"TEST  START: "
								+ function.convertCalendarMillisecondsAsLongToDateTimeHourMinSec(start));
				function.fileWriter("run.log", "TEST FINISH: " + time);
				function.fileWriter("run.log", "TOTAL  TIME: "
						+ function.convertTimeMillisecondsAsLongToDuration(finish
								- start));
				function.fileWriter("run.log", "");
			}
		}
		// Clean-up unnecessary file(s)
		function.fileCleaner("failed.num");
		function.fileCleaner("finish.time");
		function.fileCleaner("ini.time");
		function.fileCleaner("start.time");
		function.fileCleaner("stack.trace");
		function.fileCleaner("test.num");
		function.fileCleaner("xml.path");
		
	}
}
