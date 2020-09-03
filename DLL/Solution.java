package DLL;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedlist list = new MyLinkedlist();
		
		for(int i = 1; i<=10;i++){
			list.appent(i);
		}
		
		list.print();
		System.out.println();
		list.addAt(10, 0);
		list.print();
		
		
		 
	}

}
