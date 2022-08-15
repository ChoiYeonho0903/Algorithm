package baekjoon.fastcampus2.dp;

import java.util.*;
import java.io.*;

public class S3_11726 {
    static int n;
    static int[] memo = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        memo[1] = 1;
        memo[2] = 2;
        for(int i = 3; i <= 1000; i++) {
            memo[i] = (memo[i-1] + memo[i-2]) % 10_007;
        }

        System.out.println(memo[n]);
    }
}