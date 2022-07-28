package baekjoon.fastcampus2.graphsearch;

import java.io.*;
import java.util.*;

public class S2_11724 {
    static int N;
    static int M;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                cnt++;
                bfs(i);
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int i = 0; i < list[x].size(); i++) {
                int tx = list[x].get(i);
                if(!visited[tx]) {
                    queue.add(tx);
                    visited[tx] = true;
                }
            }
        }
    }
}
