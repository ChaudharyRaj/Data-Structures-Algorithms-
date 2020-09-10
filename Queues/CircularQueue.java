package Queues;

public class CircularQueue <E>{
	
	private int currentSise;
	private E[] CQueueElements;
	private int maxSize;
	private int rear;
	private int front;
	public CircularQueue(int maxSize){
		this.maxSize = maxSize;
		CQueueElements = (E[]) new  Object[this.maxSize];
		currentSise = 0;
		front = -1;
		rear = -1;
	}
	/*
	 * Enqueue Elements is Queue
	 */
	public void enqueue(E item) throws Exception{
		if(isFull()){
			throw new Exception("Circular Queieis is Full. Element can not be added");
		}else{
			rear = (rear +1)%CQueueElements.length;
			CQueueElements[rear] = item;
			currentSise++;
			if(front == -1)
				front = rear;
		}
	}
	
	/*
	 * Dequeue elements fron Queue*/
	public E deueue() throws Exception{
		E deQueueElement;
		if(isEmpty()){
			throw new Exception("Circular Queue is Empty. Elenets can not be dequeue");
		}else{
			deQueueElement = CQueueElements[front];
			front = (front+1)%CQueueElements.length;
			currentSise--;
		}
		return deQueueElement;
	}
	/*Peek Element*/
	public E peek() throws Exception{
		 if(isEmpty()){
			 throw new  Exception("Circular Queue is Empty . conot get any Element Form Empty Queue");
		 }else{
			 E element = CQueueElements[front];
			 return element;
		 }
	}
	
	/*
	 * check Queue isFull
	 */
	public boolean isFull(){
		return (currentSise == CQueueElements.length);
	}
	/*
	 * cheack id Queue is Empty
	 */
	public boolean isEmpty(){
		return (currentSise == 0);
	}

}
