package baekjoon.fastcampus.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_11403 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static int[][] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        lists = new ArrayList[N];
        ans = new int[N][N];
        for (int i = 0; i < N; i++) {
            lists[i]= new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    lists[i].add(j);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            bfs(i);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void bfs (int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while (!queue.isEmpty()) {
            int tx = queue.poll();
            for (int i = 0; i < lists[tx].size(); i++) {
                int nx = lists[tx].get(i);
                if (visited[nx]) continue;
                queue.add(nx);
                visited[nx] = true;
                ans[x][nx] = 1;
            }
        }
    }
}
