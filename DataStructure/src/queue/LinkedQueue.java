package queue;

public class LinkedQueue {
	private Node front = null;
	private Node rear = null;
	private int size = 0;

	private class Node{
		private Object data;
		private Node next = null;
		public Node(Object data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void enqueue(Object input) {
		Node node = new Node(input);
		
		
		if(front == null) {
			front = node;
		}
		else {
			rear.next = node;
		}
		rear = node;
		size++;
		
	}
	
	public void dequeue() {
		Node temp = front.next;
		front = temp;
		if(size == 1) 	front = null;
		size--;
		
	}
	
	public void show() {
		Node x = front;
		if(size == 0)	System.out.println("Queue is Empty");
		for(int i = 0; i < size; i++) {
			System.out.print(x.data+" ");
			x = x.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedQueue queue = new LinkedQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.show();
		
		queue.dequeue();
		queue.dequeue();
		queue.show();
		
		queue.dequeue();
		queue.show();
	}

}
