package baekjoon.fastcampus2.tree;

import java.util.*;
import java.io.*;

public class G5_1068 {
    static int N;
    static int root;
    static int erase;
    static ArrayList<Integer>[] list;
    static int[] leafCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        leafCnt = new int[N];

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(x == -1) {
                root = i;
                continue;
            }
            list[x].add(i);
        }
        erase = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            if(list[i].contains(erase)) {
                list[i].remove(list[i].indexOf(erase));
            }
        }

        if(root != erase) {
            dfs(root);
        }

        System.out.println(leafCnt[root]);
    }

    static void dfs(int x) {
        if(list[x].size() == 0) {
            leafCnt[x] = 1;
            return;
        }

        for(int i = 0; i < list[x].size(); i++) {
            int child = list[x].get(i);
            dfs(child);
            leafCnt[x] += leafCnt[child];
        }
    }
}