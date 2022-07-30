package baekjoon.fastcampus2.graphsearch;

import java.util.*;
import java.io.*;

public class S2_4963 {
    static StringBuilder sb = new StringBuilder();
    static int w;
    static int h;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            ans = 0;
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;
            arr = new int[h][w];
            visited = new boolean[h][w];

            for(int i = 0; i < h; i++) {
                str = br.readLine();
                st = new StringTokenizer(str, " ");
                for(int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(!visited[i][j] && arr[i][j] == 1) {
                        ans++;
                        bfs(i, j);
                    }
                }
            }
            sb.append(ans).append("\n");
        }


        System.out.print(sb);
    }

    static void bfs(int Y, int X) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Y);
        queue.add(X);
        visited[Y][X] = true;

        while(!queue.isEmpty()) {
            int y = queue.poll();
            int x = queue.poll();
            for(int i = 0; i < 8; i++) {
                int ty = y + dy[i];
                int tx = x + dx[i];
                if(ty < 0 || tx < 0 || ty >= h || tx >= w) continue;
                if(arr[ty][tx] == 1 && !visited[ty][tx]) {
                    queue.add(ty);
                    queue.add(tx);
                    visited[ty][tx] = true;
                }
            }
        }
    }

}
