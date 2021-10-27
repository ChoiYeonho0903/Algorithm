package PROGRAMMERS_Algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Greedy_4 {
    static int[] people = {70, 50, 80, 50};
    static int limit = 100;
    public static void main(String[] args) {
        System.out.println(solution(people, limit));
    }
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int data : people) {
            deque.add(data);
        }
        while(!deque.isEmpty()) {
            int weight = deque.pollLast();
            if(!deque.isEmpty() && weight + deque.peekFirst() <= limit) {
                deque.pollFirst();
            }
            answer++;
        }
        return answer;
    }
}
