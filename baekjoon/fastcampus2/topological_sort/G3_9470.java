package baekjoon.fastcampus2.topological_sort;

import java.util.*;
import java.io.*;

public class G3_9470 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int K;
    static int M;
    static int P;
    static ArrayList<Integer>[] list;
    static int[] inDegree;
    static int[] order;
    static int[] maxCnt;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            ans = 0;
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            list = new ArrayList[M+1];
            inDegree = new int[M+1];
            order = new int[M+1];
            maxCnt = new int[M+1];
            for(int j = 1; j <= M; j++) {
                list[j] = new ArrayList<>();
            }
            for(int j = 0; j < P; j++) {
                str = br.readLine();
                st = new StringTokenizer(str, " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x].add(y);
                inDegree[y]++;
            }

            bfs();
            sb.append(K).append(" ").append(ans).append("\n");
        }

        System.out.print(sb);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= M; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
                order[i] = 1;
            }
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();
            if(maxCnt[x] >= 2) {
                order[x]++;
            }
            ans = Math.max(ans, order[x]);
            for(int y : list[x]) {
                inDegree[y]--;
                if(order[y] == order[x]) {
                    maxCnt[y]++;
                } else if(order[y] < order[x]) {
                    order[y] = order[x];
                    maxCnt[y] = 1;
                }
                if(inDegree[y] == 0) {
                    queue.add(y);
                }
            }
        }
    }
}