package baekjoon.etc.greedy;

import java.util.Scanner;

public class Greedy_1541 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String equation = scan.next();
        String [] minus = equation.split("-");
        String [] plus;
        int sum;
        int ans=0;
        for(int i=0; i<minus.length; i++) {
            plus = minus[i].split("\\+");
            sum =0;
            for(int j=0; j< plus.length; j++) {
                sum += Integer.valueOf(plus[j]);
            }
            if(i==0)
                ans += sum;
            else
                ans -= sum;
        }
        System.out.println(ans);
    }
}
