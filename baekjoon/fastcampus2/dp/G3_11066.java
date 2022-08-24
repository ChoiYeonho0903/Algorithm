package baekjoon.fastcampus2.dp;

import java.util.*;
import java.io.*;

public class G3_11066 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int K;
    static int[] A;
    static int[][] dp;
    static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            K = Integer.parseInt(br.readLine());
            A = new int[K+1];
            dp = new int[K+1][K+1];
            sum = new int[K+1][K+1];

            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int i = 1; i <= K; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 1; i <= K; i++) {
                for(int j = i; j <= K; j++) {
                    sum[i][j] = sum[i][j-1] + A[j];
                }
            }

            for(int len = 2; len <= K; len++) {
                for(int i = 1; i <= K - len + 1; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + sum[i][j]);
                    }
                }
            }

            sb.append(dp[1][K]).append("\n");
        }
        System.out.print(sb);
    }
}