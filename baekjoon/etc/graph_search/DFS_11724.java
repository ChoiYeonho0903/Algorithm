package baekjoon.etc.graph_search;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS_11724 {
    static ArrayList<Integer> [] arrayLists = new ArrayList[10001];
    static boolean [] visited = new boolean[1001];

    static void dfs(int x) {
        visited[x] = true;
        for (int i = 0; i <arrayLists[x].size(); i++) {
            int tmp = arrayLists[x].get(i);
            if(!visited[tmp]) {
                dfs(tmp);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int count = 0;
        for (int i = 1; i <=N; i++) {
            arrayLists[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i <M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arrayLists[x].add(y);
            arrayLists[y].add(x);
        }

        for (int i = 1; i <=N; i++) {
            if(!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }
}
