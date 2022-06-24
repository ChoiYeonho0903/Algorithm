package baekjoon.tony.tree;

import java.io.*;
import java.util.*;

public class S1_1991 {
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new int[N+1][3];
        visited = new boolean[N+1];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int index = st.nextToken().charAt(0) - 'A';
            list[index][1] = st.nextToken().charAt(0) - 'A';
            list[index][2] = st.nextToken().charAt(0) - 'A';
        }

        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);

        System.out.println(sb);
    }

    static void preOrder(int x) {
        sb.append((char)(x + 'A'));
        if((char)(list[x][1] + 'A') != '.') {
            preOrder(list[x][1]);
        }
        if((char)(list[x][2] + 'A') != '.') {
            preOrder(list[x][2]);
        }
    }

    static void inOrder(int x) {
        if((char)(list[x][1] + 'A') != '.') {
            inOrder(list[x][1]);
        }
        sb.append((char)(x + 'A'));
        if((char)(list[x][2] + 'A') != '.') {
            inOrder(list[x][2]);
        }
    }

    static void postOrder(int x) {
        if((char)(list[x][1] + 'A') != '.') {
            postOrder(list[x][1]);
        }
        if((char)(list[x][2] + 'A') != '.') {
            postOrder(list[x][2]);
        }
        sb.append((char)(x + 'A'));
    }
}
