package BAEKJOON_Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_2217 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int [] rope = new int[N];
        int max =0;
        for(int i=0; i<N; i++) {
            rope[i] = scan.nextInt();
        }
        Arrays.sort(rope);
        for(int i=0; i<N; i++) {
            if(rope[i]*(N-i) > max)
                max = rope[i]*(N-i);
        }
        System.out.println(max);
    }
}
