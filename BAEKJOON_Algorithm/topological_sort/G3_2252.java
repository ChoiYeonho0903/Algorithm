package BAEKJOON_Algorithm.topological_sort;

import java.io.*;
import java.util.*;

public class G3_2252 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static ArrayList<Integer>[] lists;
    static int[] inDeg;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        inDeg = new int[N+1];
        for(int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lists[x].add(y);
            inDeg[y]++;
        }
        for(int i = 1; i <= N; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(" ");
            for (int y : lists[x]) {
                inDeg[y]--;
                if(inDeg[y]==0) queue.add(y);
            }
        }
        System.out.println(sb);
    }
}
