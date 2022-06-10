package baekjoon.etc.greedy;

import java.util.Scanner;

public class Greedy_2810 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;
        int cupholder;
        String str = scanner.next();
        for (int i = 0; i <N; i++) {
            if(str.charAt(i)=='L')
                count++;
        }
        count /= 2;
        cupholder = N+1-count;
        if(cupholder>=N)
            System.out.println(N);
        else
            System.out.println(cupholder);
    }
}
