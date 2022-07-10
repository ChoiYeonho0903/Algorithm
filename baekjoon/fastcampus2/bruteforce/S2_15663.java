package baekjoon.fastcampus2.bruteforce;

import java.util.*;
import java.io.*;

public class S2_15663 {
    static StringBuilder sb = new StringBuilder();
    static int M;
    static int N;
    static int[] arr;
    static int[] selected;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        used = new boolean[N+1];
        selected = new int[M+1];

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, 1, N+1);

        rec_func(1);
        System.out.print(sb);
    }

    static void rec_func(int depth) {
        if(depth == M+1) {
            for(int i = 1; i <= M; i++) {
                sb.append(arr[selected[i]]).append(" ");
            }
            sb.append("\n");
        } else {
            int lastSelected = 0;
            for(int i = 1; i <= N; i++) {
                if(used[i]) continue;
                if(lastSelected == arr[i]) continue;

                lastSelected = arr[i];
                used[i] = true;
                selected[depth] = i;
                rec_func(depth+1);
                used[i] = false;
                selected[depth] = 0;
            }
        }
    }
}
