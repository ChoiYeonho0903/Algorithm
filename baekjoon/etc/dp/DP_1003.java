package baekjoon.etc.dp;

import java.util.ArrayList;
import java.util.Scanner;

public class DP_1003 {
    static int T;
    static int [][] memo = new int[41][2];
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        int max = 0;
        for (int i = 0; i <T; i++) {
            int td = scanner.nextInt();
            if(max < td)
                max = td;
            arrayList.add(td);
        }
        memo[0][0] = 1;
        memo[1][1] = 1;
        for (int i = 2; i <=max; i++) {
            memo[i][0] = memo[i-1][0] + memo[i-2][0];
            memo[i][1] = memo[i-1][1] + memo[i-2][1];
        }
        for (int i = 0; i <T; i++) {
            System.out.println(memo[arrayList.get(i)][0] + " " + memo[arrayList.get(i)][1]);
        }
    }
}
