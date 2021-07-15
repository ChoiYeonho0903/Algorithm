package BAEKJOON_Algorithm;

import java.util.Scanner;

public class Greedy_16953 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int count = 0;
        while(true) {
            if(B%2!=0 && (B-1)%10!=0) {
                count = -1;
                break;
            }
            else if(B%2==0) {
                B /= 2;
                count++;
            }
            else {
                B = (B-1)/10;
                count++;
            }

            if(A==B)
                break;
            if(A>B) {
                count = -1;
                break;
            }
        }
        if(count != -1)
            count++;
        System.out.println(count);
    }
}
