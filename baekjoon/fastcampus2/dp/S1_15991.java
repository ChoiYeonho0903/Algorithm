package baekjoon.fastcampus2.dp;

import java.io.*;

public class S1_15991 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int N;
    static int[] memo = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 2;
        memo[4] = 3;
        memo[5] = 3;
        memo[6] = 6;
        for(int i = 7; i <= 100_000; i++) {
            memo[i] = (memo[i-2] + memo[i-4]) % 1_000_000_009 + memo[i-6];
            memo[i] %= 1_000_000_009;
        }

        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            sb.append(memo[N]).append("\n");
        }

        System.out.print(sb);
    }
}