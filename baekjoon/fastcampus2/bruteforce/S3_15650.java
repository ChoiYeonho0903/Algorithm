package baekjoon.fastcampus2.bruteforce;

import java.util.*;
import java.io.*;

public class S3_15650 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M+1];
        selected[0] = 0;

        rec_func(1);
        System.out.print(sb);

    }

    static void rec_func(int depth) {
        if(depth == M+1) {
            for(int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for(int i = selected[depth-1]+1; i <= N; i++) {
                selected[depth] = i;
                rec_func(depth+1);
                selected[depth] = 0;
            }
        }
    }
}
