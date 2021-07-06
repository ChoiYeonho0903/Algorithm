package BAEKJOON_Algorithm;

import java.util.Scanner;

public class Greedy_1946 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int [] ans = new int[T];
        for (int i = 0; i <T; i++) {
            int N = scan.nextInt();
            int [] score = new int[N];
            for (int j = 0; j <N; j++) {
                score[scan.nextInt()-1] = scan.nextInt();
            }
            int limit = score[0];
            for (int j = 1; j <N; j++) {
                if(score[j]<limit) {
                    ans[i]++;
                    limit = score[j];
                }
            }
        }
        for (int i = 0; i <T; i++) {
            System.out.println(ans[i]+1);
        }
    }
}
