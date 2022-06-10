package baekjoon.fastcampus.bruteforce.level1;

import java.io.*;

public class B2_2231 {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
            int num = i;
            int sum = num;
            while(num > 0) {
                sum += (num % 10);
                num = num / 10;
            }
            if(sum == N) {
                M = i;
                break;
            }
        }
        System.out.println(M);
    }
}
