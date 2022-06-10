package baekjoon.fastcampus.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_1260 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int V;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for (int i = 1; i <=N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i <M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        //정렬
        for (int i = 1; i <=N; i++) {
            Collections.sort(list[i]);
        }

        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(V);

        System.out.println(sb);
    }

    static void dfs(int x) {
        visited[x] = true;
        sb.append(x).append(" ");
        for (int y : list[x]) {
            if (visited[y]) {
                continue;
            }
            dfs(y);
        }
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int x = que.poll();
            sb.append(start).append(" ");

            for (int y : list[x]) {
                if (visited[y]) {
                    continue;
                }

                que.add(y);
                visited[y] = true;
            }
        }
    }
}
