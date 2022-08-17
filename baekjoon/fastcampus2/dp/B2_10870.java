package baekjoon.fastcampus2.dp;

import java.io.*;

public class B2_10870 {
    static int N;
    static int[] memo = new int[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        memo[1] = 1;

        for(int i = 2; i <= 20; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        System.out.println(memo[N]);
    }
}
