package baekjoon.fastcampus2.dp;

import java.util.*;
import java.io.*;

public class G1_1562 {
    static int N;
    static final int MOD = 1_000_000_000;
    static int[][][][] dp = new int[101][10][10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i < 10; i++) {
            dp[1][i][i][i] = 1;
        }

        for(int i = 2; i <= 100; i++) {
            for(int prev = 0; prev < 10; prev++) {
                for(int low = 0; low < 10; low++) {
                    for(int high = 0; high < 10; high++) {
                        if(prev-1 >= 0) {
                            dp[i][prev][Math.min(low, prev-1)][Math.max(high, prev-1)] += dp[i-1][prev][low][high];
                            dp[i][prev][Math.min(low, prev-1)][Math.max(high, prev-1)] %= MOD;
                        }
                        if(prev+1 <= 9) {
                            dp[i][prev][Math.min(low, prev+1)][Math.max(high, prev-1)] += dp[i-1][prev][low][high];
                            dp[i][prev][Math.min(low, prev+1)][Math.max(high, prev-1)] %= MOD;
                        }
                    }
                }

            }
        }
    }
}
