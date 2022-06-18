package baekjoon.tony.data_structure;

import java.util.*;
import java.io.*;

public class S3_10799 {
    static Stack<String> stack = new Stack<>();
    static int ans = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean tf = false;
        for(int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i+1);
            switch (s) {
                case "(":
                    stack.add(s);
                    tf = false;
                    break;
                case ")":
                    stack.pop();
                    if(tf) {
                        ans++;
                    } else {
                        ans += stack.size();
                        tf = true;
                    }
                    break;
            }
        }
        System.out.println(ans);
    }
}
