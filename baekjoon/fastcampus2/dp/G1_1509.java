package baekjoon.fastcampus2.dp;

import java.io.*;
import java.util.*;

public class G1_1509 {
    static int N;
    static String[] arr;
    static int[][] dp;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        N = str.length();
        arr = new String[N+1];
        dp = new int[N+1][N+1];
        memo = new int[N+1];
        for(int i = 0; i < N; i++) {
            arr[i+1] = str.substring(i, i+1);
        }

        for(int i = 1; i <= N; i++) {
            dp[i][i] = 1;
        }
        for(int i = 1; i < N; i++) {
            if(arr[i].equals(arr[i+1])) {
                dp[i][i+1] = 1;
            }
        }
        for(int len = 3; len <= N; len++) {
            for(int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;
                if(arr[i].equals(arr[j]) && dp[i+1][j-1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            memo[i] = Integer.MAX_VALUE;
            for(int j = 1; j <= i; j++) {
                if(dp[j][i] == 1) {
                    memo[i] = Math.min(memo[i], memo[j-1] + 1);
                }
            }
        }

        System.out.println(memo[N]);
    }
}