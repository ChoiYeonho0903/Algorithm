package PROGRAMMERS_Algorithm;

import java.util.*;

public class Stack_1 {
    static int[] progresses = {95, 90, 99, 99, 80, 99};
    static int[] speeds = {1, 1, 1, 1, 1, 1};
    public static void main(String[] args) {
        int[] answer = solution(progresses, speeds);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <progresses.length; i++) {
            int days = 0;
            int tmp = progresses[i];
            while(true) {
                days++;
                tmp += speeds[i];
                if(tmp>=100)
                    break;
            }
            queue.add(days);
        }
        int ttmp = queue.poll();
        int count = 1;
        while(!queue.isEmpty()) {
            if(ttmp >= queue.peek()) {
                queue.poll();
                count++;
            }
            else {
                list.add(count);
                ttmp = queue.poll();
                count = 1;
            }
        }
        list.add(count);

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
