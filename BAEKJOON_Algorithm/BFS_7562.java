package BAEKJOON_Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_7562 {
    static int I;
    static int [][] chess;
    static int [][] count;
    static boolean [][] visited;
    static int [] ans;
    static int [] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int [] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    static void bfs(int y, int x, int ay, int ax) {
        visited[y][x] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(y,x));
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i <8; i++) {
                int tdx = point.x + dx[i];
                int tdy = point.y + dy[i];
                if (tdx>=0 && tdy>=0 && tdx<I && tdy<I) {
                    if(!visited[tdy][tdx]) {
                        visited[tdy][tdx] = true;
                        queue.add(new Point(tdy, tdx));
                        count[tdy][tdx] = count[point.y][point.x] + 1;
                    }
                }
            }
            if(visited[ay][ax])
                break;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testNum = scanner.nextInt();
        ans = new int[testNum];
        for (int i = 0; i <testNum; i++) {
            I = scanner.nextInt();
            count = new int[I][I];
            visited = new boolean[I][I];
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int ax = scanner.nextInt();
            int ay = scanner.nextInt();
            bfs(y,x,ay,ax);
            ans[i] = count[ay][ax];
        }
        for (int i = 0; i <testNum; i++) {
            System.out.println(ans[i]);
        }
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
