package circularDLL;

public class Solution {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		MyLinkedList list = new MyLinkedList();
		for(int i =0; i<=10; i++) {
			list.append(i);
		}
		list.print();
		
		System.out.println();
//		list.revrous();
//		list.insertAt(10, 10);
//		System.out.println();
		list.delete();
		list.print();
	}

}
