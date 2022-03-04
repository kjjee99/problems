package silver;

/*
 * 좌표 정렬
 * 정렬
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11650 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] points = new int[N][2];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(points, (p1, p2) -> {
				if(p1[0] == p2[0])
					return p1[1] - p2[1];
				return p1[0] - p2[0];
		});
		
		for(int[] point : points) {
			System.out.print(point[0] +" "+ point[1]);
			System.out.println();
		}
	}

}
