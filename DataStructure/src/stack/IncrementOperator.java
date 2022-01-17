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

		if (operator1 < operator2) // 2의 우선순위가 높을 때
			return -1;
		else if (operator1 > operator2) // 1의 우선순위가 높을 때
			return 1;
		else // 우선순위가 같을 때
			return 0;
	}

	public static void main(String[] args) {
		IncrementOperator operator = new IncrementOperator();
		String str = "5+3-2";
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			int value = operator.getOperator(str.charAt(i));
//			if(value != -1) {
				if(!stack.isEmpty() && operator.compareOperator(stack.lastElement(), str.charAt(i)) == -1)
					continue;
				stack.add(str.charAt(i));
//			}
		}

		stack.forEach(ch -> System.out.print(ch + " "));
		System.out.println();
	}

}
