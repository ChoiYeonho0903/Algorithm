package baekjoon.fastcampus.dp;

import java.io.*;

public class B2_10870 {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[21];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= 20; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N]);
    }
}
