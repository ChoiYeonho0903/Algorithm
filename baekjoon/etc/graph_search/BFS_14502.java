package baekjoon.etc.graph_search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_14502 {
    static int N;
    static int M;
    static int [][] virus;
    static int [][] clone;
    static boolean [][] visited;
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};
    static int safety;
    static int max;

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        visited = new boolean[N][M];
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <M; j++) {
                if(clone[i][j] == 2) {
                    visited[i][j] = true;
                    queue.add(new Point(i,j));
                }
            }
        }

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i <4; i++) {
                int tdx = point.x + dx[i];
                int tdy = point.y + dy[i];
                if(tdx>=0 && tdy>=0 && tdx<M && tdy<N) {
                    if(!visited[tdy][tdx] && clone[tdy][tdx]==0) {
                        visited[tdy][tdx] = true;
                        queue.add(new Point(tdy,tdx));
                    }
                }
            }
        }

        safety = 0;
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <M; j++) {
                if(clone[i][j] == 0 && !visited[i][j])
                    safety++;
            }
        }

        if(max < safety)
            max = safety;
    }

    static void wall(int count) {
        if(count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i <N; i++) {
            for (int j = 0; j <M; j++) {
                if(clone[i][j] == 0) {
                    clone[i][j] = 1;
                    wall(count + 1);
                    clone[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        virus = new int[N][M];
        clone = new int[N][M];
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <M; j++) {
                virus[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <M; j++) {
                clone[i][j] = virus[i][j];
            }
        }
        visited = new boolean[N][M];
        wall(0);

        System.out.println(max);
    }

    private static class Point {
        int x;
        int y;

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
