package baekjoon.etc.graph_search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_7576 {
    static int M;
    static int N;
    static int [][] tomato;
    static int [][] count;
    static boolean [][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};

    public static void bfs() {
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i <4; i++) {
                int tdx = point.x + dx[i];
                int tdy = point.y + dy[i];
                if (tdx>=0 && tdy>=0 && tdx<M && tdy<N) {
                    if(!visited[tdy][tdx] && tomato[tdy][tdx]==0) {
                        visited[tdy][tdx] = true;
                        queue.add(new Point(tdy, tdx));
                        count[tdy][tdx] = count[point.y][point.x] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        tomato = new int[N][M];
        visited = new boolean[N][M];
        count = new int[N][M];
        int max = 0;
        int ans = 0;
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <M; j++) {
                tomato[i][j] = scanner.nextInt();
                if(tomato[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(new Point(i,j));
                }
            }
        }
        bfs();

        for (int i = 0; i <N; i++) {
            for (int j = 0; j <M; j++) {
                if(tomato[i][j] == 0 && !visited[i][j])
                    ans = -1;
                else if(max < count[i][j])
                    max = count[i][j];
            }
        }
        if(ans!=-1)
            ans = max;
        System.out.println(ans);
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
