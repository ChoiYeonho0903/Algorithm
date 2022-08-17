package baekjoon.fastcampus2.dp;

import java.io.*;
import java.util.*;

public class G5_2011 {
    static int N;
    static String str;
    static int memo[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        str = br.readLine();
        N = str.length();

        memo = new int[N];

        if(str.charAt(0) != '0') {
            memo[0] = 1;
        } else {
            System.out.println(0);
            return;
        }

        for(int i = 1; i < N; i++) {
            if(str.charAt(i) != '0') {
                memo[i] = memo[i-1];
            }

            if (check(str.charAt(i-1), str.charAt(i))) {
                if(i >= 2) {
                    memo[i] += memo[i-2];
                } else {
                    memo[i] += 1;
                }
                memo[i] %= 1_000_000;
            }
        }

        System.out.println(memo[N-1]);
    }

    static boolean check(char A, char B) {
        if (A == '0') return false;
        if (A == '1') return true;
        if (A >= '3') return false;
        return B <= '6';
    }
}