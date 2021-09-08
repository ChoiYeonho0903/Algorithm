package PROGRAMMERS_Algorithm;

import java.util.Scanner;
import java.util.Stack;

public class Conversion_kakao_2020 {
    static String p;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        p = scanner.next();
        System.out.println(solution(p));
    }

    public static String solution(String p) {
        String answer = conversion(p);
        return answer;
    }

    private static String conversion(String p) {
        String u;
        String v;
        String answer = "";

        if(p.equals("")) {
            return "";
        }
        else {
            Stack<Character> stack = new Stack<>();
            if(p.charAt(0) == '(') {
                stack.add(p.charAt(0));
                int i;
                for (i = 1; i <p.length(); i++) {
                    if(p.charAt(i) == '(') {
                        stack.add(p.charAt(i));
                    }
                    else if(p.charAt(i) == ')') {
                        stack.pop();
                    }
                    if(stack.isEmpty())
                        break;
                }
                u = p.substring(0, i+1);
                v = p.substring(i+1, p.length());
                return u + conversion(v);
            }
            else {
                stack.add(p.charAt(0));
                int i;
                for (i = 1; i <p.length(); i++) {
                    if(p.charAt(i) == ')') {
                        stack.add(p.charAt(i));
                    }
                    else if(p.charAt(i) == '(') {
                        stack.pop();
                    }
                    if(stack.isEmpty())
                        break;
                }
                u = p.substring(0, i+1);
                v = p.substring(i+1, p.length());
                answer += '(';
                answer += conversion(v);
                answer += ')';
                u = u.substring(1, u.length()-1);
                for (int j = 0; j <u.length(); j++) {
                    if(u.charAt(j) == ')') {
                        answer += '(';
                    }
                    else if(u.charAt(j) == '(') {
                        answer += ')';
                    }
                }
                return answer;
            }
        }
    }
}
