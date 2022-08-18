package baekjoon.fastcampus2.dp;

import java.io.*;
import java.util.*;

public class S1_11057 {
    static int N;
    static int[][] memo = new int[1001][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ans = 0;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < 10; i++) {
            memo[1][i] = 1;
        }

        for(int i = 2; i <= 1000; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k <= j; k++) {
                    memo[i][j] += memo[i-1][k];
                }
                memo[i][j] %= 10_007;
            }
        }

        for(int i = 0; i < 10; i++) {
            ans += memo[N][i];
            ans %= 10_007;
        }

        System.out.println(ans);
    }
}
