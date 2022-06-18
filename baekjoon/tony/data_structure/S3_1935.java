package baekjoon.tony.data_structure;

import java.io.*;
import java.util.*;

public class S3_1935 {
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static int N;
    static double answer;
    static Stack<Double> stack = new Stack<>();
    static int[] num;

    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        String str = br.readLine();
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i+1);
            boolean tf = false;

            for(int j = 0; j < N; j++) {
                if(alphabet.substring(j, j+1).equals(s)) {
                    stack.add((double) (num[j]));
                    tf = true;
                    break;
                }
            }

            if(!tf) {
                Double pop1 = stack.pop();
                Double pop2 = stack.pop();
                switch (s) {
                    case "+":
                        stack.add(pop2+pop1);
                        break;
                    case "-":
                        stack.add(pop2-pop1);
                        break;
                    case "*":
                        stack.add(pop2*pop1);
                        break;
                    case "/":
                        stack.add(pop2/pop1);
                        break;
                }
            }
        }
        System.out.print(String.format("%.2f", stack.pop()));
    }
}
