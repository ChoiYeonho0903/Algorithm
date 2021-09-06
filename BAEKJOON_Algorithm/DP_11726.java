package BAEKJOON_Algorithm;

import java.util.Scanner;

public class DP_11726 {
    static int n;
    static int [] dp = new int[1001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}
