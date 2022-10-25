package baekjoon.tony.tree;

import java.io.*;
import java.util.*;

public class S1_9934 {
    static StringBuilder sb = new StringBuilder();
    static int K;
    static int[] list;
    static ArrayList<Integer>[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        int size = (int) Math.pow(2, K);
        list = new int[size];
        ans = new ArrayList[K];
        for(int i = 0; i < K; i++) {
            ans[i] = new ArrayList<>();
        }

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i < size; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        recursion(1, list.length-1, 0);

        for(int i = 0; i < ans.length; i++) {
            for(int j = 0; j < ans[i].size(); j++) {
                sb.append(ans[i].get(j)).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void recursion(int start, int end, int depth) {
        if(depth == K) {
            return;
        }

        int root = (start + end) / 2;
        ans[depth].add(list[root]);

        recursion(start, root-1, depth+1);
        recursion(root+1, end, depth+1);

    }
}
