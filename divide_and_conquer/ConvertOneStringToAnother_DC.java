package divide_and_conquer;

public class ConvertOneStringToAnother_DC {

	public static void main(String[] args) {
		ConvertOneStringToAnother_DC obj = new ConvertOneStringToAnother_DC();
		System.out.println(obj.findMin("table","tcble"));
	}
	public int findMin(String s1, String s2){
		return findMinOperations(s1, s2, 0, 0);
	}
	private static int findMinOperations(String s1, String s2, int i1, int i2) {
		
		if(s1.length() == i1)
			return s2.length() - i2;
		if(s2.length() == i2)
			return s1.length() - i1;
		if(s1.charAt(i1) == s2.charAt(i2))
			return findMinOperations(s1, s2, i1+1, i2+1);
		
		int c1 = 1+ findMinOperations(s1, s2, i1+1,i2);
		int c2 = 1+ findMinOperations(s1, s2, i1, i2+1);
		int c3 = 1+ findMinOperations(s1,s2, i1+1,i2+1);
		return Math.min(c1, Math.min(c2, c3));
	}

}
