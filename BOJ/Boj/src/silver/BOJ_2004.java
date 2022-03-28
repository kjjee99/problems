package silver;

/*
 * 조합의 결과에서 0의 개수 구하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2004 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		int five = five_power(N) - five_power(N - K) - five_power(K);
		int two = two_power(N) - two_power(N - K) - two_power(K);
		
		System.out.println(Math.min(five, two));
		
	}

	private static int five_power(long n) {
		int cnt = 0;
		while(n >= 5) {
			cnt += n / 5;
			n /= 5;
		}
		return cnt;
	}
	
	private static int two_power(long n) {
		int cnt = 0;
		
		while(n >= 2) {
			cnt += n / 2;
			n /= 2;
		}
		
		return cnt;
	}
}
