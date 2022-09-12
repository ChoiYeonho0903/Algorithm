package baekjoon.fastcampus2.tree;

import java.util.*;
import java.io.*;

public class G5_1240 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static ArrayList<Node>[] tree;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < N-1; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            tree[x].add(new Node(y, z));
            tree[y].add(new Node(x, z));
        }

        for(int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ans = 0;
            dfs(x, y, -1, 0);
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int x, int y, int parent, int sum) {
        if(x == y) {
            ans = sum;
            return;
        }

        for(int i = 0; i < tree[x].size(); i++) {
            Node node = tree[x].get(i);
            int z = node.node;
            int distance = node.distance;
            if(z == parent) continue;
            dfs(z, y, x, sum + distance);
        }

    }
    static class Node {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
