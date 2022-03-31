package silver;

/*
 * 프린터 우선순위
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1966 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T--> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());	//몇 번째로 인쇄되었는지 궁금한 문서가 현재 큐에서 몇 번째에 놓여있는지
			
			st = new StringTokenizer(br.readLine());
			LinkedList<int[]> dq = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				dq.add(new int[] {i,Integer.parseInt(st.nextToken())});
			}
			int cnt = 0;
			while(!dq.isEmpty()) {
				int[] now = dq.poll();
				boolean isMax = true;
				
				for(int i = 0; i < dq.size(); i++) {
					if(now[1] < dq.get(i)[1]) {
						isMax = false;
						break;
					}
				}
				if(isMax) {
					cnt++;
					if(now[0] == M)	break;
				}
				else	dq.add(now);
			}
			System.out.println(cnt);
		}
	}

}
