package bronze;

//5와 3으로 최소로 나누기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {
	public static BufferedReader sc = new BufferedReader (new InputStreamReader(System.in));
	
	//greedy
	public static void main(String[] args) throws IOException{
		int sugar = Integer.parseInt(sc.readLine());
		int bag = 0;
		while (sugar >= 0) {
			if(sugar % 5 == 0) {
				bag += sugar / 5;
				break;
			}
			sugar -= 3;
			bag++;
		}
		if(sugar < 0) 	bag = -1;
		System.out.println(bag);
	}

	/*public static void main(String[] args) throws NumberFormatException, IOException {
		int sugar = Integer.parseInt(sc.readLine());
		int bag = 0;
		while (sugar > 0) {
			if (sugar % 5 == 0) {
				sugar -= 5;
				bag++;
			} else if (sugar % 3 == 0) {
				sugar -= 3;
				bag++;
			} else if (sugar > 5) {
				sugar -= 5;
				bag++;
			} else {
				bag = -1;
				break;
			}
		}
		System.out.println(bag);
	}*/

}
