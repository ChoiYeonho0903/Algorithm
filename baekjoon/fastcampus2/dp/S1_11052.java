package baekjoon.fastcampus2.dp;

import java.io.*;
import java.util.*;

public class S1_11052 {
    static int N;
    static int[] P;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        P = new int[301];
        memo = new int[301];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        memo[1] = P[1];

        for(int i = 2; i <= N; i++) {
            int max = P[i];
            for(int j = 1; j <= i/2; j++) {
                max = Math.max(memo[i-j]+memo[j], max);
            }
            memo[i] = max;
        }

        System.out.println(memo[N]);
    }
}
