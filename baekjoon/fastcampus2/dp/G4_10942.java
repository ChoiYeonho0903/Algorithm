package baekjoon.fastcampus2.dp;

import java.util.*;
import java.io.*;

public class G4_10942 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1][N+1];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            dp[i][i] = 1;
        }
        for(int i = 1; i <= N - 1; i++) {
            int j = i + 1;
            if(arr[i] == arr[j]) {
                dp[i][j] = 1;
            }
        }

        for(int len = 3; len <= N; len++) {
            for(int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;
                if(arr[i] == arr[j] && dp[i+1][j-1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e]).append("\n");
        }

        System.out.print(sb);
    }
}