package BAEKJOON_Algorithm;

import java.util.Scanner;

public class DP_9095 {
    static int [] memo = new int[11];
    static int [] n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        n = new int[T];
        int max = 0;
        for (int i = 0; i <T; i++) {
            n[i] = scanner.nextInt();
            if(max < n[i])
                max = n[i];
        }
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;
        for (int i = 4; i <=max; i++) {
            memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
        }
        for (int i = 0; i <n.length; i++) {
            System.out.println(memo[n[i]]);
        }
    }
}
