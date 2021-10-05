package PROGRAMMERS_Algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_2 {
    static int[] priorities = {1, 1, 9, 1, 1, 1};
    static int location = 0;
    public static void main(String[] args) {
        System.out.println(solution(priorities, location));
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i <priorities.length; i++) {
            queue.add(new Pair(i, priorities[i]));
        }
        int count = 1;
        while(!queue.isEmpty()) {
            Pair t_pair = queue.poll();
            boolean tf = true;
            Iterator<Pair> iter = queue.iterator();
            while(iter.hasNext()) {
                if(iter.next().imp > t_pair.imp) {
                    tf = false;
                    break;
                }
            }
            if(tf == false) {
                queue.add(t_pair);
            }
            else if(t_pair.index == location){
                answer = count;
                break;
            }
            else {
                count++;
            }
        }
        return answer;
    }

    private static class Pair {
        int index;
        int imp;

        public Pair(int index, int imp) {
            this.index = index;
            this.imp = imp;
        }
    }
}


