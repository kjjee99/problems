package silver;

/**
 * 걷기(그리디)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long min = Long.MAX_VALUE;

        // 수직+수평 이동
        min = Math.min(min, (x+y) * w);
        // 대각선 이동
        if((x+y)% 2 == 0)   min = Math.min(min, Math.max(x, y) * s);
        else min = Math.min(min, (Math.max(x, y) - 1) * s + w);
        // 대각선 + 수직 + 수평 이동
        min = Math.min(min, Math.min(x, y) * s + Math.abs(x - y) * w);

        System.out.println(min);
    }
}
