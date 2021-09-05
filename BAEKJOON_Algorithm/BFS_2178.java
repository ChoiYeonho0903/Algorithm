package BAEKJOON_Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_2178 {
    static int N;
    static int M;
    static int [][] distance;
    static int [][] count;
    static boolean [][] visited;
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};

    public static void bfs(int y, int x) {
        visited[y][x] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(y,x));
        count[y][x] = 1;

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i <4; i++) {
                int tdx = point.x + dx[i];
                int tdy = point.y + dy[i];
                if (tdx>=0 && tdy>=0 && tdx<M && tdy<N) {
                    if(!visited[tdy][tdx] && distance[tdy][tdx]==1) {
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
        N = scanner.nextInt();
        M = scanner.nextInt();
        distance = new int[N][M];
        visited = new boolean[N][M];
        count = new int[N][M];
        for (int i = 0; i <N; i++) {
            String str = scanner.next();
            for (int j = 0; j <M; j++) {
                distance[i][j] = str.charAt(j) - '0';
            }
        }
        bfs(0,0);
        System.out.println(count[N-1][M-1]);
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
