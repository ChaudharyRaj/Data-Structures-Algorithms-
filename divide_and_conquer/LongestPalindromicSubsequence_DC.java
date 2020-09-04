package divide_and_conquer;

public class LongestPalindromicSubsequence_DC {
	public static int findLPS(String s) {
		return findLPSAux(s,0,s.length() -1);
	}

	private static int findLPSAux(String s, int startIndex , int endIndex) {
		
		if(startIndex > endIndex)
			return 0;
		if(startIndex == endIndex)
			return 1;
		
		int count1 = 0;
		if(s.charAt(startIndex) == s.charAt(endIndex)){
			count1 = 2+findLPSAux(s, startIndex+1, endIndex-1);
		}
		int count2 = findLPSAux(s, startIndex+1, endIndex);
		int count3 =  findLPSAux(s, startIndex, endIndex-1);
		return Math.max(count1, Math.max(count2, count3));
	}
	
	public static void main(String[] args) {
		 LongestPalindromicSubsequence_DC lps =  new LongestPalindromicSubsequence_DC();
		 System.out.println("Longest Palindromic Sequence: " + LongestPalindromicSubsequence_DC.findLPS("elrmenmet"));
	}
}
