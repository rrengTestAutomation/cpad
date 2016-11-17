package test.common;

import java.io.File;

public class Locators {
	
	public static String outputFileDir     = System.getProperty("user.dir") + File.separator + "output" + File.separator;
	public static String testOutputFileDir = System.getProperty("user.dir") + File.separator + "test-output" + File.separator;
	public static String driverFileDir     = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "drivers" + File.separator;
	public static String testIconFileDir   = System.getProperty("user.dir") + File.separator + "resources" +  File.separator + "icons" + File.separator;
	
	/************************URL's**************************/
	public static String cpadServerURL    = System.getProperty("URL");                                                     // used to be: cpadServer + "/CPAD/";
	public static String cpadServer       = cpadServerURL.substring(0, cpadServerURL.indexOf("/CPAD/"));                   // used to be: System.getProperty("URL");                                               // used to be: "http://" + cpadServerDomain;
	public static String cpadServerDomain = cpadServer.substring(cpadServer.lastIndexOf("://") + 3, cpadServer.length());  // used to be: "v-cpad-p01.tvo.org:8080";	
	
	
	public static String[][] combination(String a) {
		String[][] combination = { { a } };
		return combination;
	}
	
	public static String[][] combination(String a, String b) {
		String[][] combination = { { a }, { b },
                                   { a, b }, { b, a }
                                 };
		return combination;
	}
	
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
    
    public static String[][] combination(String a, String b, String c, String d, String e) {
        String[][] combination = { {a},{b},{c},{d},{e},
        		                   {a,b},{a,c},{a,d},{a,e},{b,a},
        		                   {b,c},{b,d},{b,e},{c,a},{c,b},
        		                   {c,d},{c,e},{d,a},{d,b},{d,c},
        		                   {d,e},{e,a},{e,b},{e,c},{e,d},
        		                   {a,b,c},{a,b,d},{a,b,e},{a,c,b},{a,c,d},{a,c,e},{a,d,b},{a,d,c},{a,d,e},{a,e,b},
        		                   {a,e,c},{a,e,d},{b,a,c},{b,a,d},{b,a,e},{b,c,a},{b,c,d},{b,c,e},{b,d,a},{b,d,c},
        		                   {b,d,e},{b,e,a},{b,e,c},{b,e,d},{c,a,b},{c,a,d},{c,a,e},{c,b,a},{c,b,d},{c,b,e},
        		                   {c,d,a},{c,d,b},{c,d,e},{c,e,a},{c,e,b},{c,e,d},{d,a,b},{d,a,c},{d,a,e},{d,b,a},
        		                   {d,b,c},{d,b,e},{d,c,a},{d,c,b},{d,c,e},{d,e,a},{d,e,b},{d,e,c},{e,a,b},{e,a,c},
        		                   {e,a,d},{e,b,a},{e,b,c},{e,b,d},{e,c,a},{e,c,b},{e,c,d},{e,d,a},{e,d,b},{e,d,c},
        		                   {a,b,c,d},{a,b,c,e},{a,b,d,c},{a,b,d,e},{a,b,e,c},{a,b,e,d},{a,c,b,d},{a,c,b,e},{a,c,d,b},{a,c,d,e},{a,c,e,b},{a,c,e,d},
        		                   {a,d,b,c},{a,d,b,e},{a,d,c,b},{a,d,c,e},{a,d,e,b},{a,d,e,c},{a,e,b,c},{a,e,b,d},{a,e,c,b},{a,e,c,d},{a,e,d,b},{a,e,d,c},
        		                   {b,a,c,d},{b,a,c,e},{b,a,d,c},{b,a,d,e},{b,a,e,c},{b,a,e,d},{b,c,a,d},{b,c,a,e},{b,c,d,a},{b,c,d,e},{b,c,e,a},{b,c,e,d},
        		                   {b,d,a,c},{b,d,a,e},{b,d,c,a},{b,d,c,e},{b,d,e,a},{b,d,e,c},{b,e,a,c},{b,e,a,d},{b,e,c,a},{b,e,c,d},{b,e,d,a},{b,e,d,c},
        		                   {c,a,b,d},{c,a,b,e},{c,a,d,b},{c,a,d,e},{c,a,e,b},{c,a,e,d},{c,b,a,d},{c,b,a,e},{c,b,d,a},{c,b,d,e},{c,b,e,a},{c,b,e,d},
        		                   {c,d,a,b},{c,d,a,e},{c,d,b,a},{c,d,b,e},{c,d,e,a},{c,d,e,b},{c,e,a,b},{c,e,a,d},{c,e,b,a},{c,e,b,d},{c,e,d,a},{c,e,d,b},
        		                   {d,a,b,c},{d,a,b,e},{d,a,c,b},{d,a,c,e},{d,a,e,b},{d,a,e,c},{d,b,a,c},{d,b,a,e},{d,b,c,a},{d,b,c,e},{d,b,e,a},{d,b,e,c},
        		                   {d,c,a,b},{d,c,a,e},{d,c,b,a},{d,c,b,e},{d,c,e,a},{d,c,e,b},{d,e,a,b},{d,e,a,c},{d,e,b,a},{d,e,b,c},{d,e,c,a},{d,e,c,b},
        		                   {e,a,b,c},{e,a,b,d},{e,a,c,b},{e,a,c,d},{e,a,d,b},{e,a,d,c},{e,b,a,c},{e,b,a,d},{e,b,c,a},{e,b,c,d},{e,b,d,a},{e,b,d,c},
        		                   {e,c,a,b},{e,c,a,d},{e,c,b,a},{e,c,b,d},{e,c,d,a},{e,c,d,b},{e,d,a,b},{e,d,a,c},{e,d,b,a},{e,d,b,c},{e,d,c,a},{e,d,c,b},
        		                   {a,b,c,d,e},{a,b,c,e,d},{a,b,d,c,e},{a,b,d,e,c},{a,b,e,c,d},{a,b,e,d,c},{a,c,b,d,e},{a,c,b,e,d},{a,c,d,b,e},{a,c,d,e,b},{a,c,e,b,d},{a,c,e,d,b},
        		                   {a,d,b,c,e},{a,d,b,e,c},{a,d,c,b,e},{a,d,c,e,b},{a,d,e,b,c},{a,d,e,c,b},{a,e,b,c,d},{a,e,b,d,c},{a,e,c,b,d},{a,e,c,d,b},{a,e,d,b,c},{a,e,d,c,b},
        		                   {b,a,c,d,e},{b,a,c,e,d},{b,a,d,c,e},{b,a,d,e,c},{b,a,e,c,d},{b,a,e,d,c},{b,c,a,d,e},{b,c,a,e,d},{b,c,d,a,e},{b,c,d,e,a},{b,c,e,a,d},{b,c,e,d,a},
        		                   {b,d,a,c,e},{b,d,a,e,c},{b,d,c,a,e},{b,d,c,e,a},{b,d,e,a,c},{b,d,e,c,a},{b,e,a,c,d},{b,e,a,d,c},{b,e,c,a,d},{b,e,c,d,a},{b,e,d,a,c},{b,e,d,c,a},
        		                   {c,a,b,d,e},{c,a,b,e,d},{c,a,d,b,e},{c,a,d,e,b},{c,a,e,b,d},{c,a,e,d,b},{c,b,a,d,e},{c,b,a,e,d},{c,b,d,a,e},{c,b,d,e,a},{c,b,e,a,d},{c,b,e,d,a},
        		                   {c,d,a,b,e},{c,d,a,e,b},{c,d,b,a,e},{c,d,b,e,a},{c,d,e,a,b},{c,d,e,b,a},{c,e,a,b,d},{c,e,a,d,b},{c,e,b,a,d},{c,e,b,d,a},{c,e,d,a,b},{c,e,d,b,a},
        		                   {d,a,b,c,e},{d,a,b,e,c},{d,a,c,b,e},{d,a,c,e,b},{d,a,e,b,c},{d,a,e,c,b},{d,b,a,c,e},{d,b,a,e,c},{d,b,c,a,e},{d,b,c,e,a},{d,b,e,a,c},{d,b,e,c,a},
        		                   {d,c,a,b,e},{d,c,a,e,b},{d,c,b,a,e},{d,c,b,e,a},{d,c,e,a,b},{d,c,e,b,a},{d,e,a,b,c},{d,e,a,c,b},{d,e,b,a,c},{d,e,b,c,a},{d,e,c,a,b},{d,e,c,b,a},
        		                   {e,a,b,c,d},{e,a,b,d,c},{e,a,c,b,d},{e,a,c,d,b},{e,a,d,b,c},{e,a,d,c,b},{e,b,a,c,d},{e,b,a,d,c},{e,b,c,a,d},{e,b,c,d,a},{e,b,d,a,c},{e,b,d,c,a},
        		                   {e,c,a,b,d},{e,c,a,d,b},{e,c,b,a,d},{e,c,b,d,a},{e,c,d,a,b},{e,c,d,b,a},{e,d,a,b,c},{e,d,a,c,b},{e,d,b,a,c},{e,d,b,c,a},{e,d,c,a,b},{e,d,c,b,a}
                                 };
        return combination;
    }
    
