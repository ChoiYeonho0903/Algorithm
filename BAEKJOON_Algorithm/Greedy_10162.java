package BAEKJOON_Algorithm;

import java.util.Scanner;

public class Greedy_10162 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int []set = {300, 60, 10};
        int []count = new int[3];
        for(int i=0; i<set.length; i++) {
            count[i] = T/set[i];
            T -= set[i]*count[i];
        }
        if(T!=0)
            System.out.println(-1);
        else {
            for(int i=0; i<set.length; i++) {
                System.out.print(count[i]+" ");
            }
            System.out.println("");
        }
    }
}
