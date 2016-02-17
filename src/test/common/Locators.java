package test.common;

import java.io.File;

public class Locators {
	
	public static String outputFileDir     = System.getProperty("user.dir") + File.separator + "output" + File.separator;
	public static String testOutputFileDir = System.getProperty("user.dir") + File.separator + "test-output" + File.separator;
	public static String driverFileDir     = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"                                                 
                                           + File.separator + "resources" + File.separator + "drivers" + File.separator;

	/************************URL's**************************/
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

	public static String[] url(String root, String[][] join) {
		String[] url = new String[join.length];
		for (int i = 0; i < join.length; i++) { url[i] = root.replace(" ", "%20") + join(join[i]); }
		return url;
	};	
	
	public static String join(String[] combination) {
		String result = "";
		for (int i = 0; i < combination.length; i++) { result = result + "&" + combination[i]; }
		return result;
	}
	
}
