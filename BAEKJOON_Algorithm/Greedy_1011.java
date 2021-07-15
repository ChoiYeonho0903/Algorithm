package BAEKJOON_Algorithm;

import java.util.Scanner;

public class Greedy_1011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int X,Y,distance;
        int [] ans = new int[T];
        int count;
        for (int i = 0; i <T; i++) {
            X = scanner.nextInt();
            Y = scanner.nextInt();
            distance = Y-X;
            int k=0;
            long sum=1;
            int plus=1;
            count=1;
            if(distance==1)
                ans[i] = 1;
            else {
                while (true) {
                    count++;
                    if(count%2!=0)
                        plus++;
                    sum+=plus;

                    if(distance<=sum)
                        break;
                }
            }
            ans[i] = count;
        }
        for (int i = 0; i <T; i++) {
            System.out.println(ans[i]);
        }
    }
}
