package BAEKJOON_Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BFS_16234 {
    static int N;
    static int L;
    static int R;
    static int[][] country;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        country = new int[N][N];
        L = scanner.nextInt();
        R = scanner.nextInt();
        int day = 0;
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <N; j++) {
                country[i][j] = scanner.nextInt();
            }
        }
        while(true) {
            int count = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if(bfs(i, j)!=1) {
                            count++;
                        }
                    }
                }
            }
            if(count == 0) {
                break;
            }
            else {
                day++;
            }
        }
        System.out.println(day);
    }

    public static int bfs(int y, int x) {
        Queue<Point> queue = new LinkedList<>();
        Stack<Point> stack = new Stack<>();
        queue.add(new Point(y, x));
        visited[y][x] = true;
        int sum = 0;
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            sum += country[current.y][current.x];
            stack.add(current);
            for (int i = 0; i <4; i++) {
                int ty = current.y + dy[i];
                int tx = current.x + dx[i];
                if(ty<0 || tx<0 || ty>=N || tx>=N) continue;
                int tmp = Math.abs(country[current.y][current.x] - country[ty][tx]);
                if(!visited[ty][tx] && tmp>=L && tmp<=R) {
                    queue.add(new Point(ty, tx));
                    visited[ty][tx] = true;
                }
            }
        }
        int answer = stack.size();
        int average = sum / stack.size();
        while(!stack.isEmpty()) {
            Point current = stack.pop();
            country[current.y][current.x] = average;
        }
        return answer;
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
