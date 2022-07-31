package baekjoon.fastcampus2.graphsearch;

import java.util.*;
import java.io.*;

public class S1_11403 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static ArrayList<Integer>[] list;
    static int[][] ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        ans = new int[N][N];

        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) {
                    list[i].add(j);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
            bfs(i);
            for(int j = 0; j < N; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(int X) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int i = 0; i < list[x].size(); i++) {
                int tx = list[x].get(i);
                if(visited[tx]) continue;
                queue.add(tx);
                visited[tx] = true;
                ans[X][tx] = 1;
            }
        }
    }
}
