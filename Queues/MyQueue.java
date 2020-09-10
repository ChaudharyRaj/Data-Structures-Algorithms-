package Queues;

public class MyQueue<E> {
	
	static class Node<E>{
		E data;
		Node<E> next;
		public Node(E data){
			this.data = data;
			this.next = null;
		}
	}
	private Node<E> head, rear;
	
	public void enqueue(E data){
		Node<E> newnode = new Node<E>(data);
		
		if(head == null){
			head =rear = newnode;
			return;
		}
		rear.next = newnode;
		rear = rear.next;
	}
	
	public E dqueue(){
		if(head == null) {
			return null;
		}
		Node <E>  temp = head;
		head = head.next;
		return temp.data;
	}	
}
