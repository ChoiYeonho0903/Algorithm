package BAEKJOON_Algorithm;

import java.util.Scanner;

public class DFS_2573 {
    static int N;
    static int M;
    static int [][] height;
    static boolean [][] visited;
    static int [] dx = {0,0,1,-1};
    static int [] dy = {1,-1,0,0};
    public static void dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i <4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(!visited[ny][nx] && height[ny][nx]>0) {
                dfs(ny, nx);
            }
        }
    }
    public static void melt() {
        int count;
        int [][] tmp = new int[N][M];
        for (int i = 1; i <N-1; i++) {
            for (int j = 1; j <M-1; j++) {
                count = 0;
                for (int k = 0; k <4; k++) {
                    if (height[i+dy[k]][j+dx[k]] == 0)
                        count++;
                }
                if(height[i][j] - count <=0)
                    tmp[i][j] = 0;
                else
                    tmp[i][j] = height[i][j] - count;
            }
        }
        for (int i = 1; i <N-1; i++) {
            for (int j = 0; j <M-1; j++) {
                height[i][j] = tmp[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        int count;
        int year = 0;
        height = new int[N][M];

        for (int i = 0; i <N; i++) {
            for (int j = 0; j <M; j++) {
                height[i][j] = scanner.nextInt();
            }
        }
        while(true) {
            year++;
            melt();

            visited = new boolean[N][M];
            count = 0;
            for (int i = 1; i <N-1; i++) {
                for (int j = 1; j <M-1; j++) {
                    if(!visited[i][j] && height[i][j]>0) {
                        count++;
                        dfs(i,j);
                    }
                }
            }
            if(count>=2)
                break;
            else if(count == 0)
                break;
        }
        if(count == 0)
            System.out.println(count);
        else
            System.out.println(year);
    }
}
