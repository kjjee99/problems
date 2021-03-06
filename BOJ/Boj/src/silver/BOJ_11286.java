package silver;

/*
 * 절대값 힙
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
			int a1 = Math.abs(a);
			int b1 = Math.abs(b);
			if(a1 == b1)	return a - b;
			return a1 - b1;
		});
		while(N--> 0) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(queue.isEmpty())	System.out.println(0);
				else				System.out.println(queue.poll());
				continue;
			}
			queue.add(input);
		}
	}

}
