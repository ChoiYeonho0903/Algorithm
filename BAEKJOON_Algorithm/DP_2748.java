package BAEKJOON_Algorithm;

import java.util.Scanner;

public class DP_2748 {
    static int n;
    static long [] Fn = new long[91];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println(fibo(n));
    }

    private static long fibo(int x) {
        if(x==0)
            return 0;
        else if(x==1)
            return 1;
        else if(Fn[x] != 0)
            return Fn[x];
        else {
            Fn[x] = fibo(x-1) + fibo(x-2);
            return Fn[x];
        }
    }
}
