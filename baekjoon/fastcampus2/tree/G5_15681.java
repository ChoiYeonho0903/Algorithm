package baekjoon.fastcampus2.tree;

import java.util.*;
import java.io.*;

public class G5_15681 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int R;
    static int Q;
    static ArrayList<Integer>[] list;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        ans = new int[N+1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++) {
            ans[i] = 1;
        }

        for(int i = 1; i < N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        dfs(R, -1);

        for(int i = 0; i < Q; i++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(ans[x]).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int x, int parent) {
        if(list[x].size() == 1 && list[x].get(0) == parent) {
            return;
        }

        for(int y : list[x]) {
            if(y == parent) continue;
            dfs(y, x);
            ans[x] += ans[y];
        }

    }
}
