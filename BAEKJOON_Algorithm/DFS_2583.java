package BAEKJOON_Algorithm;

import java.util.PriorityQueue;
import java.util.Scanner;

public class DFS_2583 {
    static int M;
    static int N;
    static int [][] paper;
    static boolean [][] visited;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, 1, 0, -1};
    static int count = 0;
    static PriorityQueue<Integer> priorityQueue = new PriorityQueue();
    public static void dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i <4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<M) {
                if(paper[ny][nx]==0 && !visited[ny][nx]) {
                    count++;
                    dfs(ny, nx);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        int K = scanner.nextInt();
        paper = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i <K; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            for (int j = y1; j<y2 ; j++) {
                for (int k =x1; k<x2; k++) {
                    paper[j][k] = 1;
                }
            }
        }
        for (int i = 0; i <M; i++) {
            for (int j = 0; j <N; j++) {
                if(!visited[i][j] && paper[i][j]==0) {
                    count = 0;
                    count++;
                    dfs(i, j);
                    priorityQueue.add(count);
                }
            }
        }
        int size = priorityQueue.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.print(priorityQueue.poll() + " ");
        }
    }
}
