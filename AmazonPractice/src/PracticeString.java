import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class PracticeString {
	
	 public int firstUniqChar(String s) {
		 if (s == null || s.length()<=0) return -1;
	     LinkedHashMap<Character, ArrayList<Integer>> strHM = new LinkedHashMap<Character, ArrayList<Integer>>();	     
	     for (int i = 0; i< s.length(); i++) {
	    	 if (strHM.get(s.charAt(i))==null) {
	    		 ArrayList<Integer> temp = new ArrayList<Integer>();
	    		 strHM.put(s.charAt(i), temp);
	    	 }
	    	 ArrayList<Integer> replace = strHM.get(s.charAt(i));
	    	 replace.add(i);
	    	 strHM.put(s.charAt(i), replace);
	     }
	     for (Map.Entry<Character, ArrayList<Integer>> entry : strHM.entrySet()) {
	    	 if (entry.getValue().size() == 1){
	    		 for (Integer index : entry.getValue())
	    		 return index;
	    	 }
	     }
	     return -1;
	 }
	 
	 public boolean findAnagram (String s, String p) {
		 if (s.length() >= p.length()) {
			 int[] ascii = new int[255];
			 for (int i=0; i<p.length(); i++) {
				 int pInt = (int) p.toLowerCase().charAt(i);
				 ascii[pInt] += 1;
				 int sInt = (int) s.toLowerCase().charAt(i);
				 ascii[sInt] -= 1;
			 }
			 for (int i=0; i<ascii.length; i++) {
				 if (ascii[i]!=0) return false;
			 }
		 }
		 return true;
	 }
	 
	 public String compressedString(String s) {
		 
		 if (s == null || s.length() <=0 ) return null;
		 if (s.length() == 1) return s + 1;
		 StringBuilder compressedString = new StringBuilder();
		 int count = 0;
		 for (int i=0; i<s.length(); i++) {
			 count++;
			 if ( (i+1) >= s.length() || s.charAt(i) != s.charAt(i+1)) {
				 compressedString.append(s.charAt(i));
				 compressedString.append(count);
				 count = 0;
			 }
		 }
		 return compressedString.length() < s.length() ? compressedString.toString() : s;
	 }
	 
	 public boolean isUniqueChars(String s) {
		 if (s == null || s.length() <= 0) return false;
		 int checker = 0;
		 for (int i=0; i<s.length(); i++) {
			 int value = s.charAt(i) - 'a';
			 if ((checker & (1<<value)) > 0) return false;
			 checker |= (1<<value);
		 }
		 return true;
	 }
	 
	 public static void main (String args[]) {
		 PracticeString ps = new PracticeString();
		 String s = "leetcode";
		 System.out.println(ps.isUniqueChars(s));
		 /*System.out.println(ps.firstUniqChar(s));
		 System.out.println(ps.findAnagram("cad", "abc"));
		 String t = ps.compressedString("ab");
		 System.out.println(t);*/
	 }
}
