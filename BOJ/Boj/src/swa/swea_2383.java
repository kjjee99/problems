package swa;

/* 점심 식사시간 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_2383 {
	private static int[][] map;
	private static boolean[] selected;
	private static List<int[]> people, stairs;
	private static List<int[]> stair1, stair2;
	private static int n, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());

			people = new ArrayList<>();
			stairs = new ArrayList<>();

			map = new int[n][n]; // 1: person, <= 2: stair length
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						people.add(new int[] { i, j });
					if (map[i][j] > 1)
						stairs.add(new int[] { i, j });
				}
			}

			min = Integer.MAX_VALUE;
			selected = new boolean[people.size()];
			comb(0);
			System.out.println("#"+tc+" "+min);
		}
	}

	private static void comb(int cnt) {
		if (cnt == people.size()) {
			stair1 = new ArrayList<>();
			stair2 = new ArrayList<>();
			for (int i = 0; i < cnt; i++) {
				int[] now = people.get(i);
				if (selected[i]) {
					int len = Math.abs(now[0] - stairs.get(0)[0]) + Math.abs(now[1] - stairs.get(0)[1]);
					stair1.add(new int[] { now[0], now[1], len });
				} else {
					int len = Math.abs(now[0] - stairs.get(1)[0]) + Math.abs(now[1] - stairs.get(1)[1]);
					stair2.add(new int[] { now[0], now[1], len });
				}
			}
			int time = down();
			min = Math.min(min, time);
			return;
		}

		selected[cnt] = true;
		comb(cnt + 1);
		selected[cnt] = false;
		comb(cnt + 1);
	}

	private static int down() {
		int cnt = people.size();
		int time = 1;
		Queue<int[]> q1 = new LinkedList<>();
		Queue<int[]> q2 = new LinkedList<>();

		Queue<int[]> w1 = new LinkedList<>();
		Queue<int[]> w2 = new LinkedList<>();

		int s1 = map[stairs.get(0)[0]][stairs.get(0)[1]];
		int s2 = map[stairs.get(1)[0]][stairs.get(1)[1]];

		while (true) {
			if (cnt == 0)	break; // 모든 사람이 다 내려갔을 때 종료

			for (int i = 0; i < q1.size(); i++) {
				int[] person = q1.poll();
				int dep = person[1] - 1;
				if (dep == 0) { // 계단을 다 내려왔을 때
					cnt--;
					i--;
					continue;
				}
				q1.add(new int[] { i, dep });
			}
			for (int i = 0; i < q2.size(); i++) {
				int[] person = q2.poll();
				int dep = person[1] - 1;
				if (dep == 0) { // 계단을 다 내려왔을 때
					cnt--;
					i--;
					continue;
				}
				q2.add(new int[] { i, dep });
			}
			while (q1.size() < 3 && !w1.isEmpty()) {
				q1.add(w1.poll());
			}
			while (q2.size() < 3 && !w2.isEmpty()) {
				q2.add(w2.poll());
			}

			for (int i = 0; i < stair1.size(); i++) {
				int[] person = stair1.get(i);
				int dep = person[2] - 1;
				if (dep == 0) {
					if (q1.size() == 3) {
						w1.add(new int[] { i, s1 });
					}
					else {
						q1.add(new int[] { i, s1 });
					}
					stair1.remove(i);
					i--;
				} else {
					stair1.set(i, new int[] { person[0], person[1], dep });
				}
			}
			for (int i = 0; i < stair2.size(); i++) {
				int[] person = stair2.get(i);
				int dep = person[2] - 1;
				if (dep == 0) {
					if (q2.size() == 3) {
						w2.add(new int[] { i, s2 });
					}
					else {
						q2.add(new int[] { i, s2 });
					}
					stair2.remove(i);
					i--;
				} else {
					stair2.set(i, new int[] { person[0], person[1], dep });
				}
			}

			time++;
		}
		return time;
	}

}
