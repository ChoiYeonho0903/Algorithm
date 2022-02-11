package BAEKJOON_Algorithm.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_2178 {
    static int N;
    static int M;
    static int[][] A;
    static boolean[][] visited;
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for (int i = 1; i <=N; i++) {
            str = br.readLine();
            for (int j = 1; j <=M; j++) {
                A[i][j] = str.charAt(j-1)-'0';
            }
        }
        bfs();
        System.out.println(ans);
    }

    static void bfs () {
        Queue<Maze> queue = new LinkedList<>();
        queue.add(new Maze(1, 1, 1));
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            Maze maze = queue.poll();
            int x = maze.x;
            int y = maze.y;
            int count = maze.count;
            if (x==N && y==M) ans = count;
            for (int i = 0; i <dir.length; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx<1 || ny<1 || nx>N || ny>M) continue;
                if (visited[nx][ny]) continue;
                if (A[nx][ny] == 1) {
                    queue.add(new Maze(nx, ny, count+1));
                    visited[nx][ny] = true;
                }
            }
        }

    }

    static class Maze {
        int x;
        int y;
        int count;

        public Maze(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
