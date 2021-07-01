package list;

public class DoublyLinkedList {
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	public class Node{
		private Object data;
		private Node next;
		private Node prev;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public void addFirst(Object input) {
		Node newNode = new Node(input);

		if(head != null) {
			head.prev = newNode;	//첫번째 노드 추가 제외
			newNode.next = head;
			newNode.prev = null;
		}
		else{
			tail = newNode;
			newNode.next = null;
			newNode.prev = null;
		}
		
		head = newNode;
		size++;
	}
	
	public void add(int index, Object input) {
		Node newNode = new Node(input);
		
		if(index == 0)				addFirst(input);
		else if(index == size - 1)	addLast(input);
		else {
			Node prevNode = getNode(index - 1);
			Node nextNode = prevNode.next;
			prevNode.next = newNode;
			newNode.next = nextNode;
			newNode.prev = prevNode;
			nextNode.prev = newNode;
		}
		size++;
	}
	
	public void addLast(Object input) {
		Node newNode = new Node(input);
		
		if(size == 0)	addFirst(input);
		else {
			tail.next = newNode;
			newNode.prev = tail;
			newNode.next = null;
			tail = newNode;
		}
		size++;
	}
	
	public void get() {
		Node node = head;
		System.out.println("Doubly linked list");
		int i = size;
		while(i > 0) {
			System.out.println(node.data);
			node = node.next;
			i--;
		}
	}
	
	public Node getNode(int index) {
		if(index < size/2) {
			Node node = head;
			for(int i = 0; i < index; i++)
				node = node.next;
			return node;
		}
		else {
			Node node = tail;
			for(int i = size - 1; i > index; i--)
				node = node.prev;
			return node;
		}
		
	}
	
	public void remove(Object input) {
		Node node = head;
		Node currentNode = head;
		boolean chk = false;
		
		if(head == null)	return;
		do {
			Node nextNode = currentNode.next;
			if(nextNode.data == input) {
				currentNode.next = nextNode.next;
				if(head == nextNode)	head = head.next;
				if(tail == nextNode)	tail = currentNode;
					
				chk = true;
				size--;
				break;				}
			currentNode = nextNode;
		}while(currentNode != null);
		
		if(chk == true)		System.out.println("remove data: "+input);
		else				System.out.println("Data "+input+" doesn't exist.");
	}
	
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		
		dll.addFirst(10);
		dll.addFirst(5);
		dll.addLast(20);
		dll.addLast(25);
		dll.add(2, 15);
		
		dll.get();
		
		dll.remove(10);
		dll.get();
	}

}
