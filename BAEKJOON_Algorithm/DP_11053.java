package BAEKJOON_Algorithm;

import java.util.Scanner;

public class DP_11053 {
    static int [] num;
    static int [] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        num = new int[N];
        dp = new int[N];
        int ans = 1;
        for (int i = 0; i <N; i++) {
            num[i] = scanner.nextInt();
        }
        dp[0] = 1;
        for (int i = 1; i <N; i++) {
            int max = 0;
            for (int j = 0; j <i; j++) {
                if(num[i]>num[j]) {
                    if(max < dp[j]) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max+1;
            if(ans < dp[i])
                ans = dp[i];
        }
        System.out.println(ans);
    }
}
