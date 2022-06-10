package baekjoon.etc.string;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class STRING_4949 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        while(true) {
            String str = scanner.nextLine();
            if(str.charAt(0) == '.') break;
            Stack<Character> stack = new Stack<>();
            Boolean isBalance = true;
            for (int i = 0; i <str.length(); i++) {
                if(str.charAt(i)=='(') {
                    stack.add(str.charAt(i));
                }
                else if(str.charAt(i)==')') {
                    if(stack.isEmpty() || stack.peek()!='(') {
                        isBalance = false;
                        break;
                    }
                    else {
                        stack.pop();
                    }

                }
                else if(str.charAt(i)=='[') {
                    stack.add(str.charAt(i));
                }
                else if(str.charAt(i)==']') {
                    if(stack.isEmpty() || stack.peek()!='[') {
                        isBalance = false;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
                else continue;
            }
            if(isBalance && stack.isEmpty())
                arrayList.add("yes");
            else
                arrayList.add("no");
        }
        for (int i = 0; i <arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
