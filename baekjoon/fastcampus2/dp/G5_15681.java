package baekjoon.fastcampus2.dp;

import java.util.*;
import java.io.*;

public class G5_15681 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int R;
    static int Q;
    static ArrayList<Integer>[] list;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        dp = new int[N+1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            dp[i] = 1;
        }

        for(int i = 0; i < N-1; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        dfs(R, 0);

        for(int i = 0; i < Q; i++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(dp[x]).append("\n");
        }

        System.out.print(sb);

    }

    static void dfs(int x, int parent) {
        for(int y : list[x]) {
            if(y == parent) continue;
            dfs(y, x);
            dp[x] += dp[y];
        }
    }
}