package Queues;

public class MainClassCQueue {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CircularQueue<Integer> q = new CircularQueue<>(10);
		for(int i =1; i<=9; i++){
			q.enqueue(i);
		}
		
//		for(int i =0; i<5; i++){
//			System.out.println(q.deueue());
//		}
		System.out.println(q.peek());
		System.out.println(q.isFull());
		System.out.println(q.isEmpty());
		 
		
	}

}
