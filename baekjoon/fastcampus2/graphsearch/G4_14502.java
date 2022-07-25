package baekjoon.fastcampus2.graphsearch;

import java.io.*;
import java.util.*;

public class G4_14502 {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] blank;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static boolean[][] visited;
    static int ans = 0;
    static int B = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        blank = new int[N*M+1][2];

        for(int i = 0; i < N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }

        dfs(1, 0);
        System.out.println(ans);
    }

    static void dfs(int idx, int cnt) {
        if(cnt == 3) {
            bfs();
            return;
        }
        if (idx > B) {
            return;
        }

        arr[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx + 1, cnt + 1);

        arr[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, cnt);

    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 2) {
                    visited[i][j] = true;
                    queue.add(i);
                    queue.add(j);
                }
            }
        }

        while(!queue.isEmpty()) {
            int y = queue.poll();
            int x = queue.poll();
            for(int i = 0; i < 4; i++) {
                int ty = y + dy[i];
                int tx = x + dx[i];
                if(ty < 0 || tx < 0 || ty >= N || tx >= M) {
                    continue;
                }
                if(arr[ty][tx] == 0 && !visited[ty][tx]) {
                    visited[ty][tx] = true;
                    queue.add(ty);
                    queue.add(tx);
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0 && !visited[i][j]) {
                    cnt++;
                }
            }
        }
        ans = Math.max(cnt, ans);
    }
}
