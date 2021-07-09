package BAEKJOON_Algorithm;

import java.util.Scanner;

public class Greedy_1439 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        char pre;
        char cur;
        int ans=0;
        int count=0;
        for (int i = 1; i <str.length(); i++) {
            pre = str.charAt(i-1);
            cur = str.charAt(i);
            if(pre != cur) {
                count++;
            }
        }
        ans = (count/2) + (count%2);
        System.out.println(ans);
    }
}
