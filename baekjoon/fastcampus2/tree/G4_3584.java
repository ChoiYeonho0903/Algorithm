package baekjoon.fastcampus2.tree;

import java.io.*;
import java.util.*;

public class G4_3584 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int N;
    static ArrayList<Integer>[] tree;
    static ArrayList<Integer>[] parent;
    static ArrayList<Integer> listA;
    static ArrayList<Integer> listB;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            tree = new ArrayList[N+1];
            parent = new ArrayList[N+1];
            listA = new ArrayList<>();
            listB = new ArrayList<>();

            for(int j = 1; j <= N; j++) {
                tree[j] = new ArrayList<>();
                parent[j] = new ArrayList<>();
            }
            for(int j = 1; j < N; j++) {
                String str = br.readLine();
                st = new StringTokenizer(str, " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                tree[x].add(y);
                parent[y].add(x);
            }

            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            dfs(A, listA);
            dfs(B, listB);

            for(int j = 0; j < listA.size(); j++) {
                int x = listA.get(j);
                if(listB.contains(x)) {
                    sb.append(x).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }

    static void dfs(int x, ArrayList<Integer> list) {
        list.add(x);
        if(parent[x].size() > 0) {
            dfs(parent[x].get(0), list);
        }

    }
}
