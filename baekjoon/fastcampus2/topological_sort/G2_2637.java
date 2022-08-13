package baekjoon.fastcampus2.topological_sort;

import java.util.*;
import java.io.*;

public class G2_2637 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static ArrayList<Product>[] list;
    static int[] inDegree;
    static int[] outDegree;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        inDegree = new int[N+1];
        outDegree = new int[N+1];
        memo = new int[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            list[x].add(new Product(y, k));
            inDegree[x]++;
            outDegree[y]++;
        }

        memo[N] = 1;
        bfs(N);

        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                sb.append(i).append(" ").append(memo[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(Product p : list[x]) {
                memo[p.part] += memo[x] * p.cnt;
                outDegree[p.part]--;
                if(outDegree[p.part] == 0) {
                    queue.add(p.part);
                }
            }
        }
    }

    static class Product {
        int part;
        int cnt;

        public Product(int part, int cnt) {
            this.part = part;
            this.cnt = cnt;
        }
    }
}
