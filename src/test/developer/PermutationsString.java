package test.developer;

import java.io.IOException;
import java.util.ArrayList;

public class PermutationsString {

	public static void main(String[] args) throws IOException {
		System.out.println(permutations("abc"));
	}	
	
	static ArrayList<String> permutations(String s) {
        if (s == null) {
            return null;
        }

        ArrayList<String> resultList = new ArrayList<String>();

        if (s.length() < 2) {
            resultList.add(s);
            return resultList;
        }

        int length = s.length();
        char currentChar;

        for (int i = 0; i < length; i++) {
            currentChar = s.charAt(i);
            String subString = s.substring(0, i) + s.substring(i + 1);
            ArrayList<String> subPermutations = permutations(subString);
            for (String item : subPermutations) {
                resultList.add(currentChar + item);
            }
        }
        
        return resultList;
    } 
	
	
}