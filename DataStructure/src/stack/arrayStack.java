package stack;

public class arrayStack {
	private int[] stackArray = new int[100];	
	private int topIndex = -1;
	
	public class arrStack{
		private int data;
		public arrStack(int input) {
			this.data = input;
		}
	}
	
	public void sPush(int input) {		//데이터 넣기
		topIndex++;
	}
	
	public void sPop(int input) {		//마지막 데이터 추출 후 삭제
		topIndex--;
	}
	
	public int sPeek(int input) {		//마지막 데이터 보여주기
		return stackArray[topIndex];
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
	
	public static void main(String[] args) {
		
	}

}
