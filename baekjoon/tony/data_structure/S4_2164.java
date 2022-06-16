package baekjoon.tony.data_structure;

import java.io.*;
import java.util.*;

public class S4_2164 {
    static Queue<Integer> queue = new LinkedList();
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }
        while(true) {
            if(queue.size() == 1) {
                break;
            }
            queue.poll();
            Integer poll = queue.poll();
            queue.add(poll);
        }
        System.out.print(queue.poll());
    }
}
