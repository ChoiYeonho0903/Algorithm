package baekjoon.fastcampus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15650 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M+1];
        visited = new boolean[N+1];
        selected[0] = 0;
        rec_func(1);
        System.out.println(sb);
    }

    static void rec_func(int k) {
        if(k == M+1) {
            for (int i = 1; i <=M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = selected[k-1]+1; i <=N; i++) {
                selected[k] = i;
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }
}
