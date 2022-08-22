package baekjoon.fastcampus2.dp;

import java.util.*;
import java.io.*;

public class G5_5557 {
    static int N;
    static int[] A;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        dp = new long[N+1][21];

        String str = br.readLine();
        st = new StringTokenizer(str, " ");

        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        if(A[1] + A[2] <= 20) {
            dp[2][A[1] + A[2]]++;
        }
        if(A[1] - A[2] >= 0) {
            dp[2][A[1] - A[2]]++;
        }

        for(int i = 3; i < N; i++) {
           for(int j = 0; j <= 20; j++) {
               if(dp[i-1][j] > 0) {
                   if(j + A[i] <= 20) {
                       dp[i][j + A[i]] += dp[i-1][j];
                   }
                   if(j - A[i] >= 0) {
                       dp[i][j - A[i]] += dp[i-1][j];
                   }
               }
           }
        }

        System.out.println(dp[N-1][A[N]]);
    }
}