package baekjoon.etc.graph_search;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS_1707 {
    static int V;
    static int E;
    static ArrayList<Integer> [] arrayLists = new ArrayList[20001];
    static int [] visited;
    static String [] str;
    static boolean temp;
    public static void dfs(int x) {
        for (int i = 0; i <arrayLists[x].size(); i++) {
            int tmp = arrayLists[x].get(i);
            if(visited[tmp]==0) {
                if(visited[x]==1) {
                    visited[tmp] = 2;
                    dfs(tmp);
                }
                else if(visited[x]==2) {
                    visited[tmp] = 1;
                    dfs(tmp);
                }
            }
            else {
                if(visited[x] == visited[tmp]) {
                    temp = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        str = new String[K];
        for (int i = 0; i <K; i++) {
            V = scanner.nextInt();
            E = scanner.nextInt();
            for (int j = 1; j <=V; j++) {
                arrayLists[j] = new ArrayList<>();
            }
            visited = new int[V+1];
            temp = true;
            for (int j = 0; j <E; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                arrayLists[x].add(y);
                arrayLists[y].add(x);
            }
            for (int j = 1; j <=V; j++) {
                if(visited[j]==0) {
                    visited[j]=1;
                    dfs(j);
                }
            }
            if(temp)
                str[i] = "YES";
            else
                str[i] = "NO";
        }
        for (int i = 0; i <K; i++) {
            System.out.println(str[i]);
        }
    }
}
