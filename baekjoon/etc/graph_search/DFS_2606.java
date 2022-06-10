package baekjoon.etc.graph_search;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS_2606 {
    public static int computer;
    public static int num;
    public static ArrayList<Integer> [] network  = new ArrayList[101];
    public static boolean [] visited = new boolean[101];
    public static int count = 0;

    public static void dfs(int x) {
        visited[x] = true;
        for (int i = 0; i <network[x].size(); i++) {
            int tmp = network[x].get(i);
            if(!visited[tmp]) {
                count++;
                dfs(tmp);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        computer = scanner.nextInt();
        num = scanner.nextInt();
        for (int i = 1; i <=computer; i++) {
            network[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i <num; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            network[x].add(y);
            network[y].add(x);
        }

        dfs(1);

        System.out.println(count);
    }
}
