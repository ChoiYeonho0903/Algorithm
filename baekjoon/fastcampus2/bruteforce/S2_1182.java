package baekjoon.fastcampus2.bruteforce;

import java.util.*;
import java.io.*;

public class S2_1182 {
    static int N;
    static int S;
    static int[] arr;
    static int[] selected;
    static int sum;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        selected = new int[N+1];

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        rec_func(1);
        System.out.print(ans);
    }

    static void rec_func(int depth) {
        for(int i = selected[depth-1]+1; i <= N; i++) {
            selected[depth] = i;
            sum += arr[i];
            if(sum == S) {
                ans++;
            }
            rec_func(depth+1);
            sum -= arr[i];
            selected[depth] = 0;
        }
    }
}
