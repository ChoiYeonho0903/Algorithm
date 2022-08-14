package baekjoon.fastcampus2.shortestpath;

import java.util.*;
import java.io.*;

public class G4_1753 {
    static StringBuilder sb = new StringBuilder();
    static int V;
    static int E;
    static ArrayList<Edge>[] edge;
    static int[] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edge = new ArrayList[V+1];
        dist = new int[V+1];
        for(int i = 1; i <= V; i++) {
            edge[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());

        for(int i = 0; i < E; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edge[from].add(new Edge(to, weight));
        }

        dijkstra(start);

        for(int i = 1; i <= V; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);

    }

    static void dijkstra(int start) {
        for(int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        queue.add(new Info(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()) {
            Info info = queue.poll();
            if(dist[info.idx] < info.dist) continue;

            for(Edge e : edge[info.idx]) {
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;
                dist[e.to] = dist[info.idx] + e.weight;
                queue.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        int idx;
        int dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}
