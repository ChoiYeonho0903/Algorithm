package BAEKJOON_Algorithm.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_14502 {
    static int N;
    static int M;
    static int[][] A;
    static boolean[][] visited;
    static int safeZone;
    static int virus;
    static int minVirus = Integer.MAX_VALUE;
    static int wallNum;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for (int i = 0; i <N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for (int j = 0; j <M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j]==1) wallNum++;
            }
        }
        test(0);
        safeZone = (N*M) - (wallNum+3) - minVirus;
        System.out.println(safeZone);
    }

    static void test(int wall) {
        if (wall==3) {
            virus = 0;
            visited = new boolean[N][M];
            bfs();
            minVirus = Math.min(minVirus, virus);
        } else {
            for (int i = 0; i <N; i++) {
                for (int j = 0; j <M; j++) {
                    if (A[i][j] == 0) {
                        A[i][j] = 1;
                        test(wall+1);
                        A[i][j] = 0;
                    }
                }
            }
        }
    }
    static void bfs () {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <M; j++) {
                if (A[i][j]==2) {
                    queue.add(i);
                    queue.add(j);
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            virus++;
            for (int i = 0; i <dir.length; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if (visited[nx][ny]) continue;
                if (A[nx][ny]==0 || A[nx][ny] == 2) {
                    queue.add(nx);
                    queue.add(ny);
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
