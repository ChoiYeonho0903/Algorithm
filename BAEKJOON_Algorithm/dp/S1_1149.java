package BAEKJOON_Algorithm.dp;

import java.io.*;
import java.util.*;

public class S1_1149 {
    static int N;
    static int[][] A;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N+1][3];
        dp = new int[N+1][3];
        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1; i <= N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + A[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + A[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + A[i][2];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            if(dp[N][i] < min) {
                min = dp[N][i];
            }
        }
        System.out.println(min);
    }
}
