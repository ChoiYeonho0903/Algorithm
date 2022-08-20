package baekjoon.fastcampus2.dp;

import java.io.*;

public class S1_1309 {
    static final int MOD = 9901;
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N+1][3];

        // 두 개의 방 중에 사자를 아예 넣지 않는 경우
        dp[1][0] = 1;
        // 두 개의 방 중에 사자를 왼쪽 방에 넣는 경우
        dp[1][1] = 1;
        // 두 개의 방 중에 사자를 오른쪽 방에 넣는 경우
        dp[1][2] = 1;

        for(int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
            dp[i][0] %= MOD;
            dp[i][1] = dp[i-1][0] + dp[i-1][2];
            dp[i][1] %= MOD;
            dp[i][2] = dp[i-1][0] + dp[i-1][1];
            dp[i][2] %= MOD;
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % MOD);

    }
}