//수정必
package silver;

//셀프넘버

import java.io.IOException;

public class BOJ_4673 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int self_num = 1;
		boolean[] chk = new boolean[10001];
		while(self_num <= 10000) {
			int n = selfNum(self_num);
			if(n < 10001)
				chk[n] = true;
			self_num++;
		}
		for(int i = 0; i < 10001; i++) {
			if(!chk[i])
				System.out.println(i);
		}

	}
	
	public static int selfNum(int number) {
		int temp = number;
		while(number != 0) {
			temp += number % 10;
			number = number / 10;
		}
		return temp;
	}

}
