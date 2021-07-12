package BAEKJOON_Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_2437 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N= scanner.nextInt();
        int [] weight = new int[N];
        int ans=0;
        for (int i = 0; i <N; i++) {
            weight[i] = scanner.nextInt();
        }
        Arrays.sort(weight);
        for (int i = 0; i < weight.length; i++) {
            if(ans+1 < weight[i])
                break;
            else
                ans += weight[i];
        }
        System.out.println(ans+1);
    }
}
