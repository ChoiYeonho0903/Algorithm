package baekjoon.fastcampus2.graphsearch;

import java.util.*;
import java.io.*;

public class S1_2178 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            str = br.readLine();
            for(int j = 1; j <= M; j++) {
                arr[i][j] = str.charAt(j-1) - '0';
            }
        }

        bfs();

        System.out.println(ans);
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1, 1));
        visited[1][1] = true;

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for(int i = 0; i < 4; i++) {
                int ty = point.y + dy[i];
                int tx = point.x + dx[i];
                if(ty <= 0 || tx <= 0 || ty > N || tx > M) continue;
                if(!visited[ty][tx] && arr[ty][tx] == 1) {
                    queue.add(new Point(ty, tx, point.cnt+1));
                    visited[ty][tx] = true;
                    if(ty == N && tx == M) {
                        ans = point.cnt+1;
                    }
                }
            }
        }
    }

    static class Point {
        int y;
        int x;
        int cnt;

        public Point(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
}
