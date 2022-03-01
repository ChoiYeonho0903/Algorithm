package BAEKJOON_Algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G5_15681 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int R;
    static int Q;
    static ArrayList<Integer>[] lists;
    static int[] subTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N+1];
        subTree = new int[N+1];
        for (int i = 1; i <= N; i++) {
            subTree[i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lists[x].add(y);
            lists[y].add(x);
        }
        dfs(R, 0);
        for (int i = 0; i < Q; i++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(subTree[x]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs (int x, int parent) {
        if (lists[x].size()==1 && lists[x].get(0) == parent) {
            return;
        }
        for (int i = 0; i < lists[x].size(); i++) {
            int nx = lists[x].get(i);
            if (nx == parent) continue;
            dfs(nx, x);
            subTree[x] += subTree[nx];
        }
    }
}
