package BAEKJOON_Algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS_2644 {
    static int n;
    static ArrayList<Integer> [] arrayLists = new ArrayList[101];
    static ArrayList<Integer> villager = new ArrayList<>();
    static boolean [] visited;
    static int ans = 0;
    static int person1;
    static int person2;
    public static void dfs(int x) {
        if(x == person2) {
            ans = villager.size();
            return;
        }
        visited[x] = true;
        villager.add(x);

        for (int i = 0; i <arrayLists[x].size(); i++) {
            int tmp = arrayLists[x].get(i);
            if(!visited[tmp])
                dfs(tmp);
        }
        villager.remove(Integer.valueOf(x));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        person1 = scanner.nextInt();
        person2 = scanner.nextInt();
        int m = scanner.nextInt();
        visited = new boolean[n+1];
        for (int i = 0; i <=n; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0; i <m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arrayLists[x].add(y);
            arrayLists[y].add(x);
        }
        dfs(person1);
        if(ans == 0)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
}
