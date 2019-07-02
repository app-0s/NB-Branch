import java.util.*;

public class PermutationMethods {
	public static boolean isPerm(String a, String b) {
		// Ensure length of strings are same
		if(a.length() != b.length())
			return false;
		
		a = a.toLowerCase();
		b = b.toLowerCase();
		
		int len = a.length();
		HashMap<Character, Character> hm = new HashMap<Character, Character>();
		
		// Add each char from string a to hashmap
		for(int i = 0; i < len; i++) {
			hm.put(a.charAt(i), a.charAt(i));
		}
		
		for(int j = 0; j < len; j++) {
			if(!hm.containsKey(b.charAt(j)))
				return false;
		}
		
		
		return true;
	}
}
