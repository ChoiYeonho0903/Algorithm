package baekjoon.fastcampus.dp;

import java.io.*;
import java.util.*;

public class S1_11052 {
    static int N;
    static int[] P;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        P = new int[N+1];
        dp = new int[N+1];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 0;
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + P[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
