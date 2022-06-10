package baekjoon.etc.string;

import java.util.Scanner;

public class STRING_11720 {
    static int N;
    static String str;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        str = scanner.next();
        int ans = 0;
        for (int i = 0; i <str.length(); i++) {
            ans += str.charAt(i) - '0';
        }
        System.out.println(ans);
    }
}
