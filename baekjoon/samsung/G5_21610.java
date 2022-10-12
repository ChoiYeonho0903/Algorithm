package baekjoon.samsung;

import java.util.*;
import java.io.*;

public class G5_21610 {
    static int N;
    static int M;
    static int[][] water;
    static boolean[][] cloud;
    static int[][] moveArr;

    static int[][] dir = {{0,0}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}};
    static int[][] magicDir = {{-1,-1}, {-1,1}, {1,1}, {1,-1}};

    public static void main(String[] args) throws IOException {
        input();
        // 초기 구름
        cloud[N][1] = true;
        cloud[N][2] = true;
        cloud[N-1][1] = true;
        cloud[N-1][2] = true;

        for(int i = 0; i < M; i++) {
            // 구름이동
            boolean[][] moveCloud = move(i);

            // 물복사버그 마법
            magic(moveCloud);

            // 구름 생성
            createCloud(moveCloud);


        }

        int ans = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                ans += water[i][j];
            }
        }
        System.out.println(ans);
    }

    public static boolean[][] move(int t) {
        // 모든 구름이 d 방향으로 s칸 이동한다.
        int d = moveArr[t][0];
        int s = moveArr[t][1];
        boolean[][] moveCloud = new boolean[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(cloud[i][j]) {
                    int tx = i + dir[d][0] * s;
                    int ty = j + dir[d][1] * s;
                    if(tx > N) {
                        tx %= N;
                    }
                    if(ty > N) {
                        ty %= N;
                    }
                    if(tx <= 0) {
                        while(tx <= 0) {
                            tx += N;
                        }
                    }
                    if(ty <= 0) {
                        while(ty <= 0) {
                            ty += N;
                        }
                    }
                    moveCloud[tx][ty] = true;

                    // 각 구름 위치에 저장된 물의 양 1증가
                    water[tx][ty] += 1;
                }
            }
        }
        return moveCloud;
    }

    public static void magic(boolean[][] moveCloud) {
        int[][] newWater = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                newWater[i][j] = water[i][j];
                if(moveCloud[i][j]) {
                    for(int k = 0; k < 4; k++) {
                        int tx = i + magicDir[k][0];
                        int ty = j + magicDir[k][1];
                        if(tx <= 0 || ty <= 0 || tx > N || ty > N) continue;
                        if(water[tx][ty] > 0) {
                            newWater[i][j]++;
                        }
                    }
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                water[i][j] = newWater[i][j];
            }
        }
    }

    public static void createCloud(boolean[][] moveCloud) {
        cloud = new boolean[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(moveCloud[i][j]) continue;
                if(water[i][j] >= 2) {
                    cloud[i][j] = true;
                    water[i][j] -= 2;
                }
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        water = new int[N+1][N+1];
        cloud = new boolean[N+1][N+1];
        moveArr = new int[M][2];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                water[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            moveArr[i][0] = Integer.parseInt(st.nextToken());
            moveArr[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}