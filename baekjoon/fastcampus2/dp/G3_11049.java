package baekjoon.fastcampus2.dp;

import java.io.*;
import java.util.*;

public class G3_11049 {
    static int N;
    static int[][] A;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N+1][2];

        dp = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int len = 2; len <= N; len++) {
            for(int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][k] + dp[k+1][j] + A[i][0]*A[k][1]*A[j][1], dp[i][j]);
                }
            }
        }

        System.out.println(dp[1][N]);
    }
}