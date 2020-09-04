package myCircularSingleLikedlist;

public class Solution {
	
	public static void main(String[] args) {
		MyLinkedlist list = new MyLinkedlist();
		
		for(int  i = 1; i<=10; i++) {
			list.Add(i);
		}
		list.print();
		System.out.println();
		list.deleteFromlast();
		list.deleteFromlast();
		System.out.println();
		list.print();
	}

}
