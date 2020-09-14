package strings;

public class RepeatedSubstring_Pattern {
	
	public boolean repeatedSubstringPattern(String s) {
        
        int len = s.length();
        
        for(int i = len/2; i >= 1; i--){
            if(len%i == 0){
                int repeat_time = len/i;
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int j=0; j< repeat_time; j++){
                    sb.append(substring);
                }
                if(sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
	public static void main(String[] args) {
		RepeatedSubstring_Pattern rp =  new RepeatedSubstring_Pattern();
		String s = "abab";
		System.out.println(rp.repeatedSubstringPattern(s));

	}

}
