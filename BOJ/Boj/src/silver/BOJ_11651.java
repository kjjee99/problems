package silver;

/*
 * 좌표 정렬하기2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_11651 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] points = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] p1, int[] p2) {
				if(p1[1] == p2[1])
					return p1[0] - p2[0];
				return p1[1] - p2[1];
			}
		});
		for(int[] point : points) {
			System.out.println(point[0] +" "+ point[1]);
		}
	}

}
