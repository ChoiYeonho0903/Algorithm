package baekjoon.fastcampus2.dp;

import java.io.*;

public class S1_2156 {
    static int N;
    static int[] drink;
    static int[][] dp;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        drink = new int[N+1];
        dp = new int[N+1][2];

        for(int i = 1; i <= N; i++) {
            drink[i] = Integer.parseInt(br.readLine());
        }

        dp[1][0] = drink[1];
        max = drink[1];

        if(N >= 2) {
            dp[2][0] = drink[1] + drink[2];
            dp[2][1] = drink[2];

            max = Math.max(dp[2][0], max);
        }

        for(int i = 3; i <= N; i++) {
            dp[i][0] = dp[i-1][1] + drink[i];
            dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + drink[i];
            dp[i][1] = Math.max(dp[i][1], Math.max(dp[i-3][0], dp[i-3][1]) + drink[i]);

            max = Math.max(dp[i][0], max);
            max = Math.max(dp[i][1], max);
        }

        System.out.println(max);
    }
}