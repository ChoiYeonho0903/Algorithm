package baekjoon.tony.data_structure;

import java.io.*;
import java.util.*;

public class S4_1158 {
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList();
    static int N;
    static int K;
    static boolean[] visited;
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sb.append("<");
        visited = new boolean[N+1];
        int index = 0;
        int count = 0;
        while(queue.size() < N) {
            while (true) {
                index++;
                if(index > N) {
                    index = 1;
                }
                if(!visited[index]) count++;
                if(count == K) {
                    queue.add(index);
                    visited[index] = true;
                    count = 0;
                    break;
                }
            }
        }
        while(true) {
            sb.append(queue.poll());
            if(queue.isEmpty()) {
                sb.append(">");
                break;
            }
            sb.append(", ");
        }
        System.out.print(sb);
    }
}
