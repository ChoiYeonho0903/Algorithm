package baekjoon.fastcampus.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_1012 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int M;
    static int N;
    static int K;
    static int[][] A;
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i <T; i++) {
            String str = br.readLine();
            int ans = 0;
            st = new StringTokenizer(str, " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = new int[N][M];
            visited = new boolean[N][M];
            for (int j = 0; j <K; j++) {
                str = br.readLine();
                st = new StringTokenizer(str, " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                A[y][x] = 1;
            }

            for (int j = 0; j <N; j++) {
                for (int k = 0; k <M; k++) {
                    if (!visited[j][k] && A[j][k]==1) {
                        bfs(j, k);
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int tx = queue.poll();
            int ty = queue.poll();
            for (int i = 0; i <4; i++) {
                int nx = tx + dir[i][0];
                int ny = ty + dir[i][1];
                if (nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if (visited[nx][ny]) continue;
                if (A[nx][ny] == 1) {
                    queue.add(nx);
                    queue.add(ny);
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
