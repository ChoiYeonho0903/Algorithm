package BAEKJOON_Algorithm.dp;

import java.io.*;

public class S1_11057 {
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[1001][10];
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for(int i = 2; i <= N; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int m = 0; m <= j; m++) {
                    dp[i][j] += dp[i-1][m];
                    dp[i][j] %= 10007;
                }
            }
        }
        int sum = 0;
        for(int i = 0; i <= 9; i++) {
            sum += dp[N][i];
            sum %= 10007;
        }
        System.out.println(sum);
    }
}
