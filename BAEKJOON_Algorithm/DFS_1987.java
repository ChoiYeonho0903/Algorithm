package BAEKJOON_Algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS_1987 {
    static char [][] board;
    static boolean [][] visited;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, 1, 0, -1};
    static int R;
    static int C;
    static int max = 0;
    static ArrayList<Character> arrayList = new ArrayList<>();
    static void dfs (int x, int y) {
        int count = 0;
        arrayList.add(board[x][y]);
        if(max < arrayList.size())
            max = arrayList.size();
        visited[x][y] = true;
        for (int i = 0; i <4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if(!visited[nx][ny]) {
                    count = 0;
                    for (int j = 0; j <arrayList.size(); j++) {
                        if(arrayList.get(j) != board[nx][ny])
                            count++;
                        else
                            break;
                    }
                    if(count==arrayList.size())
                        dfs(nx, ny);
                }
            }
        }
        arrayList.remove(Character.valueOf(board[x][y]));
        visited[x][y] = false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt();
        C = scanner.nextInt();
        board = new char[R][C];
        visited = new boolean[R][C];
        String str;
        for (int i = 0; i <R; i++) {
            str = scanner.next();
            for (int j = 0; j <C; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        dfs(0, 0);

        System.out.println(max);
    }
}
