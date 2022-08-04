package baekjoon.fastcampus2.tree;

import java.util.*;
import java.io.*;

public class S2_20364 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int Q;
    static int[] parent;
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();

        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        visited = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            int x = i / 2;
            parent[i] = x;
        }

        for(int i = 0; i < Q; i++) {
            int x = Integer.parseInt(br.readLine());
            ans = 0;
            dfs(x);
            if(ans == 0) {
                visited[x] = true;
            }
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int x) {
        if(visited[x]) {
            ans = x;
        }
        if(x == 0) {
            return;
        }

        int y = parent[x];
        dfs(parent[x]);
    }
}
