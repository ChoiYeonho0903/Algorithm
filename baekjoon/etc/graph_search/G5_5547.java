package baekjoon.etc.graph_search;

import java.io.*;
import java.util.*;

public class G5_5547 {
    static int W;
    static int H;
    static int[][] arr;
    static boolean[][] visited;
    static int[] edx = {0, 1, 0, -1, -1, -1};
    static int[] edy = {-1, 0, 1, 1, 0, -1};
    static int[] odx = {1, 1, 1, 0, -1, 0};
    static int[] ody = {-1, 0, 1, 1, 0, -1};
    static int ans = 0;
    static int count = 0 ;
    static boolean tf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H+2][W+2];
        visited = new boolean[H+2][W+2];

        for(int i = 1; i <= H; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 1; j <= W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= H; i++) {
            for(int j = 1; j <= W; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        for(int i = 1; i <= H; i++) {
            for(int j = 1; j <= W; j++) {
                if(arr[i][j] == 0 && !visited[i][j]) {
                    count = 0;
                    tf = false;
                    zeroDfs(i, j);
                    if(!tf) {
                        ans -= count;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;
        for(int i = 0; i < 6; i++) {
            int ty;
            int tx;
            if(y%2 == 0) {
                ty = y + edy[i];
                tx = x + edx[i];
            } else {
                ty = y + ody[i];
                tx = x + odx[i];
            }

            if(arr[ty][tx] == 0) {
                ans++;
            }
        }

        for(int i = 0; i < 6; i++) {
            int ty;
            int tx;
            if(y%2 == 0) {
                ty = y + edy[i];
                tx = x + edx[i];
            } else {
                ty = y + ody[i];
                tx = x + odx[i];
            }

            if(ty > H || tx > W || ty <= 0 || tx <= 0) continue;
            if(visited[ty][tx]) continue;
            if(arr[ty][tx] == 1) {
                dfs(ty, tx);
            }
        }
    }

    static void zeroDfs(int y, int x) {
        visited[y][x] = true;
        for(int i = 0; i < 6; i++) {
            int ty;
            int tx;
            if(y%2 == 0) {
                ty = y + edy[i];
                tx = x + edx[i];
            } else {
                ty = y + ody[i];
                tx = x + odx[i];
            }

            if(arr[ty][tx] == 1) {
                count++;
            }
        }

        for(int i = 0; i < 6; i++) {
            int ty;
            int tx;
            if(y%2 == 0) {
                ty = y + edy[i];
                tx = x + edx[i];
            } else {
                ty = y + ody[i];
                tx = x + odx[i];
            }

            if(ty > H || tx > W || ty <= 0 || tx <= 0) {
                tf = true;
                continue;
            }
            if(visited[ty][tx]) continue;
            if(arr[ty][tx] == 0) {
                zeroDfs(ty, tx);
            }
        }
    }
}
