package baekjoon.fastcampus2.topological_sort;

import java.util.*;
import java.io.*;

public class G3_2623 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static ArrayList<Integer>[] list;
    static int[] inDegree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        inDegree = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int[] tmp = new int[x];
            for(int j = 0; j < x; j++) {
                int y = Integer.parseInt(st.nextToken());
                tmp[j] = y;
            }
            for(int j = 0; j < x-1; j++) {
                int y = tmp[j];
                int z = tmp[j+1];
                list[y].add(z);
                inDegree[z]++;
            }
        }

        bfs();
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                sb = new StringBuilder();
                sb.append(0).append("\n");
            }
        }
        System.out.print(sb);

    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
                visited[i] = true;
                sb.append(i).append("\n");
            }
        }
        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int y : list[x]) {
                inDegree[y]--;
                if(inDegree[y] == 0) {
                    queue.add(y);
                    visited[y] = true;
                    sb.append(y).append("\n");
                }
            }
        }
    }
}