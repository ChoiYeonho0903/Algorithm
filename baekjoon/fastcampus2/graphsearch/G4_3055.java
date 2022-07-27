package baekjoon.fastcampus2.graphsearch;

import java.util.*;
import java.io.*;

public class G4_3055 {
    static int R;
    static int C;
    static String[][] arr;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    static Queue<Integer> waterQueue = new LinkedList<>();
    static boolean[][] waterVisited;
    static int[][] waterCnt;

    static Queue<Integer> queue = new LinkedList<>();
    static boolean[][] visited;
    static int[][] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int r = 0;
        int c = 0;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[R][C];
        visited = new boolean[R][C];
        cnt = new int[R][C];
        waterVisited = new boolean[R][C];
        waterCnt = new int[R][C];

        for(int i = 0; i < R; i++) {
            str = br.readLine();
            for(int j = 0; j < C; j++) {
                arr[i][j] = str.substring(j, j+1);
                if(arr[i][j].equals("S")) {
                    queue.add(i);
                    queue.add(j);
                    visited[i][j] = true;
                }
                if(arr[i][j].equals("*")) {
                    waterQueue.add(i);
                    waterQueue.add(j);
                    waterVisited[i][j] = true;
                }
                if(arr[i][j].equals("D")) {
                    r = i;
                    c = j;
                }
            }
        }

        waterBfs();
        bfs();
        if(!visited[r][c]) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(cnt[r][c]);
        }
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            int y = queue.poll();
            int x = queue.poll();
            for(int i = 0; i < 4; i++) {
                int ty = y + dy[i];
                int tx = x + dx[i];
                if(ty < 0 || tx < 0 || ty >= R || tx >= C) continue;
                if(waterCnt[ty][tx] != 0 && cnt[y][x]+1 >= waterCnt[ty][tx]) continue;
                if(visited[ty][tx]) continue;
                if(arr[ty][tx].equals(".") || arr[ty][tx].equals("D")) {
                    queue.add(ty);
                    queue.add(tx);
                    visited[ty][tx] = true;
                    cnt[ty][tx] = cnt[y][x] + 1;
                }
            }
        }
    }

    static void waterBfs() {
        while(!waterQueue.isEmpty()) {
            int y = waterQueue.poll();
            int x = waterQueue.poll();
            for(int i = 0; i < 4; i++) {
                int ty = y + dy[i];
                int tx = x + dx[i];
                if(ty < 0 || tx < 0 || ty >= R || tx >= C) continue;
                if(arr[ty][tx].equals(".") && !waterVisited[ty][tx]) {
                    waterQueue.add(ty);
                    waterQueue.add(tx);
                    waterVisited[ty][tx] = true;
                    waterCnt[ty][tx] = waterCnt[y][x] + 1;
                }
            }
        }
    }
}
