package myCircularSingleLikedlist;

public class MyLinkedlist {
	
	static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data = data;
			next =  null;
		}
	}
	
	Node head = null;
	Node tail =null;
	
	public void Add(int data){
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
			newNode.next = head;
		}else {
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
		}
		
	}
	
	void addAt(int data, int position){
		
		if(head ==  null) {
			Add(data);
		}
		if(position <1){
			System.out.println("Invalid Position !");
		}
		
		if(position == 1){
			Node newNode = new Node(data);
			newNode.data = data;
			newNode.next =  head;
			head = newNode;
			tail.next = head;
		}else{
			
			Node newNode = new Node(data);
			Node previus = head;
			int count = 0;
			while(count < position -1) {
				previus = previus.next;
				count++;
			}
			 newNode.next = previus.next;
			 previus.next = newNode;
		}
	}
	
	public void print(){
		
		Node current = head;
		if(head == null) {
			System.out.println("List is empty");
		}else {
			do {
				System.out.print(current.data+"->");
				
				current = current.next;
			}while(current !=head);
			 
		}
	}
	
	public void find(int item){
		Node current = head;
		
		if(head == null) {
			System.out.println("List is Empty");
		}
		int i=1;
		boolean flag = false;
		do {
			if(current.data == item) {
				flag =  true;
				break;
			}
			current = current.next;
			i++;
		}while(current != head);
		
		if(flag) {
			System.out.println("Element is present at Index "+ i);
		}else {
			System.out.println("Element is Not present");
		} 
	}
	
	public int lenght(Node head){
		Node current = head;
		int count =0;
		
		if(head  == null) {
			System.out.println("List is Empty");
			return 0;
		}
		
		do {
			current = current.next;
			count++;
		}while(current !=  head);
		 
		return count;
	}
	
	public void deleteAtFront(){
		
		Node previous = head,Next= head;
		
		if(head == null){
			System.out.println("List is Empty !");
			return;
			
		}else if(previous.next == previous) {
			head  = null;
			tail = null;
			return;
			
		}else {
			while(previous.next !=  tail){
				
				previous = previous.next;
				Next = previous.next;
			}
			previous.next = Next.next;
			head = previous.next;
			return;
		}
	}
	
	void deleteFromlast(){
		Node current = head, previous = head;
		
		if(head == null) {
			System.out.println("List is Empty !");
			
		}else if(current.next == current) {
				head = null;
				tail = null;
				return;
		}else {
			while(current.next !=  head) {
				previous = current;
				current = current.next;
			}
			
			previous.next = current.next;
			head = previous.next;
		}
	}
	
	
	public void deleteElementAt(int index){
		Node previous = head;
		int len =  lenght(head);
		int i =1;
		
		if(head == null){
			System.out.println("List is already Empty..!");
			return;
			
		}else if(index >len || index <0){
			System.out.println("Your given Index is Invalid !");
			
		}else if(index == 1){
			
			deleteAtFront();
			return;
			
		}else {
			
			while(i < index -1) {
				previous = previous.next;
				i++;
			}
			Node nextNode = previous.next;
			previous.next = nextNode.next;
			return;
		}
	}
	
}
