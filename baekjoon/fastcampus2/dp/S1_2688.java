package baekjoon.fastcampus2.dp;

import java.io.*;

public class S1_2688 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int N;
    static long[][] dp = new long[65][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for(int i = 1; i <= 64; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }

        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            long ans = 0;
            for(int j = 0; j <= 9; j++) {
                ans += dp[N][j];
            }
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
