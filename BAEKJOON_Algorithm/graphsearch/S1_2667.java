package BAEKJOON_Algorithm.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S1_2667 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] A;
    static boolean[][] visited;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int count;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i <N; i++) {
            String str = br.readLine();
            for (int j = 0; j <N; j++) {
                A[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <N; j++) {
                if (!visited[i][j] && A[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (Integer integer : list) {
            sb.append(integer).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs (int x, int y) {
        visited[x][y] = true;
        count++;
        for (int i = 0; i <dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx<0 || ny<0 || nx>=N || ny>=N) continue;
            if (visited[nx][ny] || A[nx][ny] == 0) continue;
            dfs(nx, ny);
        }
    }
}
