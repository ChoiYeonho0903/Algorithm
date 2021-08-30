package BAEKJOON_Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_7569 {
    static int M;
    static int N;
    static int H;
    static int [][][] tomato;
    static int [][][] count;
    static boolean [][][] visited;
    static int [] dx = {0, 0, 1, -1, 0, 0};
    static int [] dy = {0, 0, 0, 0, 1, -1};
    static int [] dz = {1, -1, 0, 0, 0, 0};
    static Queue<Point> queue = new LinkedList<>();

    static void bfs() {
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i <6; i++) {
                int tdx = point.x + dx[i];
                int tdy = point.y + dy[i];
                int tdz = point.z + dz[i];
                if(tdx>=0 && tdy>=0 && tdz>=0 && tdx<M && tdy<N && tdz<H) {
                    if(!visited[tdz][tdy][tdx] && tomato[tdz][tdy][tdx] == 0) {
                        visited[tdz][tdy][tdx] = true;
                        queue.add(new Point(tdz, tdy, tdx));
                        count[tdz][tdy][tdx] = count[point.z][point.y][point.x] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        H = scanner.nextInt();
        tomato = new int[H][N][M];
        count = new int[H][N][M];
        visited = new boolean[H][N][M];
        for (int i = 0; i <H; i++) {
            for (int j = 0; j <N; j++) {
                for (int k = 0; k <M; k++) {
                    tomato[i][j][k] = scanner.nextInt();
                    if(tomato[i][j][k] == 1) {
                        visited[i][j][k] = true;
                        queue.add(new Point(i,j,k));
                    }
                }
            }
        }
        bfs();
        int max = 0;
        int ans = 0;
        for (int i = 0; i <H; i++) {
            for (int j = 0; j <N; j++) {
                for (int k = 0; k <M; k++) {
                    if(tomato[i][j][k]==0 && count[i][j][k]==0) {
                        ans = -1;
                    }
                    else if (max < count[i][j][k])
                        max = count[i][j][k];
                }
            }
        }
        if(ans == -1)
            System.out.println(ans);
        else
            System.out.println(max);
    }

    private static class Point {
        int x;
        int y;
        int z;
        public Point(int z, int y, int x) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
