package baekjoon.etc.dp;

import java.util.Scanner;

public class DP_1463 {
    static int N;
    static int [] memo = new int[1000001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        memo[1] = 0;
        for (int i = 2; i <=N; i++) {
            memo[i] = 1000001;
        }
        for (int i = 2; i <=N; i++) {
            if(i%3==0) {
                memo[i] = Math.min(memo[i], memo[i / 3]+1);
            }
            if(i%2==0) {
                memo[i] = Math.min(memo[i], memo[i / 2]+1);
            }

            memo[i] = Math.min(memo[i], memo[i - 1]+1);
        }
        System.out.println(memo[N]);
    }
}
