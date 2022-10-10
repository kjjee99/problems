package gold;

/* 괄호 추가하기 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16637 {
    private static int[] nums;
    private static char[] op;
    private static int n, max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        nums = new int[n / 2 + 1];
        op = new char[n / 2];

        String e = br.readLine();
        for(int i = 0; i < e.length(); i++){
            if(e.charAt(i) == '+' || e.charAt(i) == '-' || e.charAt(i) == '*'){
                op[i / 2] = e.charAt(i);
            }else{
                nums[i / 2] = e.charAt(i) - '0';
            }
        }

        comb(1, 0, nums[0]);
        System.out.println(max);
    }

    private static void comb(int start, int cnt, int sum){
        if(start > n / 2){
            max = Math.max(max, sum);
            return;
        }

        if(start + 1 <= n / 2) {
            int next = calculate(op[cnt + 1], nums[start], nums[start + 1]);
            comb(start + 2, cnt + 2, calculate(op[cnt], sum, next));
        }
        comb(start + 1, cnt + 1, calculate(op[cnt], sum, nums[start]));
    }

    private static int calculate(char op, int a, int b){
        switch (op){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 0;
    }
}
