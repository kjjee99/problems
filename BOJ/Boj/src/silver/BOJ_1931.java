package silver;
/*
 * 회의실 배정
 * 정렬&그리디
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int time[][] = new int[N][2];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, new Comparator<int[]>(){
			@Override
			public int compare(int[] t1, int[] t2) {
				//종료시간이 같을 경우
				if(t1[1] == t2[1])
					//시작시간 비교
					return t1[0] - t2[0];
				//종료시간 비교
				return t1[1] - t2[1]; 
			}
		});
		
		int cnt = 0;
		int prev = 0;
		for(int i = 0; i < N; i++) {
			if(prev <= time[i][0]) {
				prev = time[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
