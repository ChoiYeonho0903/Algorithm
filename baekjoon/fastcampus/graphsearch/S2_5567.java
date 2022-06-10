package baekjoon.fastcampus.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_5567 {
    static int n;
    static int m;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        lists = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lists[x].add(y);
            lists[y].add(x);
        }
        bfs(1);
        System.out.println(ans);
    }

    static void dfs (int x, int depth) {
        if (depth>=2) return;
        visited[x] = true;
        for (int i = 0; i < lists[x].size(); i++) {
            int nx = lists[x].get(i);
            if (visited[nx]) continue;
            ans++;
            dfs(nx, depth+1);
        }
    }

    static void bfs (int x) {
        Queue<Classmate> queue = new LinkedList<>();
        queue.add(new Classmate(x, 0));
        visited[x] = true;

        while(!queue.isEmpty()) {
            ans++;
            Classmate classmate = queue.poll();
            int tx = classmate.x;
            int count = classmate.count;
            for (int i = 0; i < lists[tx].size(); i++) {
                int nx = lists[tx].get(i);
                if (visited[nx]) continue;
                if (count+1>=3) continue;
                queue.add(new Classmate(nx, count+1));
                visited[nx] = true;
            }
        }
    }

    static class Classmate {
        int x;
        int count;

        public Classmate(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}
