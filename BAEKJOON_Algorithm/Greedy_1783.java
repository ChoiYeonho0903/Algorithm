package BAEKJOON_Algorithm;

import java.util.Scanner;

public class Greedy_1783 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Y = scanner.nextInt();
        int X = scanner.nextInt();
        int ans =0;
        if (Y==1)
            ans = 1;
        else if(Y==2) {
            if (X >= 7)
                ans = 4;
            else
                ans = (X + 1) / 2;
        }
        else if(X<=4)
            ans = X;
        else if(X<7)
            ans = 4;
        else
            ans = X - 7 + 5;

        System.out.println(ans);
    }
}
