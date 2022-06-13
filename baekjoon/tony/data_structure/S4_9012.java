package baekjoon.tony.data_structure;

import java.util.*;
import java.io.*;

public class S4_9012 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static Stack<String> stack;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            stack = new Stack<>();
            String str = br.readLine();
            boolean tf = true;
            for(int j = 0; j < str.length(); j++) {
                String substring = str.substring(j, j + 1);
                if(substring.equals("(")) {
                    stack.add(substring);
                } else {
                    if(stack.size() == 0) {
                        tf = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.size() == 0 && tf) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
    }
}
