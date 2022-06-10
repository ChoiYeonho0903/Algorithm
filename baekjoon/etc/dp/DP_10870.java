package baekjoon.etc.dp;

import java.util.Scanner;

public class DP_10870 {
    static int n;
    static int [] Fn = new int[21];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        Fn[0] = 0;
        Fn[1] = 1;
        for (int i = 2; i <=n; i++) {
            Fn[i] = Fn[i-1] + Fn[i-2];
        }
        System.out.println(Fn[n]);
    }
}
