package baekjoon.fastcampus2.tree;

import java.util.*;
import java.io.*;

public class S1_15900 {
    static int N;
    static ArrayList<Integer>[] tree;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }

        dfs(1, -1, 0);
        if(ans % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    static void dfs(int x, int parent, int depth) {
        if(tree[x].size() == 1) {
            ans += depth;
        }

        for(int i = 0; i < tree[x].size(); i++) {
            int y = tree[x].get(i);
            if(y != parent) {
                dfs(y, x, depth+1);
            }
        }
    }
}
