package baekjoon.etc.graph_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_1389 {
    static int N;
    static int M;
    static ArrayList<Integer> [] user;
    static int [] count;
    static int [] ans;
    static boolean [] visited;

    static void bfs(int x) {
        visited[x] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i <user[current].size(); i++) {
                int next = user[current].get(i);
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count[next] = count[current] + 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        user = new ArrayList[N+1];
        ans = new int[N+1];
        for (int i = 1; i <=N; i++) {
            user[i] = new ArrayList<>();
        }
        for (int i = 0; i <M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            user[x].add(y);
            user[y].add(x);
        }
        for (int i = 1; i <=N; i++) {
            visited = new boolean[N+1];
            count = new int[N+1];
            bfs(i);
            for (int j = 1; j <=N; j++) {
                ans[i] += count[j];
            }
        }

        int min = ans[1];
        int number = 1;
        for (int i = 2; i <=N; i++) {
            if(min > ans[i]) {
                min = ans[i];
                number = i;
            }
        }
        System.out.println(number);
    }
}
