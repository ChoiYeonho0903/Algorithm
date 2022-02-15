package BAEKJOON_Algorithm.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S2_11724 {
    static int N;
    static int M;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lists[x].add(y);
            lists[y].add(x);
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                ans++;
            }
        }
        System.out.println(ans);
    }

    static void dfs (int x) {
        visited[x] = true;
        for (int i = 0; i < lists[x].size(); i++) {
            int y = lists[x].get(i);
            if (visited[y]) continue;
            dfs(y);
        }
    }
}
