package baekjoon.samsung;

import java.util.*;
import java.io.*;

public class G3_20057 {
    static int N;
    static int[][] arr;
    static int[][] dir = {{0,-1}, {1,0}, {0,1}, {-1,0}}; // 토네이도 방향 서,남,동,북
    static int[][][] sandDir = {
            // 서
            {{-1,1}, {1,1}, {-2,0}, {2,0}, {0,-2}, {-1,0}, {1,0}, {-1,-1}, {1,-1}, {0,-1}},
            // 남
            {{-1,-1}, {-1,1}, {0,-2}, {0,2}, {2,0}, {0,-1}, {0,1}, {1,-1}, {1,1}, {1,0}},
            // 동
            {{-1,-1}, {1,-1}, {-2,0}, {2,0}, {0,2}, {-1,0}, {1,0}, {-1,1}, {1,1}, {0,1}},
            // 북
            {{1,-1}, {1,1}, {0,-2}, {0,2}, {-2,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {-1,0}}

    };
    static int[] percent = {1, 1, 2, 2, 5, 7, 7, 10, 10};
    public static void main(String[] args) throws IOException {
        input();
        int ans = move();
        System.out.println(ans);
    }

    public static int move() {
        int x = N/2;
        int y = N/2;
        int d = 0;
        int len = 1;
        int ans = 0;
        // 두번 회전하면 길이 바뀐다.
        int rotation = 0;
        while(true) {
            for(int i = 0; i < len; i++) {
                x += dir[d][0];
                y += dir[d][1];
                ans += tornado(x, y, d);
                if(x == 0 && y == 0) break;
            }

            if(x == 0 && y == 0) break;

            // 회전
            d = (d+1) % 4;
            rotation++;
            if(rotation%2 == 0) {
                len++;
            }

        }
        return ans;
    }

    public static int tornado(int x, int y, int d) {
        int outSand = 0;
        int sand = arr[x][y];
        for(int i = 0; i < 9; i++) {
            int tx = x + sandDir[d][i][0];
            int ty = y + sandDir[d][i][1];
            if(isOutOfBound(tx, ty)) {
                outSand += arr[x][y] * percent[i] / 100;
            } else {
                arr[tx][ty] += arr[x][y] * percent[i] / 100;
            }
            sand -= arr[x][y] * percent[i] / 100;
        }
        int tx = x + sandDir[d][9][0];
        int ty = y + sandDir[d][9][1];
        if(isOutOfBound(tx, ty)) {
            outSand += sand;
        } else {
            arr[tx][ty] += sand;
        }
        arr[x][y] = 0;
        return outSand;
    }

    public static boolean isOutOfBound(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N) {
            return true;
        }
        return false;
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}