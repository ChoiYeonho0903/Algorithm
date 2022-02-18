package BAEKJOON_Algorithm.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_18404 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int X;
    static int Y;
    static int[][] A;
    static boolean[][] visited;
    static int ans;
    static int[][] dir = {{-2,-1}, {-2,1}, {-1,-2}, {-1,2}, {1,-2}, {1,2}, {2,-1}, {2,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        bfs();

        for (int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(A[x][y]).append(" ");
        }
        System.out.println(sb);
    }

    static void bfs () {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(X, Y, 0));
        visited[X][Y] = true;
        A[X][Y] = 0;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int tx = point.x;
            int ty = point.y;
            int count = point.count;

            for (int i = 0; i < dir.length; i++) {
                int nx = tx + dir[i][0];
                int ny = ty + dir[i][1];
                if (nx<=0 || ny<=0 || nx>N || ny>N) continue;
                if (visited[nx][ny]) continue;
                queue.add(new Point(nx, ny, count+1));
                visited[nx][ny] = true;
                A[nx][ny] = count+1;
            }
        }
    }

    static class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
