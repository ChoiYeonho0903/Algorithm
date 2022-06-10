package baekjoon.etc.greedy;

import java.util.*;

class Classtime implements Comparable<Classtime>{
    int S;
    int T;

    Classtime(int S, int T) {
        this.S = S;
        this.T = T;
    }

    @Override
    public int compareTo(Classtime o) {
        return S - o.S;
    }

}
public class Greedy_11000 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Classtime> classtime = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i <N; i++) {
            classtime.add(new Classtime(scanner.nextInt(), scanner.nextInt()));
        }
        Collections.sort(classtime);
        priorityQueue.add(classtime.get(0).T);
        for (int i = 1; i <N; i++) {
            if(priorityQueue.peek() <= classtime.get(i).S) {
                priorityQueue.remove();
                priorityQueue.add(classtime.get(i).T);
            }
            else
                priorityQueue.add(classtime.get(i).T);
        }
        System.out.println(priorityQueue.size());
    }
}
