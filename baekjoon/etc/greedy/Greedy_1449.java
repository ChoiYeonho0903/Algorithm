package baekjoon.etc.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_1449 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int L = scanner.nextInt();
        int link=0;
        int count=0;
        int [] leak = new int[N];
        for (int i = 0; i <leak.length; i++) {
            leak[i] = scanner.nextInt();
        }
        Arrays.sort(leak);
        link = leak[0];
        count++;
        for (int i = 1; i <leak.length ; i++) {
            if(link+(L-1) >= leak[i])
                continue;
            else {
                count++;
                link = leak[i];
            }
        }
        System.out.println(count);
    }
}
