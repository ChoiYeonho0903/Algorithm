package BAEKJOON_Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_11399 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int min = 0;
        int N = scan.nextInt();
        int [] P = new int[N];
        for(int i=0; i<N; i++) {
            P[i] = scan.nextInt();
        }
        Arrays.sort(P);
        for (int i=0; i<N; i++) {
            for(int j=0; j<=i; j++) {
                min += P[j];
            }
        }
        System.out.println(min);
    }
}
