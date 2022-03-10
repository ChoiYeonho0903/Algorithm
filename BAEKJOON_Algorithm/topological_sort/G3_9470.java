package BAEKJOON_Algorithm.topological_sort;

import java.util.*;
import java.io.*;

public class G3_9470 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int K;
    static int M;
    static int P;
    static ArrayList<Integer>[] lists;
    static int[] inDeg;
    static int[] order;
    static int[] count;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            queue = new LinkedList<>();
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            lists = new ArrayList[M+1];
            for(int i = 1; i <= M; i++) {
                lists[i] = new ArrayList<>();
            }
            inDeg = new int[M+1];
            order = new int[M+1];
            count = new int[M+1];
            for(int i = 0; i < P; i++) {
                str = br.readLine();
                st = new StringTokenizer(str, " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                lists[x].add(y);
                inDeg[y]++;
            }
            for(int i = 1; i <= M; i++) {
                if (inDeg[i] == 0) {
                    queue.add(i);
                    order[i] = 1;
                    count[i] = 1;
                }
            }
            int ans = 0;
            while(!queue.isEmpty()) {
                int x = queue.poll();
                if(count[x] >= 2) order[x]++;
                ans = Math.max(ans, order[x]);
                for(int y :  lists[x]) {
                    inDeg[y]--;
                    if(inDeg[y]==0) {
                        queue.add(y);
                    }

                    if(order[y] == order[x]) {
                        count[y]++;
                    } else if(order[y] < order[x]) {
                        order[y] = order[x];
                        count[y] = 1;
                    }
                }
            }
            sb.append(K).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
