package baekjoon.fastcampus2.graphsearch;

import java.io.*;
import java.util.*;

public class S2_1012 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int M;
    static int N;
    static int K;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int cnt = 0;
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            visited = new boolean[N][M];
            for(int j = 0; j < K; j++) {
                str = br.readLine();
                st = new StringTokenizer(str, " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr[Y][X] = 1;
            }

            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(!visited[j][k] && arr[j][k] == 1) {
                        cnt++;
                        bfs(j, k);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int y, int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(y);
        queue.add(x);
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            int Y = queue.poll();
            int X = queue.poll();
            for(int i = 0; i < 4; i++) {
                int ty = Y + dy[i];
                int tx = X + dx[i];
                if(ty < 0 || tx < 0 || ty >= N || tx >= M) continue;
                if(!visited[ty][tx] && arr[ty][tx] == 1) {
                    queue.add(ty);
                    queue.add(tx);
                    visited[ty][tx] = true;
                }
            }
        }
    }
}
