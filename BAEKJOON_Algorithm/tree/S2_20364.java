package BAEKJOON_Algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S2_20364 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int Q;
    static boolean[] visited;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        visited = new boolean[N+1];
        for (int i = 0; i < Q; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            int land = 0;
            while (x > 1) {
                if (visited[x]) {
                    land = x;
                }
                x /= 2;
            }
            if (land == 0) {
                sb.append(0).append("\n");
                visited[list.get(i)] = true;
            } else {
                sb.append(land).append("\n");
            }
        }
        System.out.print(sb);
    }
}
