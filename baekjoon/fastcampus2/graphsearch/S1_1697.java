package baekjoon.fastcampus2.graphsearch;

import java.io.*;
import java.util.*;

public class S1_1697 {
    static int N;
    static int K;
    static int[] arr = new int[100_001];
    static int[] cnt = new int[100_001];
    static boolean[] visited = new boolean[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);
        System.out.println(cnt[K]);
    }

    static void bfs (int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int x = queue.poll();

            if(x == K) {
                break;
            }

            int tx = x + 1;
            if(tx >= 0 && tx <= 100_000 && !visited[tx]) {
                queue.add(tx);
                visited[tx] = true;
                cnt[tx] = cnt[x] + 1;
            }

            tx = x - 1;
            if(tx >= 0 && tx <= 100_000 && !visited[tx]) {
                queue.add(tx);
                visited[tx] = true;
                cnt[tx] = cnt[x] + 1;
            }

            tx = x * 2;
            if(tx >= 0 && tx <= 100_000 && !visited[tx]) {
                queue.add(tx);
                visited[tx] = true;
                cnt[tx] = cnt[x] + 1;
            }
        }
    }
}