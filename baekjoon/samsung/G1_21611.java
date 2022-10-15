package baekjoon.samsung;

import java.util.*;
import java.io.*;

public class G1_21611 {
    static int N; // 격자 크기
    static int M; // 마법 횟수
    static int[][] dir = {{0,0}, {-1,0}, {1,0}, {0,-1}, {0,1}};
    static int[][] destroyOrder;
    static int[][] matrix;
    static int[][] marbleOrder;
    static int[] marble;
    static int[] ans = new int[4];
    public static void main(String[] args) throws IOException {

        input();
        transform();

        for(int i = 0; i < M; i++) {
            // 1.구슬 파괴
            destroy(i);

            // 2. 파괴된 후에 빈 칸으로 구슬 이동
            marble = move();

            // 3. 4개 이상의 연속하는 구슬 존재시 폭발 (없을때까지)
            explode();

            // 4. 구슬 변화 (생성)
            marble = produce();
        }

        int answer = 0;
        for(int i = 1; i <= 3; i++) {
            answer += ans[i] * i;
        }
        System.out.println(answer);
    }

    public static int[] produce() {
        int[] newMarble = new int[N*N+2];
        int cn = 2;
        int cnt = 1;
        int m = marble[2];
        for(int i = 3; i <= N*N; i++) {
            if (m == marble[i]) {
                cnt++;
            } else {
                newMarble[cn++] = cnt;
                if (cn > N * N) break;
                newMarble[cn++] = m;
                if (cn > N * N) break;
                cnt = 1;
                m = marble[i];
            }
        }
        return newMarble;
    }

    public static int[] move() {
        int[] sortMarble = new int[N*N+2];
        int cn = 2;
        for(int i = 2; i <= N*N; i++) {
            if(marble[i] != 0) {
                sortMarble[cn++] = marble[i];
            }
        }
        return sortMarble;
    }

    public static void explode() {
        // 4개 이상의 연속하는 구슬 존재시 폭발 (없을때까지)
        while(true) {
            boolean flag = false;
            int cnt = 0;
            int m = 0;
            for(int i = 2; i <= N*N + 1; i++) {
                if(m == marble[i] && m != 0) {
                    cnt++;
                } else {
                    if(cnt >= 4) {
                        ans[m] += cnt;
                        for(int j = i-1; j > i-1-cnt; j--) {
                            marble[j] = 0;
                        }
                        flag = true;
                    }
                    cnt = 1;
                    m = marble[i];
                }
            }
            if(flag) {
                marble = move();
            } else {
                break;
            }
        }
    }

    public static void destroy(int t) {
        int x = (N+1)/2;
        int y = (N+1)/2;
        int d = destroyOrder[t][0];
        int s = destroyOrder[t][1];
        for(int i = 0; i < s; i++) {
            x += dir[d][0];
            y += dir[d][1];
            int cn = marbleOrder[x][y];
            marble[cn] = 0;
        }
    }

    // 2차 배열을 1차배열로의 전환
    public static void transform() {
        marble = new int[N*N+2];
        marbleOrder = new int[N+1][N+1];
        int x = (N+1)/2;
        int y = (N+1)/2;
        int d = 3;
        int rotation = 0;
        int len = 1;
        int cn = 1;
        marbleOrder[x][y] = cn;
        marble[cn++] = matrix[x][y];

        while(true) {

            for(int i = 0; i < len; i++) {
                x += dir[d][0];
                y += dir[d][1];
                marbleOrder[x][y] = cn;
                marble[cn++] = matrix[x][y];
                if(x == 1 && y == 1) break;
            }

            if(x == 1 && y == 1) break;

            d = changeDir(d);
            if(++rotation % 2 == 0) {
                len++;
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N+1][N+1];
        destroyOrder = new int[M][2];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            destroyOrder[i][0] = Integer.parseInt(st.nextToken());
            destroyOrder[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    public static int changeDir(int d) {
        switch (d) {
            case 1:
                d = 3;
                break;
            case 2:
                d = 4;
                break;
            case 3:
                d = 2;
                break;
            case 4:
                d = 1;
                break;
            default:
                break;
        }
        return d;
    }
}