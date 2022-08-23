package baekjoon.fastcampus2.dp;

import java.util.*;
import java.io.*;

public class G5_2096 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] A;
    static int[][] dpMax;
    static int[][] dpMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N+1][3];
        dpMax = new int[N+1][3];
        dpMin = new int[N+1][3];

        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dpMax[1][0] = A[1][0];
        dpMax[1][1] = A[1][1];
        dpMax[1][2] = A[1][2];
        dpMin[1][0] = A[1][0];
        dpMin[1][1] = A[1][1];
        dpMin[1][2] = A[1][2];

        for(int i = 2; i <= N; i++) {
            dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]) + A[i][0];
            dpMax[i][1] = Math.max(dpMax[i-1][2], Math.max(dpMax[i-1][0], dpMax[i-1][1])) + A[i][1];
            dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + A[i][2];

            dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]) + A[i][0];
            dpMin[i][1] = Math.min(dpMin[i-1][2], Math.min(dpMin[i-1][0], dpMin[i-1][1])) + A[i][1];
            dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + A[i][2];
        }

        int min = dpMin[N][0];
        int max = dpMax[N][0];

        for(int i = 1; i < 3; i++) {
            min = Math.min(min, dpMin[N][i]);
            max = Math.max(max, dpMax[N][i]);
        }

        sb.append(max).append(" ").append(min);
        System.out.println(sb);
    }
}