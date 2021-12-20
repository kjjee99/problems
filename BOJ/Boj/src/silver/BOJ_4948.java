package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_4948 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Boolean> prime = new ArrayList<Boolean>();
		initial(prime);
		
		int cases = Integer.parseInt(br.readLine());
		while(cases == 0){
			int number = Integer.parseInt(br.readLine());
			
			for(int i = 2; i < number * 2; i++) {
				if(prime.get(i)) {
					for(int j = i * i; j < number * 2; j += i) {
						prime.set(j, false);
					}
				}
			}
			int result = prime.size();
			System.out.println(result);
			cases--;
		}
	}
	
	public static void initial(ArrayList<Boolean> list) {
		list.add(false);
		list.add(false);
	}

}
