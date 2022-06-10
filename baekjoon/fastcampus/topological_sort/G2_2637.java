package baekjoon.fastcampus.topological_sort;

import java.util.*;
import java.io.*;

public class G2_2637 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static ArrayList<Product>[] lists;
    static int[] inDeg;
    static int[] requiredNum;
    static Queue<Integer> queue = new LinkedList();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        lists = new ArrayList[N+1];
        inDeg = new int[N+1];
        requiredNum = new int[N+1];
        for(int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            lists[x].add(new Product(y, z));
            inDeg[y]++;
        }
        queue.add(N);
        requiredNum[N] = 1;
        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(Product p : lists[x]) {
                int y = p.product;
                int num = p.num;
                requiredNum[y] += (num*requiredNum[x]);
                inDeg[y]--;
                if(inDeg[y] == 0) {
                    queue.add(y);
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            if(lists[i].size() == 0) {
                sb.append(i).append(" ").append(requiredNum[i]).append("\n");
            }
        }
        System.out.print(sb);
    }
    static private class Product {
        int product;
        int num;

        public Product(int product, int num) {
            this.product = product;
            this.num = num;
        }
    }
}
