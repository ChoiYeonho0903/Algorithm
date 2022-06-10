package baekjoon.fastcampus.dp;

import java.io.*;

public class S3_9095 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            dp = new int[15];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int j = 4; j <= n; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}
