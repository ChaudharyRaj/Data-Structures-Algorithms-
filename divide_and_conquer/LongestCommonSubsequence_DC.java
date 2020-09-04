package divide_and_conquer;

public class LongestCommonSubsequence_DC {
	public int  findLCS(String s1, String s2) {
		return findLCSAux(s1,s2,0,0);
	}
	
	private int findLCSAux(String s1, String s2, int i1, int i2) {
		
		if(i1 == s1.length() || i2 == s2.length())
			return 0; // Base Case 
		
		int c1 = 0;
		if(s1.charAt(i1) == s2.charAt(i2)){
			c1 = 1 + findLCSAux(s1, s2, i1+1, i2+1); //If current character in both the string matches, then increase the index by 1 in both the strings.
		}
		int c2 = findLCSAux(s1, s2, i1+1, i2);//Increase index of 1st String
		int c3 = findLCSAux(s1, s2, i1, i2+1);//Increase index of 2nd String
		
		return Math.max(c1, Math.max(c2, c3));
	}

	public static void main(String[] args) {
		LongestCommonSubsequence_DC lcs = new  LongestCommonSubsequence_DC();
		System.out.println(lcs.findLCS("houdini", "hdupti"));
	}// end of method
}// end of class