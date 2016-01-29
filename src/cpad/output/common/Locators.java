package cpad.output.common;

import java.io.File;

public class Locators {
	
	public static String outputFileDir     = System.getProperty("user.dir") + File.separator + "output" + File.separator;
	public static String testOutputFileDir = System.getProperty("user.dir") + File.separator + "test-output" + File.separator;
	public static String driverFileDir     = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"                                                 
              + File.separator + "resources" + File.separator + "drivers" + File.separator;
	
}
