package circularDLL;

public class MyLinkedList {

	public class Node{
		int data;
		Node next;
		Node prev;
		public Node(int data){
			this.data = data;
			next = null;
			prev = null;
		}
	}
	
	Node head;
	
	boolean isEmpty(Node head) {
		return head == null;
	}
	
	void append(int data){
		if(head ==  null) {
			Node new_node = new Node(data);
			new_node.next = new_node.prev = new_node;
			head = new_node;
			return;
		}
		Node tail = (head).prev;
		Node new_node =  new Node(data);
		new_node.next  =  head;
		(head).prev = new_node;
		new_node.prev = tail;
		tail.next =  new_node;
	}
	
	void add(int data){
		
		Node tail = (head).prev;
		Node new_node = new Node(data);
		new_node.next =  head;
		new_node.prev = tail;
		tail.next = (head).prev = new_node;
		head =  new_node;
	}
	
	void insertAt(int data, int position){
		// Check list is empty or not !
		if(head == null) {
			System.out.println("Lists is laready Empty !");
		}
		if(position ==0) {
			add(data);
		}
		int len =  lenght(head);
		
		if(position < 0 || len < position) {
			System.out.println("Invalid Position !");
		}
		Node tail =  (head).prev;
		Node current =  head;
		Node new_node = new Node(data);
		for(int i =0; i<position -1; i++) {
			current = current.next;
		}
		new_node.next =  current.next;
		current.next = new_node;
		new_node.prev =  current;
		new_node.next.prev = new_node;
	}
	
	void find(int key) {
		if(isEmpty(head)) {
			System.out.println("Lists is laready Empty !");
			return;
		}
		
		Node tail = (head).prev;
		Node current =  head;
		int index =0;
		boolean status = false;
		while(current != tail) {
			
			if(current.data == key) {
				status = true;
				System.out.println("Element is present at Index "+index);
				break;
			}
			current =  current.next;
			index++;
		}
		if(current.data == key) {
			status = true;
			System.out.println("Element is present at Index "+index);
		}
		
		
		if(!status) {
			System.out.println("Element is Not Found !");
		}
	}
	
	void print() {
		if(isEmpty(head)) {
			System.out.println("Lists is already Empty !");
			return;
		}
		Node current = head;
		Node tail =  (head).prev;
		while(current != tail) {
			
			System.out.printf("%d ", current.data);  
			current =  current.next;
		}
		System.out.printf("%d ", current.data);  
		 
	}
	
	void  revrous() {
		if(isEmpty(head)) {
			System.out.println("List is already Empty !");
			return;
		}
		Node tail =  (head).prev;
		Node current = tail;
		while(current.prev != tail) {
			System.out.print(current.data+ " ");
			current =  current.prev;
		}
		System.out.print(current.data+ " ");
	}
	
	int lenght(Node head) {
		int count = 0;
		
		if(head == null) return 0;
		Node temp = head;
		while(temp.next != head) {
			temp =  temp.next;
			count++;
		}
		return count;
	}
	
	
	
	void remove(int Element){
		// check is list is Empty of not 
		if(isEmpty(head)) {
			System.out.println("Lists is laready Empty !");
			return;
		}
		Node tail = (head).prev;
		Node current = head;
		Node previous = null;
		
		while(current.data != Element){
			if(current.next == head) {
				System.out.println("Element is not present in a list !");
				return;
			}
			previous = current;
			current = current.next;
		}
		//if list has only one Node
		if(current.next == head && previous == null){
			(head)=null;
			tail = null;
			return;
		}
		
		if(current == head){
			previous = (head).prev;
			head  = (head).next;
			previous.next =head;
			(head).prev =previous;
		}else if(current.next ==  head) {
			previous.next = head;
			(head).prev = previous;
		}else {
			previous.next =  current.next;
			current.next.prev = previous;
		}
	}
	
	void removeAt(int index){
		
		if(isEmpty(head)){
			System.out.println("List is already Empty !");
			return;
		}
		
		Node tail = (head).prev;
		Node current =  head;
		Node previous = null;
		
		for(int i = 0; i<=index -1; i++){
			previous = current;
			current =  current.next;
		}
		
		if(current.next == head && previous == null){
			(head) = null;
			tail = null;
		}
		
		if(current == head){
			previous = tail;
			head = (head).next;
			previous.next = head;
			(head).prev = previous;
		}
		else if(current.next == head){
			previous.next = head;
			(head).prev = previous;
		}else{
			previous.next =  current.next;
			current.next.prev =  previous;
		}
	}
	
	void delete(){
		 (head).prev = null;
		 Node temp =head;
		 
		 while(temp.next== head){
			 temp.prev = null;
			 temp = temp.next;
		 }
		 head = null;
		 
	}
}
