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
	
	public void sPush(int input) {
		topIndex++;
	}
	
	public void sPop(int input) {
		topIndex--;
	}
	
	public int sPeek(int input) {
		return stackArray[topIndex];
	}
	
	public boolean sIsEmpty() {
		if(topIndex == -1)		return true;
		else					return false;
	}
	
	public static void main(String[] args) {
		
	}

}
