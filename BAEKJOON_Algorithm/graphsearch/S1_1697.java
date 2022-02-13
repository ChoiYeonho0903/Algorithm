package BAEKJOON_Algorithm.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_1697 {
    static int N;
    static int K;
    static boolean[] visited = new boolean[100001];
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs(N);
        System.out.println(ans);
    }

    static void bfs (int x) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x == K) {
                ans = point.count;
                break;
            }
            for (int i = 0; i <3; i++) {
                int nx = dir(i, point.x);
                if (nx<0 || nx>100000) continue;
                if (visited[nx]) continue;
                queue.add(new Point(nx, point.count+1));
                visited[nx] = true;
            }
        }
    }

    static int dir(int index, int x) {
        if (index == 0) {
            return x-1;
        } else if (index == 1) {
            return x+1;
        } else {
            return x*2;
        }
    }

    static class Point {
        int x;
        int count;

        public Point(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}
