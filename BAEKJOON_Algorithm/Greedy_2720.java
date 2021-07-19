package BAEKJOON_Algorithm;

import java.util.Scanner;

public class Greedy_2720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T= scanner.nextInt();
        int [] change = new int[T];
        int [] money = {25, 10, 5, 1};
        int [][] count = new int[T][4];
        for (int i = 0; i <change.length; i++) {
            change[i] = scanner.nextInt();
        }
        for (int i = 0; i <change.length; i++) {
            for (int j = 0; j < money.length ; j++) {
                if(change[i]>=money[j]) {
                    count[i][j] = (change[i]/money[j]);
                    change[i] %= money[j];
                }
            }
        }
        for (int i = 0; i <T ; i++) {
            for (int j = 0; j <money.length ; j++) {
                System.out.print(count[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
