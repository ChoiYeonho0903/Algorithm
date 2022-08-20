package baekjoon.fastcampus2.dp;

import java.util.*;
import java.io.*;

public class S1_9465 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int N;
    static int[][] A;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            A = new int[2][N+1];
            dp = new int[2][N+1];

            for(int j = 0; j < 2; j++) {
                String str = br.readLine();
                st = new StringTokenizer(str, " ");
                for(int k = 1; k <= N; k++) {
                    A[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = A[0][1];
            dp[1][1] = A[1][1];

            for(int j = 2; j <= N; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + A[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + A[1][j];
            }

            sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
        }
        System.out.print(sb);
    }
}