package list;

/*
 * https://opentutorials.org/module/1335/8857 참고
 */

public class LinkedList {
	private Node head;							//첫번째 노드
	private Node tail;							//마지막 노드
	private int size = 0;
	
	private class Node{
		private Object data;					//데이터 저장 필드
		private Node next;						//다음 노드
		public Node(Object input) {				
			this.data = input;
			this.next = null;
		}
		
		public String toString() {				//노드 내용을 쉽게 출력해 확인
			return String.valueOf(this.data);
		}
	}
	
	public void addFirst(Object input) {		//첫번째 노드에 추가
		Node newNode = new Node(input);
		
		newNode.next = head;
		head = newNode;
		size++;
		if(head.next == null)
			tail = head;
	}
	
	public void addLast(Object input) {			//마지막 노드에 추가
		Node newNode = new Node(input);
		
		if(size == 0) {
			addFirst(input);
		}
		else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	Node node(int index) {						//중간에 추가
		Node x = head;
		for(int i = 0; i < index; i++)
			x = x.next;
		return x;
	}
	
	public void add(int index, Object input) {
		if(index == 0) {
			addFirst(input);
		}
		else {
			Node temp1 = node(index - 1);
			Node temp2 = temp1.next;
			Node newNode = new Node(input);
			temp1.next = newNode;
			newNode.next = temp2;
			size++;
			if(newNode.next == null)
				tail = newNode;
		}
	}
	
	public void removeFirst() {
		Node temp = head;
		head = temp.next;
		
		temp = null;
		size--;
		return;
	}
	
	public void remove(int input) {		//index를 인자로 받음
		if(input == 0) {
			removeFirst();
		}
		
		Node temp1 = node(input-1);
		Node temp2 = temp1.next;
		
		temp1.next = temp2.next;
		if(temp2 == tail)
			tail = temp1;
		
		temp2 = null;
		size--;
		
	}
	
	public int size() {
		return size;
	}
	
	public Object get(int index) {
		Node temp = node(index);
		return temp.data;
	}
	
	public void print() {
		System.out.println("List--");
		for(int i = 0; i < size(); i++) {
			System.out.println(get(i));
		}
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addFirst(11);
		ll.addLast(22);
		ll.addLast(33);
		ll.addLast(44);
		ll.addLast(55);
		
		System.out.println("index 2 = "+ll.get(2));
		
		
		ll.print();
		
		ll.add(1, 100);
		ll.print();
		
		ll.remove(4);
		ll.removeFirst();
		
		ll.print();
	}

}
