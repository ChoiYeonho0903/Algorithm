package baekjoon.fastcampus2.dp;

import java.io.*;

public class S3_1003 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int N;
    static int[][] memo = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        memo[0][0] = 1;
        memo[1][1] = 1;
        for(int i = 2; i <= 40; i++) {
            memo[i][0] = memo[i-1][0] + memo[i-2][0];
            memo[i][1] = memo[i-1][1] + memo[i-2][1];
        }

        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            sb.append(memo[N][0]).append(" ").append(memo[N][1]).append("\n");
        }

        System.out.print(sb);
    }
}