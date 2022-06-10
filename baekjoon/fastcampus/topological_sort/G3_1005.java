package baekjoon.fastcampus.topological_sort;

import java.io.*;
import java.util.*;

public class G3_1005 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int N;
    static int K;
    static int W;
    static int[] t;
    static int[] tDone;
    static ArrayList<Integer>[] lists;
    static int[] inDeg;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            Queue<Integer> queue = new LinkedList<>();
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            lists = new ArrayList[N+1];
            for(int j = 1; j <= N; j++) {
                lists[j] = new ArrayList<>();
            }
            t = new int[N+1];
            tDone = new int[N+1];
            inDeg = new int[N+1];
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 1; j <= N; j++) {
                t[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 0; j < K; j++) {
                str = br.readLine();
                st = new StringTokenizer(str, " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                lists[x].add(y);
                inDeg[y]++;
            }
            for(int j = 1; j <= N; j++) {
                if(inDeg[j] == 0) {
                    queue.add(j);
                    tDone[j] = t[j];
                }
            }

            while(!queue.isEmpty()) {
                int x = queue.poll();
                for(int y : lists[x]) {
                    inDeg[y]--;
                    if(inDeg[y]==0) queue.add(y);
                    tDone[y] = Math.max(tDone[y], tDone[x]+t[y]);
                }
            }
            W = Integer.parseInt(br.readLine());
            sb.append(tDone[W]).append("\n");
        }
        System.out.print(sb);
    }
}
