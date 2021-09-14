package BAEKJOON_Algorithm;

import java.util.Scanner;

public class DP_2579 {
    static int [] stair;
    static int [][] memo;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;
        stair = new int[n];
        memo = new int[n][2];
        for (int i = 0; i <n; i++) {
            stair[i] = scanner.nextInt();
        }
        if(n>2) {
            memo[0][0] = stair[0];
            memo[0][1] = 0;
            memo[1][0] = stair[1];
            memo[1][1] = stair[0] + stair[1];
            for (int i = 2; i < n; i++) {
                memo[i][0] = Math.max(memo[i - 2][0], memo[i - 2][1]) + stair[i];
                memo[i][1] = memo[i - 1][0] + stair[i];
            }
            answer = Math.max(memo[n-1][0], memo[n-1][1]);
        }
        else if(n == 2){
            answer = stair[0] + stair[1];
        }
        else
            answer = stair[0];

        System.out.println(answer);
    }
}
