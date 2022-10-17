package baekjoon.samsung;

import java.io.*;
import java.util.*;

public class G4_20056 {
    static int N;
    static int M;
    static int K;
    static Grid[][] grids;

    static int[][] dir = {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
    public static void main(String[] args) throws IOException {

        input();

        for(int i = 0; i < K; i++) {
            // 파이어볼 이동
            move();

            // 마법
            magic();
        }

        int ans = sumMass();
        System.out.println(ans);
    }

    public static int sumMass() {
        int sum = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(grids[i][j].fireBalls.size() != 0) {
                    for(FireBall fireBall : grids[i][j].fireBalls) {
                        sum += fireBall.m;
                    }
                }
            }
        }
        return sum;
    }

    public static void magic() {
        // 2개 이상의 파이어볼이 있는 칸 동작

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(grids[i][j].fireBalls.size() >= 2) {
                    int mass = 0;
                    int speed = 0;
                    boolean flag = true;
                    int tmp = grids[i][j].fireBalls.get(0).d % 2;
                    int size = grids[i][j].fireBalls.size();
                    for(FireBall fireBall : grids[i][j].fireBalls) {
                        mass += fireBall.m;
                        speed += fireBall.s;
                        if(fireBall.d % 2 != tmp) {
                            flag = false;
                        }
                    }

                    grids[i][j].fireBalls.clear();
                    mass /= 5;
                    if(mass == 0) continue;
                    speed /= size;
                    if(flag) {
                        for(int k = 0; k < 8; k++) {
                            if(k%2 == 0) {
                                grids[i][j].fireBalls.add(new FireBall(mass, speed, k));
                            }
                        }
                    } else {
                        for(int k = 0; k < 8; k++) {
                            if(k%2 == 1) {
                                grids[i][j].fireBalls.add(new FireBall(mass, speed, k));
                            }
                        }
                    }
                }
            }
        }
    }

    public static void move() {
        Grid[][] moveGrids = new Grid[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                moveGrids[i][j] = new Grid();
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(grids[i][j].fireBalls.size() != 0) {
                    for(FireBall fireBall : grids[i][j].fireBalls) {
                        int m = fireBall.m;
                        int s = fireBall.s;
                        int d = fireBall.d;
                        int x = i;
                        int y = j;
                        for(int k = 0; k < s; k++) {
                            x += dir[d][0];
                            y += dir[d][1];
                            if(x <= 0) {
                                x += N;
                            }
                            if(y <= 0) {
                                y += N;
                            }
                            if(x > N) {
                                x %= N;
                            }
                            if(y > N) {
                                y %= N;
                            }
                        }
                        moveGrids[x][y].fireBalls.add(new FireBall(m,s,d));
                    }
                }
            }
        }
        grids = moveGrids;
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grids = new Grid[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                grids[i][j] = new Grid();
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            grids[r][c].fireBalls.add(new FireBall(m, s, d));
        }
    }

    public static class Grid {
        ArrayList<FireBall> fireBalls = new ArrayList<>();
    }

    public static class FireBall {
        int m;
        int s;
        int d;

        public FireBall(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}