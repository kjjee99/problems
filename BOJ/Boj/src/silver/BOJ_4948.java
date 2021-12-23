package silver;

//n<x<=2n의 소수 개수 찾기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_4948 {

	public static void main(String[] args) throws IOException {
		boolean[] prime = new boolean[246913];
		prime[0] = prime[1] = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//소수 미리 구하기
		for (int i = 2; i < Math.sqrt(prime.length); i++) {
			if (!prime[i]) {
				for (int j = i * i; j < prime.length; j += i) {
					prime[j] = true;
				}
			}
		}
		int cases = Integer.parseInt(st.nextToken());
		while (cases != 0) {
			int result = 0;
			for(int i = cases + 1; i < 2 * cases + 1; i++)	
				if(!prime[i])	result++;
			System.out.println(result);
			st = new StringTokenizer(br.readLine());
			cases = Integer.parseInt(st.nextToken());
		}
	}

	public static void initial(ArrayList<Boolean> list) {
		list.add(false);
		list.add(false);
	}

}
