package BAEKJOON_Algorithm.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_3184 {
    static StringBuilder sb = new StringBuilder();
    static int R;
    static int C;
    static String[][] A;
    static boolean[][] visited;
    static int sheep;
    static int wolf;
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new String[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            str = br.readLine();
            for (int j = 0; j < C; j++) {
                A[i][j] = str.substring(j, j+1);
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j]) continue;
                if (A[i][j].equals(".") || A[i][j].equals("v") || A[i][j].equals("o")) {
                    bfs(i, j);
                }
            }
        }
        sb.append(sheep).append(" ").append(wolf);
        System.out.println(sb);
    }

    static void bfs (int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        visited[x][y] = true;
        int o = 0;
        int v = 0;
        while (!queue.isEmpty()) {
            int tx = queue.poll();
            int ty = queue.poll();
            if (A[tx][ty].equals("v")) v++;
            if (A[tx][ty].equals("o")) o++;

            for (int i = 0; i < 4; i++) {
                int nx = tx + dir[i][0];
                int ny = ty + dir[i][1];
                if (nx<0 || ny<0 || nx>=R || ny>=C) continue;
                if (visited[nx][ny]) continue;
                if (A[nx][ny].equals(".") || A[nx][ny].equals("v") || A[nx][ny].equals("o")) {
                    queue.add(nx);
                    queue.add(ny);
                    visited[nx][ny] = true;
                }
            }
        }
        if (v>=o) {
            wolf += v;
        } else {
            sheep += o;
        }
    }
}
