package baekjoon.etc.dp;

import java.util.Scanner;

public class DP_1912 {
    static int [] num;
    static int [] memo;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        num = new int[n];
        memo = new int[n];
        int max = 0;
        for (int i = 0; i <n; i++) {
            num[i] = scanner.nextInt();
        }
        memo[0] = num[0];
        max = memo[0];
        for (int i = 1; i <n; i++) {
            memo[i] = Math.max(memo[i-1] + num[i], num[i]);
            if(max < memo[i])
                max = memo[i];
        }
        System.out.println(max);
    }
}
