package baekjoon.fastcampus2.dp;

import java.io.*;

public class S2_15990 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int N;
    static int[][] dp = new int[100_001][4];
    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i = 4; i <= 100_000; i++) {
            dp[i][1] = dp[i-1][2] + dp[i-1][3];
            dp[i][1] %= MOD;
            dp[i][2] = dp[i-2][1] + dp[i-2][3];
            dp[i][2] %= MOD;
            dp[i][3] = dp[i-3][1] + dp[i-3][2];
            dp[i][3] %= MOD;
        }

        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            int ans = 0;
            for(int j = 1; j <= 3; j++) {
                ans += dp[N][j];
                ans %= MOD;
            }
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}