package stack;

public class arrayStack {
	private int[] stackArray = new int[100];	
	private int topIndex = -1;
	
	public void sPush(int input) {		//데이터 넣기
		topIndex++;
		stackArray[topIndex] = input;
	}
	
	public void sPop() {		//마지막 데이터 추출 후 삭제
		System.out.println("Value is "+stackArray[topIndex]);
		topIndex--;
	}
	
	public void sPeek() {		//마지막 데이터 보여주기
		System.out.println("Value is "+stackArray[topIndex]);
	}
	
	public boolean sIsEmpty() {			//비어있는지 확인
		if(topIndex == -1)		return true;
		else					return false;
	}
	
	public void clear() {				//스택 비우기
		if(sIsEmpty()) System.out.println("Stack is already Empty");
		else {
			topIndex = -1;
			stackArray = new int[100];
		}
	}
	
	public void show() {
		if(sIsEmpty()) System.out.println("Stack is Empty.");
		else {
			for(int i = 0; i <= topIndex; i++) {
				System.out.println(stackArray[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		arrayStack stack = new arrayStack();
		
		//비어있는지 확인
		stack.clear();
		
		stack.sPush(1);
		stack.sPush(2);
		stack.sPush(3);
		stack.show();
		
		stack.sPop();
		stack.sPeek();
	}

}
