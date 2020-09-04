package divide_and_conquer;

public class LongestPalindromicSubstring_DC{
	
	public static int findLPSLength(String s) {
		return findLPsLenghtAux(s,0,s.length()-1);
	}
	
	private static int findLPsLenghtAux(String s, int startEndex, int endIndex) {
		
		if(startEndex > endIndex)
			return 0;
		if(startEndex == endIndex)
			return 1;
		int count1 = 0;
		if(s.charAt(startEndex) == s.charAt(endIndex)) {
			int remaningLength = endIndex - startEndex-1;
			if(remaningLength ==  findLPsLenghtAux(s, startEndex+1, endIndex-1)) {
				count1 = remaningLength+2;
			}
		}
		int count2 = findLPsLenghtAux(s, startEndex+1, endIndex);
		int count3 = findLPsLenghtAux(s, startEndex, endIndex-1);
		return Math.max(count1, Math.max(count2, count3));
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring_DC lps =  new LongestPalindromicSubstring_DC();
		System.out.println("Longest Palindromic Substring: " + lps.findLPSLength("ABCCBUA"));
	}
}
