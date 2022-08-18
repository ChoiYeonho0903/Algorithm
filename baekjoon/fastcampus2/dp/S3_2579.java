package baekjoon.fastcampus2.dp;

import java.io.*;
import java.util.*;

public class S3_2579 {
    static int N;
    static int[] stair;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        stair = new int[N+1];
        memo = new int[N+1][2];

        for(int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        memo[1][0] = stair[1];
        memo[2][0] = stair[1] + stair[2];
        memo[2][1] = stair[2];

        for(int i = 3; i <= N; i++) {
            memo[i][0] = memo[i-1][1]+stair[i];
            memo[i][1] = Math.max(memo[i-2][0], memo[i-2][1]) + stair[i];
        }

        int ans = Math.max(memo[N][0], memo[N][1]);
        System.out.println(ans);
    }
}