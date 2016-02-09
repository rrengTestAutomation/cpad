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
	
    public static String[][] combination(String a, String b, String c, String d) {
        String[][] combination = { {a},{b},{c},{d},
                                   {a,b},{a,c},{a,d},{b,a},
                                   {b,c},{b,d},{c,a},{c,b},
                                   {c,d},{d,a},{d,b},{d,c},
                                   {a,b,c},{a,b,d},{a,c,b},{a,c,d},
                                   {a,d,b},{a,d,c},{b,a,c},{b,a,d},
                                   {b,c,a},{b,c,d},{b,d,a},{b,d,c},
                                   {c,a,b},{c,a,d},{c,b,a},{c,b,d},
                                   {c,d,a},{c,d,b},{d,a,b},{d,a,c},
                                   {d,b,a},{d,b,c},{d,c,a},{d,c,b},
                                   {a,b,c,d},{a,b,d,c},{a,c,b,d},{a,c,d,b},
                                   {a,d,b,c},{a,d,c,b},{b,a,c,d},{b,a,d,c},
                                   {b,c,a,d},{b,c,d,a},{b,d,a,c},{b,d,c,a},
                                   {c,a,b,d},{c,a,d,b},{c,b,a,d},{c,b,d,a},
                                   {c,d,a,b},{c,d,b,a},{d,a,b,c},{d,a,c,b},
                                   {d,b,a,c},{d,b,c,a},{d,c,a,b},{d,c,b,a}
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
		for (int i = 0; i < combination.length; i++) { result = result + "&" + combination[i]; }
		return result;
	}
	
}
