package BAEKJOON_Algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1_1991 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        lists = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = st.nextToken().charAt(0) - 'A';
            int y = st.nextToken().charAt(0) - 'A';
            int z = st.nextToken().charAt(0) - 'A';
            if (y >= 0) {
                lists[x].add(y);
            } else {
                lists[x].add(-1);
            }
            if (z >= 0) {
                lists[x].add(z);
            } else {
                lists[x].add(-1);
            }
        }
        preDfs(0);
        sb.append("\n");
        inDfs(0);
        sb.append("\n");
        postDfs(0);
        sb.append("\n");
        System.out.print(sb);
    }

    static void preDfs (int x) {
        char c = (char)(x + 'A');
        sb.append(c);

        for (int i = 0; i < lists[x].size(); i++) {
            int nx = lists[x].get(i);
            if (nx != -1) preDfs(nx);
        }
    }

    static void inDfs (int x) {

        for (int i = 0; i < lists[x].size(); i++) {
            if (i == 1) {
                char c = (char)(x + 'A');
                sb.append(c);
            }
            int nx = lists[x].get(i);
            if (nx != -1) inDfs(nx);
        }

    }

    static void postDfs (int x) {
        for (int i = 0; i < lists[x].size(); i++) {
            int nx = lists[x].get(i);
            if (nx != -1) postDfs(nx);
        }

        char c = (char)(x + 'A');
        sb.append(c);
    }
}
