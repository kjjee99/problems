package stack;

import java.util.Stack;

public class IncrementOperator {

	private int getOperator(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 5;
		case '*':
		case '/':
			return 3;
		case '(': 
			return 1;
		}
		return -1;
	}

	private int compareOperator(char op1, char op2) {
		int operator1 = getOperator(op1);
		int operator2 = getOperator(op2);

		if (operator1 > operator2) // 2의 우선순위가 높을 때
			return -1;
		else if (operator1 < operator2) // 1의 우선순위가 높을 때
			return 1;
		else // 우선순위가 같을 때
			return 0;
	}
	
	
	private void addOperator(Stack<Character> stack, Stack<Character> temp) {
		temp.forEach(op -> stack.add(op));
		temp.clear();
	}
	
	//postfix(후위표기법)
	public Stack<Character> postfix(String str){
		IncrementOperator operator = new IncrementOperator();
		Stack<Character> stack = new Stack<>();
		Stack<Character> temporary_op = new Stack<>();	
		
		for(int i = 0; i < str.length(); i++) {
			int value = operator.getOperator(str.charAt(i));
			if(value != -1) {
				if(!temporary_op.isEmpty() 
						&& operator.compareOperator(temporary_op.get(temporary_op.size() - 1), str.charAt(i)) == -1) {
					operator.addOperator(stack, temporary_op);
				}
				if(str.charAt(i) != '(')	temporary_op.add(str.charAt(i));
			}
			else {
				if(str.charAt(i) == ')') 	operator.addOperator(stack, temporary_op);
				else						stack.add(str.charAt(i));
			}
		}
		
		if(!temporary_op.isEmpty()) 	operator.addOperator(stack, temporary_op);
		

		System.out.println("::postfix::");
		stack.forEach(ch -> System.out.print(ch + " "));
		System.out.println();
		
		return stack;
	}

	public static void main(String[] args) {
		IncrementOperator operator = new IncrementOperator();
		String str = "(5+3)*4-2";
		
		operator.postfix(str);
		
	}

}
