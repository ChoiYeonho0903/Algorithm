package baekjoon.fastcampus.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_3055 {
    static StringBuilder sb = new StringBuilder();
    static int R;
    static int C;
    static String[][] matrix;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static Queue<Point> waterQueue = new LinkedList<>();
    static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        matrix = new String[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i <R; i++) {
            str = br.readLine();
            for (int j = 0; j <C; j++) {
                matrix[i][j] = str.substring(j,j+1);
                if (matrix[i][j].equals("S")) {
                    queue.add(new Point(i, j, 0));
                    visited[i][j] = true;
                }
                if (matrix[i][j].equals("*")) {
                    waterQueue.add(new Point(i, j, 0));
                }
            }
        }
        bfs();
        if (sb.length()==0) sb.append("KAKTUS");
        System.out.println(sb);
    }

    static void bfs() {
        int totalTime = 0;
        while (!queue.isEmpty()) {
            totalTime++;
            while (!waterQueue.isEmpty()) {
                if (waterQueue.peek().time >=totalTime) break;
                Point point = waterQueue.poll();
                int x = point.x;
                int y = point.y;
                int time = point.time;
                for (int i = 0; i <4; i++) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];
                    if (nx<0 || ny<0 || nx>=R || ny>=C) continue;
                    if (matrix[nx][ny].equals(".") || matrix[nx][ny].equals("S")) {
                        waterQueue.add(new Point(nx, ny, time+1));
                        matrix[nx][ny] = "*";
                    }
                }
            }

            while (!queue.isEmpty()) {
                if (queue.peek().time >=totalTime) break;
                Point point = queue.poll();
                int x = point.x;
                int y = point.y;
                int time = point.time;
                if (matrix[x][y].equals("D")) {
                    sb.append(time);
                    queue.clear();
                    break;
                }

                for (int i = 0; i <4; i++) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];
                    if (nx<0 || ny<0 || nx>=R || ny>=C) continue;
                    if (visited[nx][ny]) continue;
                    if (matrix[nx][ny].equals(".") || matrix[nx][ny].equals("D")) {
                        queue.add(new Point(nx, ny, time+1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
