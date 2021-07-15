package BAEKJOON_Algorithm;

import java.util.Scanner;

public class Greedy_2847 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int [] score = new int[N];
        int ans = 0;
        for (int i = 0; i <score.length; i++) {
            score[i] = scanner.nextInt();
        }
        for (int i = score.length-1; i >0; i--) {
            if(score[i]<=score[i-1]) {
                ans +=(score[i-1]-(score[i]-1));
                score[i-1] = (score[i]-1);
            }
        }
        System.out.println(ans);
    }
}
