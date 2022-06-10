package baekjoon.etc.dp;

import java.util.Scanner;

public class DP_1932 {
    static int [][] num;
    static int [][] memo;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        num = new int[n][n];
        memo = new int[n][n];
        int max = 0;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <i+1; j++) {
                num[i][j] = scanner.nextInt();
            }
        }
        memo[0][0] = num[0][0];
        for (int i = 1; i <n; i++) {
            memo[i][0] = memo[i-1][0] + num[i][0];
            memo[i][i] = memo[i-1][i-1] + num[i][i];
            for (int j = 1; j <i; j++) {
                memo[i][j] = Math.max(memo[i-1][j-1], memo[i-1][j]) + num[i][j];
            }
        }
        for (int i = 0; i <n; i++) {
            if(max < memo[n-1][i]) {
                max = memo[n-1][i];
            }
        }
        System.out.println(max);
    }
}
