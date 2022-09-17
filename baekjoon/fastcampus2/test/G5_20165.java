package baekjoon.fastcampus2.test;

import java.util.*;
import java.io.*;

public class G5_20165 {
    static StringBuilder sb = new StringBuilder();
    static int score;
    static int N;
    static int M;
    static int R;

    static int[][] length;
    static int[][] backUp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        length = new int[N+1][M+1];
        backUp = new int[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 1; j <= M; j++) {
                length[i][j] = Integer.parseInt(st.nextToken());
                backUp[i][j] = length[i][j];
            }
        }

        for(int i = 0; i < R; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int aY = Integer.parseInt(st.nextToken());
            int aX = Integer.parseInt(st.nextToken());
            String aD = st.nextToken();
            attack(aY, aX, aD);
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int dY = Integer.parseInt(st.nextToken());
            int dX = Integer.parseInt(st.nextToken());
            defence(dY, dX);
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(length[i][j] == 0) {
                    sb.append("F").append(" ");
                } else {
                    sb.append("S").append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(score);
        System.out.print(sb);
    }

    static void attack(int y, int x, String aD) {
        if(length[y][x] == 0) {
            return;
        }
        int dx = 0, dy = 0;
        switch (aD) {
            case "E":
                dx = 1;
                break;
            case "W":
                dx = -1;
                break;
            case "S":
                dy = 1;
                break;
            case "N":
                dy = -1;
                break;
        }

        int cnt = length[y][x];
        while(y >= 1 && x >= 1 && y <= N && x <= M && cnt >= 1) {
            if (length[y][x] > 0) {
                score++;
            }

            cnt = Math.max(cnt-1, length[y][x]-1);
            length[y][x] = 0;

            y += dy;
            x += dx;
        }
    }

    static void defence(int aY, int aX) {
        length[aY][aX] = backUp[aY][aX];
    }
}