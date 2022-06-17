package baekjoon.tony.data_structure;

import java.util.*;
import java.io.*;

public class S2_1874 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static Stack<Integer> stack = new Stack<>();
    static int[] sequence;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int num = 1;
        sequence = new int[n];

        for(int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < n; i++) {
            Integer tmp = sequence[i];
            while(num <= tmp) {
                stack.add(num++);
                sb.append("+").append("\n");
            }
            if(stack.peek().equals(tmp)) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                sb = new StringBuilder();
                sb.append("NO").append("\n");
                break;
            }
        }
        System.out.print(sb);
    }
}
