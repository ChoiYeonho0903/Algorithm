package baekjoon.fastcampus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15649 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] selected;
    static boolean used[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M+1];
        used = new boolean[N+1];
        rec_func(1);
        System.out.println(sb);
    }

    static void rec_func(int k) {
        if(k==M+1) {
            for (int i = 1; i <=M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <=N; i++) {
                if(!used[i]) {
                    selected[k] = i;
                    used[i] = true;
                    rec_func(k+1);
                    selected[k] = 0;
                    used[i] = false;
                }
            }
        }
    }
}
