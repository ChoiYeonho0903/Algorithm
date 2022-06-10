package baekjoon.fastcampus.shortestpath;

import java.util.*;
import java.io.*;

public class G5_1753 {
    static StringBuilder sb = new StringBuilder();
    static int V;
    static int E;
    static int start;
    static int[] dist;
    static ArrayList<Edge>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        lists = new ArrayList[V+1];
        dist = new int[V+1];
        for(int i = 1; i <= V; i++) {
            lists[i] = new ArrayList<>();
        }
        start = Integer.parseInt(br.readLine());
        for(int i = 0; i < E; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            lists[u].add(new Edge(v, w));
        }

        dijkstra(start);
        for(int i = 1; i <= V; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(dist[i]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void dijkstra(int start) {
        // 모든 정점까지에 대한 거리를 무한대로 초기화 해주기.
        for(int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 최소 힙 생성
        PriorityQueue<Info> queue = new PriorityQueue<>(Comparator.comparing(o -> o.dist));

        // 시작점에 대한 정보을 기록에 추가하고, 거리 배열(dist)에 갱신해준다.
        queue.add(new Info(start, 0));
        dist[start] = 0;

        // 거리 정보들이 모두 소진될 때가지 거리 갱신을 반복한다.
        while(!queue.isEmpty()) {
            Info info = queue.poll();

            // 꺼낸 정보가 최신 정보라 다르면, 의미없이 낡은 정보이므로 폐기한다.
            if(info.dist > dist[info.idx]) continue;

            // 연결된 모든 간선들을 통해서 다른 정점들에 대한 정보를 갱신해준다.
            for(Edge e : lists[info.idx]) {
                if (dist[info.idx] + e.weight >= dist[e.to]) continue;

                // e.to 까지 갈 수 있는 더 짧은 거리를 찾았다면 이에 대한 정보를 갱신하고 queue에 기록한다.
                dist[e.to] = dist[info.idx] + e.weight;
                queue.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    static class Edge {
        public int to;
        public int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        public int idx;
        public int dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}
