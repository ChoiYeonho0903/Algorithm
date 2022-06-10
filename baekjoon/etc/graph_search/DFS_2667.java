package baekjoon.etc.graph_search;

import java.util.PriorityQueue;
import java.util.Scanner;

public class DFS_2667 {
    public static boolean [][] visited = new boolean[25][25];
    public static int [][] house = new int[25][25];
    public static int [] dx = {0, 0, -1, 1};
    public static int [] dy = {-1, 1, 0 ,0};
    public static int N;
    public static int count;
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i <dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >=0 && nx < N && ny < N) {
                if(house[nx][ny] == 1 && !visited[nx][ny]) {
                    count++;
                    dfs(nx, ny);
                }
            }
        }


    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        String str;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i <N; i++) {
            str = scanner.next();
            for (int j = 0; j <N; j++) {
                house[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <N; j++) {
                if(house[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    count++;
                    dfs(i,j);
                    priorityQueue.add(count);
                }
            }
        }
        int size = priorityQueue.size();
        System.out.println(size);
        for (int i = 0; i <size; i++) {
            System.out.println(priorityQueue.poll());
        }
    }
}
