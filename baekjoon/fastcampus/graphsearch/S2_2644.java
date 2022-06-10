package baekjoon.fastcampus.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_2644 {
    static int n;
    static int A,B;
    static int m;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        lists = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];
        dist = new int[n+1];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lists[x].add(y);
            lists[y].add(x);
        }
        bfs();
        System.out.println(dist[B]);
    }

    static void bfs () {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < dist.length; i++) {
            dist[i] = -1;
        }
        queue.add(A);
        visited[A] = true;
        dist[A] = 0;

        while (!queue.isEmpty()) {
            int tx = queue.poll();
            for (Integer nx : lists[tx]) {
                if (visited[nx]) continue;
                queue.add(nx);
                visited[nx] = true;
                dist[nx] = dist[tx] + 1;
            }
        }
    }
}
