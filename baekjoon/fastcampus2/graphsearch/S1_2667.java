package baekjoon.fastcampus2.graphsearch;

import java.util.*;
import java.io.*;

public class S1_2667 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int homeCnt;
    static int groupCnt;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    groupCnt = 0;
                    dfs(i, j);
                    list.add(groupCnt);
                }
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(int i : list) {
            sb.append(i).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int y, int x) {
        groupCnt++;
        visited[y][x] = true;
        for(int i = 0 ; i < 4; i++) {
            int ty = y + dy[i];
            int tx = x + dx[i];
            if(ty < 0 || tx < 0 || ty >= N || tx >= N) {
                continue;
            }
            if(arr[ty][tx] == 1 && !visited[ty][tx]) {
                dfs(ty, tx);
            }
        }
    }
}
