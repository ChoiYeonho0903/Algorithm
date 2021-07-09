package BAEKJOON_Algorithm;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy_1715 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int ans =0;
        int num1;
        int num2;
        for (int i = 0; i <N; i++) {
            priorityQueue.add(scan.nextInt());
        }
        while(true) {
            if(priorityQueue.size() >= 2) {
                num1 = priorityQueue.poll();
                num2 = priorityQueue.poll();
                ans += (num1+num2);
                priorityQueue.add(num1+num2);
            }
            else if (priorityQueue.size() == 1) {
                priorityQueue.poll();
                break;
            }
        }
        System.out.println(ans);
    }
}
