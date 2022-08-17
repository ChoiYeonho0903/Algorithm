package baekjoon.fastcampus2.dp;

import java.io.*;

public class S2_15988 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int N;
    static int[] memo = new int[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;

        for(int i = 4; i <= 1_000_000; i++) {
            memo[i] = (memo[i-1] + memo[i-2]) % 1_000_000_009 + memo[i-3];
            memo[i] %= 1_000_000_009;
        }

        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            sb.append(memo[N]).append("\n");
        }

        System.out.print(sb);
    }
}