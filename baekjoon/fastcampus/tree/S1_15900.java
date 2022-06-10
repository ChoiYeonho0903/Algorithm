package baekjoon.fastcampus.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1_15900 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static ArrayList<Integer>[] lists;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        lists = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lists[x].add(y);
            lists[y].add(x);
        }
        dfs(1, 0, 0);
        if (sum%2 == 1) sb.append("Yes");
        else sb.append("No");
        System.out.println(sb);
    }

    static void dfs (int x, int parent, int depth) {
        int size = lists[x].size();
        if (size == 1 && lists[x].get(0) == parent) {
            sum += depth;
        }
        for (int i = 0; i < lists[x].size(); i++) {
            int nx = lists[x].get(i);
            if (nx == parent) continue;
            dfs(nx, x, depth+1);
        }
    }
}
