package BAEKJOON_Algorithm;

import java.util.Scanner;

public class Greedy_10775 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int G = scanner.nextInt();
        int P = scanner.nextInt();
        int [] gate = new int[G+1];
        int g;
        int ans = 0;
        for (int i = 1; i <=P; i++) {
            int j;
            g = scanner.nextInt();
            for (j = g; j >=1; j--) {
                if(gate[j]==0) {
                    gate[j] = i;
                    ans++;
                    break;
                }
            }
            if(j==0)
                break;
        }
        System.out.println(ans);
    }
}
