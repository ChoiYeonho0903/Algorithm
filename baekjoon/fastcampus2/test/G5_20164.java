package baekjoon.fastcampus2.test;

import java.io.*;

public class G5_20164 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        recursion(isOdd(str), str);

        System.out.println(min + " " + max);
    }

    public static int isOdd(String str) {
        int cnt = 0;
        for(int i = 0; i < str.length(); i++) {
            int x = Integer.parseInt(str.substring(i, i+1));
            if(x % 2 == 1) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void recursion(int ans, String str) {
        int N = str.length();
        if(N >= 3) {
            for(int i = 1; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    int sum = 0;
                    int[] x = new int[3];
                    x[0] = Integer.parseInt(str.substring(0, i));
                    x[1] = Integer.parseInt(str.substring(i, j));
                    x[2] = Integer.parseInt(str.substring(j, N));
                    for(int y : x) {
                        sum += y;
                    }
                    recursion(isOdd(String.valueOf(sum)) + ans, String.valueOf(sum));
                }
            }
        } else if(N == 2) {
            int sum = 0;
            int[] x = new int[2];
            x[0] = Integer.parseInt(str.substring(0, 1));
            x[1] = Integer.parseInt(str.substring(1, 2));
            for(int y : x) {
                sum += y;
            }
            recursion(isOdd(String.valueOf(sum)) + ans, String.valueOf(sum));
        } else {
            max = Math.max(max, ans);
            min = Math.min(min, ans);
            return;
        }
    }
}