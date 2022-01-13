package BAEKJOON_Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SSW_13460 {
    static int N;
    static int M;
    static char[][] board;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][][][] visited;
    static Point red;
    static Point blue;
    static int target_x;
    static int target_y;
    static boolean redArrive;
    static boolean blueArrive;
    static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(red.rY, red.rX, blue.bY, blue.bX, 0));
        visited[red.rY][red.rX][blue.bY][blue.bX] = true;
        while(!queue.isEmpty()) {
            Point poll = queue.poll();
            int trY = poll.rY;
            int trX = poll.rX;

            int tbY = poll.bY;
            int tbX = poll.bX;
            int count = poll.count+1;
            if(count>10) {
                return -1;
            }
            for (int i = 0; i <4; i++) {
                int rY = trY;
                int rX = trX;
                int bY = tbY;
                int bX = tbX;
                redArrive = false;
                blueArrive = false;
                while(board[rY+dy[i]][rX+dx[i]]!='#') {
                    rX += dx[i];
                    rY += dy[i];
                    if(isArrive(rY, rX)) {
                        redArrive = true;
                        break;
                    }
                }
                while(board[bY+dy[i]][bX+dx[i]]!='#') {
                    bX += dx[i];
                    bY += dy[i];
                    if(isArrive(bY, bX)) {
                        blueArrive = true;
                        break;
                    }
                }
                if(blueArrive) {
                    continue;
                }
                else if(redArrive && !blueArrive) {
                    return count;
                }

                if(rX == bX && rY == bY) {
                    if(i==0) {
                        if(trX < tbX) rX--;
                        else bX--;
                    }
                    else if(i==1) {
                        if(trX < tbX) bX++;
                        else rX++;
                    }
                    else if (i==2) {
                        if(trY < tbY) rY--;
                        else bY--;
                    }
                    else  {
                        if(trY < tbY) bY++;
                        else rY++;
                    }
                }
                if(!visited[rY][rX][bY][bX]) {
                    visited[rY][rX][bY][bX] = true;
                    queue.add(new Point(rY, rX, bY, bX, count));
                }
            }
        }
        return -1;
    }
    static boolean isArrive(int y, int x) {
        if(y == target_y && x == target_x) {
            return true;
        }
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        board = new char[N][M];
        visited = new boolean[N][M][N][M];
        for (int i = 0; i <N; i++) {
            String str = scanner.next();
            for (int j = 0; j <M; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j]=='R') {
                    red = new Point(i, j, 0, 0, 0);
                }
                if(board[i][j]=='B') {
                    blue = new Point(0,0, i, j, 0);
                }
                if(board[i][j]=='O') {
                    target_x = j;
                    target_y = i;
                }
            }
        }
        int ans = bfs();
        System.out.println(ans);
    }

    private static class Point {
        int rY;
        int rX;
        int bY;
        int bX;
        int count;

        public Point(int rY, int rX, int bY, int bX, int count) {
            this.rY = rY;
            this.rX = rX;
            this.bY = bY;
            this.bX = bX;
            this.count = count;
        }
    }
}
