package DLL;
public class MyLinkedlist {
	
	static class Node{
		int data;
		Node previous;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	Node head;
	
	void appent(int data){
		
		Node new_node = new Node(data);
		Node last= head;
		
		new_node.next = null;
		if(head == null) {
			new_node.previous = null;
			head = new_node;
			return;
		}
		
		while(last.next != null) {
			last = last.next;
		}
		last.next = new_node;
		new_node.previous = last;
	}
	
	void push(int data){
		
		Node new_node = new Node(data);
		new_node.next = head;
		new_node.previous= null;
		
		if(head != null) {
			head.previous = new_node;
		}
		head = new_node;	
	}
	
	void addAt(int Data, int position){
		Node new_node = new Node(Data);
		int len = lenght(head);
		if(position==0){
			push(Data);
		}else if(position == len) {
			appent(Data);
		}else if(position<0 || len <position) {
			System.out.println("Invalid Position !");
		}else {
			Node current = head;
			
			for(int i =0; i<position -1; i++) {
			 
				current =  current.next;
			}
			new_node.next = current.next;
			new_node.previous = current;
			current.next =  new_node;
			new_node.next.previous =  new_node;
			
		}
	}
	
	
	void insetAfter(Node prev_node, int new_data){
		
		if(prev_node == null) {
			System.out.print("New_Node can not be a Null !");
			return;
		}
		Node new_node = new Node(new_data);
		new_node.next =  prev_node.next;
		prev_node.next = new_node;
		new_node.previous = prev_node;
		
		if(new_node.next != null){
			new_node.next.previous =  new_node;
		}
	}
	
	void print(){
		Node current = head;
		if(head == null) {
			System.out.println("List is Empty");
			return;
		}
		while(current !=  null){
			System.out.print(current.data+"->");
			current = current.next;
		}
	}
	
	void find(int key){
		
		Node current =  head;
		boolean ststus =  false;
		
		if(head == null){
			System.out.println("List is Empty !");
		}else {
			
			int  i =0;
			while(current.next !=  null) {
				
				if(current.data == key) {
					System.out.print("Element is Found at Index : "+i);
					ststus = true;
				}
				
				i++;
				current = current.next;
			}
			
		}
		
		if(!ststus) System.out.println("Elemnt is Not found !");
		
	}
	
	
	void revours() {
		Node temp = null;
		Node current = head;
		if(head == null) {
			System.out.println("List is already Empty");
			return;
		}else {
			while(current != null) {
				temp = current.previous;
				current.previous =  current.next;
				current.next =  temp;
				
				current  = current.previous;
			}
			if(temp !=null) {
				head =  temp.previous;
			}
			return;
		}
		
	}
	
	int lenght(Node head) {
		int count = 0;
		if(head == null){
			return 0;
		}else{
			
			Node temp = head;
			
			while(temp!=null) {
				temp =  temp.next;
				count++;
			}
		}
		return count;
	}
}
