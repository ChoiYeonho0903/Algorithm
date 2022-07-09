package baekjoon.fastcampus2.bruteforce;

import java.io.*;
import java.util.*;

public class S1_14888 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] A;
    static int[] operator = new int[4];
    static int[] selected;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        selected = new int[N];
        rec_func(1);
        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }

    static void rec_func(int depth) {
        if(depth == N) {
            int result = A[1];
            for(int i = 1; i < N; i++) {
                switch(selected[i]) {
                    case 0:
                        result += A[i+1];
                        break;
                    case 1:
                        result -= A[i+1];
                        break;
                    case 2:
                        result *= A[i+1];
                        break;
                    case 3:
                        result /= A[i+1];
                        break;
                }
            }
            if(max < result) {
                max = result;
            }
            if(min > result) {
                min = result;
            }
        } else {
            for(int i = 0; i < 4; i++) {
                if(operator[i] > 0) {
                    operator[i]--;
                    selected[depth] = i;
                    rec_func(depth+1);
                    selected[depth] = 0;
                    operator[i]++;
                }
            }
        }
    }
}
