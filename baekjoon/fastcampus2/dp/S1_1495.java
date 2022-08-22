package baekjoon.fastcampus2.dp;

import java.util.*;
import java.io.*;

public class S1_1495 {
    static int N;
    static int S;
    static int M;
    static int[] A;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N+1];
        dp = new int[N+1][M+1];

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][S] = 1;

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= M; j++) {
                if(dp[i-1][j] > 0) {
                    if(j + A[i] <= M) {
                        dp[i][j + A[i]] = 1;
                    }

                    if(j - A[i] >= 0) {
                        dp[i][j - A[i]] = 1;
                    }
                }
            }
        }

        int ans = -1;
        for(int i = 0; i <= M; i++) {
            if(dp[N][i] > 0) {
                ans = i;
            }
        }

        System.out.println(ans);
    }
}