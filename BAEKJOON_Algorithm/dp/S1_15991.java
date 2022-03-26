package BAEKJOON_Algorithm.dp;

import java.io.*;

public class S1_15991 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp = new int[100001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        for(int i = 4; i <= 100000; i++) {
            dp[i] += dp[i-2];
            dp[i] %= 1000000009;
            if(i-4 >= 0) {
                dp[i] += dp[i-4];
                dp[i] %= 1000000009;
            }
            if(i-6 >= 0) {
                dp[i] += dp[i-6];
                dp[i] %= 1000000009;
            }
        }
        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.print(sb);
    }
}
