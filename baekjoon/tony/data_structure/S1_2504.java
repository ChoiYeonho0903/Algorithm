package baekjoon.tony.data_structure;

import java.util.*;
import java.io.*;

public class S1_2504 {
    static Stack<String> stack = new Stack<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean tf = false;
        int ans = 0;
        int tmp = 1;
        for(int i = 0; i < str.length(); i++) {
            String st = str.substring(i, i+1);
            switch(st) {
                case "(":
                    stack.add("(");
                    tmp *= 2;
                    break;
                case ")":
                    if(!stack.isEmpty() && stack.peek().equals("(")) {
                        if(str.substring(i-1, i).equals("(")) {
                            ans += tmp;
                        }
                        stack.pop();
                        tmp /= 2;

                    } else {
                        tf = true;
                    }
                    break;
                case "[":
                    stack.add("[");
                    tmp *= 3;
                    break;
                case "]":
                    if(!stack.isEmpty() && stack.peek().equals("[")) {
                        if(str.substring(i-1, i).equals("[")) {
                            ans += tmp;
                        }
                        stack.pop();
                        tmp /= 3;
                    } else {
                        tf = true;
                    }
                    break;
                default:
                    break;
            }
        }
        if(!stack.isEmpty()) {
            tf = true;
        }
        if(tf) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}
