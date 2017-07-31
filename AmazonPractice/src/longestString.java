
public class longestString {

	public int longestCommonSubstring (String s, String p) {
		
		int sLength = s.length();
		int pLength = p.length();
		int mat[][] = new int[sLength+1][pLength+1];
		int max = Integer.MIN_VALUE;
		
		for (int i=1; i<=sLength; i++) {
			for (int j=1; j<=pLength; j++) {
				if (s.charAt(i-1) == p.charAt(j-1)){
					mat[i][j] = 1 + mat[i-1][j-1];
					if (mat[i][j] > max) max = mat[i][j];
				}
				else mat[i][j] =0;
			}
		}
		System.out.println(max);
		return max;
	}
	
	public int longestCommonSubsequence (String s, String p) {
		
		int sLength = s.length();
		int pLength = p.length();
		int mat[][] = new int[sLength+1][pLength+1];
		int max = Integer.MIN_VALUE;
		
		for (int i=1; i<=sLength; i++) {
			for (int j=1; j<=pLength; j++) {
				if (s.charAt(i-1) == p.charAt(j-1)) {
					mat[i][j] = mat[i-1][j-1] + 1;
				} else mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
				if (mat[i][j] > max) max = mat[i][j];
			}
		}
		System.out.println(max);
		return max;
	}
	
	public static void main (String args[]) {
		
		longestString ls = new longestString();
		ls.longestCommonSubstring("abcdaf", "zbcdf");
		ls.longestCommonSubsequence("abcdaf", "zbcdf");
	}
}
