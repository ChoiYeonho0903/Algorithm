package baekjoon.fastcampus2.tree;

import java.util.*;
import java.io.*;

public class S1_1991 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new int[N][2];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = st.nextToken().charAt(0) - 'A';
            String s = st.nextToken();
            int y;
            if(s.equals(".")) {
                y = -1;
            } else {
                y = s.charAt(0) - 'A';
            }
            s = st.nextToken();
            int z;
            if(s.equals(".")) {
                z = -1;
            } else {
                z = s.charAt(0) - 'A';
            }
            list[x][0] = y;
            list[x][1] = z;
        }

        preDfs(0);
        sb.append("\n");
        inDfs(0);
        sb.append("\n");
        postDfs(0);

        System.out.println(sb);
    }

    static void preDfs(int x) {
        if (x == -1) return;
        sb.append((char) (x+'A'));
        preDfs(list[x][0]);
        preDfs(list[x][1]);
    }

    static void inDfs(int x) {
        if (x == -1) return;
        inDfs(list[x][0]);
        sb.append((char) (x+'A'));
        inDfs(list[x][1]);
    }

    static void postDfs(int x) {
        if (x == -1) return;
        postDfs(list[x][0]);
        postDfs(list[x][1]);
        sb.append((char) (x+'A'));
    }
}