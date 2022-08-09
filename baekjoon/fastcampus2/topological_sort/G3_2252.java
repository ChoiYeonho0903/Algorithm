package baekjoon.fastcampus2.topological_sort;

import java.util.*;
import java.io.*;

public class G3_2252 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] inDegree;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N+1];
        list = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            inDegree[y]++;
        }

        bfs();

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(" ");
            for(int y : list[x]) {
                inDegree[y]--;
                if(inDegree[y] == 0) {
                    queue.add(y);
                }
            }
        }
    }
}