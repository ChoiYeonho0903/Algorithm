package BAEKJOON_Algorithm.dp;

import java.io.*;

public class S2_15988 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp = new int[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= 1000000; i++) {
            dp[i] = ((dp[i-3] + dp[i-2])%1000000009 + dp[i-1])%1000000009;
        }
        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.print(sb);
    }
}
