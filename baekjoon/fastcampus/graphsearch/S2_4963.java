package baekjoon.fastcampus.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_4963 {
    static StringBuilder sb = new StringBuilder();
    static int w;
    static int h;
    static int[][] A;
    static boolean[][] visited;
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}, {-1,1}, {1,1}, {1,-1}, {-1,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            int count = 0;
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;
            A = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                str = br.readLine();
                st = new StringTokenizer(str, " ");
                for (int j = 0; j < w; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && A[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs (int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int tx = queue.poll();
            int ty = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = tx + dir[i][0];
                int ny = ty + dir[i][1];
                if (nx<0 || ny<0 || nx>=h || ny>=w) continue;
                if (!visited[nx][ny] && A[nx][ny] == 1) {
                    queue.add(nx);
                    queue.add(ny);
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
