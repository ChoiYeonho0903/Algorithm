package baekjoon.fastcampus.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class G4_4803 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = 0;
        while (true) {
            num++;
            String str = br.readLine();
            int count = 0;
            st = new StringTokenizer(str, " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;
            lists = new ArrayList[n+1];
            visited = new boolean[n+1];
            for (int i = 1; i <= n; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                str = br.readLine();
                st = new StringTokenizer(str, " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                lists[x].add(y);
                lists[y].add(x);
            }
            for (int i = 1; i <= n; i++) {
                if (visited[i]) continue;
                if (dfs(i, 0)) {
                    count++;
                }
            }
            sb.append("Case ").append(num).append(": ");

            if (count == 0) sb.append("No trees.\n");
            else if (count == 1) sb.append("There is one tree.\n");
            else sb.append("A forest of ").append(count).append(" trees.\n");
        }
        System.out.print(sb);
    }

    static boolean dfs (int x, int parent) {
        visited[x] = true;
        boolean tf = true;
        for (int i = 0; i < lists[x].size(); i++) {
            int nx = lists[x].get(i);
            if (nx == parent) continue;
            if (visited[nx]) {
                return false;
            }
            tf &= dfs(nx, x);
        }
        return tf;
    }
}
