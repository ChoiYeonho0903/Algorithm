package baekjoon.etc.graph_search;

import java.util.Scanner;

public class DFS_2468 {
    static int [][] height;
    static boolean [][] visited;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, 1, 0, -1};
    static int N;
    static int max_height = 0;
    public static void dfs(int x, int y, int limit) {
        visited[x][y] = true;
        for (int i = 0; i <4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<N) {
                if(height[nx][ny]>limit && !visited[nx][ny]) {
                    dfs(nx, ny, limit);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        height = new int[N][N];

        int count = 0;
        int max_num = 0;
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <N; j++) {
                height[i][j] = scanner.nextInt();
                if(height[i][j] > max_height)
                    max_height = height[i][j];
            }
        }
        for (int i = 0; i <=max_height; i++) {
            count = 0;
            visited = new boolean[N][N];
            for (int j = 0; j <N; j++) {
                for (int k = 0; k <N; k++) {
                    if(height[j][k]>i && !visited[j][k]) {
                        count++;
                        dfs(j, k, i);
                    }
                }
            }
            if(max_num < count)
                max_num = count;
        }
        System.out.println(max_num);
    }
}
