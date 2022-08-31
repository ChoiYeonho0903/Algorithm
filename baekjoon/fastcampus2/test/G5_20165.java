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
    static boolean[][] domino;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        length = new int[N+1][M+1];
        domino = new boolean[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 1; j <= M; j++) {
                length[i][j] = Integer.parseInt(st.nextToken());
                domino[i][j] = true;
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
                if(!domino[i][j]) {
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

    static void attack(int aY, int aX, String aD) {
        if(!domino[aY][aX]) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(aY);
        queue.add(aX);
        score++;
        switch (aD) {
            case "E":
                while(!queue.isEmpty()) {
                    int y = queue.poll();
                    int x = queue.poll();
                    domino[y][x] = false;
                    for(int i = 1; i <= length[y][x]-1; i++) {
                        if(x+i <= M && domino[y][x+i]) {
                            queue.add(y);
                            queue.add(x+i);
                            score++;
                        }
                    }
                }
                break;
            case "W":
                while(!queue.isEmpty()) {
                    int y = queue.poll();
                    int x = queue.poll();
                    domino[y][x] = false;
                    for(int i = 1; i <= length[y][x]-1; i++) {
                        if(x-i >= 1 && domino[y][x-i]) {
                            queue.add(y);
                            queue.add(x-i);
                            score++;
                        }
                    }
                }
                break;
            case "S":
                while(!queue.isEmpty()) {
                    int y = queue.poll();
                    int x = queue.poll();
                    domino[y][x] = false;
                    for(int i = 1; i <= length[y][x]-1; i++) {
                        if(y+i <= N && domino[y+i][x]) {
                            queue.add(y+i);
                            queue.add(x);
                            score++;
                        }
                    }
                }
                break;
            case "N":
                while(!queue.isEmpty()) {
                    int y = queue.poll();
                    int x = queue.poll();
                    domino[y][x] = false;
                    for(int i = 1; i <= length[y][x]-1; i++) {
                        if(y-i >= 1 && domino[y-i][x]) {
                            queue.add(y-i);
                            queue.add(x);
                            score++;
                        }
                    }
                }
                break;
        }
    }

    static void defence(int aY, int aX) {
        domino[aY][aX] = true;
    }
}