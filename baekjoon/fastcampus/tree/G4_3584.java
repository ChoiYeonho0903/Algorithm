package baekjoon.fastcampus.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G4_3584 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            lists = new ArrayList[N+1];
            visited = new boolean[N+1];
            for (int j = 1; j <= N; j++) {
                lists[j] = new ArrayList<>();
            }
            for (int j = 0; j < N-1; j++) {
                String str = br.readLine();
                st = new StringTokenizer(str, " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                lists[y].add(x);
            }
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            dfs(x1);
            dfs(x2);
        }
        System.out.print(sb);
    }

    static void dfs (int x) {
        if (visited[x]) {
            sb.append(x).append("\n");
            return;
        }
        visited[x] = true;
        if (lists[x].isEmpty()) return;
        int nx = lists[x].get(0);
        dfs(nx);
    }
}
