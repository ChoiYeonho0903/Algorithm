package baekjoon.fastcampus2.topological_sort;

import java.util.*;
import java.io.*;

public class G3_1005 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int N;
    static int K;
    static int W;
    static int[] D;
    static ArrayList<Integer>[] list;
    static int[] inDegree;
    static int[] done;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            D = new int[N + 1];
            inDegree = new int[N + 1];
            done = new int[N + 1];
            list = new ArrayList[N + 1];
            for (int j = 1; j <= N; j++) {
                list[j] = new ArrayList<>();
            }

            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for (int j = 1; j <= N; j++) {
                D[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < K; j++) {
                str = br.readLine();
                st = new StringTokenizer(str, " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x].add(y);
                inDegree[y]++;
            }

            W = Integer.parseInt(br.readLine());
            bfs();
            sb.append(done[W]).append("\n");
        }

        System.out.print(sb);

    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
                done[i] = D[i];
            }
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int y : list[x]) {
                inDegree[y]--;
                if(inDegree[y] == 0) {
                    queue.add(y);
                }
                done[y] = Math.max(done[y], done[x] + D[y]);
            }
        }
    }
}
