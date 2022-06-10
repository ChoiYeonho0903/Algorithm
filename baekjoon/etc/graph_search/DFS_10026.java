package baekjoon.etc.graph_search;

import java.util.Scanner;

public class DFS_10026 {
    static int N;
    static char [][] sector;
    static boolean [][] visited;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};

    public static void dfs(int y, int x, char c) {
        visited[y][x] = true;
        for (int i = 0; i <4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<N) {
                if(!visited[ny][nx] && sector[ny][nx]==c) {
                    dfs(ny, nx, c);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        sector = new char[N][N];
        visited = new boolean[N][N];
        String str;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i <N; i++) {
            str = scanner.next();
            for (int j = 0; j <N; j++) {
                sector[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <N; j++) {
                if(!visited[i][j]) {
                    count1++;
                    dfs(i, j, sector[i][j]);
                }
            }
        }
        visited = new boolean[N][N];
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <N; j++) {
                if(sector[i][j] == 'G')
                    sector[i][j] = 'R';
            }
        }
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <N; j++) {
                if(!visited[i][j]) {
                    count2++;
                    dfs(i, j, sector[i][j]);
                }
            }
        }
        System.out.println(count1 + " " + count2);
    }
}
