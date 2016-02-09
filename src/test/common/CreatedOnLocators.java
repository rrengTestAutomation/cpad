package test.common;

public class CreatedOnLocators {

	/************************URL's**************************/
//	public static String root = "http://[&]";
//	public static String a = "A";
//	public static String b = "B";
//	public static String c = "C";
	
	public static String root = "http://tomcat-dev:8080/CPAD/videos/?sort_by=created_on&sort_order=desc&";
	public static String a = "program_asset_id=2790";
	public static String b = "group=Adult";
	public static String c = "size=80";	
	public static String[] URL = Locators.url(root, Locators.combination(a, b, c));
	

	
}
