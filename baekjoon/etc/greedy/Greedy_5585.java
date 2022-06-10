package baekjoon.etc.greedy;

import java.util.Scanner;

public class Greedy_5585 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        int change = 1000-M;
        int [] C = {500, 100, 50, 10, 5, 1};
        int count=0;
        for(int i=0; i<C.length; i++) {
            while(true) {
                if(change-C[i] >= 0) {
                    change -= C[i];
                    count++;
                }
                else
                    break;
            }
        }
        System.out.println(count);
    }
}
