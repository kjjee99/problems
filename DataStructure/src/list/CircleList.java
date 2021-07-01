package list;

public class CircleList {

	private Node tail;
	private int size = 0;
	
	public class Node{
		private Object data;
		private Node next;
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public void inserLastNode(Object input) {
		Node newNode = new Node(input);
		if(tail == null) {
			tail = newNode;
			newNode.next = newNode;
		}
		else {
			tail.next = newNode;
		}
		tail = newNode;
		size++;   
	}
	public static void main(String[] args) {

	}

}
