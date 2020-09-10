package Queues;
import java.util.*;
public class MainClass {

	static void reversString(String str){
		int len = str.length();
		char[] ch = str.toCharArray();
		Stack<Character> st = new Stack<>();
		
		for(int i =0; i<len; i++){
			st.push(ch[i]);
		}
		for(int i =0; i<len; i++){
			char x = st.pop();
			ch[i] = x;
		}
		str = String.copyValueOf(ch);
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =  new Scanner(System.in);
		int t =  in.nextInt();
		while(t-->0){
			String str = in.next();
			reversString(str);
		}
		
	}

}
