package BAEKJOON_Algorithm.topological_sort;

import java.util.*;
import java.io.*;

public class G2_2623 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static int[][] pd;
    static int[] inDeg;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N+1];
        visited = new boolean[N+1];
        inDeg = new int[N+1];
        pd = new int[M][];
        for(int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            pd[i] = new int[x];
            for(int j = 0; j < x; j++) {
                pd[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < pd.length; i++) {
            for(int j = 0; j < pd[i].length-1; j++) {
                int x = pd[i][j];
                int y = pd[i][j+1];
                lists[x].add(y);
                inDeg[y]++;
            }
        }
        for(int i = 1; i <= N; i++) {
            if(inDeg[i] == 0) {
                queue.add(i);
                visited[i] = true;
            }
        }
        while(!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append("\n");
            for(int i = 0; i < lists[x].size(); i++) {
                int y = lists[x].get(i);
                inDeg[y]--;
                if(inDeg[y] == 0) {
                    visited[y] = true;
                    queue.add(y);
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                sb = new StringBuilder("0");
            }
        }
        System.out.print(sb);
    }
}
