package BAEKJOON_Algorithm.input_output;

import java.util.Scanner;

public class B3_10950 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] ans = new int[T];
        for (int i = 0; i <T; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            ans[i] = A+B;
        }
        for (int i = 0; i <T; i++) {
            System.out.println(ans[i]);
        }
    }
}
