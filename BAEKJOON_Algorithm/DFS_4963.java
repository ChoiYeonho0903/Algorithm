package BAEKJOON_Algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS_4963 {
    static int [][] map;
    static boolean [][] visited;
    static int w;
    static int h;
    static int [] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int [] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i <8; i++) {
            int tdx = x+dx[i];
            int tdy = y+dy[i];
            if(tdx>=0 && tdy>=0 && tdx<h && tdy<w) {
                if(!visited[tdx][tdy] && map[tdx][tdy] == 1) {
                    dfs(tdx, tdy);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> island_num = new ArrayList<>();
        int count = 0;
        while(true) {
            w = scanner.nextInt();
            h = scanner.nextInt();
            count = 0;
            if(w==0 && h==0)
                break;
            else {
                map = new int[h][w];
                visited = new boolean[h][w];
                for (int i = 0; i <h; i++) {
                    for (int j = 0; j <w; j++) {
                        map[i][j] = scanner.nextInt();
                    }
                }
                for (int i = 0; i <h; i++) {
                    for (int j = 0; j <w; j++) {
                        if(map[i][j] == 1 && !visited[i][j]) {
                            count ++;
                            dfs(i, j);
                        }
                    }
                }
            }
            island_num.add(count);
        }
        for (int i = 0; i <island_num.size(); i++) {
            System.out.println(island_num.get(i));
        }
    }
}