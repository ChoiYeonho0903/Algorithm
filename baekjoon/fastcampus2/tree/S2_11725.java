package baekjoon.fastcampus2.tree;

import java.util.*;
import java.io.*;

public class S2_11725 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        ans = new int[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        dfs(1);
        for(int i = 2; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }

        System.out.print(sb);

    }

    static void dfs(int x) {
        visited[x] = true;
        for(int i = 0; i < list[x].size(); i++) {
            int tx = list[x].get(i);
            if(visited[tx]) continue;
            ans[tx] = x;
            dfs(tx);
        }
    }
}
