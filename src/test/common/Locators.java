package test.common;

import java.io.File;

public class Locators {
	
	public static String outputFileDir     = System.getProperty("user.dir") + File.separator + "output" + File.separator;
	public static String testOutputFileDir = System.getProperty("user.dir") + File.separator + "test-output" + File.separator;
	public static String driverFileDir     = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"                                                 
                                           + File.separator + "resources" + File.separator + "drivers" + File.separator;

	/************************URL's**************************/
	public static String[][] combination(String a, String b, String c) {
		String[][] combination = { { a }, { b }, { c },
                                   { a, b }, { a, c }, { b, a },
                                   { b, c }, { c, a }, { c, b },
                                   { a, b, c }, { a, c, b }, { b, a, c },
                                   { b, c, a }, { c, a, b }, { c, b, a }
                                 };
		return combination;
	}

	public static String[] url(String root, String[][] join) {
		String[] url = new String[join.length];
		for (int i = 0; i < join.length; i++) { url[i] = root + join(join[i]); }
		return url;
	};	
	
	public static String join(String[] combination) {
		String result = "";
		for (int i = 0; i < combination.length; i++) {
			if (i == 0) { result = result + combination[i]; }
			       else { result = result + "&" + combination[i]; }
		}
		return result;
	}
	
}
