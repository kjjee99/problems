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
	
	
	//맨 앞에 삽입했을 때
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		if(tail == null) {
			tail = newNode;
			newNode.next = newNode;
		}
		else {
			newNode.next = tail.next;
			tail.next = newNode;
		}
		size++;
	}
	
	public void add(Object input) {
		Node newNode = new Node(input);
		
		if(size == 0)		addFirst(input);
//		else if(tail)
	}
	
	//맨 뒤에 삽입했을때
		public void addLast(Object input) {
			Node newNode = new Node(input);
			if(tail == null) 	addFirst(input);
			else {
				newNode.next = tail.next;
				tail.next = newNode;
				tail = newNode;
			}
			size++;   
		}
		
	//모든 리스트 출력
	public void get() {
		Node currentNode = tail.next;
		if(tail.next == null)	return;
		else {
			int i = size;
			System.out.println("circular list");
			while(i > 0) {
				System.out.println(currentNode.data);
				currentNode = currentNode.next;
				i--;
			}
		}
	}
	
	//삭제할 데이터를 입력받아 그 데이터를 가지고 있는 노드 삭제
	public void remove(Object input) {
		Node head = tail.next;
		Node currentNode = head;
		boolean chk = false;
		
		if(tail.next == null)	return;
		do {
			Node nextNode = currentNode.next;
			if(nextNode.data == input) {
				if(tail == head) {			//only one node
					head = null;
					tail = null;
				}
				else {
					currentNode.next = nextNode.next;
					if(head == nextNode)	head = head.next;
					if(tail == nextNode)	tail = currentNode;
				}
				chk = true;
				size--;
				break;
			}
			currentNode = nextNode;
		}while(currentNode != head);
		
		if(chk == true)		System.out.println("remove data: "+input);
		else				System.out.println("Data "+input+" doesn't exist.");
	}
	
	public static void main(String[] args) {
		CircleList cl = new CircleList();
		cl.addFirst(10);
		cl.addLast(15);
		cl.addFirst(5);
		cl.addLast(20);
		
		cl.get();
		
		cl.remove(15);
		cl.remove(8);
		cl.get();
	}

}
