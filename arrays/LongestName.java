package arrays;
import java.util.*;
public class LongestName {
	static String LongesNmae(String[] names){
		if(names.length == 0)
			return null;
		String LongName = "";
		
		for(int i = 0; i <names.length;i++){
			String name = names[i];
			if(name.length()>= LongName.length())
				LongName = name;
		}
		
		return LongName;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			int n =  in.nextInt();
			in.nextLine();
			String[] names = new String[n];
			for(int i = 0 ; i<n; i++)
				names[i] =  in.next();
			System.out.println(LongesNmae(names));
		}
		in.close();
	}

}
