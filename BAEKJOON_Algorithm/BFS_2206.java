package BAEKJOON_Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_2206 {
    static int N;
    static int M;
    static int [][] wall;
    static int [][][] count;
    static boolean [][][] visited;
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};
    static int min = 1000000;

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        count = new int[N][M][2];
        visited = new boolean[N][M][2];
        visited[0][0][1] = true;
        count[0][0][1] = 1;
        queue.add(new Point(0,0, 1));
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i <4; i++) {
                int tdx = point.x + dx[i];
                int tdy = point.y + dy[i];

                if(tdx<0 || tdy<0 || tdx>=M || tdy>=N)
                    continue;

                //벽부시기 가능
                if(wall[tdy][tdx] == 1) {
                    if (!visited[tdy][tdx][point.wall] && point.wall == 1) {
                        visited[tdy][tdx][point.wall-1] = true;
                        queue.add(new Point(tdy, tdx, point.wall-1));
                        count[tdy][tdx][point.wall-1] = count[point.y][point.x][point.wall] + 1;
                    }
                }
                else {
                    if (!visited[tdy][tdx][point.wall]) {
                        visited[tdy][tdx][point.wall] = true;
                        queue.add(new Point(tdy, tdx, point.wall));
                        count[tdy][tdx][point.wall] = count[point.y][point.x][point.wall] + 1;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        wall = new int[N][M];
        for (int i = 0; i <N; i++) {
            String str = scanner.next();
            for (int j = 0; j <M; j++) {
                wall[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();
        if(!visited[N-1][M-1][1] && !visited[N-1][M-1][0])
            System.out.println(-1);
        else if(!visited[N-1][M-1][1] && visited[N-1][M-1][0])
            System.out.println(count[N - 1][M - 1][0]);
        else if(visited[N-1][M-1][1] && !visited[N-1][M-1][0])
            System.out.println(count[N - 1][M - 1][1]);
        else {
            if(count[N - 1][M - 1][1] > count[N - 1][M - 1][0])
                System.out.println(count[N - 1][M - 1][0]);
            else
                System.out.println(count[N - 1][M - 1][1]);
        }
    }

    private static class Point {
        int x;
        int y;
        int wall;

        public Point(int y, int x, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }
}
