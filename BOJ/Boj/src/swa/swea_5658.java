package swa;

/* 보물상자 비밀번호 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class swea_5658 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   // 숫자의 개수
            int k = Integer.parseInt(st.nextToken());   // K번째 큰수

            String input = br.readLine();
            Deque<Character> q = new ArrayDeque<>();
            for(int i = 0; i < n; i++){
                q.add(input.charAt(i));
            }

            int len = n / 4;

            PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {return n2 - n1;});
            for(int x = 0; x < len; x++){
                for(int i = 0; i < 4; i++){
                    String s = "";
                    for(int j = 0; j < len; j++){
                        s += q.peek();
                        q.add(q.poll());
                    }
                    int num = Integer.parseInt(s, 16);
                    if(!pq.contains(num)) pq.add(num);
                }
                q.addFirst(q.pollLast());
            }

            for(int i = 0; i < k - 1; i++){
                pq.poll();
            }

            System.out.println("#" + tc + " " + pq.poll());
        }
    }
}
