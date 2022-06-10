package baekjoon.fastcampus.bruteforce.level1;

import java.util.*;
import java.io.*;

public class B2_2309 {
    static StringBuilder sb = new StringBuilder();
    static int[] A = new int[9+1];
    static int[] idx = new int[7+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 1; i <= 9; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);
        dfs(0 , 0);
        System.out.print(sb);
    }

    static void dfs (int depth, int sum) {
        if(depth == 7) {
            if (sum == 100 && sb.length() == 0) {
                for(int i = 1; i <= 7; i++) {
                    sb.append(A[idx[i]]).append("\n");
                }
            }
        } else {
            for(int i = idx[depth]+1; i <= 9; i++) {
                idx[depth+1] = i;
                dfs(depth+1, sum + A[i]);
            }
        }
    }
}
