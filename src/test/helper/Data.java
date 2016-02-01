package test.helper;

public class Data {

//	public String root = "http://tomcat-dev:8080/CPAD/videos/?sort_by=created_on&sort_order=desc&";
//	public String a = "program_asset_id=2790";
//	public String b = "group=Adult";
//	public String c = "size=80";
//	
// // public String[][] d = combination(a, b, c);
//	public String[]   e = url(root, combination(a, b, c));

	public static String[][] combination(String a, String b, String c){
           String[][] combination = {
	                                 {a},
	                                 {b},                 
	                                 {c},                 
	                                 {a,b},                 
	                                 {a,c},                 
	                                 {b,a},                 
	                                 {b,c},                 
	                                 {c,a},                 
	                                 {c,b},                 
	                                 {a,b,c},                 
	                                 {a,c,b},                 
	                                 {b,a,c},                 
	                                 {b,c,a},                 
	                                 {c,a,b},                 
	                                 {c,b,a}
                                    };
return combination;
}

public static String join(String[] combination) {
	String result = "";
	for (int i = 0; i < combination.length; i++) {
	if (i == 0) { result = result + combination[i]; } else { result = result + "&" + combination[i]; }
	}
	return result;
}

public static String[] url(String root, String[][] join) {
	String[] url = new String[join.length];
		for (int i = 0; i < join.length; i++) {
			url[i] = root + join(join[i]);
		}
		return url;
		};

}
