package baekjoon.tony.data_structure_2;

import java.util.*;
import java.io.*;

public class S2_2075 {
    static PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < N; j++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i = 0; i < N-1; i++) {
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
