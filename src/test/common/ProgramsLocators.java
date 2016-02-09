package test.common;

public class ProgramsLocators {

	/************************URL's**************************/
//	public static String root = "http://[&]";
//	public static String a = "A";
//	public static String b = "B";
//	public static String c = "C";
//	public static String d = "D";

	public static String root = "http://tomcat-dev:8080/CPAD/programs/?group=Adult";
	public static String a = "single_program=0";
	public static String b = "size=60";
	public static String c = "sort_order=DESC";
	public static String d = "sort_by=CREATED_ON";
	public static String[] URL = Locators.url(root, Locators.combination(a, b, c, d));

}
