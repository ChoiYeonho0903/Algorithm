package BAEKJOON_Algorithm.dp;

import java.io.*;

public class S3_2579 {
    static int N;
    static int[] A;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[301];
        dp = new int[301][2];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        dp[1][0] = A[1];
        dp[2][0] = A[2] + A[1];
        dp[2][1] = A[2];
        for(int i = 3; i <= N; i++) {
            dp[i][0] = dp[i-1][1] + A[i];
            dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + A[i];
        }
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}
