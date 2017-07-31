
public class StringCTC {

	/*1.1 Implement an algorithm to determine if a string has all unique characters*/
	public boolean isUniqueCharacters (String s) {
		if (s.length() > 26) return false; //Assuming for lowercase alphabets
		int checker = 0;
		for (int i = 0; i < s.length(); i++) {
			int value = s.charAt(i) - 'a';
			if ((checker & (1 << value)) > 0) {
				return false;
			}
			checker |= (1 << value);
		}
		return true;
	}
	
	/*1.2 Given two strings, write a method to decide if one is a permutation of other.*/
	public boolean isPermutation (String s, String t) {
		if (s.length() != t.length()) return false;
		
		int letters[] = new int[128]; //Assuming for ASCII characters
		
		for (int i = 0; i < s.length(); i++) {
			letters[s.charAt(i)]++;
		}
		
		for (int i = 0; i< t.length(); i++) {
			int ch = t.charAt(i);
			letters[ch]--;
			if (letters[ch] < 0) return false;
		}
		
		return true;
	}
	
	/*1.3 Write an algorithm to replace space with '%20'*/
	public void URLify (char[] s, int length) {
		int space = 0, fullLength;
		for(int i = 0; i < length; i++) {
			if (s[i] == ' ') space++;
		}
		fullLength = length + space * 2;
		s[fullLength - 1] = '\0';
		for (int i = length - 1; i >= 0; i--) {
			if (s[i] == ' ') {
				s[fullLength - 1] = '0';
				s[fullLength - 2] = '2';
				s[fullLength - 3] = '%';
				fullLength -=3;
			} else {
				s[fullLength - 1] = s[i];
				fullLength -= 1;
			}
		}
	}
	
	/*1.4 Palindrome Permutation : Given a string, write a function to check if it is a permutation of a palindrome.*/
	
	public boolean palindromePermutation (String s) {
		int table[] = buildFrequencyTable(s);
		boolean foundOdd = false;
		for (int i : table) {
			if (i%2 == 1) {		//checks that no more than one character has an odd count.
				if (foundOdd) return false;
				foundOdd = true;
			}
		}
		return true;
	}
	
	/*1.5 One Away : Given two strings, write a function to check if they are one edit away.*/
	
	public boolean oneEditAway (String s, String t) {
		if (s.length() == t.length()) return oneEditReplace(s, t);
		else if ((s.length() - t.length() == 1) || (t.length() - s.length() == 1)) return oneEditInsertDelete(s,t);
		return false;
	}
	
	/*1.6 String Compression : Write an algorithm to compress the string using the counts of the repeated characters.
	 Return original string, if length of compress string is larger.*/
	
	public String compressString (String s) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
			count++;
			if ((i+1 >= s.length()) || (s.charAt(i) != s.charAt(i+1))) {
				sb.append(s.charAt(i));
				sb.append(count);
				count = 0;
			}
		}
		return sb.length() < s.length() ? sb.toString() : s;
	}
	
	/*1.8 Zero Matrix : write a function such that if an  element in M*N matrix is 0, its row and column should be zero. */
	
	public void ZeroMatrix(int[][] matrix) {
		boolean rowHasZero = false;
        boolean columnHasZero = false;
        
        //Check if first row has zero
        for (int i=0; i<matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowHasZero = true;
                break;
            }
        }
        
        //Check if first column has zero
        for (int i=0; i<matrix.length; i++) {
            if (matrix[i][0] == 0) {
                columnHasZero = true;
                break;
            }
        }
        
        //Check for zeroes in rest of the array
        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        //Nullify rows based on first column
        for (int i=1; i<matrix.length; i++) {
            if (matrix[i][0] == 0) nullifyRow(matrix, i);
        }
        
        //Nullify columns based on first row
        for (int i=1; i<matrix[0].length; i++) {
            if (matrix[0][i] == 0) nullifyColumn(matrix, i);
        }
        
        if (rowHasZero) nullifyRow(matrix, 0);
        if (columnHasZero) nullifyColumn(matrix, 0);
	}
	
	/*1.9 String Rotation : Given two strings, s and t check if t is rotation of s.*/
	
	public boolean stringRotation (String s, String t) {
		if (s.length() != t.length()) return false;
		String ss = s + s;
		return isSubstring(ss,t);
	}
	
	/* ****Helper function required for performing string operation - START*** */ 
	
	//Finds if string t is substring of string s. 
	public boolean isSubstring(String s, String t) {
		if (s.indexOf(t) >= 0) return true;
		else return false;
	}
	
	//Maps each character to a number. a -> 0, b -> 1, etc. This is case sensitive. Non-letter characters map to -1.
	public int getCharNumber (Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		
		int value = Character.getNumericValue(c);
		if (a <= value && value <= z) return value - a;
		else return -1;
	}
	
	//Build frequency table - count how many times each character appears.
	public int[] buildFrequencyTable (String s) {
		int table[] = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		
		for (char c : s.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) table[x]++;
		}
		return table;
	}
	
	public boolean oneEditReplace (String s, String t) {
		boolean foundDifference = false;
		for (int i = 0; i<s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				if(foundDifference) return false;
				foundDifference = true;
			}
		}
		return true;
	}
	
	public boolean oneEditInsertDelete (String s, String t) {
		int index1 = 0;
		int index2 = 0;
		//int length = s.length() > t.length() ? s.length() : t.length();
		while (index2 < t.length() && index1 < s.length()) {
			if (s.charAt(index1) != t.charAt(index2)) {
				if (index1 != index2) return false;
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}
	
	public void nullifyRow(int [][]matrix, int row) {
		for (int i=0; i<matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
	}
	
	public void nullifyColumn(int [][]matrix, int column) {
		for (int i=0; i<matrix.length; i++) {
			matrix[i][column] = 0;
		}
	}
	
	/*Helper function required for performing string operation - END*/
	
	public static void main(String[] args) {
		
		StringCTC sCTC = new StringCTC();
		System.out.println(sCTC.isUniqueCharacters("aaa"));
		System.out.println(sCTC.isPermutation("papre", "repap"));
		System.out.println(sCTC.compressString("aaaabbc"));
		String s = "Mr John Smith    ";
		char[] sArray = s.toCharArray();
		sCTC.URLify(sArray, 13);
		for (char c : sArray) System.out.print(c);
		System.out.println();
		System.out.println(sCTC.palindromePermutation("taco occat"));
		System.out.println(sCTC.oneEditAway("swap", "swand"));
		System.out.println(sCTC.stringRotation("waterbottle", "erbottlewat"));
	}

}
