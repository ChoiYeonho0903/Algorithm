package baekjoon.etc.graph_search;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS_11725 {
    static int N;
    static ArrayList<Integer> [] arrayLists = new ArrayList[100001];
    static boolean [] visited;
    static int [] parent;
    public static void dfs(int x) {
        visited[x] = true;
        for (int i = 0; i <arrayLists[x].size(); i++) {
            int tmp = arrayLists[x].get(i);
            if(!visited[tmp]) {
                parent[tmp]=x;
                dfs(tmp);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        visited = new boolean[N+1];
        parent = new int[N+1];
        for (int i = 1; i <=N; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0; i <N-1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arrayLists[x].add(y);
            arrayLists[y].add(x);
        }
        dfs(1);
        for (int i = 2; i <=N; i++) {
            System.out.println(parent[i]);
        }
    }
}
