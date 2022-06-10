package baekjoon.etc.string;

import java.util.Scanner;
import java.util.Stack;

public class STRING_9012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String [] str = new String[T];
        String [] ans = new String[T];
        for (int i = 0; i < T; i++) {
            str[i] = scanner.next();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j <str[i].length(); j++) {
                if(str[i].charAt(j)==')') {
                    if(stack.isEmpty()) {
                        ans[i] = "NO";
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
                else if(str[i].charAt(j)=='(') {
                    stack.push('(');
                }
            }
            if(!stack.isEmpty()) {
                ans[i] = "NO";
            }
            else if(ans[i]==null) {
                ans[i] = "YES";
            }
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
