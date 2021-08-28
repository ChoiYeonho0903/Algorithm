package BAEKJOON_Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_1697 {
    static int N;
    static int M;
    static int [] count = new int[100001];
    static boolean [] visited = new boolean[100001];
    static void bfs() {
        visited[N] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            int next = current-1;
            if(next<=100000 && next>=0) {
                if(!visited[next]) {
                    visited[next] = true;
                    count[next] = count[current] +1;
                    queue.add(next);
                }
            }
            next = current+1;
            if(next<=100000 && next>=0) {
                if(!visited[next]) {
                    visited[next] = true;
                    count[next] = count[current] +1;
                    queue.add(next);
                }
            }
            next = current * 2;
            if(next<=100000 && next>=0) {
                if(!visited[next]) {
                    visited[next] = true;
                    count[next] = count[current] +1;
                    queue.add(next);
                }
            }

            if(visited[M]==true)
                break;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        bfs();
        System.out.println(count[M]);
    }
}