    public static String[][] combination(String a, String b, String c, String d, String e, String f) {
        String[][] combination = { {a},{b},{c},{d},{e},{f},
                {a,b},{a,c},{a,d},{a,e},{a,f},{b,a},{b,c},{b,d},{b,e},{b,f},
                {c,a},{c,b},{c,d},{c,e},{c,f},{d,a},{d,b},{d,c},{d,e},{d,f},
                {e,a},{e,b},{e,c},{e,d},{e,f},{f,a},{f,b},{f,c},{f,d},{f,e},
                {a,b,c},{a,b,d},{a,b,e},{a,b,f},{a,c,b},{a,c,d},{a,c,e},{a,c,f},{a,d,b},{a,d,c},
                {a,d,e},{a,d,f},{a,e,b},{a,e,c},{a,e,d},{a,e,f},{a,f,b},{a,f,c},{a,f,d},{a,f,e},
                {b,a,c},{b,a,d},{b,a,e},{b,a,f},{b,c,a},{b,c,d},{b,c,e},{b,c,f},{b,d,a},{b,d,c},
                {b,d,e},{b,d,f},{b,e,a},{b,e,c},{b,e,d},{b,e,f},{b,f,a},{b,f,c},{b,f,d},{b,f,e},
                {c,a,b},{c,a,d},{c,a,e},{c,a,f},{c,b,a},{c,b,d},{c,b,e},{c,b,f},{c,d,a},{c,d,b},
                {c,d,e},{c,d,f},{c,e,a},{c,e,b},{c,e,d},{c,e,f},{c,f,a},{c,f,b},{c,f,d},{c,f,e},
                {d,a,b},{d,a,c},{d,a,e},{d,a,f},{d,b,a},{d,b,c},{d,b,e},{d,b,f},{d,c,a},{d,c,b},
                {d,c,e},{d,c,f},{d,e,a},{d,e,b},{d,e,c},{d,e,f},{d,f,a},{d,f,b},{d,f,c},{d,f,e},
                {e,a,b},{e,a,c},{e,a,d},{e,a,f},{e,b,a},{e,b,c},{e,b,d},{e,b,f},{e,c,a},{e,c,b},
                {e,c,d},{e,c,f},{e,d,a},{e,d,b},{e,d,c},{e,d,f},{e,f,a},{e,f,b},{e,f,c},{e,f,d},
                {f,a,b},{f,a,c},{f,a,d},{f,a,e},{f,b,a},{f,b,c},{f,b,d},{f,b,e},{f,c,a},{f,c,b},
                {f,c,d},{f,c,e},{f,d,a},{f,d,b},{f,d,c},{f,d,e},{f,e,a},{f,e,b},{f,e,c},{f,e,d},
                {a,b,c,d},{a,b,c,e},{a,b,c,f},{a,b,d,c},{a,b,d,e},{a,b,d,f},{a,b,e,c},{a,b,e,d},{a,b,e,f},{a,b,f,c},{a,b,f,d},{a,b,f,e},
                {a,c,b,d},{a,c,b,e},{a,c,b,f},{a,c,d,b},{a,c,d,e},{a,c,d,f},{a,c,e,b},{a,c,e,d},{a,c,e,f},{a,c,f,b},{a,c,f,d},{a,c,f,e},
                {a,d,b,c},{a,d,b,e},{a,d,b,f},{a,d,c,b},{a,d,c,e},{a,d,c,f},{a,d,e,b},{a,d,e,c},{a,d,e,f},{a,d,f,b},{a,d,f,c},{a,d,f,e},
                {a,e,b,c},{a,e,b,d},{a,e,b,f},{a,e,c,b},{a,e,c,d},{a,e,c,f},{a,e,d,b},{a,e,d,c},{a,e,d,f},{a,e,f,b},{a,e,f,c},{a,e,f,d},
                {a,f,b,c},{a,f,b,d},{a,f,b,e},{a,f,c,b},{a,f,c,d},{a,f,c,e},{a,f,d,b},{a,f,d,c},{a,f,d,e},{a,f,e,b},{a,f,e,c},{a,f,e,d},
                {b,a,c,d},{b,a,c,e},{b,a,c,f},{b,a,d,c},{b,a,d,e},{b,a,d,f},{b,a,e,c},{b,a,e,d},{b,a,e,f},{b,a,f,c},{b,a,f,d},{b,a,f,e},
                {b,c,a,d},{b,c,a,e},{b,c,a,f},{b,c,d,a},{b,c,d,e},{b,c,d,f},{b,c,e,a},{b,c,e,d},{b,c,e,f},{b,c,f,a},{b,c,f,d},{b,c,f,e},
                {b,d,a,c},{b,d,a,e},{b,d,a,f},{b,d,c,a},{b,d,c,e},{b,d,c,f},{b,d,e,a},{b,d,e,c},{b,d,e,f},{b,d,f,a},{b,d,f,c},{b,d,f,e},
                {b,e,a,c},{b,e,a,d},{b,e,a,f},{b,e,c,a},{b,e,c,d},{b,e,c,f},{b,e,d,a},{b,e,d,c},{b,e,d,f},{b,e,f,a},{b,e,f,c},{b,e,f,d},
                {b,f,a,c},{b,f,a,d},{b,f,a,e},{b,f,c,a},{b,f,c,d},{b,f,c,e},{b,f,d,a},{b,f,d,c},{b,f,d,e},{b,f,e,a},{b,f,e,c},{b,f,e,d},
                {c,a,b,d},{c,a,b,e},{c,a,b,f},{c,a,d,b},{c,a,d,e},{c,a,d,f},{c,a,e,b},{c,a,e,d},{c,a,e,f},{c,a,f,b},{c,a,f,d},{c,a,f,e},
                {c,b,a,d},{c,b,a,e},{c,b,a,f},{c,b,d,a},{c,b,d,e},{c,b,d,f},{c,b,e,a},{c,b,e,d},{c,b,e,f},{c,b,f,a},{c,b,f,d},{c,b,f,e},
                {c,d,a,b},{c,d,a,e},{c,d,a,f},{c,d,b,a},{c,d,b,e},{c,d,b,f},{c,d,e,a},{c,d,e,b},{c,d,e,f},{c,d,f,a},{c,d,f,b},{c,d,f,e},
                {c,e,a,b},{c,e,a,d},{c,e,a,f},{c,e,b,a},{c,e,b,d},{c,e,b,f},{c,e,d,a},{c,e,d,b},{c,e,d,f},{c,e,f,a},{c,e,f,b},{c,e,f,d},
                {c,f,a,b},{c,f,a,d},{c,f,a,e},{c,f,b,a},{c,f,b,d},{c,f,b,e},{c,f,d,a},{c,f,d,b},{c,f,d,e},{c,f,e,a},{c,f,e,b},{c,f,e,d},
                {d,a,b,c},{d,a,b,e},{d,a,b,f},{d,a,c,b},{d,a,c,e},{d,a,c,f},{d,a,e,b},{d,a,e,c},{d,a,e,f},{d,a,f,b},{d,a,f,c},{d,a,f,e},
                {d,b,a,c},{d,b,a,e},{d,b,a,f},{d,b,c,a},{d,b,c,e},{d,b,c,f},{d,b,e,a},{d,b,e,c},{d,b,e,f},{d,b,f,a},{d,b,f,c},{d,b,f,e},
                {d,c,a,b},{d,c,a,e},{d,c,a,f},{d,c,b,a},{d,c,b,e},{d,c,b,f},{d,c,e,a},{d,c,e,b},{d,c,e,f},{d,c,f,a},{d,c,f,b},{d,c,f,e},
                {d,e,a,b},{d,e,a,c},{d,e,a,f},{d,e,b,a},{d,e,b,c},{d,e,b,f},{d,e,c,a},{d,e,c,b},{d,e,c,f},{d,e,f,a},{d,e,f,b},{d,e,f,c},
                {d,f,a,b},{d,f,a,c},{d,f,a,e},{d,f,b,a},{d,f,b,c},{d,f,b,e},{d,f,c,a},{d,f,c,b},{d,f,c,e},{d,f,e,a},{d,f,e,b},{d,f,e,c},
                {e,a,b,c},{e,a,b,d},{e,a,b,f},{e,a,c,b},{e,a,c,d},{e,a,c,f},{e,a,d,b},{e,a,d,c},{e,a,d,f},{e,a,f,b},{e,a,f,c},{e,a,f,d},
                {e,b,a,c},{e,b,a,d},{e,b,a,f},{e,b,c,a},{e,b,c,d},{e,b,c,f},{e,b,d,a},{e,b,d,c},{e,b,d,f},{e,b,f,a},{e,b,f,c},{e,b,f,d},
                {e,c,a,b},{e,c,a,d},{e,c,a,f},{e,c,b,a},{e,c,b,d},{e,c,b,f},{e,c,d,a},{e,c,d,b},{e,c,d,f},{e,c,f,a},{e,c,f,b},{e,c,f,d},
                {e,d,a,b},{e,d,a,c},{e,d,a,f},{e,d,b,a},{e,d,b,c},{e,d,b,f},{e,d,c,a},{e,d,c,b},{e,d,c,f},{e,d,f,a},{e,d,f,b},{e,d,f,c},
                {e,f,a,b},{e,f,a,c},{e,f,a,d},{e,f,b,a},{e,f,b,c},{e,f,b,d},{e,f,c,a},{e,f,c,b},{e,f,c,d},{e,f,d,a},{e,f,d,b},{e,f,d,c},
                {f,a,b,c},{f,a,b,d},{f,a,b,e},{f,a,c,b},{f,a,c,d},{f,a,c,e},{f,a,d,b},{f,a,d,c},{f,a,d,e},{f,a,e,b},{f,a,e,c},{f,a,e,d},
                {f,b,a,c},{f,b,a,d},{f,b,a,e},{f,b,c,a},{f,b,c,d},{f,b,c,e},{f,b,d,a},{f,b,d,c},{f,b,d,e},{f,b,e,a},{f,b,e,c},{f,b,e,d},
                {f,c,a,b},{f,c,a,d},{f,c,a,e},{f,c,b,a},{f,c,b,d},{f,c,b,e},{f,c,d,a},{f,c,d,b},{f,c,d,e},{f,c,e,a},{f,c,e,b},{f,c,e,d},
                {f,d,a,b},{f,d,a,c},{f,d,a,e},{f,d,b,a},{f,d,b,c},{f,d,b,e},{f,d,c,a},{f,d,c,b},{f,d,c,e},{f,d,e,a},{f,d,e,b},{f,d,e,c},
                {f,e,a,b},{f,e,a,c},{f,e,a,d},{f,e,b,a},{f,e,b,c},{f,e,b,d},{f,e,c,a},{f,e,c,b},{f,e,c,d},{f,e,d,a},{f,e,d,b},{f,e,d,c},
                {a,b,c,d,e},{a,b,c,d,f},{a,b,c,e,d},{a,b,c,e,f},{a,b,c,f,d},{a,b,c,f,e},{a,b,d,c,e},{a,b,d,c,f},{a,b,d,e,c},{a,b,d,e,f},{a,b,d,f,c},{a,b,d,f,e},
                {a,b,e,c,d},{a,b,e,c,f},{a,b,e,d,c},{a,b,e,d,f},{a,b,e,f,c},{a,b,e,f,d},{a,b,f,c,d},{a,b,f,c,e},{a,b,f,d,c},{a,b,f,d,e},{a,b,f,e,c},{a,b,f,e,d},
                {a,c,b,d,e},{a,c,b,d,f},{a,c,b,e,d},{a,c,b,e,f},{a,c,b,f,d},{a,c,b,f,e},{a,c,d,b,e},{a,c,d,b,f},{a,c,d,e,b},{a,c,d,e,f},{a,c,d,f,b},{a,c,d,f,e},
                {a,c,e,b,d},{a,c,e,b,f},{a,c,e,d,b},{a,c,e,d,f},{a,c,e,f,b},{a,c,e,f,d},{a,c,f,b,d},{a,c,f,b,e},{a,c,f,d,b},{a,c,f,d,e},{a,c,f,e,b},{a,c,f,e,d},
                {a,d,b,c,e},{a,d,b,c,f},{a,d,b,e,c},{a,d,b,e,f},{a,d,b,f,c},{a,d,b,f,e},{a,d,c,b,e},{a,d,c,b,f},{a,d,c,e,b},{a,d,c,e,f},{a,d,c,f,b},{a,d,c,f,e},
                {a,d,e,b,c},{a,d,e,b,f},{a,d,e,c,b},{a,d,e,c,f},{a,d,e,f,b},{a,d,e,f,c},{a,d,f,b,c},{a,d,f,b,e},{a,d,f,c,b},{a,d,f,c,e},{a,d,f,e,b},{a,d,f,e,c},
                {a,e,b,c,d},{a,e,b,c,f},{a,e,b,d,c},{a,e,b,d,f},{a,e,b,f,c},{a,e,b,f,d},{a,e,c,b,d},{a,e,c,b,f},{a,e,c,d,b},{a,e,c,d,f},{a,e,c,f,b},{a,e,c,f,d},
                {a,e,d,b,c},{a,e,d,b,f},{a,e,d,c,b},{a,e,d,c,f},{a,e,d,f,b},{a,e,d,f,c},{a,e,f,b,c},{a,e,f,b,d},{a,e,f,c,b},{a,e,f,c,d},{a,e,f,d,b},{a,e,f,d,c},
                {a,f,b,c,d},{a,f,b,c,e},{a,f,b,d,c},{a,f,b,d,e},{a,f,b,e,c},{a,f,b,e,d},{a,f,c,b,d},{a,f,c,b,e},{a,f,c,d,b},{a,f,c,d,e},{a,f,c,e,b},{a,f,c,e,d},
                {a,f,d,b,c},{a,f,d,b,e},{a,f,d,c,b},{a,f,d,c,e},{a,f,d,e,b},{a,f,d,e,c},{a,f,e,b,c},{a,f,e,b,d},{a,f,e,c,b},{a,f,e,c,d},{a,f,e,d,b},{a,f,e,d,c},
                {b,a,c,d,e},{b,a,c,d,f},{b,a,c,e,d},{b,a,c,e,f},{b,a,c,f,d},{b,a,c,f,e},{b,a,d,c,e},{b,a,d,c,f},{b,a,d,e,c},{b,a,d,e,f},{b,a,d,f,c},{b,a,d,f,e},
                {b,a,e,c,d},{b,a,e,c,f},{b,a,e,d,c},{b,a,e,d,f},{b,a,e,f,c},{b,a,e,f,d},{b,a,f,c,d},{b,a,f,c,e},{b,a,f,d,c},{b,a,f,d,e},{b,a,f,e,c},{b,a,f,e,d},
                {b,c,a,d,e},{b,c,a,d,f},{b,c,a,e,d},{b,c,a,e,f},{b,c,a,f,d},{b,c,a,f,e},{b,c,d,a,e},{b,c,d,a,f},{b,c,d,e,a},{b,c,d,e,f},{b,c,d,f,a},{b,c,d,f,e},
                {b,c,e,a,d},{b,c,e,a,f},{b,c,e,d,a},{b,c,e,d,f},{b,c,e,f,a},{b,c,e,f,d},{b,c,f,a,d},{b,c,f,a,e},{b,c,f,d,a},{b,c,f,d,e},{b,c,f,e,a},{b,c,f,e,d},
                {b,d,a,c,e},{b,d,a,c,f},{b,d,a,e,c},{b,d,a,e,f},{b,d,a,f,c},{b,d,a,f,e},{b,d,c,a,e},{b,d,c,a,f},{b,d,c,e,a},{b,d,c,e,f},{b,d,c,f,a},{b,d,c,f,e},
                {b,d,e,a,c},{b,d,e,a,f},{b,d,e,c,a},{b,d,e,c,f},{b,d,e,f,a},{b,d,e,f,c},{b,d,f,a,c},{b,d,f,a,e},{b,d,f,c,a},{b,d,f,c,e},{b,d,f,e,a},{b,d,f,e,c},
                {b,e,a,c,d},{b,e,a,c,f},{b,e,a,d,c},{b,e,a,d,f},{b,e,a,f,c},{b,e,a,f,d},{b,e,c,a,d},{b,e,c,a,f},{b,e,c,d,a},{b,e,c,d,f},{b,e,c,f,a},{b,e,c,f,d},
                {b,e,d,a,c},{b,e,d,a,f},{b,e,d,c,a},{b,e,d,c,f},{b,e,d,f,a},{b,e,d,f,c},{b,e,f,a,c},{b,e,f,a,d},{b,e,f,c,a},{b,e,f,c,d},{b,e,f,d,a},{b,e,f,d,c},
                {b,f,a,c,d},{b,f,a,c,e},{b,f,a,d,c},{b,f,a,d,e},{b,f,a,e,c},{b,f,a,e,d},{b,f,c,a,d},{b,f,c,a,e},{b,f,c,d,a},{b,f,c,d,e},{b,f,c,e,a},{b,f,c,e,d},
                {b,f,d,a,c},{b,f,d,a,e},{b,f,d,c,a},{b,f,d,c,e},{b,f,d,e,a},{b,f,d,e,c},{b,f,e,a,c},{b,f,e,a,d},{b,f,e,c,a},{b,f,e,c,d},{b,f,e,d,a},{b,f,e,d,c},
                {c,a,b,d,e},{c,a,b,d,f},{c,a,b,e,d},{c,a,b,e,f},{c,a,b,f,d},{c,a,b,f,e},{c,a,d,b,e},{c,a,d,b,f},{c,a,d,e,b},{c,a,d,e,f},{c,a,d,f,b},{c,a,d,f,e},
                {c,a,e,b,d},{c,a,e,b,f},{c,a,e,d,b},{c,a,e,d,f},{c,a,e,f,b},{c,a,e,f,d},{c,a,f,b,d},{c,a,f,b,e},{c,a,f,d,b},{c,a,f,d,e},{c,a,f,e,b},{c,a,f,e,d},
                {c,b,a,d,e},{c,b,a,d,f},{c,b,a,e,d},{c,b,a,e,f},{c,b,a,f,d},{c,b,a,f,e},{c,b,d,a,e},{c,b,d,a,f},{c,b,d,e,a},{c,b,d,e,f},{c,b,d,f,a},{c,b,d,f,e},
                {c,b,e,a,d},{c,b,e,a,f},{c,b,e,d,a},{c,b,e,d,f},{c,b,e,f,a},{c,b,e,f,d},{c,b,f,a,d},{c,b,f,a,e},{c,b,f,d,a},{c,b,f,d,e},{c,b,f,e,a},{c,b,f,e,d},
                {c,d,a,b,e},{c,d,a,b,f},{c,d,a,e,b},{c,d,a,e,f},{c,d,a,f,b},{c,d,a,f,e},{c,d,b,a,e},{c,d,b,a,f},{c,d,b,e,a},{c,d,b,e,f},{c,d,b,f,a},{c,d,b,f,e},
                {c,d,e,a,b},{c,d,e,a,f},{c,d,e,b,a},{c,d,e,b,f},{c,d,e,f,a},{c,d,e,f,b},{c,d,f,a,b},{c,d,f,a,e},{c,d,f,b,a},{c,d,f,b,e},{c,d,f,e,a},{c,d,f,e,b},
                {c,e,a,b,d},{c,e,a,b,f},{c,e,a,d,b},{c,e,a,d,f},{c,e,a,f,b},{c,e,a,f,d},{c,e,b,a,d},{c,e,b,a,f},{c,e,b,d,a},{c,e,b,d,f},{c,e,b,f,a},{c,e,b,f,d},
                {c,e,d,a,b},{c,e,d,a,f},{c,e,d,b,a},{c,e,d,b,f},{c,e,d,f,a},{c,e,d,f,b},{c,e,f,a,b},{c,e,f,a,d},{c,e,f,b,a},{c,e,f,b,d},{c,e,f,d,a},{c,e,f,d,b},
                {c,f,a,b,d},{c,f,a,b,e},{c,f,a,d,b},{c,f,a,d,e},{c,f,a,e,b},{c,f,a,e,d},{c,f,b,a,d},{c,f,b,a,e},{c,f,b,d,a},{c,f,b,d,e},{c,f,b,e,a},{c,f,b,e,d},
                {c,f,d,a,b},{c,f,d,a,e},{c,f,d,b,a},{c,f,d,b,e},{c,f,d,e,a},{c,f,d,e,b},{c,f,e,a,b},{c,f,e,a,d},{c,f,e,b,a},{c,f,e,b,d},{c,f,e,d,a},{c,f,e,d,b},
                {d,a,b,c,e},{d,a,b,c,f},{d,a,b,e,c},{d,a,b,e,f},{d,a,b,f,c},{d,a,b,f,e},{d,a,c,b,e},{d,a,c,b,f},{d,a,c,e,b},{d,a,c,e,f},{d,a,c,f,b},{d,a,c,f,e},
                {d,a,e,b,c},{d,a,e,b,f},{d,a,e,c,b},{d,a,e,c,f},{d,a,e,f,b},{d,a,e,f,c},{d,a,f,b,c},{d,a,f,b,e},{d,a,f,c,b},{d,a,f,c,e},{d,a,f,e,b},{d,a,f,e,c},
                {d,b,a,c,e},{d,b,a,c,f},{d,b,a,e,c},{d,b,a,e,f},{d,b,a,f,c},{d,b,a,f,e},{d,b,c,a,e},{d,b,c,a,f},{d,b,c,e,a},{d,b,c,e,f},{d,b,c,f,a},{d,b,c,f,e},
                {d,b,e,a,c},{d,b,e,a,f},{d,b,e,c,a},{d,b,e,c,f},{d,b,e,f,a},{d,b,e,f,c},{d,b,f,a,c},{d,b,f,a,e},{d,b,f,c,a},{d,b,f,c,e},{d,b,f,e,a},{d,b,f,e,c},
                {d,c,a,b,e},{d,c,a,b,f},{d,c,a,e,b},{d,c,a,e,f},{d,c,a,f,b},{d,c,a,f,e},{d,c,b,a,e},{d,c,b,a,f},{d,c,b,e,a},{d,c,b,e,f},{d,c,b,f,a},{d,c,b,f,e},
                {d,c,e,a,b},{d,c,e,a,f},{d,c,e,b,a},{d,c,e,b,f},{d,c,e,f,a},{d,c,e,f,b},{d,c,f,a,b},{d,c,f,a,e},{d,c,f,b,a},{d,c,f,b,e},{d,c,f,e,a},{d,c,f,e,b},
                {d,e,a,b,c},{d,e,a,b,f},{d,e,a,c,b},{d,e,a,c,f},{d,e,a,f,b},{d,e,a,f,c},{d,e,b,a,c},{d,e,b,a,f},{d,e,b,c,a},{d,e,b,c,f},{d,e,b,f,a},{d,e,b,f,c},
                {d,e,c,a,b},{d,e,c,a,f},{d,e,c,b,a},{d,e,c,b,f},{d,e,c,f,a},{d,e,c,f,b},{d,e,f,a,b},{d,e,f,a,c},{d,e,f,b,a},{d,e,f,b,c},{d,e,f,c,a},{d,e,f,c,b},
                {d,f,a,b,c},{d,f,a,b,e},{d,f,a,c,b},{d,f,a,c,e},{d,f,a,e,b},{d,f,a,e,c},{d,f,b,a,c},{d,f,b,a,e},{d,f,b,c,a},{d,f,b,c,e},{d,f,b,e,a},{d,f,b,e,c},
                {d,f,c,a,b},{d,f,c,a,e},{d,f,c,b,a},{d,f,c,b,e},{d,f,c,e,a},{d,f,c,e,b},{d,f,e,a,b},{d,f,e,a,c},{d,f,e,b,a},{d,f,e,b,c},{d,f,e,c,a},{d,f,e,c,b},
                {e,a,b,c,d},{e,a,b,c,f},{e,a,b,d,c},{e,a,b,d,f},{e,a,b,f,c},{e,a,b,f,d},{e,a,c,b,d},{e,a,c,b,f},{e,a,c,d,b},{e,a,c,d,f},{e,a,c,f,b},{e,a,c,f,d},
                {e,a,d,b,c},{e,a,d,b,f},{e,a,d,c,b},{e,a,d,c,f},{e,a,d,f,b},{e,a,d,f,c},{e,a,f,b,c},{e,a,f,b,d},{e,a,f,c,b},{e,a,f,c,d},{e,a,f,d,b},{e,a,f,d,c},
                {e,b,a,c,d},{e,b,a,c,f},{e,b,a,d,c},{e,b,a,d,f},{e,b,a,f,c},{e,b,a,f,d},{e,b,c,a,d},{e,b,c,a,f},{e,b,c,d,a},{e,b,c,d,f},{e,b,c,f,a},{e,b,c,f,d},
                {e,b,d,a,c},{e,b,d,a,f},{e,b,d,c,a},{e,b,d,c,f},{e,b,d,f,a},{e,b,d,f,c},{e,b,f,a,c},{e,b,f,a,d},{e,b,f,c,a},{e,b,f,c,d},{e,b,f,d,a},{e,b,f,d,c},
                {e,c,a,b,d},{e,c,a,b,f},{e,c,a,d,b},{e,c,a,d,f},{e,c,a,f,b},{e,c,a,f,d},{e,c,b,a,d},{e,c,b,a,f},{e,c,b,d,a},{e,c,b,d,f},{e,c,b,f,a},{e,c,b,f,d},
                {e,c,d,a,b},{e,c,d,a,f},{e,c,d,b,a},{e,c,d,b,f},{e,c,d,f,a},{e,c,d,f,b},{e,c,f,a,b},{e,c,f,a,d},{e,c,f,b,a},{e,c,f,b,d},{e,c,f,d,a},{e,c,f,d,b},
                {e,d,a,b,c},{e,d,a,b,f},{e,d,a,c,b},{e,d,a,c,f},{e,d,a,f,b},{e,d,a,f,c},{e,d,b,a,c},{e,d,b,a,f},{e,d,b,c,a},{e,d,b,c,f},{e,d,b,f,a},{e,d,b,f,c},
                {e,d,c,a,b},{e,d,c,a,f},{e,d,c,b,a},{e,d,c,b,f},{e,d,c,f,a},{e,d,c,f,b},{e,d,f,a,b},{e,d,f,a,c},{e,d,f,b,a},{e,d,f,b,c},{e,d,f,c,a},{e,d,f,c,b},
                {e,f,a,b,c},{e,f,a,b,d},{e,f,a,c,b},{e,f,a,c,d},{e,f,a,d,b},{e,f,a,d,c},{e,f,b,a,c},{e,f,b,a,d},{e,f,b,c,a},{e,f,b,c,d},{e,f,b,d,a},{e,f,b,d,c},
                {e,f,c,a,b},{e,f,c,a,d},{e,f,c,b,a},{e,f,c,b,d},{e,f,c,d,a},{e,f,c,d,b},{e,f,d,a,b},{e,f,d,a,c},{e,f,d,b,a},{e,f,d,b,c},{e,f,d,c,a},{e,f,d,c,b},
                {f,a,b,c,d},{f,a,b,c,e},{f,a,b,d,c},{f,a,b,d,e},{f,a,b,e,c},{f,a,b,e,d},{f,a,c,b,d},{f,a,c,b,e},{f,a,c,d,b},{f,a,c,d,e},{f,a,c,e,b},{f,a,c,e,d},
                {f,a,d,b,c},{f,a,d,b,e},{f,a,d,c,b},{f,a,d,c,e},{f,a,d,e,b},{f,a,d,e,c},{f,a,e,b,c},{f,a,e,b,d},{f,a,e,c,b},{f,a,e,c,d},{f,a,e,d,b},{f,a,e,d,c},
                {f,b,a,c,d},{f,b,a,c,e},{f,b,a,d,c},{f,b,a,d,e},{f,b,a,e,c},{f,b,a,e,d},{f,b,c,a,d},{f,b,c,a,e},{f,b,c,d,a},{f,b,c,d,e},{f,b,c,e,a},{f,b,c,e,d},
                {f,b,d,a,c},{f,b,d,a,e},{f,b,d,c,a},{f,b,d,c,e},{f,b,d,e,a},{f,b,d,e,c},{f,b,e,a,c},{f,b,e,a,d},{f,b,e,c,a},{f,b,e,c,d},{f,b,e,d,a},{f,b,e,d,c},
                {f,c,a,b,d},{f,c,a,b,e},{f,c,a,d,b},{f,c,a,d,e},{f,c,a,e,b},{f,c,a,e,d},{f,c,b,a,d},{f,c,b,a,e},{f,c,b,d,a},{f,c,b,d,e},{f,c,b,e,a},{f,c,b,e,d},
                {f,c,d,a,b},{f,c,d,a,e},{f,c,d,b,a},{f,c,d,b,e},{f,c,d,e,a},{f,c,d,e,b},{f,c,e,a,b},{f,c,e,a,d},{f,c,e,b,a},{f,c,e,b,d},{f,c,e,d,a},{f,c,e,d,b},
                {f,d,a,b,c},{f,d,a,b,e},{f,d,a,c,b},{f,d,a,c,e},{f,d,a,e,b},{f,d,a,e,c},{f,d,b,a,c},{f,d,b,a,e},{f,d,b,c,a},{f,d,b,c,e},{f,d,b,e,a},{f,d,b,e,c},
                {f,d,c,a,b},{f,d,c,a,e},{f,d,c,b,a},{f,d,c,b,e},{f,d,c,e,a},{f,d,c,e,b},{f,d,e,a,b},{f,d,e,a,c},{f,d,e,b,a},{f,d,e,b,c},{f,d,e,c,a},{f,d,e,c,b},
                {f,e,a,b,c},{f,e,a,b,d},{f,e,a,c,b},{f,e,a,c,d},{f,e,a,d,b},{f,e,a,d,c},{f,e,b,a,c},{f,e,b,a,d},{f,e,b,c,a},{f,e,b,c,d},{f,e,b,d,a},{f,e,b,d,c},
                {f,e,c,a,b},{f,e,c,a,d},{f,e,c,b,a},{f,e,c,b,d},{f,e,c,d,a},{f,e,c,d,b},{f,e,d,a,b},{f,e,d,a,c},{f,e,d,b,a},{f,e,d,b,c},{f,e,d,c,a},{f,e,d,c,b},
                {a,b,c,d,e,f},{a,b,c,d,f,e},{a,b,c,e,d,f},{a,b,c,e,f,d},{a,b,c,f,d,e},{a,b,c,f,e,d},{a,b,d,c,e,f},{a,b,d,c,f,e},{a,b,d,e,c,f},{a,b,d,e,f,c},{a,b,d,f,c,e},{a,b,d,f,e,c},
                {a,b,e,c,d,f},{a,b,e,c,f,d},{a,b,e,d,c,f},{a,b,e,d,f,c},{a,b,e,f,c,d},{a,b,e,f,d,c},{a,b,f,c,d,e},{a,b,f,c,e,d},{a,b,f,d,c,e},{a,b,f,d,e,c},{a,b,f,e,c,d},{a,b,f,e,d,c},
                {a,c,b,d,e,f},{a,c,b,d,f,e},{a,c,b,e,d,f},{a,c,b,e,f,d},{a,c,b,f,d,e},{a,c,b,f,e,d},{a,c,d,b,e,f},{a,c,d,b,f,e},{a,c,d,e,b,f},{a,c,d,e,f,b},{a,c,d,f,b,e},{a,c,d,f,e,b},
                {a,c,e,b,d,f},{a,c,e,b,f,d},{a,c,e,d,b,f},{a,c,e,d,f,b},{a,c,e,f,b,d},{a,c,e,f,d,b},{a,c,f,b,d,e},{a,c,f,b,e,d},{a,c,f,d,b,e},{a,c,f,d,e,b},{a,c,f,e,b,d},{a,c,f,e,d,b},
                {a,d,b,c,e,f},{a,d,b,c,f,e},{a,d,b,e,c,f},{a,d,b,e,f,c},{a,d,b,f,c,e},{a,d,b,f,e,c},{a,d,c,b,e,f},{a,d,c,b,f,e},{a,d,c,e,b,f},{a,d,c,e,f,b},{a,d,c,f,b,e},{a,d,c,f,e,b},
                {a,d,e,b,c,f},{a,d,e,b,f,c},{a,d,e,c,b,f},{a,d,e,c,f,b},{a,d,e,f,b,c},{a,d,e,f,c,b},{a,d,f,b,c,e},{a,d,f,b,e,c},{a,d,f,c,b,e},{a,d,f,c,e,b},{a,d,f,e,b,c},{a,d,f,e,c,b},
                {a,e,b,c,d,f},{a,e,b,c,f,d},{a,e,b,d,c,f},{a,e,b,d,f,c},{a,e,b,f,c,d},{a,e,b,f,d,c},{a,e,c,b,d,f},{a,e,c,b,f,d},{a,e,c,d,b,f},{a,e,c,d,f,b},{a,e,c,f,b,d},{a,e,c,f,d,b},
                {a,e,d,b,c,f},{a,e,d,b,f,c},{a,e,d,c,b,f},{a,e,d,c,f,b},{a,e,d,f,b,c},{a,e,d,f,c,b},{a,e,f,b,c,d},{a,e,f,b,d,c},{a,e,f,c,b,d},{a,e,f,c,d,b},{a,e,f,d,b,c},{a,e,f,d,c,b},
                {a,f,b,c,d,e},{a,f,b,c,e,d},{a,f,b,d,c,e},{a,f,b,d,e,c},{a,f,b,e,c,d},{a,f,b,e,d,c},{a,f,c,b,d,e},{a,f,c,b,e,d},{a,f,c,d,b,e},{a,f,c,d,e,b},{a,f,c,e,b,d},{a,f,c,e,d,b},
                {a,f,d,b,c,e},{a,f,d,b,e,c},{a,f,d,c,b,e},{a,f,d,c,e,b},{a,f,d,e,b,c},{a,f,d,e,c,b},{a,f,e,b,c,d},{a,f,e,b,d,c},{a,f,e,c,b,d},{a,f,e,c,d,b},{a,f,e,d,b,c},{a,f,e,d,c,b},
                {b,a,c,d,e,f},{b,a,c,d,f,e},{b,a,c,e,d,f},{b,a,c,e,f,d},{b,a,c,f,d,e},{b,a,c,f,e,d},{b,a,d,c,e,f},{b,a,d,c,f,e},{b,a,d,e,c,f},{b,a,d,e,f,c},{b,a,d,f,c,e},{b,a,d,f,e,c},
                {b,a,e,c,d,f},{b,a,e,c,f,d},{b,a,e,d,c,f},{b,a,e,d,f,c},{b,a,e,f,c,d},{b,a,e,f,d,c},{b,a,f,c,d,e},{b,a,f,c,e,d},{b,a,f,d,c,e},{b,a,f,d,e,c},{b,a,f,e,c,d},{b,a,f,e,d,c},
                {b,c,a,d,e,f},{b,c,a,d,f,e},{b,c,a,e,d,f},{b,c,a,e,f,d},{b,c,a,f,d,e},{b,c,a,f,e,d},{b,c,d,a,e,f},{b,c,d,a,f,e},{b,c,d,e,a,f},{b,c,d,e,f,a},{b,c,d,f,a,e},{b,c,d,f,e,a},
                {b,c,e,a,d,f},{b,c,e,a,f,d},{b,c,e,d,a,f},{b,c,e,d,f,a},{b,c,e,f,a,d},{b,c,e,f,d,a},{b,c,f,a,d,e},{b,c,f,a,e,d},{b,c,f,d,a,e},{b,c,f,d,e,a},{b,c,f,e,a,d},{b,c,f,e,d,a},
                {b,d,a,c,e,f},{b,d,a,c,f,e},{b,d,a,e,c,f},{b,d,a,e,f,c},{b,d,a,f,c,e},{b,d,a,f,e,c},{b,d,c,a,e,f},{b,d,c,a,f,e},{b,d,c,e,a,f},{b,d,c,e,f,a},{b,d,c,f,a,e},{b,d,c,f,e,a},
                {b,d,e,a,c,f},{b,d,e,a,f,c},{b,d,e,c,a,f},{b,d,e,c,f,a},{b,d,e,f,a,c},{b,d,e,f,c,a},{b,d,f,a,c,e},{b,d,f,a,e,c},{b,d,f,c,a,e},{b,d,f,c,e,a},{b,d,f,e,a,c},{b,d,f,e,c,a},
                {b,e,a,c,d,f},{b,e,a,c,f,d},{b,e,a,d,c,f},{b,e,a,d,f,c},{b,e,a,f,c,d},{b,e,a,f,d,c},{b,e,c,a,d,f},{b,e,c,a,f,d},{b,e,c,d,a,f},{b,e,c,d,f,a},{b,e,c,f,a,d},{b,e,c,f,d,a},
                {b,e,d,a,c,f},{b,e,d,a,f,c},{b,e,d,c,a,f},{b,e,d,c,f,a},{b,e,d,f,a,c},{b,e,d,f,c,a},{b,e,f,a,c,d},{b,e,f,a,d,c},{b,e,f,c,a,d},{b,e,f,c,d,a},{b,e,f,d,a,c},{b,e,f,d,c,a},
                {b,f,a,c,d,e},{b,f,a,c,e,d},{b,f,a,d,c,e},{b,f,a,d,e,c},{b,f,a,e,c,d},{b,f,a,e,d,c},{b,f,c,a,d,e},{b,f,c,a,e,d},{b,f,c,d,a,e},{b,f,c,d,e,a},{b,f,c,e,a,d},{b,f,c,e,d,a},
                {b,f,d,a,c,e},{b,f,d,a,e,c},{b,f,d,c,a,e},{b,f,d,c,e,a},{b,f,d,e,a,c},{b,f,d,e,c,a},{b,f,e,a,c,d},{b,f,e,a,d,c},{b,f,e,c,a,d},{b,f,e,c,d,a},{b,f,e,d,a,c},{b,f,e,d,c,a},
                {c,a,b,d,e,f},{c,a,b,d,f,e},{c,a,b,e,d,f},{c,a,b,e,f,d},{c,a,b,f,d,e},{c,a,b,f,e,d},{c,a,d,b,e,f},{c,a,d,b,f,e},{c,a,d,e,b,f},{c,a,d,e,f,b},{c,a,d,f,b,e},{c,a,d,f,e,b},
                {c,a,e,b,d,f},{c,a,e,b,f,d},{c,a,e,d,b,f},{c,a,e,d,f,b},{c,a,e,f,b,d},{c,a,e,f,d,b},{c,a,f,b,d,e},{c,a,f,b,e,d},{c,a,f,d,b,e},{c,a,f,d,e,b},{c,a,f,e,b,d},{c,a,f,e,d,b},
                {c,b,a,d,e,f},{c,b,a,d,f,e},{c,b,a,e,d,f},{c,b,a,e,f,d},{c,b,a,f,d,e},{c,b,a,f,e,d},{c,b,d,a,e,f},{c,b,d,a,f,e},{c,b,d,e,a,f},{c,b,d,e,f,a},{c,b,d,f,a,e},{c,b,d,f,e,a},
                {c,b,e,a,d,f},{c,b,e,a,f,d},{c,b,e,d,a,f},{c,b,e,d,f,a},{c,b,e,f,a,d},{c,b,e,f,d,a},{c,b,f,a,d,e},{c,b,f,a,e,d},{c,b,f,d,a,e},{c,b,f,d,e,a},{c,b,f,e,a,d},{c,b,f,e,d,a},
                {c,d,a,b,e,f},{c,d,a,b,f,e},{c,d,a,e,b,f},{c,d,a,e,f,b},{c,d,a,f,b,e},{c,d,a,f,e,b},{c,d,b,a,e,f},{c,d,b,a,f,e},{c,d,b,e,a,f},{c,d,b,e,f,a},{c,d,b,f,a,e},{c,d,b,f,e,a},
                {c,d,e,a,b,f},{c,d,e,a,f,b},{c,d,e,b,a,f},{c,d,e,b,f,a},{c,d,e,f,a,b},{c,d,e,f,b,a},{c,d,f,a,b,e},{c,d,f,a,e,b},{c,d,f,b,a,e},{c,d,f,b,e,a},{c,d,f,e,a,b},{c,d,f,e,b,a},
                {c,e,a,b,d,f},{c,e,a,b,f,d},{c,e,a,d,b,f},{c,e,a,d,f,b},{c,e,a,f,b,d},{c,e,a,f,d,b},{c,e,b,a,d,f},{c,e,b,a,f,d},{c,e,b,d,a,f},{c,e,b,d,f,a},{c,e,b,f,a,d},{c,e,b,f,d,a},
                {c,e,d,a,b,f},{c,e,d,a,f,b},{c,e,d,b,a,f},{c,e,d,b,f,a},{c,e,d,f,a,b},{c,e,d,f,b,a},{c,e,f,a,b,d},{c,e,f,a,d,b},{c,e,f,b,a,d},{c,e,f,b,d,a},{c,e,f,d,a,b},{c,e,f,d,b,a},
                {c,f,a,b,d,e},{c,f,a,b,e,d},{c,f,a,d,b,e},{c,f,a,d,e,b},{c,f,a,e,b,d},{c,f,a,e,d,b},{c,f,b,a,d,e},{c,f,b,a,e,d},{c,f,b,d,a,e},{c,f,b,d,e,a},{c,f,b,e,a,d},{c,f,b,e,d,a},
                {c,f,d,a,b,e},{c,f,d,a,e,b},{c,f,d,b,a,e},{c,f,d,b,e,a},{c,f,d,e,a,b},{c,f,d,e,b,a},{c,f,e,a,b,d},{c,f,e,a,d,b},{c,f,e,b,a,d},{c,f,e,b,d,a},{c,f,e,d,a,b},{c,f,e,d,b,a},
                {d,a,b,c,e,f},{d,a,b,c,f,e},{d,a,b,e,c,f},{d,a,b,e,f,c},{d,a,b,f,c,e},{d,a,b,f,e,c},{d,a,c,b,e,f},{d,a,c,b,f,e},{d,a,c,e,b,f},{d,a,c,e,f,b},{d,a,c,f,b,e},{d,a,c,f,e,b},
                {d,a,e,b,c,f},{d,a,e,b,f,c},{d,a,e,c,b,f},{d,a,e,c,f,b},{d,a,e,f,b,c},{d,a,e,f,c,b},{d,a,f,b,c,e},{d,a,f,b,e,c},{d,a,f,c,b,e},{d,a,f,c,e,b},{d,a,f,e,b,c},{d,a,f,e,c,b},
                {d,b,a,c,e,f},{d,b,a,c,f,e},{d,b,a,e,c,f},{d,b,a,e,f,c},{d,b,a,f,c,e},{d,b,a,f,e,c},{d,b,c,a,e,f},{d,b,c,a,f,e},{d,b,c,e,a,f},{d,b,c,e,f,a},{d,b,c,f,a,e},{d,b,c,f,e,a},
                {d,b,e,a,c,f},{d,b,e,a,f,c},{d,b,e,c,a,f},{d,b,e,c,f,a},{d,b,e,f,a,c},{d,b,e,f,c,a},{d,b,f,a,c,e},{d,b,f,a,e,c},{d,b,f,c,a,e},{d,b,f,c,e,a},{d,b,f,e,a,c},{d,b,f,e,c,a},
                {d,c,a,b,e,f},{d,c,a,b,f,e},{d,c,a,e,b,f},{d,c,a,e,f,b},{d,c,a,f,b,e},{d,c,a,f,e,b},{d,c,b,a,e,f},{d,c,b,a,f,e},{d,c,b,e,a,f},{d,c,b,e,f,a},{d,c,b,f,a,e},{d,c,b,f,e,a},
                {d,c,e,a,b,f},{d,c,e,a,f,b},{d,c,e,b,a,f},{d,c,e,b,f,a},{d,c,e,f,a,b},{d,c,e,f,b,a},{d,c,f,a,b,e},{d,c,f,a,e,b},{d,c,f,b,a,e},{d,c,f,b,e,a},{d,c,f,e,a,b},{d,c,f,e,b,a},
                {d,e,a,b,c,f},{d,e,a,b,f,c},{d,e,a,c,b,f},{d,e,a,c,f,b},{d,e,a,f,b,c},{d,e,a,f,c,b},{d,e,b,a,c,f},{d,e,b,a,f,c},{d,e,b,c,a,f},{d,e,b,c,f,a},{d,e,b,f,a,c},{d,e,b,f,c,a},
                {d,e,c,a,b,f},{d,e,c,a,f,b},{d,e,c,b,a,f},{d,e,c,b,f,a},{d,e,c,f,a,b},{d,e,c,f,b,a},{d,e,f,a,b,c},{d,e,f,a,c,b},{d,e,f,b,a,c},{d,e,f,b,c,a},{d,e,f,c,a,b},{d,e,f,c,b,a},
                {d,f,a,b,c,e},{d,f,a,b,e,c},{d,f,a,c,b,e},{d,f,a,c,e,b},{d,f,a,e,b,c},{d,f,a,e,c,b},{d,f,b,a,c,e},{d,f,b,a,e,c},{d,f,b,c,a,e},{d,f,b,c,e,a},{d,f,b,e,a,c},{d,f,b,e,c,a},
                {d,f,c,a,b,e},{d,f,c,a,e,b},{d,f,c,b,a,e},{d,f,c,b,e,a},{d,f,c,e,a,b},{d,f,c,e,b,a},{d,f,e,a,b,c},{d,f,e,a,c,b},{d,f,e,b,a,c},{d,f,e,b,c,a},{d,f,e,c,a,b},{d,f,e,c,b,a},
                {e,a,b,c,d,f},{e,a,b,c,f,d},{e,a,b,d,c,f},{e,a,b,d,f,c},{e,a,b,f,c,d},{e,a,b,f,d,c},{e,a,c,b,d,f},{e,a,c,b,f,d},{e,a,c,d,b,f},{e,a,c,d,f,b},{e,a,c,f,b,d},{e,a,c,f,d,b},
                {e,a,d,b,c,f},{e,a,d,b,f,c},{e,a,d,c,b,f},{e,a,d,c,f,b},{e,a,d,f,b,c},{e,a,d,f,c,b},{e,a,f,b,c,d},{e,a,f,b,d,c},{e,a,f,c,b,d},{e,a,f,c,d,b},{e,a,f,d,b,c},{e,a,f,d,c,b},
                {e,b,a,c,d,f},{e,b,a,c,f,d},{e,b,a,d,c,f},{e,b,a,d,f,c},{e,b,a,f,c,d},{e,b,a,f,d,c},{e,b,c,a,d,f},{e,b,c,a,f,d},{e,b,c,d,a,f},{e,b,c,d,f,a},{e,b,c,f,a,d},{e,b,c,f,d,a},
                {e,b,d,a,c,f},{e,b,d,a,f,c},{e,b,d,c,a,f},{e,b,d,c,f,a},{e,b,d,f,a,c},{e,b,d,f,c,a},{e,b,f,a,c,d},{e,b,f,a,d,c},{e,b,f,c,a,d},{e,b,f,c,d,a},{e,b,f,d,a,c},{e,b,f,d,c,a},
                {e,c,a,b,d,f},{e,c,a,b,f,d},{e,c,a,d,b,f},{e,c,a,d,f,b},{e,c,a,f,b,d},{e,c,a,f,d,b},{e,c,b,a,d,f},{e,c,b,a,f,d},{e,c,b,d,a,f},{e,c,b,d,f,a},{e,c,b,f,a,d},{e,c,b,f,d,a},
                {e,c,d,a,b,f},{e,c,d,a,f,b},{e,c,d,b,a,f},{e,c,d,b,f,a},{e,c,d,f,a,b},{e,c,d,f,b,a},{e,c,f,a,b,d},{e,c,f,a,d,b},{e,c,f,b,a,d},{e,c,f,b,d,a},{e,c,f,d,a,b},{e,c,f,d,b,a},
                {e,d,a,b,c,f},{e,d,a,b,f,c},{e,d,a,c,b,f},{e,d,a,c,f,b},{e,d,a,f,b,c},{e,d,a,f,c,b},{e,d,b,a,c,f},{e,d,b,a,f,c},{e,d,b,c,a,f},{e,d,b,c,f,a},{e,d,b,f,a,c},{e,d,b,f,c,a},
                {e,d,c,a,b,f},{e,d,c,a,f,b},{e,d,c,b,a,f},{e,d,c,b,f,a},{e,d,c,f,a,b},{e,d,c,f,b,a},{e,d,f,a,b,c},{e,d,f,a,c,b},{e,d,f,b,a,c},{e,d,f,b,c,a},{e,d,f,c,a,b},{e,d,f,c,b,a},
                {e,f,a,b,c,d},{e,f,a,b,d,c},{e,f,a,c,b,d},{e,f,a,c,d,b},{e,f,a,d,b,c},{e,f,a,d,c,b},{e,f,b,a,c,d},{e,f,b,a,d,c},{e,f,b,c,a,d},{e,f,b,c,d,a},{e,f,b,d,a,c},{e,f,b,d,c,a},
                {e,f,c,a,b,d},{e,f,c,a,d,b},{e,f,c,b,a,d},{e,f,c,b,d,a},{e,f,c,d,a,b},{e,f,c,d,b,a},{e,f,d,a,b,c},{e,f,d,a,c,b},{e,f,d,b,a,c},{e,f,d,b,c,a},{e,f,d,c,a,b},{e,f,d,c,b,a},
                {f,a,b,c,d,e},{f,a,b,c,e,d},{f,a,b,d,c,e},{f,a,b,d,e,c},{f,a,b,e,c,d},{f,a,b,e,d,c},{f,a,c,b,d,e},{f,a,c,b,e,d},{f,a,c,d,b,e},{f,a,c,d,e,b},{f,a,c,e,b,d},{f,a,c,e,d,b},
                {f,a,d,b,c,e},{f,a,d,b,e,c},{f,a,d,c,b,e},{f,a,d,c,e,b},{f,a,d,e,b,c},{f,a,d,e,c,b},{f,a,e,b,c,d},{f,a,e,b,d,c},{f,a,e,c,b,d},{f,a,e,c,d,b},{f,a,e,d,b,c},{f,a,e,d,c,b},
                {f,b,a,c,d,e},{f,b,a,c,e,d},{f,b,a,d,c,e},{f,b,a,d,e,c},{f,b,a,e,c,d},{f,b,a,e,d,c},{f,b,c,a,d,e},{f,b,c,a,e,d},{f,b,c,d,a,e},{f,b,c,d,e,a},{f,b,c,e,a,d},{f,b,c,e,d,a},
                {f,b,d,a,c,e},{f,b,d,a,e,c},{f,b,d,c,a,e},{f,b,d,c,e,a},{f,b,d,e,a,c},{f,b,d,e,c,a},{f,b,e,a,c,d},{f,b,e,a,d,c},{f,b,e,c,a,d},{f,b,e,c,d,a},{f,b,e,d,a,c},{f,b,e,d,c,a},
                {f,c,a,b,d,e},{f,c,a,b,e,d},{f,c,a,d,b,e},{f,c,a,d,e,b},{f,c,a,e,b,d},{f,c,a,e,d,b},{f,c,b,a,d,e},{f,c,b,a,e,d},{f,c,b,d,a,e},{f,c,b,d,e,a},{f,c,b,e,a,d},{f,c,b,e,d,a},
                {f,c,d,a,b,e},{f,c,d,a,e,b},{f,c,d,b,a,e},{f,c,d,b,e,a},{f,c,d,e,a,b},{f,c,d,e,b,a},{f,c,e,a,b,d},{f,c,e,a,d,b},{f,c,e,b,a,d},{f,c,e,b,d,a},{f,c,e,d,a,b},{f,c,e,d,b,a},
                {f,d,a,b,c,e},{f,d,a,b,e,c},{f,d,a,c,b,e},{f,d,a,c,e,b},{f,d,a,e,b,c},{f,d,a,e,c,b},{f,d,b,a,c,e},{f,d,b,a,e,c},{f,d,b,c,a,e},{f,d,b,c,e,a},{f,d,b,e,a,c},{f,d,b,e,c,a},
                {f,d,c,a,b,e},{f,d,c,a,e,b},{f,d,c,b,a,e},{f,d,c,b,e,a},{f,d,c,e,a,b},{f,d,c,e,b,a},{f,d,e,a,b,c},{f,d,e,a,c,b},{f,d,e,b,a,c},{f,d,e,b,c,a},{f,d,e,c,a,b},{f,d,e,c,b,a},
                {f,e,a,b,c,d},{f,e,a,b,d,c},{f,e,a,c,b,d},{f,e,a,c,d,b},{f,e,a,d,b,c},{f,e,a,d,c,b},{f,e,b,a,c,d},{f,e,b,a,d,c},{f,e,b,c,a,d},{f,e,b,c,d,a},{f,e,b,d,a,c},{f,e,b,d,c,a},
                {f,e,c,a,b,d},{f,e,c,a,d,b},{f,e,c,b,a,d},{f,e,c,b,d,a},{f,e,c,d,a,b},{f,e,c,d,b,a},{f,e,d,a,b,c},{f,e,d,a,c,b},{f,e,d,b,a,c},{f,e,d,b,c,a},{f,e,d,c,a,b},{f,e,d,c,b,a}
        };
        return combination;
    }

    public static String url(String root, String join) { return root.replace(" ", "%20") + join(join).replace("?&", "?"); }
    
	public static String[] url(String root, String[][] join) {
		String[] url = new String[join.length];
		for (int i = 0; i < join.length; i++) {
			if ( !root.contains("?") ) { root = root + "?";}
			url[i] = (root.replace(" ", "%20") + join(join[i])).replace("?&", "?"); }
		return url;
	};	
	
	public static String join(String combination) { return "&" + combination; }
	
	public static String join(String[] combination) {
		String result = "";
		for (int i = 0; i < combination.length; i++) { result = result + "&" + combination[i]; }
		return result;
	}
	
}
