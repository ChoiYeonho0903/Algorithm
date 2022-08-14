package baekjoon.fastcampus2.shortestpath;

import java.util.*;
import java.io.*;

public class G5_1916 {
    static int N;
    static int M;
    static int[] dist;
    static ArrayList<Edge>[] edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N+1];
        edge = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            edge[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edge[from].add(new Edge(to, weight));
        }

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);

    }

    static void dijkstra(int start) {
        // 모든 정점까지에 대한 거리를 무한대로 초기화 하기
        for(int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 최소 힙 생성
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        // 시작점에 대한 정보(Information)을 기록에 추가하고, 거리 배열(dist)에 갱신해준다.
        pq.add(new Info(start, 0));
        dist[start] = 0;

        // 거리 정보들이 모두 소진될 때까지 거리 생신을 반복한다.
        while(!pq.isEmpty()) {
            Info info = pq.poll();

            if(dist[info.idx] < info.dist) continue;

            // 연결된 모든 간선들을 통해서 다른 정점들에 대한 정보를 갱신해준다.
            for(Edge e : edge[info.idx]) {
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;

                // e.to 까지 갈 수 있는 더 짧은 거리를 찾았다면 이에 대한 정보를 갱신하고 PQ에 기록해둔다.
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
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