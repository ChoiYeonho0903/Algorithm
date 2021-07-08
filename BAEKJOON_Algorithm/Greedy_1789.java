package BAEKJOON_Algorithm;

import java.util.Scanner;

public class Greedy_1789 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long S = scan.nextLong();
        long num = 1;
        long count = 0;
        while(S>0) {
            if(S-num>=0) {
                S -= num;
                count ++;
                num++;
            }
            else {
                break;
            }
        }
        System.out.println(count);
    }
}
