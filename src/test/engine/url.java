package test.engine;

import test.helper.Data;

public class url {
	
//	public static String root = "http://tomcat-dev:8080/CPAD/videos/?sort_by=created_on&sort_order=desc&";
//	public static String a = "program_asset_id=2790";
//	public static String b = "group=Adult";
//	public static String c = "size=80";
	
	public static String root = "http://desc&";
	public static String a = "A";
	public static String b = "B";
	public static String c = "C";

	public static void main(String[] args) {

		
	 // public String[][] d = combination(a, b, c);
		String[]   url = Data.url(root, Data.combination(a, b, c));
		for (int i = 0; i < url.length; i++) {
        System.out.println(url[i]);
		}

	}

}
