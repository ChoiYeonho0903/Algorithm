package baekjoon.etc.greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy_1744 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> priorityQueue_pos = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> priorityQueue_neg = new PriorityQueue<>();
        int input;
        int num1;
        int num2;
        int ans=0;
        for (int i = 0; i <N; i++) {
            input = scanner.nextInt();
            if(input <=0)
                priorityQueue_neg.add(input);
            else if (input == 1)
                ans += input;
            else
                priorityQueue_pos.add(input);
        }
        while(true) {
            if(priorityQueue_pos.size() >=2) {
                num1 = priorityQueue_pos.poll();
                num2 = priorityQueue_pos.poll();
                ans += (num1*num2);
            }
            else if (priorityQueue_pos.size() == 1) {
                num1 = priorityQueue_pos.poll();
                ans += num1;
            }
            else
                break;
        }
        while(true) {
            if(priorityQueue_neg.size() >=2) {
                num1 = priorityQueue_neg.poll();
                num2 = priorityQueue_neg.poll();
                ans += (num1*num2);
            }
            else if (priorityQueue_neg.size() == 1) {
                num1 = priorityQueue_neg.poll();
                ans += num1;
            }
            else
                break;
        }
        System.out.println(ans);
    }
}
