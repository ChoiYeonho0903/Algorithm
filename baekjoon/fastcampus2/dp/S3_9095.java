package baekjoon.fastcampus2.dp;

import java.util.*;
import java.io.*;

public class S3_9095 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int n;
    static int[] memo = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        memo[1] = 1;
        memo[2] = 2 ;
        memo[3] = 4;
        for(int i = 4; i < 11; i++) {
            memo[i] = memo[i-3] + memo[i-2] + memo[i-1];
        }
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            sb.append(memo[n]).append("\n");
        }

        System.out.print(sb);
    }
}